import sorts
import random as ra

def test_shift1():
    #invoke
    a_list = [103,131,132,134,45,134,542]
    test_list = list(a_list)
    index = 4
    #test
    returned = sorts.shift(test_list,index)
    #analyze
    assert a_list[0] == returned[1]
    assert a_list[1] == returned[2]
    assert a_list[2] == returned[3]
    assert a_list[3] == returned[4]
    assert a_list[4] == returned[0]
    assert a_list[5] == returned[5]
    assert a_list[6] == returned[6]

def test_shift2():
    #invoke
    a_list = [4365457,434,647,53646,6,32534,7534]
    test_list = list(a_list)
    index = 4
    #test
    returned = sorts.shift(test_list,index)
    #analyze
    assert a_list[0] == returned[1]
    assert a_list[1] == returned[2]
    assert a_list[2] == returned[3]
    assert a_list[3] == returned[4]
    assert a_list[4] == returned[0]
    assert a_list[5] == returned[5]
    assert a_list[6] == returned[6]

def test_shift3():
    #invoke
    a_list = [1,2,3,4,5,6,7]
    test_list = list(a_list)
    index = 4
    #test
    returned = sorts.shift(test_list,index)
    #analyze
    assert a_list[0] == returned[0]
    assert a_list[1] == returned[1]
    assert a_list[2] == returned[2]
    assert a_list[3] == returned[3]
    assert a_list[4] == returned[4]
    assert a_list[5] == returned[5]
    assert a_list[6] == returned[6]

def test_insertion_sort1():
    a_list = [2346,3453,635,634,545634,5346345,3,375,345,53]
    test_list = list(a_list)

    returned = sorts.insertion_sort(test_list)

    assert returned[0] == 3
    assert returned[1] == 53
    assert returned[2] == 345
    assert returned[3] == 375
    assert returned[4] == 634
    assert returned[5] == 635
    assert returned[6] == 2346
    assert returned[7] == 3453
    assert returned[8] == 545634
    assert returned[9] == 5346345

def test_insertion_sort2():
    a_list = [i for i in range(0,10)]
    test_list = list(a_list)

    returned = sorts.insertion_sort(test_list)

    for i in range(len(a_list)):
        assert returned[i] == i

def test_insertion_sort3():
    a_list = [10 - i for i in range(0,10)]
    test_list = list(a_list)

    returned = sorts.insertion_sort(test_list)

    for i in range(len(a_list)):
        assert returned[i] == i + 1
    
def test_split_even():
    test_list = [i for i in range(1,10)]

    answer1, answer2 = sorts.split(test_list)

    for i in range(len(answer1)):
        assert answer1[i] == i + 1

    for i in range(len(answer2)):
        assert answer2[i] == i + 5

def test_split_odd():
    test_list = [i for i in range(1,9)]

    answer1, answer2 = sorts.split(test_list)

    for i in range(len(answer1)):
        assert answer1[i] == i + 1

    for i in range(len(answer2)):
        assert answer2[i] == i + 5

def test_split_empty():
    test_list = []

    answer1, answer2 = sorts.split(test_list)

    assert answer1 == []

    assert answer2 == []

def test_split_one():
    test_list = [1]

    answer1, answer2 = sorts.split(test_list)

    assert answer1 == []

    assert answer2 == [1]

def test_merge_two_of_one():
    answer1 = sorts.merge([1],[2])

    assert 1 == answer1[0]
    assert 2 == answer1[1]

def test_merge_two_of_two():
    answer1 = sorts.merge([1,2],[3,4])

    assert 1 == answer1[0]
    assert 2 == answer1[1]
    assert 3 == answer1[2]
    assert 4 == answer1[3]

def test_merge_two_of_n():
    answer1 = sorts.merge([1,2,3,4,5],[6,7,8,9])

    assert 1 == answer1[0]
    assert 2 == answer1[1]
    assert 3 == answer1[2]
    assert 4 == answer1[3]
    assert 5 == answer1[4]
    assert 6 == answer1[5]
    assert 7 == answer1[6]
    assert 8 == answer1[7]
    assert 9 == answer1[8]

def test_merge_left_copy():
    array = [1,2,3,4,5]
    array2 = array.copy()

    answer1 = sorts.merge(array,array2)

    assert 1 == answer1[0]
    assert 1 == answer1[1]
    assert 2 == answer1[2]
    assert 2 == answer1[3]
    assert 3 == answer1[4]
    assert 3 == answer1[5]
    assert 4 == answer1[6]
    assert 4 == answer1[7]
    assert 5 == answer1[8]
    assert 5 == answer1[9]

def test_merge_right_copy():
    array = [1,2,3,4,5]
    array2 = array.copy()

    answer1 = sorts.merge(array2,array)

    assert 1 == answer1[0]
    assert 1 == answer1[1]
    assert 2 == answer1[2]
    assert 2 == answer1[3]
    assert 3 == answer1[4]
    assert 3 == answer1[5]
    assert 4 == answer1[6]
    assert 4 == answer1[7]
    assert 5 == answer1[8]
    assert 5 == answer1[9]

def test_merge_sort_two():
    array = sorts.merge_sort([3,2])

    assert 2 == array[0]
    assert 3 == array[1]

def test_merge_sort_three():
    array = sorts.merge_sort([3,2,8])

    assert 2 == array[0]
    assert 3 == array[1]
    assert 8 == array[2]

def test_merge_sort_four():
    array = sorts.merge_sort([3,2,8,1000])

    assert 2 == array[0]
    assert 3 == array[1]
    assert 8 == array[2]
    assert 1000 == array[3]

def test_partition_all_three():
    less,same,more = sorts.partition(5, [1,10,5])

    assert less[0] == 1
    assert same[0] == 5
    assert more[0] == 10

def test_partition_no_less():
    less,same,more = sorts.partition(5, [10,10,5])

    assert len(less) == 0
    assert len(same) == 1
    assert len(more) == 2

def test_partition_no_more():
    less,same,more = sorts.partition(5, [1,1,5])

    assert len(less) == 2
    assert len(same) == 1
    assert len(more) == 0

def test_quicksort_one():
    answer = sorts.quicksort([1])

    assert answer[0] == 1

def test_quicksort_in_rand():
    array = sorts.quicksort([1,54,342,53,4,24,52,45,2341,534,52])

    last = 0
    for i in array:
        assert i > last

def test_quicksort_in_order():
    array = sorts.quicksort([1,2,3,4,5,6,7,8,9])

    last = 0
    for i in array:
        assert i > last

def test_quicksort_in_reverse():
    array = sorts.quicksort([10,9,8,7,6,5,4,3,2,1])

    last = 0
    for i in array:
        assert i > last