class Graph:
    def __init__(self, graph=None):
        if (graph == None):
            graph = {}
        self.__graph = graph

    def printGraph(self):
        print (self.__graph)
        
    def addVertex(self, v):
        if (not v in self.__graph):
            self.__graph[v] = []
            
    def addEdge(self, u, v):
        if (u in self.__graph):
            if (not v in self.__graph[u]):
                self.__graph[u].append(v)
        else:
            self.__graph[u] = [v]
        
    def printGraphUsingBFS(self):
        graphKeys = self.__graph.keys()
        if (not len(graphKeys)):
            return
        
        isVisited = []
        q = []
        for node in graphKeys:
            if (not node in isVisited):
                q.append(node)
                isVisited.append(node)

        while (len(q)):
            node = q[0]
            q = q[1:]
            if (not node in self.__graph):
                continue
            for v in self.__graph[node]:
                if (not v in isVisited):
                    q.append(v)
                    isVisited.append(v)

        print(isVisited)      

    def printGraphUsingDFS(self):
        graphKeys = list(self.__graph.keys())
        if (not len(graphKeys)):
            return
        
        isVisited = []
        for node in graphKeys:
            self.dfs(node, isVisited)
        print (isVisited)

    def dfs(self, node, isVisited):
        if (node in isVisited):
            return
        isVisited.append(node)
        if (not node in self.__graph.keys()):
            return
        for v in self.__graph[node]:
            if (not v in isVisited):
                self.dfs(v, isVisited)



gr = Graph({'A':['B'], 'B':['C'], 'C':['D'], 'D':['A','E','G'],
            'E':['F'], 'F':['E','G'], 'G':['F','D'], 'H':['I','J']})

gr.addEdge('I','K')
gr.addEdge('I','L')
gr.addEdge('J','M')
gr.addEdge('J','N')
gr.printGraph()

gr.printGraphUsingBFS()
gr.printGraphUsingDFS()
