import calculator


def test_add():
    # setup
    x1 = 4
    y1 = 2
    expected_sum1 = "4 + 2 = 6"

    x2 = 7
    y2 = 13
    expected_sum2 = "7 + 13 = 20"
    
    x3 = 45
    y3 = 3
    expected_sum3 = "45 + 3 = 48"

    x4 = 100
    y4 = -5
    expected_sum4 = "100 + -5 = 95"


    # invoke
    actual_sum1 = calculator.add(x1, y1)
    actual_sum2 = calculator.add(x2, y2)
    actual_sum3 = calculator.add(x3, y3)
    actual_sum4 = calculator.add(x4, y4)

    # analyze
    assert expected_sum1 == actual_sum1
    assert expected_sum2 == actual_sum2
    assert expected_sum3 == actual_sum3
    assert expected_sum4 == actual_sum4

def test_subtract():
    # setup
    x1 = 4
    y1 = 2
    expected_subtract1 = "4 - 2 = 2"

    x2 = 7
    y2 = 13
    expected_subtract2 = "7 - 13 = -6"
    
    x3 = 45
    y3 = 3
    expected_subtract3 = "45 - 3 = 42"

    x4 = 100
    y4 = -5
    expected_subtract4 = "100 - -5 = 105"


    # invoke
    actual_subtract1 = calculator.subtract(x1, y1)
    actual_subtract2 = calculator.subtract(x2, y2)
    actual_subtract3 = calculator.subtract(x3, y3)
    actual_subtract4 = calculator.subtract(x4, y4)

    # analyze
    assert expected_subtract1 == actual_subtract1
    assert expected_subtract2 == actual_subtract2
    assert expected_subtract3 == actual_subtract3
    assert expected_subtract4 == actual_subtract4

def test_multiply():
    # setup
    x1 = 4
    y1 = 2
    expected_product1 = "4 * 2 = 8"

    x2 = 7
    y2 = 13
    expected_product2 = "7 * 13 = 91"
    
    x3 = 45
    y3 = 3
    expected_product3 = "45 * 3 = 135"

    x4 = 100
    y4 = -5
    expected_product4 = "100 * -5 = -500"


    # invoke
    actual_product1 = calculator.multiply(x1, y1)
    actual_product2 = calculator.multiply(x2, y2)
    actual_product3 = calculator.multiply(x3, y3)
    actual_product4 = calculator.multiply(x4, y4)

    # analyze
    assert expected_product1 == actual_product1
    assert expected_product2 == actual_product2
    assert expected_product3 == actual_product3
    assert expected_product4 == actual_product4

def test_divide():
    # setup
    x1 = 4
    y1 = 2
    expected_quotient1 = "4 / 2 = 2.0"

    x2 = 25
    y2 = 5
    expected_quotient2 = "25 / 5 = 5.0"
    
    x3 = 45
    y3 = 3
    expected_quotient3 = "45 / 3 = 15.0"

    x4 = 100
    y4 = -5
    expected_quotient4 = "100 / -5 = -20.0"
    
    x5 = 100
    y5 = 0
    expected_quotient5 = "100 / 0 = NaN"


    # invoke
    actual_quotient1 = calculator.divide(x1, y1)
    actual_quotient2 = calculator.divide(x2, y2)
    actual_quotient3 = calculator.divide(x3, y3)
    actual_quotient4 = calculator.divide(x4, y4)
    actual_quotient5 = calculator.divide(x5, y5)

    # analyze
    assert expected_quotient1 == actual_quotient1
    assert expected_quotient2 == actual_quotient2
    assert expected_quotient3 == actual_quotient3
    assert expected_quotient4 == actual_quotient4
    assert expected_quotient5 == actual_quotient5

def test_exponent():
    # setup
    x1 = 4
    y1 = 2
    expected_exponent1 = "4 ^ 2 = 16.0"

    x2 = 7
    y2 = 13
    expected_exponent2 = "7 ^ 13 = 96889010407.0"
    
    x3 = 45
    y3 = 3
    expected_exponent3 = "45 ^ 3 = 91125.0"

    x4 = 100
    y4 = 5
    expected_exponent4 = "100 ^ 5 = 10000000000.0"


    # invoke
    actual_exponent1 = calculator.exponent(x1, y1)
    actual_exponent2 = calculator.exponent(x2, y2)
    actual_exponent3 = calculator.exponent(x3, y3)
    actual_exponent4 = calculator.exponent(x4, y4)

    # analyze
    assert expected_exponent1 == actual_exponent1
    assert expected_exponent2 == actual_exponent2
    assert expected_exponent3 == actual_exponent3
    assert expected_exponent4 == actual_exponent4