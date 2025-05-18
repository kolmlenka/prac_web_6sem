package com.example.web.controllers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TeacherControllerSystemTest {

    private static final String DRIVER_PATH = "/home/kolmlena/chromedriver";
    private static final String BASE_URL = "http://localhost:8080";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private final String teacherslistTitle = "Список преподавателей";
    private final String teacherTitle = "Информация о преподавателе";
    private final String teachercoursesTitle = "Курсы преподавателя";
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
    void TeachersListPage() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/teachers/list");

        assertEquals(teacherslistTitle, driver.getTitle());

        driver.quit();
    }

    @Test
    void TeacherPage() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/teachers?teacherId=1");

        assertEquals(teacherTitle, driver.getTitle());

        driver.quit();
    }

    @Test
    void TeacherNotFoundPage() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/teachers?teacherId=999");

        assertEquals(errorPageTitle, driver.getTitle());
        assertTrue(driver.getPageSource().contains("В базе нет преподавателя с ID = 999"));

        driver.quit();
    }

    @Test
    void FilterTeachersByCourse() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/teachers/filter?teacherId=1");

        assertEquals(teachercoursesTitle, driver.getTitle());
        assertTrue(driver.getPageSource().contains("Course(id=1, name=Операционные системы, coverage=100, intensity=4, year=2)"));

        driver.quit();
    }

    @Test
    void FilterTeachersByCourseEmpty() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/teachers/filter?teacherId=999");

        List<WebElement> courseElements = driver.findElements(By.cssSelector(".course-entry"));
        assertEquals(0, courseElements.size(), "Expected no courses for teacherId=999");

        driver.quit();
    }

}
