package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    static Faker faker = new Faker(new Locale(("ru")));

    public String generateDate(int shift) {

        LocalDate currentDate = LocalDate.now();
        LocalDate deliveryDate = currentDate.plusDays(shift);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        String date = deliveryDate.format(formatter);
        return date;
    }

    public static String generateName() {

        return faker.name().fullName();
    }

    public static String generatePhone() {

        return faker.phone("+##########");
    }

    public static final List<String> cities = Arrays.asList(
            "Москва", "Калуга", "Казань", "Хабаровск", "Якутск", "Красноярск", "Иваново"
    );

    public static String generateCity() {
        return cities.get(faker.random().nextInt(cities.size())));
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
