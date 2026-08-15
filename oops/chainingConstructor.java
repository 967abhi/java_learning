public class chainingConstructor {
    public static void main(String[] args) {
        Student s1=new Student();
       Student s2=new Student(":aditya");
       Student s3=new Student("rohan",12);
    //    s1().markattendance();
       s1.print();
       s2.print();
       s3.print();


    }

    static class Student{
        //Characteristics of student
        String name;
        int age;
        int roll_no;
        String college;

        //Default constructor
        Student(){
            System.out.println("Default constuructor called");

        }
        //name string
        Student(String name){
            this.name=name;
        }
        //name and age
        Student(String name,int age){
            this.name=name;
            this.age=age;
        }
        //name age,roll number
        Student(String name,int age,int roll_no){
            this.name=name;
            this.age=age;
            this.roll_no=roll_no;
        }
        //NAME AGE ROLL NUMBER COLLEGE
        Student(String name,int age,int roll_no,String college){
            this.name=name;
            this.age=age;
            this.roll_no=roll_no;
            this.college=college;
        }

        void markattendance(){
            System.out.println("Attendace marked by"+ name);
        }
        void print(){
            System.out.println(name+" "+ age+" "+roll_no+" ");
        }

    }
}
