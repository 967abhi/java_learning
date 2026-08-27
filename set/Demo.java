package set;

import java.util.*;

public class Demo {
    public static void main(String[] args){
        Set<String> set=new HashSet<>();
        set.add("Abhishek");
        set.add("Rohan");
        set.add("Raj");
        // System.out.println(set.contains("Raj"));

        Map<Integer,String>mpp=new HashMap<>();
        mpp.put(101,"Abhishek");
        mpp.put(102,"Rohan");
        mpp.put(103,"Abhishek");
        System.out.println(mpp.containsKey(101));
        System.out.println(mpp.get(103));





    }
}
