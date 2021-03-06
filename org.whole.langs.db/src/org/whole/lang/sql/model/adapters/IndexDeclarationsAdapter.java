package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractSetEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class IndexDeclarationsAdapter extends AbstractSetEntityAdapter<IndexDeclaration> implements IndexDeclarations {
	private static final long serialVersionUID = 1;

	public IndexDeclarationsAdapter(IEntity implementor) {
		super(implementor);
	}

	public IndexDeclarationsAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<IndexDeclarations> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.IndexDeclarations;
	}
}
