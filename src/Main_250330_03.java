/* 189. ��ת���� */
public class Main_250330_03 {
    /*
    ���� 1�����η�ת�������Ž⣩
    ʱ�临�Ӷ� O(n)���ռ临�Ӷ� O(1)
    ˼·��
    ��ת�������飨[1,2,3,4,5,6,7] �� [7,6,5,4,3,2,1]����
    ��תǰ k ��Ԫ�أ�[7,6,5,4,3,2,1] �� [5,6,7,4,3,2,1]����
    ��תʣ�ಿ�֣�[5,6,7,4,3,2,1] �� [5,6,7,1,2,3,4]����
    */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1); // ���巴ת
        reverse(nums, 0, k - 1); // ��תǰk��
        reverse(nums, k, n - 1); // ��תʣ�ಿ��
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
    ���� 3����״�滻���ռ� O(1)����������⣩
    ʱ�临�Ӷ� O(n)���ռ临�Ӷ� O(1)
    ˼·��
    ÿ�ΰ� nums[i] �ŵ� nums[(i + k) % n]������¼���滻��Ԫ�ء�
    ѭ������ֱ������Ԫ�ض����滻һ�Ρ�
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
