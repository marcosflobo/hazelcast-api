package com.marcosflobo.hazelcast.api.controller;

import com.marcosflobo.hazelcast.api.domain.MapGetRequest;
import com.marcosflobo.hazelcast.api.domain.MapPutRequest;
import com.marcosflobo.hazelcast.api.service.MapService;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Put;

@Controller("/v1/map")
public class MapController {

  private final MapService mapService;

  public MapController(MapService mapService) {
    this.mapService = mapService;
  }

  @Post
  @Produces(MediaType.APPLICATION_JSON)
  public HttpResponse<String> get(HttpRequest request, @Body MapGetRequest mapGetRequest) {
    return mapService.get(mapGetRequest);
  }

  @Put
  @Produces(MediaType.APPLICATION_JSON)
  public HttpResponse<String> writeKeyValue(HttpRequest request,
      @Body MapPutRequest mapPutRequest) {
    return mapService.write(mapPutRequest);
  }

}
