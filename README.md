# Adapter Pattern

### About
In these repositories, some design patterns are implemented to a mini game system for self education. They may not be suited to use in an actual game (directly anyway). However, it is good to have some examples underhand to take reference. And even if anyone wants to use them, you are welcome.

### Definition
Adapter pattern, converts the interface of a class into another interface the clients expect. Adapter lets classes work together that couldn’t otherwise because of incompatible interfaces.

### Description
We come to a point that we need to use some web services and APIs. We will use two services; one to store users' data in our own database, another one to use game services like social login, leaderboard etc... Because there is more than one service, it will be good to create an interface for these services. So later, we use this interface to make requests and decrease dependencies. Lets make a simple interface;

```java
public interface IService {

    void sendRequest();
    String getResponse();
}
```

Our interface is ready. Now, time to create our concrete classes, one for game services and another one for database services.

```java
public class GameService implements IService {

    @Override
    public void sendRequest() {
        System.out.println("Request is sent to Game Service");
    }

    @Override
    public String getResponse() {
        String response;
        // some implementations
        return response;
    }
}
```
```java
public class DatabaseService implements IService {

    @Override
    public void sendRequest() {
        System.out.println("Request is sent to Database Service");
    }

    @Override
    public String getResponse() {
        String response;
        // some implementations
        return response;
    }
}
```

We are ready to make some requests. However, onces the actual requests were made, we see that game service responses with JSON format and database service responses with XML format. We used interface to decrease dependencies, but now we need to know which service it is to parse for corresponding format and hidden dependency occured. So what we can do? Some convertion can be add in subclass' getResponse() method and make it return converted response. Then again if we decide to change the format we are using or the APIs' says "Lets use YAML instead of JSON from now on", we need to make changes in every subclass. Good news, there is a good pattern for these situations, Adapter Pattern. 

In adapter pattern, our interfaces won't be changed, they will work like before. We just make someone else to adapt them to our needs and act like a power adapters in real life. So lets make our adapter. First we need some parser;

```java
public interface IParser {

    String parse(String response);
}
```
```java
public class JsonParser implements IParser {

    @Override
    public String parse(String response) {
        String parsedResponse;
        // some implementations
        return parsedResponse;
    }
}
```
```java
public class XMLParser implements IParser {

    @Override
    public String parse(String response) {
        String parsedResponse;
        // some implementations
        return parsedResponse;
    }
}
```
Now, it is adapter's turn;

```java
public class ServiceAdapter implements IService {

    private IService service;
    private IParser parser;

    public ServiceAdapter(IService service) {
        this.service = service;

        if(service instanceof GameService){
            parser = new JsonParser();
        } else if (service instanceof DatabaseService) {
            parser = new XMLParser();
        }
    }

    @Override
    public void sendRequest() {
        service.sendRequest();
    }

    @Override
    public String getResponse() {
        String actualResponse = service.getResponse();
        System.out.println(actualResponse);
        return parser.parse(actualResponse);
    }
}
```

Our adapter is constructed with a reference of our actual interface and decides which adapter to use for which subclass. For now, sendRequest() is the same for both. However, getResponse() is now, returns it after parsing and converting it to the same type. Now, we don't need to worry about what format services response with and if we want to add a new format or change them, we just need to add a new parser or change assignments. Usage is as simple as this;

```java
IService gameService = new ServiceAdapter(new GameService());
gameService.sendRequest();
String response = gameService.getResponse();
System.out.println("Game Service Response: " + response);

IService databaseService = new ServiceAdapter(new DatabaseService());
databaseService.sendRequest();
response = databaseService.getResponse();
System.out.println("Database Service Response: " + response);
```

And output;
```
Request is sent to Game Service
{ code: 200, data: Got your request }
Parsing Json...
Game Service Response: code: 200, data: Got your request

Request is sent to Database Service
< code: 200, data: Got your request >
Parsing XML...
Database Service Response: code: 200, data: Got your request
```
We got same results and that's it. In example, fake implementations are made, feel free to look at them.
