#include <iostream>
using namespace std;

int main(){
    
    //---VARIABLES---
    //Integers
    short myShort = 2; //short == short int (2 bytes)
    int myInt = 2; // (4 bytes)
    long myLong = 2; //long == long int (4 bytes)
    
    //Floating-Point
    float myFloat = 1; // (4 bytes)
    double myDouble = 1; // (8 bytes)
    long double myLongDouble = 1; // (16 bytes)
    
    //Characters
    char mySingleChar = 'C'; // (1 byte)
    string myString = "Hello World!"; // (32 bytes)
    
    //Boolean
    bool myBoolean = true; // (1 byte) True = 1, False = 0
    
    //Modifiers
    /*
    signed -> signed representation
    unsigned -> unsigned representation (no negatives)
    short -> space optimized of at least 16 bits (2 bytes)
    long -> space will be of at least 32 bits (4 bytes)
    */
   
    //---VARIABLE DECLARATION---
    int x = 5, y = 4, z = 3;
    //also...
    int a, b, c;
    a = b = c = 5;
    
    //---CONSTANTS---
    //Values will be unchangeble and read-only
    const int myIntConstant = 50;
    // myIntConstant = 10; -> error: assignment of read-only variable
    
    //---USER INPUT---
    /*
    int w; 
    cout << "Type a number: ";
    cin >> w;
    cout << "Your number is: " << w;
    */
    
    //---SCIENTIFIC NUMBERS---
    //The 'e' or 'E' indicated the power of the float number
    float f1 = 35e3;
    double d1 = 12e5;
    
    //---CHARACTER DATA TYPES---
    //Characters 'char' variables can also be ASCII values (https://www.w3schools.com/charsets/ref_html_ascii.asp):
    char myA = 65;
    char myB = 66;
    char myC = 67;
    
    //---OPERATORS---
    /*
    +, -, *, /, %, ++, --; (Arithmetic)
    Unlike Java, ++ and -- are first order:
    --x;
    ++x;
    
    =, +=, -=, *=, /=, %= (Assignment) 
    
    ==, !=, >, <, >=, <= (Boolean)
    
    &&, ||, ! (Logical)
    
    &, |, ^, >>, << (Bitwise)
    */
   
    //---STRINGS---
    //Concatenation
    string firstName = "John";
    string lastName = "Doe";
    string fullName = firstName + lastName; //JohnDoe
    
    fullName = firstName + " " + lastName; //John Doe
    fullName = firstName.append(lastName); //JohnDoe
    
    //Lenght
    int nameLenght = fullName.length(); //string.lenght() == string.size()
    
    //Access Strings
    char lastLetterOfLenght = fullName[fullName.length() - 1];
    fullName[5] = 'K';
    
    //Special Characters
    /*
    \' -> result in '
    \" -> result in "
    \\ -> result in \
    \n -> new line
    \t -> tab whitespace
    */
    string testText = "It\'s Leviosa, not \"Levi-osa\"";
    
    //User Input Strings
    //cin considers a (whitespace, tab, space, etc) as terminating charater, so...:
    /*
    cin >> fullName; John Doe
    fullName == "John"
    */
   //To solve this: getline(cin, fullName)
   
   //---MATHEMATHICS---
    /*
    Some important functions:
    max(5, 10);
    min(5, 10);
    The following ones are in <cmath> header
    sqrt(x);
    round(x);
    log(x);
    abs(x)
    acos(x)
    asin(x)
    atan(x)
    cbrt(x)
    ceil(x)
    cos(x)
    cosh(x)
    exp(x)
    expml(x)
    fabs(x)
    fdim(x, y)
    floor(x)
    hypot(x, y)
    frna(x, y, z)
    fmax(x, y)
    fmin(x, Y)
    fmod(x, Y)
    iow(x, y)
    in(x)
    inh(x)
    In(x)
    nh(x)
    etc...
    https://cplusplus.com/reference/cmath/
    */
   
   //---CONDITIONS---
   //If, else if, else
   if(true){
    
   }
   else if(true){
    
   }
   else{
    
   }
   
   //Ternary Operator
   //variable = (condition)? valueIfTrue : valueIfFalse
   
    //---SWITCH CASES---
    switch(x){
        case 1:
            //code block
            break;
    }
    
    //---WHILE LOOPS---
    while(false){
        
    }
    
    do{
        
    }while(false);
    
    //---FOR LOOPS---
    for (int i = 0; i < 10; i++){
        //do something
    }
    
    int myNumbers[5] = {1, 2, 3, 4, 5};
    for (int number : myNumbers){
        //do something
    }
    
    //---BREAK/CONTINUE---
    /*
    break -> breaks the loop
    continue -> breaks ONE iteration of the loop (or skips it)
    */
   
   //---ARRAYS---
   string cars[4] = {"Volvo", "BMW", "KIA", "FIAT"};
   cars[0] = "Opel";
   
   //ITS NOT NECESSARY TO SPECIFY THE SIZE OF THE ARRAY WHEN DECLARING IT IMMEDIATELY
   int otherNumbers[] = {1, 2, 3, 4, 5, 6};
   //The compiler determines the size of the array based on the number of inserted values.
   
   //Get Array Size
   int size = sizeof(otherNumbers) / sizeof(int); //For array lenght = 6
   //sizeof(otherNumbers) -> sum of all the sizes of each int in the array 4 bytes * 6 = 24
   //cout << size;
   
   //Multidimensional Arrays
   int maze[5][5];
   
   //---STRUCTS---
   //Can contain many different data types 
   struct { int myNumber; string myName; } myStruct;
   
   //Assign value
   myStruct.myName = "Federico.";
   myStruct.myNumber = 19;
   
   //Multiple structures
   struct { string gameName; int release; string mainDevice; } myGame1, myGame2, myGame3;
   
   //Naming structures
   struct myDataType { int something; } mySomething;
   
   myDataType otherSomething;
   otherSomething.something = 4;
   
   //---REFERENCES---
   //With the '&' operator, we can create a reference variable to another variable
   string food = "Pizza."; //food variable
   string &meal = food; //reference to food
   //food == meal
   
   //---MEMORY ADRESS---
   //To access the memory adress of a saved variable we use the & operator
   string otherFood = "Pasta";
   //cout << &food -> outputs 0x6dfed4
   
   //---POINTERS---
   //A pointer is a variable that stores the memory adress of its value, it is created with the same data type of 
   //the value and with a '*'
   string beans = "Beans.";
   string* ptr = &beans;
   /*
   A pointer can also be created this way:
   string* prt = &...
   string *prt = &...
   string * prt = &...
   The first one is preferred.
   */
   
   //Dereference
   //Get the value with a memory adress
   //cout << *ptr; -> "Beans."
   
   //Modify Pointers
   *ptr = "Hamburger";
   
    return 0;
}

    //---FUNCTIONS---

    void myFunction(int number, string name, bool wants){
        
    }

    //It is a common pattern in C++ that the function is declared before the main, and defined after:
    /*
        void function();

        int main(){
            return 0;
        }

        void function(){
            Do something
        }
    */
   
   //Default Parameters
   void otherFunction(string defParameter = "Default Parameter"){
    //If the function is called without a parameter, it takes the default one.
   }
   
   //Return
   int returnInteger(){
    return 1;
   }
   
   //Pass By Reference
   void swapNums(int &x, int &y){
    int z = x;
    x = y;
    y = z;
   }
   
   int firstNum = 10;
   int secondNum = 20;
    // swapNums(firstNum, secondNum); -> changes the value of firstNum and secondNum
    
    //Overloading
    void sayHello(int integer);
    void sayHello(float floating);
    void sayHello(bool boolean);
   
   