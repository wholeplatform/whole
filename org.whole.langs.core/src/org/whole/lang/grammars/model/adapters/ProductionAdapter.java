package org.whole.lang.grammars.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.grammars.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ProductionAdapter extends AbstractEntityAdapter implements
		Production {
	private static final long serialVersionUID = 1;

	public ProductionAdapter(IEntity implementor) {
		super(implementor);
	}

	public ProductionAdapter() {
	}

	public void accept(IGrammarsVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Production> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Production;
	}

	public NonTerminal getName() {
		return wGet(GrammarsFeatureDescriptorEnum.name).wGetAdapter(
				GrammarsEntityDescriptorEnum.NonTerminal);
	}

	public void setName(NonTerminal name) {
		wSet(GrammarsFeatureDescriptorEnum.name, name);
	}

	public Rule getRule() {
		return wGet(GrammarsFeatureDescriptorEnum.rule).wGetAdapter(
				GrammarsEntityDescriptorEnum.Rule);
	}

	public void setRule(Rule rule) {
		wSet(GrammarsFeatureDescriptorEnum.rule, rule);
	}

	public Template getTemplate() {
		return wGet(GrammarsFeatureDescriptorEnum.template).wGetAdapter(
				GrammarsEntityDescriptorEnum.Template);
	}

	public void setTemplate(Template template) {
		wSet(GrammarsFeatureDescriptorEnum.template, template);
	}
}
