package DSA.array;

import java.util.*;

//https://leetcode.com/problems/insert-delete-getrandom-o1
public class L380InsertDeleteGetRandom {

    Map<Integer, Integer> map;
    List<Integer> list;
    Random random;

    public L380InsertDeleteGetRandom() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        Integer indexInList = map.get(val);
        Integer lastElement = list.get(list.size() - 1);

        list.set(indexInList, lastElement);
        list.remove(list.size() - 1);

        map.put(lastElement, indexInList);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomNumber = random.nextInt(list.size());
        return list.get(randomNumber);
    }
}

//TC:
//Insert: O(1) on average, as both inserting into a list and a hash map are O(1).
//Remove: O(1) on average, as we swap the last element and remove in constant time.
//GetRandom: O(1), as accessing an element by index in a list is constant time.

//SC: : O(n), where n is the number of elements in the set.
// We store the elements in both a list and a map, each requiring O(n) space.
