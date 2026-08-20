import { Link } from 'react-router-dom';

function Navbar() {
  return (
    <nav className="navbar">
      <h2>Library System</h2>
      <div className="links">
        <Link to="/">Books</Link>
        <Link to="/members">Members</Link>
        <Link to="/add-book">+ Book</Link>
        <Link to="/add-member">+ Member</Link>
        <Link to="/issue">Issue Book</Link>
      </div>
    </nav>
  );
}

export default Navbar;