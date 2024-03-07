package com.intelij.omkar.demandmanagement.Controller;

import com.intelij.omkar.demandmanagement.Model.Demand;
import com.intelij.omkar.demandmanagement.Model.Member;
import com.intelij.omkar.demandmanagement.Services.DemandService;
import com.intelij.omkar.demandmanagement.Services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

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

    @GetMapping(path = "/{eid}")
    public ResponseEntity<Member> getMemberByEid(@PathVariable String eid) {
        return memberService.getMemberByEid(eid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/status/{status}")
    public List<Member> getMembersByStatus(@PathVariable Member.StatusChoice status) {
        return memberService.getMembersByStatus(status);
    }
    @GetMapping(path = "/searchByName")
    public List<Member> getMembersByFirstNameAndLastName(@RequestParam String firstName, @RequestParam String lastName) {
        return memberService.getMembersByFirstNameAndLastName(firstName, lastName);
    }

    @GetMapping(path = "/location/{location}")
    public List<Member> getMembersByLocation(@PathVariable String location) {
        return memberService.getMembersByLocation(location);
    }
}
