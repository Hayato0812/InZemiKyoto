import matplotlib.pyplot as plt
import networkx as nx
from main import Main

main = Main()

# レイアウトの取得
pos = nx.spring_layout(main.G)

# ネットワークの可視化
plt.figure(figsize=(6, 6))
nx.draw_networkx_edges(main.G, pos)
nx.draw_networkx_nodes(main.G, pos, node_size=10)
plt.axis('off')
plt.show()
