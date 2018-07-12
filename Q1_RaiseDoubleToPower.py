# find power (**) using recursion

def power (d, n):
    if (n == 0): return 1;
    
    #reverse number and power if n is negative
    if (n < 0):         
        d = 1.0 / d
        n = -n
        return power (d, n)
    
    #if n is even, then calculated value = (d**(n/2))
    #if n is odd, then calculated value = d*(d**truncated(n/2))
    pwr = power (d, n//2)
    if (n % 2):
        return d * pwr * pwr
    else:
        return pwr * pwr

print (power(2,-11))
print (power(2,13))
print (power(2,11))
