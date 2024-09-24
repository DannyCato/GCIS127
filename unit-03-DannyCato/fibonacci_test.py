import fibonacci

def test_fibonacci_naive():
    returned1 = fibonacci.fibonacci_naive(9)
    returned2 = fibonacci.fibonacci_naive(10)
    returned3 = fibonacci.fibonacci_naive(4)
    returned4 = fibonacci.fibonacci_naive(15)
    returned5 = fibonacci.fibonacci_naive(-2)
    returned6 = fibonacci.fibonacci_naive(1)
    returned7 = fibonacci.fibonacci_naive(2)

    assert returned1 == 21
    assert returned2 == 34
    assert returned3 == 2
    assert returned4 == 377 
    assert returned5 == None
    assert returned6 == 0
    assert returned7 == 1

def test_fibonacci_fast():
    returned1 = fibonacci.fibonacci_naive(9)
    returned2 = fibonacci.fibonacci_naive(10)
    returned3 = fibonacci.fibonacci_naive(4)
    returned4 = fibonacci.fibonacci_naive(15)
    returned5 = fibonacci.fibonacci_naive(-2)
    returned6 = fibonacci.fibonacci_naive(1)
    returned7 = fibonacci.fibonacci_naive(2)

    assert returned1 == 21
    assert returned2 == 34
    assert returned3 == 2
    assert returned4 == 377 
    assert returned5 == None
    assert returned6 == 0
    assert returned7 == 1
