package Services;

import Interfaces.UserInterface;
import Model.User;

import java.util.Arrays;

public class UserService implements UserInterface {
    private AnnouncementsService announcementsService;

    public UserService(AnnouncementsService announcementsService) {
        this.announcementsService = announcementsService;
    }

    public AnnouncementsService getAnnouncementsService() {
        return announcementsService;
    }

    public void setAnnouncementsService(AnnouncementsService announcementsService) {
        this.announcementsService = announcementsService;
    }

    @Override
    public void getAllUser() {
        System.out.println(Arrays.toString(announcementsService.getUsers()));
    }

    @Override
    public String getAnnouncementsByUserId(int id) {
        for (int i = 0; i < announcementsService.getUsers().length; i++) {
           if (announcementsService.getUsers()[i].getId()==id){
               return "Announcement - " + announcementsService.getAnnouncements()[i];
           }
        }
        return "Haven't this user";
    }

}
