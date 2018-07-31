#assume node is an integer

def isCycle(graph):
    if (not graph):
        return False

    isVisited = []
    isAlive = []
    for node in graph:
        if (isCycleDFS(graph, node, isVisited, isAlive)):
            return True
    return False

def isCycleDFS(graph, node, isVisited, isAlive):
    if (not node in isVisited):
        isVisited.append(node)
        isAlive.append(node)
        for c in graph[node]:
            if ((not c == None) and (not c in isVisited)):
                if isCycleDFS(graph, c, isVisited, isAlive):
                    return True
            elif ((not c == None) and (c in isVisited) and
                  (c in isAlive)):
                return True

        xx = isAlive.pop()
        return False


graph = {0:[1], 1:[2,3], 2:[3,4,5], 3:[4], 4:[], 5:[], 99:[3]}
isIt = isCycle(graph)
print (isIt)

graph = {0:[1], 1:[2,3], 2:[5,3], 3:[4], 4:[2], 5:[], 99:[3]}
isIt = isCycle(graph)
print (isIt)
                
