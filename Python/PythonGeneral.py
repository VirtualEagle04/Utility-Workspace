# Variables
# No need to declare variable types before
myInt = 1
myFloat = 2.5
myString1 = "Hello, World!"
myString2 = 'Hello, Python!'

# Casting
# For specifying data types to a variable
x = int(3)  # x will be 3
y = float(3)  # y will be 3.0
z = str(3)  # z will be '3'

# Getting the Type
# To get the type of variable, we use:
type(myInt)  # will be int
type(myFloat)  # will be float 
type(myString1)  # will be str

# Variables are Case-Sensitive
a = 4
A = 4
# a != A

# Single-line multiple variable assignments
a, b = 3, 4

# ---------------------------------------

# Lists
myList = [1, 2, 3]
otherList, g = [], 3

# Adding elements to a list
otherList.append("Hello")
otherList.append(3)
otherList.append(24.3)
# otherList = ["Hello", 3, 24.3]

# ---------------------------------------

# Basic Operators
number = 1 + 2 * 3 / 4.0  # number is 2.5
remainder = 11 % 3  # remainder will be 2
squared = 7 ** 2  # squared will be 49
cubed = 2 ** 3  # cubed will be 8

# String operators
stringMultiplication = "Hey " * 5  # will be "Hey Hey Hey Hey Hey"

# List operators
evenNumbers = [2, 4, 6, 8]
oddNumbers = [1, 3, 5, 7]
allNumbers = oddNumbers + evenNumbers
# allNumbers will be [1, 3, 5, 7, 2, 4, 6, 8], so ORDER MATTERS

multipleNumbers = [1, 2, 3] * 3
# will be [1, 2, 3, 1, 2, 3, 1, 2, 3]

# ---------------------------------------

# String Formatting
name = "John"
output = "Hello, %s!" % name  # will be "Hello, John!"

age = 23
output = "Hello, %s! You have %d" % (name, age)  # will be "Hello, John! You have 23"

myList = [1, 2, 3]
output = "A list: %s" % myList  # will be "A list: [1, 2, 3]"

# %s - String (or any object with a string representation, like numbers)
# %d - Integers
# %f - Floating point numbers
# %.<number of digits>f - Floating point numbers with a fixed amount of digits to the right of the dot.
# %x/%X - Integers in hex representation (lowercase/uppercase)

# ---------------------------------------

# Basic Strinf Operations

# Entended Slice Syntax :
astring = "Hello World!"
output = astring[3:7]  # will be "lo W"
# general form is [startIndex(Inclusive): stopIndex(Exclusive): stepEachIndex]
chars = ['a', 'b', 'c', 'd', 'e', 'f', 'g']
output = chars[::2]  # will be [a, c, e, g] because it start at 0, ends at lenght, but steps 2 indexes each time
# can accept negative indexes, for example: -3 will be 'd', because it starts the index count from right to left
output = chars[-1]  # will be the last element, because there is no -0
# So...
# normal = [0, 1, 2, 3, 4, 5, 6]
# inverse = [-7, -6, -5, -4, -3, -2, -1]
# normal[6] == inverse[-1]

# Common Functions
len(astring)  # Lenght
astring.index("!")  # Index of parameter in string
astring.count("l")  # Number of parameter in string
astring.upper()  # HELLO WORLD!
astring.lower()  # hello world!
astring.capitalize()  # Hello World!
astring.startswith("Hello")  # Checks for a match in the start of the string
astring.endswith("!")  # Cheks for a match in the end of the string
astring.split(" ")  # Splits if it finds the parameter, returns list

# ---------------------------------------

# Conditions
# "And" and "Or" operations are made with the keywords and / or
name = "John"
age = 23
if name == "John" and age == 23:
    output = "Your name is John and you are 23 years old."
if name == "John" or name == "Rick":
    output = "Your name is either John or Rick."

# "in" operator
# used to check if a specified object exists within an iterable object container, such as a list
name = "John"
if name in ["John", "Rick"]:
    output = "Your name is either John or Rick."

# if, elif, else
x = 2
if x == 2:
    pass
elif x == 3:
    pass
else:
    pass

# "is" Operator
x = [1, 2, 3]
y = [1, 2, 3]

output = (x == y)
output = (x is y)
# the "is" operator does not do the same as "==", instead, it checks the instances themselves
(x is x)  # True
(x is y)  # True

# "not" Operator (the same as ! in Java, inverts the boolean)
output = (not False)  # True
output = (not not True)  # True

# ---------------------------------------

# Loops
# There are two types of loops in Python: for and while

primes = [2, 3, 5, 7]
for prime in primes:
    output = prime

for x in range(3):
    output = x
# 0, 1, 2
for x in range(3, 6):
    output = x
# 3, 4, 5
for x in range(3, 8, 2):
    output = x
# 3, 5, 7

# while loops
count = 0
while count < 5:
    output = count
    count += 1
# 0, 1, 2, 3, 4,

count = 0
while True:
    count += 1
    if (count >= 5):
        break
# 0, 1, 2, 3, 4


for x in range(10):
    if x % 2 == 0:
        continue
# 1, 3, 5, 7, 9

# else in loops
count = 0
while (count < 5):
    count += 1
else:
    # will only occur when the while condition fails
    count = 0

for i in range(1, 10):
    if (i % 5 == 0):
        break
else:
    # this will never happen because the for loop is ended with a break, so the else part is skipped
    count = 0


# ---------------------------------------

# Functions
# functions in Python are defined with the block keyword def <nameOfTheFunction>(parameter1, parameter2):
# the "return" keyword is optional, and defines if a functions return something or not

def myFunction():
    return 1 + 2


# ---------------------------------------

# Classes and Objects

class Car:
    brand = "Kia"
    model = 2008
    drive = "FWD"

    def __init__(self, brand, model, drive):
        self.brand = brand
        self.model = model
        self.drive = drive

    def toString(self):
        output = self.brand + " " + self.drive + " " + str(self.model)


myCar = Car("Volvo", 2010, "RWD")
output = myCar.toString()

# Modules and Packages

from Python.PythonModule import doSomething as customModuleName

# customModuleName()

import platform

x = platform.system()
print(x)

x = dir(platform)
print(x)
