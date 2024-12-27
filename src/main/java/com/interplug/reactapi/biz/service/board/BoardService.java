package com.interplug.reactapi.biz.service.board;

import com.interplug.reactapi.biz.dto.board.BoardSaveRequestDto;
import com.interplug.reactapi.biz.dto.board.BoardSearchResponseDto;
import com.interplug.reactapi.biz.dto.board.BoardUpdateRequestDto;
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

    /**
     *
     *
     * <pre>
     * 통합게시판 게시글 수정
     * </pre>
     *
     * @author junguKang (junguKang)
     * @return void
     * @ModifyDate 2024.12.13
     */
    public void updateBoard(Long id, BoardUpdateRequestDto boardUpdateRequestDto){

        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(id + " 의 게시글을 조회 할 수 없습니다."));
        boardEntity.update(boardUpdateRequestDto);

        boardRepository.save(boardEntity);
    }
    /**
     *
     *
     * <pre>
     * 통합게시판 게시글 삭제
     * </pre>
     *
     * @author junguKang (junguKang)
     * @return void
     * @ModifyDate 2024.12.26
     */
    public void deleteBoard(Long id){
        BoardEntity boardEntity = boardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(id + "의 삭제 할 게시글을 찾을수 없습니다."));
        boardRepository.deleteById(id);
    }
}
