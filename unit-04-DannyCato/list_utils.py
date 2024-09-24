"""
Provides simple untility functions for creating lists.

@author GCCIS Faculty
"""
import random

def random_list(size, min_value=0, max_value=None):
    """
    Creates and returns a list of random values in the range 
    [min_value, max_value]. 
    """
    a_list = []
    if max_value is None:
        max_value = size
    for i in range(size):
        random_number = random.randint(min_value, max_value)
        a_list.append(random_number)
    return a_list

def range_list(start, stop, step=1):
    """
    Creates a list from a range of values.
    """
    a_list = []
    for i in range(start, stop, step):
        a_list.append(i)
    return a_list

def main():
    """
    Tests the utilities and prints the results to standard output.
    """
    random.seed(1)
    print(random_list(10))
    print(range_list(0, 10, 1))
    print(range_list(100, 200, 10))
    print(range_list(1000, 10000, 115))

if __name__ == "__main__":
    main()