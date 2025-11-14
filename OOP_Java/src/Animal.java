public class Animal {

    // Proprietà
    private String name;
    private int age;
    private String type;
    private String category;

    // Costruttori
    public Animal(String name, int age, String type, String category) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.category = category;
    }

    // Getter e Setter
    public String getName() { return this.name; }
    public void setName(String name) { this.name = name; }
    public String getType() { return this.type; }
    public String getCategory() { return this.category; }
    public int getAge() { return  this.age; }
    public void setAge(int age) {
        if(this.age < age && this.age == age-1) {
            this.age = age;
        } else {
            System.out.println("Età errata!!!");
        }
    }

    // Metodi
    public void info() {
        System.out.println(this.name + " age: " + this.age + " (" + this.type + ") - " + this.category);
    }
}
