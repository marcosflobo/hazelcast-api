# hazelcast-api
Microservice that exposes an API to manage information in Hazelcast Maps

## Endpoints
### Business
|Endpoint|Return Format|Desciption|
---------|-------------|----------|
|TODO|`application/json`|TODO|

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

