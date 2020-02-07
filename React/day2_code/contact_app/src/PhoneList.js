import React, {Component} from 'react';
import PhoneItem from './components/PhoneItem';

class PhoneList extends Component {
    shouldComponentUpdate(nextProps, nextState){
        return nextProps.data !== this.props.data; //or false
      }

    render() {
        const {data, onUpdate, onRemove} = this.props;
        // 데이터가 자동으로 할당 되는 걸 호출한다. {}안에 넣으면,

        //<div>관리자 / 111</div>
        //<div>테스트 / 222</div>
        // loop-> data의 값 출력
        const list = data.map(
            value => (
                <PhoneItem key={value.id} 
                info={value} 
                onUpdate={onUpdate}
                onRemove={onRemove} 
                //개별적인 동작을 해야 하니까
                /> 
                //name, id, phone 전달된것을 출력되게끔하기
                //<div key={value.id}>{value.name} / {value.phone}</div>
            )
        );

        return (
            <div> 
                {list}
            </div>
        );
    }
}

export default PhoneList;