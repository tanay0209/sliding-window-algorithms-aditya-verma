import java.util.ArrayList;
import java.util.Arrays;

public class FirstNegativeNumberInEveryWindowOfSizeK
{
    private static long[] firstNegative (long[] arr, int n, int k)
    {
        int start = 0;
        int end = 0;
        ArrayList<Long> list = new ArrayList<>();
        long[] result = new long[n - k + 1];
        int position = 0;
        while (end < n) {
            if (arr[end] < 0) {
                list.add(arr[end]);
            }

            if ((end - start + 1) < k) {
                end++;
            }
            else if ((end - start + 1) == k) {
                if (list.size() == 0) {
                    result[position++] = 0;
                }
                else {
                    result[position++] = list.get(0);
                    if (list.get(0) == arr[start]) {
                        list.remove(0);
                    }
                }
                start++;
                end++;
            }

        }
        return result;
    }

    public static void main (String[] args)
    {
        long[] arr = { -8, 2, 3, -6, 10 };
        System.out.println(Arrays.toString(firstNegative(arr, arr.length, 2)));
    }
}
