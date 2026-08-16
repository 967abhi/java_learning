package Enum;

public class Demo3 {
    public static void main(String[] args){
        NORTDIRECTION north=new NORTDIRECTION();
        SoutDirection south=new SoutDirection();
        EastDirection east=new EastDirection();
        System.out.println(north.move());
        System.out.println(south.move());
        System.out.println(east.move());

    }

    static abstract class Direction{
        public abstract String move();
    }
    static class NORTDIRECTION extends Direction{
        @Override
        public String move(){
            return "North direction";
        }

    }
    static class SoutDirection extends Direction{
        @Override
        public String move(){
            return "South Direction";
        }
    }
    static class EastDirection extends Direction{
        @Override
        public String move(){
            return "East Direction";
        }
    }
}
