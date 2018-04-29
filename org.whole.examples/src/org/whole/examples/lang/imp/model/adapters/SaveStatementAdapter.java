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
public class SaveStatementAdapter extends AbstractEntityAdapter implements SaveStatement {
	private static final long serialVersionUID = 1;

	public SaveStatementAdapter(IEntity implementor) {
		super(implementor);
	}

	public SaveStatementAdapter() {
	}

	public void accept(IImpVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<SaveStatement> wGetEntityDescriptor() {
		return ImpEntityDescriptorEnum.SaveStatement;
	}

	public Expression getExp() {
		return wGet(ImpFeatureDescriptorEnum.exp).wGetAdapter(ImpEntityDescriptorEnum.Expression);
	}

	public void setExp(Expression exp) {
		wSet(ImpFeatureDescriptorEnum.exp, exp);
	}

	public Expression getFileName() {
		return wGet(ImpFeatureDescriptorEnum.fileName).wGetAdapter(ImpEntityDescriptorEnum.Expression);
	}

	public void setFileName(Expression fileName) {
		wSet(ImpFeatureDescriptorEnum.fileName, fileName);
	}
}
