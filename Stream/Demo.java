package Stream;
import java.util.*;
// import java.util.stream.Stream;
public class Demo {
    public static void main(String[] args) {
        // Boilerplate generated
       List<Integer>list=new ArrayList<>(List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15));
    
        //  list.stream().filter(n->n%2==0).forEach(n->System.out.println(n));
        // Stream<Integer>s=list.stream();
        // s=s.filter(x->x>10);
        // // s=s.map(x->x*2);
        // s.forEach(System.out::println);
        list.stream().filter(x->x>10).map(x->x*2).forEach(System.out::println);



    }
}
