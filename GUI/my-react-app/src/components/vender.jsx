import React, { useState } from 'react';

const Vendor = () => {
  const [eventName, setEventName] = useState('');
  const [ticketPrice, setTicketPrice] = useState('');
  const [ticketQuantity, setTicketQuantity] = useState('');
  const [isLoading, setIsLoading] = useState(false);

  const handleAddTickets = async (e) => {
    e.preventDefault();
    if (!eventName || !ticketPrice || !ticketQuantity) {
      alert('Please fill in all fields');
      return;
    }

    const price = parseFloat(ticketPrice);
    const quantity = parseInt(ticketQuantity);

    if (price <= 0 || quantity <= 0) {
      alert('Price and quantity must be greater than 0');
      return;
    }

    try {
      setIsLoading(true);
      const response = await fetch('http://localhost:8081/api/tickets', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({ eventName, price, tickets: quantity }),
      });

      if (response.ok) {
        alert('Tickets added successfully!');
        setEventName('');
        setTicketPrice('');
        setTicketQuantity('');
        window.scrollTo(0, 0); // Optional: scroll to top after submission
      } else {
        const errorData = await response.json();
        throw new Error(errorData.message || 'Failed to add tickets');
      }
    } catch (error) {
      console.error('Error adding tickets:', error);
      alert('Failed to add tickets. Please try again.');
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="bg-gradient-to-r from-purple-100 to-pink-100 min-h-screen">
      <div className="flex flex-col items-center py-12">
        <h1 className="text-4xl font-bold text-purple-900 mb-8 animate-fade-in">Add Tickets to Event</h1>
        <div className="w-full max-w-lg px-4">
          <form onSubmit={handleAddTickets} className="bg-white shadow-xl rounded-lg p-8 border-2 border-purple-300">
            <div className="mb-6">
              <label htmlFor="eventName" className="block text-lg font-semibold text-purple-700">Event Name</label>
              <input
                id="eventName"
                type="text"
                value={eventName}
                onChange={(e) => setEventName(e.target.value)}
                className="w-full mt-2 p-3 border-2 border-purple-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-purple-500"
                placeholder="Enter event name"
              />
            </div>

            <div className="mb-6">
              <label htmlFor="ticketPrice" className="block text-lg font-semibold text-purple-700">Ticket Price ($)</label>
              <input
                id="ticketPrice"
                type="number"
                value={ticketPrice}
                onChange={(e) => setTicketPrice(e.target.value)}
                className="w-full mt-2 p-3 border-2 border-purple-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-purple-500"
                placeholder="Enter ticket price"
              />
            </div>

            <div className="mb-6">
              <label htmlFor="ticketQuantity" className="block text-lg font-semibold text-purple-700">Ticket Quantity</label>
              <input
                id="ticketQuantity"
                type="number"
                value={ticketQuantity}
                onChange={(e) => setTicketQuantity(e.target.value)}
                className="w-full mt-2 p-3 border-2 border-purple-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-purple-500"
                placeholder="Enter ticket quantity"
              />
            </div>

            <button
              type="submit"
              disabled={isLoading}
              className="w-full bg-gradient-to-r from-purple-600 to-pink-600 text-white font-bold py-3 px-6 rounded-lg shadow-md hover:shadow-lg transform hover:scale-105 transition-all duration-300"
            >
              {isLoading ? 'Adding Tickets...' : 'Add Tickets'}
            </button>
          </form>
        </div>
      </div>
    </div>
  );
};

export default Vendor;
