import React, {Component}from 'react';
import { render } from 'react-dom';
import VideoListItem from './video_list_item';

const VideoList = (props) => {
    const videoItems =props.videos.map(v => {
        return (
            <VideoListItem onVideoSelect={props.onVideoSelect} key={v.etag} video={v}/>
        ) //onVideoSelect를 사용해서 넘기는 부분
    });

    return(
        <ul className="col-md-4 list-group">
            {videoItems}
        </ul>
    );
}

export default VideoList;