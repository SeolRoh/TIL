import React, {component, Component} from 'react';

class Myintro extends Component{
    render(){
        const css ={
            color : 'red' ,
            fontSize : '40px'
        };
        return(
            <div>
            <div style={css}> 안녕하세요, 제 이름은 <b>{this.props.card.name}</b></div>
            <div style={css}> 안녕하세요, 제 이메일은 <b>{this.props.card.email}</b></div>
            <div style={css}> 안녕하세요, 제 번호는 <b>{this.props.card.phone}</b></div>
            </div>
        );
    }
}

export default Myintro;