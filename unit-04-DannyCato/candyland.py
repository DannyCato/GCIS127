import random as rand
import re

def create_deck():
    '''
    Returns a list of strings for a deck in the game\n
    4 single moves of each color denoted as "S*first letter of color*" (Red, Orange, Yellow, Green, Blue, Purple) \n
    3 double moves of each color denoted as "D*first letter of color*" \n
    1 special card (Peppermint, Peanut, Lollipop, Icecream)
    '''
    Build_list = list()
    Given_list = list()
    for i in range(24): # adding all Single cards to the temporary list
        modulus = i % 6
        if modulus == 0:
            Build_list.append("SR")
        elif modulus == 1:
            Build_list.append("SO")
        elif modulus == 2:
            Build_list.append("SY")
        elif modulus == 3:
            Build_list.append("SG")
        elif modulus == 4:
            Build_list.append("SB")
        elif modulus == 5:
            Build_list.append("SP")
    for i in range(18): # adding all double cards to the temporary list 
        modulus = i % 6
        if modulus == 0:
            Build_list.append("DR")
        elif modulus == 1:
            Build_list.append("DO")
        elif modulus == 2:
            Build_list.append("DY")
        elif modulus == 3:
            Build_list.append("DG")
        elif modulus == 4:
            Build_list.append("DB")
        elif modulus == 5:
            Build_list.append("DP")

    Build_list.append("Peppermint") # adding special cards
    Build_list.append("Peanut")
    Build_list.append("Lollipop")
    Build_list.append("Icecream")

    #print(Build_list) # Checking to make sure list has all required elements
    #print(len(Build_list)) # making sure it's the right length

    while len(Build_list) > 0:
        index = 0
        if len(Build_list) > 0:
            index = rand.randrange(len(Build_list))
        Given_list.append(Build_list[index])
        Build_list.pop(index)

    #print(Given_list)
    #print(len(Given_list))
    return Given_list

def create_board():
    '''
    Returns the board for the game \n
    formatted as: \n
    "*First Letter of Color*" + "*Optional Attribute*" + "*Attribute Parameter*" \n
    or \n
    "*Special Square*"
    '''
    count = 0
    board = list()
    for i in range(83): 
        if i == 20: # checking if its a special square and stops board from pushing a color on that square
            board.append("Peppermint")
            continue
        elif i == 32:
            board.append("Peanut")
            continue
        elif i == 49:
            board.append("Lollipop")
            continue
        elif i == 66:
            board.append("Icecream")
            continue
        elif i == 82:
            board.append("Multi-colored")
            continue

        modulus = count % 6
        if modulus == 0: # adding color if not a special square
            board.append("R")
        elif modulus == 1:
            board.append("P")
        elif modulus == 2:
            board.append("Y")
        elif modulus == 3:
            board.append("B")
        elif modulus == 4:
            board.append("O")
        elif modulus == 5:
            board.append("G")

        if i == 26 or  i == 53: # adding attributes to square
            board[i] += "L"
        elif i == 3:
            board[i] += "S35"
        elif i == 17:
            board[i] += "S24"

        count += 1

    #print(board)
    #for i in range(len(board)):
        #print(board[i], i)
    #print(len(board))
    return board

