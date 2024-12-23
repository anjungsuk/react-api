package com.interplug.reactapi.biz.service.board;

import com.interplug.reactapi.biz.dto.board.BoardSaveRequestDto;
import com.interplug.reactapi.biz.dto.board.BoardSearchResponseDto;
import com.interplug.reactapi.biz.entity.BoardEntity;
import com.interplug.reactapi.biz.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    /**
     *
     *
     * <pre>
     * 게시판 전체 조회
     * </pre>
     *
     * @author junguKang (junguKang)
     * @return boardEntityList
     */
    public List<BoardSearchResponseDto> getBoardList(){
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        return boardEntityList.stream().map(BoardSearchResponseDto::new).collect(Collectors.toList());
    }

    /**
     *
     *
     * <pre>
     * 통합게시판 게시글 등록
     * </pre>
     *
     * @author junguKang (junguKang)
     * @return void
     * @ModifyDate 2024.12.13
     */

    @Transactional
    public void saveBoard(BoardSaveRequestDto boardSaveRequestDto){
        BoardEntity boardEntity = boardSaveRequestDto.toEntity();
        BoardEntity savedBoardEntity = boardRepository.save(boardEntity);
    }
}
