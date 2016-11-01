package com.digitalplay.network.ireader.common.search;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * <p>查询条件（包括分页和排序）</p>
 * <p>User: Zhang Kaitao
 * <p>Date: 13-1-15 上午7:29
 * <p>Version: 1.0
 */

public final class SearchRequest  {

    private final Map<String, SearchFilter> searchFilterMap = Maps.newHashMap();
    /**
     * 使用这个的目的是保证拼sql的顺序是按照添加时的顺序
     */
    private final List<SearchFilter> searchFilters = Lists.newArrayList();

    private Pageable page;

    private Sort sort;

    private boolean converted;

    /**
     * @param searchParams
     * @see SearchRequest#SearchRequest(java.util.Map<java.lang.String,java.lang.Object>)
     */
    public SearchRequest(final Map<String, Object> searchParams) {
        this(searchParams, null, null);
    }

    public SearchRequest() {
        this(null, null, null);
    }

    public SearchRequest(final Map<String, Object> searchParams, final Pageable page) {
        this(searchParams, page, null);
    }

    public SearchRequest(final Map<String, Object> searchParams, final Sort sort) throws SearchException {
        this(searchParams, null, sort);
    }

    public SearchRequest(final Map<String, Object> searchParams, final Pageable page, final Sort sort)
            throws SearchException {

        toSearchFilters(searchParams);

        merge(sort, page);
    }


    private void toSearchFilters(final Map<String, Object> searchParams) throws SearchException {
        if (searchParams == null || searchParams.size() == 0) {
            return;
        }
        for (Map.Entry<String, Object> entry : searchParams.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            addSearchFilter(SearchFilter.newSearchFilter(key, value));
        }
    }


    public SearchRequest addSearchParam(final String key, final Object value) throws SearchException {
    	addSearchFilter(SearchFilter.newSearchFilter(key, value));
        return this;
    }

    public SearchRequest addSearchParams(Map<String, Object> searchParams) throws SearchException {
        toSearchFilters(searchParams);
        return this;
    }


    public SearchRequest addSearchFilter(final String searchProperty, final SearchOperator operator, final Object value) {
        SearchFilter searchFilter = SearchFilter.newSearchFilter(searchProperty, operator, value);
        return addSearchFilter(searchFilter);
    }

    public SearchRequest addSearchFilter(SearchFilter searchFilter) {
        if (searchFilter == null) {
            return this;
        }
        searchFilterMap.put(searchFilter.getKey(), searchFilter);
        int index = searchFilters.indexOf(searchFilter);
        if(index != -1) {
            searchFilters.set(index, searchFilter);
        } else {
            searchFilters.add(searchFilter);
        }
        return this;

    }


    public SearchRequest addSearchFilters(Collection<? extends SearchFilter> searchFilters) {
        if (CollectionUtils.isEmpty(searchFilters)) {
            return this;
        }
        for (SearchFilter searchFilter : searchFilters) {
            addSearchFilter(searchFilter);
        }
        return this;
    }



    public SearchRequest removeSearchFilter(final String searchProperty, final SearchOperator operator) {
        this.removeSearchFilter(searchProperty + SearchFilter.separator + operator);
        return this;
    }
    public SearchRequest removeSearchFilter(final String key) {
        if (key == null) {
            return this;
        }

        SearchFilter searchFilter = searchFilterMap.remove(key);

        if (searchFilter == null) {
            searchFilter = searchFilterMap.remove(getCustomKey(key));
        }

        if (searchFilter == null) {
            return this;
        }

        searchFilters.remove(searchFilter);

        return this;
    }

    private String getCustomKey(String key) {
        return key + SearchFilter.separator + SearchOperator.custom;
    }

    public SearchRequest setPage(final Pageable page) {
        merge(sort, page);
        return this;
    }

    public SearchRequest setPage(int pageNumber, int pageSize) {
        merge(sort, new PageRequest(pageNumber, pageSize));
        return this;
    }

    public SearchRequest addSort(final Sort sort) {
        merge(sort, page);
        return this;
    }

    public SearchRequest addSort(final Sort.Direction direction, final String property) {
        merge(new Sort(direction, property), page);
        return this;
    }


