import ceaser_cypher

def test_ceaser_cypher():
    encrypt = "fuck you pytest" # gives random error about a non-existent variable "encrypt"
    # setup
    letter = 'Z'
    shift = 4
    expected = 'D'


    UP_Letter1 = 'A' #T
    UP_Letter2 = 'B' #T
    UP_Letter3 = 'c' #F


    Decrypt1 = 'D'
    shift1 = 8
    expected_Decrypt1 = 'V'

    Decrypt2 = 'J'
    shift2 = 2
    expected_Decrypt2 = 'H'

    Decrypt3 = 'A'
    shift3 = 2
    expected_Decrypt3 = 'Y'


    encrypt_message1 = "WOWZA"
    encrypt_message_shift1 = 3
    expected_encrypt_message1 = "ZRZCD"

    encrypt_message2 = "GRONK"
    encrypt_message_shift2 = 2
    expected_encrypt_message2 = "ITQPM"

    encrypt_message3 = "GRAGGLE"
    encrypt_message_shift3 = 6
    expected_encrypt_message3 = "MXGMMRK"

    # decrpyt message tests are using encrpyt message test but in reverse

    default_parameter_encrypt_letter = 'G'
    expected_default_parameter_encrypt_letter = 'J'

    default_parameter_decrypt_letter = "D"
    expected_default_parameter_decrypt_letter = "A"

    default_parameter_encrypt_message = "GREAT"
    expected_default_parameter_encrypt_message = "JUHDW"

    default_parameter_decrypt_message = "JURVV"
    expected_default_parameter_decrypt_message = "GROSS"
    


    # invoke
    actual = ceaser_cypher.encrypt_letter(letter,shift)

    UP_actual1 = ceaser_cypher.is_Alphabetic(UP_Letter1)
    UP_actual2 = ceaser_cypher.is_Alphabetic(UP_Letter2)
    UP_actual3 = ceaser_cypher.is_Alphabetic(UP_Letter3)

    actual_Decrypt1 = ceaser_cypher.decrypt_letter(Decrypt1, shift1)
    actual_Decrypt2 = ceaser_cypher.decrypt_letter(Decrypt2, shift2)
    actual_Decrypt3 = ceaser_cypher.decrypt_letter(Decrypt3, shift3)

    actual_encrypt_message1 = ceaser_cypher.encrypt_message(encrypt_message1, encrypt_message_shift1)
    actual_encrypt_message2 = ceaser_cypher.encrypt_message(encrypt_message2, encrypt_message_shift2)
    actual_encrypt_message3 = ceaser_cypher.encrypt_message(encrypt_message3, encrypt_message_shift3)

    actual_decrypt_message1 = ceaser_cypher.decrypt_message(expected_encrypt_message1, encrypt_message_shift1)
    actual_decrypt_message2 = ceaser_cypher.decrypt_message(expected_encrypt_message2, encrypt_message_shift2)
    actual_decrypt_message3 = ceaser_cypher.decrypt_message(expected_encrypt_message3, encrypt_message_shift3)

    actual_default_parameter_encrypt_letter = ceaser_cypher.encrypt_letter(default_parameter_encrypt_letter)
    actual_default_parameter_decrypt_letter = ceaser_cypher.decrypt_letter(default_parameter_decrypt_letter)

    actual_default_parameter_encrypt_message = ceaser_cypher.encrypt_message(default_parameter_encrypt_message)
    actual_default_parameter_decrypt_message = ceaser_cypher.decrypt_message(default_parameter_decrypt_message)


    # analyze
    assert expected == actual

    assert UP_actual1 == True
    assert UP_actual2 == True
    assert UP_actual3 == False

    assert expected_Decrypt1 == actual_Decrypt1
    assert expected_Decrypt2 == actual_Decrypt2
    assert expected_Decrypt3 == actual_Decrypt3

    assert actual_encrypt_message1 == expected_encrypt_message1
    assert actual_encrypt_message2 == expected_encrypt_message2
    assert actual_encrypt_message3 == expected_encrypt_message3

    assert actual_decrypt_message1 == encrypt_message1
    assert actual_decrypt_message2 == encrypt_message2
    assert actual_decrypt_message3 == encrypt_message3

    assert actual_default_parameter_encrypt_letter == expected_default_parameter_encrypt_letter
    assert actual_default_parameter_decrypt_letter == expected_default_parameter_decrypt_letter
    assert actual_default_parameter_encrypt_message == expected_default_parameter_encrypt_message
    assert actual_default_parameter_decrypt_message == expected_default_parameter_decrypt_message