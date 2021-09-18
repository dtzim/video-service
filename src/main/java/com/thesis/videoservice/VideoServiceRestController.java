package com.thesis.videoservice;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
  public List<VideoDTO> geVideos() throws InterruptedException, ExecutionException {
    return videoService.getVideos();
  }

  @CrossOrigin
  @PutMapping("/videos/{id}")
  public String setVideo(@PathVariable("id") String id, @RequestBody VideoDTO videoDTO)
      throws JsonProcessingException {
    return videoService.updateVideo(id, videoDTO);
  }
}
