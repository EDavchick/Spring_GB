package com.gb;

public class App {
    public static void main(String[] args) {
        Person person = new Person("Lena", "Davydova", 25);
        System.out.println(person.equals(new Person("Irina", "Vasileva", 35)));
        System.out.println(person.hashCode());
        System.out.println(person);
    }
}
