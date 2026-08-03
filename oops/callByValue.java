public class callByValue {
    public static void main(String[] args) {
        int x=10;
        int y=20;
        System.out.println(x+","+y);
        // swap(x,y);
        addtyen(x,y);
        System.out.println(x+","+y);
    }
    static void addtyen(int x,int y){
        x=x+10;
        y=y+10;
    }
}
