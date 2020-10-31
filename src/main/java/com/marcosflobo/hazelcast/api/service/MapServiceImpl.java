package com.marcosflobo.hazelcast.api.service;


import com.marcosflobo.hazelcast.api.domain.MapPutRequest;
import io.micronaut.http.HttpResponse;
import javax.inject.Singleton;

@Singleton
public class MapServiceImpl implements MapService {

  @Override
  public HttpResponse<String> write(MapPutRequest mapPutRequest) {
    return HttpResponse.ok();
  }
}
