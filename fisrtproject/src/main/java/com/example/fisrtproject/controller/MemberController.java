package com.example.fisrtproject.controller;

import com.example.fisrtproject.dto.MemberForm;
import com.example.fisrtproject.entity.Member;
import com.example.fisrtproject.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/members/new")
    public String signin (){
        return "members/new";
    }

    @PostMapping("/join")
    public String createMembers(MemberForm form) {
        System.out.println(form.toString());
        //dto를 엔티티로 변환
        Member member = form.toEntity();
        System.out.println(member.toString());
        //DB
        Member saved = memberRepository.save(member);
        System.out.println(saved.toString());

        return "members/new";
    }
}
