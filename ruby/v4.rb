#!/usr/bin/env ruby

require 'benchmark'

def max_subarray(v,size)
    resp = 0
    maior = 0
    i = 0
    while i < size
        maior = [0,maior+v[i]].max
        resp = [resp,maior].max
        i = i + 1
    end
    return resp
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
    result = max_subarray(v,size)
}
if ARGV.length > 2
    if ARGV[2] == "-t"
        puts(time.real)
    elsif ARGV[2] == "-r"
        puts(result)
    end
end

