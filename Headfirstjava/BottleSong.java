package Headfirstjava;

public class BottleSong {
    
    public static void main(String[] args) {
        int bottles = 99;
        String word = "bottles";
        while (bottles > 0) {
            if (bottles == 1) {
                word = "bottle";
            }
            System.out.println(bottles + "green " + word + " of beer on the wall");
            System.out.println(bottles + "green " + word + " of beer");
            System.out.println("And if one green bottle should accidentally fall,");
            bottles=bottles - 1;
            if (bottles > 0) {
                System.out.println("There will be " + bottles + "green " + word + " of beer on the wall");
            } else {
                System.out.println("No more bottles of beer on the wall");
            }
    }
}
}