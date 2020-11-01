# hazelcast-api
[![Codacy Badge](https://app.codacy.com/project/badge/Grade/6a48a3ea9aea4092b2aa3ae5ab40e299)](https://www.codacy.com/gh/marcosflobo/hazelcast-api/dashboard?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=marcosflobo/hazelcast-api&amp;utm_campaign=Badge_Grade)
[![Codacy Badge](https://app.codacy.com/project/badge/Coverage/6a48a3ea9aea4092b2aa3ae5ab40e299)](https://www.codacy.com/gh/marcosflobo/hazelcast-api/dashboard?utm_source=github.com&utm_medium=referral&utm_content=marcosflobo/hazelcast-api&utm_campaign=Badge_Coverage)

Microservice that exposes an API to manage information in Hazelcast Maps

## Configuration
|Property|Default value|Desciption|
---------|-------------|----------|
|MICRONAUT_SERVER_PORT|`6969`|The port on the API is listening|
|MICRONAUT_SERVER_MAX_REQUEST_SIZE|`1024`|Max size, in bytes, allowed for an incoming request|
|HAZELCAST_NETWORK_ADDRESSES|`localhost:5701`|The DNS and port of the Hazelcast cluster|
|HAZELCAST_CLIENT_NAME|`hazelcastApi`|The name representing this microservice the list of clients from Hazelcast connections|
|HAZELCAST_CLIENT_CLUSTERNAME|`dev`|The name of the Hazelcast cluster to connect|
|MICRONAUT_METRICS_ENABLED|`true`|Enable or disable the Micronaut metrics endpoint|

## API Endpoints
|Endpoint|Method|Produces|Consumes|Body|Desciption|
---------|------|--------|--------|----|----------|
|/v1/map|PUT|`application/json`|`application/json`|`{"key":"foo", "value":"myvalue", "map-name":"mymap"}`|Write a key/value on a specific Hazelcast Map|
|/v1/map|POST|`application/json`|`application/json`|`{"key":"foo", "map-name":"mymap"}`|Get the value from a key on a specific Hazelcast Map|

### Examples
#### Write simple key/value in Map named "mymap2"
```shell script
curl -X PUT http://localhost:6969/v1/map --header "Content-Type: application/json" -d '{"key":"foo","value":"myvalue2", "map-name":"mymap2"}'
```
#### Write a complex key/value in Map named "mymap2"
```shell script
curl -X PUT http://localhost:6969/v1/map --header "Content-Type: application/json" -d '{"key":"foo","value":"{\"internal_key\": \"internal_value\"}", "map-name":"mymap2"}'
```
#### Get a value from a key in Map named "mymap2"
```shell script
curl -X POST http://localhost:6969/v1/map --header "Content-Type: application/json" -d '{"key":"complexkey", "map-name": "mymap2"}'
```

## Development
During development, it's very important test and test fast, not only the application but also how it will work when it's
deployed in production. For that, it's important to test via Docker container and, for doing so, we can use a docker-compose
file.

The `docker-compose.yml` file will run:
  - Container with the last assembled version of this hazelcast-api app
  - Container with [Prometheus](https://prometheus.io/) service, to scrape the metrics exposed by the app
  - Container with [Grafana](https://grafana.com/) service, to visualize the metrics scraped by Prometheus from the app

### Run docker-compose
```shell script
$ ./gradlew clean assemble && docker-compose up
```
  - Prometheus is available on http://localhost:9090. Perform some tests on the app API (see chapter above) and wait 30s to query for some metric such as `http_server_requests_seconds_count`
  - Grafana is available on http://localhost:3000
  - Hazelcast server is deployed on port 5701
  - Hazelcast Management Center is available on http://localhost:8080

To stop the docker-compose, just type `Ctrl+c`. To remove the containers created, run `docker-compose down`.

### Metrics
|Endpoint|Desciption|
---------|----------|
|/metrics|Metrics information in JSON format|
|/prometheus|Metrics information in Prometheus format|
|/health|Status health of the service in JSON format|

## Micronaut
  - Version 2.1.2. More info at [Micronaut 2.1.2](https://github.com/micronaut-projects/micronaut-core/releases/tag/v2.1.2)
  - [Official documentation](https://docs.micronaut.io/latest/guide/index.html)

### Feature cache-hazelcast documentation
  - [Micronaut Hazelcast Cache documentation](https://micronaut-projects.github.io/micronaut-cache/latest/guide/index.html#hazelcast)
  - [https://hazelcast.org/](https://hazelcast.org/)

### Feature management documentation
  - [Micronaut Micronaut Management documentation](https://docs.micronaut.io/latest/guide/index.html#management)

### Feature http-client documentation
  - [Micronaut Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)
