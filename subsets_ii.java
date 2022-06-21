import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class subsets_ii {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        backtracking(res, current, nums, 0);
        return res;
    }

    public void backtracking(List<List<Integer>> result, List<Integer> current, int[] nums, int currIndex) {
        if (currIndex >= nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[currIndex]);
        backtracking(result, current, nums, currIndex+1);
        current.remove(current.size()-1);

        while (currIndex+1 < nums.length && nums[currIndex] == nums[currIndex+1]) {
            currIndex += 1;
        }
        backtracking(result, current, nums, currIndex+1);
    }

    public static void main(String[] args) {
        subsets_ii sol = new subsets_ii();
        List<List<Integer>> result = sol.subsets(new int[] {1,3,3});
        System.out.println("Subsets of {1,3,3} is " + result);

        result = sol.subsets(new int[] {1,5,3,5});
        System.out.println("Subsets of {1,5,3,5} is " + result);
    }

    @Test
    public void testSubsets() {
        List<List<Integer>> expectedOne = new ArrayList<>();
        expectedOne.add(Arrays.asList(1));
        expectedOne.add(new ArrayList<>());

        List<List<Integer>> expectedTwo = new ArrayList<>();
        expectedTwo.add(Arrays.asList(1,3,3));
        expectedTwo.add(Arrays.asList(1,3));
        expectedTwo.add(Arrays.asList(1));
        expectedTwo.add(Arrays.asList(3,3));
        expectedTwo.add(Arrays.asList(3));
        expectedTwo.add(new ArrayList<>());

        assertEquals(expectedOne, subsets(new int[] {1}));
        assertEquals(expectedTwo, subsets(new int[] {1,3,3}));
    }
}

/*
https://leetcode.com/problems/subsets-ii/
Explanation

Time:
Space:
*/