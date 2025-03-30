/* 189. 轮转数组 */
public class Main_250330_03 {
    /*
    方法 1：三次反转法（最优解）
    时间复杂度 O(n)，空间复杂度 O(1)
    思路：
    反转整个数组（[1,2,3,4,5,6,7] → [7,6,5,4,3,2,1]）。
    反转前 k 个元素（[7,6,5,4,3,2,1] → [5,6,7,4,3,2,1]）。
    反转剩余部分（[5,6,7,4,3,2,1] → [5,6,7,1,2,3,4]）。
    */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1); // 整体反转
        reverse(nums, 0, k - 1); // 反转前k个
        reverse(nums, k, n - 1); // 反转剩余部分
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public void rotate_2(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, n);
    }

    /*
    方法 3：环状替换（空间 O(1)，但较难理解）
    时间复杂度 O(n)，空间复杂度 O(1)
    思路：
    每次把 nums[i] 放到 nums[(i + k) % n]，并记录被替换的元素。
    循环处理，直到所有元素都被替换一次。
    */
    public void rotate_3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int count = 0;
        for (int start = 0; count < n; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (current != start);
        }
    }
}
