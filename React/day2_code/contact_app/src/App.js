import React, {Component} from 'react';
import './App.css';
import PhoneForm from './components/PhoneForm.js';
import PhoneList from './PhoneList';


class App extends Component {
  id = 1;
  state = {
      contacts: [// 여기가 초기데이터, 이 값을 가지고 시작한다.
          {
              id : 0,
              name : '관리자',
              phone : '010-1111-1111'
          }
      ],
      keyword : ''
  };

  handleChange =(e)=> {
    const {contact} =this.state
    
    this.getSnapshotBeforeUpdate({
      keyword: e.target.value
    });
  }

  handleCreate = (data) => {
    const {contacts} = this.state;

    this.setState({
      contacts: contacts.concat({id: this.id++,...data})
    })
  }

  handleUpdate = (selected_id, data) => {
    console.log('App handleUpdate=' +selected_id);
    const {contacts} = this.state;

    console.log("selected_id=" + selected_id);
    this.setState({
      contacts: contacts.map(
        item => item.id === selected_id 
        ? ({...item, ...data }) 
        : item //기존 데이터들 변경 없음 -> 전개연산자 사용하기
      )
    });
      
      console.log(this.state.contact);
    }

  handleRemove = (selected_id) => {
    console.log('App handleRemove=' +selected_id);
    const {contacts} = this.state;

    this.setState({
        contacts: contacts.filter(
            // contact 하나만 적용하면 가지고 있는 contacts 내용 모두 적용된다.
            info => info.id !== selected_id 
        ) 
    });
    
      console.log(this.state.contact);
    }

   

  render() {
    const {contacts,keyword} = this.state;
    //전체 목록 -> contacts
    //검색할 키워드 -> keyword
    //contacts에서 keyword인 데이터만 검색해서 전달 (list에
    //contacts.map or contacts.filter 
    //contacts.filter(v=> (조건) ? true : false)
    const filteredContacts = contacts.filter(v => v.name.indexOf(keyword) !== -1);

    return (
      <div className="App-header">
        <PhoneForm onCreate={this.handleCreate} 
        />
        <p>
          <input placeholder="검색 할 이름을 입력하세요"
          onChange={this.handleChange}
          value={this.state.keyword}
          />
        </p>
        {JSON.stringify(contacts)}
        <PhoneList data={this.state.contacts} 
        onUpdate = {this.handleUpdate} 
        onRemove = {this.handleRemove} 
        />
      </div>
    );
  }
}

export default App;
