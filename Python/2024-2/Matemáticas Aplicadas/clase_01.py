# Clase 01


# ---- Variables ----

# DATA TYPES:
# > Text: str
# > Numeric: int, float, complex
# > Sequence: list, tuple, range
# > Mapping: dict
# > Set: set, frozenset
# > Boolean: bool
# > Binary: bytes, bytearray, memoryview
# > None: NoneType

var1 = 4  # int
var2 = 3.14  # float
var3 = "Text1"  # str
var4 = 'Text2'  # str
var5 = True  # bool
var6 = False  # bool

# a. Replacement

var1 = 5

# b. Casting

str1 = str(3)  # will be '3'
str1 = int(3)  # will be 3
str1 = float(3)  # will be 3.0

# c. Getting Type

print(type(var1))  # >>> <class 'int'>
print(type(var3))  # >>> <class 'str'>

# d. Case-Sensitive

xyz = 4
XYZ = 4  # xyz != XYZ

# e. Multiple Values

a, b, c = 4, '4', 4.0

a = b = c = 4

# f. Unpacking Collections

fruits = ["apple", "banana", "cherry"]
a, b, c = fruits

# g. Printing

print(a, b, c)

print(a + b + c)

