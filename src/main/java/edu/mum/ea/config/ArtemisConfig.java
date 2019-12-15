package edu.mum.ea.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisConfigurationCustomizer;
import org.springframework.boot.autoconfigure.jms.artemis.ArtemisProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ArtemisConfig implements ArtemisConfigurationCustomizer {

    @Autowired
    ArtemisProperties artemisProperties;

    @Override
    public void customize(org.apache.activemq.artemis.core.config.Configuration configuration) {
        try {
            configuration.addAcceptorConfiguration("netty", "tcp://" + artemisProperties.getHost() + ":" + artemisProperties.getPort());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
