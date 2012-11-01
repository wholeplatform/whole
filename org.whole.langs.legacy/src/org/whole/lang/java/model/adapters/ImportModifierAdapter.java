package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ImportModifierAdapter extends AbstractEntityAdapter implements
		ImportModifier {
	private static final long serialVersionUID = 1;

	public ImportModifierAdapter(IEntity implementor) {
		super(implementor);
	}

	public ImportModifierAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ImportModifier> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ImportModifier;
	}

	public boolean isValue() {
		return wBooleanValue();
	}

	public void setValue(boolean value) {
		wSetValue(value);
	}
}
