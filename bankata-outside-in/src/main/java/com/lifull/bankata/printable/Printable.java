package com.lifull.bankata.printable;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public interface Printable {
    void print(String output);
}
