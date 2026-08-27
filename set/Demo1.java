package set;

import java.util.*;

public class Demo1 {
    public static void main(String[] args){
        // //constructor of hashset/linkedhashset
        // Set<Integer> set=new HashSet<>();//16size
        // //inital capacity
        // Set<Integer>set2=new HashSet<>(100);
        // //capacity,load factor
        // Set<Integer>set3=new HashSet<>(100,08f);
        // //using another collection
        // Set<Integer>set4=new HashSet<>(List.of(1,2,3,4,5,6,7,8,9));
        // // they all are true for the linkedhashset

        TreeSet<Integer>set=new TreeSet<>();
        set.add(80);
        set.add(23);
        set.add(10);
        set.add(90);
        set.add(50);
        //sorted Interface they take o(logn)
        // System.out.println(set.first());
        // System.out.println(set.last());
        // System.out.println(set.headSet(80));
        // System.out.println(set.tailSet(80));
        // System.out.println(set.subSet(23, 80));

        //Navigable set 
        // largest number smaller then 80
        // System.out.println(set.lower(80));
        //greater element less then or qual to 80
        // System.out.println(set.floor(80));
        // smallest no.greater then 80
        // System.out.println(set.higher(80));
        // smallest np.greater thenor eual to  80
        // System.out.println(set.ceiling(80));
        // System.out.println(set.pollFirst());
        // System.out.println(set.pollLast());
        // System.out.println(set.descendingIterator());
        // System.out.println(set.descendingSet());



    }
    
}
// bst->leftest most mode->smallest
// rightestmost node->largest
