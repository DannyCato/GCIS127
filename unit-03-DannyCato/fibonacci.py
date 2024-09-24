import time
import plotter

def fibonacci_naive(n):
    if n <= 0:
        return None
    elif n == 1:
        return 0
    elif n == 2:
        return 1
    else:
        return fibonacci_naive(n-1) + fibonacci_naive(n-2)

def naive_timer(n):
    for i in range(n):
        start = time.perf_counter()
        fibonacci_naive(i)
        plotter.add_data_point(time.perf_counter() - start)
        
def fibonacci_fast(n, fn_minus_1=1, fn_minus_2=0):
    '''
    Slightly edited version of this code:
    https://stackoverflow.com/a/13826877
    '''

    if n < 0:
        return None
    elif n == 0:
        return fn_minus_2
    else:
        return fibonacci_fast(n - 1, fn_minus_1 + fn_minus_2, fn_minus_1)
    
def fast_timer(n):
    for i in range(n):
        start = time.perf_counter()
        fibonacci_fast(i)
        plotter.add_data_point(time.perf_counter() - start)

def fibonacci_my_way(n):
    if n <= 0:
        return None
    elif n == 1:
        return 0
    elif n == 2:
        return 1
    else:
        num0 = 0
        num1 = 1
        sum = 0
        for i in range(n - 2):
            sum = num0 + num1
            num0 = num1
            num1 = sum
    return sum

def MW_timer(n):
    for i in range(n):
        start = time.perf_counter()
        fibonacci_my_way(i)
        plotter.add_data_point(time.perf_counter() - start)

def main():
    #naive
    plotter.init("fibonacci_naive", "n", "Time")
    plotter.new_series("Naive")
    naive_timer(int(input("Enter a value (<40): ")))
    plotter.plot()

    #fast
    plotter.init("fibonacci_fast", "n", "Time")
    plotter.new_series("Fast")
    fast_timer(int(input("Enter a value: ")))
    plotter.plot()

    #both
    plotter.init("Fibonacci", "n", "Time")
    plotter.new_series("Naive")
    n = int(input("Enter a value (<40): "))
    naive_timer(n)
    plotter.new_series("Fast")
    fast_timer(n)
    plotter.plot()

    #curiousity of iterative vs recursive
    plotter.init("Fibonacci", "n", "Time")
    plotter.new_series("Iterative")
    n = int(input("Enter a value (<40): "))
    naive_timer(n)
    plotter.new_series("Naive")
    naive_timer(n)
    plotter.new_series("Fast")
    fast_timer(n)
    plotter.plot()



    '''
    Old code that i was using during testing
    #print(fibonacci_naive(15))
    #print(fibonacci_my_way(15))
    #print(fibonacci_fast(15))
    plotter.init("Fibonacci", "n", "Time")
    plotter.new_series("Naive")
    naive_timer(30)
    plotter.new_series("Fast")
    fast_timer(30)
    plotter.plot()
    '''

if __name__ == "__main__":
    main()