public class Local{
    public static void main(String[] args){

    }

}
class outer {
    void greet(){
        class Local{
            void hello(){
                System.out.println("Hello from the local class");
            }
        }
    }
}