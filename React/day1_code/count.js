import React, {Component} from 'react';

const ErrorObject = () => {
    throw (new Error('에러 발생'));
}

class Counter extends Component{

    state = {
        count : 0,
        number: 0,
        error:false,
        info: {
            name : 'seol',
            age: 10
        }
    }

    componentDidCatch(error, info){
        this.setState({
            error : true
        }) ;
    }

    constructor(props){
        super(props);
        console.log(this.props.init);
        //this.state.count = this.props.init; //Number()를 써서 변경하거나 숫자를 이용해 변경하면 된다.
        console.log('call constructor');
    }

    componentDidMount(){
        console.log('componentDidMount');

    }

    shouldComponentUpdate(nextProps, nextstate) {
        console.log('shouldComponentUpdate');
        if(nextstate.count % 5 === 0) return false; // 화면 갱신 - 불필요한 데이터는 보여주지 않겠다.
        return true;
    }

    componentWillUpdate(nextProps, nextstate) {
        console.log('componentWillUpdate');
    }

    componentDidUpdate(prevProps, prevState) {
        console.log('componentDidUpdate');
    }

    handleIncrease = () => {
        //console.log('+');
        this.setState({
            count: this.state.count +1
        });
    }

    handleChangeInfo = () => {
        //1. this.state.info의 name을 변경
        // this.setState({
        //    info: {
        //         name: 'dowon',
        //         age: 20
        //     }
        // });
        //2. this.atate.info의 name을 변경(전개연산자)
            this.setState({
                info: {
                    ...this.state.info,
                    name: 'LeeDowon'

                }
            });
    }

    handleDecrease = () => {
        //console.log('-');
        this.setState({
            count: this.state.count -1
        });
    }

    render() {
        if(this.state.error) return( <h1>에러가 발생되었습니다.</h1>);
      
        return (
            <div>
                <h1>Counter</h1>
                <h2>{this.state.count}</h2>

                {
                    this.state.count == 3 && <ErrorObject />
                }

                <button onClick={this.handleIncrease}>+</button>
                <button onClick={this.handleDecrease}>-</button>
                <button onClick={this.handleChangeInfo}>Change Info name</button>

                {this.state.info.name}/{this.state.info.age}
            </div>
            );
        }
    }

export default Counter;