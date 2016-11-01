package com.digitalplay.network.ireader.common.search;


import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

import com.google.common.collect.Lists;

public class DynamicSpecifications {

	
	public static <T> Specification<T> bySearchFilter(final SearchRequest searchRequest, final Class<T> entityClazz) {
		return new Specification<T>() {
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
				if (searchRequest.hasSearchFilter()){
					List<Predicate> predicates = Lists.newArrayList();
					final Collection<SearchFilter> filters = searchRequest.getSearchFilters();
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
}