# brixtonangelcompatibility

Tests compatibility between a Brixton Eureka Server (SR1) with a Angel Eureka Client (SR6) with
custom 'eureka.instance.metadataMap.instanceId'.

See https://github.com/spring-cloud/spring-cloud-netflix/issues/1111

To start server 
* cd xxx-eureka-server
* gradle bootRun

To start client
* cd xxx-eureka-client-angel
* gradle bootRun
