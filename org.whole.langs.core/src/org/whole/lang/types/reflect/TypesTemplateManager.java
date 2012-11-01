package org.whole.lang.types.reflect;

import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.types.model.TypeSystem;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class TypesTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final TypesTemplateManager instance = new TypesTemplateManager();
	}

	public static TypesTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private TypesTemplateManager() {
		put("empty", new AbstractTemplateFactory<TypeSystem>() {
			public TypeSystem create() {
				return GenericEntityFactory.instance
						.create(TypesEntityDescriptorEnum.TypeSystem);
			}
		});
	}
}
