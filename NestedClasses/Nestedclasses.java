package NestedClasses;

public class Nestedclasses {
    public static void main(String[] args) {
        Outer outer=new Outer();
        Outer.Inner inner=new Outer.Inner();
        inner.hello(outer);

    }
    
}
//example of the static nested class
class Outer{
            int x=4;

    static class Inner{


        void hello(Outer outer){
            System.out.println("Hello from the static nested class");
            System.out.println("Value of x: " + outer.x);
        }

    }
}
class BankAcount{
     
    static class InterestCalculator{
        private static double calculateInterestYearly(double principal){
            return principal*0.05;
        }
    }

    public double computeInterest(double principal){
        return InterestCalculator.calculateInterestYearly(principal);
    }
}
