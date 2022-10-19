package com.shds.pco.service.work;


import com.shds.pco.domain.work.Work;
import com.shds.pco.domain.work.WorkRepository;
import com.shds.pco.web.dto.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class WorkService {

    public final WorkRepository workRepository;


    @Transactional
    public Long save(WorkSaveRequestDto workSaveRequestDto) {
        return workRepository.save(workSaveRequestDto.toEntity()).getId();
    }

    @Transactional
    public List<WorkListResponseDto> findAllDesc() {
        return workRepository.findAllDesc().stream()
                .map(WorkListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public WorkResponseDto findById(Long idx) {
        Work entity = workRepository.findById(idx).orElseThrow(() -> new IllegalArgumentException("해당 근무가 없습니다. idx=" + idx));
        return new WorkResponseDto(entity);
    }

    @Transactional
    public Long update(Long idx, WorkUpdateRequestDto requestDto) {
        Work work = workRepository.findById(idx).orElseThrow(() -> new IllegalArgumentException("해당 근무가 없습니다. idx=" + idx));
        work.update(requestDto.getName(), requestDto.getWorkDate(), requestDto.getWorkMinute());
        return idx;
    }

    @Transactional
    public void delete(Long idx) {
        Work work = workRepository.findById(idx)
                .orElseThrow(() -> new IllegalArgumentException("해당 근무가 없습니다. idx=" + idx));

        workRepository.delete(work);
    }


}
