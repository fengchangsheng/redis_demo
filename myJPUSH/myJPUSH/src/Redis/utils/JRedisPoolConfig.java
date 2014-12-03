/**
 * 
 */
package Redis.utils;

/**
 * Created on 2013-12-20
 * <p>Description: [Redis≈‰÷√≤Œ ˝]</p>
 * @author:wenghy
 * @version     1.0
 */
public class JRedisPoolConfig {
	static int EXPORE=Integer.parseInt(CommonHelper.getProertiesValue("maxActive","redis.properties"));
	static int  MAX_ACTIVE=Integer.parseInt(CommonHelper.getProertiesValue("maxActive","redis.properties"));
	static int  MAX_IDLE=Integer.parseInt(CommonHelper.getProertiesValue("maxIdle","redis.properties"));
	static int MAX_WAIT=Integer.parseInt(CommonHelper.getProertiesValue("maxWait","redis.properties"));
	static int TIME_OUT=Integer.parseInt(CommonHelper.getProertiesValue("timeout","redis.properties"));
	static boolean  TEST_ON_BORROW=false;
	static boolean  TEST_ON_RETURN=false;
	static String  REDIS_PASSWORD=CommonHelper.getProertiesValue("redisPWD","redis.properties");
	static String  REDIS_IP=CommonHelper.getProertiesValue("redisIp","redis.properties");
	static int REDIS_PORT=Integer.parseInt(CommonHelper.getProertiesValue("redisPort","redis.properties"));
}
