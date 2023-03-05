package com.example.service;

import com.example.model.EmailBox;

import java.util.List;

public interface IEmailBoxService {
    EmailBox getInfo();

    void update(EmailBox emailBox);

    List<String> languages();

    List<String> pageSize();
}
