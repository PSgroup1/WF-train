
import './App.css';
import  {BrowserRouter as Router,Routes,Route} from 'react-router-dom';

import Home from './components/Home';
// import Register from './components/DealerRegistration';
import Login from './components/Login';
import NavBar from './components/Navbar';
import DealerRegistration from './components/EmployeeRegistration';

/*
	React Router is a standard library for routing in React. 
	It enables the navigation among views of various components in a React Application, allows changing the browser URL, 
	and keeps the UI in sync with the URL. 
	React Router is a JavaScript framework that lets us handle client and server-side routing in React applications. 
	It enables the creation of single-page web or mobile apps that allow navigating without refreshing the page. 
	It also allows us to use browser history features while preserving the right application view.

*/

function App() {
  return (
    <div className="App">
      <header className="App-header">
        
        <h1>loanEzz</h1>

      </header>
      <section>
      <div style={{ backgroundImage: "url(/images/loanezz.jpg)",
                    backgroundRepeat: 'no-repeat',
                    backgroundSize:'cover', minHeight:'100vh',minWidth:'100vw'}}>
          <Router>
            <NavBar></NavBar>
            <Routes>
              <Route path='/' exact Component={Home}></Route>
              <Route path='/register'  Component={DealerRegistration}></Route>.
              <Route path='/login'  Component={Login}></Route>

            </Routes>
          </Router>

        </div>
      </section>
      <footer className='footer'>
        <p>&copy;All rights reserved to wells Fargo</p>
        </footer>
    </div>
  );
}

export default App;
