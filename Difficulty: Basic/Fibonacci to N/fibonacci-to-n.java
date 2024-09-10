//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<Integer> ans=ob.nFibonacci(N);
            for(Integer u:ans)
             System.out.print(u+" ");
            System.out.println(); 
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution{
    ArrayList <Integer> nFibonacci(int N){
        ArrayList <Integer> ans=new ArrayList<Integer>();
        //getting first two terms of the series since 
        //these two will always be present for N>=1
        ans.add(0);
        ans.add(1);
        int a=0,b=1,c=1;
        //getting all the terms that are less than N
        while(c<=N)
        {
            ans.add(c);
            a=b;
            b=c;
            c=a+b;
        }
        return ans;
    }
}