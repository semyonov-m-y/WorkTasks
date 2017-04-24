package workTasks;

import java.util.HashMap;
import java.util.Map;

//1b

public class Task2 {

    public static void main(String[] args) {
        Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < 101; i++) {
            hashMap.put(i, i % 9);
        }

        for (Map.Entry entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + " Value: "
                    + entry.getValue());
        }
    }
}
