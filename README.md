# springboot-microservices

### Notes on avatar_id_creator service

#### Standalone JAR:
When running the java standalone, use command like ```java -jar build/libs/AvatarCreator-0.1.0.jar --avatarNameUri=http://<avatar_name_service>:<port>/```. This retrieves the name section of the final output from another microservice.    Refer [https://github.com/bbideep/go](https://github.com/bbideep/go)   

When the env var 'avatarNameUri' is not provided, the remote service is not called and the result output is something like 'ZOMBIE_AVATAR_<randomnumber>'
  
#### Docker container:
Build the image: ```docker build -f Dockerfile -t avatar_name_creator:0.1 .```   
Run in a container like ```docker run -d -p 8080:8080 -e avatarNameUri=http://<avatar_name_service>:<port>/ avatar_name_creator:0.1```. 

You would see an output like 'ZOMBIE_AVATAR_<randomnumber>' if the env var avatarNameUri is not provided at run time.
