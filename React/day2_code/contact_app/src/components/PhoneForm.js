import React, {Component} from 'react';

class PhoneForm extends Component {
    
    state = {
        name : '',
        phone : ''
    };
    handleChange = (e) => {
        this.setState({ //기존 데이터를 업데이트 하는 것.유일한 방법
            [e.target.name]: e.target.value
        })   
    }
    handleSubmit = (e)=>{
        e.preventDefault();
        this.props.onCreate(this.state);
        this.setState({
            name : '',
            phone : ''
        });//전달 받은 함수 이름 onCreate
        //여기서 사용자가 전달 받은 state 값이 App.js 내 부모클래스로 간다.
    }
    
    render(){
        return (
            <form onSubmit ={this.handleSubmit}>
                <input 
                value = {this.state.name}
                placeholder = '이름을 입력하세요.'
                onChange={this.handleChange}
                name = 'name'
                />  
                <input 
                value = {this.state.phone}
                placeholder = '연락처를 입력하세요.'
                onChange={this.handleChange}
                name = 'phone'
                /> 
                
                <button type="submit">등록</button>               
             </form>
        );
    }
}

export default PhoneForm;