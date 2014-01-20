package com.softexploration.lab.bankapp.ext.domain.search;

import java.util.List;

public interface SearchCriteria {

	List<SearchedAttribute> getAttributes();

	Integer getStart();

	Integer getMaxResult();
}
