package com.example.ex15.member;

import com.example.ex15.member.entity.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {

    @GetMapping("/memberList")
    public String memberList() {

        return "memberList";
    }



    @GetMapping("/members")
    @ResponseBody
    public Map<String, Object> memberListApi() {
        Map<String, Object> results = new HashMap<>();
        ArrayList<Member> list = new ArrayList<>();

        for(int i=0; i<10; i++) {
            Member member = new Member();

            member.setName("홍길동 " + i);
            member.setJumin("주민번호 " + i);
            member.setAddress("홍길동 집 주소 " + i);

            list.add(member);
        }

        results.put("content", list);
        results.put("message", "SUCCESS");

        return results;
    }
}
