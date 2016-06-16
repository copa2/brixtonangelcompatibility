package com.xxx;

import static com.netflix.discovery.converters.wrappers.CodecWrappers.getCodecName;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.CloudJacksonJson;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import com.netflix.discovery.converters.wrappers.CodecWrappers;
import com.netflix.discovery.converters.wrappers.CodecWrappers.LegacyJacksonJson;

@SpringBootApplication
@EnableEurekaServer
public class Application {

    public static void main(String[] args) {
    	// Dirty hack, which injects CloudJacksonJson as encoder/decoder in com.netflix.discovery.provider.DiscoveryJerseyProvider
    	CodecWrappers.registerWrapper(new CloudJacksonJson() {
    		@Override
    		public String codecName() {
    			return getCodecName(LegacyJacksonJson.class);
    		}
    	}); 
        new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

}