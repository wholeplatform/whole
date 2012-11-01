package org.whole.lang.scripts.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.scripts.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.scripts.visitors.IScriptsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scripts.reflect.ScriptsEntityDescriptorEnum;
import org.whole.lang.scripts.reflect.ScriptsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ScriptAdapter extends AbstractEntityAdapter implements Script {
	private static final long serialVersionUID = 1;

	public ScriptAdapter(IEntity implementor) {
		super(implementor);
	}

	public ScriptAdapter() {
	}

	public void accept(IScriptsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Script> wGetEntityDescriptor() {
		return ScriptsEntityDescriptorEnum.Script;
	}

	public LanguageName getLanguageName() {
		return wGet(ScriptsFeatureDescriptorEnum.languageName).wGetAdapter(
				ScriptsEntityDescriptorEnum.LanguageName);
	}

	public void setLanguageName(LanguageName languageName) {
		wSet(ScriptsFeatureDescriptorEnum.languageName, languageName);
	}

	public Source getSource() {
		return wGet(ScriptsFeatureDescriptorEnum.source).wGetAdapter(
				ScriptsEntityDescriptorEnum.Source);
	}

	public void setSource(Source source) {
		wSet(ScriptsFeatureDescriptorEnum.source, source);
	}
}
