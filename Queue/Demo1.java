package Queue;

import java.util.*;

public class Demo1 {
    public static void main(String[] args){
        ArrayDeque<Integer>queue=new ArrayDeque<>();
        //single ended queue 
        //Enqueue method 
        queue.add(1);
        queue.offer(2);
        queue.offer(3);
        //show here the difference between add and offer id the add is failed then add will give the expection error 
        // but the offer will  show any false 
        //offer will safe version 
        //front access methid 
        // System.out.println(queue.peek());
        // System.out.println(queue.element());
        // so there is also two way to print the top element  but there are two thing element is return the exception and then peak will return the null peak safe element is not safe
        //element remove 
        queue.remove();//throw exception 
        queue.poll();//return null 
        // so the remove is not safe because that will throw the exception but the nullpoll is safe because that will return the null 
        

        

    }
}
// Queue
// Dequeue interface 
// ArrayDequueuclass