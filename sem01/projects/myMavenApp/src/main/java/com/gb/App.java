package com.gb;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class App {
    public static void main(String[] args) {
        Person person1 = new Person("Елена", "Давыдова", 47);
        Person person2 = new Person("Алла", "Петрова", 35);
        Person person3 = new Person("Марина", "Хабарова", 65);

        // create object Gson
        Gson gson1 = new Gson();
        Gson gson2 = new GsonBuilder().setPrettyPrinting().create();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.excludeFieldsWithoutExposeAnnotation().setPrettyPrinting();
        Gson gson3 = gsonBuilder.create();

        // serialize object class Person to JSON format, get string
        String personToJson1 = gson1.toJson(person1);
        String personToJson2 = gson2.toJson(person2);
        String personToJson3 = gson3.toJson(person3);

        System.out.println("person1: " + person1);
        System.out.println("person2: " + person2);
        System.out.println("person3: " + person3);

        // deserialize string in JSON format to object class Person
        Person jsonToPerson1 = gson1.fromJson(personToJson1, Person.class);
        Person jsonToPerson2 = gson2.fromJson(personToJson2, Person.class);
        Person jsonToPerson3 = gson3.fromJson(personToJson3, Person.class);

        System.out.println("jsonToPerson1: " + jsonToPerson1);
        System.out.println("jsonToPerson2: " + jsonToPerson2);
        System.out.println("jsonToPerson3: " + jsonToPerson3); // com.gb.Person@6615435c[age=0,firstName=<null>,lastName=<null>]

        System.out.println("Simple JSON: " + personToJson1);
        System.out.println("Pretty JSON: " + personToJson2);
        System.out.println("JSON without expose field: " + personToJson3); // {}

        System.out.println("person1 equals jsonToPerson1: " + person1.equals(jsonToPerson1));
        System.out.println("person2 equals jsonToPerson2: " + person2.equals(jsonToPerson2));
        System.out.println("person3 equals jsonToPerson3: " + person3.equals(jsonToPerson3)); // false

        System.out.println(person1.equals(new Person("Irina", "Vasileva", 35)));
        System.out.println("hashcode for person1: " + person1.hashCode());
    }
}
