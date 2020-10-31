package com.marcosflobo.hazelcast.api.service;


import io.micronaut.http.HttpResponse;

public interface MapService {

  public HttpResponse<String> write();

}
