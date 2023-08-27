package Services;

import Exceptions.AnnouncementBookingException;
import Exceptions.AnnouncementNotAvailableException;
import Interfaces.BookInterface;
import Model.Announcements;
import Model.Booking;
import Model.User;

public class BookService implements BookInterface {
    private Announcements[]announcements;

    public BookService(Announcements[] announcements) {
        this.announcements = announcements;
    }

    public Announcements[] getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(Announcements[] announcements) {
        this.announcements = announcements;
    }

    @Override
    public String bookAnnouncement(int announcementId) throws AnnouncementBookingException, AnnouncementNotAvailableException {
        for (int i = 0; i < announcements.length; i++) {
            if (announcements[i].getId() == announcementId) {
                if (announcements[i].isBooked()) {
                    throw new AnnouncementBookingException("Announcement with ID " + announcementId + " is already booked.");
                } else {
                    announcements[i].setBooked(true);
                    return "удачно забронировали!";
                }
            }
        }
                   throw new AnnouncementNotAvailableException("Announcement with ID " + announcementId + " is not available.");
    }

    @Override
    public String unBookAnnouncement(int announcementId) throws AnnouncementBookingException, AnnouncementNotAvailableException{
        for (int i = 0; i < announcements.length; i++) {
            if (announcements[i].getId()==announcementId){
                if (!announcements[i].isBooked()){
                    throw new AnnouncementBookingException("Announcement with ID "+announcementId+" is already unbooked");
                }else{
                    announcements[i].setBooked(false);
                    return "Удачно сняли с брони";
                }
            }
        }
                    throw new AnnouncementNotAvailableException("Announcement with ID "+announcementId+" is not available");
    }

}
