package cn.acecandy.git.nasscraper.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;

/**
 * @author tangningzhu
 * @since 2022/12/10
 */
@Slf4j
@Component
public class OutputPropsRunner implements CommandLineRunner {

    @Resource
    private NasScraperConfig nasScraperConfig;

    @Override
    public void run(String... args) throws Exception {
        log.info("配置-nasScraper: {}", nasScraperConfig);
    }

}