/**
 * Copyright (c) 2005-2012 https://github.com/zhangkaitao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package com.digitalplay.network.ireader.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.data.domain.Sort;
import org.springframework.orm.jpa.SharedEntityManagerCreator;

public class RepositoryHelper {

    private static EntityManager entityManager;
    private Class<?> entityClass;
    private boolean enableQueryCache = false;

    /**
     * @param entityClass 是否开启查询缓存
     */
    public RepositoryHelper(Class<?> entityClass) {
        this.entityClass = entityClass;

        EnableQueryCache enableQueryCacheAnnotation =
                AnnotationUtils.findAnnotation(entityClass, EnableQueryCache.class);

        boolean enableQueryCache = false;
        if (enableQueryCacheAnnotation != null) {
            enableQueryCache = enableQueryCacheAnnotation.value();
        }
        this.enableQueryCache = enableQueryCache;
    }

    public static void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        entityManager = SharedEntityManagerCreator.createSharedEntityManager(entityManagerFactory);
    }

    public static EntityManager getEntityManager() {

        return entityManager;
    }


    public static void flush() {
        getEntityManager().flush();
    }

    public static void clear() {
        flush();
        getEntityManager().clear();
    }


    /**
     * <p>执行批处理语句.如 之间insert, update, delete 等.<br/>
     * @param ql
     * @param params
     * @return
     */
    public int batchUpdate(final String ql, final Object... params) {

        Query query = getEntityManager().createQuery(ql);
        setParameters(query, params);

        return query.executeUpdate();
    }


    /**
     * 按顺序设置Query参数
     *
     * @param query
     * @param params
     */
    public void setParameters(Query query, Object[] params) {
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i + 1, params[i]);
            }
        }
    }

    /**
     * 拼排序
     *
     * @param sort
     * @return
     */
    public String prepareOrder(Sort sort) {
        if (sort == null || !sort.iterator().hasNext()) {
            return "";
        }
        StringBuilder orderBy = new StringBuilder("");
        orderBy.append(" order by ");
        orderBy.append(sort.toString().replace(":", " "));
        return orderBy.toString();
    }







    public void applyEnableQueryCache(Query query) {
        if (enableQueryCache) {
            query.setHint("org.hibernate.cacheable", true);//开启查询缓存
        }
    }

}
