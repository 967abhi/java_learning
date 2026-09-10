package optional_class;

import java.util.Optional;

public class Demo {
    public static void main(String[] args) {
        // Boilerplate generated
     
        Optional<String>name=getName();
        // System.out.println(name.isPresent());
        System.out.println(name.get());

    }
    public static Optional<String>getName(){
        return Optional.of("Abhishek");
       
    }
    
}
