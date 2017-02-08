# Graph Algorithms in Python

# Breadth First Search

# 1.  Is there a path from Node A to Node B?
# 2.  What is the shortest path from Node A to Node B?

# create a graph object
graph = {"You": ["Alice", "Bob", "Claire"],
         "Alice": ["Peggy"],
         "Bob": ["Peggy", "Anuj"],
         "Claire": ["Tom", "Johnny"],
         "Anuj": [],
         "Tom": [],
         "Johnny": [],
         "Peggy": []
}

from collections import deque

# some function that defines if someone sells mangos
def person_is_seller(person):
    return person[-2] == "u"
        
def breadth_first_search(graph):
    search_queue = deque()
    search_queue += graph["You"]
    
    while search_queue:                            # while there are people in the search queue,
        person = search_queue.popleft()            # take the next person,
        if person_is_seller(person):               # if they are a mango seller,
            print person + " is a mango seller!"   # Celebrate!
            return True
        else:                                      # otherwise,
            search_queue += graph[person]          # add their connections to the back of the search queue
    return False


# use the function
breadth_first_search(graph)


