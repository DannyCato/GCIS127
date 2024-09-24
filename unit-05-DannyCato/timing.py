"""
A Python module that provides a timing function that can be used to time how
long it takes to execute some other function.

@author GCCIS Faculty
"""
import time
import activities

def __args_to_string(*args):
    string = "("
    length = len(args)
    if length > 0:
        string += str(args[0])
        for index in range(1, length):
            string +=", " + str(args[index])
    string += ")"
    return string
    


def time_function(function, *args):
    """
    Uses the provided parameters as arguments when executing the given function
    and times how long it takes to execute.

    *args may be zero or more parameters.
    """
    print("timing ", function.__name__, __args_to_string(*args), sep="")
    start = time.perf_counter()
    result = function(*args)
    end = time.perf_counter()
    print("  elapsed time:", (end - start))
    return result

def __test_function(a, b, c):
    """
    An example function that is used to demonstrat the time_function works.
    """
    print(a, b, c)
    return "foobar"

def __main():
    """
    Provides an example of how to use time_function.
    """
    result = time_function(__test_function, "a", 1, False)
    print(result)

    print(time_function(activities.fill_list, 5000))
    print(time_function(activities.fill_list, 10000))
    print(time_function(activities.fill_list, 15000))

    print(time_function(activities.fill_set, 5000))
    print(time_function(activities.fill_set, 10000))
    print(time_function(activities.fill_set, 15000))

if __name__ == "__main__":
    __main()
