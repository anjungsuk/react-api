package com.interplug.reactapi.biz.dto.board.request;

import com.interplug.reactapi.biz.entity.board.BoardEntity;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {
    @NotEmpty
    private String writerNm;
    @NotEmpty
    private String password;
    @NotEmpty
    private String categoryCd;
    @NotEmpty
    private String title;
    @NotEmpty
    private String cont;

    /**
     *
     *
     * <pre>
     * 게시글 저장 RequestDto
     * </pre>
     *
     * @author junguKang (junguKang)
     * @ModifyDate 2024.12.13
     */

    @Builder
    public BoardSaveRequestDto(String writerNm, String password, String categoryCd, String title, String cont) {
        this.writerNm = writerNm;
        this.password = password;
        this.categoryCd = categoryCd;
        this.title = title;
        this.cont = cont;
    }

    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .categoryCd(categoryCd)
                .title(title)
                .cont(cont)
                .writerNm(writerNm)
                .password(password)
                .build();
    }
}
