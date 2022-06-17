/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Foodee.control;

/**
 *
 * @author Admin
 */
import com.Foodee.Model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.ArrayList;

public class NewClass {

    public static void main(String[] args) throws JsonProcessingException, IOException {
        Person person1 = new Person(1, "hung");
        Person person2 = new Person(2, "thuy");
        ArrayList<Person> list = new ArrayList<>();
        list.add(person1);
        list.add(person2);

        ObjectMapper om = new ObjectMapper();
        String json = "{\n"
                + "    \"id\": 10,\n"
                + "    \"name\": \"nước lọc\"\n"
                + "}";
        Person person3 = om.readValue(json, Person.class);
        System.out.println(person3);
    }
}
