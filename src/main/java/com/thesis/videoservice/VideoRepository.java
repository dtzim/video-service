package com.thesis.videoservice;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface VideoRepository extends MongoRepository<VideoDTO, String> {

}
