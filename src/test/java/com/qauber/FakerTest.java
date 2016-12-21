package com.qauber;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

import java.util.Locale;

/**
 * Created by erikfriedlander on 12/13/16.
 */
public class FakerTest {


    @Test
    public void fakeThings(){

        //create Faker object. locale is US English. try 'ru' for russian. Can leave blank.
        //other locales (and docs) at https://github.com/DiUS/java-faker
        Faker faker = new Faker(new Locale("en-US"));



        String name = faker.name().fullName();
        System.out.println(name);

        System.out.println(faker.gameOfThrones().character());
        System.out.println("Book: "+faker.book().title());
        System.out.println("Author: "+faker.book().author());

        System.out.println(faker.address().streetAddress());
        System.out.println(faker.address().cityName()+", "+faker.address().stateAbbr()+", "+faker.address().zipCode());

        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.phoneNumber().phoneNumber());

    }


}
