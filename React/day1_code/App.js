import React, { Component } from 'react';
import './App.css';
//import {Fragment} from 'react'
import Counter from './count'

  class App extends Component{
    render() {
      
      return (
          <Counter init="10">
            
          </Counter>  //초기값을 Count component 에 전달
      );
    }
  }

export default App;
