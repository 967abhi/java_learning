package Interable;

// import java.util.ArrayList;
// import java.util.Iterator;
// import java.util.LinkedList;
import java.util.*;

public class Deom {
    public static void main(String[] args){
        // List<Integer>list=new LinkedList<>();
        // list.add(10);
        // list.add(20);
        // list.add(30);
        // list.add(40);
        // list.add(50);

        // Iterator<Integer>it=list.iterator();
        // while(it.hasNext()){
        //     System.out.println(it.next());
        // }
        Collection<Integer>list=new HashSet<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        Iterator<Integer>it=list.iterator();
        while(it.hasNext()){
            System.out.println(it.next()); 
        }


    }
}
