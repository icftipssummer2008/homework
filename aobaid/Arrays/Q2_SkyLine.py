class Strip:
    def __init__(self, left, ht):
        self.left = left
        self.ht = ht

class SkyLine:
    def __init__(self):
        self.arr = []
    def append(self, strip):
        n = len(self.arr)
        if (n and (self.arr[n-1].ht == strip.ht)):
            return
        if (n and (self.arr[n-1].left == strip.left)):
            self.arr[n-1].ht = max(self.arr[n-1].ht, strip.ht)
        self.arr.append(strip)
    def count(self):
        return (len(self.arr))
    def print(self):
        for elem in self.arr:
            print("(",elem.left,",",elem.ht,")",end="", sep="")
        
#strips format same as skyLine format
def mergeSkyLines(sky1, sky2):
    i, j, h1, h2 = 0, 0, 0, 0
    merged = SkyLine()
    while (i < sky1.count() and j < sky2.count()):
        strip1 = sky1.arr[i]
        strip2 = sky2.arr[j]
        if (strip1.left < strip2.left):  #x-coordinate
            h1 = strip1.ht
            maxHt = max(h1, h2)
            merged.append(Strip(strip1.left,maxHt))
            i += 1
        else:
            h2 = strip2.ht
            maxHt = max(h1, h2)
            merged.append(Strip(strip2.left,maxHt))
            j += 1
            
    while (i < len(sky1.arr)):
        merged.append(sky1.arr[i])
        i += 1

    while (j < len(sky2.arr)):
        merged.append(sky2.arr[j])
        j += 1

    return merged

class Building:
    def __init__(self,left,ht,right=0):
       self.left = left
       self.ht = ht
       self.right = right

def findSkyLine(bldgArr, start, end):
    if (start == end):
        this = SkyLine()
        strip = Strip(bldgArr[start].left,bldgArr[start].ht)
        this.append(strip)
        strip = Strip(bldgArr[start].right,0)
        this.append(strip)
        return this

    mid = (start + end) // 2
    skyLineLeft = findSkyLine(bldgArr, start, mid)
    skyLineRight = findSkyLine(bldgArr, mid+1, end)
    result = mergeSkyLines(skyLineLeft, skyLineRight)
    return result

bldgArr = [Building(1,11,5), Building(1, 11, 5), Building(2, 6, 7), Building(3, 13, 9),
           Building(12, 7, 16), Building(14, 3, 25), Building(19, 18, 22),
           Building(23, 13, 29), Building(24, 4, 28)]

skyLine = findSkyLine(bldgArr, 0, len(bldgArr)-1)
skyLine.print()
