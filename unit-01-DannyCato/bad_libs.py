def Main():
    adj1 = input("Adjective for a large thing: ") # Added specfics so it's less janky when printed
    adj2 = input("Adjective for a group of people: ") # ^^
    word1 = input("word: ") #swapped from noun1 for clarity when making mad lib
    noun2 = input("Noun: ")
    name1 = input("An object in the kitchen: ") #changed from Name: to make more interesting
    noun3 = input("Noun: ")
    noun4 = input("Noun of something Gross: ") # same as last prompt
    obj1 = input("Object: ")
    obj2 = input("Object: ")


    print("Once upon a time in a galaxy filled with ", adj1 ," wonders, there sailed a ", adj2 ," pirate named Captain ", word1 ,".", sep="", end=" ")
    print("This daring spacefarer was known far and wide for their ", noun2,"-clad parrot named, ", name1,", and their trusty ", noun3, " of the cosmos, the \'Saucy ", noun4, "\'.", sep="", end=" ")
    print("Together they scoured the galaxy looking for ", obj1, " and ", obj2, " everywhere they go.", sep="", end=" ")

Main()