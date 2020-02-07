import React, {Component} from 'react';

class PhoneItem extends Component {
    state = {
        editable: false,
        name: '',
        phone: ''
    }

    static defaultProps ={
        info:{
            id: '',
            name: '이름',
            phone: '010-0000-0000'
        }
    }
    componentDidUpdate(preProps,prevState){ //124p,138p 라이프사이클에 관련된 함수. 화면이 바뀔때 마다 호출
        const {info, onUpdate } = this.props;
        //console.log(info.name+"/"+info.phone);
//        console.log(onUpdate);
        console.log(prevState.editable + "/" + this.state.editable);
        if(!prevState.editable && this.state.editable){
            this.setState(
                {
                    name: info.name,
                    phone: info.phone
                }
            )
        }

        //update
        if(prevState.editable && !this.state.editable){
            onUpdate(info.id, {
                name: this.state.name,
                phone: this.state.phone
            });
        }
    }

    handleRemove = () => {
        const {info, onRemove} = this.props;
        onRemove(info.id);
    }
    handleUpdate = () => {
        const{ editable /*, name, phone*/ } = this.state;
        // const {info, onUpdate} = this.props;
        // onUpdate(info.id);
        this.setState({
            editable: !editable // 전환시키고자 사용하는 간단한 방법 !true, !false 바뀜
        });
    }
    handleChange = (e) => {
        const {name, value} = e.target;
        this.setState({
            [name]: value
        });
    }

    render() {
        const css ={
            color: '',
            background : '',
            border: '1px solid black',
            padding: '9px', //div태그안에 홍길동이라는 컨텐츠가 있는데 이게 얼마나 보이는지 크기
            margin: '5px' // 마진은 어느정도 간격이 떨어지나
        };

        const {editable} = this.state;
        if(editable){
            return (
                <div style={css}>
                    <div>
                        <input value={this.state.name="name"} 
                        placeholder="이름을 입력하세요"
                        onChange={this.handleChange}
                        />
                    </div>
                    <div>
                        <input value={this.state.phone="phone"}
                        placeholder="번호를 입력하세요"
                        onChange={this.handleChange}
                        />
                    </div>
                    <button onClick={this.handleRemove} >삭제</button>
                    <button onClick={this.handleUpdate} >적용</button>
                </div>
            );

        } else {
            console.log('일반모드');
        }

        const info = this.props.info;

        const{name,phone,id} = this.props.info; //전달받은 데이타

        console.log(id);
        console.log(name);
        console.log(phone);
        return(
            <div style={css} className=''>
                <div><b>{name}</b></div>
                <div>{phone}</div>
                <button name='update' onClick = {this.handleUpdate}>수정</button>
                <button name='remove' onClick = {this.handleRemove}>삭제</button>
            </div>  
        );
    };
}

export default PhoneItem;