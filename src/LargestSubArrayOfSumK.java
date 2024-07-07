public class LargestSubArrayOfSumK
{
    private static int subArray (int[] nums, int k)
    {
        int start = 0;
        int end = 0;
        int size = 0;
        int sum = 0;

        while (end < nums.length) {
            sum += nums[end];
            if (sum == k) {
                size = Math.max(size, end - start + 1);
                end++;
            }
            else if (sum < k) {
                end++;
            }
            else {
                while (sum>k){
                    sum-=nums[start];
                    start++;
                }
                end++;
            }
        }
        return size;
    }

    public static void main (String[] args)
    {
        int[] nums = { 4, 1, 1, 1, 2, 3, 5 };
        int target = 5;
        System.out.println(subArray(nums,target));
    }
}
