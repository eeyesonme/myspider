package com.digitalplay.network.ireader.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.Cache;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.hibernate.stat.Statistics;

public class HibernateUtils {

	/** 
     * 根据jpa EntityManager 获取 hibernate Session API 
     * @param em 
     * @return 
     */  
    public static Session getSession(EntityManager em) {  
        return (Session) em.getDelegate();  
    }  
  
    public static void manualCommit(EntityManager em){
    		getSession(em).getTransaction().commit();
    }
    public static CacheMode getCacheMode(EntityManager em){
    	return getSession(em).getCacheMode();
    }
    
    public static void setCacheMode(EntityManager em,CacheMode mode){
    	 getSession(em).setCacheMode(mode);
    }
  
    /** 
     * 根据jpa EntityManager 获取 hibernate SessionFactory API 
     * @see #getSessionFactory(javax.persistence.EntityManagerFactory) 
     * @param em 
     * @return 
     */  
    public static SessionFactory getSessionFactory(EntityManager em) {  
        return getSessionFactory(em.getEntityManagerFactory());  
    }  
  
    /** 
     * 根据jpa EntityManagerFactory 获取 hibernate SessionFactory API 
     * @param emf 
     * @return 
     */  
    public static SessionFactory getSessionFactory(EntityManagerFactory emf) {  
        return ((HibernateEntityManagerFactory)emf).getSessionFactory();  
    }  
  
    /** 
     * 根据 jpa EntityManager 获取hibernate Cache API 
     * @see #getCache(javax.persistence.EntityManagerFactory) 
     * @param em 
     * @return 
     */  
    public static Cache getCache(EntityManager em) {  
        return getCache(em.getEntityManagerFactory());  
    }  
  
    /** 
     * 根据jpa EntityManagerFactory 获取 hibernate Cache API 
     * @param emf 
     * @return 
     */  
    public static Cache getCache(EntityManagerFactory emf) {  
        return getSessionFactory(emf).getCache();  
    }  
  
    /** 
     * 清空一级缓存 
     * @param em 
     */  
    public static void clearCache(EntityManager em) {  
        em.clear();  
    }  
  
    /** 
     * 根据jpa EntityManager 清空二级缓存 
     * 1、实体缓存 
     * 2、集合缓存 
     * 3、查询缓存 
     * @param em 
     */  
    public static void clearAllCache(EntityManager em) {  
    	  Cache cache = HibernateUtils.getCache(em.getEntityManagerFactory());  
    	  cache.evictAllRegions();
    }  
    
    public static void printStatics(EntityManager em){
    	Statistics st = HibernateUtils.getSessionFactory(em).getStatistics();
    	System.out.println(st.toString());
    	System.out.println(st.getSecondLevelCacheStatistics("Category").toString());
    }
  
}
