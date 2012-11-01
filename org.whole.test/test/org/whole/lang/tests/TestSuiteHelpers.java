package org.whole.lang.tests;

import org.whole.lang.model.IEntity;

public class TestSuiteHelpers {
	public static void extractSubString(IEntity value) {
		value.wSetValue(value.wStringValue().substring(5));
	}
}
