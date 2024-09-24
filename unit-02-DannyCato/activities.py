def boolean_expresions(a, b, c):
    print(a, b, c, sep="\n")
    print("is a > b?:", a>b)
    print("is b = c?:", b==c)
    print("is a <= c?:", a<=c)
    print("is a != c?:", a!=c)
    print("is a > b and a > c?:", a>b and a>c)
    print("is b < c or a < b?:", b<c or a<b)
            

def Main():
    boolean_expresions(input("Pick a number?: "), input("Pick a number?: "), input("Pick a number?: "))

Main()