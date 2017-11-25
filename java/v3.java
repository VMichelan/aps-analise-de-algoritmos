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
		result = a.max_subarray(v,0,size-1);
		end = bean.getCurrentThreadCpuTime();
		if(args.length > 2){
			if(args[2].equals("-t")){
				System.out.println((end - start)/1000000000.0);
			}
			else if(args[2].equals("-r")){
				System.out.println(result);
			}
		}
	}

	public int max_subarray(List<Integer> v, int lo,int hi){
		if (lo >= hi)
			return v.get(lo);
		int mid = (lo+hi)/2;
		int leftMax = max_subarray(v,lo,mid);
		int rightMax = max_subarray(v,mid+1,hi);
		int leftBothMax = Integer.MIN_VALUE,leftBothSum = 0;
		for(int i = mid; i >= 0;i--){
			leftBothSum += v.get(i);
			if (leftBothSum > leftBothMax)
				leftBothMax = leftBothSum;
		}
		int rightBothMax = Integer.MIN_VALUE,rightBothSum = 0;
		for(int i = mid+1; i <= hi;i++){
			rightBothSum += v.get(i);
			if (rightBothSum > rightBothMax)
				rightBothMax = rightBothSum;
		}

		int bothMax = leftBothMax + rightBothMax;

		if(bothMax > leftMax && bothMax > rightMax)
			return bothMax;
		else if (leftMax > bothMax && leftMax > rightMax)
			return leftMax;
		else
			return rightMax;
	}

}
