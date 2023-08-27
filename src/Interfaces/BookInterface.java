package Interfaces;

import Exceptions.AnnouncementBookingException;
import Exceptions.AnnouncementNotAvailableException;
import Model.Announcements;
import Model.Booking;
import Model.User;

public interface BookInterface {
    String bookAnnouncement(int announcementId) throws AnnouncementBookingException, AnnouncementNotAvailableException;
    String unBookAnnouncement(int announcementId) throws AnnouncementBookingException,AnnouncementNotAvailableException, Exception;
}
