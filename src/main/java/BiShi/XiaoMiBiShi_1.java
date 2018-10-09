package main.java.BiShi;

import java.util.*;

/**
 * @author: Rinchar
 * @date: 2018/9/27
 **/
public class XiaoMiBiShi_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        List<List<Integer>> setList = new ArrayList<>();
        Map<Integer, Integer> timesMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = in.nextLine();
            String[] strList = str.trim().split(" ");
            List<Integer> intList = new ArrayList<>();
            for (String item : strList) {
                int tempInt = Integer.valueOf(item);
                intList.add(tempInt);
                if (timesMap.containsKey(tempInt)) {
                    timesMap.put(tempInt, timesMap.get(tempInt) + 1);
                } else {
                    timesMap.put(tempInt, 1);
                }
            }
            setList.add(intList);
        }
        while (!isAllSingle(timesMap)) {
            int max = findMax(timesMap);
            Set<Integer> tempSet = new HashSet<>();
            for (int i = 0; i < setList.size(); i++) {
                List<Integer> tempList = setList.get(i);
                if (tempList.contains(max)) {
                    for (Integer intTemp : tempList) {
                        tempSet.add(intTemp);
                    }
                    setList.remove(i);
                    i--;
                }
            }
            setList.add(new ArrayList<>(tempSet));
            timesMap = new HashMap<>();
            for (List<Integer> item : setList) {
                for (Integer intItem : item) {
                    if (timesMap.containsKey(intItem)) {
                        timesMap.put(intItem, timesMap.get(intItem) + 1);
                    } else {
                        timesMap.put(intItem, 1);
                    }
                }
            }
        }
        System.out.println(setList.size());
        int maxNumSet = 0;
        for (List<Integer> item : setList) {
            if (item.size() > maxNumSet) {
                maxNumSet = item.size();
            }
        }
        System.out.println(maxNumSet);
    }

    private static int findMax(Map<Integer, Integer> map) {
        int re = 0, pos = Integer.MIN_VALUE;
        for (Integer key : map.keySet()) {
            if (re < map.get(key)) {
                re = map.get(key);
                pos = key;
            }
        }
        return pos;
    }

    private static boolean isAllSingle(Map<Integer, Integer> map) {
        for (Integer key : map.keySet()) {
            if (map.get(key) != 1) {
                return false;
            }
        }
        return true;
    }
}
