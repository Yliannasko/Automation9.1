package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    static Faker faker = new Faker(new Locale("ru"));

    public static String generateDate(int addDays) {

        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity() {
        var cities = new String[]{"Москва", "Калуга", "Казань", "Иваново", "Хабаровск", "Якутск", "Краснодар", "Красноярск", "Новосибирск"
        };
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName() {

        return faker.name().name();
    }

    public static String generatePhone() {

        return faker.numerify("+##########");
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser() {
            return new UserInfo(generateCity(), generateName(), generatePhone());
        }

        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;
        }
    }
}
