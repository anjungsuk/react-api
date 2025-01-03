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
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    @Query(value = "SELECT " +
                "b.board_no" +
                ", b.category_cd" +
                ", b.title" +
                ", b.writer_nm" +
                ", b.password" +
                ", b.cont" +
                ", b.view_cnt" +
                ", b.mod_dt" +
                ", b.reg_dt " +
            "FROM " +
            "   bt_tb_board b " +
            "WHERE " +
            "   b.category_cd = :categoryCd " +
            "   AND b.title = :title " +
            "   AND b.writer_nm = :writerNm",nativeQuery = true)
    List<BoardEntity> findAllByCategoryCdAndTitleAndWriterNm(@Param("categoryCd") String categoryCd,
                                                    @Param("title") String title,
                                                    @Param("writerNm") String writerNm);
}
