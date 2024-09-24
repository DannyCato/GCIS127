import csv
import sys

def sort(a_list):
    sys.path.insert(0, "../unit-04-DannyCato/sorts.py")


def number_holes(a_list):
    set_from_list = set()
    
    for i in a_list:
        try:
            i = int(i)
            set_from_list.add(i)
        except:
            continue
    
    for i in range(1,len(set_from_list)):
        if i not in set_from_list:
            print("Hole at",i)
        


def get_nums(csv_filename):
    return_list = list()
    with open(csv_filename) as csv_file:
        file = csv.reader(csv_file)
        next(file)
        for line in file:
            return_list.append(line[1])
    return return_list

def main():
    nums = get_nums("data/pokemon_cards.csv")
    print(nums)
    number_holes(nums)

main()