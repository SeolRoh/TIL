import React, { Component } from 'react';

const Myintro2 = function({card}) => {
    return {
        <div>
            <div style={css}> 안녕하세요 제 이름은 <b>
            {card.name}, 
            {card.email}, 
            {card.phone} </b>  입니다.
            </div>
        </div>
    }
}

export default Myintro2;