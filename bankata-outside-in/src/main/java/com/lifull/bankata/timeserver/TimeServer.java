package com.lifull.bankata.timeserver;

import org.springframework.stereotype.Component;

@Component
public interface TimeServer {
    public String getDate();
}
