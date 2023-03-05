package com.example.repository;

import com.example.model.EmailBox;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailBoxRepository implements IEmailBoxRepository {
    private static EmailBox emailBox;
    private static List<String> languages;
    private static List<String> pageSize;

    static {
        emailBox = new EmailBox("English", "25", false, "Thor");
        languages = new ArrayList<>();
        pageSize = new ArrayList<>();
//        model.addAttribute("languages", Arrays.asList("English", "Vietnamese", "Japanese", "Chinese"));
//        model.addAttribute("pageSize", Arrays.asList("5", "10", "15", "25", "50", "100"));\
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");
        pageSize.add("5");
        pageSize.add("10");
        pageSize.add("15");
        pageSize.add("25");
        pageSize.add("50");
        pageSize.add("100");
    }

    @Override
    public EmailBox getInfo() {
        return emailBox;
    }

    @Override
    public void update(EmailBox emailBox1) {
        emailBox.setLanguages(emailBox1.getLanguages());
        emailBox.setPageSize(emailBox1.getPageSize());
        emailBox.setSpamFilter(emailBox1.getSpamFilter());
        emailBox1.setSignature(emailBox1.getSignature());
    }

    @Override
    public List<String> languages() {
        return null;
    }

    @Override
    public List<String> pageSize() {
        return null;
    }
}
