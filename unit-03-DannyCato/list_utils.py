import random

def random_list(size, min_value=0, max_value= None):
    list = []
    for i in range(size):
        if max_value == None:
            list.append(random.randint(min_value, size))
        else:
            list.append(random.randint(min_value, max_value))
    return list
    

def range_list(start, stop, step=1):
    list = []
    count = start
    while (count <= stop):
        list.append(count)
        count = count + step
    print(list)
    return list

def main():
    print(random_list(10))
    range_list(0, 10)

if __name__ == "__main__":
    main()