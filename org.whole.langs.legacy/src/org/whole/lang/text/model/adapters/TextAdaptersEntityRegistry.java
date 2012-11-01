package org.whole.lang.text.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.text.reflect.TextEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class TextAdaptersEntityRegistry extends AbstractEntityRegistry {
	public TextAdaptersEntityRegistry() {
		super(TextEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new DocumentAdapter());
		put(new IndentAdapter());
		put(new RowSeparatorAdapter());
		put(new TextSeparatorAdapter());
		put(new RowAdapter());
		put(new TextAdapter());
		put(new ITextAdapter());
		put(new IRowAdapter());
	}
}
