import React from 'react';


const Search = ({location}) => { //match라는 객체
return (
    <div>
        Search keyword : {new URLSearchParams(location.search).get("keyword")}
    </div>
  );
};

export default Search;