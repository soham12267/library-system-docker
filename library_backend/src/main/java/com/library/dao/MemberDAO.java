package com.library.dao;

import java.util.List;
import com.library.model.Member;

public interface MemberDAO {
    void addMember(Member member);
    Member getMemberById(int memberId);
    List<Member> getAllMembers();
    void updateMember(Member member);
    void deleteMember(int memberId);
}
