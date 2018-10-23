package com.dongyuzhang.foodMap.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FoodMapProperties {

    @Value("${com.dongyuzhang.foodMap.name}")
    private String name;

    @Value("${com.dongyuzhang.foodMap.title}")
    private String title;

    @Value("${com.dongyuzhang.foodMap.description}")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
