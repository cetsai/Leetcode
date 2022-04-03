import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class two_sum_closest_to_zero {
    public int twoSumClosest(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (Math.abs(minSum) > Math.abs(sum)) {
                    minSum = sum;
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return minSum;
    }

    public int twoSumClosestSort(int[] nums) {
        Arrays.sort(nums);
        int[] res = new int[2];
        int left = 0;
        int right = nums.length-1;
        int minSum = Integer.MAX_VALUE;

        while (left < right) {
            int sum = nums[left] + nums[right];

            if (Math.abs(minSum) > Math.abs(sum)) {
                minSum = sum;
                res[0] = left;
                res[1] = right;
            }

            if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
        return minSum;
    }

    @Test (timeout = 100)
    public void testTwoSumClosest() {
        int[] one = {1, 60, -10, 70, -80, 85};
        int[] two = {-8, -66, -60};
        int[] three = {-21,-67,-37,-18,4,-65};
        assertEquals(5, twoSumClosest(one));
        assertEquals(-68, twoSumClosest(two));
        assertEquals(-14, twoSumClosest(three));
        assertEquals(5, twoSumClosestSort(one));
        assertEquals(-68, twoSumClosestSort(two));
        assertEquals(-14, twoSumClosestSort(three));
    }
}
