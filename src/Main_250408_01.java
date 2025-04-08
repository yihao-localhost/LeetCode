import java.util.Arrays;

/* 42. ½ÓÓêË® */
public class Main_250408_01 {
    public int trap(int[] height) {
        int sum = 0;
        int n = height.length;
        int[] right = new int[n];
        int[] left = new int[n];
        right[0] = height[0];
        left[n - 1] = height[n - 1];
        for (int i = 1; i < n; i++) {
            right[i] = Math.max(right[i - 1], height[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            left[i] = Math.max(left[i + 1], height[i]); 
        }
        for (int i = 0; i < n; i++) {
            sum += Math.min(right[i],left[i]) - height[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        new Main_250408_01().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
