package Model;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class Announcements {
    private int id;
    public static int idd;
    private String description;
    private LocalDate data;
    private String title;
    private Types type;
    private User owner;
    private boolean isBooked;
    private double rating;
    private int pricePerDay;
    private Address address;

    public Announcements(String description, LocalDate data, String title, Types type, User owner, boolean isBooked, double rating, int pricePerDay, Address address) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        if (data == null) {
            throw new IllegalArgumentException("Data cannot be null");
        }
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty");
        }
        if (type == null) {
            throw new IllegalArgumentException("TypeOfHouse cannot be null");
        }
        if (owner == null) {
            throw new IllegalArgumentException("Owner cannot be null");
        }
        if (pricePerDay < 0) {
            throw new IllegalArgumentException("PricePerDay cannot be negative");
        }
        if (address == null) {
            throw new IllegalArgumentException("Address cannot be null");
        }
        this.id = idd++;
        this.description = description;
        this.data = data;
        this.title = title;
        this.type = type;
        this.owner = owner;
        this.isBooked = isBooked;
        this.rating = rating;
        this.pricePerDay = pricePerDay;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Announcements " +
                "id = " + id +
                ", description = " + description +
                ", data = " + data +
                ", title = " + title +
                ", type = " + type +"\n"+
                ", owner = " + owner +
                ", isBooked = " + isBooked +
                ", rating = " + rating +
                ", pricePerDay = " + pricePerDay+
                ", address = " + address + "\n";
    }
}
