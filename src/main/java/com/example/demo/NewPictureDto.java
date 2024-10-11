package com.example.demo;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
public class NewPictureDto {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
