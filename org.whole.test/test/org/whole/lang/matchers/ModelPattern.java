package org.whole.lang.matchers;

import org.whole.lang.builders.IBuilderOperation;
import org.whole.lang.commons.builders.ICommonsBuilder;
import org.whole.lang.commons.reflect.CommonsLanguageKit;
import org.whole.lang.models.builders.IModelsBuilder;
import org.whole.lang.models.model.Model;
import org.whole.lang.models.reflect.ModelsLanguageKit;
import org.whole.lang.templates.AbstractTemplateFactory;

/**
 * @generator Whole
 */
public class ModelPattern extends AbstractTemplateFactory<Model> {
	public void apply(IBuilderOperation op) {
		IModelsBuilder b0 = (IModelsBuilder) op.wGetBuilder(ModelsLanguageKit.URI);
		ICommonsBuilder cb = (ICommonsBuilder) op.wGetBuilder(CommonsLanguageKit.URI);
		b0.Model_();
		b0.SimpleName("Model1");
		b0.TypeRelations();
		b0.ModelDeclarations_(3);
		b0.SimpleEntity_();
		b0.EntityModifiers();
		b0.SimpleName("Entity1");
		b0.Types();
		b0.Features_(1);
		b0.Feature_();
		b0.FeatureModifiers();
		cb.Variable("dataEntity", "http://lang.whole.org/Models#SimpleName", "MANDATORY");
		b0.SimpleName("data1");
		b0._Feature();
		b0._Features();
		b0._SimpleEntity();
		b0.DataEntity_();
		b0.EntityModifiers();
		cb.Variable("dataEntity", "http://lang.whole.org/Models#SimpleName", "MANDATORY");
		b0.Types();
		cb.Variable("dataType", "http://lang.whole.org/Models#DataType", "MANDATORY");
		b0._DataEntity();
		cb.Variable("modelDeclaration", "http://lang.whole.org/Models#ModelDeclaration", "ZERO_OR_MORE_GREEDY");
		b0._ModelDeclarations();
		b0._Model();
	}
}