package com.dw.member.service;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

// 알고리즘구현 (코딩) : Service
// 컨트롤로 -> 서비스 -> 레파지스토리
// MVC 중요! 면접때 나옴 (검색해보기)
@Service
// JAVA에서 구글로 API 전송하는 로직
public class MainService {
    public boolean verifyRecaptcha(String recaptcha) {
        final String SECRET_KEY = "6LfXOpYjAAAAAJ6BvS9CsSFnA3_qTBRNZkV7NmUJ";
        final String RE_URL = "https://www.google.com/recaptcha/api/siteverify";// 리캡차 인증 주소
        try {
            URL obj = new URL(RE_URL);
            HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
            con.setRequestMethod("POST");

            String postParams = "secret=" + SECRET_KEY + "&response=" + recaptcha;
            con.setDoOutput(true);

            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(postParams);
            wr.flush();
            wr.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JsonReader jsonReader = Json.createReader(new StringReader(response.toString()));
            JsonObject jsonObject = jsonReader.readObject();
            jsonReader.close();
            return jsonObject.getBoolean("success"); // true or false

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
