def letters():
    '''
        returns a set with every lowercase letter of the alphabet
    '''
    return set("abcdefghijklmnopqrstuvwxyz")

def make_letter_frequency(filename):
    '''
        returns a dictionary of the frequency of every letter (not case sensetive)\n
        inputs:\n
            \tfilename = a .txt file
    '''
    letter_count = dict()
    letter_set = letters()
    for i in letter_set:
        letter_count[i] = 0
    with open(filename) as file:
        for line in file:
            line = line.lower()
            for char in line:
                if char in letter_set:
                    letter_count[char] = letter_count[char] + 1
    return letter_count


def print_letter_frequency(frequency):
    '''
        prints every key and the highest used one at the end
        inputs:
            frequency = dictionary of the frequency of every letter
    '''
    highest_used_key = "a"
    for key in frequency.keys():
        print(key, ":", frequency[key])
        if frequency[key] > frequency[highest_used_key]:
            highest_used_key = key
    print("The most popular letter :", highest_used_key, ":", frequency[highest_used_key])

def main():
    #print(letters())
    #frequency = make_letter_frequency("data/alice.txt")
    #print(frequency)
    #print_letter_frequency(frequency)

    print("Alice in Wonderland:")
    alice_frequency = make_letter_frequency("data/alice.txt")
    print_letter_frequency(alice_frequency)
    print()
    print("rit_mission:")
    alice_frequency = make_letter_frequency("data/rit_mission.txt")
    print_letter_frequency(alice_frequency)



if __name__ == "__main__":
    main()