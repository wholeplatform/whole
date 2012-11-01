package org.whole.lang.text.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TextImplEntityRegistry extends AbstractEntityRegistry {
	public TextImplEntityRegistry() {
		super(TextEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new DocumentImpl());
		put(new IndentImpl());
		put(new RowSeparatorImpl());
		put(new TextSeparatorImpl());
		put(new RowImpl());
		put(new TextImpl());
	}
}
