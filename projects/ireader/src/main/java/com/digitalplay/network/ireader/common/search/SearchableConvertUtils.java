package com.digitalplay.network.ireader.common.search;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.core.convert.ConversionService;
import org.springframework.util.CollectionUtils;

import com.digitalplay.network.ireader.util.SpringUtils;
import com.google.common.collect.Lists;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-15 上午11:46
 * <p>Version: 1.0
 */
public final class SearchableConvertUtils {

    private static volatile ConversionService conversionService;

    /**
     * 设置用于类型转换的conversionService
     * 把如下代码放入spring配置文件即可
     * <bean class="org.springframework.beans.factory.config.MethodInvokingFactoryBean">
     * <property name="staticMethod"
     * value="com.sishuok.es.common.entity.search.utils.SearchableConvertUtils.setConversionService"/>
     * <property name="arguments" ref="conversionService"/>
     * </bean>
     *
     * @param conversionService
     */
    public static void setConversionService(ConversionService conversionService) {
        SearchableConvertUtils.conversionService = conversionService;
    }

    public static ConversionService getConversionService() {
        if (conversionService == null) {
            synchronized (SearchableConvertUtils.class) {
                if (conversionService == null) {
                    try {
                        conversionService = SpringUtils.getBean(ConversionService.class);
                    } catch (Exception e) {
                        throw new SearchException("conversionService is null, " +
                                "search param convert must use conversionService. " +
                                "please see [com.sishuok.es.common.entity.search.utils." +
                                "SearchableConvertUtils#setConversionService]");
                    }
                }
            }
        }
        return conversionService;
    }

    /**
     * @param search      查询条件
     * @param entityClass 实体类型
     * @param <T>
     */
    public static <T> void convertSearchValueToEntityValue(final SearchRequest search, final Class<T> entityClass) {

        if (search.isConverted()) {
            return;
        }

        Collection<SearchFilter> searchFilters = search.getSearchFilters();
        BeanWrapperImpl beanWrapper = new BeanWrapperImpl(entityClass);
        beanWrapper.setAutoGrowNestedPaths(true);
        beanWrapper.setConversionService(getConversionService());

        for (SearchFilter searchFilter : searchFilters) {
            convertSearchValueToEntityValue(beanWrapper, searchFilter);
        }
    }

    private static void convertSearchValueToEntityValue(BeanWrapperImpl beanWrapper, SearchFilter searchFilter) {
    	String searchProperty = searchFilter.getFieldName();

        //自定义的也不转换
        if (searchFilter.getOperator() == SearchOperator.custom) {
            return;
        }

        //一元运算符不需要计算
        if (searchFilter.isUnaryFilter()) {
            return;
        }


        String entityProperty = searchFilter.getFieldName();

        Object value = searchFilter.getValue();

        Object newValue = null;
        boolean isCollection = value instanceof Collection;
        boolean isArray = value != null && value.getClass().isArray();
        if (isCollection || isArray) {
            List<Object> list = Lists.newArrayList();
            if (isCollection) {
                list.addAll((Collection) value);
            } else {
                list = Lists.newArrayList(CollectionUtils.arrayToList(value));
            }
            int length = list.size();
            for (int i = 0; i < length; i++) {
                list.set(i, getConvertedValue(beanWrapper, searchProperty, entityProperty, list.get(i)));
            }
            newValue = list;
        } else {
            newValue = getConvertedValue(beanWrapper, searchProperty, entityProperty, value);
        }
        searchFilter.setValue(newValue);

    }


    private static Object getConvertedValue(
            final BeanWrapperImpl beanWrapper,
            final String searchProperty,
            final String entityProperty,
            final Object value) {

        Object newValue;
        try {

            beanWrapper.setPropertyValue(entityProperty, value);
            newValue = beanWrapper.getPropertyValue(entityProperty);
        } catch (InvalidPropertyException e) {
            throw new InvalidSearchPropertyException(searchProperty, entityProperty, e);
        } catch (Exception e) {
            throw new InvalidSearchValueException(searchProperty, entityProperty, value, e);
        }

        return newValue;
    }



}
