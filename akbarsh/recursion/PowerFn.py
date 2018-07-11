"""
Implement a power function to raise a double to an int power, including negative powers.
e.g. pow(double d, int p) should give 'd' raised to power 'p'.
"""
def powofx(d,p):
    if p==0:
        return 1
    elif p>0:
        return d*powofx(d,p-1)
    else:
        return 1.0/d*powofx(d,p+1)
print powofx(2,3)
print powofx(2,-3)
