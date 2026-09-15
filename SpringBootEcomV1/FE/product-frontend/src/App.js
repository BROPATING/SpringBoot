import './App.css';
import React, { useEffect, useState } from "react";
import axios from 'axios';

function App() {
  const [list, setList] = useState([]);
  const [formData, setFormData] = useState({
    id: "",
    name: "",
    price: "",
    available: "",
    quantity: ""
  })
  
  // Fetch the List of Products
  useEffect(() => {
    axios.get("http://localhost:8080/api/v1/prod")
        .then(response => {
            setList(response.data);
        })
        .catch(error => console.error("Error fetching products:", error));
  }, []);

  // Handle input changes dynamically
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };
  
  const addProd = () => {
    axios.post("http://localhost:8080/api/v1/prod/addProd", {
      ...formData,
      price: parseFloat(formData.price) || 0.00,
      quantity: parseFloat(formData.quantity) || 0.00
    })
        .then(res => {
              alert("Product Added Successfully");
              setList(prev => [...prev, res.data]);
              // Clear the input fields after successful submission
              setFormData({ id: "", name: "", brand: "", price: "", quantity: "" });
        })
        .catch(err => console.error("Error: "+err));
  }
  
  return (
      <div style={{ padding: "20px" }}>
        <h1>E-Commerce Products</h1>

        {/* Input Form Section */}
        <div style={{ marginBottom: "20px", display: "flex", gap: "10px", flexWrap: "wrap" }}>
          <input
              type="text"
              name="id"
              placeholder="Product ID (e.g. P105)"
              value={formData.id}
              onChange={handleChange}
          />
          <input
              type="text"
              name="name"
              placeholder="Product Name"
              value={formData.name}
              onChange={handleChange}
          />
          <input
              type="text"
              name="available"
              placeholder="Available"
              value={formData.available}
              onChange={handleChange}
          />
          <input
              type="number"
              name="price"
              placeholder="Price"
              value={formData.price}
              onChange={handleChange}
          />
          <input
              type="number"
              name="quantity"
              placeholder="Quantity"
              value={formData.quantity}
              onChange={handleChange}
          />
          <button onClick={addProd}>
            Add Product
          </button>
        </div>

        {/* Product List */}
        <ul>
          {list.map(product => (
              <li key={product.id}>
                <strong>{product.name}</strong> ({product.available}) - ${product.price} [Qty: {product.quantity}]
              </li>
          ))}
        </ul>
      </div>
  );
}

export default App;
