/* 238. 除自身以外数组的乘积 */
public class Main_250406_02 {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = nums[0];
        right[len - 1] = nums[len - 1];
        for (int i = 1; i < len - 1; i++) {
            left[i] = left[i - 1] * nums[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }
        ans[0] = right[1];
        ans[len - 1] = left[len - 2];
        for (int i = 1; i < len - 1; i++) {
            ans[i] = left[i - 1] * right[i + 1];
        }
        return ans;
    }
}
