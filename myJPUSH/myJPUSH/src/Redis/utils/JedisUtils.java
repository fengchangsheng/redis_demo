/**
 * JedisUtils
 */
package Redis.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created on 2013-12-18
 * <p>Description: [描述该类概要功能介绍]</p>
 */
/**
 * Created on 2013-12-18
 * <p>
 * Description: [描述该类概要功能介绍]
 * </p>
 * 
 * @author:wenghy
 * @version 1.0
 */
public class JedisUtils {
	 //private Logger log = Logger.getLogger(this.getClass());  
	 /**缓存生存时间 */
	 private final int expire =JRedisPoolConfig.EXPORE;
	 /** 操作Key的方法 */
	// public Keys KEYS;
	 /** 对存储结构为String类型的操作 */
	 //public Strings STRINGS;
	 /** 对存储结构为List类型的操作 */
	// public Lists LISTS;
	 /** 对存储结构为Set类型的操作 */
	// public Sets SETS;
	 /** 对存储结构为HashMap类型的操作 */
	// public Hash HASH;
	 /** 对存储结构为Set(排序的)类型的操作 */
	// public SortSet SORTSET;
	 private static JedisPool jedisPool = null;  
		 
	 private JedisUtils() {   
		
	 } 
    static {  
           JedisPoolConfig config = new JedisPoolConfig();
           config.setMaxActive(JRedisPoolConfig.MAX_ACTIVE);   
           config.setMaxIdle(JRedisPoolConfig.MAX_IDLE);
           config.setMaxWait(JRedisPoolConfig.MAX_WAIT); 
           config.setTestOnBorrow(JRedisPoolConfig.TEST_ON_BORROW);
           config.setTestOnReturn(JRedisPoolConfig.TEST_ON_RETURN); 
           //redis如果设置了密码：
           jedisPool = new JedisPool(
        		config, 
        		JRedisPoolConfig.REDIS_IP, 
           		JRedisPoolConfig.REDIS_PORT,
           		JRedisPoolConfig.TIME_OUT,
           		JRedisPoolConfig.REDIS_PASSWORD);    
           //redis未设置密码：
          // jedisPool = new JedisPool(config, JRedisPoolConfig.REDIS_IP, 
           	//	JRedisPoolConfig.REDIS_PORT); 
	   }
    
	public JedisPool getPool() {  
		return jedisPool; 
	}
	
    /**
     * 从jedis连接池中获取获取jedis对象  
     * @return
     */
    public static Jedis getJedis() {  
   	 return jedisPool.getResource(); 
	}
    
    
    private static final JedisUtils JedisUtils = new JedisUtils();
	 

   /**
    * 获取JedisUtils实例
    * @return
    */
   public static JedisUtils getInstance() {
		return JedisUtils; 
	}

   /**
    * 回收jedis
    * @param jedis
    */
   public static void returnJedis(Jedis jedis) {
		jedisPool.returnResource(jedis);
	} 

   
   /**
	 * 设置过期时间
	 * @author ruan 2013-4-11
	 * @param key
	 * @param seconds
	 */
	public void expire(String key, int seconds) {
		if (seconds <= 0) { 
			return;
		}
		Jedis jedis = getJedis();
		jedis.expire(key, seconds);
		returnJedis(jedis);
	}

	/**
	 * 设置默认过期时间
	 * @author ruan 2013-4-11
	 * @param key
	 */
	public void expire(String key) {
		expire(key, expire);
	}

}
