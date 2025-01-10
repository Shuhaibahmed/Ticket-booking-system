import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import HomePage from './components/HomePage';
import Navbar from './components/Navbar';
import Vendor from './components/vender';
import Footer from './components/Footer';
import Customer from './components/Customer'; 

const App = () => {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/vender" element={<Vendor />} />
        <Route path="/customer" element={<Customer />} /> 
      </Routes>
      <Footer />
    </BrowserRouter>
  );
};

export default App;
