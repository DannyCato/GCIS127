def convert_height():
    height_inches = int(input("Enter your height in inches?: ")) #cast to int otherwise it will read as string
    height_feet =  height_inches // 12 # // for floor division
    height_inches_remainder = height_inches % 12 # modulus operation
    print("you are ", height_feet, "\' ", height_inches_remainder, "\" tall", sep="")

def before(char):
    char_num = ord(char)
    print(char)
    print(chr(char_num + 1))
    print(chr(char_num + 2))
    print(chr(char_num + 3))

    

def Main():
    convert_height()
    before(input("Enter a character: "))


Main()