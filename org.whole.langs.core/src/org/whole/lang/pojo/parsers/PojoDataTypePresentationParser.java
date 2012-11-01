package org.whole.lang.pojo.parsers;

import org.whole.lang.model.EnumValue;
import org.whole.lang.parsers.DefaultDataTypePresentationParser;
import org.whole.lang.pojo.reflect.PojoEntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;

public class PojoDataTypePresentationParser extends DefaultDataTypePresentationParser {
	private static final PojoDataTypePresentationParser instance = new PojoDataTypePresentationParser();
	public static PojoDataTypePresentationParser instance() {
		return instance;
	}
	protected PojoDataTypePresentationParser() {
	}

	public String unparseEnumValue(EntityDescriptor<?> ed, EnumValue value) {
		if (PojoEntityDescriptorEnum.PrimitiveType.equals(ed))
			return value.toString();
		else
			return super.unparseEnumValue(ed, value);
	}

}
