import React from 'react';
import { Link } from 'react-router-dom'; // Use Link for navigation

const Navbar = () => {
  return (
    <nav className="bg-gradient-to-r from-blue-950 to-purple-900 p-5 shadow-lg">
      <div className="container mx-auto flex justify-between items-center">
        <Link to="/" className="text-white text-3xl font-bold hover:text-purple-300 transition duration-300">
          <img src="./src/assets/logo-modified.png" alt="Logo" className="inline-block h-10 mr-2" />
          EVENT PRO
        </Link>
        <ul className="flex space-x-8">
          <li>
            <Link 
              to="/" 
              className="text-white hover:text-purple-300 transition duration-300 ease-in-out transform hover:scale-110 text-lg font-semibold"
            >
              Home
            </Link>
          </li>
          <li>
            <Link 
              to="/vender" 
              className="text-white hover:text-purple-300 transition duration-300 ease-in-out transform hover:scale-110 text-lg font-semibold"
            >
              Vendor
            </Link>
          </li>
          <li>
            <Link 
              to="/customer" 
              className="text-white hover:text-purple-300 transition duration-300 ease-in-out transform hover:scale-110 text-lg font-semibold"
            >
              Customer
            </Link>
          </li>
        </ul>
      </div>
    </nav>
  );
};

export default Navbar;
