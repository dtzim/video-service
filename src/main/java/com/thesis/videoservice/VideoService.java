package com.thesis.videoservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VideoService {

  @Autowired
  private VideoRepository repository;

  List<VideoDTO> getVideos() {
    return repository.findAll();
  }

  Object updateVideo(VideoDTO video) {
    return repository.save(video);
  }
}
