public class Inheritance {
public static void main(String[] args){

    EngineeringStudent es=new EngineeringStudent();
    CSEEnginneringstudent cse=new CSEEnginneringstudent();
    es.AttendLab();
    es.markAttendance();
    cse.attendCselab();
    cse.AttendLab();
    cse.markAttendance();



}

    static class Student{

        String name;
        int age;

        void markAttendance(){
            System.out.println("Attendance marked by ");
        }

    }
    static class EngineeringStudent extends Student{
        void AttendLab(){
            System.out.println("Attend lab");
        }
    }

    //multilevel inheritance
    // so it will work like this a->b->c

    static class CSEEnginneringstudent extends EngineeringStudent{
        void attendCselab(){
            System.out.println("Attend cse lab");
        }
    }
}
