package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public class ProcedureDeclarationAdapter extends AbstractEntityAdapter implements ProcedureDeclaration {
	private static final long serialVersionUID = 1;

	public ProcedureDeclarationAdapter(IEntity implementor) {
		super(implementor);
	}

	public ProcedureDeclarationAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ProcedureDeclaration> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ProcedureDeclaration;
	}
}
