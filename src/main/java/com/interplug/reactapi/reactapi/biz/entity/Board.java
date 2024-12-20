package com.interplug.reactapi.reactapi.biz.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table
public class Board {

    @Id
    @Column(name = "board_no", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardNo;


}
