k = input("Key: ")
m = input("Message: ")
listK = []
listM = []
listR = []

for c in m:
    listM.append(bin(ord(c))[2:].zfill(8))

if len(k) == 1:
    for i in range(len(m)):
        listK.append(bin(ord(c))[2:].zfill(8))

else:
    for i in range(len(m)):
        listK.append(bin(ord(k[i%len(k)]))[2:].zfill(8))
print(listM)
print(listK)

for i in range(len(m)):
    element = ''
    for c in listM[i]:
        print(f'{ord(c) ^ ord(c)}')

print(listR)
