import java.util.*;

/* 380. O(1) 时间插入、删除和获取随机元素 */
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

        // 通过map可以直接获得要删除的元素的索引
        int index = map.get(val);

        // 将要删除的元素和最后一个元素互换位置，然后再删除最后一个元素
        // 记得map中也要更新原来最后一个元素的新index，删除要删除的元素
        int last = list.get(list.size() - 1);
        list.set(index, last);
        list.remove(list.size() - 1);
        map.put(last, index);
        // 删除操作要放到最后，否则如果只有一个元素的情况，map.put(last, index)又把这一个元素放进去了
        map.remove(val);
        return true;
    }

    public int getRandom() {
        // Math.random()返回的是[0, 1)之间的随机数，不包括1
        int randomIndex =(int) (Math.random() * (double)list.size());
        return list.get(randomIndex);
    }
}
