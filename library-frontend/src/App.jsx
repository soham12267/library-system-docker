import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Navbar from './components/Navbar';
import BookList from './components/BookList';
import AddBook from './components/AddBook';
import MemberList from './components/MemberList';
import AddMember from './components/AddMember';
import IssueBook from './components/IssueBook';
import './index.css';

function App() {
  return (
    <Router>
      <div className="app-container">
        <Navbar />
        <main className="content">
          <Routes>
            <Route path="/" element={<BookList />} />
            <Route path="/add-book" element={<AddBook />} />
            <Route path="/members" element={<MemberList />} />
            <Route path="/add-member" element={<AddMember />} />
            <Route path="/issue" element={<IssueBook />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;