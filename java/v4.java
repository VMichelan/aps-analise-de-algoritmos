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
		result = a.max_subarray(v,size);
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

	public int max_subarray(List<Integer> v, int size){
		int resp = 0,maior = 0;
		for(int i=0;i<size;i++){
			maior = Math.max(0,maior+v.get(i));
			resp = Math.max(resp,maior);
		}
		return resp;
	}

}
