//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


// 
class jobComparator implements Comparator<Job> 
{
    public int compare(Job j1, Job j2){
        if(j1.profit > j2.profit)return -1;
        if(j1.profit < j2.profit)return 1;
        return 0;
    }
}

class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        //sorting all jobs according to decreasing order of profit.
        Arrays.sort(arr, new jobComparator());
        

        int res=0, count=0;
        //array to store result (Sequence of jobs).
        int[] result = new int[n];
        //boolean array to keep track of free time slots. 
        boolean[] slot = new boolean[n];
        
        //initializing all slots to free.
        Arrays.fill(slot, false);
        
        //iterating through all given jobs.
        for (int i=0; i<n; i++)
        { 
            //finding a free slot for current job (Note that we start 
        	//from the last possible slot).
            for (int j=Integer.min(n, arr[i].deadline)-1; j>=0; j--) 
            { 
                //if free slot is found, we add current job to result array
        		//and make the current slot occupied.
                if (slot[j]==false)
                { 
			        result[j] = i; 
			        slot[j] = true;
			        break; 
		        } 
	        } 
	    } 
	    for (int i=0; i<n; i++)
	    {
	        //if slot is occupied, we update the counter and 
    	    //add its profit in final result.
	        if(slot[i]) {
	            count++;
	            res += arr[result[i]].profit;
	        }
	    }
	    
	    //storing the count of jobs and max profit in a list and returning it.
	    int[] ans = new int[2];
	    ans[0] = count;
	    ans[1] = res;
	    return ans;
    }
    
}
/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/