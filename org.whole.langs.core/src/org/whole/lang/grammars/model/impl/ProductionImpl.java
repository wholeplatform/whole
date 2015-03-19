package org.whole.lang.grammars.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.grammars.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.grammars.reflect.GrammarsEntityDescriptorEnum;
import org.whole.lang.grammars.visitors.IGrammarsVisitor;
import org.whole.lang.grammars.reflect.GrammarsFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class ProductionImpl extends AbstractSimpleEntity implements Production {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Production> wGetEntityDescriptor() {
		return GrammarsEntityDescriptorEnum.Production;
	}

	public int wGetEntityOrd() {
		return GrammarsEntityDescriptorEnum.Production_ord;
	}

	public void accept(IGrammarsVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw org.whole.lang.exceptions.IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wHashCode() {
		return getName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getName().wEquals(
					entity.wGet(GrammarsFeatureDescriptorEnum.name));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("name=");
		buffer.append(name);
	}

	private NonTerminal name;

	public NonTerminal getName() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.name, name);
	}

	public void setName(NonTerminal name) {
		notifyChanged(GrammarsFeatureDescriptorEnum.name, this.name,
				this.name = name);
	}

	private Rule rule;

	public Rule getRule() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.rule, rule);
	}

	public void setRule(Rule rule) {
		notifyChanged(GrammarsFeatureDescriptorEnum.rule, this.rule,
				this.rule = rule);
	}

	private Template template;

	public Template getTemplate() {
		return notifyRequested(GrammarsFeatureDescriptorEnum.template, template);
	}

	public void setTemplate(Template template) {
		notifyChanged(GrammarsFeatureDescriptorEnum.template, this.template,
				this.template = template);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getRule().wGetAdaptee(false);
		case 2:
			return getTemplate().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(GrammarsEntityDescriptorEnum.NonTerminal));
			break;
		case 1:
			setRule(value.wGetAdapter(GrammarsEntityDescriptorEnum.Rule));
			break;
		case 2:
			setTemplate(value
					.wGetAdapter(GrammarsEntityDescriptorEnum.Template));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
