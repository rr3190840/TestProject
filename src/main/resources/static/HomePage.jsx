import React, { useState, useEffect } from 'react';
import axios from 'axios';

const App = () => {
  const [phoneNumber, setPhoneNumber] = useState('');
  const [otp, setOTP] = useState('');
  const [token, setToken] = useState('');
  const [profile, setProfile] = useState('');

  // Function to send OTP
  const sendOTP = async () => {
    try {
      const response = await axios.post('/api/send_otp', { phone: phoneNumber });
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  // Function to validate OTP
  const validateOTP = async () => {
    try {
      const response = await axios.post(`/api/validate_otp?phone=${phoneNumber}&otp=${otp}`);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  // Function to authenticate user and obtain JWT token
  const authenticate = async () => {
    try {
      const response = await axios.post('/api/authenticate', { username: 'your_username', password: 'your_password' });
      setToken(response.data.token);
    } catch (error) {
      console.error(error);
    }
  };

  // Function to retrieve user profile
  const getUserProfile = async () => {
    try {
      const response = await axios.get('/api/profile', {
        headers: { Authorization: `Bearer ${token}` },
      });
      setProfile(response.data);
    } catch (error) {
      console.error(error);
    }
  };

  // Call getUserProfile when token changes
  useEffect(() => {
    if (token) {
      getUserProfile();
    }
  }, [token]);

  return (
    <div>
      <h2>OTP Test</h2>
      <div>
        <label>Phone Number:</label>
        <input type="text" value={phoneNumber} onChange={(e) => setPhoneNumber(e.target.value)} />
        <button onClick={sendOTP}>Send OTP</button>
      </div>
      <div>
        <label>OTP:</label>
        <input type="text" value={otp} onChange={(e) => setOTP(e.target.value)} />
        <button onClick={validateOTP}>Validate OTP</button>
      </div>
      <div>
        <button onClick={authenticate}>Authenticate</button>
      </div>
      {token && (
        <div>
          <h2>User Profile</h2>
          <p>{profile}</p>
        </div>
      )}
    </div>
  );
};

export default App;
