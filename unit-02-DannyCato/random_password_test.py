import random_password

def test_create_ascii_range_string():
    #invoke
    x1 = 97
    y1 = 100
    expected_answer1 = "abc"

    x2 = 48
    y2 = 58
    expected_answer2 = "0123456789"

    x3 = 65
    y3 = 70
    expected_answer3 = "ABCDE"

    #test
    actual_answer1 = random_password.create_ascii_range_string(x1,y1)
    actual_answer2 = random_password.create_ascii_range_string(x2,y2)
    actual_answer3 = random_password.create_ascii_range_string(x3,y3)

    #analyze
    assert expected_answer1 == actual_answer1
    assert expected_answer2 == actual_answer2
    assert expected_answer3 == actual_answer3

def test_solid_strings():
    #invoke
    uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
    lowercase = "abcdefghijklmnopqrstuvwxyz"
    numbers = "0123456789"
    symbols = "!\"#$%&'()*+,-./:;<=>?@[\]^_`{|}~"

    #test
    actual_uppercase = random_password.create_uppercase_letters_string()
    actual_lowercase = random_password.create_lowercase_letters_string()
    actual_numbers = random_password.create_digits_string()
    actual_symbols = random_password.create_symbols_string()

    #analyze
    assert uppercase == actual_uppercase
    assert lowercase == actual_lowercase
    assert numbers == actual_numbers
    assert symbols == actual_symbols

def test_pick_random_letter():
    #invoke
    string1 = "great"
    string2 = "string"
    string3 = "NR$E%#Basdf"
    string4 = "NTEA#G$Ahare4T@"

    #test
    letter_picked1 = random_password.get_random_char_from_string(string1)
    letter_picked2 = random_password.get_random_char_from_string(string2)
    letter_picked3 = random_password.get_random_char_from_string(string3)
    letter_picked4 = random_password.get_random_char_from_string(string4)
    
    #analyze
    assert string1 or letter_picked1
    assert string2 or letter_picked2
    assert string3 or letter_picked3
    assert string4 or letter_picked4
