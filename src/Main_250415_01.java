import java.util.*;

/* 15. 三数之和 */

//解法一：暴力解法（超时）
public class Main_250415_01 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> trip = new ArrayList<>();
                        trip.add(nums[i]);
                        trip.add(nums[j]);
                        trip.add(nums[k]);
                        Collections.sort(trip);
                        set.add(trip);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    //解法二：双指针
    public List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        if(nums == null || nums.length < 3) return null;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> trip = new ArrayList<>();
                    trip.add(nums[i]);
                    trip.add(nums[left]);
                    trip.add(nums[right]);
                    Collections.sort(trip);
                    left++;
                    right--;
                    set.add(trip);
                }else if (nums[i] + nums[left] + nums[right] > 0) {
                    right--;
                }else {
                    left++;
                }
            }
        }
        return new ArrayList<>(set);
    }
}


