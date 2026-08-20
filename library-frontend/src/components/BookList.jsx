import { useState, useEffect } from 'react';
import { getBooks } from '../services/api';

function BookList() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    loadBooks();
  }, []);

  const loadBooks = async () => {
    try {
      const response = await getBooks();
      setBooks(response.data);
    } catch (err) {
      console.error("Error connecting to Java backend:", err);
    }
  };

  return (
    <div>
      <h3>Library Inventory</h3>
      <table className="data-table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>ISBN</th>
            <th>Status</th>
          </tr>
        </thead>
        <tbody>
          {books.map((book) => (
            <tr key={book.bookId || book.book_id}>
              <td>{book.bookId || book.book_id}</td>
              <td>{book.title}</td>
              <td>{book.author}</td>
              <td>{book.isbn}</td>
              <td>{book.available ? "✅ Available" : "❌ Issued"}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default BookList;