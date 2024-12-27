package com.interplug.reactapi.biz.dto.board.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 *
 * <pre>
 * 게시글 수정 RequestDto
 * </pre>
 *
 * @author junguKang (junguKang)
 * @ModifyDate 2024.12.26
 */
@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {

    @NotBlank
    private String categoryCd;
    @NotBlank
    private String title;
    @NotBlank
    private String cont;

    @Builder
    public BoardUpdateRequestDto(String categoryCd, String title, String cont) {
        this.categoryCd = categoryCd;
        this.title = title;
        this.cont = cont;
    }

}
