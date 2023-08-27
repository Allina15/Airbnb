package Services;

import Interfaces.AnnouncementsInterface;
import Model.Address;
import Model.Announcements;
import Model.Types;
import Model.User;

import java.time.LocalDate;
import java.util.Arrays;

import static Model.Types.valueOf;

public class AnnouncementsService implements AnnouncementsInterface {
    private Announcements[] announcements;
    private User[]users;

    public AnnouncementsService(Announcements[]announcements,User[]users) {
        this.announcements = announcements;
        this.users=users;
    }

    public Announcements[]getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(Announcements[]announcements) {
        this.announcements = announcements;
    }

    public User[] getUsers() {
        return users;
    }

    public void setUsers(User[] users) {
        this.users = users;
    }

    @Override
    public String createAnnouncement(Announcements announcement) {
        Announcements[] newAnnouncements = Arrays.copyOf(announcements, announcements.length + 1);
        newAnnouncements[announcements.length] = announcement;
        setAnnouncements(newAnnouncements);
        for (int i = 0; i < announcements.length; i++) {
            newAnnouncements[i].setId(i);
        }
        return "Announcement saved\n " + announcement;
    }

    @Override
    public String deleteAnnouncementById(int id) {
        boolean found = false;
        Announcements[]newAnn=new Announcements[announcements.length-1];
        for (int i = 0; i < announcements.length-1; i++) {
            if (!found && announcements[i].getId()!=id){
                newAnn[i]=announcements[i];
            }else{
                found=true;
            }
            if (found){
                newAnn[i]=announcements[i+1];
            }
        }
        setAnnouncements(newAnn);
        for (int j = 0; j < newAnn.length; j++) {
           newAnn[j].setId(j);
        }
        return "Announcement was deleted";
    }

    @Override
    public String updateAnnouncementById(int id, Announcements announcement) {
        for (int i = 0; i < announcements.length; i++) {
         if (announcements[i].getId()==id){
            announcements[i]=announcement;
            announcements[i].setId(i);
         }
        }
        return "Announcement is updated\nAfter: "+announcement;
    }

    @Override
    public String getAnnouncementById(int id) {
        for (Announcements a:announcements) {
            if(a.getId()==id){
                return " " + a;
            }
        }
        return "haven't this announcement";
    }

    @Override
    public Announcements[] getAllAnnouncements() {
        return announcements;
    }

    @Override
    public void sortAnnouncementsByRating(Announcements[]announcements) {
        for (int i = 0; i < announcements.length-1; i++) {
            if (announcements[i].getRating()>announcements[i+1].getRating()){
                Announcements minRating = announcements[i];
                announcements[i]=announcements[i+1];
                announcements[i+1]=minRating;
            }
        }
        System.out.println(Arrays.toString(announcements));
    }

    @Override
    public String sortByPrice(Announcements[]announcements){
        for (int i = 0; i < announcements.length-1; i++) {
            if (announcements[i].getPricePerDay() > announcements[i+1].getPricePerDay()){
                Announcements minPrice = announcements[i];
                announcements[i]=announcements[i+1];
                announcements[i+1]=minPrice;
            }
        }
        return "Result "+Arrays.toString(announcements);
    }

    @Override
    public String filterByType(Types types){
        int index = 0;
        Announcements[]newA = new Announcements[announcements.length];
        for (int i = 0; i < announcements.length; i++) {
            if (announcements[i].getType().equals(types)){
                newA[index]=announcements[i];
                index++;
            }
        }
        Announcements[]array=Arrays.copyOf(newA,index);
        return "Result "+Arrays.toString(array);
    }

    @Override
    public String getAnnouncementsByAddress(String address) {
        for (int i = 0; i < announcements.length; i++) {
            if (announcements[i].getAddress().getAddress().equalsIgnoreCase(address)){
                return "result by your search " + announcements[i];
            }
        }
        return null;
    }
}
