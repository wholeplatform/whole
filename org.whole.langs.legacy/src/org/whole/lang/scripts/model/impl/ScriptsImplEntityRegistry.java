package org.whole.lang.scripts.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.scripts.reflect.ScriptsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ScriptsImplEntityRegistry extends AbstractEntityRegistry {
	public ScriptsImplEntityRegistry() {
		super(ScriptsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new ScriptImpl());
		put(new LanguageNameImpl());
	}
}
