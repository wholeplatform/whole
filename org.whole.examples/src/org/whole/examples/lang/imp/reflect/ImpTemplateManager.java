package org.whole.examples.lang.imp.reflect;

import org.whole.examples.lang.imp.codebase.Factorial;
import org.whole.examples.lang.imp.codebase.FunctionParam;
import org.whole.examples.lang.imp.codebase.MetaProgram;
import org.whole.examples.lang.imp.model.FunctionDeclaration;
import org.whole.lang.templates.AbstractTemplateManager;
import org.whole.lang.templates.AbstractTemplateFactory;
import org.whole.lang.factories.GenericEntityFactory;

/** 
 * @generator Whole
 */
public class ImpTemplateManager extends AbstractTemplateManager {
	private static class SingletonHolder {
		private static final ImpTemplateManager instance = new ImpTemplateManager();
	}

	public static ImpTemplateManager instance() {
		return SingletonHolder.instance;
	}

	private ImpTemplateManager() {
		put("empty", new AbstractTemplateFactory<FunctionDeclaration>() {
			public FunctionDeclaration create() {
				return GenericEntityFactory.instance.create(ImpEntityDescriptorEnum.FunctionDeclaration);
			}
		});
		
		put("factorial", new Factorial());
		put("function as param", new FunctionParam());
		put("meta program exec", new MetaProgram());

	}
}