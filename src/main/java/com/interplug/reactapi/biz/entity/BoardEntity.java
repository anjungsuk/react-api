package com.interplug.reactapi.biz.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "bt_tb_board")
public class BoardEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no", nullable = false)
    private int boardNo;

    @Column(name = "category_cd", length = 30)
    private String categoryCd;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Column(name = "cont", columnDefinition = "TEXT")
    private String cont;

    @Column(name = "writer_nm", nullable = false, length = 50)
    private String writerNm;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "view_cnt")
    private int viewCnt;

    @Column(name = "reg_dt", nullable = false)
    private LocalDateTime regDt;

    @Column(name = "mod_dt")
    private LocalDateTime modDt;

    @Builder
    public BoardEntity(String categoryCd, String title, String cont, String writerNm,
                       String password, Integer viewCnt, LocalDateTime regDt, LocalDateTime modDt) {
        this.categoryCd = categoryCd;
        this.title = title;
        this.cont = cont;
        this.writerNm = writerNm;
        this.password = password;
        this.viewCnt = viewCnt;
        this.regDt = regDt;
        this.modDt = modDt;
    }
}
