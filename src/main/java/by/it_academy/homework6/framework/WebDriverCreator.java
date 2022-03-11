package by.it_academy.homework6.framework;

import org.openqa.selenium.remote.RemoteWebDriver;

public interface WebDriverCreator<T extends RemoteWebDriver> {
    T create();
}