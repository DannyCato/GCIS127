def make_student(id, name):
    return [id,name,0,0]

def add_student(population, id, name):
    '''for i in range(len(population)):
        if population[i][0] == id:
            population.pop(i)
            population.insert(i,make_student(id, name))
            return population
    return population.append(make_student(id,name))
    '''
    population[str(id)] = make_student(id,name)
    
def get_student(population, id):
    '''for i in population:
        if i[0] == id:
            return i
    return None
    '''
    if str(id) in population:
        return population[str(id)]
    return None

def add_credits(population, id, credits):
    student = get_student(population, id)
    student[2] = credits

def get_credits(population, id):
    student = get_student(population, id)
    if student != None:
        return student[2]
    return None

def main():
    id1 = 0
    name1 = "Greg"
    id2 = 1
    name2 = "George"
    id3 = 2
    name3 = "Naiome"
    id4 = 3
    name4 = "Nella"

    Greg = make_student(id1,name1)
    print(Greg)
    George = make_student(id2,name2)
    print(George)
    Naiome = make_student(id3,name3)
    print(Naiome)
    Nella = make_student(id4,name4)
    print(Nella)

    population = dict()

    add_student(population, id1, name1)
    add_student(population, id2, name2)
    add_student(population, id3, name3)
    add_student(population, id4, name4)
    print(population)

    print(get_student(population, id1))
    print(get_student(population, 5))

    add_credits(population, id1, 12)
    print(population)
    print(get_credits(population, id1))



if __name__ == "__main__":
    main()