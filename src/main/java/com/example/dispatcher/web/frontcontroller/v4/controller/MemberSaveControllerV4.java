package com.example.dispatcher.web.frontcontroller.v4.controller;

import com.example.dispatcher.domain.Member;
import com.example.dispatcher.repository.MemberRepository;
import com.example.dispatcher.web.frontcontroller.ModelView;
import com.example.dispatcher.web.frontcontroller.v4.ControllerV4;

import java.util.Map;

public class MemberSaveControllerV4 implements ControllerV4 {
    private static final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String userName = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = memberRepository.save(new Member(userName, age));
        model.put("member", member);

        return "save-result";
    }
}
