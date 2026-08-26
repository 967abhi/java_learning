package Interable;
// C0ollection  

import java.util.*;

public class Demo4 {
   public static void main(String[] args){
    //  Collection<Integer>col=new ArrayList<>();
    Collection<Integer>col=new HashSet<>();
     col.add( 1);
     col.add(2);
     col.add(3);
     col.add(4);

     //size
    //  int n=col.size();
    //  System.out.println(n);
    //  System.out.println(col.isEmpty());

    //  //boolan Contains(objec o)->1,,2,3 equaks()

    // System.out.println(col.contains(2));
    // // once i change to hashset then time will constant o 1
    // // iterate->iterator
    // //object toArray();
    // Object[] obj=col.toArray();
    // for(Object o:obj){
    //     System.out.println(o);
    // }
    //toArray()


    // Integer[] arr2=new Integer[0];

    // Integer[]arr=col.toArray(arr2);
    // for(Integer i:arr){
    //     System.out.println(i);
    // }
//   boolean b=col.add(3);
//   so it give false because hashset not allowed duplicate value 
//   System.out.println(b);
// boolean remove (object obj);
// System.out.println(col.remove(3));

// // print the items of the HashSet after removal
// System.out.println("Items after remove:");
// for (Integer i : col) {
//     System.out.println(i);
// }
// addall 
 col.addAll(List.of(5,6,7,8,9));
 System.out.println(col);
     
   }
    
}
