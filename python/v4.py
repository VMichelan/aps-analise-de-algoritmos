def max_subarray(v,size):
    resp = 0
    maior = 0
    i = 0
    while i < size:
        maior = max(0,maior+v[i])
        resp = max(resp,maior)
        i = i + 1
    return resp


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
