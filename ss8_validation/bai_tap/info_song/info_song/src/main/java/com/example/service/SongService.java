package com.example.service;

import com.example.dto.SongDTO;
import com.example.model.Song;
import com.example.repository.ISongRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<SongDTO> findAll() {
        List<Song> songList = iSongRepository.findAll();
        List<SongDTO> songDTOList = new ArrayList<>();
        SongDTO songDTO;
        for (Song song : songList) {
            songDTO = new SongDTO();
            BeanUtils.copyProperties(song, songDTO);
            songDTOList.add(songDTO);
        }
        return songDTOList;
    }

    @Override
    public void create(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return iSongRepository.findById(id).get();
    }

    @Override
    public void update(Song song) {
        iSongRepository.save(song);
    }
}
