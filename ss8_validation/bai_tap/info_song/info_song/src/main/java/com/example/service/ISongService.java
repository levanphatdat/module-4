package com.example.service;

import com.example.dto.SongDTO;
import com.example.model.Song;

import java.util.List;

public interface ISongService {
    List<SongDTO> findAll();

    void create(Song song);

    Song findById(int id);

    void update(Song song);
}
