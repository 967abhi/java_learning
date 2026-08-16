package NestedClasses;

public class Local{
    public static void main(String[] args){
        OuterLocal o = new OuterLocal();
        o.greet();
    }

}
class OuterLocal {
    void greet(){
        //a local class is declared inside a method and only visible in that method
        class Greeter{
            void hello(){
                System.out.println("Hello from the local class");
            }
        }
        Greeter g = new Greeter();
        g.hello();
    }
}
