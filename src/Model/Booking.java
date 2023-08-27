package Model;

public class Booking {
    private User user;
    private Announcements announcements;

    public Booking(User user, Announcements announcements) {
        this.user = user;
        this.announcements = announcements;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Announcements getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(Announcements announcements) {
        this.announcements = announcements;
    }

    @Override
    public String toString() {
        return "Booking " +
                "user = " + user +
                ", announcements = " + announcements + "\n";
    }
}
