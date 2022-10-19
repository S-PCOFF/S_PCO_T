package com.shds.pco.web.dto;

import com.shds.pco.domain.work.Work;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class WorkListResponseDto {
    private long idx;

    private long id;

    private String name;

    private String workDate;

    private int workMinute;

    private LocalDateTime modifiedDate;


    public WorkListResponseDto(Work entity) {
        this.idx = entity.getIdx();
        this.id = entity.getId();
        this.name = entity.getName();
        this.workDate = entity.getWorkDate();
        this.workMinute = entity.getWorkMinute();
        this.modifiedDate = entity.getModifiedDate();
    }
}