package com.example.dispatcher.repository;

import com.example.dispatcher.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    private static final MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach(){
        memberRepository.clear();
    }

    @Test
    void save() {
        //given
        Member userA = new Member("userA", 15);

        //when
        Member savedMember = memberRepository.save(userA);

        //then
        Member result = memberRepository.findById(savedMember.getId());

        assertThat(savedMember.getUsername()).isEqualTo(result.getUsername());
        assertThat(savedMember.getAge()).isEqualTo(result.getAge());
    }

    @Test
    void findAll() {
        //given
        Member userA = new Member("userA", 15);
        Member userB = new Member("userB", 20);

        //when
        Member memberA = memberRepository.save(userA);
        Member memberB = memberRepository.save(userB);

        //then
        List<Member> memberList = memberRepository.findAll();

        assertThat(memberList.size()).isEqualTo(2);
        assertThat(memberList).contains(memberA, memberB);
    }
}