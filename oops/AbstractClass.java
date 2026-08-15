public class AbstractClass {
    public static void main(String[] args){
        Car c1=new FuelCar();
        Car c2=new ElectricCar();
        c1.start();
        System.out.println("Fuel car");
        c1.accelerate();
        c1.brake();
        c2.start();
        System.out.println("Electric car");
        c2.accelerate();
        c2.brake();

    }

}
abstract class Car{
    void start(){
        System.out.println("Car is started");
    }
    abstract void accelerate();
    abstract void brake();

}
class FuelCar extends Car{
    @Override
    void accelerate(){
        System.out.println("Fuel car is accelerating");
    }
    @Override
    void brake(){
        System.out.println("Fuel car is braking");
    }
}
class ElectricCar extends Car{
    @Override
    void accelerate(){
        System.out.println("Electric car is accelerating");
    }
    @Override
    void brake(){
        System.out.println("Electric car is braking");
    }
}
