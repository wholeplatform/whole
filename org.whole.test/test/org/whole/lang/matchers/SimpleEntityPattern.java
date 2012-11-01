package org.whole.lang.matchers;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.models.builders.IModelsBuilder;
import org.whole.lang.models.model.SimpleEntity;
import org.whole.lang.models.reflect.ModelsLanguageKit;
import org.whole.lang.templates.AbstractTemplateFactory;

/**
 * @generator Whole
 */
public class SimpleEntityPattern extends AbstractTemplateFactory<SimpleEntity> {
	public void apply(IBuilderOperation op) {
		IModelsBuilder b0 = (IModelsBuilder) op.wGetBuilder(ModelsLanguageKit.URI);
		ICommonsBuilder cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
		b0.SimpleEntity_();
		b0.EntityModifiers();
		cb.Variable("entityName", "http://lang.whole.org/Models#SimpleName", "MANDATORY");
		b0.Types_();
		cb.Variable("type", "http://lang.whole.org/Models#SimpleName", "ZERO_OR_MORE_GREEDY");
		b0._Types();
		b0.Features_();
		cb.Variable("feature", "http://lang.whole.org/Models#Feature", "ZERO_OR_MORE_GREEDY");
		b0._Features();
		b0._SimpleEntity();
	}
}