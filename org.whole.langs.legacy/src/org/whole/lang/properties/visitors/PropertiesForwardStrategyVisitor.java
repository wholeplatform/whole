package org.whole.lang.properties.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.properties.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class PropertiesForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IPropertiesVisitor> implements
		IPropertiesVisitor {
	public PropertiesForwardStrategyVisitor() {
		this(new PropertiesIdentityVisitor());
	}

	public PropertiesForwardStrategyVisitor(
			IPropertiesVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IPropertiesEntity) entity).accept(this);
	}

	public void visit(Properties entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Entries entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Property entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Comment entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PropertyName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PropertyValue entity) {
		wGetStrategy().visit(entity);
	}
}
