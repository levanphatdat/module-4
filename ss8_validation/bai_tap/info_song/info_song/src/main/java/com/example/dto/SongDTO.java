package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class SongDTO {
    private Integer id;
    @NotBlank(message = "{name.notBlank}")
    @Size(max = 800, message = "name.size")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "{name.pattern}")
    private String name;
    @NotBlank(message = "{singer.notBlank}")
    @Size(max = 300, message = "singer.size")
    @Pattern(regexp = "^[^@;,.=+\\-]+$", message = "{singer.pattern}")
    private String singer;
    @NotBlank(message = "{category.notBlank}")
    @Size(max = 1000, message = "{category.size}")
    @Pattern(regexp = "^[^@;.=+\\-]+$", message = "{category.pattern}")
    private String category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SongDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}