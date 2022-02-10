package com.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.ui.Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApiSender{
    public static String get() throws Exception {
        URL url = new URL("http://127.0.0.1:8000/contents/4");

        ObjectMapper mapper = new ObjectMapper();
        StringBuilder sb = new StringBuilder();
        BufferedReader br;

        List<Map<String, Object>> listMap = new ArrayList<Map<String,Object>>();

        String res;
        try {
            HttpURLConnection con = (HttpURLConnection)url.openConnection();

            //Request Header 정의
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");

            //전송방식
            con.setRequestMethod("GET");

            //서버에 연결되는 Timeout 시간 설정
            con.setConnectTimeout(5000);

            //InputStream 읽어 오는 Timeout 시간 설정
            con.setReadTimeout(5000);

            //URLConnection에 대한 doOutput 필드값을 지정된 값으로 설정한다.
            //URL 연결은 입출력에 사용될 수 있다.
            //URL 연결을 출력용으로 사용하려는 경우 DoOutput 플래그를 true로 설정하고,
            //그렇지 않은 경우는 false로 설정해야 한다. 기본값은 false이다.
            con.setDoOutput(false);

            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\n");
                }
                br.close();
                res = sb.toString();
            } else {
                res = "false";
            }
        } catch (Exception e) {
            res = e.toString();
        }

        return res;
    }
}
