import { useState, useEffect } from 'react';
import { getMembers } from '../services/api';

function MemberList() {
  const [members, setMembers] = useState([]);

  useEffect(() => {
    loadMembers();
  }, []);

  const loadMembers = async () => {
    try {
      const response = await getMembers();
      setMembers(response.data);
    } catch (err) {
      console.error("Error loading members", err);
    }
  };

  return (
    <div>
      <h3>Library Members</h3>
      <table className="data-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
          </tr>
        </thead>
        <tbody>
          {members.map((member) => (
            <tr key={member.memberId || member.member_id}>
              <td>{member.memberId || member.member_id}</td>
              <td>{member.name}</td>
              <td>{member.email}</td>
              <td>{member.phone}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default MemberList;