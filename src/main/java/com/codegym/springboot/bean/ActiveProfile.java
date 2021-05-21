package com.codegym.springboot.bean;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ActiveProfile {
    private final boolean dev;

    public ActiveProfile(Environment environment){
        List<String> activeProfile = Arrays.asList(environment.getActiveProfiles());
        this.dev = activeProfile.contains("dev");
    }

    public boolean isDev(){
        return dev;
    }
}
