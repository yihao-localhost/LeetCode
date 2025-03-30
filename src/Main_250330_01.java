/* 80. 删除有序数组中的重复项 II */
public class Main_250330_01 {
    public int removeDuplicates(int[] nums) {
        int flag = 1;
        int p = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[p]){
                flag++;
                if(flag == 2){
                    nums[++p] = nums[i];
                }
            }else {
                nums[++p] = nums[i];
                flag = 1;
            }
        }
        return p+1;
    }
}
