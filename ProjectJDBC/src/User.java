public class User {

    private long  user_id;
    private String name;
    private String lastname;
    private int age;
    private String city;
    private String fiscal_code;
    private String email;

    public User(long user_id, String name, String lastname, int age, String city, String fiscal_code, String email) {
        this.user_id = user_id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.city = city;
        this.fiscal_code = fiscal_code;
        this.email = email;
    }

    public User(String name, String lastname, int age, String city, String fiscal_code, String email) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.city = city;
        this.fiscal_code = fiscal_code;
        this.email = email;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFiscal_code() {
        return fiscal_code;
    }

    public void setFiscal_code(String fiscal_code) {
        this.fiscal_code = fiscal_code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                ", fiscal_code='" + fiscal_code + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
