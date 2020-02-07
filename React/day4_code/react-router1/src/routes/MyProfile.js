import React from 'react';
import { Redirect } from 'react-router-dom';

const isLogged = false; //false는 로그인이 안되었을 경우

const MyProfile = () => { //match라는 객체
return (
    <div>
        {
            !isLogged && <Redirect to ="/login"/>

        }
        MyProfile
    </div>
  );
};

export default MyProfile;