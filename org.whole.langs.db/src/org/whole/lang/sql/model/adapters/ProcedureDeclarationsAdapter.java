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
public class ProcedureDeclarationsAdapter extends AbstractSetEntityAdapter<ProcedureDeclaration>
		implements ProcedureDeclarations {
	private static final long serialVersionUID = 1;

	public ProcedureDeclarationsAdapter(IEntity implementor) {
		super(implementor);
	}

	public ProcedureDeclarationsAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<ProcedureDeclarations> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.ProcedureDeclarations;
	}
}
