def maxCrossingSum(arr, l, m, h):
    sum = 0
    left_sum = -math.inf
    i = m
    while i >= l:
        sum = sum + arr[i]
        if sum > left_sum:
            left_sum = sum
        i -= 1
     
    sum = 0;
    right_sum = -math.inf
    i = m+1
    while i <= h:
        sum = sum + arr[i]
        if sum > right_sum:
            right_sum = sum
        i += 1

    return left_sum + right_sum;


def maxSubArraySum(arr, l, h):
   if l == h:
     return arr[l]
   m = math.floor((l + h)/2)
   return max(max(maxSubArraySum(arr, l, m),
              maxSubArraySum(arr, m+1, h)),
              maxCrossingSum(arr, l, m, h))


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
    result = maxSubArraySum(v,0,size-1)
    end = time.clock()
    if len(sys.argv) > 3 and sys.argv[3] == "-t":
        print(end - start)
    if len(sys.argv) > 3 and sys.argv[3] == "-r":
        print(result)
