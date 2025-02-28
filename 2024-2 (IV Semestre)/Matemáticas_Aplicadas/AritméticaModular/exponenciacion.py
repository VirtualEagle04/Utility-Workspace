# Aritmética Modular (Operaciones)

import numpy as np

# Exponenciación

# 3^13 % 17:
# Binary Representation of Exponent: 13(dec) = 1101(bin)
# This can be interpreted as 13 = 2^3 + 2^2 + 2^0

# Exponentiation by Squaring:
# Compute the necessary power of 2 by squaring:
# 3^1 % 17 = 3
# 3^2 % 17 = (3*3) % 17 = 9
# 3^4 % 17 = (9*9) % 17 = 81 % 17 = 13
# 3^8 % 17 = (13*13) % 17 = 169 % 18 = 16

# Combine the Results Using Binary Expansion:
# Using the binary representation 1101(bin), we get
# 3^13 = 3^(8+4+1) = 3^8 * 3^4 * 3^1

# Combine the Results:
# 3^13 % 17 = (3^8 % 17)*(3^4 % 17)*(3^1 % 17) % 17
# 3^13 % 17 = 16*13*3 % 17

# Final Calculation
# 16*13 = 208
# 208*3 = 624
# 624 % 17 = 12

# So, 3^13 % 17 = 12

# ---------------------------

# Problem:
# 2300^100 % 89 = ?