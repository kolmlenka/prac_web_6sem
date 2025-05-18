package com.example.web;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class StudentControllerSystemTest {

    private static final String DRIVER_PATH = "/home/kolmlena/chromedriver";
    private static final String BASE_URL = "http://localhost:8080";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "postgres";

    private final String studentsListTitle = "Список студентов";
    private final String addStudentTitle = "Добавить студента";
    private final String editStudentTitle = "Редактировать студента";
    private final String studentProfileTitle = "Профиль студента";
    private final String errorPageTitle = "Ошибка"; // Assuming this is the title of the error page

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
    void StudentListPage() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/students/list");

        assertEquals(studentsListTitle, driver.getTitle());

        driver.quit();
    }

    @Test
    void AddStudent() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/students/add");

        WebElement nameField = driver.findElement(By.name("name"));
        WebElement groupField = driver.findElement(By.name("group"));
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

        nameField.sendKeys("Иван Иванов");
        groupField.sendKeys("101");
        submitButton.click();

        assertEquals(studentsListTitle, driver.getTitle());
        assertTrue(driver.getPageSource().contains("Иван Иванов"));

        driver.quit();
    }

    @Test
    void EditStudent() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/students/edit?studentId=5");

        assertEquals(editStudentTitle, driver.getTitle());

        WebElement nameField = driver.findElement(By.name("name"));
        nameField.clear();
        nameField.sendKeys("Jane Doe");
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        assertEquals(studentsListTitle, driver.getTitle());
        assertTrue(driver.getPageSource().contains("Jane Doe"));

        driver.quit();
    }

    @Test
    void DeleteStudent() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/students/delete?studentId=3");

        assertEquals(studentsListTitle, driver.getTitle());
        assertFalse(driver.getPageSource().contains("Абросикин Илья Эдуардович"));

        driver.quit();
    }

    @Test
    void StudentProfilePage() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/students/profile?studentId=1");

        assertEquals(studentProfileTitle, driver.getTitle());

        driver.quit();
    }

    @Test
    void StudentNotFound() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.get(BASE_URL + "/students/edit?studentId=666");

        assertEquals(errorPageTitle, driver.getTitle());
        assertTrue(driver.getPageSource().contains("Студент с ID = 999 не найден."));

        driver.quit();
    }

    @Test
    void AddStudentWithMissingFields() {
        WebDriver driver = new ChromeDriver();
        login(driver);
        driver.quit();
    }