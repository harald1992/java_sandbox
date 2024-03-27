package mapsAndSets;

import java.util.*;

public class MapsAndSetsMain {

    public static void mapsAndSetsStart() {
        hashMap();
        hashSets();
    }

    private static void hashMap() {
        // hashMap = key value pair
        Map<String, String> myMap = Map.of("key1", "value1", "key2", "value2");
        System.out.println(myMap.getOrDefault("key2", "Value3, not found"));
    }


    // group similar objects together and handle them as one unit. Has similar things as lists
    // called hashSet because it is using a hash-table as storage mechanism. It works quite quick to add elements to a set, constant time.
    // a list gets more expensive the larger it gets.
    private static void hashSets() {
        Set<String> names = new HashSet<>();
        names.add("Henry");
        names.add("Walter");
        names.add("Gus");
        names.add("Skyler");
        names.add("Henry"); // sets don't allow duplicates.
        // System.out.println(names);  // prints in different order, so different than lists. If you want to have it ordered in sorting, you can use TreeSet (but is slower). If you want to keep the insertion order, use LinkedHashSet.

        names.remove("Walter");
        names.remove(0); // doesnt work because hashSets have to particular index.
        // System.out.println(names.contains("Walter"));


        // names.forEach(System.out::print);

        Iterator<String> namesIterator = names.iterator();
        while(namesIterator.hasNext()) {
            System.out.println(namesIterator.next());
        }

        List<Integer> listWithDuplicates = List.of(5,5,5,5,5,5,5,5,5,5,5,5);
        Set<Integer> setWithoutDuplicates = new HashSet<>(listWithDuplicates);  // like set.addAl(list) function;
        System.out.println(setWithoutDuplicates);
    }

}
