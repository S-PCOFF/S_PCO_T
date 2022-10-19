package com.shds.pco.web;


import com.shds.pco.service.work.WorkService;
import com.shds.pco.web.dto.PostsUpdateRequestDto;
import com.shds.pco.web.dto.WorkSaveRequestDto;
import com.shds.pco.web.dto.WorkUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
public class WorkController {

    private final WorkService workService;

    @PostMapping("/api/v1/work")
    public Long save(@RequestBody WorkSaveRequestDto workSaveRequestDto) {
        return workService.save(workSaveRequestDto);
    }

    @PutMapping("/api/v1/work/{idx}")
    public Long update(@PathVariable Long idx, @RequestBody WorkUpdateRequestDto workUpdateRequestDto) {
        return workService.update(idx, workUpdateRequestDto);
    }

    @DeleteMapping("/api/v1/work/{idx}")
    public Long delete(@PathVariable Long idx) {
        workService.delete(idx);
        return idx;
    }

}
