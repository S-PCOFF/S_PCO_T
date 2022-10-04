package com.shds.pco.web;

import com.shds.pco.service.posts.PostsService;
import com.shds.pco.web.dto.PostsResponseDto;
import com.shds.pco.web.dto.PostsSaveRequestDto;
import com.shds.pco.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Slf4j
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        log.info("PostsApiController save ========= {}", requestDto);
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        log.info("PostsApiController update ========= {}", requestDto);
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        log.info("PostsApiController findById ========= {}", id);
        return postsService.findById(id);
    }
}