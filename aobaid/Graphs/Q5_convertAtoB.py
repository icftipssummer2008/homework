def diff(word1, word2):
    dist = 0
    if (len(word1) == len(word2)):
        for i in range (len(word1)):
            if (not word1[i] == word2[i]):
                dist += 1
    return dist

def dfs(graph, node, b, isVisited, paths):
    isVisited.append(node)
    if (node == b):    #reached destination
        print(isVisited)
        paths.append(isVisited[:])
    else:
        for v in graph[node]:
            if (not v in isVisited):
                dfs(graph, v, b, isVisited, paths)
    isVisited.pop()

def aToB (a, b, dict1):
    graph = {}
    #create vertex in graph between words with 1 char difference
    for i in range (len(dict1)):
        word1 = dict1[i]
        for j in range(i+1,len(dict1)):
            word2 = dict1[j]
            if (not word1 == word2 and
                diff(word1, word2) == 1):
                if (word1 in graph):
                    graph[word1].append(word2)
                else:
                    graph[word1] = [word2]
                if (word2 in graph):
                    graph[word2].append(word1)
                else:
                    graph[word2] = [word1]

    #perform dfs to search for all possible paths to destination           
    isVisited = []
    paths = []
    dfs(graph, a, b, isVisited, paths)
    
    for aPath in paths:
        print(aPath)


dict1 = ["cat", "bat", "hat", "bad", "had"]
aToB("bat", "had", dict1)


