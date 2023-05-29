package com.example.dispatcher.repository;

import com.example.dispatcher.domain.Member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long seqId = 0L;
    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }

    private MemberRepository(){}

    public Member save(Member member){
        member.setId(++seqId);
        store.put(member.getId(), member);

        return member;
    }

    public Member findById(long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clear(){
        store.clear();
    }
}
