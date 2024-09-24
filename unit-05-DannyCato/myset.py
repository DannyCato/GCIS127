def make_myset(length, hash_func=hash):
    table = [[] for _ in range(length)]
    return (hash_func, table)

def add(myset, element):
    element.myset[0]