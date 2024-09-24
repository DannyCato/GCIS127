def absolute_difference(number1, number2):
    answer = number1 - number2
    if answer > 0:
        return answer
    else:
        return answer * -1
    
def pi_tester():
    iterations = 0
    digits_of_pi = "3 1 4 1 5 9 2 6 5 3 5 8 9 7 9 3 2 3 8 4 6 2 6 4 3 3 8 3 2 7 9 5 0 2 8 8 4 1 9 7 1 6 9 3 9 9 3 7 5 1 0 5 8 2 0 9 7 4 9 4 4 5 9 2 3 0 7 8 1 6 4 0 6 2 8 6 2 0 8 9 9 8 6 2 8 0 3 4 8 2 5 3 4 2 1 1 7 0 6 7 9".split(" ")
    while (iterations < 100):
        answer = input("Enter the next digit: ")
        if int(answer) != int(digits_of_pi[iterations]):
            return iterations
        else:
            iterations = iterations + 1
    return iterations

def main():
    print("Score =", pi_tester())

if __name__ == "__main__":
    main()