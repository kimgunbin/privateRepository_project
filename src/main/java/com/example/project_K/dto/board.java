package com.example.project_K.dto;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //DB가 해당 객체를 인식 (해당클래스로 테이블을만듬)
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Getter
@Setter
public class board {
    @Id                             //오라클 -mysql은 identity임
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String title;
    private String content;
    private String filename;//파일이름
    private String filepath;//파일경로
}
