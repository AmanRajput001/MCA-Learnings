/**
 * 	Exploring the Collections Framework and various collection types in Java.
 */

import java.util.*;

public class CollectionsFrameworkExample {
    public static void main(String[] args) {
        // List Example
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Item 1");
        arrayList.add("Item 2");
        arrayList.add("Item 3");

        List<String> linkedList = new LinkedList<>();
        linkedList.add("Node 1");
        linkedList.add("Node 2");
        linkedList.add("Node 3");

        // Set Example
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Element 1");
        hashSet.add("Element 2");
        hashSet.add("Element 3");

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("B");
        treeSet.add("A");
        treeSet.add("C");

        // Queue Example
        Queue<String> queue = new LinkedList<>();
        queue.offer("Task 1");
        queue.offer("Task 2");
        queue.offer("Task 3");

        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("Priority 3");
        priorityQueue.offer("Priority 1");
        priorityQueue.offer("Priority 2");

        // Map Example
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Value 1");
        hashMap.put(2, "Value 2");
        hashMap.put(3, "Value 3");

        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Three", 3);
        treeMap.put("One", 1);
        treeMap.put("Two", 2);

        // Print Results
        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
        System.out.println("HashSet: " + hashSet);
        System.out.println("TreeSet: " + treeSet);
        System.out.println("Queue: " + queue);
        System.out.println("PriorityQueue: " + priorityQueue);
        System.out.println("HashMap: " + hashMap);
        System.out.println("TreeMap: " + treeMap);
    }
}
