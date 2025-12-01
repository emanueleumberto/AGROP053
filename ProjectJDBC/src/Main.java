import com.github.javafaker.Faker;

import java.sql.SQLException;
import java.util.Locale;

public class Main {
    static Faker fake = new Faker(new Locale("it-IT"));
    public static void main(String[] args) {
        try {
            // DBConnection db = new DBConnection();
            DBConnection db = DBConnection.getInstance();
            popolaDB(0);
            System.out.println(db);


            // User u = new User("Mario", "Rossi", 25, "Roma", "AB123CD654EF789Y", "m.rossi@example.com");
            // User u = new User("Giuseppe", "Verdi", 39, "Napoli", "BA963CD654EF741N", "g.verdi@example.com");
            // db.createUser(u);

            // User u = db.findUser(1);
            //System.out.println(u);

            // u.setEmail("m.rossi@test.it");
            // db.updateUser(u);

            // db.removeUser(u);

            //db.findAllUser().forEach(System.out::println);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void popolaDB(int num) throws SQLException {
        // DBConnection db = new DBConnection();
        DBConnection db = DBConnection.getInstance();
        System.out.println(db);
        for (int i = 0; i < num; i++) {
            String name = fake.name().firstName();
            String lastname = fake.name().lastName();
            int age = fake.number().numberBetween(18, 80);
            String city = fake.address().cityName();
            String fiscal_code = fake.lorem().characters(16);
            String email = name.charAt(0) + "." + lastname + "@" +  fake.internet().domainName();

            User u = new User(name, lastname, age, city, fiscal_code.toUpperCase(), email.toLowerCase());
            db.createUser(u);
        }
    }
}