import React, {Component}from 'react';
import { render } from 'react-dom';

class SearchBar extends Component {
    constructor(props){
        super(props); //부모의 생성자 함수 부모클래스를 호출 할 때 (Component)

        this.state={ //생성자가 있기 때문에 super클래스 다음에 생성한다.
            term: ''
        }
    }
    onInputchange = (event) => {
        this.setState({
            term: event.target.value
        });

        this.props.onsearchTermChange(event.target.value);
    }
    // onInputchange = (term) => {
    //     let {term} = this.state
    //     //console.log(event.target);
    //     this.setState ({
    //         term: event.target.value
    //     });
       //console.log(this.setState.term); //입력되어진 값
    //}

    render(){
        return (
            <div className="search-bar" >
                <input onChange={this.onInputchange} />
                <button buttonName="search">검색</button>        
            </div>
        )
    }
}

export default SearchBar;