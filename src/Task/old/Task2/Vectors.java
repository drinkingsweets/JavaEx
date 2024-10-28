package Task.old.Task2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Vectors {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double[] v1 = Arrays.stream(s.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        double[] v2 = Arrays.stream(s.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        System.out.println(countLetters(v1));


    }
    static double scalarProduct(double[] vec1, double[] vec2) {
        double res = 0.0;

        for (int i = 0; i < 3; i++) {
            res += (vec1[i] * vec2[i]);
        }
        return res;
    }

    static double[] vectorProduct(double[] vec1, double[] vec2) {
        return new double[]{(vec1[1] * vec2[2] - vec1[2] * vec2[1]),
                (vec1[2] * vec2[0] - vec1[0] * vec2[2]), (vec1[0] * vec2[1] - vec1[1] * vec2[0])};
    }

    static double[] vectorSum(double[] vec1, double[] vec2) {
        return new double[]{vec1[0] + vec2[0], vec1[1] + vec2[1], vec1[2] + vec2[2]};
    }

    static double[] vectorSubtract(double[] vec1, double[] vec2) {
        return new double[]{vec1[0] - vec2[0], vec1[1] - vec2[1], vec1[2] - vec2[2]};
    }

    static double vectorModule(double[] vec1) {
        return Math.sqrt(Math.pow(vec1[0], 2) + Math.pow(vec1[1], 2) + Math.pow(vec1[2], 2));
    }

    static double vectorAngle(double[] vec1, double[] vec2) {
        double dotProduct = vec1[0] * vec2[0] + vec1[1] * vec2[1] + vec1[2] * vec2[2];
        double mag1 = Math.sqrt(vec1[0] * vec1[0] + vec1[1] * vec1[1] + vec1[2] * vec1[2]);
        double mag2 = Math.sqrt(vec2[0] * vec2[0] + vec2[1] * vec2[1] + vec2[2] * vec2[2]);
        return Math.round(Math.toDegrees(Math.acos(dotProduct / (mag1 * mag2))) * 100.0) / 100.0;
    }

    static double[] rotateVector(double[] vec, double[][] rotationMatrix) {
        double[] result = new double[3];
        for (int i = 0; i < 3; i++) {
            result[i] = rotationMatrix[i][0] * vec[0] + rotationMatrix[i][1] * vec[1] + rotationMatrix[i][2] * vec[2];
        }
        return result;
    }

    static double[] projectionVector(double[] vec1, String where){
        switch (where){
            case "xz":
                return new double[]{vec1[0], 0, vec1[2]};
            case "xy":
                return new double[]{vec1[0], vec1[1], 0};
            case "yz":
                return new double[]{0, vec1[1], vec1[2]};
        }
        return null;
    }

    static boolean vectorParallel(double[] vec1, double[] vec2) {
        return ((vec1[0] / vec2[0] == vec1[1] / vec2[1]) && (vec1[1] / vec2[1] == vec1[2] / vec2[2]));
    }

    static boolean vectorPerpendicular(double[] vec1, double[] vec2) {
        return (scalarProduct(vec1, vec2) == 0);
    }

    static void vectorLogic3(double[] vec1) {
        String[] vec2 = new String[3];

        for (int i = 0; i < 3; i++) {
            vec2[i] = Integer.toBinaryString((int) vec1[i]);
        }

        String[] notVec = new String[3];
        String[] leftVec = new String[3];
        String[] rightVec = new String[3];

        for (int i = 0; i < 3; i++) {
            int value = Integer.parseInt(vec2[i], 2);

            notVec[i] = Integer.toBinaryString(~value);
            leftVec[i] = Integer.toBinaryString(value << 3);
            rightVec[i] = Integer.toBinaryString(value >> 3);
        }

        System.out.println("Исходный вектор (double): " + Arrays.toString(vec1));
        System.out.println("Двоичное представление (int): " + Arrays.toString(vec2));
        System.out.println("Побитовый оператор «НЕ»: " + Arrays.toString(notVec));
        System.out.println("Сдвиг влево на 3 бита: " + Arrays.toString(leftVec));
        System.out.println("Сдвиг вправо на 3 бита: " + Arrays.toString(rightVec));
    }

    static void vectorLogicTwo(double[] vec1, double[] vec2) {
        String[] hexVec1 = new String[3];
        String[] hexVec2 = new String[3];

        for (int i = 0; i < 3; i++) {
            hexVec1[i] = Integer.toHexString((int) vec1[i]);
            hexVec2[i] = Integer.toHexString((int) vec2[i]);
        }

        int[] v1 = new int[3];
        int[] v2 = new int[3];

        for (int i = 0; i < 3; i++) {
            v1[i] = Integer.parseInt(hexVec1[i], 16);
            v2[i] = Integer.parseInt(hexVec2[i], 16);
        }

        int[] vecAnd = new int[3];
        int[] vecOr = new int[3];
        int[] vecXor = new int[3];

        for (int i = 0; i < 3; i++) {
            vecAnd[i] = v1[i] & v2[i];
            vecOr[i] = v1[i] | v2[i];
            vecXor[i] = v1[i] ^ v2[i];
        }

        System.out.println("Вектор 1 (в шестнадцатеричном формате): " + Arrays.toString(hexVec1));
        System.out.println("Вектор 2 (в шестнадцатеричном формате): " + Arrays.toString(hexVec2));
        System.out.println("Результат побитового «И»: " + Arrays.toString(convertToHex(vecAnd)));
        System.out.println("Результат побитового «ИЛИ»: " + Arrays.toString(convertToHex(vecOr)));
        System.out.println("Результат побитового исключающего «ИЛИ»: " + Arrays.toString(convertToHex(vecXor)));
    }

    static String[] convertToHex(int[] array) {
        String[] hexArray = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            hexArray[i] = Integer.toHexString(array[i]);
        }
        return hexArray;
    }

    static HashMap<String, Integer> countLetters(double[] vec1) {
        int[] v1 = new int[3];

        for (int i = 0; i < 3; i++) {
            v1[i] = (int) vec1[i] % 10;
        }

        String[] words = new String[]{"ноль", "один", "два", "три", "четыре", "пять",
        "шесть", "семь", "восемь", "девять"};
        String[] inWord = new String[3];

        for (int i = 0; i < 3; i++) {
            inWord[i] = words[v1[i]];
        }

        HashMap<String, Integer> counter = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < inWord[i].length(); j++) {
                counter.merge(Character.toString(inWord[i].charAt(j)), 1, Integer::sum);
            }
        }
        return counter;
    }
}
