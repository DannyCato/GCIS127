def add_chars(char1, char2):
    sum = ord(char1) + ord(char2)
    print(sum)

def subtract_chars(char1, char2):
    subtract = ord(char1) - ord(char2)
    print(subtract)


def Main():
    char1 = input("Enter character 1: ")
    char2 = input("Enter character 2: ")
    add_chars(char1,char2)
    subtract_chars(char1,char2)

Main()