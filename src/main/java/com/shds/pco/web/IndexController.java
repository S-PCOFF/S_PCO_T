package com.shds.pco.web;

import com.shds.pco.conf.auth.LoginUser;
import com.shds.pco.conf.auth.dto.SessionUser;
import com.shds.pco.service.posts.PostsService;
import com.shds.pco.service.work.WorkService;
import com.shds.pco.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
@Slf4j
public class IndexController {

    private final PostsService postsService;

    private final WorkService workService;

    private final HttpSession httpSession;

//    @GetMapping("/")
//    public String index(Model model) {
//        model.addAttribute("posts", postsService.findAllDesc());
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//
//        if (user != null) {
//            model.addAttribute("userName", user.getName());
//        }
//
//        return "index";
//    }

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null) {
            model.addAttribute("userName", user.getName());
        }

        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }


    @GetMapping("/work")
    public String workIndex(Model model, @LoginUser SessionUser user) {
        model.addAttribute("work", workService.findAllDesc());

        if (user != null) {
            model.addAttribute("userName", user.getName());
            model.addAttribute("userId", user.getId());
        }

        return "work-index";
    }

    @GetMapping("/work/save/{userId}")
    public String workSave(@PathVariable long userId, Model model) {
        model.addAttribute("userId", userId);

        return "work-save";
    }

    @GetMapping("/work/update/{idx}")
    public String workUpdate(@PathVariable Long idx, Model model) {
        model.addAttribute("work", workService.findById(idx));
        return "work-update";
    }


}
