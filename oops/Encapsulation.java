public class Encapsulation {
    public static void main(String[] args) {

        BankAccount ba = new BankAccount();
        // ba.deposit(10000);
        // System.out.println(ba.getbalance());
        // so here we are directly access and modifying the balance of the account that
        // is wrong
        // so we read about the access modifiers we will use that
        // just making the private as a access then it gives the error:= The field
        // BankAccount.balance is not visible
        ba.deposit(10000);
        System.out.println("balance after the depositt:"+ba.getbalance());
        ba.withdraw(2500);
        System.out.println("balance after the withdraw:"+ba.getbalance());
       System.out.println("Total amount :"+ba.getbalance());    

       Student s1=new Student("Aditya",12,1,"IIT");
       System.out.println("Name:"+s1.getName());
       System.out.println("College:"+s1.getCollege());
       System.out.println("Age:"+s1.getAge());  
       s1.setAge(15);;
       s1.getAge();
       System.out.println("Age after the setter:"+s1.getAge());


    }
}

class BankAccount {
    private double balance;

    public void deposit(int amount){
        balance+=amount;
    }
    public void withdraw(int amount ){
        balance-=amount;
    }
    //getter/setter 
    public double getbalance(){
        return balance;
    }

}
class Student{
   private String name;
   private int roll_number;
   private int age;
   private String college;

//constructor 
   Student(String name,int roll_number,int age,String college){
    this.name=name;
    this.roll_number=roll_number;
    this.age=age;
    this.college=college;
   }
   public String getName(){
    return name;
   }
   //setter oif the getname
   public void setName(String name){
    this.name=name;
   }
   //get college
   public String getCollege(){
    return college;
   }
   //setter college
   public void setCollege(String college){
    // so here i can write the validation to check the college exit or not 
    this.college=college;
   }
   //get age;
   public int getAge(){
    return age;

   }
   //setter age;
   public void setAge(int age){
    if(age>100){
        System.out.println("Age is not valid");
    }
    else{
        this.age=age;
    }
   }


}