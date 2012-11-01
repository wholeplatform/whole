package org.whole.lang.scripts.builders;

import org.whole.lang.contexts.EntityContext;
import org.whole.lang.model.IEntity;
import org.whole.lang.scripts.reflect.ScriptsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ScriptsModelContext extends EntityContext {
	public ScriptsModelContext(IEntity root) {
		super(root);
	}

	public ScriptsModelContext getLanguageName() {
		return (ScriptsModelContext) wGet(ScriptsFeatureDescriptorEnum.languageName);
	}

	public void setLanguageName(ScriptsModelContext languageName) {
		wSet(ScriptsFeatureDescriptorEnum.languageName, languageName);
	}

	public ScriptsModelContext getSource() {
		return (ScriptsModelContext) wGet(ScriptsFeatureDescriptorEnum.source);
	}

	public void setSource(ScriptsModelContext source) {
		wSet(ScriptsFeatureDescriptorEnum.source, source);
	}
}
