package com.github.illiaderhun.coaches;

import com.github.illiaderhun.fortune.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope("singleton")
public class TennisCoach implements Coach {

    private FortuneService fortuneService;

    public TennisCoach() {
    }

    /*@Autowired
    public TennisCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }*/

    // init-method
    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println("Do my startup stuff");
    }

    // destroy-method
    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println("Do my cleanup stuff");
    }

    @Autowired
    @Qualifier("randomService")
    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    public FortuneService getFortuneService() {
        return fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand valley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
