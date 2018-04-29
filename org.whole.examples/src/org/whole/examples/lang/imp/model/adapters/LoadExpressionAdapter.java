package org.whole.examples.lang.imp.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.examples.lang.imp.model.*;
import org.whole.lang.model.IEntity;
import org.whole.examples.lang.imp.visitors.IImpVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.examples.lang.imp.reflect.ImpEntityDescriptorEnum;
import org.whole.examples.lang.imp.reflect.ImpFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class LoadExpressionAdapter extends AbstractEntityAdapter implements LoadExpression {
	private static final long serialVersionUID = 1;

	public LoadExpressionAdapter(IEntity implementor) {
		super(implementor);
	}

	public LoadExpressionAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<LoadExpression> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.LoadExpression;
	}

	public Expression getFileName() {
		return wGet(ImpFeatureDescriptorEnum.fileName).wGetAdapter(ImpEntityDescriptorEnum.Expression);
	}

	public void setFileName(Expression fileName) {
		wSet(ImpFeatureDescriptorEnum.fileName, fileName);
	}

	public Expression getLanguage() {
		return wGet(ImpFeatureDescriptorEnum.language).wGetAdapter(ImpEntityDescriptorEnum.Expression);
	}

	public void setLanguage(Expression language) {
		wSet(ImpFeatureDescriptorEnum.language, language);
	}
}
