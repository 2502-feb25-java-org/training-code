# Docker 
- platform for developers to develop, deploy, and run applications with containers
- Docker can only be used on Linux machines (Docker Toolbox can be used to configure Docker on a Mac or Windows Pro)
## Containerization
### Virtual Machines vs Containers
- both ways we can have partition a single machine into multiple computing environments
- virtual machines each have their own OS that are integrated with the host machines host operating system with a hypervisor
- containers have the ability to share a an operating system while maintaining their own isolated computing environment
    - can have their own file systems, environment variables, etc. 
- the hypervisor is not necessary, the guest OS are not necessary
- much more lightweight more easily scalable
- more efficient use of machine's resources
<img src="https://www.brightcomputing.com/hs-fs/hubfs/Blog_Images/containers-vm.jpg?width=960&height=470&name=containers-vm.jpg" alt="containers v. vms">
Containers are:
- Flexible: Even the most complex applications can be containerized.
- Lightweight: Containers leverage and share the host kernel.
- Interchangeable: You can deploy updates and upgrades on-the-fly.
- Portable: You can build locally, deploy to the cloud, and run anywhere.
- Scalable: You can increase and automatically distribute container replicas.
- Stackable: You can stack services vertically and on-the-fly.
### Drawbacks of Containerization
- don't have the flexibility of using different operating systems for different applications ("OS lock in"); we can provide software which makes applications compatible with other OS but no longer have the benefit of them being as lightweight 
- if an OS is comprimised it effects all applications
## Docker Workflow
- image: the basis of a container 
    - an ordered collection of root filesystem changes and the corresponding execution parameters for use within a container runtime
- two ways we can obtain an image
    1. we can build our image with a Dockerfile
    2. we can pull our image from DockerHub
- once we have an image we can create a container in that image
### Dockerfile
- A file which describes the the changes we're making on the environment to make our image
    - base image: an image created with a Dockerfile with no FROM 
    - parent image: an image in the FROM clause
Dockerfile keywords:
- FROM: specifies the parent image, the image upon which your image is build on
    - if you don't include the FROM keyword, you're creating base image
- ADD: can do what copy does but can also use a URL 
- COPY: copies a file or directory from the host to the container
- ENV: set environment variables 
- EXPOSE: documents the port to be exposed (is not actually enforced, doesn't actually do anything)
- LABEL: allows you to set key value pairs of metadata
- WORKDIR: changes the working director from which changes are being made
- RUN: runs a shell command, or runs an executable
Building an Image with a Dockerfile 
- this is done with the CLI build command, where the only required argument is the location of the Dockerfile
    - docker build .
    - docker build -t [tagname] .
### DockerHub
- centralized library for container images
- images available from software vendors, can add your own repositories
## Docker Compose 
- a tool for defining and running multi-container Docker applications
- docker-compose.yml file allows you to configure your applications' services so that you can spin up all of your containers at once
# Docker Example
### 1. set up Docker on an Amazon Linux instance
- create a linux instance on AWS, and ssh into it
Update Linux instance
> sudo yum update -y
Install Docker Community Edition
> sudo amazon-linux-extras install docker
Start the docker service
> sudo service docker start
Add the ec2-user to the docker grou so you can execute Docker commands without using sudo 
> sudo usermod -a -G docker ec2-user
-- log out and back in --
> exit
> ssh
-- once you log back in you should be able to run the following command and it be recognized as the current user:
> docker info 
### 2a. pull an image from dockerhub and create a container with it
list images, shouldn't be any
> docker images 
pull container from dockerhub
> docker pull hello-world 
list images again, should see hello-world
> docker images 
list running processes, none should be running 
> docker ps 
run hello-world
> docker run hello-world
show active containers; hello-world will have terminated so  --all this will show even when exited
> docker container ls
> docker container ls --all
### 2b. pull an image from dockerhub and create a container with it
- each dockerhub repo is uniquely identified by the user/repo
- we could do the same steps as in 2b and pull crehm/discovery and then run it; however, when we run an image that isn't in the current directory, docker will attempt to pull tha 
> docker run btkruppa/dicovery -p [8761:8761]
> docker run [image]
> docker run [image] -p [hostPort:containerPort]
- -p option publishes to a port, the first value being the port on the host machine (your linux instance) and 
- -d option will run the container in detached mode (will open a separate terminal)
take a look now at the images 
> docker images
and also the running processes
> docker ps 
you should see it up and running - go to your ec2 endpoint's port 8761 and see an instance of eureka running 
### 3. creating an image from a dockerfile
create Dockerfile
> touch Dockerfile 
edit file
> nano Dockerfile
``` Dockerfile
FROM java:8 
ADD https://s3.us-east-2.amazonaws.com/crehm-resources/account-service.jar .
EXPOSE 2333
CMD java -jar account-service.jar
```
-- the jar url here is the account service we created during our microservice week (spring boot app)
- change the eureka location to your ec2's currently hosted eureka's instance [http://ec2-xxx-xxx-xxx-xxx.compute-1.amazonaws.com:8761/eureka]
- use maven to package spring boot app into a jar
- host it in an s3 so that the car can be downloaded from the url to your ec2's container
- you can use the url I have provided but it will not register itself with eureka
Now let's build our image using the Dockerfile
> docker build -t account-service .
and then create a container with the image you just built
> docker run account-service -p [2333:2333]
- now you should be able to port 2333/accounts on your ec2 and see account data
- you should also be able to see the account-service registered with eureka 
### 4. pushing an image to docker hub
- log in on https://hub.docker.com/
- create a repository
- log into docker hub in the command line 
> docker login --username=yourhubusername --email=youremail@company.com
- create an image with the same tag as your repository (username/repository to uniquely identify)
- push that image to docker hub
> docker push [username]/[repository]
# Docker Swarm
- orchestration tool (Kubernetes is also an orchestration tool)
- 