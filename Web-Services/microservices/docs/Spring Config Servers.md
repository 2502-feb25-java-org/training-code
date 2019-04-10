
# Spring Cloud Config Servers
* “Spring Cloud Config provides server and client-side support for externalized configuration in a distributed system.”
* Spring Config Server is built on Spring Boot
* Spring Cloud Config Server provides an HTTP resource-based API for external configuration
* Allows client applications to consume configuration on startup and can refresh the configuration without restarting.
* Spring Cloud Config works best with Spring applications, but can also work with any application running any language.

Normally, configuration files will be packed together with the code and form a sole (file) product. Thus, if there are any changes in the configuration, you need to compile, and repack the project and re-deploy it onto the server. This is obviously a challenge in a distributed application environment.
The idea to solve the above problem is that a service (application) is required to manage configurations for other services. It runs independently on a server.

![alt text](https://o7planning.org/en/11723/cache/images/i/15378106.png "Config Server Usage")

* Runs on port 8080 by default, change port in application.properties
* Stores & retrieves configuration data in *EnvironmentRepository*, which serves up *Environment* objects
* Default implementation of *EnvironmentRepository* is __Git version control__.

![alt text](https://o7planning.org/en/11723/cache/images/i/15359236.png "Flowchart")

 - Use *@EnableConfigServer* annotation to create a Spring Config Server class.
 

>     @SpringBootApplication
>     @EnableConfigServer
>     public   class  ConfigServer {
>     	public   static   void  main(String[] args) {
>     			SpringApplication.run(ConfigServer. class , args);
>     	}
>     }

 - Server listens to a git repository, which provides version controlled
   configuration  content

In application.properties file:

>     server.port=8888
>     spring.cloud.config.server.git.uri=ssh://localhost/config-repo
>     spring.cloud.config.server.git.clone-on-start=true
>     security.user.name=root
>     security.user.password=s3cr3t
