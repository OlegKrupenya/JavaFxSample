package com.testdev.config;

import com.testdev.domain.Field;
import com.testdev.service.field.FieldService;
import com.testdev.service.field.IFieldService;
import com.testdev.service.game.GameService;
import com.testdev.service.game.IGameService;
import com.testdev.ui.Controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration of the application.
 * Created by oleh.krupenia on 7/17/2015.
 */
@Configuration
@ComponentScan("com.testdev.domain")
public class AppConfig {
    @Bean
    public Field field() {
        return new Field();
    }

    @Bean
    public Controller controller() {
        return new Controller();
    }

    @Bean
    public IFieldService fieldService() {
        return new FieldService();
    }

    @Bean
    public IGameService gameService() {
        return new GameService();
    }
}
