package com.shds.pco.web.dto;

import com.shds.pco.domain.work.Work;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class WorkResponseDto {

    private long idx;

    private long id;

    private String name;

    private String workDate;

    private int workMinute;


    public WorkResponseDto(Work entity) {
        this.idx = entity.getIdx();
        this.id = entity.getId();
        this.name = entity.getName();
        this.workDate = entity.getWorkDate();
        this.workMinute = entity.getWorkMinute();
    }
}
