package com.marcosflobo.hazelcast.api.service;


import com.marcosflobo.hazelcast.api.domain.MapGetRequest;
import com.marcosflobo.hazelcast.api.domain.MapPutRequest;
import io.micronaut.http.HttpResponse;

public interface MapService {

  HttpResponse<String> get(MapGetRequest mapGetRequest);
  HttpResponse<String> write(MapPutRequest mapPutRequest);

}
