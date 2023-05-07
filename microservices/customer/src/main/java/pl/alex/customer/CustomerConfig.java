package pl.alex.customer;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CustomerConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){ // <-- Better to use OpenApi or OpenFeign
        return new RestTemplate();
    }
}
