package com.balestocks.scrap.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;

@Configuration
public class WebDriverConfig {

    @Bean
    public WebDriver getWebDriver() throws IOException {
        // Configura automaticamente o ChromeDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        // Cria uma instância do WebDriver
        return new ChromeDriver(options);
    }
}