package com.interplug.reactapi.biz.repository.board;

import com.interplug.reactapi.biz.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

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
public interface BoardRepository extends JpaRepository<BoardEntity, Long> { }
