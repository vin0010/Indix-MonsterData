package com.indix.utils;

import redis.clients.jedis.Jedis;

public class RedisJava {
	public static void main(String[] args) {
		// Connecting to Redis server on localhost
		Jedis jedis = new Jedis("localhost",30005);
		Jedis jedis1 = new Jedis("localhost",30006);
		System.out.println("Connection to server sucessfully");
		// check whether server is running or not
		System.out.println("Server is running: " + jedis.ping());
		
		jedis.set("1","one");
		System.out.println(jedis1.get("1"));
	}
}