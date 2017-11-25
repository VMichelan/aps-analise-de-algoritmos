def max_subarray(v,size):
    best = -math.inf
    i = 0
    while i < size:
        j = i
        sum = 0
        while j < size:
            sum = sum + v[j]
            if sum > best:
                best = sum
            j+=1
        i+=1
    if math.isfinite(best):
        return best
    return 0
        
if __name__ == '__main__':
    import math
    import sys
    import time
    if len(sys.argv) < 3:
        print("Argumentos invalidos")
        sys.exit(0) 
    size = int(sys.argv[1])
    f = open(sys.argv[2],"r")
    v = []
    while size > 0:
        v.append(int(f.readline()))
        size = size - 1
    size = int(sys.argv[1])
    start = time.clock()
    result = max_subarray(v,size)
    end = time.clock()
    if len(sys.argv) > 3 and sys.argv[3] == "-t":
        print(end - start)
    if len(sys.argv) > 3 and sys.argv[3] == "-r":
        print(result)
