import { useState } from 'react';
import { addMember } from '../services/api';
import { useNavigate } from 'react-router-dom';

function AddMember() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({ name: '', email: '', phone: '' });

  const handleSubmit = async (e) => {
    e.preventDefault(); 
    try {
      await addMember(formData);
      alert('Member registered successfully!');
      navigate('/members'); // Redirect to member list
    } catch (err) {
      alert('Failed to register member.');
    }
  };

  return (
    <div className="form-container">
      <h3>Register New Member</h3>
      <form onSubmit={handleSubmit}>
        <div className="input-group">
          <label>Full Name:</label>
          <input type="text" required value={formData.name} onChange={(e) => setFormData({...formData, name: e.target.value})} />
        </div>
        <div className="input-group">
          <label>Email Address:</label>
          <input type="email" required value={formData.email} onChange={(e) => setFormData({...formData, email: e.target.value})} />
        </div>
        <div className="input-group">
          <label>Phone Number:</label>
          <input type="text" value={formData.phone} onChange={(e) => setFormData({...formData, phone: e.target.value})} />
        </div>
        <button type="submit">Register Member</button>
      </form>
    </div>
  );
}

export default AddMember;