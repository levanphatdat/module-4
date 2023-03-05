package com.example.repository;

import com.example.model.EmailBox;

import java.util.List;

public interface IEmailBoxRepository {
    EmailBox getInfo();

    void update(EmailBox emailBox);

    List<String> languages();

    List<String> pageSize();
}
