package com.example.project_K.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "music")
@Getter
@Setter
@NoArgsConstructor
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String artist;

    private String fileName;

    private String contentType;

    @Lob
    private byte[] file;

    public Music(String title, String artist, String fileName, String contentType, byte[] file) {
        this.title = title;
        this.artist = artist;
        this.fileName = fileName;
        this.contentType = contentType;
        this.file = file;
    }
}
