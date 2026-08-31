package Comparable;

import java.util.*;

public class Demo {
    public static void main(String[] args){
        List<Student>list=new ArrayList<>();
        list.add(new Student("abhishe", 85));
         list.add(new Student("raj", 95));
         list.add(new Student("Rohan", 85));
         Collections.sort(list);
         for(Student s:list){
            System.out.println(s.name+" "+s.marks);
         }
        //  System.out.println(list);
        // so here we got the issues because java donot know how to do the sort and there we got the issues 
        // so know if i will do normal then it will not give the issues 
        // List<Integer>list1=new ArrayList<>();
        // list1.add(1);
        // list1.add(2);
        // Collections.sort(list1);
        // so here we not get the issues because there java knows what to compare so there the student class will extends with the comparable and then implement 
    
        

    }
    
}
class Student implements Comparable<Student>{
    String name;
    int marks;
    Student(String name,int marks){
        this.name=name;
        this.marks=marks;
    }
    @Override
    public int compareTo(Student other){
        // return this.marks-other.marks;
        if(this.marks!=other.marks){
            return this.marks-other.marks;

        }
        return this.name.compareTo(other.name);

    }
}

//this.marks-other,amrks
//<0:this.marks,other.marks
//>0:this.marks,other.marks 

