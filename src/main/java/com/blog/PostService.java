package com.blog;

import com.google.gson.Gson;
import com.models.PostModel;
import com.util.ApiSender;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    public PostModel get_post(int index) throws Exception {
        Gson gson = new Gson();

        //api를 get방식으로 요청한 후 돌려받는 메서드
        //json String형식 또는 'False' 문자열을 리턴한다
        String str = ApiSender.get("http://127.0.0.1:8000/contents/"+index);

        PostModel postModel = gson.fromJson(str, PostModel.class);

        return postModel;
    }


}