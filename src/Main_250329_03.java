public class Main_250329_03 {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len < 2) return len;
        int idx = 0;
        for (int i = 1; i < len; i++){
            if(nums[i] != nums[idx]){
                nums[++idx] = nums[i];
            }
        }
        return idx + 1;
    }


}
