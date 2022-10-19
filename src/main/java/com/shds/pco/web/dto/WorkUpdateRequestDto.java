package com.shds.pco.web.dto;

import com.shds.pco.domain.work.Work;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WorkUpdateRequestDto {

    private String name;

    private String workDate;

    private int workMinute;


    public WorkUpdateRequestDto(Work entity) {
        this.name = entity.getName();
        this.workDate = entity.getWorkDate();
        this.workMinute = entity.getWorkMinute();
    }
}
