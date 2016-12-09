package com.example.lehuyduc.session12.networking.databases.models;

import io.realm.RealmObject;

/**
 * Created by Le Huy Duc on 06/12/2016.
 */

public class Person extends RealmObject{
    String name;

    public static Person create(String name) {
        Person person = new Person();
        person.name = name;
        return person;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
