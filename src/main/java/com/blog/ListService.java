package com.blog;

import com.google.gson.Gson;
import com.models.ListModel;
import com.models.PostModel;
import com.util.ApiList;
import com.util.ApiSender;
import org.springframework.stereotype.Service;

@Service
public class ListService {
    public ListModel get_post(String blogger) throws Exception {
        Gson gson = new Gson();
        //api를 get방식으로 요청한 후 돌려받는 메서드
        //json String형식 또는 'False' 문자열을 리턴한다
        String str = ApiList.get("http://127.0.0.1:8000/contents/"+blogger);

        ListModel ListModel = gson.fromJson(str, ListModel.class);

        return ListModel;
    }


}