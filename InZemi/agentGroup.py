from setting import Setting
from metrics import Metrics


class AgentGroup:
    def __init__(self, id, metrics):
        self.agents = []
        self.metrics = []

        self.id = id
        self.metrics.extend(metrics)

        for i in range(Setting.GROUP_DIFFERENCE):
            self.metrics.append(Metrics())

    def addAgent(self,agent):
        self.agents.append(agent)

    def evaluateMyAgents(self):
        for agent in self.agents:
           self.evaluate(agent)

    def evaluate(self,agent):
        score = 0
        for i in range(int(len(agent.beliefs)/Setting.SYUYAKUDO)):
            if self.isSame(agent,i):
                score += 1
        agent.score = score

    def isSame(self, agent,i):
        same = True
        for j in range(i*Setting.SYUYAKUDO,i*Setting.SYUYAKUDO+(Setting.SYUYAKUDO - 1)):
            if agent.beliefs[j].value != self.metrics[j].value:
                same = False
                break
        return same

