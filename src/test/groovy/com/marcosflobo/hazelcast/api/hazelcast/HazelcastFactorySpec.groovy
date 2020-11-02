package com.marcosflobo.hazelcast.api.hazelcast

import com.hazelcast.client.config.ClientConfig
import com.hazelcast.client.config.ClientNetworkConfig
import com.hazelcast.core.HazelcastInstance
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification
import spock.lang.Unroll

import javax.inject.Inject

@MicronautTest
class HazelcastFactorySpec extends Specification {

    @Inject
    HazelcastFactory hazelcastFactory = new HazelcastFactory()

    @Unroll
    def "The Hazelcast configuration is properly created"(){
        when: "The Hazelcast client config is created"
        ClientConfig clientConfig = hazelcastFactory.getClientConfig()

        then: "It should have the Instance name which is set on the application-test.yml"
        clientConfig.getInstanceName() == "hazelcastApi-test"

        and: "It should have the Network Addresses which is set on the application-test.yml"
        clientConfig.getNetworkConfig().getAddresses().get(0) == "localhost-test:5701"

        and: "It should have the Cluster Name which is set on the application.yml"
        clientConfig.getClusterName() == "dev"
    }
}
