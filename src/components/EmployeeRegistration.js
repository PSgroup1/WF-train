import React, { useState } from 'react';
import '../style/DealerRegistration.css'; // Import external CSS for styling
import AuthenticationService from '../service/AuthenticationService';

const EmployeeRegistration = () => {
  const [dealer, setDealer] = useState({
    email: '',
    name: '',
    password: '',
    dob: '',
    phoneNo: '',
    address: {
      street: '',
      city: '',
      pincode: ''
    }
  });

  const [errors, setErrors] = useState({});
  const [successMessage, setSuccessMessage] = useState('');

  const handleChange = (e) => {
    const { name, value } = e.target;
    if (name.includes('.')) {
      const [parent, child] = name.split('.');
      setDealer((prevDealer) => ({
        ...prevDealer,
        [parent]: {
          ...prevDealer[parent],
          [child]: value
        }
      }));
    } else {
      setDealer((prevDealer) => ({
        ...prevDealer,
        [name]: value
      }));
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const validationErrors = validateForm();
    if (Object.keys(validationErrors).length === 0) {
      try {
        await AuthenticationService.registerDealer(dealer);
        setSuccessMessage('Registration successful!');
        
      } catch (error) {
        console.error('Registration error', error);
        setSuccessMessage('An error occurred during registration.');
      }
    } else {
      setErrors(validationErrors);
    }
  };

  const validateForm = () => {
    let validationErrors = {};

    if (!dealer.email) {
      validationErrors.email = 'Email is required.';
    }

    if (!dealer.fname) {
        validationErrors.fname = 'First name is required.';
    } else if (!/^\d{10}$/.test(dealer.fname)) {
        validationErrors.phoneNo = 'Invalid phone number. Please enter a 10-digit number.';
    }

    if (!dealer.lname) {
        validationErrors.lname = 'Last name is required.';
    }
    // Add more validation rules for other fields
    if (!dealer.password) {
        validationErrors.password = 'Password is required.';
      } else if (dealer.password.length < 6) {
        validationErrors.password = 'Password must be at least 6 characters.';
    }

    if (!dealer.dob) {
    validationErrors.dob = 'Date of Birth is required.';
    } 

    if (!dealer.phoneNo) {
    validationErrors.phoneNo = 'Phone number is required.';
    } else if (!/^[a-zA-Z]$/.test(dealer.phoneNo)) {
    validationErrors.phoneNo = 'Invalid phone number. Please enter a 10-digit number.';
    }
    
    if (!dealer.address.street) {
    validationErrors['address.street'] = 'Street is required.';
    }

    if (!dealer.address.city) {
    validationErrors['address.city'] = 'City is required.';
    }

    if (!dealer.address.pincode) {
    validationErrors['address.pincode'] = 'Pin Code is required.';
    }

    return validationErrors;
  };

  return (
    <div className="registration-container">
      <h2>Employee Registration</h2>
      {successMessage && <p className="success-message">{successMessage}</p>}
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Email:</label>
          <input
            type="email"
            name="email"
            value={dealer.email}
            onChange={handleChange}
            className={errors.email && 'error'}
          />
          {errors.email && <p className="error-message">{errors.email}</p>}
        </div>
        <div className="form-group">
          <label>First Name:</label>
          <input
            type="text"
            name="fname"
            value={dealer.fname}
            onChange={handleChange}
            className={errors.fname && 'error'}
          />
          {errors.fname && <p className="error-message">{errors.fname}</p>}
        </div>
        <div className="form-group">
          <label>Last Name:</label>
          <input
            type="text"
            name="lname"
            value={dealer.lname}
            onChange={handleChange}
            className={errors.lname && 'error'}
          />
          {errors.lname && <p className="error-message">{errors.lname}</p>}
        </div>

        <div className="form-group">
          <label>Password:</label>
          <input
            type="password"
            name="password"
            value={dealer.password}
            onChange={handleChange}
            className={errors.password && 'error'}
          />
          {errors.password && <p className="error-message">{errors.password}</p>}
        </div>

        <div className="form-group">
          <label>Date of Birth:</label>
          <input
          type="date"
          name="dob"
          value={dealer.dob}
          onChange={handleChange}
          className={errors.dob && 'error'}
        />
        {errors.dob && <p className="error-message">{errors.dob}</p>}
      </div>

      <div className="form-group">
          <label>Phone Number:</label>
          <input
            type="text"
            name="phoneNo"
            value={dealer.phoneNo}
            onChange={handleChange}
            className={errors.phoneNo && 'error'}
          />
          {errors.phoneNo && <p className="error-message">{errors.phoneNo}</p>}
        </div>

        {/* Add more form fields with similar structure */}
        <div className="form-group">
          <label>Street:</label>
          <input
            type="text"
            name="address.street"
            value={dealer.address.street}
            onChange={handleChange}
            className={errors['address.street'] && 'error'}
          />
          {errors['address.street'] && <p className="error-message">{errors['address.street']}</p>}
        </div>

        <div className="form-group">
          <label>City:</label>
          <input
            type="text"
            name="address.city"
            value={dealer.address.city}
            onChange={handleChange}
            className={errors['address.city'] && 'error'}
          />
          {errors['address.city'] && <p className="error-message">{errors['address.city']}</p>}
        </div>

        <div className="form-group">
          <label>Pincode:</label>
          <input
            type="text"
            name="address.pincode"
            value={dealer.address.pincode}
            onChange={handleChange}
            className={errors['address.pincode'] && 'error'}
          />
          {errors['address.pincode'] && <p className="error-message">{errors['address.pincode']}</p>}
        </div>

        <div className="form-group">
          <button type="submit" className="submit-button">
            Register
          </button>
        </div>
      </form>
    </div>
  );
};

export default DealerRegistration;
