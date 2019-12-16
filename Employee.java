package ru.geekbrains.java_one.lesson_4.homework;

/*  1.	Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
    2.	Конструктор класса должен заполнять эти поля при создании объекта;
    3.	Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
    4.	Вывести при помощи методов из пункта 3 ФИО и должность.
    5.	Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
    6.	* Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
    7.  *** Продумать конструктор таким образом, чтобы при создании каждому сотруднику
        присваивался личный уникальный идентификационный порядковый номер
    * */

public class Employee {
    private String name;
    private String position;
    private String phoneNumber;
    private int salary;
    private int birthYear;
    private int employeeID;

    private static int nextID = 0;

    public Employee (String name, String position, String phoneNumber, int birthYear, int salary) {
        this.name = name;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.birthYear = birthYear;
        this.salary = salary;
        this.employeeID = nextID++; // личный уникальный идентификационный порядковый номер
        System.out.println("Нанят новый сотрудник: " + name + ", " +birthYear +" года рождения, на должность: "+ position + " ID = " + this.employeeID);
    }

    public Employee (String name, String position, int salary) {
        this.name = name;
        this.position = position;
        this.phoneNumber = "номер неизвестен";
        this.birthYear = 0;
        this.salary = salary;
        this.employeeID = nextID++; // личный уникальный идентификационный порядковый номер
        System.out.println("Нанят новый сотрудник: " + name + ", год рождения неизвестен, на должность: "+ position + " ID = " + this.employeeID);
    }

    public int getEmployeeAge() {
        return (this.birthYear != 0) ? (2019 - this.birthYear) : (18);  // потому что до 18 на работу не взяли бы
    }

    public String getEmployeeName() {
        return this.name;
    }

    public String getEmployeePhone() {
        return this.phoneNumber;
    }

    public String getEmployeePosition() {
        return this.position;
    }

    // 6.	* Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000.
    public int setSalaryPlusFive() {
        if (this.getEmployeeAge() > 45) {
            this.salary = this.salary + 5000;
        }
        return this.salary;
    }

}
