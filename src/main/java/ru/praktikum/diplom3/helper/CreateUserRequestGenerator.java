package ru.praktikum.diplom3.helper;
import net.datafaker.Faker;
import ru.praktikum.diplom3.models.CreateUserRequest;

public class CreateUserRequestGenerator {
    public static CreateUserRequest getRandomUser(){
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        String name = faker.name().firstName();
        return new CreateUserRequest.Builder().email(email).password(password).name(name).build();
    }

}
