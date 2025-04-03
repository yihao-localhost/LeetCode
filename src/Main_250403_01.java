/* 45. ÌøÔ¾ÓÎÏ· II */
public class Main_250403_01 {
    public int jump(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        for(int i = 0, curMax = 0, nextMax = 0; i < len - 1; i++){
            nextMax = Math.max(nextMax, i + nums[i]);
            if(i == curMax){
                cnt++;
                if(nextMax >= len -1) return cnt;
                curMax = nextMax;
            }
        }
        return cnt;
    }
}
