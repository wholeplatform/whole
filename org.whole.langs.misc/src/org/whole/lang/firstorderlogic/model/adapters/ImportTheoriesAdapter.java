package org.whole.lang.firstorderlogic.model.adapters;

import org.whole.lang.model.adapters.AbstractListEntityAdapter;
import org.whole.lang.firstorderlogic.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.firstorderlogic.visitors.IFirstOrderLogicVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.firstorderlogic.reflect.FirstOrderLogicEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ImportTheoriesAdapter extends
		AbstractListEntityAdapter<ImportDeclaration> implements ImportTheories {
	private static final long serialVersionUID = 1;

	public ImportTheoriesAdapter(IEntity implementor) {
		super(implementor);
	}

	public ImportTheoriesAdapter() {
	}

	public void accept(IFirstOrderLogicVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ImportTheories> wGetEntityDescriptor() {
		return FirstOrderLogicEntityDescriptorEnum.ImportTheories;
	}
}
