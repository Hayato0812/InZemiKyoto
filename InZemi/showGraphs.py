import matplotlib.pyplot as plt
from main import Main
from setting import Setting


# ここの下をいじる
Setting.BETA = 0.3
Setting.GROUP_DIFFERENCE = 60
Setting.SYUYAKUDO = 8



main1 = Main()
main1.run()

main1_x = range(0,Setting.UPDATE_NUM)
main1_y = main1.totalScores


# ここの下をいじる
Setting.BETA = 0.6
Setting.GROUP_DIFFERENCE = 60
Setting.SYUYAKUDO = 8

main2 = Main()
main2.run()

print(main2.totalScores)

main2_x = range(0,Setting.UPDATE_NUM)
main2_y = main2.totalScores

plt.plot(main1_x,main1_y, label="main1")
plt.plot(main2_x,main2_y, label="main2")
plt.legend()
plt.show()

