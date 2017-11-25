#!/usr/bin/env ruby

require 'benchmark'

def max_subarray(v,lo,hi)
	if lo == hi
        return v[lo]
    end
    mid = ((lo+hi)/2)
    leftMax = max_subarray(v,lo,mid)
    rightMax = max_subarray(v,mid+1,hi)
    leftBothMax = -1.0/0.0
    leftBothSum = 0
    i = mid
    while i >= 0
        leftBothSum = leftBothSum + v[i]
        if leftBothSum > leftBothMax
            leftBothMax = leftBothSum
        end
        i = i - 1
    end
    rightBothMax = -1.0/0.0
    rightBothSum = 0
    i = mid+1
    while i <= hi
        rightBothSum = rightBothSum + v[i]
        if rightBothSum > rightBothMax
            rightBothMax = rightBothSum
        end
        i = i + 1
    end
    bothMax = leftBothMax + rightBothMax

    return [bothMax,rightMax,leftMax,0].max
end
        
if ARGV.length < 2
	print("Argumentos invalidos")
	exit;
end
size = ARGV[0].to_i
f = open(ARGV[1],"r")
v = []
while size > 0 do
	v.push(f.readline().to_i)
    size = size - 1
end
size = ARGV[0].to_i
result = 0;
time = Benchmark.measure{
    result = max_subarray(v,0,size-1)
}
if ARGV.length > 2
    if ARGV[2] == "-t"
        puts(time.real)
    elsif ARGV[2] == "-r"
        puts(result)
    end
end

