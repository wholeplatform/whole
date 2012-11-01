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
public class ForEachComprehensionBlockAdapter extends AbstractEntityAdapter
		implements ForEachComprehensionBlock {
	private static final long serialVersionUID = 1;

	public ForEachComprehensionBlockAdapter(IEntity implementor) {
		super(implementor);
	}

	public ForEachComprehensionBlockAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ForEachComprehensionBlock> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.ForEachComprehensionBlock;
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
