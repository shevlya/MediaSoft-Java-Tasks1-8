package model;

import annotations.JsonField;

public class Person {
    @JsonField(name = "person_name")
    private String name;

    @JsonField(name = "person_age")
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }
}
