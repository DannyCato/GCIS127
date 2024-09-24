import math

def add(x, y):
    sum = x + y
    return str(x) + " + " + str(y) + " = " + str(sum)

def subtract(x, y):
    difference = x - y
    return str(x) + " - " + str(y) + " = " + str(difference)

def multiply(x, y):
    product = x * y
    return str(x) + " * " + str(y) + " = " + str(product)

def divide(x, y):
    if y == 0:
        return str(x) + " / " + str(y) + " = NaN"
    quotient = x / y
    return str(x) + " / " + str(y) + " = " + str(quotient)

def exponent(x, y):
    exponent = math.pow(x,y)
    return str(x) + " ^ " + str(y) + " = " + str(exponent)

def main():
    X_var = int(input("enter x: "))
    Y_var = int(input("enter y: "))
    print(add(X_var, Y_var))
    print(subtract(X_var, Y_var))
    print(multiply(X_var, Y_var))
    print(divide(X_var, Y_var))
    print(exponent(X_var, Y_var))

if __name__ == "__main__":
    main()