def gcis_sort(a_list):
    '''
    for each index_a in a list:
       for every index_b before (list.length - 1 - index_a):
           if value at index is greater than value at the next index:
               swap value at index with the value at the next index
       if no value was swapped stop sorting (done)
   return the sorted list
   '''
    for index_a in range(len(a_list)):
        for index_b in range(len(a_list) - 1 - index_a ,len(a_list)):
            a = a_list[index_a]
            b = a_list[index_b]
            if a < b:
                a = a_list[index_a]
                a_list[index_a] = b
                a_list[index_b] = a
            
    return a_list

def in_place_reverse(a_list):
    '''
        Linear time
    '''
    length = len(a_list)
    for i in range(length // 2):
        hold_value = a_list[length - 1 - i]
        a_list[length - 1 - i] = a_list[i]
        a_list[i] = hold_value
    return a_list

def make_multiplication_table():
    return [[i*j for j in range(1,11)] for i in range(1,11)]

#(i*j for j in range(10))
def main():
    list1 = [6,5,4,3,2,1]
    print(list1)
    print(gcis_sort(list1))
    
    print() # create space to see prints better

    list2 = [1,2,3,4,5,6]
    print(list2)
    print(in_place_reverse(list2))

    print() # create space to see prints better

    table = make_multiplication_table()
    for line in table:
        print(line)


if __name__ == "__main__":
    main()