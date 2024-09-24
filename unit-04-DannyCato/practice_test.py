import practice

def test_power():
    # invoke
    Base1 = 5
    Exponent1 = -1
    Expected1 = None

    Base2 = 5
    Exponent2 = 0
    Expected2 = 1

    Base3 = 5
    Exponent3 = 1
    Expected3 = 5

    Base4 = 4
    Exponent4 = 7
    Expected4 = 16384

    Base5 = 4
    Exponent5 = 4
    Expected5 = 256

    # test
    Actual1 = practice.power(Base1, Exponent1)
    Actual2 = practice.power(Base2, Exponent2)
    Actual3 = practice.power(Base3, Exponent3)
    Actual4 = practice.power(Base4, Exponent4)
    Actual5 = practice.power(Base5, Exponent5)

    # analyze
    assert Expected1 == Actual1
    assert Expected2 == Actual2
    assert Expected3 == Actual3
    assert Expected4 == Actual4
    assert Expected5 == Actual5