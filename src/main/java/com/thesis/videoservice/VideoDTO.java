package com.thesis.videoservice;

import java.util.List;

import javax.persistence.Id;

public class VideoDTO {

  @Id
  private String id;
  private String videoLink;
  private String imageLink;
  private String description;
  private String title;
  private String level;
  private String type;
  private List<String> pose;
  private boolean isFavorite;

  public VideoDTO(){}

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getVideoLink() {
    return videoLink;
  }
  public void setVideoLink(String videoLink) {
    this.videoLink = videoLink;
  }

  public String getImageLink() {
    return imageLink;
  }
  public void setImageLink(String imageLink) {
    this.imageLink = imageLink;
  }

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  public String getLevel() { return level; }
  public void setLevel(String level) {
    this.level = level;
  }

  public String getType() { return type; }
  public void setType(String type) {
    this.type = type;
  }

  public List<String> getPose() {
    return pose;
  }
  public void setPose(List<String> pose) { this.pose = pose; }

  public boolean isFavorite() {
    return isFavorite;
  }
  public void setFavorite(boolean favorite) { isFavorite = favorite; }

  @Override
  public String toString() {
    return "VideoDTO{" +
        "id='" + id + '\'' +
        ", videoLink='" + videoLink + '\'' +
        ", imageLink='" + imageLink + '\'' +
        ", description='" + description + '\'' +
        ", title='" + title + '\'' +
        ", level=" + level +
        ", type='" + type + '\'' +
        ", pose=" + pose +
        ", isFavorite=" + isFavorite +
        '}';
  }
}
