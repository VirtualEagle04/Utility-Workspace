# Versión 1 Profe

def v1():
    with open("MA_Práctica_04.pdf", "rb") as f:
        data = f.read()
        L = []

        for byte in data:
            L.append(int(bin(byte)[2:].zfill(8), 2))
        
        bits = bin(sum(L))[2:]
        print(bits)
        print(bits[::-1])
        L = []

        for i in range(0, len(bits), 8):
            L.append(int(bits[::-1][i:i+8][::-1], 2))
        
        print(sum(L))
        print(bin(sum(L))[2:])

# Version 2 Profe

def v2():
    with open("MA_Práctica_04.pdf", "rb") as f:
        data = f.read()
        L = [int(bin(byte)[2:].zfill(8), 2) for byte in data]

        while True:
            bits = bin(sum(L))[2:]

            if len(bits) <= 8:
                break

            L = [int(bits[::-1][i:i+8][::-1], 2) for i in range(0, len(bits), 8)]

        checksum = ""

        print(sum(L))
        print(bin(sum(L))[2:])

        checksum = "".join("1" if bit == "0" else "0" for bit in bits)

        print(checksum)

print("V2")
v2()