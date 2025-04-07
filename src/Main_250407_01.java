/* 135. 分发糖果 */
public class Main_250407_01 {
    //官方的正确解法
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }

    //自己的错误的解法
    public int candy2(int[] ratings) {
        int n = ratings.length;
        int sum = 0;
        int right = 0;
        int left = 0;
        int pre = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0 && ratings[n - i - 1] > ratings[n - i]){
                if (left != 0 && left > right){
                    right = left + 1;
                }else {
                    right++;
                }
                sum += right;
            }else {
                right = 0;
            }
            if (i != 0 && ratings[i] > ratings[i - 1] && !(i != n - 1 && ratings[i] > ratings[i + 1])){
                if (pre != 0 && right > left){
                    left = pre + 1;
                }else {
                    left++;
                }
                sum += left;
            }else {
                left = 0;
            }
            pre = right;
            sum++;
        }
        System.out.println(" sum = " + sum);
        return sum;
    }

    public static void main(String[] args) {
        new Main_250407_01().candy(new int[]{1,3,4,5,2});
    }
}
