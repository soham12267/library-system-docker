package com.library.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Member;
import com.library.util.DBConnection;

public class MemberDAOImpl implements MemberDAO {

    @Override
    public void addMember(Member member) {
        String sql = "INSERT INTO members (name, email, phone) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, member.getName());
            ps.setString(2, member.getEmail());
            ps.setString(3, member.getPhone());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Member getMemberById(int memberId) {
        String sql = "SELECT * FROM members WHERE member_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, memberId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return mapRow(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        String sql = "SELECT * FROM members";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                members.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return members;
    }

    @Override
    public void updateMember(Member member) {
        String sql = "UPDATE members SET name = ?, email = ?, phone = ? WHERE member_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, member.getName());
            ps.setString(2, member.getEmail());
            ps.setString(3, member.getPhone());
            ps.setInt(4, member.getMemberId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMember(int memberId) {
        String sql = "DELETE FROM members WHERE member_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, memberId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Member mapRow(ResultSet rs) throws SQLException {
        return new Member(
            rs.getInt("member_id"),
            rs.getString("name"),
            rs.getString("email"),
            rs.getString("phone")
        );
    }
}
