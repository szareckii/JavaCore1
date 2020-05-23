package lesson2;

public class MyArraySizeException extends ArrayIndexOutOfBoundsException {

    private int count;

    public int getCount() {
        return count;
    }

    public MyArraySizeException(String message, int count) {
        super(message);
        this.count = count;
    }
}
