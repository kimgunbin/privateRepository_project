package com.example.project_K.controller;

import com.example.project_K.respository.MusicRepository;
import com.example.project_K.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;

@Controller

public class MusicController {

    @Autowired
    private MusicService musicService;
    @Autowired
    private MusicRepository musicRepository;

    // 음악 업로드
    @PostMapping("/music/upload")
    public String uploadMusic(@RequestParam("file") MultipartFile file,
                              @RequestParam("title") String title,
                              @RequestParam("artist") String artist) throws IOException {
        musicService.uploadMusic(file, title, artist);
        return "redirect:/home";
    }

    @GetMapping("/music/delete/{id}")
    public String musicdelete(@PathVariable Long id) {
        musicRepository.deleteById(id);
        return "redirect:/home";
    }

}
