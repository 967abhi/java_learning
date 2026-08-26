package List;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        // System.out.println(list.get(3));
        list.set(1, 5);
        System.out.println(list);
        list.addAll(2,List.of(9,8,7));
        System.out.println(list);


        List<Integer> i=List.of(1,2,3,4,5,6,7,8);
        
        System.out.println(i);

    }
}
