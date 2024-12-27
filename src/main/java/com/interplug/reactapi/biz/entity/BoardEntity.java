package com.interplug.reactapi.biz.entity;

import ch.qos.logback.classic.Logger;
import com.interplug.reactapi.biz.dto.board.BoardUpdateRequestDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "bt_tb_board")
public class BoardEntity{

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BoardEntity.class);
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

    @Column(name = "view_cnt", nullable = false)
    private int viewCnt;

    @Column(name = "reg_dt", nullable = false)
    private LocalDateTime regDt;

    @Column(name = "mod_dt")
    private LocalDateTime modDt;

    @PrePersist
    public void prePersist() {
        this.regDt = LocalDateTime.now();
        log.info("prePersist");
        this.viewCnt = 0;
        log.info("prePersist viewCnt={}", viewCnt);
    }

    @PreUpdate
    public void preUpdate() {
        this.modDt = LocalDateTime.now();
    }

    @Builder
    public BoardEntity(int boardNo, String categoryCd, String title, String cont, String writerNm,
                       String password, int viewCnt, LocalDateTime regDt, LocalDateTime modDt) {
        this.categoryCd = categoryCd;
        this.title = title;
        this.cont = cont;
        this.writerNm = writerNm;
        this.password = password;
        this.viewCnt = viewCnt;
        this.regDt = regDt;
        this.modDt = modDt;
        this.boardNo = boardNo;
    }

    public void update(BoardUpdateRequestDto boardUpdateRequestDto) {
        this.categoryCd = boardUpdateRequestDto.getCategoryCd();
        this.title = boardUpdateRequestDto.getTitle();
        this.cont = boardUpdateRequestDto.getCont();
    }
}
