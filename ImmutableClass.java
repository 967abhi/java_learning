public class ImmutableClass {
    public static void main(String[] args) {

        College college = new College("IITG", "Guwahati");
        Student s1 = new Student("Aditya", 22, college);

        // 1. Changing the ORIGINAL object passed to Student
        college.setName("IITB");

        System.out.println(s1.getCollege().getName());
        // IITG
        // Student has its own copy of College.

        // 2. Changing the object returned by the getter
        College returnedCollege = s1.getCollege();
        returnedCollege.setName("IITD");

        System.out.println(s1.getCollege().getName());
        // IITG
        // Getter returned a copy, so Student's College was not changed.

        System.out.println(s1);
        // Student{name='Aditya', age=22, college=IITG}
    }

    static final class Student {

        private final String name;
        private final int age;
        private final College college;

        public Student(String name, int age, College college) {
            this.name = name;
            this.age = age;

            // Defensive copy IN
            this.college = new College(
                    college.getName(),
                    college.getAddress()
            );
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        // Defensive copy OUT
        public College getCollege() {
            return new College(
                    college.getName(),
                    college.getAddress()
            );
        }

        @Override
        public String toString() {
            return "Student{name='" + name +
                    "', age=" + age +
                    ", college=" + college.getName() + "}";
        }
    }

    static class College {

        private String name;
        private String address;

        public College(String name, String address) {
            this.name = name;
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
