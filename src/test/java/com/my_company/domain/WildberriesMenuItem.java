package com.my_company.domain;

public enum WildberriesMenuItem {
    SHOES("Обувь"),
    ACCESSORIES("Аксессуары"),
    ELECTRONICS("Электроника");

    private String description;

    WildberriesMenuItem(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return description;
    }
}
