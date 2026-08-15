public class Static {

    public static void main(String[] args){
        System.out.println("Hello, World!");
        Student s1=new Student("Aditya",12,1);
        Student s2=new Student("Rohan",13,2);
        System.out.println(s1.name+" "+Student.college);
        System.out.println(s2.name+" "+Student.college);

    }

    static class Student{
        String name;
        int age;
        int roll_no;
        static String college;

        Student(String name,int age,int roll_no){
            this.name = name;
            this.age = age;
            this.roll_no = roll_no;

        }
        //static block
        static{
            college="IIT";
        }
    }
}
