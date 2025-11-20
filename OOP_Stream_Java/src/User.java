import java.util.HashSet;
import java.util.Set;

public class User {

    private String name;
    private String lastname;
    private String city;
    private int age;
    private Set<String> hobby;

    public User(String name, String lastname, String city, int age) {
        this.name = name;
        this.lastname = lastname;
        this.city = city;
        this.age = age;
        this.hobby = new HashSet<String>();
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getCity() {
        return city;
    }

    public int getAge() {
        return age;
    }

    public Set<String> getHobby() {
        return hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                '}';
    }
}
