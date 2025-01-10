import React, { useState, useEffect } from 'react';

const Customer = () => {
  const [events, setEvents] = useState([]);

  // Fetch events from the backend API on component mount
  useEffect(() => {
    const fetchEvents = async () => {
      try {
        const response = await fetch('http://localhost:8081/api/tickets');
        if (response.ok) {
          const data = await response.json();
          setEvents(data);
        } else {
          throw new Error('Failed to fetch events');
        }
      } catch (error) {
        console.error('Error fetching events:', error);
        alert('Failed to load events. Please try again.');
      }
    };

    fetchEvents();
  }, []); // Empty dependency array ensures the fetch only happens once when the component mounts

  const handleBuyTicket = (id) => {
    setEvents(events.map(event => {
      if (event.id === id && event.tickets > 0) {
        return { ...event, tickets: event.tickets - 1 };
      }
      return event;
    }));
    alert('Ticket purchased successfully!');
  };

  return (
    <div className="bg-gradient-to-r from-purple-100 to-pink-100 min-h-screen">
      <div className="flex flex-col items-center py-12">
        <h1 className="text-4xl font-bold text-purple-900 mb-8 animate-fade-in">Available Events</h1>
        <div className="w-full max-w-4xl px-4">
          {events.map((event) => (
            <div
              key={event.id}
              className="bg-white shadow-xl rounded-lg mb-8 p-8 border-2 border-purple-300 hover:border-purple-500 transform hover:-translate-y-1 transition-all duration-300"
            >
              <div className="flex items-center justify-between">
                <div>
                  <h2 className="text-3xl font-bold text-purple-800 mb-2">
                    {event.image} {event.eventName}
                  </h2>
                  <p className="text-lg text-purple-600 font-semibold mb-2">
                    Price: ${event.price.toFixed(2)}
                  </p>
                  <p className="text-md text-purple-500">
                    Available Tickets: {event.tickets}
                  </p>
                </div>
                <button
                  onClick={() => handleBuyTicket(event.id)}
                  disabled={event.tickets === 0}
                  className={`bg-gradient-to-r from-purple-600 to-pink-600 
                    ${event.tickets > 0 ? 'hover:from-purple-700 hover:to-pink-700' : 'opacity-50 cursor-not-allowed'} 
                    text-white font-bold py-3 px-6 rounded-lg shadow-md hover:shadow-lg 
                    transform hover:scale-105 transition-all duration-300`}
                >
                  {event.tickets > 0 ? 'Buy Ticket' : 'Sold Out'}
                </button>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default Customer;
