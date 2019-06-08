import networkx as nx
from agent import Agent
from agentGroup import AgentGroup
from setting import Setting
from metrics import Metrics
import pandas as pd
import os
import numpy as np




class Main:

    def __init__(self,):
        self.agentGroupList = []
        self.agentList = []
        self.baseMetrics = []


        #エージェントを全員作る
        for i in range(Setting.AGENT_NUM_IN_ONE_GROUP*Setting.AGENT_GROUP_NUM):
            self.agentList.append(Agent(i))

        #ベースとなる評価指標を作る
        for i in range(Setting.GYOMU_NUM - Setting.GROUP_DIFFERENCE):
            self.baseMetrics.append(Metrics())

        #評価指標が異なるエージェントグループを作る
        for i in range(Setting.AGENT_GROUP_NUM):
            self.agentGroupList.append(AgentGroup(i, self.baseMetrics))

        #エージェントグループにエージェントを入れる
        for agentGroup in self.agentGroupList:
            for i in range(Setting.AGENT_NUM_IN_ONE_GROUP):
                agentGroup.addAgent(self.agentList[i+agentGroup.id * Setting.AGENT_NUM_IN_ONE_GROUP])

        #ネットワークを作り、エージェントを繋げる
        self.G = nx.relaxed_caveman_graph(Setting.AGENT_GROUP_NUM,Setting.AGENT_NUM_IN_ONE_GROUP,Setting.BETA)
        relations = nx.to_dict_of_lists(self.G)
        for i in range(len(relations)):
            self.agentList[i].connect(relations[i], self.agentList)

        self.Alldata = []

    def run(self):
        self.totalScores = []
        for i in range(Setting.UPDATE_NUM):

            for agentGroup in self.agentGroupList:
                agentGroup.evaluateMyAgents()

            # self.Alldata.append([[self.agentList[num].score for num in range(len(self.agentList))]])
            self.Alldata.append([agent.score for agent in self.agentList])

            for agent in self.agentList:
                agent.learn()

            self.totalScores.append(np.average(self.Alldata[i]))


    def output(self,i):
        df = pd.DataFrame(self.Alldata)
        df.to_csv("Beta"+str(Setting.BETA)+"_Difference"+str(Setting.GROUP_DIFFERENCE)+"_Syuyakudo"+str(Setting.SYUYAKUDO)+"Result"+str(i)+".csv")


if __name__ == "__main__":
    # ディレクトリの移動
    os.chdir("data")

    # ここでシュミレーション回す
    for i in range(Setting.TIMES_OF_SIMULATING):
        main = Main()
        main.run()
        print(str(i + 1) + "回まわし終わったよ")
        main.output(i)





