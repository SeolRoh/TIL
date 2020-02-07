import React from 'react';
import { BrowserRouter as Router, Route, Switch} from 'react-router-dom'; // 라우트는 라우터 안에들어가는 세부요소
import About from './routes/About';
import Home from './routes/Home';
import Posts from './routes/Posts';
import Login from './routes/Login';
import Header from './components/header';
import MyProfile from './routes/MyProfile';
import Search from './routes/Search';
import NotFound from './routes/NotFound';
 

const App = () => {
  return (
        <Router>
          <Header />
          <Switch>
            <Route exact path="/" component={Home} />
            <Route path="/about" component={About} />
            <Route path="/posts" component={Posts} />
            <Route path="/search" component={Search} />
            <Route path="/MyProfile" component={MyProfile} />
            <Route path="/login" component={Login} />
            <Route component={NotFound} />
          </Switch>
        </Router>
  );
};

export default App;
