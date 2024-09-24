import csv
import random as r

'''
Assignment 5.2

By: Danny Catorcini
'''

def make_database(filename):
    '''
        returns a dictionary of all pokemon cards\n
        returned dictionary formatted: dictionary[card number] = tuple(card number, name, type)\n
        inputs:\n
            \tfilename = pokenmon_cards.csv file
    '''
    database = dict()
    with open(filename) as csv_file:
        file = csv.reader(csv_file)
        next(file)
        for line in file:
            database[int(line[1])] = (int(line[1]), line[0], line[2])
    return database

def make_pack(database):
    '''
        returns a randomly selected set of 10 cards\n
        inputs:\n
            \tdatabase: database of all cards
    '''
    pack = set()
    while len(pack) < 10:
        card = database[r.randrange(1,len(database) + 1)]
        #print(card)
        pack.add(card)
    return pack

def build_basic_collection(database):
    '''
        returns the number of iterations to completely get all cards\n
        inputs:\n
            \tdatabase: database of all cards
    '''
    collection = set()
    count = 0
    while len(collection) != len(database):
        #length = len(collection) # was used for testing but isn't necessary anymore
        pack = make_pack(database)
        for i in pack:
            collection.add(i)
        count += 1
    return count

def build_counting_collection(database):
    '''
        returns a dictionary of the number of times a card was pulled\n
        returned dictionary formatted: dictionary[tuple(card number, name, type)] = number of times card was pulled\n
        inputs:\n
            \tdatabase: database of all cards
    '''
    collection = dict()
    collection_set = set()
    for i in range(1, len(database) + 1):
        collection[database[i]] = 0

    while len(collection_set) < len(database):
        pack = make_pack(database)
        for card in pack:
            collection[card] = collection[card] + 1
            collection_set.add(card)
    return collection

def main():
    database = make_database("data/pokemon_cards.csv")
    #print(database)
    print("Cards in database :", str(len(database)))

    print("Cards in pack:")
    pack = make_pack(database)
    for i in pack:
        print("\t",i)

    #print(build_basic_collection(database))
    count = 0
    num = 1000
    for i in range(num):
        count += build_basic_collection(database)
    print("Average is :", str(count/num))

    print("Cards purchased to complete set:")
    collection = build_counting_collection(database)
    total = 0
    key_of_most = 0
    for i in collection.keys():
        num_pulled = collection[i]
        total += num_pulled
        try:
            if num_pulled > collection[key_of_most]:
                key_of_most = i
        except:
            key_of_most = i
        print("\t", i, ":", num_pulled)
    print("Most :", key_of_most, "=", collection[key_of_most])
    print("Total:", total)


if __name__ == "__main__":
    main()