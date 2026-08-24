package typecasting;
// generics

public class Demo1 {
    public static void main(String[] args) {
        Box<String> box = new Box<>("Hello world");
        System.out.println(box);
    }
}

class Box<T> {
    public T value;

    Box(T value) {
        this.value = value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}