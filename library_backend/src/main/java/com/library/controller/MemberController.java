package com.library.controller;

import org.springframework.web.bind.annotation.*;
import com.library.model.Member;
import com.library.dao.MemberDAO;
import com.library.dao.MemberDAOImpl;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173")
public class MemberController {

    private MemberDAO memberDAO = new MemberDAOImpl();

    @GetMapping("/members")
    public List<Member> getAllMembers() {
        return memberDAO.getAllMembers();
    }

    @PostMapping("/members")
    public String addMember(@RequestBody Member member) {
        memberDAO.addMember(member);
        return "Member added successfully";
    }
}