#Ej No.7

import re

text = input("Text: ")

print(f"Number of Upper Case letters in the text: {len(re.findall('[A-Z]', text))}")

#ASCII
res = 0
for c in text:
    if 41 <= ord(c) <= 90:
        res += 0

print(f"Number of Upper Case letters in the text: {res}")