"""
Simple plotting module that will plot data using matplotlib. 

Note that matplotlib must be installed first.

Example:
import plotter

plotter.init("My Graph", "X-Axis", "Y-Axis")
plotter.add_data_point(100)
plotter.add_data_point(25)
plotter.add_data_point(37)
plotter.new_series()
plotter.add_data_point(75)
plotter.add_data_point(65)
plotter.add_data_point(100)
plotter.plot()

@author GCCIS Faculty
"""

import matplotlib.pyplot as pyplot

__SERIES = []
__LABELS = []
__INCLUDE_DATA_LABELS = True
__ANNOTATION_FONT_SIZE = 8

def reset():
    """
    Resets the plotter, erasing any current plots.
    """
    __SERIES.clear()
    __LABELS.clear()
    pyplot.clf()

def title(title=None):
    """
    Sets the title of the plot to the specified value.
    """
    if title is not None:
        pyplot.title(title)

def x_axis_label(label=None):
    """
    Sets the X-Axis label to the specified value.
    """
    if label is not None:
        pyplot.xlabel(label)

def y_axis_label(label=None):
    """
    Sets the Y-Axis label to the specified value.
    """
    if label is not None:
        pyplot.ylabel(label)

def init(plot_title, x_label, y_label, include_data_labels=True):
    """
    Initializes the plotter with the specified title, X-Axis label, and Y-Axis
    label. Optionally, the data labels may be disabled.

    This has the effect of resetting the plotter if there are any existing 
    plots.
    """
    reset()
    title(plot_title)
    x_axis_label(x_label)
    y_axis_label(y_label)
    global __INCLUDE_DATA_LABELS
    __INCLUDE_DATA_LABELS = include_data_labels

def new_series(label=None):
    """
    Starts a new series in the current plot with the specified label. If no
    label is specified, the label "Series N" will be used instead (where N is 
    the number of series on the plot, including this one).
    """
    __SERIES.append([])
    if label is None:
        label = f"Series {len(__SERIES)}"
    __LABELS.append(label)

def add_data_point(coord1):
    """
    Adds a data point to the current plot. If a series has not yet been added
    to the plot, a new one will be created before adding the data point.
    """
    if(len(__SERIES) == 0):
        new_series()
    __SERIES[-1].append(coord1)

def plot(log=False):
    """
    Draws the plot and displays it on the screen. Optionally sets the scale of
    the Y-Axis to logarithmic.
    """
    x_ticks = set()
    for series_number in range(len(__SERIES)):
        series = __SERIES[series_number]
        series_label = __LABELS[series_number]
        xs = [x for x in range(len(series))]
        x_ticks.update(xs)
        pyplot.plot(xs, series, label=series_label)

        if __INCLUDE_DATA_LABELS:
            for i in range(len(series)):
                pyplot.annotate(f"{series[i]:.3g}", (xs[i], series[i]), 
                    fontsize=__ANNOTATION_FONT_SIZE, textcoords="offset points",
                    xytext=(0, 10), ha="center")

    pyplot.legend(loc="upper right")
    pyplot.xticks(sorted(x_ticks))
    pyplot.subplots_adjust(left=0.1, right=0.95, top=0.95, bottom=0.05)
    if log:
        pyplot.yscale('log')
    pyplot.show()

def main():
    """
    Test function to demonstrate the plotter.
    """
    init("My Graph", "X-Axis", "Y-Axis")
    new_series("Line #1")
    add_data_point(100)
    add_data_point(25)
    add_data_point(37)
    new_series("Line #2")
    add_data_point(75)
    add_data_point(65)
    add_data_point(100)
    plot()
    init("Second Graph", "Bottom", "Left")
    new_series()
    add_data_point(10)
    add_data_point(20)
    add_data_point(30)
    new_series()
    add_data_point(50)
    add_data_point(60)
    add_data_point(70)
    plot(True)

if __name__ == "__main__":
    main()

