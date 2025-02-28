# Características de una función Hash:
# 1. DETERMINISM: A hash function always produces the same output when given the same input. 
#           This means that if you hash the same data twice, you'll get the same hash value both times.
# 2. SPEED: Hash functions should be fast to compute. They should be able to generate a hash value quickly, 
#           even for large amounts of data. This is important for applications like data indexing, digital signatures, and password storage.
# 3. COLLISION RESISTANCE: A good hash function should make it computationally infeasible to find two 
#           different inputs that produce the same hash value. This property is known as collision resistance. 
#           If it were easy to find collisions, it would be a major security vulnerability.
# 4. HARD TO INVERT / PREIMAGE RESISTANCE: Given a hash value, it should be computationally infeasible to determine the original input data. 
#           This property is known as the preimage resistance. If it were easy to invert a hash function, 
#           it would be a major security vulnerability, as it would allow an attacker to recreate the original data from its hash.
# 5. AVALANCHE EFFECT: A small change in the input should result in a significant change in the output. This property is known as the avalanche effect. 
#           If a hash function didn't have this property, it would be easy to find two inputs that have the same hash value by making 
#           small changes to one of the inputs. This would undermine the collision resistance property.

# Algoritmos Más Utilizados (Solo para Texto)
# > MD5 (Message Digest Algorithm 5)
# > SHA-256 (Secure Hash Algorithm of 256 bits - 32 bytes)
# >> Más seguro que MD5
# > SHA-512 (Secure Hash Algorithm of 512 bits - 64 bytes)
# >> Más seguro que MD5 y SHA-256

import hashlib
from crypto.PublicKey import RSA
from crypto.Cipher import PKCS1_OAEP

print("TEXTO".center(100, "-"))

data = "Hello"
bdata = bytes(data, "utf-8")

h1 = hashlib.new("md5", bdata).hexdigest()
h2 = hashlib.new("sha256", bdata).hexdigest()
h3 = hashlib.new("sha512", bdata).hexdigest()

print(h1)
print(h2)
print(h3)

print("ARCHIVOS".center(100, "-"))

with open("test/kanye.jpg", "rb") as f:
    data = f.read()
    print(hashlib.new("sha256", data).hexdigest())

with open("test/kanye.jpg", "rb") as f:
    data = hashlib.file_digest(f, "sha256")
    print(data.hexdigest())

print("SALTING & STRETCHING".center(100, "-"))
# "Salting" and "Stretching" are two common techniques used to enhance
# passwords security and make them more resistant to
# brute force and dictionary attacks.

# SALTING: Using a random data as an additional input to a
# one-way function that hashes data, a password or a passphrase.

# STRETCHING: Techniques used to make a possibly weak key, typically a
# password or passphrase, more secure against a brute-force attack by
# increasing the resources (time and possibly space) it takes to test
# each possible key.

print("RSA ALGORITHM".center(100, "-"))
# It is an asymmetric encryption algorithm developed by Ron
# Rivest, Adi Shamir, and Leonard Adleman. Generally, it is not
# used to encrypt entire messages or files because it is less
# efficient and consumes more resources compared to symmetric
# key encryption.

# Factorize large semiprime numbers: Difficulty of factoring large semiprimes.
# Public and Private keys: Pub->Encrypt, Priv->Decrypt.
# Communication: Used to secure communication such as HTTPS.
# Encrypts small data: Used for encrypting small pieces of data.

# PUBLIC KEY:
# - Shared Openly.
# - Used to encrypt data or verify digital signatures.
# - Impossible to generate the original plaintext from the encrypted text with the public key.
# Consists of two parts:
# > Modulus (n).
# > Public Exponent (e).

# PRIVATE KEY:
# - Secret
# - Used to decrypt data or to digitally sign data.
# - Used to reverse the operation performed by the public key.
# Consists of two parts:
# > Moduus (n).
# > Private Exponent (d).

