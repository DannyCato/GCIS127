NUMBERS_IN_ALPHABET = 26
TWICE_NUMBERS_IN_ALPHABET = 52
STARTING_LETTER_OF_UPPERCASE = 65
SHIFT = 3

def encrypt_letter(letter, shift=SHIFT):
    if is_Alphabetic:
        letter_number = ord(letter) # find position of letter
        letter_shifted = (letter_number + shift) % NUMBERS_IN_ALPHABET + TWICE_NUMBERS_IN_ALPHABET # add shift to positon with mod to keep it in the range of letters
        if letter_shifted < STARTING_LETTER_OF_UPPERCASE:
            letter_shifted = letter_shifted + NUMBERS_IN_ALPHABET
        return chr(letter_shifted) # return shifter letter
    else:
        return ""
    
def is_Alphabetic(character):
    if STARTING_LETTER_OF_UPPERCASE - 1 < ord(character) < 91:
        return True
    else:
        return False
    
def decrypt_letter(letter,shift=SHIFT):
    letter_number = ord(letter)
    letter_shifted = (letter_number - shift) % NUMBERS_IN_ALPHABET + TWICE_NUMBERS_IN_ALPHABET # add shift to positon with mod to keep it in the range of letters
    if letter_shifted < STARTING_LETTER_OF_UPPERCASE:
        letter_shifted = letter_shifted + NUMBERS_IN_ALPHABET
    return chr(letter_shifted) # return shifter letter

def encrypt_message(message, shift=SHIFT):
    ciphertext = ""
    for iterations in message:
        ciphertext = ciphertext + encrypt_letter(iterations,shift)
    return ciphertext

def decrypt_message(message, shift=SHIFT):
    ciphertext = ""
    for iterations in message:
        ciphertext = ciphertext + decrypt_letter(iterations,shift)
    return ciphertext


def main():
    #print(encrypt_letter(input("Select a letter: "), 3))
    phrase = input("Type out a phrase: ").split()
    for i in phrase:
        print(encrypt_message(i))
        


if __name__ == "__main__":
    main()