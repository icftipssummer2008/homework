class qElement:
    def __init__(self, cellNo=0, steps=0):
        self.cellNo = cellNo
        self.steps = steps

def minSteps(graph, N):    #will use BFS
    if (graph == []):
        return 0

    q = []
    isVisited = []
    
    node = qElement(0, 0)
    q.append(node)
    isVisited.append(node.cellNo)

    while (q):
        node = q.pop(0)
        if (node.cellNo == N-1):  #reached target
            break
        start = node.cellNo + 1
        end = min(node.cellNo + 7, N)
        for j in range(start, end):
            if (not j in isVisited):
                isVisited.append(j)
                nextNode = qElement()
                nextNode.steps = node.steps + 1
                stepCount = nextNode.steps
                if (j in graph):
                    nextNode.cellNo = graph[j]
                else:
                    nextNode.cellNo = j
                q.append(nextNode)
    return node.steps

N = 30
graph = {2:21, 4:7, 10:25, 19:28, 16:3, 18:6, 20:8, 26:0}

steps = minSteps(graph, N)
print (steps)
                
