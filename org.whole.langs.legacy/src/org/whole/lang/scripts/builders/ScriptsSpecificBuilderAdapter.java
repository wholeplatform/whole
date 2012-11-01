package org.whole.lang.scripts.builders;

import org.whole.lang.builders.GenericBuilderContext;
import org.whole.lang.builders.IBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.scripts.reflect.ScriptsFeatureDescriptorEnum;
import org.whole.lang.scripts.reflect.ScriptsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ScriptsSpecificBuilderAdapter extends GenericBuilderContext
		implements IScriptsBuilder {
	public ScriptsSpecificBuilderAdapter(IBuilder strategy) {
		super(strategy);
	}

	public ScriptsSpecificBuilderAdapter(IBuilder strategy,
			IEntityContext entityContext) {
		super(strategy, entityContext);
	}

	public void source() {
		wFeature(ScriptsFeatureDescriptorEnum.source);
	}

	public void languageName() {
		wFeature(ScriptsFeatureDescriptorEnum.languageName);
	}

	public void visit() {
	}

	public void Script() {
		wEntity(ScriptsEntityDescriptorEnum.Script);
	}

	public void Script_() {
		wEntity_(ScriptsEntityDescriptorEnum.Script);
	}

	public void _Script() {
		_wEntity(ScriptsEntityDescriptorEnum.Script);
	}

	public void LanguageName() {
		wEntity(ScriptsEntityDescriptorEnum.LanguageName);
	}

	public void LanguageName(String value) {
		wEntity(ScriptsEntityDescriptorEnum.LanguageName, value);
	}
}
