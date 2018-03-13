package Redis;

import redis.clients.jedis.Jedis;

public class Exercice4 {

  public static void main(String[] args) {
    String cacheKey = "languages";
    Jedis jedis = new Jedis("localhost");
    // Adding a set as value
    jedis.sadd(cacheKey, "Java");
    jedis.sadd(cacheKey, "C#");
    jedis.sadd(cacheKey, "Python");// SADD
    // Getting all values in the set: SMEMBERS
    System.out.println("Languages: " + jedis.smembers(cacheKey));
    // Adding new values
    jedis.sadd(cacheKey, "Java");
    jedis.sadd(cacheKey, "Ruby");
    // Getting the values... it doesn't allow duplicates
    System.out.println("Languages: " + jedis.smembers(cacheKey));
  }
}
