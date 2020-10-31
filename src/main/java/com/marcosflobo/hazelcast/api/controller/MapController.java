package com.marcosflobo.hazelcast.api.controller;

import com.marcosflobo.hazelcast.api.service.MapService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Put;

@Controller("/v1/map")
public class MapController {

  private MapService mapService;

  public MapController(MapService mapService) {
    this.mapService = mapService;
  }

  @Put
  @Produces(MediaType.APPLICATION_JSON)
  public HttpResponse<String> writeKeyValue() {
    return mapService.write();
  }

}
