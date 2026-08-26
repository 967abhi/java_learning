package Interable;

import java.util.*;

public class Demo3 {
    public static void main(String[] args){

    
    List<Integer> list =new ArrayList<>();
    list.add(10);
     list.add(20);
      list.add(30);
       list.add(40);
        list.add(50);
        Iterator<Integer> it=list.iterator();
        while(it.hasNext()){
            int value=it.next();
            if(value==30){
                list.remove(value);
            }
            System.out.println(it.next());
        }

    }

    
}
//Concurrent modification Exception  -->fail fast  
// Iterable gives object of iterator and then it override by arraylistiteraot 
// arraylist iterat and then in that i am able to hasnext and next 
// 1.speration of concern 
// 2.lass My Array lợt í
// int c] ar = { 10, 20, 303;
// int size = 3;
// Private int pos = 0; resetc
// posco;
// bublic boolean hajwert с 3
// atum pos< si ze;
// public boolean next () of
// xtun ar Epos ++];
// a=lx
// 10 241 30 2
// es pos
// d= new My Aray ListC);
// d xsetc);
// ,while(I.hes NeatC)) of
// int a = I.next();
// -while (l. hesNeн)ь
// int b= l'neeti
// са, 6);
// 1020
// 19 30