package com.marcosflobo.hazelcast.api.service;


import com.hazelcast.map.IMap;
import com.marcosflobo.hazelcast.api.domain.MapPutRequest;
import com.marcosflobo.hazelcast.api.hazelcast.HazelcastFactory;
import io.micronaut.http.HttpResponse;
import javax.inject.Singleton;

@Singleton
public class MapServiceImpl implements MapService {

  private IMap<String, String> hazelcastMap;

  public MapServiceImpl(HazelcastFactory hazelcastFactory) {
    hazelcastMap = hazelcastFactory.getHazelcastClient().getMap("mymap");
  }

  @Override
  public HttpResponse<String> write(MapPutRequest mapPutRequest) {

    hazelcastMap.putAsync(mapPutRequest.getKey(), mapPutRequest.getValue());

    return HttpResponse.ok();
  }
}
