package com.marcosflobo.hazelcast.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MapGetRequest {

  @JsonProperty("map-name")
  private String mapName;
  @JsonProperty("key")
  private String key;

  public String getMapName() {
    return mapName;
  }

  public void setMapName(String mapName) {
    this.mapName = mapName;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }
}
