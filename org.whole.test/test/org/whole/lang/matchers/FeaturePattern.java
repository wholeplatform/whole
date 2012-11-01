package org.whole.lang.matchers;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.models.builders.IModelsBuilder;
import org.whole.lang.models.model.Feature;
import org.whole.lang.models.reflect.ModelsLanguageKit;
import org.whole.lang.templates.AbstractTemplateFactory;

/**
 * @generator Whole
 */
public class FeaturePattern extends AbstractTemplateFactory<Feature> {
	public void apply(IBuilderOperation op) {
		IModelsBuilder b0 = (IModelsBuilder) op.wGetBuilder(ModelsLanguageKit.URI);
		ICommonsBuilder cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
		b0.Feature_();
		b0.FeatureModifiers();
		cb.Variable("featureType", "http://lang.whole.org/Models#SimpleName", "MANDATORY");
		cb.Variable("featureName", "http://lang.whole.org/Models#SimpleName", "MANDATORY");
		b0._Feature();
	}
}