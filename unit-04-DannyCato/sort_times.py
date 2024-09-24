import sorts as s
import time as t
import plotter as p
import list_utils as lu
import math as m
import sys

SIZES = (200,500,800,1100,1400,1700,2000)

def insertion_sort_function_timer(a_list):
    start = t.perf_counter()
    s.insertion_sort(a_list)
    return t.perf_counter() - start

def sort_function_timer(sort_function, a_list):
    '''
        Returns how long it takes to sort a list\n
        Inputs:\n
        \tsort_function = any of the names of the implemented sorts in sorts.py as a string\n
        \ta_list = a list of numbers
    '''
    start = t.perf_counter()
    if sort_function.__name__ == s.insertion_sort.__name__:
        sort_function(a_list)
    elif sort_function.__name__ == s.quicksort.__name__:
        sort_function(a_list)
    elif sort_function.__name__ == s.merge_sort.__name__:
        sort_function(a_list)
        #print("hi!")
    elif sort_function.__name__ == quick_insertion_sort.__name__:
        sort_function(a_list, len(a_list))
    return t.perf_counter() - start

def plot_sort_time_using_random_lists(sort_function):
    '''
        Returns the time it takes to sort a randomized list\n
        Inputs:\n
        \tsort_function = Any of the sorts in sorts.py
    '''
    print("timing", sort_function.__name__)
    p.new_series(sort_function.__name__)
    for i in SIZES:
        time = sort_function_timer(sort_function, lu.random_list(i))
        p.add_data_point(time)

def plot_sort_time_using_sorted_lists(sort_function):
    '''
        Returns the time it takes to sort a sorted list\n
        Inputs:\n
        \tsort_function = Any of the sorts in sorts.py
    '''
    print("timing", sort_function.__name__)
    p.new_series(sort_function.__name__)
    
    for i in SIZES:
        # print(lu.range_list(0,i))
        time = sort_function_timer(sort_function, lu.range_list(0,i))
        p.add_data_point(time)

def quick_insertion_sort(arr, size, iterations=0):
        '''
            Returns a sorted list using quicksort in most cases or insertion sort when quicksort slows down
            Inputs:\n
            arr = An array of nubmers
            size = size of the array
            Iterations = number of iterations
        '''
        #print(size * m.log(size, 10), iterations)

        if len(arr) < 2: 
            return arr
        elif len(arr) <= 1:
            return arr
        elif iterations >= 8:
            for i in range(len(arr)):
                s.shift(arr, i)
                #print("hi!")
            return arr
        else:
            pivot = arr[len(arr) // 2]
            less,same,more = s.partition(pivot, arr)
            sorted_less = quick_insertion_sort(less, size, iterations)
            sorted_more = quick_insertion_sort(more, size, iterations)
            return sorted_less + same + sorted_more                   

def main():
    '''
    print("Sorted took: " + str(insertion_sort_function_timer([i for i in range(0,3001)])))
    print("Random took: " + str(insertion_sort_function_timer([lu.random_list(3001,-10000,10000)])))
    print("Reverse Sorted took: " + str(insertion_sort_function_timer([3000 - i for i in range(0,3001)])))
    '''
    sys.setrecursionlimit(int(SIZES[len(SIZES) - 1] * m.log(SIZES[len(SIZES) - 1]))) # set the max recursion into depth to N*log(N) of the max size
    p.init("Sort Functions runtime over number of random elements", "Sort", "Time")
    plot_sort_time_using_random_lists(s.insertion_sort)
    plot_sort_time_using_random_lists(s.quicksort)
    plot_sort_time_using_random_lists(s.merge_sort)
    plot_sort_time_using_random_lists(quick_insertion_sort)
    p.plot()
    input()

    p.init("Sort Functions runtime over number of sorted elements", "Sort", "Time")
    plot_sort_time_using_random_lists(s.insertion_sort)
    plot_sort_time_using_sorted_lists(s.quicksort)
    plot_sort_time_using_sorted_lists(s.merge_sort)
    plot_sort_time_using_sorted_lists(quick_insertion_sort)
    p.plot()
    input()

if __name__ == "__main__":
    main()