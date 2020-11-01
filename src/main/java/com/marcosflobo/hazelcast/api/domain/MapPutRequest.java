package com.marcosflobo.hazelcast.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MapPutRequest {

  @JsonProperty("map-name")
  private String mapName;
  @JsonProperty("key")
  private String key;
  @JsonProperty("value")
  private String value;

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

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  @Override
  public String toString() {
    return "MapPutRequest{" +
        "key='" + key + '\'' +
        ", value='" + value + '\'' +
        '}';
  }
}
