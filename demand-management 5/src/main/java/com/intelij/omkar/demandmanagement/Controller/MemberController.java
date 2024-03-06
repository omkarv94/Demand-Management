package com.intelij.omkar.demandmanagement.Controller;

import com.intelij.omkar.demandmanagement.Model.Member;
import com.intelij.omkar.demandmanagement.Services.DemandService;
import com.intelij.omkar.demandmanagement.Services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @Autowired
    private MemberService memberService;
    @PostMapping(path = "/add")
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @GetMapping(path = "/showall")
    public List<Member> showMembers() {
        return memberService.showMembers();
    }

}
