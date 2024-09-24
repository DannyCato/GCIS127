import random

def literal_list():
    return [1.24, "adv", 'a', 13, False]
    
def sequence_list(sequence):
    return list(sequence)

def print_list(a_list):
    for i in a_list:
        print(i)

def append_to_list(sequence):
    a_list = []
    for i in sequence:
        a_list.append(i)
        print(a_list)
    return a_list

def roll_the_dice(sides):
    number = random.randint(1, sides)
    return str(number)
    
def countdown(n, sum=0):
    print(str(n))
    if n == 0: # base case
        print("Sum of all values is: " + str(sum))
    else: # recursive case
        countdown(int(n - 1), n + sum)

def factorial(N):
    if N < 0:
        return None
    elif N == 0 or N == 1:
        return 1
    elif N > 1:
        return N * factorial(N - 1)
        

def main():
    
    print_list(literal_list())
    print_list(sequence_list([1,3,2,4]))
    append_to_list(range(1,10))
    for i in range(1,10):
        print(roll_the_dice(6))
    
    countdown(6)
    print(factorial(10))
    print(factorial(100))
    #print(factorial(2000)) # does not recurse far enough
    

if __name__ == "__main__":
    main()
    