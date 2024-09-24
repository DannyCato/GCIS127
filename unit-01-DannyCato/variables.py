def variables_practice():
    ageInMonths = 18 * 12 + 8 # 18years * 12months = 216 + 8 months = 224 months
    daysInAYear = 365
    FirstPet = 'Guppy' #beta fish
    pi = 3.1415

    print('I am', ageInMonths, 'months old') #printing months
    print('How many days in a year? :', daysInAYear)
    print('My first pet was a beta fish named', FirstPet)
    print('the first 5 digits of by are:', pi)

def expressions_practice():
    AddingInts = 2 + 2 
    MultiplyingTwoTypes = 4 * 5.3
    DividingFloats = 3.4 * 6.6 #has some floating point funniness
    Mix = (17 + 4 - (3 + 4)^2 ) / 4 

    print(AddingInts, MultiplyingTwoTypes, DividingFloats, Mix)

def prompt_and_print():
    Number1 = float(input("first number = "))
    Number2 = float(input("second number = "))
    print(Number1, "+", Number2, "=", Number1 + Number2)
    print(Number1, "-", Number2, "=", Number1 - Number2)
    print(Number1, "*", Number2, "=", Number1 * Number2)
    print(Number1, "/", Number2, "=", Number1 / Number2)
    print(Number1, "%", Number2, "=", Number1 % Number2)

"""
TypeError: unsupported operand type(s) for -: 'str' and 'str'
"""

def main():
    variables_practice()
    expressions_practice()
    prompt_and_print()

main()