//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution 
{
    public int findMaxDiff(int[] arr) 
    {
        
        int n = arr.length;
        int[] leftSmaller = new int[n];
        int[] rightSmaller = new int[n];
        
        // Compute nearest smaller to the left
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) 
        {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) 
            {
                stack.pop();
            }
            leftSmaller[i] = stack.isEmpty() ? 0 : arr[stack.peek()];
            stack.push(i);
        }
        
        // Compute nearest smaller to the right
        stack.clear();
        for (int i = n - 1; i >= 0; i--) 
        {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) 
            {
                stack.pop();
            }
            rightSmaller[i] = stack.isEmpty() ? 0 : arr[stack.peek()];
            stack.push(i);
        }
        
        // Compute the maximum absolute difference
        int maxAbsDiff = 0;
        for (int i = 0; i < n; i++) 
        {
            int absDiff = Math.abs(leftSmaller[i] - rightSmaller[i]);
            maxAbsDiff = Math.max(maxAbsDiff, absDiff);
        }
        
        return maxAbsDiff;
         
    }
}
