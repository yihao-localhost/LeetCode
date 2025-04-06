import java.util.*;

/* 380. O(1) ʱ����롢ɾ���ͻ�ȡ���Ԫ�� */
public class Main_250406_01 {

    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;

    public void RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }

        // ͨ��map����ֱ�ӻ��Ҫɾ����Ԫ�ص�����
        int index = map.get(val);

        // ��Ҫɾ����Ԫ�غ����һ��Ԫ�ػ���λ�ã�Ȼ����ɾ�����һ��Ԫ��
        // �ǵ�map��ҲҪ����ԭ�����һ��Ԫ�ص���index��ɾ��Ҫɾ����Ԫ��
        int last = list.get(list.size() - 1);
        list.set(index, last);
        list.remove(list.size() - 1);
        map.put(last, index);
        // ɾ������Ҫ�ŵ���󣬷������ֻ��һ��Ԫ�ص������map.put(last, index)�ְ���һ��Ԫ�طŽ�ȥ��
        map.remove(val);
        return true;
    }

    public int getRandom() {
        // Math.random()���ص���[0, 1)֮����������������1
        int randomIndex =(int) (Math.random() * (double)list.size());
        return list.get(randomIndex);
    }
}
