const API_BASE_URL = "http://localhost:8081/api/tickets";

export const getTickets = async () => {
  try {
    const response = await fetch(API_BASE_URL);
    if (!response.ok) throw new Error("Failed to fetch tickets");
    return await response.json();
  } catch (error) {
    console.error(error);
    throw error; // Re-throw the error for further handling
  }
};

export const addTicket = async (ticket) => {
  try {
    const response = await fetch(API_BASE_URL, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(ticket),
    });
    if (!response.ok) throw new Error("Failed to add ticket");
    return await response.json();
  } catch (error) {
    console.error(error);
    throw error; // Re-throw the error for further handling
  }
};

export const deleteTicket = async (id) => {
  try {
    const response = await fetch(`${API_BASE_URL}/${id}`, {
      method: "DELETE",
    });
    if (!response.ok) throw new Error("Failed to delete ticket");
  } catch (error) {
    console.error(error);
    throw error; // Re-throw the error for further handling
  }
};
