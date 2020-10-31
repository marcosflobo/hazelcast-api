package com.marcosflobo.hazelcast.api.controller

import com.marcosflobo.hazelcast.api.domain.MapPutRequest
import com.marcosflobo.hazelcast.api.service.MapService
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class MapControllerSpec extends Specification {

    MapService mockMapService = Mock(MapService)
    MapController mapController = new MapController(mockMapService)

    @Inject
    @Client("/v1/map")
    RxHttpClient client

    def "Controller gets proper information"() {
        given: "a body"
        MapPutRequest mapPutRequest = new MapPutRequest();
        and: "a response from the service"
        def expResponse = HttpResponse.ok();
        mockMapService.write(mapPutRequest) >> expResponse

        expect: "to return the service response"
        def response = mapController.writeKeyValue(HttpRequest.PUT("/v1/map", mapPutRequest), mapPutRequest)

        and: "the response is OK"
        response.status() == expResponse.status()
    }
}
