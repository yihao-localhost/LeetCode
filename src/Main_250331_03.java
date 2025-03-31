/* 55. ��Ծ��Ϸ */
public class Main_250331_03 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int count = 1;
                int j = i + 1;
                while (j < nums.length && nums[j] == 0) {
                    count++;
                    j++;
                }
                boolean canSkip = false;
                for (int k = i - 1; k >= 0; k--) {
                    if (nums[k] + k >= i + count || nums[k] + k >= nums.length - 1) {
                        canSkip = true;
                        i += count - 1; // �����Ѵ����0
                        break;
                    }
                }
                if (!canSkip) {
                    // ����Ƿ��Ѿ������һ��λ�ã��������һ��λ����0��
                    return i + count >= nums.length && i == nums.length - 1;
                }
            }
        }
        return true;
    }
}
