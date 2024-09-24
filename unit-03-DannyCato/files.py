import csv

def print_lines(filename):
    with open(filename) as file:
        for line in file:
            line = line.strip()
            print(line)

def word_search(filename):
    word = input("enter a word: ").lower()
    file = open(filename)
    for line in file:
        line = line.strip().split()
        for i in line:
            if word == i:
                file.close()
                return True
            else:
                continue
    file.close()
    return False

def first_words(filename, number_of_words=30):
    list = []
    with open(filename) as file:    
        for line in file:
            line = line.strip().split()
            if line == []:
                continue
            else:
                list.append(line[0])
            if (len(list) >= number_of_words):
                break
    return list

def numbers():
    sum = 0
    while (True):
        filename = input("Filename: ")
        if filename == "":
            break
        try:
            with open(filename) as file:
                for line in file:
                    for item in line:
                        item = item.strip()
                        if item != '':
                            #print(item)
                            try:
                                sum += float(item)
                            except ValueError:
                                print("Skipping non-float or integer character:",item)                           

        except FileNotFoundError:
            print("The file trying to be found does not exist within this given directory")
                        
        print("Sum:", sum)


def main():
    #print_lines("data/numbers_01.txt")
    #print(word_search("data/words.txt"))
    #print(first_words("data/alice.txt"))
    numbers()

if __name__ == "__main__":
    main()