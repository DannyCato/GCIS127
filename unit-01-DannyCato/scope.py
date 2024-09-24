STRING = "Fo sho"
INT = 15
FLOAT = 3.1415

def print_param(p):
    print(p)

def print_local():
    local = "great"
    print(local)
    
def print_which():
    STRING = "nah bro"
    print(STRING)


def Main():
    print_param(STRING)
    print_param(INT)
    print_param(FLOAT)
    local = "cool"
    print_local()
    print_which()

Main()