/* 27. �Ƴ�Ԫ�� */
public class Main_250329_02 {
    public int removeElement(int[] nums, int val) {
        int p = nums.length;
        for (int i = p - 1; i >= 0; i--) {
            if(nums[i] == val){
                for(int j = i; j < p - 1; j++){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                p--;
            }
        }
        return p;
    }

    public int removeElement_2(int[] nums, int val) {
        int left = 0; // ָ����һ��������λ��
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right]; // ֱ�Ӹ��ǣ����轻��
                left++;
            }
        }
        return left; // left ��Ϊ��ЧԪ�ص�����
    }

}
