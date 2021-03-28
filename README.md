# Spring Boot "REST API" User Management
***
This is a sample User Management with Spring Boot

### About Javadoc

You can launch the index.html file inside javadoc folder.

## How to Run
***
* Clone this repository
* Make sure you are using JDK 1.8 and Maven 3.x
* You can run the project by the main Class : 
```
      UserProfileApps
```

Once the application runs you should see something like this :

```
2021-03-28 13:47:06.320  INFO 91432 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2021-03-28 13:47:06.511  INFO 91432 --- [  restartedMain] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2021-03-28 13:47:06.640  INFO 91432 --- [  restartedMain] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-03-28 13:47:06.647  INFO 91432 --- [  restartedMain] c.f.usermanagement.demo.UserProfileApps  : Started UserProfileApps in 3.629 seconds (JVM running for 4.313)
2021-03-28 13:47:06.671  INFO 91432 --- [       Thread-7] o.s.b.a.mongo.embedded.EmbeddedMongo     : 2021-03-28T13:47:06.671+0200 I NETWORK  [thread1] connection accepted from 
```

## About the DataBase

I used a mongodb EmbeddedMongo to store data in order to test my application,








