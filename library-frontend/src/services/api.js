import axios from 'axios';

const API = axios.create({
    baseURL: 'http://localhost:8080/api', // Matches your Spring Boot port
});

export const getBooks = () => API.get('/books');
export const addBook = (bookData) => API.post('/books', bookData);
export const getMembers = () => API.get('/members');
export const addMember = (memberData) => API.post('/members', memberData);
export const issueBook = (transactionData) => API.post('/transactions/issue', transactionData);