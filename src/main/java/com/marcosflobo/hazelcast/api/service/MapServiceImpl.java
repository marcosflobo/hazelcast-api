package com.marcosflobo.hazelcast.api.service;


import io.micronaut.http.HttpResponse;

public class MapServiceImpl implements MapService {

  @Override
  public HttpResponse<String> write() {
    return HttpResponse.ok();
  }
}
