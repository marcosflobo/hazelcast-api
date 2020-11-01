package com.marcosflobo.hazelcast.api.service;


import com.marcosflobo.hazelcast.api.domain.MapGetRequest;
import com.marcosflobo.hazelcast.api.domain.MapPutRequest;
import io.micronaut.http.HttpResponse;

public interface MapService {

  public HttpResponse<String> get(MapGetRequest mapGetRequest);
  public HttpResponse<String> write(MapPutRequest mapPutRequest);

}
