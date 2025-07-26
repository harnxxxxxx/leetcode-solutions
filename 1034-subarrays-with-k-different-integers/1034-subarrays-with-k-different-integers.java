import java.util.HashMap;

public class Solution {

    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, result = 0;

        for (int right = 0; right < nums.length; right++) {
            // Add nums[right] to the map
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // If it's a new unique number
            if (map.get(nums[right]) == 1) {
                k--;
            }

            // Shrink the window from the left if there are more than k unique numbers
            while (k < 0) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    k++;
                }
                left++;
            }

            // All subarrays ending at right and starting from left to right are valid
            result += right - left + 1;
        }

        return result;
    }
}