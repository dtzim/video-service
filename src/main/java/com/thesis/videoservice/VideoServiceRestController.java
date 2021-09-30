package com.thesis.videoservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class VideoServiceRestController {

  @Autowired
  VideoService videoService;

  @CrossOrigin
  @GetMapping("/videos")
  public List<VideoDTO> geVideos() {
    return videoService.getVideos();
  }

  @CrossOrigin
  @PutMapping("/videos")
  public Object setVideo(@RequestBody VideoDTO videoDTO)
      throws JsonProcessingException {
    return videoService.updateVideo(videoDTO);
  }
}
