#Ej No.8

import datetime

days = ['L', 'M', 'Mi', 'J', 'V', 'S', 'D']

d = datetime.date.today().weekday()
n = int(input("Extra days: "))
r = n % 7
i = (r+d) % 7

print(days[i])





