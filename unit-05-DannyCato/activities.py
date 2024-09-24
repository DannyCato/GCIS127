import random
import math
import re

def square(x):
    return x * x

def double(x):
    return x * 2

def negate(x):
    return x * -1

def apply_transforamtion(a_list, transform):
    for i in range(len(a_list)):
        a_list[i] = transform(a_list[i])
    return a_list

def unique_list(a_list, value):
    for i in a_list:
        if i == value:
            return a_list
        else:
            a_list.append(value)

def fill_list(length):
    new_list = list()
    for i in range(length):
        unique_list(new_list, i)
    return new_list

def sets():
    set1 = {1,2,42,4}
    print(set1)
    set1.add(6)
    set1.add(10)
    print(set1)
    print(set("1,2,3,4,5,6,6"))

def unique_set(a_set, value):
    if value not in a_set:
        a_set.add(value)
    return a_set

def fill_set(length):
    new_set = set()
    for i in range(length):
        unique_set(new_set, i)
    #return new_set

def coupon_collector(n):
    coupon_iterations = 0
    num_of_coupons = 0
    coupons = set()
    while(True):
        i = random.randint(0,n)
        if i not in coupons:
            coupons.add(i)
            num_of_coupons += 1
        if num_of_coupons == n:
            return coupon_iterations
        coupon_iterations += 1

def mixup(string):
    a_set = set(string)
    for thing in a_set:
        print(thing, end=" ")
    print()

def unique_words(filename):
    unique_words = set()
    with open(filename) as book:
        for line in book:
            line = line.lower()
            line = re.findall("\w+", line)
            for word in line:
                if word not in unique_words:
                    unique_words.add(word)
                else:
                    continue
    return unique_words

def superset(a_set, b_set):
    for i in b_set:
        if i not in a_set:
            return False
    return True

def subset(a_set, b_set):
    for i in a_set:
        if i not in b_set:
            return False
    return True

def intersection(a_set, b_set):
    set3 = set()
    used_set = max(a_set, b_set, key=len) # used to find which set is longer
    for i in used_set:
        if i in a_set and i in b_set:
            set3.add(i)
    return set3

def union(a_set, b_set):
    set3 = set()
    for i in a_set:
        if i not in set3:
            set3.add(i)
    for i in b_set:
        if i not in set3:
            set3.add(i)
    return set3

def minus(a_set, b_set):
    new_set = a_set.copy()
    for i in new_set:
        if i in b_set:
            a_set.remove(i)
    return a_set

def names():
    a_dict = dict()
    a_dict["D"] = "Danny"
    a_dict["G"] = "Giorgio"
    a_dict["C"] = "Catorcini"

    a_dict["M"] = "Miheila"
    a_dict["C"] = "Cristina"
    a_dict["C"] = "Cris"

    print(a_dict["D"])
    print(a_dict["G"])
    print(a_dict["C"])
    print(a_dict["M"])

    print(a_dict)

def print_dict(dictionary):
    for key in dictionary:
        value = dictionary[key]
        print(str(key) + ": " + str(value))

def find_maximum(dictionary):
    max = 0
    for key in dictionary:
        if max < dictionary[key]:
            max = dictionary[key]
    return max

def count_words(filename):
    instances = dict()
    with open(filename) as file:
        for line in file:
            line = line.lower()
            line = re.findall("\w+", line)
            for word in line:
                if word in instances:
                    instances[word] = instances[word] + 1
                else:
                    instances[word] = 1
    return instances

def hashes():
    str1 = "hello world"
    str2 = "hello World"

    print(hash(str1))
    print(hash(str2))
    print(hash("A"*100000))
    #print(hash("A"*10000000000)) # commented for speed

def collisions(filename, length, hash_func=hash):
    new_list = [None for _ in range(length)]
    #print(new_list)
    with open(filename) as file:
        count = 0
        for line in file:
            line = line.strip()
            if line == "":
                continue
            line_hash = hash_func(line)
            check_index = line_hash % length
            if new_list[check_index] == None:
                new_list[check_index] = line_hash
            else:
                return count
            count += 1

def main():
    list_original = [1,2,3]
    list1 = list(list_original)
    list2 = list(list_original)
    list3 = list(list_original)
    list4 = list(list_original)

    print(apply_transforamtion(list1, square))
    print(apply_transforamtion(list2, double))
    print(apply_transforamtion(list3, negate))

    sets()

    num = 10000
    print(str(num * math.log(num) + 0.57721566 * num))
    print(coupon_collector(10000)) # decently close

    mixup("1,2,3,4,5,6,7,7")
    mixup("What,do,you,mean")
    string = ""
    for i in range(1000):
        string = string + str(i) + ","
    mixup(string)

    print(unique_words("data/alice.txt"))

    set1 = {1,2,3,4,5,6,7,8,9}
    set2 = {1,2,3,4,5}
    print(superset(set1,set2))
    print(superset(set2,set1))

    print(subset(set1,set2))
    print(subset(set2,set1))

    print(intersection(set1,set2))

    print(union(set1,set2))

    print(minus(set1,set2))

    names() # all things using "C" were overwritten to get "Cris"

    dict1 = dict()
    for i in range(1,16):
        dict1[str(i)] = i
    print_dict(dict1)

    print(find_maximum(dict1))

    word_count = count_words("data/alice.txt")
    print(word_count)
    print(find_maximum(word_count))

    hashes()

    print(collisions("data/alice.txt", 1060))

if __name__ == "__main__":
    main()