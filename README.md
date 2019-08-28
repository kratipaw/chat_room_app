# Chat Room
[Check Code here](https://github.com/kratipaw/chat_room_app)

# Introduction
This application is a simple chat room application developed using web-sockets in Java. The basic tasks users can perform are:
- entering a room
- sending messages
- leaving the room

In the below sections, I will present an overview of the project components, what are the classes that make up the project and some few pointers on future scope.

## Web Socket
WebSocket is a communication protocol that makes it possible to establish a two-way communication channel between a server and a client.

## System Design
I will go through the important classes and their workings as well. Some additional html and xml files that complete the project and are essential are also explained.

### Message.java
Message is a model class. It is the message payload that will be exchanged between the client and the server.

### WebSocketChatServer.java
WebSocketChatServer is the controller class. It has below method implementations:-

- __onOpen__:Establishes a connection between client and server

- __onMessage__: Gets session and user information and sends messages.

- __sendMessageToAll__: Sends the message to all connected users

- __onClose__:Closes the connection

### WebSocketConfig.java
WebSocketConfig is the web socket configuration file which defines server endpoint exporter

### LoginController.java
LoginController is controller file to implement the login functionality and render the chat url

### WebSocketChatApplication.java
WebSocketChatApplication is the main class to boot the application

### login.html
This view-page helps the user to login.

### chat.html
This view-page shows the chat window where user can also type-in his\her message

### pom.xml
Its the maven build file with dependency on spring-boot-starter-web, spring-boot-starter-websocket, spring-boot-starter-thymeleaf, jquery, fastjson.

### Run the application with command
Clone the repository with,
```bash
$ git clone https://github.com/kratipaw/chat_room_app.git
```

Navigate to the root directory i.e. chat_room_app and Run the maven build command and run the spring boot application
```bash
$ cd chat_room_app; mvn build; mvn spring-boot:run
```

Let me know if you see any possible improvements or errors in the application. You can reach out to me at: <br>
[LinkedIn](https://linkedin.com/in/kratipaw) <br>
[Twitter](https://twitter.com/krati_paw)
