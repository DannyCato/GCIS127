"""
This is an in-class assignment about using functions. It prints hello world
and then prompts the user for their name to print hello *your name*

"""
def world():
    """
    First function that prints "Hello, World!"
    """
    print('Hello, World!') #prints Hello, World
    

def name():
    """
    Asks user for their name and then prints it
    """
    name = input('what\'s your name?: ') #politely asks for name
    print('Hello! ', name, '!', sep="") #prints name

def Main():
    world() #calls world
    name() #calls name

Main()