#import java.util.*

def createGraph(sortedDict):
    if (len(sortedDict) == 0):
        return None
    graph = {}
    for i in range (len(sortedDict)-1):
        word1 = sortedDict[i]
        word2 = sortedDict[i+1]
        minSize = min(len(word1), len(word2))
        for j in range (minSize):
            if (not word1[j] == word2[j]):
                createEdge (graph, word1[j], word2[j])
                break
    for word in sortedDict:        #fill remaining nodes with blank adjList
        for c in word:
            if (not c in graph):
                graph[c] = []
    return graph

def createEdge(graph, u, v):
    if (v in graph and u in graph[v]):
        string = "Inconsistent dictionary for '" + str(u) + "' and '" + str(v) + "'."
        exit (string)
    if (u in graph):
        if (not v in graph[u]):
            graph[u].append(v)
    else:
        graph[u] = [v]

def topoScan(graph):
    orderedList = []
    isVisited = []
    stack = []
    for node in graph:
        if (not node in isVisited):
            topoScanUtil(graph, node, isVisited, stack)
    stackLen = len(stack)
    for i in range(stackLen):
        orderedList.append(stack[stackLen-i-1])
    return orderedList

def topoScanUtil(graph, node, isVisited, stack):
    isVisited.append(node)
    for c in graph[node]:
        if (not c in isVisited):
            topoScanUtil(graph, c, isVisited, stack)
    stack.append(node)


sortedDict = ["caa", "aaa", "aab"]
graph = createGraph(sortedDict)
sortedList = topoScan(graph)
print (sortedList)
                
