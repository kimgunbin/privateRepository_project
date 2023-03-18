package com.example.project_K.controller;

import com.example.project_K.entity.Music;
import com.example.project_K.entity.testboard;
import com.example.project_K.respository.BoardRepository;
import com.example.project_K.respository.MusicRepository;
import com.example.project_K.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller // 뷰를 반환(데이터)
public class mainController {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private MusicRepository musicRepository;
    @GetMapping("/home")
    public String homepage(Model model){
        // 모든 게시글을 가져온다
        List<testboard> testboardList = boardRepository.findAll();
        // 가져온 데이터를 뷰로 전달
        model.addAttribute("testboardList",testboardList);
        // 음악 목록 조회
        List<Music> musiclist = musicRepository.findAll();
        // 가져온 데이터를 뷰로 전달
        model.addAttribute("musiclist",musiclist);

        // 뷰페이지 설정
        return "index";
    }

    @RequestMapping("/test")
    public String Calendar() {
        return "test";
    }

    @GetMapping("/music/uploadboard")
    public String uploadboard(){
        return "musicupload";
    }


}
