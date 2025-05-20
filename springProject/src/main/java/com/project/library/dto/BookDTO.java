package com.project.library.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class BookDTO {
    @NotBlank(message = "Название обязательно")
    private String title;
    @NotBlank(message = "Имя автора обязательно")
    private String authorName;
    @Min(value = 0, message = "Укажите валидный год")
    @Max(value = 2025, message = "Укажите валидный год")
    private int yearOfProduction;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }
}
