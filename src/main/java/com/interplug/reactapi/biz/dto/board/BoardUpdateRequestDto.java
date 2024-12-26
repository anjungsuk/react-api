package com.interplug.reactapi.biz.dto.board;

import com.interplug.reactapi.biz.entity.BoardEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

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
    @CreationTimestamp
    private LocalDateTime modDt;

    @Builder
    public BoardUpdateRequestDto(String categoryCd, String title, String cont, LocalDateTime modDt) {
        this.categoryCd = categoryCd;
        this.title = title;
        this.cont = cont;
        this.modDt = modDt;
    }

}
