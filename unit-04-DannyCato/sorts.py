def shift(a_list, index):
    if index >= 0:
        target = a_list[index]
        while index > 0 and a_list[index - 1] > target:
            a_list[index] = a_list[index - 1]
            index -= 1
        a_list[index] = target
    return a_list

def insertion_sort(a_list):
    for i in range(len(a_list)):
        shift(a_list, i)
    return a_list

def split(a_list):
    mid = len(a_list) // 2
    return a_list[:mid], a_list[mid:]

def merge(left, right):
    merged = []
    i1 = 0
    i2 = 0
    len1 = len(left)
    len2 = len(right)
    while i1 < len1 and i2 < len2:
        if left[i1] <= right[i2]:
            merged.append(left[i1])
            i1 += 1
        else:
            merged.append(right[i2])
            i2 += 1
    if i1 < len1:
        merged = merged + left[i1:]
    else:
        merged = merged + right[i2:]
    return merged

def merge_sort(an_array):
    if len(an_array) == 1:
        return an_array
    else:
        left,right = split(an_array)
        sorted_right = merge_sort(right)
        sorted_left = merge_sort(left)
        return merge(sorted_right,sorted_left)
    
def partition(pivot, arr):
    less = list()
    more = list()
    same = list()
    for i in arr:
        if i == pivot:
            same.append(i)
        elif i < pivot:
            less.append(i)
        else:
            more.append(i)
    return less,same,more
    
def quicksort(arr):
    if len(arr) <= 1:
        return arr
    else:
        pivot = arr[0]
        less,same,more = partition(pivot, arr)
        sorted_less = quicksort(less)
        sorted_more = quicksort(more)
        return sorted_less + same + sorted_more


def main():
    array = [1,2,3,4,5]
    array2 = array.copy()
    array3 = merge(array,array2)
    print(array3)

if __name__ == "__main__":
    main()