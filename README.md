# DBL Java Library
A Java wrapper for the [discordbots.org API](https://discordbots.org/api/docs)

## Usage

First, build a DiscordBotListAPI object.

```java
DiscordBotListAPI api = new DiscordBotListAPI.Builder()
	.token("token")
	.botId("botId")
	.build();
```

#### Posting stats

DBL provides three ways to post your bots stats.

**#1**
Posts the server count for the whole bot.
```java
int serverCount = ...; // the total amount of servers across all shards

api.setStats(serverCount);
```

**#2**
Posts the server count for an individual shard.
```java
int serverCount = ...; // the server count of this shard
int shardId = ...; // the id of this shard
int shardCount = ...; // the amount of shards

api.setStats(serverCount, shardId, shardCount);
```

**#3**
Posts the server counts for every shard in one request.
```java
List<Integer> shardServerCounts = ...; // a list of all the shards' server counts

api.setStats(shardServerCounts);
```

#### Checking votes

```java
String userId = ...; // ID of the user you're checking
boolean hasVoted = api.hasVoted(userId).get();
```

## Download

Replace `VERSION` with the latest version or commit hash. The latest version can be found under releases.

#### Maven

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
        <artifactId>DBL-Java-Library</artifactId>
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
    compile 'com.github.DiscordBotList:DBL-Java-Library:VERSION'
}
```


