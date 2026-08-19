package Interface;

public class Demo1 {
    public static void main(String[] args){
       Payment p=new Creditcard();
       p.Pay();

    }
    
}
// interface Car{
// public void drive();
// }

// class Thar implements Car{
//     @Override
//     public void drive(){
//         System.out.println("Thar is Driving");
//     }
// }
//polymorphism 
interface Payment{
    void Pay();

}
class Creditcard implements Payment{
    @Override
    public void Pay(){
        System.out.println("Paying by Credit card");
    }
}
class DebitCard implements Payment{
    @Override
    public void Pay(){
    System.out.println("Paying by the Debit card");
    }
}