# Python Sorting Algorithms

import random
import math
import time

lst = random.sample(range(1000000), 1000)

# Quicksort
def quicksort(array):
    if len(array) < 2:
        return array
    pivot = array[0]
    less = [i for i in array[1:] if i <= pivot]
    greater = [i for i in array[1:] if i > pivot]
    
    return quicksort(less) + [pivot] + quicksort(greater)
    
print(quicksort(lst))
