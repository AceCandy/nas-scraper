package cn.acecandy.git.nasscraper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//(scanBasePackages = {"dao"})
@SpringBootApplication
public class NasScraperApplication {

    public static void main(String[] args) {
        SpringApplication.run(NasScraperApplication.class, args);
    }

}