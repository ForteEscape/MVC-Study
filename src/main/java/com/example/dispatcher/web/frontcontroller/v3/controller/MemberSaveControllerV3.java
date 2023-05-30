package com.example.dispatcher.web.frontcontroller.v3.controller;

import com.example.dispatcher.domain.Member;
import com.example.dispatcher.repository.MemberRepository;
import com.example.dispatcher.web.frontcontroller.ModelView;
import com.example.dispatcher.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private static final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        String userName = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = memberRepository.save(new Member(userName, age));

        ModelView modelView = new ModelView("save-result");
        modelView.getModel().put("member", member);

        return modelView;
    }
}
