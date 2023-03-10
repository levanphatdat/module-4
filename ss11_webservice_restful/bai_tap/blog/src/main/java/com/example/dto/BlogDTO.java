package com.example.dto;

public class BlogDTO {
    private int id;
    private String title;
    private String content;
    private String author;
    private CategoryDTO categoryDTO;

    public BlogDTO() {
    }

    public BlogDTO(int id, String title, String content, String author, CategoryDTO categoryDTO) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.categoryDTO = categoryDTO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public CategoryDTO getCategoryDTO() {
        return categoryDTO;
    }

    public void setCategoryDTO(CategoryDTO categoryDTO) {
        this.categoryDTO = categoryDTO;
    }
}
