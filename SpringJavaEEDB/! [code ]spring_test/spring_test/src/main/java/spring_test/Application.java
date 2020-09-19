package spring_test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan //Включаем рекурсивный поиск по папкам проекта
@EnableAutoConfiguration //Включаем автоматическое конфигурирование
public class Application {
    public static void main(String[] args) { //точка входа в Java приложение
        SpringApplication.run(Application.class, args); //запускаем Spring приложение
    }
}


