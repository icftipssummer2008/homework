def largestRectangleArea(hist):
    stack = [];
		
    maxArea = 0;
    area = 0;
    i=0;
		
    while(i<len(hist)):
        if (stack):
            print (hist[stack[len(stack)-1]], "<=", hist[i], "=",
                   hist[stack[len(stack)-1]] <= hist[i])
        if((not(stack)) or hist[stack[len(stack)-1]] <= hist[i]):
            stack.append(i)
            i += 1
        else:
            top = stack.pop()
            if (not(stack)):
                area = hist[top] * i
            else:
                area = hist[top] * (i - stack[len(stack)-1] -1)
            if(area>maxArea):
                maxArea = area;
		
    while(stack):
        top = stack.pop()
        if (not(stack)):
            area = hist[top] * i
        else:
            area = hist[top] * (i - stack[len(stack)-1] -1)
        if(area>maxArea):
            maxArea = area

    return maxArea
	
hist = [2,2,1,5,6,2,3,1,1,1,1]
maxArea = largestRectangleArea(hist)

print (maxArea)
    
