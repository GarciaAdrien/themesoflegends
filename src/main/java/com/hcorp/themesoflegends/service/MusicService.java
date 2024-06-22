package com.hcorp.themesoflegends.service;


import com.hcorp.themesoflegends.dto.MusicDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService {
    private final List<MusicDto> musics;

    public MusicService() {
        //TODO MOCK BDD
        MusicStorageService musicStorageService = new MusicStorageService();
        this.musics = musicStorageService.fetchMusicFromDatabase();
    }

    public List<MusicDto> getAllMusics() {
        return this.musics;
    }

    public MusicDto getRandomMusic() {
        return this.musics.get((int)(Math.random() * this.musics.size()));
    }

    public Optional<MusicDto> findMusic(String musicId) {
        return this.musics.stream()
                .filter(gameDto -> musicId.equals(gameDto.getId()))
                .findFirst();
    }
}
