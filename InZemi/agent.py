import random
from belief import Belief
from setting import Setting


class Agent:
    def __init__(self, agentId):
        self.connectedAgents = []
        self.beliefs = []
        self.agentId = agentId
        self.score = 0

        for num in range(0, Setting.GYOMU_NUM):
            self.beliefs.append(Belief())


    def connect(self, opponents,agentList):
        for id in opponents:
            self.connectedAgents.append(agentList[id])


    def learn(self):
        superiors = []

        for agent in self.connectedAgents:
            if agent.score > self.score:
                superiors.append(agent)

        if len(superiors) == 0:
            pass
        else:
            self.learnFromOtherAgent(self.findSuperiorAgent(superiors))



    def findSuperiorAgent(self,superiors):
        superiorAgent = Agent(0)
        for i in range(len(self.beliefs)):
            sum0 = 0
            sum1 = 0
            for j in range(len(superiors)):
                if superiors[j].beliefs[i].value == 0:
                    sum0 += 1
                else:
                    sum1 += 1
            if(sum0 < sum1):
                superiorAgent.beliefs[i].value = 1
            elif(sum1 < sum0):
                superiorAgent.beliefs[i].value = 0

        return superiorAgent

    def learnFromOtherAgent(self,agent):
        sum = 0
        for i in range(len(self.beliefs)):
            p = random.uniform(0, 100)

            if(self.beliefs[i] != agent.beliefs[i]):
                if(Setting.PERCENTAGE_OF_LEARNING >= p):
                    self.beliefs[i].value = agent.beliefs[i].value
                    sum += sum







