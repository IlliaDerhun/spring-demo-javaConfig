package com.github.illiaderhun;

import com.github.illiaderhun.coaches.SwimCoach;
import com.github.illiaderhun.fortune.FortuneService;
import com.github.illiaderhun.fortune.SadFortune;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:sport.properties")
//@ComponentScan("com.github.illiaderhun")
public class SportConfig {

    @Bean
    public FortuneService sadFortuneService() {
        return new SadFortune();
    }

    @Bean
    public SwimCoach swimCoach() {
        return new SwimCoach(sadFortuneService());
    }

}
