
import random
import math
import time

lst = sorted(random.sample(range(1000000), 10000))


# Linear Search
def linearSearch(searchVal, lst):
    for i, item in enumerate(lst):
        if item == searchVal:
            return i
    else:
        print("Value not found in list")

# Binary Search
def binarySearch(searchVal, lst):

    # function to get middle index
    def defineMiddle(min_val, max_val):
        if max_val == 1:
            return 0
        else:
            return int(math.ceil((max_val - min_val) / 2.0) + min_val)

    max_val = len(lst)
    min_val = 0
    middle = defineMiddle(min_val, max_val)
    found = False

    while found == False:
        if lst[middle] == searchVal:
            found = True
            return middle
        elif lst[middle] > searchVal:
            max_val = middle
            middle = defineMiddle(min_val, max_val)
        elif lst[middle] < searchVal:
            min_val = middle
            middle = defineMiddle(min_val, max_val)

        if max_val == middle | min_val == middle:
            print "Value not found in list."
            break

# generate dictionary (hash table)
hashTable = {}
for index, value in enumerate(lst):
    hashTable[value] = index


# compare speeds
start= time.clock()
for i in range(10000):
    linearSearch(594595, lst)
end= time.clock()
timed = (end-start) # 4.5165

start = time.clock()
for i in range(10000):
    binarySearch(594595, lst)
end = time.clock()
timed2 = (end-start) # 0.102063


start = time.clock()
for i in range(10000):
    hashTable[594595]
end = time.clock()
timed2 = (end-start) # 0.001207