print("RSA EXCERCISE FOR ANA".center(100, "-"))
# Determine the private key and the public key for a user named Ana with the RSA Algo.

# N°1: Chose two prime numbers (p and q).
p = 839
print(f"p: {p}")
q = 947
print(f"q: {q}")
# N°2: Calculate the value for n
ana_n = p * q
print(f"n: {ana_n}")
# N°3: Calculate phi_sub_n = (p - 1)(q - 1)
phi_sub_n = (p - 1) * (q - 1)
print(f"phi_sub_n: {phi_sub_n}")
# N°4: Chose a number e such that:
# a) 1 < e < phi_sub_n
# b) GCD(e, phi_sub_n) = 1
ana_e = 41
print(f"e: {ana_e}")
# N°5: Find the value of d such that:
# (e * d)mod(phi_sub_n) = 1
ana_d = pow(ana_e, -1, phi_sub_n)
print(f"d: {ana_d}")

print(f"Public Key: ({ana_n}, {ana_e})")
print(f"Private Key: ({ana_n}, {ana_d})")

print("RSA EXCERCISE FOR JAIME".center(100, "-"))
# Determine the private key and the public key for a user named Ana with the RSA Algo.

# N°1: Chose two prime numbers (p and q).
p = 761
print(f"p: {p}")
q = 1019
print(f"q: {q}")
# N°2: Calculate the value for n
jaime_n = p * q
print(f"n: {jaime_n}")
# N°3: Calculate phi_sub_n = (p - 1)(q - 1)
phi_sub_n = (p - 1) * (q - 1)
print(f"phi_sub_n: {phi_sub_n}")
# N°4: Chose a number e such that:
# a) 1 < e < phi_sub_n
# b) GCD(e, phi_sub_n) = 1
jaime_e = 53
print(f"e: {jaime_e}")
# N°5: Find the value of d such that:
# (e * d)mod(phi_sub_n) = 1
jaime_d = pow(jaime_e, -1, phi_sub_n)
print(f"d: {jaime_d}")

print(f"Public Key: ({jaime_n}, {jaime_e})")
print(f"Private Key: ({jaime_n}, {jaime_d})")

print("CONFIDENTIALITY IN RSA".center(100, "-"))
print("Encrypting a Message with RSA".center(100, "-"))

msg = 4596

# Ana uses Jaime's public key to encrypt message
encrypted = pow(msg, jaime_e) % jaime_n
print(f"Encrypted Message: {encrypted}")

print("Decrypting a Message with RSA".center(100, "-"))

# Jaime uses his private key to decrypt message
decrypted = pow(encrypted, jaime_d) % jaime_n
print(f"Decrypted Message: {decrypted}")

print("Encrypting a Signature with RSA".center(100, "-"))

file_hash = 4277

# Ana uses her private key to sign the file hash and send it to Jaime along with the file hash
encrypted_hash = pow(file_hash, ana_d) % ana_n
print(f"Encrypted Signature: {encrypted_hash}")

print("Decrypting a Signature with RSA".center(100, "-"))

# Jaime uses Ana's public key to decrypt the encrypted has and compare it with the recieved hash to
# see if they match
decrypted_hash = pow(encrypted_hash, ana_e) % ana_n
print(f"Encrypted Signature: {decrypted_hash}")

print("RSA in Python".center(100, "-"))

key = RSA.generate(2048)
public_key = key.public_key()

message = bytes("Hola, saludes desde la clase", "utf-8")

cifrado = PKCS1_OAEP.new(public_key).encrypt(message)
descrifador = PKCS1_OAEP.new(key)
mensaje_descifrado = descrifador.decrypt(cifrado)

print(f"Mensaje Descrifrado: {mensaje_descifrado.decode()}")

encrypted = pow(3323451, 87679) % 142127
print(f"Decrypted Message: {encrypted}")

encrypted = pow(73745, 41) % 360403
print(f"Encrypted Message: {encrypted}")
