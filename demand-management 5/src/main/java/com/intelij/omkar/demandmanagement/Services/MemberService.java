package com.intelij.omkar.demandmanagement.Services;

import com.intelij.omkar.demandmanagement.Model.Member;
import com.intelij.omkar.demandmanagement.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> showMembers() {
        return memberRepository.findAll();
    }

}

