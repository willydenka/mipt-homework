package com.project.library.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;

public class BookHolderDTO {
    @NotBlank(message = "Поле <имя> не может быть пустым")
    private String name;
    @NotBlank(message = "Поле <фамилия> не может быть пустым")
    private String surname;
    @NotBlank(message = "Поле <отчество> не может быть пустым")
    private String patronymic;
    @PastOrPresent
    private LocalDate birthdate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
