import React, { Component } from 'react';
import ReactDOM from 'react-dom';
import SearchBar from './components/search_bar';
import YTSearch from 'youtube-api-search';
import _ from 'lodash';
import VideoList from './components/video_list';
import VideoDetail from './components/video_detail';

const API_KEY = 'AIzaSyAofSZVZowQPVQ3Q7QXP5RGTqPiW3vuGmw';


class App extends Component{
  constructor(props){
    super(props); //부모의 생성자 함수 부모클래스를 호출 할 때 (Component)
  
    this.state={ //생성자가 있기 때문에 super클래스 다음에 생성하낟.
      videos: [],
      selectedVideo: null
    }
    this.vidioSearch('surfboards');
  }

  vidioSearch(term){
    YTSearch({key: API_KEY, term:term}, (data) => { // term에 검색하고싶은 단어 넣기
      //  console.log(data);
        this.setState({
          videos: data,
          selectedVideo: data[0]  
        });  
    });
  }

  handleselect = (selectedVideo) => {
    console.log(selectedVideo);
    this.setState({
      selectedVideo: selectedVideo
    });
  }

  render(){
    const _videoSearch = _.debounce(term => {this.videoSearch(term)},300); //0.3sec
    return (
      <div>0
        <SearchBar onSearchTermChange = {_videoSearch} />
        <VideoDetail video = {this.state.selectedVideo}/>
        <VideoList onVideoSelect= {this.handleselect} videos= {this.state.videos} />
      </div>
    );
  }
}



ReactDOM.render(<App />, document.querySelector('.container'));