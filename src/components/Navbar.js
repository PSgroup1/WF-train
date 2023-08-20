import React from 'react'
import '../style/NavBar.css'

import {Link} from  'react-router-dom';

const NavBar = () =>{
    return(
        <nav className='navbar'>
            <ul className='nav-list'>
                <li className='nav-item'>
                    <Link to="/" className="nav-link">Home</Link>
                </li>

                <li className='nav-item'>
                    <Link to="/register" className="nav-link">Register</Link>
                </li>

                <li className='nav-item'>
                    <Link to="/login" className="nav-link">Login</Link>
                </li>

                <li className='nav-item'>
                    <Link to="/products" className="nav-link">Products</Link>
                </li>

            </ul>
        </nav>
    )
}

export default NavBar;