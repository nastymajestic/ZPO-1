import matplotlib.pyplot as plt
import numpy as np
import scipy.stats as stats

h = []
with open('C:/Users/Wika/Desktop/SEM5/ZPO/lab7/3_drugiestarcie/liczby.txt') as f:
    l = f.readline()
    while(l):
        h.append(float(l[:-1].replace(',','.')))
        l = f.readline()
h = sorted(h)
fit = stats.norm.pdf(h, np.mean(h), np.std(h))
plt.plot(h,fit)
plt.show()