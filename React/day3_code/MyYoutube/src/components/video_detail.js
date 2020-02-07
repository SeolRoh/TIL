import React from 'react';
import SearchBar from './search_bar';

const VideoDetail = ({video}) => { //root component = parent
   // parent this.props.video
   //const video = props.video;

   if(!video){
       return <div>Loading...</div>
   }
   const videoId =video.id.videoId; //이건 왜 필요없는지 알아보기

   //const url = 'https://www.youtube.com/embed/' + videoId ;
   const url = `https://www.youtube.com/embed/${videoId}`;
    return (
        <div className="video-detail col-md-8">
            <div className="embed-responsive embed-responsive-16by9">
                <iframe className="embed-responsive-item" src={url} />
            </div>
            <div className="details">
                <div>{video.snippet.title}</div>
                <div>{video.snippet.description}</div>
            </div>
            Video player
        </div>
    )
}

export default VideoDetail;