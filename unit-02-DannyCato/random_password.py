import random

def create_ascii_range_string(start, stop):
    str = ""
    for i in range(start, stop):
        str = str + chr(i)
    return str

def create_uppercase_letters_string():
    return create_ascii_range_string(65,91)

def create_lowercase_letters_string():
    return create_ascii_range_string(97,123)

def create_digits_string():
    return create_ascii_range_string(48,58)

def create_symbols_string(): 
    return create_ascii_range_string(33,48) + create_ascii_range_string(58,65) + create_ascii_range_string(91,97) + create_ascii_range_string(123,127)

def get_random_char_from_string(str):
    chosen = random.randint(0,len(str))
    return str[chosen]

def generate_random_password(Uppercase, Lowercase, Digits, Symbols):
    password = ""
    while (Uppercase + Lowercase + Digits + Symbols) > 0:
        chosen = random.randrange(0,4)

        '''
        0 = Uppercase letters
        1 = Lowercase letters
        2 = Digits
        3 = Symbols

        Main idea:
        Get random number
            Check if the random num == one of the numbers
                if it does then check if it is allowed to have more of that character
                    If true == add to the password string and remove one from that character amount
                    If false == restart the loop and get a new number
        Copy this framework for every number until it works

        god this sucks
        '''

        if chosen == 0:
            if Uppercase > 0:
                password = password + get_random_char_from_string(create_uppercase_letters_string())
                Uppercase = Uppercase -1
            else:
                continue
        elif chosen == 1:
            if Lowercase > 0:
                password = password + get_random_char_from_string(create_lowercase_letters_string())
                Lowercase = Lowercase -1
            else:
                continue
        elif chosen == 2:
            if Digits > 0:
                password = password + get_random_char_from_string(create_digits_string())
                Digits = Digits -1
            else:
                continue
        elif chosen == 3:
            if Symbols > 0:
                password = password + get_random_char_from_string(create_symbols_string())
                Symbols = Symbols -1
            else:
                continue

    return password

def main():
    raw_input = input("Enter <num of Uppercase letters> <num of Lowercase letters> <num of Digits> <num of Symbols>: ")
    tokens = raw_input.split(" ")
    if len(tokens) == 4:
        print("Password:", generate_random_password(int(tokens[0]), int(tokens[1]), int(tokens[2]), int(tokens[3])))
    else:
        print("did not input exactly 4 numbers seperated by spaces")
        main()
    
if __name__ == "__main__":
    main()