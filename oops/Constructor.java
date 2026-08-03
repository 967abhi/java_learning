public class Constructor {
    public static void main(String[] args) {
        Student s1=new Student("aditya",20,12,"iit");
        Student s2=new Student("rohan",22,111,"samstipur");

        s1.markattendance();
        s2.markattendance();

    }

}
class Student {
    //characteristics of student
    String name;
    int age;
    int roll_no;
    String college;
    //default constructor
   Student(){
        System.out.println("Constructor called");
    }
    //parameterized constructor
    Student(String name,int age,int roll_no,String college){
        this.name=name;
        this.age=age;
        this.roll_no=roll_no;
        this.college=college;
    }

    

    //behaviour of student
    void markattendance(){
        System.out.println("Attendace marked by"+ name);
    }
    void print(){
            System.out.println(name+" "+ age+" "+roll_no+" ");
    }

}
