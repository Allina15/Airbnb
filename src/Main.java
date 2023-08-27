import Exceptions.AnnouncementBookingException;
import Exceptions.AnnouncementNotAvailableException;
import Interfaces.AnnouncementsInterface;
import Model.*;
import Services.AnnouncementsService;
import Services.BookService;
import Services.UserService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws AnnouncementBookingException, AnnouncementNotAvailableException {
        User user1 = new User("Alina","Akhunova","Alinchik@", LocalDate.now());
        User user2 = new User("Adeliia","Zhylydyzbekova","Adelka@", LocalDate.now());
        User user3 = new User("Erkin","Toigonbaev","Erik@", LocalDate.now());
        User user4 = new User("Tunuk","Zhumabekova","Tunushka@", LocalDate.now());
        User user5 = new User("Zalkar","Mamanov","Zalkar@", LocalDate.now());
        User[]users = {user1,user2,user3};

        Address address1 = new Address("Kyrgyzstan","Chui","Ch.Aitmatova 93");
        Address address2 = new Address("Kyrgyzstan","IK","Sovetskaya 10");
        Address address3 = new Address("Kyrgyzstan","Chui","Gogolya 56 ");
        Address address4 = new Address("Kyrgyzstan","Osh","KurmanzhanDatka 9");
        Address address5 = new Address("Kyrgyzstan","Chui","Ahunbaeva 3");

        Announcements announcement1 = new Announcements(
                "Современная квартира в центре города.",
                LocalDate.now(),
                "Центральная стильная квартира",
                Types.APARTMENT,
                user1,
                false,
                4.9,
                5000,address1
        );

        Announcements announcement2 = new Announcements("Уютный коттедж на берегу озера.",
                LocalDate.now(),
                "Коттедж \"Озерная дача\"",
                Types.HOUSE, user2,
                true,
                4.7,
                3000,address2
        );

        Announcements announcement3 = new Announcements(
                "Современная квартира в центре города.",
                LocalDate.now(),
                "Квартира со всеми условиями",
                Types.APARTMENT,
                user3,
                false,
                4.8,
                4500,address3
        );

        Announcements announcement4 = new Announcements(
                "Романтический домик в горах.",
                LocalDate.now(),
                "Горный уют \"Закат\"",
                Types.HOUSE,
                user4,
                false,
                4.8,
                2500,address4
        );

        Announcements announcement5 = new Announcements(
                "Уютная дача в деревне.",
                LocalDate.now(),
                "Дача \"Зеленый уголок\"",
                Types.HOUSE,
                user5,
                false,
                4.5,
                1500,address5
        );

        Announcements[]announcements = {announcement1,announcement2,announcement3};
        Scanner scanner = new Scanner(System.in);

        AnnouncementsService announcementsService = new AnnouncementsService(announcements,users);
        UserService userService = new UserService(announcementsService);
        BookService bookService = new BookService(announcements);
        while (true) {
            System.out.println("Select an action:\n1.Create announcement\n2.Delete announcement by id\n3.Update announcement by id\n4.Get announcement by id" +
                    "\n5.Get announcements\n6.Sort announcements by rating\n7.Sort by price\n8.Filter by type\n9.Get all users\n10.Get announcement by user id" +
                    "\n11.Book announcement\n12.Un book announcement");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.println(announcementsService.createAnnouncement(announcement4));
                    break;
                case 2:
                    System.out.println("Enter the announcement id: ");
                    System.out.println(announcementsService.deleteAnnouncementById(scanner.nextInt()));
                    break;
                case 3:
                    System.out.println("Enter the id announcement: ");
                    System.out.println(announcementsService.updateAnnouncementById(scanner.nextInt(), announcement5));
                    break;
                case 4:
                    System.out.println("Enter the announcement id: ");
                    System.out.println(announcementsService.getAnnouncementById(scanner.nextInt()));
                    break;
                case 5:
                    System.out.println("---------------Announcements---------------");
                    System.out.println(Arrays.toString(announcementsService.getAnnouncements()));
                    break;
                case 6:
                    System.out.println("Announcements rating: ");
                    announcementsService.sortAnnouncementsByRating(announcements);
                    break;
                case 7:
                    System.out.println("Sorted announcements by price: ");
                    System.out.println(announcementsService.sortByPrice(announcements));
                    break;
                case 8:
                    System.out.println("Enter the type ");
                    System.out.println(announcementsService.filterByType(Types.valueOf(scanner.next())));
                    break;
                case 9:
                    System.out.println("---------------Users---------------");
                    userService.getAllUser();
                    break;
                case 10:
                    System.out.println("Enter the id");
                    System.out.println(userService.getAnnouncementsByUserId(scanner.nextInt()));
                    break;
                case 11:
                    System.out.println("Enter the id");
                    System.out.println(bookService.bookAnnouncement(scanner.nextInt()));
                    break;
                case 12:
                    System.out.println("Enter the id");
                    System.out.println(bookService.unBookAnnouncement(scanner.nextInt()));
                    break;
            }
        }
    }
}
