package com.interplug.reactapi.biz.repository.board;

import com.interplug.reactapi.biz.entity.board.BoardEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface BoardSearch {
    Page searchBoardDynamicList(PageRequest pageRequest, String searchCategory, String searchType,String searchKeyword);
}
