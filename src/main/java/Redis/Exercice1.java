package Redis;

import redis.clients.jedis.Jedis;

public class Exercice1 {

  public static void main(String[] args){

    Jedis jedis = new Jedis("localhost");
    jedis.set("foo", "bar");
    String value = jedis.get("foo");

    System.err.println(value);

  }
}
