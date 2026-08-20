import { useState } from 'react';
import { issueBook } from '../services/api';
import { useNavigate } from 'react-router-dom';

function IssueBook() {
  const navigate = useNavigate();
  // Notice we only need bookId and memberId. Java will handle the dates!
  const [formData, setFormData] = useState({ bookId: '', memberId: '' });

  const handleSubmit = async (e) => {
    e.preventDefault(); 
    try {
      await issueBook(formData);
      alert('Book issued successfully!');
      navigate('/'); 
    } catch (err) {
      alert('Failed to issue book. Check IDs.');
    }
  };

  return (
    <div className="form-container">
      <h3>Issue a Book</h3>
      <form onSubmit={handleSubmit}>
        <div className="input-group">
          <label>Book ID:</label>
          <input type="number" required value={formData.bookId} onChange={(e) => setFormData({...formData, bookId: e.target.value})} />
        </div>
        <div className="input-group">
          <label>Member ID:</label>
          <input type="number" required value={formData.memberId} onChange={(e) => setFormData({...formData, memberId: e.target.value})} />
        </div>
        <button type="submit">Issue Book</button>
      </form>
    </div>
  );
}

export default IssueBook;