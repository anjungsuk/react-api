package com.interplug.reactapi.biz.controller.board;

import com.interplug.reactapi.biz.dto.board.request.BoardSaveRequestDto;
import com.interplug.reactapi.biz.dto.board.response.BoardSearchDetailResponseDto;
import com.interplug.reactapi.biz.dto.board.response.BoardSearchResponseDto;
import com.interplug.reactapi.biz.dto.board.request.BoardUpdateRequestDto;
import com.interplug.reactapi.biz.entity.board.BoardEntity;
import com.interplug.reactapi.biz.service.board.BoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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
     * @ModifyDate 2024.12.21
     */
    @Tag(name = "목록 조회")
    @Operation(summary = "목록조회", description = "조회 성공시 게시판 목록을 반환한다.")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @Parameter(name = "searchCategory", description = "카테고리", example = "notice")
    @Parameter(name = "searchType", description = "검색 조건", example = "title")
    @Parameter(name = "searchKeyword", description = "검색어", example = "Spring")
    @Parameter(name = "page", description = "페이지 시작", example = "0")
    @Parameter(name = "size", description = "페이지 사이즈", example = "10")
    @Parameter(name = "sort", description = "정렬 순서", example = "createDate")
    @GetMapping("/list")
    public ResponseEntity<?>getBoardList(
            @RequestParam(value = "searchCategory", required = false) String searchCategory,
            @RequestParam(value = "searchType", required = false) String searchType,
            @RequestParam(value = "searchKeyword" , required = false) String searchKeyword,
            @RequestParam("sort") String sort,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        log.info("parameter >> searchCategory = {}, searchType = {}, searchKeyword = {}", searchCategory, searchType, searchKeyword);

        Page<BoardSearchResponseDto> boardList = boardService.getBoardList(searchCategory, searchType, searchKeyword, sort, page, size);
        return ResponseEntity.ok(boardList);
    }
    /**
     *
     *
     * <pre>
     * 게시글 상세 조회 Controller
     * </pre>
     *
     * @author junguKang (junguKang)
     * @ModifyDate 2024.12.27
     */
    @Tag(name = "게시글 상세 조회")
    @Operation(summary = "상세 조회", description = "조회 성공시 게시글 상세 내역을 반환한다.")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNER SEVER ERROR")
    @GetMapping("/listDetail/{id}")
    public ResponseEntity<BoardSearchDetailResponseDto> getBoardDetail(@RequestParam Long id){
        BoardSearchDetailResponseDto boardSearchDetailResponseDto = boardService.getBoardDetail(id);
        return ResponseEntity.ok(boardSearchDetailResponseDto);
    }

    /**
     *
     *
     * <pre>
     * 게시글 저장 Controller
     * </pre>
     *
     * @author junguKang (junguKang)
     * @ModifyDate 2024.12.21
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

    /**
     *
     *
     * <pre>
     * 게시글 수정 Controller
     * </pre>
     *
     * @author junguKang (junguKang)
     * @ModifyDate 2024.12.26
     */
    @Tag(name="게시글 수정")
    @Operation(summary = "게시글 수정", description = "작성한 통합게시판 게시글을 수정한다.")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNER SEVER ERROR")
    @PutMapping("/listUpdate")
    public ResponseEntity<BoardEntity> updateBoard(@RequestParam Long id, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto){
        boardService.updateBoard(id, boardUpdateRequestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     *
     *
     * <pre>
     * 게시글 삭제 Controller
     * </pre>
     *
     * @author junguKang (junguKang)
     * @ModifyDate 2024.12.27
     */
    @Tag(name="게시글 삭제")
    @Operation(summary = "게시글 삭제", description = "작성한 통합게시판 게시글을 삭제한다.")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "404", description = "NOT FOUND")
    @ApiResponse(responseCode = "500", description = "INTERNER SEVER ERROR")
    @DeleteMapping("/listDelete/{id}")
    public ResponseEntity<BoardEntity> deleteBoard(@RequestParam Long id){
        boardService.deleteBoard(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
