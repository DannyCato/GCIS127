import list_utils as lu

def linear_search(a_list, target):
    index = 0
    for i in a_list:
        if i == target:
            return index
        else:
            index = index + 1
            continue
    return None

def binary_search(a_list, target, start=0, end=None):
    if end == None:
        end = len(a_list)
    if start > end or target == None:
        return None
    
    mid = (start + end) // 2
    if (target == a_list[mid]):
        return mid
    elif (a_list[mid] < target):
        return binary_search(a_list, target, mid + 1, end)
    else:
        return binary_search(a_list, target, start, mid - 1)


def main():
    '''
    list = lu.range_list(1,100)
    print(linear_search(list,1))
    print(linear_search(list,50))
    print(linear_search(list,100))
    print(linear_search(list,101))
    '''
    print(binary_search([1, 3, 5, 7, 9, 11, 13], 7))
    print(binary_search([1, 3, 5, 7, 9, 11, 13], 11))

if __name__ == "__main__":
    main()