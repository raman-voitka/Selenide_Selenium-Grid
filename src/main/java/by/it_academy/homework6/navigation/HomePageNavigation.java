package by.it_academy.homework6.navigation;

import by.it_academy.homework6.pageobject.HomePage;

public class HomePageNavigation {
    public static void openHomePage(String homePage) {
        new HomePage().navigate(homePage);
    }
}