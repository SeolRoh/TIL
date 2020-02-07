import React from 'react';
import { BrowserRouter as Router, Route} from 'react-router-dom';
import Header from './components/header';
import Page1 from './routes/page1';
import Page2 from './routes/page2';
import Page3 from './routes/page3';

 

const Appcopy = () => {
  return (
        <Router>
          <Header />
            <Route path= "/my_note1" component={Page1} />
            <Route path = "/my_note2" component={Page2} />
            <Route path = "/my_note3" component={Page3} />
        </Router>
  );
}

export default Appcopy;
