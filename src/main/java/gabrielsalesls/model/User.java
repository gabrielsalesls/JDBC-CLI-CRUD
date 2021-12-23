package gabrielsalesls.model;

public class User {

    private Integer id;
    private String name;
    private String email;
    private String country;
    private Gender gender;

    public User() {

    }

    public User(Integer id, String name, String email, String country, Gender gender) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.country = country;
        this.gender = gender;
    }

    public User(String name, String email, String country, Gender gender) {
        this.name = name;
        this.email = email;
        this.country = country;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender.getValue();
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", gender=" + gender +
                '}';
    }
}
