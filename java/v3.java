import java.io.*;
import java.util.*;
import java.lang.management.*;

class MaxSubArray{
	public static void main(String args[]) throws java.io.IOException{
		if(args.length < 2){
			System.out.println("Argumentos invalidos");
			System.exit(1);
		}
		int size = Integer.parseInt(args[0]);
		List<Integer> v = new ArrayList<Integer>();
		BufferedReader br = new BufferedReader(new FileReader(args[1]));

	    StringBuilder sb = new StringBuilder();
	    String line = br.readLine();

	    while (line != null) {
	    	v.add(Integer.parseInt(line));
	    	line = br.readLine();
	    }
		int result;
		MaxSubArray a = new MaxSubArray();
		ThreadMXBean bean = ManagementFactory.getThreadMXBean();
		long start = bean.getCurrentThreadCpuTime(),end;
		result = a.maxSubArraySum(v,0,size-1);
		end = bean.getCurrentThreadCpuTime();
		if(args.length > 2){
			if(args[2].equals("-t")){
				System.out.printf("%f\n",(end - start)/1000000000.0);
			}
			else if(args[2].equals("-r")){
				System.out.println(result);
			}
		}
	}

	public int maxCrossingSum(List<Integer> arr, int l, int m, int h){
	    int sum = 0;
	    int left_sum = Integer.MIN_VALUE;
	    for (int i = m; i >= l; i--){
	        sum = sum + arr.get(i);
	        if (sum > left_sum)
	          left_sum = sum;
	    }
	 
	    sum = 0;
	    int right_sum = Integer.MIN_VALUE;
	    for (int i = m+1; i <= h; i++){
	        sum = sum + arr.get(i);
	        if (sum > right_sum)
	          right_sum = sum;
	    }
	    return left_sum + right_sum;
	}

	int maxSubArraySum(List<Integer> arr, int l, int h){
	   if (l == h)
	     return arr.get(l);
	   int m = (l + h)/2;
	   return Math.max(Math.max(maxSubArraySum(arr, l, m),
	              maxSubArraySum(arr, m+1, h)),
	              maxCrossingSum(arr, l, m, h));
	}

}
