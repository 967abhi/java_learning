package Enum;

public class Demo1 {
    public static void main(String[]args){
      PaymenntStatus Status=PaymenntStatus.SUCCESS;
      System.out.println((Status.name()));

    }
}

enum PaymenntStatus{
    SUCCESS,
    FAILED,
    PENDING,

}
