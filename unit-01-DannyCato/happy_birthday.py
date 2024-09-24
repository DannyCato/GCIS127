def bday_message():
    your_name = input('what\'s your name? : ')
    your_birthday = input('what day were you born on? : ')
    your_birthmonth = input('what month were you born on? : ')
    your_birthyear = input('what year were you born in? : ')

    print(your_name, '\b, your birthday is on', your_birthmonth, your_birthday, '\b,', your_birthyear)

def Main():
    bday_message()
    bday_message()
    bday_message()

Main()