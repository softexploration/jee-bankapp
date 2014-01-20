package com.softexploration.lab.bankapp.ext.domain.search;

public interface SearchedAttribute {

	String getAttributeName();

	Object getAttributeValue();

	SearchRealtionOperator getOperator();
}
