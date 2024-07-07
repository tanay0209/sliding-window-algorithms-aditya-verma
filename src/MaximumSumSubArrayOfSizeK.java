import java.util.ArrayList;
import java.util.Arrays;

public class MaximumSumSubArrayOfSizeK
{
    private static long maximumSum (ArrayList<Integer> arr, int len, int k){
        int start = 0;
        int end = 0;
        long sum = 0;
        long maxSum = Integer.MIN_VALUE;
        while (end<len){
            sum+= arr.get(end);
            if ((end-start+1)<k){
                end++;
            }else if ((end-start+1) == k){
                maxSum = Math.max(maxSum,sum);
                sum-=arr.get(start);
                start++;
                end++;
            }
        }
        return maxSum;

    }
    public static void main (String[] args)
    {
        ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(100,200,300,400));
        System.out.println(maximumSum(arr,arr.size(),2));


    }
}
