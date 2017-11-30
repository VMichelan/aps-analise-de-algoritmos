#!/usr/bin/env ruby

require 'benchmark'

def maxCrossingSum(arr, l, m, h)
    sum = 0
    left_sum = -1.0/0.0
    i = m
    while i >= l
        sum = sum + arr[i]
        if sum > left_sum
            left_sum = sum
        end
        i -= 1
    end
    sum = 0;
    right_sum = -1.0/0.0
    i = m+1
    while i <= h
        sum = sum + arr[i]
        if sum > right_sum
            right_sum = sum
        end
        i += 1
    end

    return left_sum + right_sum;
end


def maxSubArraySum(arr, l, h)
    if l == h
        return arr[l]
    end
    m = ((l + h)/2)
    return [maxSubArraySum(arr, l, m),
              maxSubArraySum(arr, m+1, h),
              maxCrossingSum(arr, l, m, h)].max
end
     
if ARGV.length < 2
	print("Argumentos invalidos")
	exit
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
    result = maxSubArraySum(v,0,size-1)
}
if ARGV.length > 2
    if ARGV[2] == "-t"
        puts(time.real)
    elsif ARGV[2] == "-r"
        puts(result)
    end
end

