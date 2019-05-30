# Spring Cloud Contract (SCC) stubs runner

## Description

[SCC stubs runner][1] out of the box doesn't allow to configure CORS.  
To overcome this limitation we use [Spring Cloud Gateway][2] to enable global CORS.    
The Gateway is configured to route requests of type `host:port/{particularStubRunnerPort}/{stubPath}`  
to `host:{particularStubRunnerPort}/{stubPath}`.  
For example, a request to `http://localhost:8080/9876/api/v1/apps/123/details` will be routed to  
`http://localhost:9876/api/v1/apps/123/details`.  

[By default](src/main/resources/application.yml) global CORS is configured to allow all origins, methods and headers.

## How to run
Example
```
java -Dstubrunner.stubsMode=REMOTE -Dstubrunner.repositoryRoot=https://some-nexus/repository/maven-public -Dstubrunner.ids=com.mycompany:my-service1:1.0.0-SNAPSHOT:stubs:9876,com.my-company.vg:my-service2:1.0.0-SNAPSHOT:stubs:9976 -Dstubrunner.snapshot-check-skip=true -jar scc-stubs-runner-1.0.0-SNAPSHOT.jar
```

[1]: https://cloud.spring.io/spring-cloud-contract/multi/multi__spring_cloud_contract_stub_runner.html#_stub_runner_server
[2]: https://spring.io/projects/spring-cloud-gateway
