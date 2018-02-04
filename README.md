# Java Wrapper
A Java wrapper for the [discordbots.org API](https://discordbots.org/api/docs)

## Download

#### Maven

Replace `VERSION` with the latest version or commit.

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```
```xml
<dependencies>
    <dependency>
        <groupId>com.github.DiscordBotList</groupId>
        <artifactId>Java-Wrapper</artifactId>
        <version>VERSION</version>
    </dependency>
</dependencies>
```

#### Gradle 
```gradle
repositories {
    maven { url 'https://jitpack.io' }
}
```
```gradle
dependencies {
    compile 'com.github.DiscordBotList:Java-Wrapper:VERSION'
}
```

## Usage

First, build a DiscordBotListAPI object.

```java
DiscordBotListAPI api = new DiscordBotListAPI.Builder()
                                             .token("token")
                                             .build();
```

#### Posting stats

DBL provides three ways to post your bots stats.

#####\#1
Posts the server count for the whole bot.
```java
String botId = ...;
int serverCount = ...;

api.setStats(botId, serverCount);
```


#####\#2
Posts the server count for an individual shard.
```java
String botId = ...;
int serverCount = ...;
int shardId = ...;
int shardCount = ...;

api.setStats(botId, serverCount, shardId, shardCount);
```

#####\#3
Posts the server counts for every shard in one request.
```java
String botId = ...;
List<Integer> shardServerCounts = ...; 

api.setStats(botId, shardServerCounts);
```

#### Retrieving voters

You can either get the full objects or a simple list of the user IDs.

```java
// will return the full User objects
List<User> voters = api.getVoters("bot id"); 

// will return a list of the user IDs
List<String> voterIds = api.getVoterIds("bot id");
```



