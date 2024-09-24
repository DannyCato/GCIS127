import practice

def test_practice():
    #invoke
    x1 = 5
    y1 = 2
    expected1 = 3

    x2 = 1
    y2 = 6
    expected2 = 5

    x3 = 3
    y3 = 2
    expected3 = 1

    #test
    actual1 = practice.absolute_difference(x1,y1)
    actual2 = practice.absolute_difference(x2,y2)
    actual3 = practice.absolute_difference(x3,y3)

    #analyze
    assert expected1 == actual1
    assert expected2 == actual2
    assert expected3 == actual3


def test_pi_tester():
    #invoke
    digits_of_pi = "3 1 4 1 5 9 2 6 5 3 5 8 9 7 9 3 2 3 8 4 6 2 6 4 3 3 8 3 2 7 9 5 0 2 8 8 4 1 9 7 1 6 9 3 9 9 3 7 5 1 0 5 8 2 0 9 7 4 9 4 4 5 9 2 3 0 7 8 1 6 4 0 6 2 8 6 2 0 8 9 9 8 6 2 8 0 3 4 8 2 5 3 4 2 1 1 7 0 6 7 9".split(" ")

    