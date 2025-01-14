package com.interplug.reactapi.biz.dto.board.response;

import com.interplug.reactapi.biz.entity.board.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class BoardSearchResponseDto {

    //NO
    private int boardNo;
    //categoryCd
    private String categoryCd;
    //title
    private String title;
    //writerNm
    private String writerNm;
    //viewCnt
    private int viewCnt;
    //regDt
    private LocalDateTime regDt;

    @Builder
    public BoardSearchResponseDto(BoardEntity boardEntity) {
        this.boardNo = boardEntity.getBoardNo();
        this.categoryCd = boardEntity.getCategoryCd();
        this.title = boardEntity.getTitle();
        this.writerNm = boardEntity.getWriterNm();
        this.viewCnt = boardEntity.getViewCnt();
        this.regDt = boardEntity.getRegDt();
    }
}
