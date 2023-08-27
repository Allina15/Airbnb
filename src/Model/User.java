package Model;

import java.time.LocalDate;

public class User {
    private int id;
    public static int idd;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate registeredDate;
    public User(String firstName, String lastName, String email, LocalDate registeredDate) {
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("email cannot be null or empty");
        }
        if (registeredDate == null) {
            throw new IllegalArgumentException("Registered data cannot be null");
        }
        this.id = idd++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registeredDate = registeredDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDate registeredDate) {
        this.registeredDate = registeredDate;
    }

    @Override
    public String toString() {
        return "User " +
                "id = " + id +
                ", firstName = " + firstName +
                ", lastName = " + lastName +
                ", email = " + email +
                ", registeredDate = " + registeredDate +"\n";
    }
}
