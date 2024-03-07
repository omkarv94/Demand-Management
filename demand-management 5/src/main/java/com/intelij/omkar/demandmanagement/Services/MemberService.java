package com.intelij.omkar.demandmanagement.Services;

import com.intelij.omkar.demandmanagement.Model.Demand;
import com.intelij.omkar.demandmanagement.Model.Member;
import com.intelij.omkar.demandmanagement.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    public Optional<Member> getMemberByEid(String eid) {
        return memberRepository.findByEid(eid);
    }

    public List<Member> getMembersByFirstNameAndLastName(String firstName, String lastName) {
        return memberRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public List<Member> getMembersByLocation(String location) {
        return memberRepository.findByLocation(location);
    }

    public List<Member> getMembersByStatus(Member.StatusChoice status) {
        return memberRepository.findByStatus(status);
    }
}

