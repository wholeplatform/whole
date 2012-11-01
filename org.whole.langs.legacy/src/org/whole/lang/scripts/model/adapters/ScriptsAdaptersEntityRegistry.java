package org.whole.lang.scripts.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.scripts.reflect.ScriptsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ScriptsAdaptersEntityRegistry extends AbstractEntityRegistry {
	public ScriptsAdaptersEntityRegistry() {
		super(ScriptsEntityDescriptorEnum.instance);
	}

	protected void createPrototypes() {
		put(new ScriptAdapter());
		put(new LanguageNameAdapter());
		put(new SourceAdapter());
	}
}
