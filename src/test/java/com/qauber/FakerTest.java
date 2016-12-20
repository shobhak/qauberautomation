package com.qauber;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

/**
 * Created by erikfriedlander on 12/13/16.
 */
public class FakerTest {


    @Test
    public void fakeThings(){

        Faker faker = new Faker();
        String name = faker.name().fullName();

        System.out.println(faker.pokemon().name());
        System.out.println(faker.gameOfThrones().character());

        System.out.println(name);
        System.out.println("Book: "+faker.book().title());
        System.out.println("Author: "+faker.book().author());
        System.out.println(faker.address().streetAddress());

        System.out.println(faker.phoneNumber().cellPhone());
        System.out.println(faker.phoneNumber().phoneNumber());
    }


}
