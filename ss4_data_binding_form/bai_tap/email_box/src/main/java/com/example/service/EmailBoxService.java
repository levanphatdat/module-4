package com.example.service;

import com.example.model.EmailBox;
import com.example.repository.IEmailBoxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailBoxService implements IEmailBoxService {
    @Autowired
    private IEmailBoxRepository iEmailBoxRepository;

    @Override
    public EmailBox getInfo() {
        return iEmailBoxRepository.getInfo();
    }

    @Override
    public void update(EmailBox emailBox) {
        iEmailBoxRepository.update(emailBox);
    }

    @Override
    public List<String> languages() {
        return iEmailBoxRepository.languages();
    }

    @Override
    public List<String> pageSize() {
        return iEmailBoxRepository.pageSize();
    }
}
