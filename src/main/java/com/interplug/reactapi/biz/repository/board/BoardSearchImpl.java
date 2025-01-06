package com.interplug.reactapi.biz.repository.board;

import com.interplug.reactapi.biz.entity.board.BoardEntity;

import com.interplug.reactapi.biz.entity.board.QBoardEntity;
import com.querydsl.core.types.Order;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.support.PageableExecutionUtils;


import java.util.List;

public class BoardSearchImpl implements BoardSearch {

    private final JPAQueryFactory queryFactory;

    public BoardSearchImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }
    @Override
    public Page searchBoardDynamicList(PageRequest page, String searchCategory, String searchType, String searchKeyword){

        QBoardEntity qBoardEntity = QBoardEntity.boardEntity;

        List<BoardEntity> content = queryFactory
                .selectFrom(qBoardEntity)
                .where(searchCategoryEq(searchCategory),
                        searchTypeEq(searchType, searchKeyword))
                .offset(page.getOffset())
                .limit(page.getPageSize())
                .orderBy(itemSort(page))
                .fetch();

        JPAQuery<BoardEntity> countQuery = queryFactory
                .selectFrom(qBoardEntity)
                .offset(page.getOffset())
                .limit(page.getPageSize())
                .orderBy(itemSort(page));
        return PageableExecutionUtils.getPage(content, page, countQuery::fetchCount);
    }

    private BooleanExpression searchCategoryEq(String searchCategory) {
        return searchCategory != null ? QBoardEntity.boardEntity.categoryCd.eq(searchCategory) : null;
    }
    private BooleanExpression searchTypeEq(String searchType, String searchKeyword) {
        switch (String.valueOf(searchType)) {
            case "title":
                return searchKeyword!= null ? QBoardEntity.boardEntity.title.like(searchKeyword) : null;
            case "content":
                return searchKeyword!= null ? QBoardEntity.boardEntity.cont.like(searchKeyword) : null;
            case "titletContent":
                return searchKeyword!= null ? QBoardEntity.boardEntity.title.like(searchKeyword).and(QBoardEntity.boardEntity.cont.like(searchKeyword)) : null;
            case "writer" :
                return searchKeyword!= null ? QBoardEntity.boardEntity.writerNm.eq(searchKeyword) : null;
        }
        return null;
    }

    private OrderSpecifier<?> itemSort(PageRequest page) {
        for(Sort.Order order : page.getSort()) {
            Order direction = order.getDirection().isAscending() ? Order.ASC : Order.DESC;
            switch (order.getProperty()) {
                case "viewCnt":
                    return new OrderSpecifier<>(direction, QBoardEntity.boardEntity.viewCnt);
                case "createDate":
                    return new OrderSpecifier<>(direction, QBoardEntity.boardEntity.regDt);
            }
        }

        return null;
    }
}
