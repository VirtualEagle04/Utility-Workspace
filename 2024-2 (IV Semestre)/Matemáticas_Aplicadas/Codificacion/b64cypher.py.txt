from base64 import b64encode, b64decode

# Cifrado manual


def tobase64(n: int) -> str:
    import string
    base64 = string.ascii_uppercase + string.ascii_lowercase + string.digits + "+/"
    return base64[n]


h = "ABC"
s = ''
for x in h:
    s = s + bin(ord(x))[2:].zfill(8)
print(s)

for i in range(0, len(s), 6):
    print(f"bin: {s[i:i+6]}")
    print(f"dec: {int(s[i:i+6].zfill(8), 2)}")
    print(f"char: {tobase64(int(s[i:i+6].zfill(8), 2))}")

# Cifrado con libreria b64encode

c = "ABC"
cypher = b64encode(c.encode())
print(cypher)

# Cifrado de imagen (jpg) a binario

with open('kanye.jpg', 'rb') as f:  # rb = read binary
    data = f.read()
    cifrado = b64encode(data)

    with open('kanye.txt', 'w') as g:  # w = write
        g.write(str(cifrado))


# Cifrado de binario a imagen (jpg)

with open('kanye.txt', 'rb') as f:  # rb = read binary
    data = f.read()
    descifrado = b64decode(data[1:])

    with open('kanye2.jpg', 'wb') as g:  # wb = write binary
        g.write(descifrado)



