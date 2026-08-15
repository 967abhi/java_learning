public class Interface {
// IImplement the interface class and everything about the interface
public static void main(String[] args) {
    school s1=new school();
    s1.study();
    s1.markAttendace();
    s1.gotoschool();
}

    interface Student{
        void study();
        void markAttendace();
        void gotoschool();

    }
    static class school implements Student{
        @Override
        public void study() {
            System.out.println("Student is studying");
        }

        @Override
        public void markAttendace() {
            System.out.println("Student is marking attendance");
        }

        @Override
        public void gotoschool() {
            System.out.println("Student is going to school");
        }
    }
    static class EngineeringSchool implements Student{
        @Override
        public void study() {
            System.out.println("Engineering student is studying");
        }

        @Override
        public void markAttendace() {
            System.out.println("Engineering student is marking attendance");
        }

        @Override
        public void gotoschool() {
            System.out.println("Engineering student is going to school");
        }
    }
}
