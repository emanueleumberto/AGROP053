import com.github.javafaker.Faker;

import java.util.Locale;

public class TestDependences {

    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("it-IT"));

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();

        System.out.println("Ciao " + firstName + " " + lastName);
    }

}
