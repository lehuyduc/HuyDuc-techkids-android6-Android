package com.example.lehuyduc.session12.networking.databases;

import android.content.Context;

import com.example.lehuyduc.session12.networking.databases.models.Person;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Le Huy Duc on 06/12/2016.
 */

public class RealmContext {
    private Realm realm;

    public RealmContext() {
        realm = realm.getDefaultInstance();
    }

    public List<Person> getAllPerson() {
        return realm.where(Person.class).findAll();
    }


    public void insertToRealm(Person person) {
        realm.beginTransaction();
        realm.copyToRealm(person);
        realm.commitTransaction();
    }

    public void deleteFromRealm(Person person) {
        realm.beginTransaction();
        person.deleteFromRealm();
        realm.commitTransaction();
    }

    public void updateToRealm(Person person) {
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(person);

        realm.commitTransaction();
    }

    private static RealmContext instance;
    public static RealmContext getInstance() {
        return instance;
    }

    public static void init(Context context) {
        Realm.init(context);
        instance = new RealmContext();
    }
}
