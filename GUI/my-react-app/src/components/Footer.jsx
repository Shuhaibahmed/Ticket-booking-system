import React from 'react';
import { Link } from 'react-router-dom';

const Footer = () => {
  return (
    <footer className="bg-gradient-to-r from-blue-950 to-purple-900 text-white py-8">
      <div className="container mx-auto text-center">
        <div className="mb-6">
          <Link to="/" className="inline-block">
            <h3 className="text-2xl font-bold mb-2 hover:text-purple-300 transition duration-300">Event Pro</h3>
          </Link>
          <p className="text-gray-300">&copy; {new Date().getFullYear()} All rights reserved.</p>
        </div>
        <div className="flex justify-center space-x-6">
          <Link to="/about" className="text-white hover:text-purple-300 transition duration-300 ease-in-out transform hover:scale-110">
            About Us
          </Link>
          <Link to="/contact" className="text-white hover:text-purple-300 transition duration-300 ease-in-out transform hover:scale-110">
            Contact
          </Link>
          <Link to="/privacy" className="text-white hover:text-purple-300 transition duration-300 ease-in-out transform hover:scale-110">
            Privacy Policy
          </Link>
        </div>
        <div className="mt-6 text-sm text-gray-400">
          <p>Making your events extraordinary</p>
        </div>
      </div>
    </footer>
  );
};

export default Footer;
