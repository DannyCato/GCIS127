import csv
import re
import plotter

def plot_grades(filename, first_name, last_name):
    plotter.init(first_name + " " + last_name + "\'s Grades", "Assignment", "Grade")
    plotter.new_series(first_name + " " + last_name + "\'s Grades")
    with open(filename) as csv_file:
        csv_reader = csv.reader(csv_file)
        next(csv_reader)
        
        for line in csv_reader: #finding name first
            if re.search(last_name, line[0]):
                if re.search(first_name, line[0]):
                    count = 0
                    for item in line: # nested loop plotting grades if name is equal
                        if count > 2:
                            plotter.add_data_point(float(item))
                        count = count + 1
            else:
                continue
    plotter.plot()

def get_average(filename, column):
    with open(filename) as csv_file:
        csv_reader = csv.reader(csv_file)
        next(csv_reader)
        if column > 2:
            sum = 0
            count = 0
            for line in csv_reader:
                try:
                    sum = sum + float(line[column])
                    #print("sum =" + str(sum))
                    count = count + 1
                    #print("count =" + str(count))
                except:
                    continue
            return sum/count

def plot_class_averages(filename):
    plotter.init("Class Averages", "Assignment", "Avg. Grade")
    plotter.new_series("Average Grade")
    count = 3
    while (True):
        try:
            avg = get_average(filename, count)
            #print(str(avg))
            plotter.add_data_point(avg)
            count = count + 1
        except:
            break
    plotter.plot()


def main():
    plot_grades("data/full_grades_100.csv", "Lynzee", "Derrick")
    plot_grades("data/full_grades_100.csv", "Normandy", "Curet")
    #print(str(get_average("data/full_grades_010.csv", 5)))
    plot_class_averages("data/full_grades_999.csv")

if __name__ == "__main__":
    main()