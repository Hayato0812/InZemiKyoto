from setting import Setting
from main import Main
import numpy as np
import matplotlib.pyplot as plt
import pandas as pd
import os

results = []
updateNumAverages = []
updateAverages = []
for i in range(Setting.TIMES_OF_SIMULATING):
    main = Main()
    main.run()
    results.append(np.average(main.Alldata[-1]))
    averages = []



    for j in range(Setting.UPDATE_NUM):
        # np.average(main.Alldata[:, j])
        averages.append(round(np.average(main.Alldata[j]), 2))

    updateNumAverages.append(averages)
    print(str(i + 1) + "回まわし終わったよ")


updateAverages.append(np.mean(updateNumAverages, axis=0))



# 平均
av = np.mean(results)
# 分散
dp = np.var(results)
# 標準偏差
std = np.std(results)

print("平均→"+str(av))
print("分散→"+str(dp))
print("標準偏差→"+str(std))

print(results)
print("Updateごとの平均")
print(updateAverages)


# x = range(0,Setting.UPDATE_NUM)
# y = updateAverages
#
#
# print("長さ")
# print(x)
# print(len(updateAverages))
#
# plt.plot(x,y, label="main")
#
# plt.legend()
# plt.show()

os.chdir("data")
df = pd.DataFrame(updateAverages)
df.to_csv("updateAverages"+"Beta"+str(Setting.BETA)+"_Difference"+str(Setting.GROUP_DIFFERENCE)+"_Syuyakudo"+str(Setting.SYUYAKUDO)+"Result"+str(i)+".csv")





