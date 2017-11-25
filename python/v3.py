def max_subarray(v,lo,hi):
    if lo == hi:
        return v[lo]
    mid = math.floor((lo+hi)/2)
    leftMax = max_subarray(v,lo,mid)
    rightMax = max_subarray(v,mid+1,hi)
    leftBothMax = -math.inf
    leftBothSum = 0
    i = mid
    while i >= 0:
        leftBothSum = leftBothSum + v[i]
        if leftBothSum > leftBothMax:
            leftBothMax = leftBothSum
        i = i - 1
    rightBothMax = -math.inf
    rightBothSum = 0
    i = mid+1
    while i <= hi:
        rightBothSum = rightBothSum + v[i]
        if rightBothSum > rightBothMax:
            rightBothMax = rightBothSum
        i = i + 1
    bothMax = leftBothMax + rightBothMax

    return max(bothMax,rightMax,leftMax,0)

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
    result = max_subarray(v,0,size-1)
    end = time.clock()
    if len(sys.argv) > 3 and sys.argv[3] == "-t":
        print(end - start)
    if len(sys.argv) > 3 and sys.argv[3] == "-r":
        print(result)
