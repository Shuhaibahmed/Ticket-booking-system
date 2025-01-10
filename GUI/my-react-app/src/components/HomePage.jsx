import React from 'react';
import { Link } from 'react-router-dom';

const HomePage = () => {
  return (
    <div className="bg-gradient-to-r from-purple-100 to-pink-100 min-h-screen">
      {/* Hero Section */}
      <header className="bg-gradient-to-r from-blue-950 to-purple-900 text-white py-10">
        <div className="container mx-auto text-center px-4">
          <h1 className="text-5xl font-bold mb-6 animate-fade-in">Welcome to Event Pro</h1>
          <p className="text-xl mb-8">
            Your ultimate platform to organize, manage, and attend events effortlessly.
          </p>
          <Link to="/vender">
            <button className="bg-white text-purple-900 font-bold py-3 px-8 rounded-lg shadow-lg 
              hover:text-purple-300 transform hover:scale-105 transition-all duration-300 mr-4">
              Create Event
            </button>
          </Link>
          <Link to="/customer">
            <button className="bg-transparent border-2 border-white text-white font-bold py-3 px-8 
              rounded-lg shadow-lg hover:text-purple-300
              transform hover:scale-105 transition-all duration-300">
              Browse Events
            </button>
          </Link>
        </div>
      </header>

      {/* Features Section */}
      <section className="py-16">
        <div className="container mx-auto text-center px-4">
          <h2 className="text-4xl font-bold text-purple-900 mb-12">Why Choose Event Pro?</h2>
          <div className="grid grid-cols-1 md:grid-cols-3 gap-8">
            <div className="bg-white p-8 rounded-lg shadow-xl hover:shadow-2xl transition-shadow duration-300">
              <div className="text-4xl mb-4">🎯</div>
              <h3 className="text-2xl font-bold mb-4 text-blue-950">Easy Event Setup</h3>
              <p className="text-gray-600">Create and manage events with just a few clicks. Our intuitive interface makes event planning a breeze.</p>
            </div>
            <div className="bg-white p-8 rounded-lg shadow-xl hover:shadow-2xl transition-shadow duration-300">
              <div className="text-4xl mb-4">🎟️</div>
              <h3 className="text-2xl font-bold mb-4 text-blue-950">Seamless Ticketing</h3>
              <p className="text-gray-600">Handle ticket sales effortlessly with our secure and reliable ticketing system.</p>
            </div>
            <div className="bg-white p-8 rounded-lg shadow-xl hover:shadow-2xl transition-shadow duration-300">
              <div className="text-4xl mb-4">🤝</div>
              <h3 className="text-2xl font-bold mb-4 text-blue-950">Customer Engagement</h3>
              <p className="text-gray-600">Build lasting connections with your audience through our engagement tools.</p>
            </div>
          </div>
        </div>
      </section>

      {/* Call to Action Section */}
      <section className="bg-gradient-to-r from-blue-950 to-purple-900 text-white py-10">
        <div className="container mx-auto text-center px-4">
          <h2 className="text-3xl font-bold mb-6">Ready to Get Started?</h2>
          <p className="text-xl mb-8">Join thousands of users who trust Event Pro for their events.</p>
          <Link to="/customer">
            <button className="bg-white text-purple-900 font-bold py-3 px-8 rounded-lg shadow-lg hover:text-purple-300 transform hover:scale-105 transition-all duration-300">
              Explore Events
            </button>
          </Link>
        </div>
      </section>
      <img src="./src/assets/logo.png" alt="Event Pro Logo" className="hidden" />
    </div>
  );
};

export default HomePage;
