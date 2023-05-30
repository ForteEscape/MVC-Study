package com.example.dispatcher.web.frontcontroller.v3.controller;

import com.example.dispatcher.domain.Member;
import com.example.dispatcher.repository.MemberRepository;
import com.example.dispatcher.web.frontcontroller.ModelView;
import com.example.dispatcher.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {

    private static final MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {

        List<Member> members = memberRepository.findAll();

        ModelView modelView = new ModelView("members");
        modelView.getModel().put("members", members);

        return modelView;
    }
}