def take_turn(player, board, deck):
    '''
    Returns the final position of a player as an int \n
    Takes in player of tuple(color, position), board = board, deck = deck 
    '''
    card = deck[0]
    deck.pop(0)
    double = False
    special = False
    if card[0] == "D": # checking if double, single, or special card
        double = True
    elif len(card) > 2:
        special = True

    print("Player", player[0], "drew", card, "\b.")

    if special:
        for i in range(len(board)):
            if board[i] == card:
                return i
    else:
        #print(player[1])
        split = board[player[1]:] # remember to return position
        count = 0
        for i in split:
            num = player[1] + count
            if i[0] != card[1]: # see if card and board color are not equal
                count += 1

            elif double: # see if another loop needs to be done due to double
                double = False
                count += 1
                continue

            elif re.search(card[1],i): # finds the first square that has the card color

                if len(i) < 2: #sees if its a normal square
                    return num
                elif i[1] == "L": # see if its a loss square
                    return num
                elif len(i) > 2: # see if its a skip square
                    print("Player", player[0], "took a shortcut!")
                    return int(re.findall("\d+",i)[0])
                
            if i == "Multi-colored": # checks to see if the player won
                return 82
            
        '''
        old code to see where i was vs where i am
        for i in split:
            if i == "Multi-colored": # checking to see if they reach last square
                return 82
            else:
                if re.search(card[1],i): # finding first sqaure with same color as card
                    if len(split) == 1: # checking for any attributes on square by length
                        return count
                    else: # attributes checking
                        if i[1] == "L":
                            return count
                        elif i[1] == "S":
                            print("Player", player[0], "took a shortcut!")
                            return int(re.findall("\d+",i)[0]) # returns the parameter of the current instruction
                else: # if square is not equal increment count and end
                    count += 1
        '''

def play_game(num_players):
    '''
    Manages actual game on a higher-level match basis \n
    Takes number of players < 11
    '''
    deck = create_deck()
    board = create_board()
    colors = ['Black', 'White', 'Red', 'Green', 'Yellow', 'Blue', 'Brown', 'Orange', 'Pink', 'Purple', 'Grey']
    players = list()
    for i in range(num_players):
        color_index = rand.randrange(len(colors))
        players.append((colors[color_index], 0, True))
        colors.pop(color_index)
        
    total_turns = 0
    while True:
        turn = total_turns % num_players
        player = [players[turn][0],players[turn][1],players[turn][2]]
        card = deck[0]
        positon = take_turn(tuple((player[0],player[1])),board,deck)

        try:
            if not player[2]:
                print("Player",player[0],"has lost a turn")
                player[2] = True
            elif board[positon][1] == "L":
                players[turn] = [players[turn][0],players[turn][1],False]
        finally:
            players[turn] = [players[turn][0], positon, players[turn][2]]
            print("Player ",player[0]," landed on ", board[positon], positon, sep="")

            if positon == 82:
                print("Player",player[0],"wins!")
                break
            total_turns += 1
            continue


def compare(a_list, b_list):
    '''
    Compare two lists of equal length
    '''
    count = 0
    Same = True
    for i in b_list:
        index = a_list[count]
        Bool = i == index
        print(count, index, i, Bool)
        count += 1
        if Bool != Same:
            Same = False
    print(Same)

def main():  
    '''
    Where play_game is ran from
    '''

    '''
    Test code:

    #create_deck()
    #create_board()
    #board = create_board()
    #print(take_turn(tuple("red", 82), board, ["SB"]) # expected 
    #print(take_turn(tuple("red", 82), board, ["SB"])
    b_list = ['R', 'P', 'Y', 'BS35', 'O', 'G', 'R', 'P', 'Y', 'B', 'O', 'G', 'R', 
              'P', 'Y', 'B', 'O', 'GS24', 'R', 'P', 'Peppermint', 'Y', 'B', 'O', 
              'G', 'R', 'PL', 'Y', 'B', 'O', 'G', 'R', 'Peanut', 'P', 'Y', 'B', 
              'O', 'G', 'R', 'P', 'Y', 'B', 'O', 'G', 'R', 'P', 'Y', 'B', 'O', 
              'Lollipop', 'G', 'R', 'P', 'YL', 'B', 'O', 'G', 'R', 'P', 'Y', 'B', 
              'O', 'G', 'R', 'P', 'Y', 'Icecream', 'B', 'O', 'G', 'R', 'P', 'Y',
              'B', 'O', 'G', 'R', 'P', 'Y', 'B', 'O', 'G', 'Multi-colored']
    compare(create_board(), b_list)
    board = create_board()
    list2 = ["SB","SB","SB"]
    tup = tuple(("red", 81))
    print(take_turn(tup, board, list2))
    '''
    play_game(2)
    

if __name__ == "__main__":
    main()