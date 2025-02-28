#Ej No.27

import secrets

# generate a secure random integer between 1 and 10
secureRandInt = secrets.randbelow(10) + 1
print("Random Secure Number: ", secureRandInt)

# Generate a secure random token
secureToken = secrets.token_hex(16)
print("Random Secure Token: ", secureToken)
