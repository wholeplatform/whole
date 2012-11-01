package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ComprehensionBlockAdapter extends AbstractEntityAdapter implements
		ComprehensionBlock {
	private static final long serialVersionUID = 1;

	public ComprehensionBlockAdapter(IEntity implementor) {
		super(implementor);
	}

	public ComprehensionBlockAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ComprehensionBlock> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ComprehensionBlock;
	}

	public Expression getIterator() {
		return wGet(JavaScriptFeatureDescriptorEnum.iterator).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setIterator(Expression iterator) {
		wSet(JavaScriptFeatureDescriptorEnum.iterator, iterator);
	}

	public Expression getIterated() {
		return wGet(JavaScriptFeatureDescriptorEnum.iterated).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Expression);
	}

	public void setIterated(Expression iterated) {
		wSet(JavaScriptFeatureDescriptorEnum.iterated, iterated);
	}
}
