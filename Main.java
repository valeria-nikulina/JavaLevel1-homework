package ru.geekbrains.java_one.lesson_4.homework;

import ru.geekbrains.java_one.lesson_4.homework.Employee;

public class Main {

    public static void main(String[] args) {
        Employee worker1 = new Employee("Иван Иваныч Иванов", "грузчик", "+7(111)1111111", 1969, 15000);
        Employee worker2 = new Employee("Петр Петрович Петров", "грузчик", "+7(111)2221111", 1972, 15000);
        Employee worker3 = new Employee("Сидр Сидрович Сидорский", "бригадир", "+7(111)3331111", 1975, 25000);
        Employee worker4 = new Employee("Василий Васильевич Василевский", "менеджер", 40000);
        Employee worker5 = new Employee("Остап Ибрагимович Бендер", "генеральный директор", 45000);

        //4. Вывести при помощи методов из пункта 3 ФИО и должность.
        System.out.println("4. "+ worker1.getEmployeeName() + " — " + worker1.getEmployeePosition());

        //5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        Employee[] empls = new Employee[] {worker5, worker4, worker3, worker2, worker1};
        System.out.println("5. Вывод сотрудников старше 40:");
        for (int i = 0; i < empls.length; i++){
            if (empls[i].getEmployeeAge() > 40 ) {
                System.out.println(empls[i].getEmployeeName() + " — " + empls[i].getEmployeePosition());
            }
        }

        //6. Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
        for (int i = 0; i < empls.length; i++){
            System.out.println("6. " + empls[i].getEmployeeName() + " получает " + empls[i].setSalaryPlusFive());
        }

    }

}