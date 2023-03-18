package com.example.project_K.dto;

import lombok.*;

import javax.persistence.Lob;

@AllArgsConstructor
@ToString
@Setter
@NoArgsConstructor
@Getter
public class MusicDto {

    private Long id;

    private String title;

    private String artist;

    private String fileName;

    private String contentType;

    @Lob
    private byte[] file;

}
