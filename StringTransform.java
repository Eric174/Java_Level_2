public class StringTransform {

    public static class StringToArrayException extends Exception {
        public StringToArrayException(String message) {
            super(message);
        }
    }

    public static class StringToInteger extends Exception {
        public StringToInteger(String message) {
            super(message);
        }
    }

    public static String[][] StrToTwoDimArr(String str) throws StringToArrayException {
        String[] str_arr = str.split("\n");
        if (str_arr.length != 4) {
            throw new StringToArrayException("Неверная длина массива, должна быть равна 4! Текущя длина: " + str_arr.length);
        }
        String[][] str_mas = new String[str_arr.length][];
        for (int i = 0; i < str_arr.length; i++) {
            str_mas[i] = str_arr[i].split(" ");
            if (str_mas[i].length != 4) {
                throw new StringToArrayException("Неверная длина массива для индекса i = " + i + ", должна быть равна 4! Текущя длина: " + str_mas[i].length);
            }
        }
        return str_mas;
    }

    public static float getSum(String[][] str) throws StringToInteger {
        int sum = 0;
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j ++) {
                try {
                    int num = Integer.parseInt(str[i][j]);
                    sum += num;
                } catch (Exception e) {
                    throw new StringToInteger("Не удалось преобразовать: " + str[i][j] + " к типу int");
                }
            }
        }
        return sum / 2f;
    }

    public static void main(String[] args) {
        String str = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";

        String[][] str_mas = new String[0][];
        try {
            str_mas = StrToTwoDimArr(str);
            System.out.println(getSum(str_mas));
        } catch (StringToArrayException | StringToInteger e) {
            System.out.println(e.getMessage());
        }

    }
}
