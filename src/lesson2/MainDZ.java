package lesson2;

public class MainDZ {

    private static final int ARRAYDIMENSION = 4;

    public static void main(String[] args) {
        String[][] myArray = {
                {"1", "2", "3","4"},
                {"5", "6", "7","8"},
//                {"9", "10", "11", "12", "13"},            //наборы для теста
//                {"9", "10", "11"},                        //наборы для теста
                {"9", "10", "ERT", "12"},                 //наборы для теста
//                {"9", "10", "11", "12"},
                {"13", "14", "15","16"}
        };

        try {
            System.out.println("Sum of array elements: " + arrayTest(myArray));
        }
        catch (MyArraySizeException e) {
            e.printStackTrace();
            System.out.println("Count: " + e.getCount());
        }
        catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Item position: [" + e.getI() + "][" + e.getJ() + "]");
        }
    }

    static public int arrayTest(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if (array.length != ARRAYDIMENSION) {
            throw new MyArraySizeException("The number of rows in the array is not equal to 4! ",  array.length);
        }

        for (int j = 0; j < array.length; j++) {
            if (array[j].length != ARRAYDIMENSION) {
                throw new MyArraySizeException("In a row with index " + j + ", count of elements is not equal to 4! " , array[j].length);
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                }
                catch (NumberFormatException e) {
                    throw  new MyArrayDataException("Item is not a number! ", i, j);
                }
            }
        }

        return sum;
    }

}
