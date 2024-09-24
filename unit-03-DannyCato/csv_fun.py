import csv
import plotter
import re

def names_and_addresses(csv_file):
    with open(csv_file) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)

        for line in csv_reader:
            print(line)

def average(csv_file):
    # names_and_addresses(csv_file)
    with open(csv_file) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)

        counter = 0
        for line in csv_reader:
            counter1 = 0
            sum = 0
            count_items = 0

            for item in line:
                if counter1 < 2 or item == '':
                    counter1 = counter1 + 1
                    continue
                else:
                    count_items = count_items + 1
                    sum = sum + float(item)
                counter1 = counter1 + 1

            counter = counter + 1
            print("Average", counter, "is", (sum/count_items))

def plot_grades(csv_filename, column):
    plotter.init("Grades", "Assignment", "Grade")
    plotter.new_series("Grades in col " + str(column))
    with open(csv_filename) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)

        for line in csv_reader:
            item = line[column]
            if item != '':
                plotter.add_data_point(float(item))
        
        plotter.plot()

def zip_check(csv_file):
    with open(csv_file) as file:
        csv_reader = csv.reader(file)
        next(csv_reader)

        for line in csv_reader:
            address = line[1].split()
            zipcode = address[len(address) - 1]
            if re.findall("^[789]", zipcode):
                print(str(line[0]) + ", of " + str(zipcode) + ", lives at an address that begins with a 7,8, or 9")
            else:
                print(str(line[0]) + ", of " + str(zipcode) + ", does not live at an address that begins with a 7,8, or 9")


def main():
    names_and_addresses("data/grades_010.csv")
    average("data/full_grades_010.csv")
    plot_grades("data/full_grades_010.csv", 3)
    zip_check("data/full_grades_010.csv")

if __name__ == "__main__":
    main()