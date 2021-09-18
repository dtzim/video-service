package com.thesis.videoservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class VideoService {

  private static final String COL_NAME = "users";

  List<VideoDTO> getVideos() throws InterruptedException, ExecutionException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<QuerySnapshot> future = dbFirestore.collection(COL_NAME).get();

    List<VideoDTO> videos = new ArrayList<>();
    List<QueryDocumentSnapshot> documents = future.get().getDocuments();

    for (QueryDocumentSnapshot document : documents) {
      if (document.exists()) {
        VideoDTO videoDTO = document.toObject(VideoDTO.class);
        videoDTO.setId(document.getId());
        videos.add(videoDTO);
      }
    }
    return videos;
  }

  String updateVideo(String id, VideoDTO video)
      throws JsonProcessingException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    dbFirestore.collection(COL_NAME)
        .document(id).set(video);
    return new ObjectMapper().writeValueAsString(Map.of("Message:", "Video updated!"));
  }
}
