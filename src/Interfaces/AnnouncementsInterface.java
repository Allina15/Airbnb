package Interfaces;

import Model.Address;
import Model.Announcements;
import Model.Types;
import Model.User;

import java.time.LocalDate;

public interface AnnouncementsInterface {
    String createAnnouncement(Announcements announcement);
    String deleteAnnouncementById(int id);
    String updateAnnouncementById(int id, Announcements announcement);
    String getAnnouncementById(int id);
    Announcements[] getAllAnnouncements();
    void sortAnnouncementsByRating(Announcements[] announcements);
    String sortByPrice(Announcements[]announcements);
    String filterByType(Types type);
    String getAnnouncementsByAddress(String address);
}
