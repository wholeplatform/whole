package org.whole.lang.java.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.java.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.java.visitors.IJavaVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ImportDeclarationsAdapter extends
		AbstractListEntityAdapter<ImportDeclaration> implements
		ImportDeclarations {
	private static final long serialVersionUID = 1;

	public ImportDeclarationsAdapter(IEntity implementor) {
		super(implementor);
	}

	public ImportDeclarationsAdapter() {
	}

	public void accept(IJavaVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ImportDeclarations> wGetEntityDescriptor() {
		return JavaEntityDescriptorEnum.ImportDeclarations;
	}
}
