def tuples(a_tuple):
    length = len(a_tuple)
    print(length)
    print(a_tuple)
    for i in range(length):
        print(i)

def scale(a_list, scalar):
    for index in range(len(a_list)):
        a_list[index] *= scalar
    return a_list

def cat(a_list, b_list):
    return a_list + b_list

def extender(a_list, b_list):
    a_list += b_list
    return a_list

def inserter(a_list, value):
    mid = len(a_list) // 2
    a_list = a_list.insert(mid, value)
    return a_list

def popper(a_list):
    for i in range(len(a_list)):
        num = a_list[0]
        a_list.pop(0)
        print(a_list, num)

def tuple_equality(tuple_1, tuple_2):
    answer1 = tuple_1 is tuple_2
    print(answer1)
    answer2 = tuple_1 == tuple_2
    print(answer2)

def swapper(a_list):
    midpoint = len(a_list) // 2
    half_1 = a_list[:midpoint]
    half_2 = a_list[midpoint:]
    return half_2 + half_1

def comprehension():
    foobar = [i for i in "foobar"]
    zero = [0 for _ in range(15)]
    integers = [i for i in range(0, 12)]
    even = [i for i in range(0,20) if i % 2 == 0]
    Div = [i for i in range(0,50) if i % 3 == 0 or i % 5 == 0]
    print(foobar, zero, integers, even, Div, sep="\n")

def make_table(rows, columns, value=0):
    '''
    table = []
    for i in range(rows):
        row = []
        for i in range(columns):
            row.append(value)
        table.append(row)
    '''
    table = [[value for _ in range(columns)] for _ in range(rows)]

    return table


def main():
    x = ("a","a","b","b")
    y = (1,2,3,4)
    list1 = [1,2,3,4,5]
    list2 = ["a","b","c"]
    list3 = [1.1,2.2,3.3,4.4,5.5]
    tuples(x)
    tuples(y)
    print(scale(list1, 3))
    print(scale(list3, 0.5))
    print(cat(list1, list3))
    print(cat(list1, list2))
    print(extender(list1, list3))
    print(extender(list1, list2))
    print(inserter(list1, 10))
    print(inserter(list2, 10))
    popper(list1)
    popper(list2)
    list4 = ["one", True, 1, 1.3]
    a = tuple(list4)
    b = tuple(list4)
    c = (True, 1, 1.3, "one")
    tuple_equality(a,a)
    tuple_equality(a,b)
    tuple_equality(a,c)

    print(swapper([]))
    print(swapper([1]))
    print(swapper([1,2,3]))
    print(swapper([0,1,2,3,4,5,6,7,8,9]))

    comprehension()
    
    print(make_table(3,3))
    
if __name__ == "__main__":
    main()

