package com.interplug.reactapi.biz.repository.board;

import com.interplug.reactapi.biz.entity.board.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 *
 *
 * <pre>
 * 통합 게시판 CRUD Repository
 * </pre>
 *
 * @author junguKang (junguKang)
 * @ModifyDate 2024.12.13
 */
public interface BoardRepository extends JpaRepository<BoardEntity, Long>, BoardSearch {


}
