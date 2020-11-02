package com.marcosflobo.hazelcast.api.hazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import java.util.List;

@Factory
public class HazelcastFactory {

  @Value("${hazelcast.network.addresses}")
  private List<String> hazecastNetworkAddresses;

  @Value("${hazelcast.client.name}")
  private String hazelcastClientName;

  @Bean
  public HazelcastInstance getHazelcastClient() {
    ClientConfig clientConfig = getClientConfig();

    return HazelcastClient.newHazelcastClient(clientConfig);
  }

  public ClientConfig getClientConfig() {
    ClientNetworkConfig clientNetworkConfig = new ClientNetworkConfig();
    clientNetworkConfig.setAddresses(hazecastNetworkAddresses);

    ClientConfig clientConfig = new ClientConfig();
    clientConfig.setInstanceName(hazelcastClientName);
    clientConfig.setNetworkConfig(clientNetworkConfig);
    return clientConfig;
  }
}
