package com.blog;

import com.google.gson.Gson;
import com.models.Comments;
import com.models.Content;
import com.models.ListModel;
import com.models.PostModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {
    @GetMapping("/sukho")
    public String return_sukho (Model model) {
        return "sukho/index";
    }

    @GetMapping("/sukho/post")
    public String return_post (Model model, @RequestParam(value = "index, blogger")int index, String blogger) throws Exception {

        //api를 get방식으로 요청한 후 돌려받는 메서드
        //json String형식 또는 'False' 문자열을 리턴한다
        PostService postService = new PostService();
        PostModel postModel = postService.get_post(index, blogger);
        Content content=postModel.getContent();
        List<Comments> comments = postModel.getComments();

        if (model.getAttribute("title") == null){
            model.addAttribute("title",content.title);
            model.addAttribute("created_at",content.created_at);
            model.addAttribute("content",content.content);
        }

        return "sukho/post";
    }

    @GetMapping("/sukho/write")
    public String return_write (Model model, @RequestParam(value = "blogger")String blogger) throws Exception {


        return "sukho/write";
    }



    //    Jinah
    @GetMapping("/jinah")
    public String return_jinah (Model model) {
        return "jinah/index";
    }

    @GetMapping("/jinah/post")
    public String return_jinah_post (Model model, @RequestParam(value = "index, blogger")int index, String blogger) throws Exception {

        //api를 get방식으로 요청한 후 돌려받는 메서드
        //json String형식 또는 'False' 문자열을 리턴한다
        PostService postService = new PostService();
        PostModel postModel = postService.get_post(index, blogger);
        Content content=postModel.getContent();
        List<Comments> comments = postModel.getComments();

        if (model.getAttribute("title") == null){
            model.addAttribute("title",content.title);
            model.addAttribute("created_at",content.created_at);
            model.addAttribute("content",content.content);
        }

        return "jinah/post";
    }

    @GetMapping("/jinah/write")
    public String return_jinah_write (Model model, @RequestParam(value = "blogger")String blogger) throws Exception {


        return "jinah/write";
    }
//    List
    @GetMapping("/jinah/list")
    public String return_jinah_list (Model model, @RequestParam(value = "blogger")String blogger) throws Exception {
        ListService listService = new ListService();
        ListModel listModel = listService.get_post(blogger);
        Content content= listModel.getContent();
        List<Comments> comments = listModel.getComments();

        if (model.getAttribute("title") == null){
            model.addAttribute("title",content.title);
            model.addAttribute("created_at",content.created_at);
            model.addAttribute("content",content.content);
        }

        return "jinah/list";
    }
}