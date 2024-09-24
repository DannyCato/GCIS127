import searches

def test_binary_search():
    #invoke
    list1 = [1, 3, 5, 7, 9, 11, 13]
    expected_target1 = 7
    expected_target2 = 11
    expected_target3 = 3
    expected_target4 = None

    #test
    found_target1 = searches.binary_search(list1,expected_target1)
    found_target2 = searches.binary_search(list1,expected_target2)
    found_target3 = searches.binary_search(list1,expected_target3)
    found_target4 = searches.binary_search(list1,expected_target4)

    #analyze
    assert expected_target1 == list1[found_target1]
    assert expected_target2 == list1[found_target2]
    assert expected_target3 == list1[found_target3]
    assert expected_target4 == found_target4
    
