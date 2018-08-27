class MyQueue:
    def __init__(self):
        self.__q1 = []     #will push into q1
        self.__q2 = []     #will pull from q2
        
    def push(self, value):
        while (self.__q2):
            self.__q1.append(self.__q2.pop())
        self.__q1.append(value)
        
    def pull(self):
        while (self.__q1):
            self.__q2.append(self.__q1.pop())
        if (self.__q2):
            return self.__q2.pop()
        else:
            return None

    def peek(self):
        while (self.__q1):
            self.__q2.append(self.__q1.pop())
        if (self.__q2):
            return self.__q2[len(self.__q2) - 1]   #top of stack
        else:
            return None

    def empty(self):
        return (not (self.__q1 or self.__q2))

q = MyQueue()
q.push(1)
q.push(2)
q.push(3)
val = q.pull()
print ("Pulled value",val)
q.push(4)
val = q.peek()
print ("Peeked value",val)
val = q.pull()
print ("Pulled value",val)
val = q.pull()
print ("Pulled value",val)
if (q.empty()):
    print ("Queue is empty")
else:
    print ("Queue is not empty")
val = q.pull()
print ("Pulled value",val)
if (q.empty()):
    print ("Queue is empty")
else:
    print ("Queue is not empty")
