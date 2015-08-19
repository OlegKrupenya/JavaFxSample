package com.testdev.config;

import com.testdev.domain.Field;
import com.testdev.service.field.FieldService;
import com.testdev.service.field.IFieldService;
import com.testdev.ui.game.state.StateContext;
import com.testdev.ui.Controller;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration of the application.
 * Created by oleh.krupenia on 7/17/2015.
 */
@Configuration
public class AppConfig {
    @Bean
    public Field field() {
        return new Field();
    }

    @Bean
    public StateContext context() {
        return new StateContext();
    }

    @Bean
    public Controller controller() {
        return new Controller();
    }

    @Bean
    public IFieldService fieldService() {
        return new FieldService();
    }
}
