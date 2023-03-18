package com.example.project_K.service;

import com.example.project_K.dto.MusicDto;
import com.example.project_K.entity.Music;
import com.example.project_K.respository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MusicService {

    @Autowired
    private MusicRepository musicRepository;

    public List<MusicDto> getMusicList() {
        List<Music> musicList = musicRepository.findAll();
        List<MusicDto> musicDtoList = new ArrayList<>();
        for (Music music : musicList) {
            MusicDto musicDto = new MusicDto();
            musicDto.setId(music.getId());
            musicDto.setTitle(music.getTitle());
            musicDto.setArtist(music.getArtist());
            musicDtoList.add(musicDto);
        }
        return musicDtoList;
    }

    public Music uploadMusic(MultipartFile file, String title, String artist) throws IOException {
// 저장할 경로를 지정
        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/assets/musics";

        // 파일 이름 생성
        String uuid = UUID.randomUUID().toString();
        String fileName = uuid + "_" + file.getOriginalFilename();
// Music 객체 생성
        Music music = new Music(title, artist, fileName, file.getContentType(), file.getBytes());

        // Music 객체 저장
        music = musicRepository.save(music);
        // 저장할 파일 객체 생성
        File saveFile = new File(projectPath, fileName);

        // 파일 저장
        file.transferTo(saveFile);



        return music;
    }


}
