package com.blog;

import com.google.gson.Gson;
import com.models.Comments;
import com.models.Content;
import com.models.PostModel;
import com.util.Uploader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class FileController {
    @RequestMapping(value="smarteditorMultiImageUpload")
    public void return_post (HttpServletRequest request, HttpServletResponse response) throws Exception {

        Uploader uploader = new Uploader();
        uploader.upload_image(request,response);

    }
}