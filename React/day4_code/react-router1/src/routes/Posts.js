import React from 'react';
import {Link, Route } from 'react-router-dom';

const Post = ({match}) => {
    return (
        <div>
            <h2>{match.params.title}</h2>
        </div>
    );
}

const Posts = () => { //match라는 객체
return (
    <div>
        <h2>Posts</h2>
        <li><Link to="/posts/java">Java Programming</Link></li>
        <li><Link to="/posts/react">React Programming</Link></li>
        <li><Link to="/posts/js">Java Script</Link></li>
        <li><Link to="/posts/max">Microservice Architecture</Link></li>

        <Route path="/posts/:title" component={Post} />
    </div>
  );
};

export default Posts;