package com.example.web.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseControllerSystemTest {

    private static final String DRIVER_PATH = "/home/kolmlena/chromedriver";
    private static final String BASE_URL = "http://localhost:8080";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private final String courseslistTitle = "Список курсов";
    private final String courseTitle = "Основы кибернетики";
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
    void CoursesListPage() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/courses/list");

        assertEquals(courseslistTitle, driver.getTitle());

        driver.quit();
    }

    @Test
    void CoursePage() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/course?courseId=7");

        assertEquals(courseTitle, driver.getTitle());

        driver.quit();
    }

    @Test
    void CourseNotFound() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/course?courseId=777");

        assertEquals(errorPageTitle, driver.getTitle());
        assertTrue(driver.getPageSource().contains("В базе нет курса с ID = 777"));

        driver.quit();
    }
}