package com.marcosflobo.hazelcast.api.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MapPutRequest {

  @JsonProperty("key")
  private String key;
  @JsonProperty("value")
  private String value;

  @Override
  public String toString() {
    return "MapPutRequest{" +
        "key='" + key + '\'' +
        ", value='" + value + '\'' +
        '}';
  }
}
