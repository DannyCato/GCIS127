letter_A = 'A'

def convert_to_ascii(b):
    print(chr(b))
    

def ascii_to_convert(a):
    print(ord(a))

def alphabet_position(letter, letter_A):
    code = ord(letter)
    position = code - letter_A - 1
    print(letter, "is in position", position, "of the alphabet")

def Main():
    convert_to_ascii(34)
    ascii_to_convert('A')
    alphabet_position(letter_A, letter_A)
    alphabet_position('B', letter_A)
    alphabet_position('C', letter_A)

Main()