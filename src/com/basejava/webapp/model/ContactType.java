package com.basejava.webapp.model;

public enum ContactType {
    PHONE("Телефон"),
    MOBILE("Мобильный телефон"),
    HOME_PHONE("Домашний телефон"),
    SKYPE("Skype"),
    MAIL("Почта"),
    LINKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль Github"),
    STACKOVERFLOW("Профиль StackOverFlow"),
    HOME_PAGE("Домашняя страница");

    private final String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

}
