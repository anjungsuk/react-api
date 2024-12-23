package com.interplug.reactapi.biz.controller.board;

import com.interplug.reactapi.biz.dto.board.BoardSaveRequestDto;
import com.interplug.reactapi.biz.dto.board.BoardSearchResponseDto;
import com.interplug.reactapi.biz.entity.BoardEntity;
import com.interplug.reactapi.biz.service.board.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/board/v1")
public class BoardController {

    private final BoardService boardService;

    /**
     *
     *
     * <pre>
     * 게시글 전체 조회 Controller
     * </pre>
     *
     * @author junguKang (junguKang)
     * @ModifyDate 2024.12.13
     */
    @Tag(name = "목록 조회")
    @Operation(summary = "목록조회", description = "조회 성공시 게시판 목록을 반환한다.")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @GetMapping("/list")
    public ResponseEntity<List<BoardSearchResponseDto>> getBoardList(){
        List<BoardSearchResponseDto> boardList = boardService.getBoardList();
        return ResponseEntity.ok(boardList);
    }

    /**
     *
     *
     * <pre>
     * 게시글 저장 Controller
     * </pre>
     *
     * @author junguKang (junguKang)
     * @ModifyDate 2024.12.13
     */
    @Tag(name="게시글 저장")
    @Operation(summary = "게시글 저장", description = "작성한 통합게시판 게시글을 저장한다.")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNER SEVER ERROR")

    @PostMapping("/listSave")
    public ResponseEntity<BoardEntity> saveBoard(@RequestBody BoardSaveRequestDto boardSaveRequestDto){
        boardService.saveBoard(boardSaveRequestDto);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
