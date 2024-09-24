def make_2d_board(filename):
    '''
        Returns a 2D array out of a file that contains a sudoku match\n
        Inputs:\n
        \tfilename = takes a .sud file or a .txt file that is correctly filled
    '''
    '''
    try:
        answer = ""
        with open(filename) as file:
            for line in file:
                line = line.strip()
                for i in line:
                    int(i)
                    answer = answer + "[" + i + "]"
                answer = answer + "\n"
            return answer.strip()
    except:
        return None
    '''
    try:
        answer = []
        with open(filename) as file:
            for line in file:
                line = line.strip()
                int(line)
                fill_list = []
                for i in line:
                    fill_list.append(i)
                answer.append(fill_list)
            return answer
    except:
        return None
    
def print_board(board, check_col=-1, check_row=-1):
    '''
        Prints a nicely formatted baord with correct spacing and colors for if an error is found\n
        Inputs:\n
            \tboard = takes in a board as a 2d array
    '''
    row_count = 0
    for row in board: #print board
        col_count = 0
        print()
        if row_count != 0 and row_count % 3 == 0: # adds horizontal space
            print()

        for item in row: # fills rows
            if col_count != 0 and col_count % 3 == 0: # adds vertical spaces
                print(" ", end="")
            color = "\033[37m"
            if row_count == check_row and col_count == check_col:
                color = "\033[31m"
            print(color, "[" + item + "]", sep="", end="") # makes the [i] and adds it to the string to be printed
            col_count += 1

        row_count += 1
    print()

def validate_board(board):
    '''
        Returns if the board is a valid solution by looking at all rows, then all columns, and then all squares\n
        \tif the board is not valid, then it will call print_board at the incorrect index and return false, otherwise return True\n
        Inputs:\n
            \tboard = 2d array of a sudoku board
    '''
    # rows
    row_count = 0
    for row in board:
        new_row_set = set()
        col_count = 0

        for item in row:
            int(item)
            if item in new_row_set:
                print_board(board, col_count, row_count)
                return False
            new_row_set.add(item)
            col_count += 1
        row_count += 1
        #print(new_row_set)
        
    # columns
    col_count = 0
    for col in range(len(board)):
        new_row_set = set()
        row_count = 0

        for row in range(len(board[col])):
            item = board[row][col]
            int(item)
            if item in new_row_set:
                print_board(board, col, row)
                return False
            new_row_set.add(item)

    # squares
    for square in range(9):
        shift_horizontal = 0
        shift_vertical = 0
        new_set = set()
        for index in range(9):
            item = board[index // 3 + shift_vertical][index % 3 + shift_horizontal]
            int(item)
            if item in new_set:
                print_board(board, col, row)
                return False
            new_set.add(item)

            
    return True

def check_game(filename):
    '''
        Helper function to clean up the for loops in main\n
        Inputs:\n
        \tfilename = a .sud file that is formatted correctly
    '''
    current_board = make_2d_board(filename)
    if current_board == None:
        return None
    return validate_board(current_board)

def main():
    '''
    thing = make_2d_board("sud/valid_001.sud")
    #print(thing)
    #print(make_2d_board(""))
    print_board(thing)
    print(validate_board(thing))

    col_wrong = make_2d_board("sud/invalid_002.sud")
    print_board(col_wrong)
    print()
    print(validate_board(col_wrong))

    square_wrong = make_2d_board("sud/invalid_001.sud")
    print_board(square_wrong)
    print()
    print(validate_board(square_wrong))
    '''
    for i in range(1,7): #invalid files
        file = "invalid_00" + str(i) + ".sud"
        local_path = "sud/" + file
        print(file, check_game(local_path))

    for i in range(1,11): #valid files
        file = "valid_00" + str(i) + ".sud"
        local_path = "sud/" + file
        print(file, check_game(local_path))
        


if __name__ == "__main__":
    main()