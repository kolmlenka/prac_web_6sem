package com.example.web.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class LessonControllerSystemTest {

    private static final String DRIVER_PATH = "/home/kolmlena/chromedriver";
    private static final String BASE_URL = "http://localhost:8080";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private final String lessonsPageTitle = "Расписание занятий";
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
    void ViewAllLessons() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/lessons");

        assertEquals(lessonsPageTitle, driver.getTitle());
        assertTrue(driver.getPageSource().contains("Расписание занятий"));

        driver.quit();
    }

    @Test
    void FilterLessonsByTimeInterval() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/lessons/filter?startTime=1970-01-01T08:45&endTime=1970-01-01T12:00");

        assertEquals(lessonsPageTitle, driver.getTitle());
        assertTrue(driver.getPageSource().contains("Расписание занятий"), "Страница должна содержать расписание занятий.");

        driver.quit();
    }

    @Test
    void FilterLessonsWithInvalidTimeInterval() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/lessons/filter?startTime=2023-10-01T12:00:00&endTime=2023-10-01T10:00:00");

        assertEquals(errorPageTitle, driver.getTitle());
        assertTrue(driver.getPageSource().contains("Дата начала интервала не может быть позже даты окончания."));

        driver.quit();
    }

    @Test
    void FilterLessonsByTeacherId() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/lessons/filter?startTime=1970-01-01T08:45&endTime=1970-01-01T12:00&teacherId=1&auditoriumId=");

        assertEquals(lessonsPageTitle, driver.getTitle());
        assertTrue(driver.getPageSource().contains("Расписание занятий"), "Страница должна содержать расписание занятий.");

        driver.quit();
    }

    @Test
    void FilterLessonsByNonExistentTeacherId() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/lessons/filter?startTime=1970-01-01T08:45&endTime=1970-01-01T12:00&teacherId=999&auditoriumId=");

        assertEquals(errorPageTitle, driver.getTitle());
        assertTrue(driver.getPageSource().contains("Расписание для преподавателя с ID = 999 не найдено."),
                "Сообщение об ошибке должно содержать правильный текст.");

        driver.quit();
    }

    @Test
    void FilterLessonsByAuditoriumId() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/lessons/filter?startTime=1970-01-01T08:45&endTime=1970-01-01T12:00&teacherId=&auditoriumId=2");

        assertEquals(lessonsPageTitle, driver.getTitle());
        assertTrue(driver.getPageSource().contains("Расписание занятий"), "Страница должна содержать расписание занятий.");

        driver.quit();
    }
}