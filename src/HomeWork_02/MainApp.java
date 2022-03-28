package HomeWork_02;

public class MainApp {
    public static void main(String[] args){
        String[][] arr1 = new String[4][];
        arr1[0] = new String[]{"1", "2", "3", "4"};
        arr1[1] = new String[]{"1", "2", "3", "4"};
        arr1[2] = new String[]{"1", "2", "3", "4"};
        arr1[3] = new String[]{"1", "2", "3", "4"};

//        arr1[4] = new String[]{"1", "2", "3", "4"};

        try {
            System.out.println("Sum:\t" + sumArr(arr1));
        } catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }
    }

    public static int sumArr(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        if (arr.length > 4) {
            throw new MyArraySizeException("Размеры массива превышают допустимые.\nРабота программы прекращена.");
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > 4) {
                throw new MyArraySizeException("Размеры массива превышают допустимые.\nРабота программы прекращена.");
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e2){
                    throw new MyArrayDataException("Не числовые данные в ячейке [" + (i+1) + "][" + (j+1) +"]\nРабота программы прекращена.");
                }
            }
        }
        return sum;
    }
}
