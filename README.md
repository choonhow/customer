# Spring root with kubernetes
This is a sample project using java spring root. It will show you how to build docker image and push to docker hub.  
You can then test this image from kubernetes node from [kube project](https://github.com/choonhow/kube)

## 0) Topic
1) [overview](#1-overview)  
2) [prequisite](#2-prerequisite)  
3) [build project](#3-build-project) 
4) [login to docker hub](#4-login-to-docker-hub)
5) [show docker images](#5-show-docker-images)
6) [push docker image](#6-push-docker-image)
7) [spring root demo](#7-spring-root-demo)

## 1) overview
This is a sample project using java spring root.  
This project will build into docker image and push to docker hub.  

## 2) prerequisite
- java, docker installed
- or you can use vagrant image (k8s-m) from [kube project](https://github.com/choonhow/kube)

## 3) build project
- run the following to build the java spring project
```
mvn build
```
- maven will build jar file in /target folder 
- run the following to build & create the docker image
- docker will copy `target/customer-0.0.1-SNAPSHOT.jar` into `/bs.jar`
```
docker image build --tag customer:0.1 .

...
Removing intermediate container 06b4348e0b89
 ---> 82b08d47b3d4
Successfully built 82b08d47b3d4
Successfully tagged customer:0.1

```

## 4) login to docker hub
- run the following to login into docker hub
```
docker login --username=xxxxx
Password:
WARNING! Your password will be stored unencrypted in /home/kube/.docker/config.json.
Configure a credential helper to remove this warning. See
https://docs.docker.com/engine/reference/commandline/login/#credentials-store

Login Succeeded
```

## 5) show docker images
- run the following to show docker images in your machine

```
> docker images
REPOSITORY                           TAG                 IMAGE ID            CREATED             SIZE
customer                             0.1                 82b08d47b3d4        5 minutes ago       504MB
```

## 5) tag remote docker images
- run the following to tag the image into your account
```
docker tag 82b08d47b3d4 <your docker acct>/customer:0.1

example
docker tag 82b08d47b3d4 choonhow/customer:0.1
```

## 6) push docker image
- run the following to push image into your docker hub account
```
docker push choonhow/customer:0.1

The push refers to repository [docker.io/choonhow/customer]
9e718c4d4d0b: Pushed
c9fcfd301d85: Pushed
fcd6896eecf1: Mounted from library/openjdk
2666aafcfdd9: Mounted from library/openjdk
c4a7cf6a6169: Mounted from library/openjdk
0.1: digest: sha256:65f8a760472fe4297fa266d8753e818f1afd93676c13c0691f27c9fb0e896ed4 size: 1579
```

## 7) spring root demo
- your image is ready in docker hub and can be use in [spring root demo project](https://github.com/choonhow/kube#11-setup-spring-root-demo)