    public <T> SearchRequest convert(final Class<T> entityClass) {
        SearchableConvertUtils.convertSearchValueToEntityValue(this, entityClass);
        markConverted();
        return this;
    }


    public  <T> Specification<T> bySearchFilter( final Class<T> entityClazz) {
    	return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (hasSearchFilter()){
					List<Predicate> predicates = Lists.newArrayList();
					final Collection<SearchFilter> filters = getSearchFilters();
					for (SearchFilter filter : filters) {
						// nested path translate, 如Task的名为"user.name"的filedName, 转换为Task.user.name属性
						String[] names = StringUtils.split(filter.getFieldName(), ".");
						Path expression = root.get(names[0]);
						for (int i = 1; i < names.length; i++) {
							expression = expression.get(names[i]);
						}

						// logic operator
						switch (filter.getOperator()) {
						case eq:
							predicates.add(builder.equal(expression, filter.getValue()));
							break;
						case like:
							predicates.add(builder.like(expression, "%" + filter.getValue() + "%"));
							break;
						case gt:
							predicates.add(builder.greaterThan(expression, (Comparable) filter.getValue()));
							break;
						case lt:
							predicates.add(builder.lessThan(expression, (Comparable) filter.getValue()));
							break;
						case gte:
							predicates.add(builder.greaterThanOrEqualTo(expression, (Comparable) filter.getValue()));
							break;
						case lte:
							predicates.add(builder.lessThanOrEqualTo(expression, (Comparable) filter.getValue()));
							break;
						}
					}

					// 将所有条件用 and 联合起来
					if (!predicates.isEmpty()) {
						return builder.and(predicates.toArray(new Predicate[predicates.size()]));
					}
				}

				return builder.conjunction();
			}
		};
    }
    public SearchRequest markConverted() {
        this.converted = true;
        return this;
    }


    public Collection<SearchFilter> getSearchFilters() {
        return Collections.unmodifiableCollection(searchFilters);
    }

    public boolean isConverted() {
        return converted;
    }

    public boolean hasSearchFilter() {
        return searchFilters.size() > 0;
    }

    public boolean hashSort() {
        return this.sort != null && this.sort.iterator().hasNext();
    }

    public boolean hasPageable() {
        return this.page != null && this.page.getPageSize() > 0;
    }

    public void removeSort() {
        this.sort = null;
        if (this.page != null) {
            this.page = new PageRequest(page.getPageNumber(), page.getPageSize(), null);
        }
    }

    public void removePageable() {
        this.page = null;
    }

    public Pageable getPage() {
        return page;
    }

    public Sort getSort() {
        return sort;
    }

    public boolean containsSearchKey(String key) {
        boolean contains =
                searchFilterMap.containsKey(key) ||
                        searchFilterMap.containsKey(getCustomKey(key));

        if(contains) {
            return true;
        }

        //否则检查其中的or 和 and
        return containsSearchKey(searchFilters, key);
    }

    private boolean containsSearchKey(List<SearchFilter> searchFilters, String key) {
        boolean contains = false;
        for(SearchFilter searchFilter : searchFilters) {
                contains = searchFilter.getKey().equals(key) || searchFilter.getFieldName().equals(key);
                if(contains) {
                    return true;
                }
            }
        return contains;
    }

    public Object getValue(String key) {
        SearchFilter searchFilter = searchFilterMap.get(key);
        if (searchFilter == null) {
            searchFilter = searchFilterMap.get(getCustomKey(key));
        }
        if (searchFilter == null) {
            return null;
        }
            return searchFilter.getValue();
    }


    private void merge(Sort sort, Pageable page) {
        if (sort == null) {
            sort = this.sort;
        }
        if (page == null) {
            page = this.page;
        }

        //合并排序
        if (sort == null) {
            this.sort = page != null ? page.getSort() : null;
        } else {
            this.sort = (page != null ? sort.and(page.getSort()) : sort);
        }
        //把排序合并到page中
        if (page != null) {
            this.page = new PageRequest(page.getPageNumber(), page.getPageSize(), this.sort);
        } else {
            this.page = null;
        }
    }


    @Override
    public String toString() {
        return "SearchRequest{" +
                "searchFilterMap=" + searchFilterMap +
                ", page=" + page +
                ", sort=" + sort +
                '}';
    }
}
