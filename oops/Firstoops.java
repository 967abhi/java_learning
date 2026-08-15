public class Firstoops {
    public static void main(String[] args) {
    Student s1;
    Student s2;
    s1=new Student();
    s2=new Student();

    s1.name="aditya";
    s1.college="iit";
    s1.roll_no=134;
    s1.age=12;

    s2.name="rohan";
    s2.age=111;
    s2.college="samstipur";
    s2.roll_no=45;


    s1.markattendance();
    s2.markattendance();

    s1.print();
    s2.print();

    }

    static class Student {
        //characteristics of student
        String name;
        int age;
        int roll_no;
        String college;


        //behaviour of student
        void markattendance(){
            System.out.println("Attendace marked by"+ name);
        }
        void print(){
                System.out.println(name+" "+ age+" "+roll_no+" ");
        }

    }
}


//java is almost completely object oriented programming language
