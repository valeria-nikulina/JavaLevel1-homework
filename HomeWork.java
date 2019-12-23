/**
 * 1)
 * Написать метод вычисляющий выражение a * (b + (c / d)) и
 * возвращающий результат с плавающей точкой, где
 * a, b, c, d – целочисленные входные параметры этого метода;
 *
 * 2)
 * Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит
 * в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
 *
 * 3)
 * Написать метод, которому в качестве параметра передается целое число,
 * метод должен проверить положительное ли число передали, или отрицательное.
 * Замечание: ноль считаем положительным числом.
 * Результат работы метода вывести в консоль
 *
 * 4)
 * Написать метод, которому в качестве параметра передается строка, обозначающая имя,
 * метод должен вернуть приветственное сообщение «Привет, переданное_имя!»;
 * Вывести приветствие в консоль.
 *
 * 5)
 * Написать метод, который определяет является ли год високосным.
 * Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
 * Для проверки работы вывести результаты работы метода в консоль
 *     год, номер которого кратен 400, — високосный;
 *     остальные годы, номер которых кратен 100, — невисокосные;
 *     остальные годы, номер которых кратен 4, — високосные.
 **/

package homework_lesson1;

import java.io.IOException;

public class HomeWork {

    //1) Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий результат
    // с плавающей точкой, где a, b, c, d – целочисленные входные параметры этого метода;
    private static float count (int a, int b, float c, float d) {
        float res = c / d;
        res = a * (b + res);
        return res;
    }

    //2) Написать метод, принимающий на вход два целых числа, и проверяющий что их сумма лежит
    //   в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
    private static boolean compare (int param1, int param2) {
        int sum = param1 + param2;
        System.out.println("a + b = " + sum + ",");
        if (sum >= 10 && sum <= 20) { return true;
        } else return false;
    }

    // 3) Написать метод, которому в качестве параметра передается целое число,
    //    метод должен проверить положительное ли число передали, или отрицательное.
    private static void ispositive (int param1) {
       if (param1 >= 0) { System.out.println(" — оно положительное!");;
        } System.out.println(" — оно отрицательное :(");
    }


    // 4) Написать метод, которому в качестве параметра передается строка, обозначающая имя,
    //    метод должен вернуть приветственное сообщение «Привет, переданное_имя!»;
    //    Вывести приветствие в консоль.
    private static void task4 (String name) {
        System.out.println("4) Привет, " + name + "!");
    }

    // 5) Написать метод, который определяет является ли год високосным.
    //    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
    //    Для проверки работы вывести результаты работы метода в консоль
    //       год, номер которого кратен 400, — високосный;
    //       остальные годы, номер которых кратен 100, — невисокосные;
    //       остальные годы, номер которых кратен 4, — високосные.
    private static void isleapyear (float yearnum) {
        float yearcheck = yearnum / 400;
        if (yearcheck % 1 == 0) {
            //целое значение
            System.out.println("5) " + yearnum +" — високосный год! yearcheck = " + yearcheck);
        } else { yearcheck = yearnum / 100;
                 if (yearcheck % 1 == 0) {
                     //целое значение
                     System.out.print("5) " );
                     System.out.printf("%.4s", yearnum); //вывод первых 4 символов
                     System.out.println(" — невисокосный год!");
                 } else { yearcheck = yearnum / 4;
                     if (yearcheck % 1 == 0) {
                         //целое значение
                         System.out.println("5) " + yearnum +" — високосный год! yearcheck = " + yearcheck);
                     } else {//System.out.println("5) " + yearnum +" — год невисокосный!");
                              System.out.print("5) " );
                              System.out.printf("%.4s", yearnum); //вывод первых 4 символов
                              System.out.println(" — год невисокосный!");
                            }

                 }

          }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.print("1) При a = 1, b = 2, c = 3 и d = 4 результат выражения a * (b + (c / d)) = ");
        System.out.println(count (1, 2, 3, 4));
        System.out.println("");

        int a = 10; // Первое число задания 2
        int b = 2;  // Второе число задания 2
        System.out.print("2) Пусть а = "+ a + ", а b = " + b +", тогда ");
        if (compare(a, b))
          { System.out.println("   то есть их сумма больше 10, но меньше 20 :)");}
           else { System.out.println("   то есть их сумма не попала в промежуток от 10 до 20 :(");}
        System.out.println(" ");

        int num3 = -20; // Число задания 3
        System.out.print("3) Передали число " + num3);
        ispositive(num3);
        System.out.println("");

        task4("Лера");
        System.out.println("");

        isleapyear(1900);
        System.out.println("");
    }
}