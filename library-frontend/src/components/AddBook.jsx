import { useState } from 'react';
import { addBook } from '../services/api';
import { useNavigate } from 'react-router-dom';

function AddBook() {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    title: '',
    author: '',
    isbn: '',
    available: true
  });

  const handleSubmit = async (e) => {
    e.preventDefault(); 
    try {
      await addBook(formData);
      alert('Book added successfully!');
      navigate('/'); // Sends you back to the list page
    } catch (err) {
      alert('Failed to save book. Is Spring Boot running?');
    }
  };

  return (
    <div className="form-container">
      <h3>Add a New Book</h3>
      <form onSubmit={handleSubmit}>
        <div className="input-group">
          <label>Title:</label>
          <input 
            type="text" 
            required 
            value={formData.title}
            onChange={(e) => setFormData({...formData, title: e.target.value})}
          />
        </div>
        <div className="input-group">
          <label>Author:</label>
          <input 
            type="text" 
            required 
            value={formData.author}
            onChange={(e) => setFormData({...formData, author: e.target.value})}
          />
        </div>
        <div className="input-group">
          <label>ISBN:</label>
          <input 
            type="text" 
            value={formData.isbn}
            onChange={(e) => setFormData({...formData, isbn: e.target.value})}
          />
        </div>
        <button type="submit">Save Book</button>
      </form>
    </div>
  );
}

export default AddBook;