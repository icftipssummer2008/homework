class Vertex:
    def __init__(self,data,neighbors=set()):
        self.data=data
        self.neighbours=neighbors

class Graph:
    def __init__(self,vertices={}):
        self.vertices=vertices

def addEdge(u,v):
    u.neighbours.add(v)

def dfs(v):
    _dfs(v, visited=set())

def _dfs(v,visited):
    if v in visited:
        return
    visited.add(v)
    print v.data,
    for n in v.neighbours:
        _dfs(n,visited)

def bfs(v):
    visited = set([v])
    Q=[v]
    while Q:
        u=Q.pop()
        print u.data,
        for n in u.neighbours:
            if n not in visited:
                visited.add(n)
                Q.append(n)

vertex1 = Vertex(3)
vertex2 = Vertex(5)
vertex3 = Vertex(2)
vertex4 = Vertex(1)
vertex5 = Vertex(4)
addEdge(vertex1,vertex2)
addEdge(vertex1,vertex3)
addEdge(vertex2,vertex4)
addEdge(vertex2,vertex5)
dfs(vertex1)
print
bfs(vertex1)