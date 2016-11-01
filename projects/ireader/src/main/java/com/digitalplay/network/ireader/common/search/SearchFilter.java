package com.digitalplay.network.ireader.common.search;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

public class SearchFilter {

	public static final String separator = "_";
	
	private String fieldName;
	private Object value;
	private SearchOperator operator;
    private  String key;

	public SearchFilter(String fieldName, SearchOperator operator, Object value) {
		this.fieldName = fieldName;
		this.value = value;
		this.operator = operator;
		 this.key = this.fieldName + separator + this.operator;
	}

	static SearchFilter newSearchFilter(final String key, final Object value) throws SearchException {

        Assert.notNull(key, "Condition key must not null");

        String[] searchs = StringUtils.split(key, separator);

        if (searchs.length == 0) {
            throw new SearchException("Condition key format must be : property or property_op");
        }

        String searchProperty = searchs[0];

        SearchOperator operator = null;
        if (searchs.length == 1) {
            operator = SearchOperator.custom;
        } else {
            try {
                operator = SearchOperator.valueOf(searchs[1]);
            } catch (IllegalArgumentException e) {
                throw new InvlidSearchOperatorException(searchProperty, searchs[1]);
            }
        }

        boolean allowBlankValue = SearchOperator.isAllowBlankValue(operator);
        boolean isValueBlank = (value == null);
        isValueBlank = isValueBlank || (value instanceof String && StringUtils.isBlank((String) value));
        isValueBlank = isValueBlank || (value instanceof List && ((List) value).size() == 0);
        //过滤掉空值，即不参与查询
        if (!allowBlankValue && isValueBlank) {
            return null;
        }

        SearchFilter searchFilter = newSearchFilter(searchProperty, operator, value);

        return searchFilter;
    }


    static SearchFilter newSearchFilter(final String searchProperty, final SearchOperator operator, final Object value) {
        return new SearchFilter(searchProperty, operator, value);
    }

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public SearchOperator getOperator() {
		return operator;
	}

	public void setOperator(SearchOperator operator) {
		this.operator = operator;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean isUnaryFilter() {
        String operatorStr = getOperator().getSymbol();
        return StringUtils.isNotEmpty(operatorStr) && operatorStr.startsWith("is");
    }
    
}
