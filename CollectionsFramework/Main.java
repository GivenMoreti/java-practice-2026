package CollectionsFramework;

import java.util.*;

public  class Main{

    public static void main(String[] args) {

        Collection<String> strings = List.of("foo","doo","fff");
        Iterator<String> iterator = strings.iterator();

        while(iterator.hasNext()){
            String ele = iterator.next();
            if(ele.length() == 3){
                System.out.println(ele);
            }
        }

//        iterator.remove();
        System.out.println(iterator);

        //the global interface
        Collection<Integer> c = new ArrayList<>();
        //all the interfaces extends the Collection interface.

        Collection<String> fruits  = new ArrayList<>();
        fruits.add("banana");
        fruits.add("apple");
        fruits.add("kiwi");

//        fruits.forEach(f -> System.out.println(f));
        fruits.forEach(System.out::println);        //method reference

        //list interface
        List<Integer> arrList = new ArrayList<>();

        //allows duplicates elements
        //maintains element insertion order
        //resizeable
        //uses wrapper classes as types
        List<Integer> linkedList = new LinkedList<>();
        List<Integer> vector = new Vector<>();


        //Queue interface
        Queue<Integer> q1 = new PriorityQueue<>();


        //deque extends queues
        Deque<Integer> dq = new ArrayDeque<>();
        Deque<Integer> dq2 = new LinkedList<>();

        //Set
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new LinkedHashSet<>();

        //sorted set extends sets
        SortedSet<Integer> ss = new TreeSet<>();


        //maps
        Map<Integer,Integer> hm = new HashMap<>();
        Map<Integer,Integer> lm = new LinkedHashMap<>();
        Map<Integer,Integer> tm = new Hashtable<>();

        //tree map
        SortedMap<Integer,String> sortedMap = new TreeMap<>();


        sortedMap.put(0,"joe");
        sortedMap.put(1,"kane");
        sortedMap.put(3,"kim");



        System.out.println(sortedMap.size());
        System.out.println(sortedMap.get(1));
        System.out.println(sortedMap.get(2));
        System.out.println(sortedMap.get(3));

        System.out.println("looping");
           for(Integer i:sortedMap.keySet()){
               System.out.println(i);
           }


        for(String i:sortedMap.values()){
            System.out.println(i);
        }









    }
}