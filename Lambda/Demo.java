import java.util.*;
public class Demo {
    public static void main(String[] args) {
        // Boilerplate generated
        List<Student>list=new ArrayList<>();
        list.add(new Student("abhishek",101,85));
        list.add(new Student("raj",102,86));
        list.add(new Student("rohan",103,88));
        Comparator<Student>c1=new SortByName();
        Comparator<Student>c2=new SortByMarks();
        Comparator<Student>c3=new SortByRoll_No();
        Collections.sort(list,c3);
        for (Student s : list) {
            System.out.println(s.name + " " + s.roll_no + " " + s.marks);
        }        

    }
}
// Then how this sort funcvtiuon is working 
// sort->c1,c2 
// so this is lot of the code so to solve thius problem java take some thing that are anonymous class 

class SortByName implements Comparator<Student>{
    @Override
    public int compare(Student s1,Student s2){
        return s1.name.compareTo(s2.name);

    }
}
class SortByRoll_No implements Comparator<Student>{
    @Override
    public int compare(Student s1,Student s2){
        return s1.roll_no-s2.roll_no;

    }
}
class SortByMarks implements Comparator<Student>{
    @Override
    public int compare(Student s1,Student s2){
        return s1.marks-s2.marks;

    }
}

class Student implements Comparable<Student>{
    String name;
    int roll_no;
    int marks;
    Student(String name,int roll_no,int marks){
        this.name=name;
        this.roll_no=roll_no;
        this.marks=marks;
    }
    @Override
    public int compareTo(Student s){
        return this.marks-s.marks;

    }
}

// so this is tight coupled to sort this 
