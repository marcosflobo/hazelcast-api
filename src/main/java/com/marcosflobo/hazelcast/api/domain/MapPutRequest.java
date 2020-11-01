package com.marcosflobo.hazelcast.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MapPutRequest {

  @JsonProperty("key")
  private String key;
  @JsonProperty("value")
  private String value;

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
