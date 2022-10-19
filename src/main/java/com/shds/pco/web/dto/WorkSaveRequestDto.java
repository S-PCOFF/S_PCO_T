package com.shds.pco.web.dto;

import com.shds.pco.domain.work.Work;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WorkSaveRequestDto {

    //private long idx;

    private long id;

    private String name;

    private String workDate;

    private int workMinute;

    @Builder
    public WorkSaveRequestDto(long id, String name, String workDate, int workMinute) {
        this.id = id;
        this.name = name;
        this.workDate = workDate;
        this.workMinute = workMinute;
    }

    public Work toEntity() {
        return Work.builder()
                .id(id)
                .name(name)
                .workDate(workDate)
                .workMinute(workMinute)
                .build();
    }

}
