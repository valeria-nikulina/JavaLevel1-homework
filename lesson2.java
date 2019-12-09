package homework_lesson2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class lesson2 {
   // Task 1. Инвертировать массив
    private static int[] invertarray (int[] inarr){
        int[] a = inarr;
        for (int i = 0; i < inarr.length; i++){
           a[i] = (inarr[i] == 1) ? 0 : 1;
       }
        return a;
    }

    // Task 2. Заполнить массив значениями 1 4 7 10 13 16 19 22
    private static int[] fillarray (int[] farr){
        int[] a = farr;
        for (int i = 0; i < farr.length; i++){
            switch (i) {
                case 0: a[i] = 1; break;
                default: a[i] = a[i-1]+3;
            }
        }
        return a;
    }

    // Task 3. Если число меньше 6, то умножить его на 2
    private static int[] mult2array (int[] marr){
        int[] a = marr;
        for (int i = 0; i < marr.length; i++){
            a[i] = (a[i] < 6) ? a[i]*2 : a[i];
        }
        return a;
    }

    // Task 4. Минимальное число в массиве
    private static int minInArray (int[] minarr){
        int a = minarr[0];
        for (int i = 0; i < minarr.length; i++){
            if (minarr[i] < a) { a = minarr[i]; }
        }
        return a;
    }

    // Task 4. Максимальное число в массиве
    private static int maxInArray (int[] maxarr){
        int a = maxarr[0];
        for (int i = 0; i < maxarr.length; i++){
            if (maxarr[i] > a) { a = maxarr[i]; }
        }
        return a;
    }

    // Task 5. Заполнить диагонали единицами (остальное рандомом, отличным от 1)
    private static int[][] diag1array (int[][] darr){
        for (int i = 0; i < darr.length; i++){
            for (int j = 0; j < darr.length;j ++) {
                Random r = new Random();
                darr[i][j] = ((i == j) || (j == darr.length - 1 - i)) ? 1 : r.nextInt(8)+2;
            }
        }
        return darr;
    }

    // Task 6. Поиск баланса в одномерном массиве
    private static boolean checkBalance (int[] barr){
        int ls = 0;
        int rs = 0;
        for (int i = 0; i < barr.length; i++){
            ls = ls + barr[i];
            rs = 0;
            for (int j = barr.length-1; j > i; j--) {
               //ls += barr[i];
               rs += barr[j];
            }
            if (ls == rs) {
                // System.out.println(ls + " || " + rs);
                return true;}
        }
        return false;
    }

    // Task 7-8. Сместить массив на n... будет работать только при n>=0
    public static int[] shiftRight(int[] array, int pos) {
        int size = array.length;
        for (int i = 0; i < pos; i++) {
            int temp = array[size - 1];
            for (int j = size - 1; j > 0; j--) {
                array[j] = array[j-1];
            }
            array[0] = temp;
            // System.out.println(Arrays.toString(array)); // track the movement
        }
        return array;
    }

    public static void main(String[] args) {
        // 1 Задать целочисленный массив, состоящий из элементов 0 и 1.
        // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод,
        // заменяющий в принятом массиве 0 на 1, 1 на 0;
        System.out.println("Task 1. Invert the array.");
        int[] arr;
        arr = new int[10];
        for (int i = 0; i < arr.length; i++){
            Random r = new Random();
            arr[i] = r.nextInt(2);
        }
        System.out.println("Initial array:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+((i==arr.length)? "" : "\t"));
        }
        System.out.println();
        System.out.println("Now let's invert the array:");
        arr = invertarray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+((i==arr.length)? "" : "\t"));
        }
        System.out.println("\n");

       // 2 Задать пустой целочисленный массив размером 8. Написать метод,
       // который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
        System.out.println("Task 2. Fill in the array:");
        int[] arr2 = new int[8];
        System.out.println(Arrays.toString(fillarray(arr2)));
        System.out.println("");


       // 3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,
       // принимающий на вход массив и умножающий числа меньше 6 на 2;
        System.out.println("Task 3. If < 6  → multiply 2:");
        int[] arr3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arr3));  // old array
        System.out.println(Arrays.toString(mult2array(arr3)));  // new array
        System.out.println("");


       // 4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
        System.out.println("Task 4. MIN and MAX in array:");
        int[] arr4 = new int[10];
        for (int i = 0; i < arr4.length; i++){
            Random r = new Random();
            arr4[i] = r.nextInt(21);
        }
        System.out.print("We have the array: ");
        System.out.println(Arrays.toString(arr4));
        System.out.println("MIN is: " + minInArray(arr4));
        System.out.println("MAX is: " + maxInArray(arr4));
        System.out.println("");

        // 5 Создать квадратный целочисленный массив (количество строк и столбцов одинаковое),
        // заполнить его диагональные элементы единицами, используя цикл(ы);
        System.out.println("Task 5. Fill diagonal with '1'.");
        int[][] arr5 = new int[5][5];

        arr5 = diag1array (arr5);
        for (int i = 0; i < arr5.length; i++){
            for (int j = 0; j < arr5.length; j ++) {
                System.out.print(arr5[i][j]);
                System.out.print((j == arr5.length - 1) ? "\n" : "\t");
            }
        }
        System.out.println("");

        // 6 Написать метод, в который передается не пустой одномерный целочисленный массив,
        // метод должен вернуть true если в массиве есть место, в котором сумма левой и правой
        // части массива равны. Примеры: checkBalance([1, 1, 1, || 2, 1]) → true,
        // checkBalance ([2, 1, 1, 2, 1]) → false, checkBalance ([10, || 1, 2, 3, 4]) → true.
        // Абстрактная граница показана символами ||, эти символы в массив не входят.
        System.out.println("Task 6. Look for balance.");
        int[] arr6 = {1, 5, 3, 8, 1};
        /* // а можно массив задавать рандомно
        //int[] arr6 = new int[5];
        //for (int i = 0; i < arr6.length; i++){
        //    Random r = new Random();
        //    arr6[i] = r.nextInt(10);  // the array filled with random values
        }*/
        System.out.print("We have the array: ");
        System.out.println(Arrays.toString(arr6));
        if (checkBalance(arr6)) System.out.println("There is Balance!");
           else System.out.println("There is NO balance!");
        System.out.println("");


        // 7 *** Написать метод, которому на вход подаётся одномерный массив и число n
        // (может быть положительным, или отрицательным), при этом метод должен циклически
        // сместить все элементы массива на n позиций.
        System.out.println("Task 7. Shift by n elements.");
        int[] arr7 = new int[5];
        for (int i = 0; i < arr7.length; i++){
             Random r = new Random();
             arr7[i] = r.nextInt(10);  // the array filled with random values
        }
        System.out.print("We have the array: ");
        System.out.println(Arrays.toString(arr7));
        int n = 3;
        System.out.println("Let's shift it by n = " + n);
        System.out.println(Arrays.toString(shiftRight(arr7, n)));


        // 8 **** Не пользоваться вспомогательным массивом при решении задачи 7.
        // вроде, и так не пользовалась в shiftRight.. будем считать, что не справилась, голова не работает уже(

    }
}
