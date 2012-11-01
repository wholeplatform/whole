package org.whole.lang.scripts.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.scripts.reflect.ScriptsFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scripts.reflect.ScriptsEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ScriptsGenericBuilderAdapter extends GenericIdentityBuilder {
	private IScriptsBuilder specificBuilder;

	public ScriptsGenericBuilderAdapter(IScriptsBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public ScriptsGenericBuilderAdapter(IScriptsBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case ScriptsFeatureDescriptorEnum.languageName_ord:
			specificBuilder.languageName();
			break;
		case ScriptsFeatureDescriptorEnum.source_ord:
			specificBuilder.source();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case ScriptsEntityDescriptorEnum.Script_ord:
			specificBuilder.Script();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case ScriptsEntityDescriptorEnum.Script_ord:
			specificBuilder.Script_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case ScriptsEntityDescriptorEnum.Script_ord:
			specificBuilder._Script();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case ScriptsEntityDescriptorEnum.LanguageName_ord:
			specificBuilder.LanguageName(value);
			break;
		}
	}
}
