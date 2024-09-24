import re

def find_rabbit(filename):
    with open(filename) as file:
        count = 0
        for line in file:
            rabbits = re.findall("rabbit", line.lower())
            count = count + len(rabbits)
        return count
    
def power(Base, Exponent):
    if Exponent < 0:
        return None
    elif Exponent == 0:
        return 1
    elif Exponent == 1:
        return Base
    elif Exponent % 2 == 1:
        return Base * power(Base, Exponent // 2) * power(Base, Exponent // 2)
    else:
        return power(Base, Exponent // 2) * power(Base, Exponent // 2)
    

def main():
    print(find_rabbit("data/alice.txt"))
    result = power(4,7)
    print(result)

if __name__ == "__main__":
    main()