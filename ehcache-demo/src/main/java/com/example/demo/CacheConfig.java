package com.example.demo;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.jcache.JCacheCacheManager;

import javax.cache.Caching;
import javax.cache.spi.CachingProvider;

import java.net.URISyntaxException;

import javax.cache.CacheManager;

@Configuration
@EnableCaching
public class CacheConfig {

	@Bean
	public JCacheCacheManager cacheManager() {
		CachingProvider cachingProvider = Caching.getCachingProvider();
		CacheManager cacheManager = null;
		try {
			cacheManager = cachingProvider.getCacheManager(getClass().getResource("/ehcache.xml").toURI(),
					getClass().getClassLoader());
		} catch (URISyntaxException e) {
			System.out.println("Exception ################## :"+e.getMessage());
			e.printStackTrace();
		}
		return new JCacheCacheManager(cacheManager);
	}
}
