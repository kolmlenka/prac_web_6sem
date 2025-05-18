package com.example.web.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuditoriumControllerSystemTest {

    private static final String DRIVER_PATH = "/home/kolmlena/chromedriver";
    private static final String BASE_URL = "http://localhost:8080";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private final String auditoriumslistTitle = "Список аудиторий";
    private final String auditoriumTitle = "Аудитория";
    private final String errorPageTitle = "Ошибка";

    @BeforeAll
    static void setUp() {
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
    }

    private void login(WebDriver driver) {
        driver.get(BASE_URL + "/login");

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        usernameField.sendKeys(USERNAME);
        passwordField.sendKeys(PASSWORD);

        loginButton.click();
    }

    @Test
    void AuditoriumsListPage() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/auditoriums/list");

        assertEquals(auditoriumslistTitle, driver.getTitle());

        driver.quit();
    }

    @Test
    void AuditoriumPage() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/auditorium?auditoriumId=1");

        assertEquals(auditoriumTitle, driver.getTitle());

        driver.quit();
    }

    @Test
    void AuditoriumPageNotFound() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/auditorium?auditoriumId=999");

        assertEquals(errorPageTitle, driver.getTitle());
        assertTrue(driver.getPageSource().contains("В базе нет аудитории с ID = 999"));

        driver.quit();
    }
}
