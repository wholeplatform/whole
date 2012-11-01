package org.whole.lang.scripts.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.scripts.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scripts.reflect.ScriptsEntityDescriptorEnum;
import org.whole.lang.scripts.visitors.IScriptsVisitor;
import org.whole.lang.scripts.reflect.ScriptsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ScriptImpl extends AbstractSimpleEntity implements Script {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Script> wGetEntityDescriptor() {
		return ScriptsEntityDescriptorEnum.Script;
	}

	public int wGetEntityOrd() {
		return ScriptsEntityDescriptorEnum.Script_ord;
	}

	public void accept(IScriptsVisitor visitor) {
		visitor.visit(this);
	}

	private LanguageName languageName;

	public LanguageName getLanguageName() {
		return notifyRequested(ScriptsFeatureDescriptorEnum.languageName,
				languageName);
	}

	public void setLanguageName(LanguageName languageName) {
		notifyChanged(ScriptsFeatureDescriptorEnum.languageName,
				this.languageName, this.languageName = languageName);
	}

	private Source source;

	public Source getSource() {
		return notifyRequested(ScriptsFeatureDescriptorEnum.source, source);
	}

	public void setSource(Source source) {
		notifyChanged(ScriptsFeatureDescriptorEnum.source, this.source,
				this.source = source);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getLanguageName().wGetAdaptee(false);
		case 1:
			return getSource().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setLanguageName(value
					.wGetAdapter(ScriptsEntityDescriptorEnum.LanguageName));
			break;
		case 1:
			setSource(value.wGetAdapter(ScriptsEntityDescriptorEnum.Source));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 2;
	}
}
