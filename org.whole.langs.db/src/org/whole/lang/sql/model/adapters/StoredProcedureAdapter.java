package org.whole.lang.sql.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.sql.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class StoredProcedureAdapter extends AbstractEntityAdapter implements StoredProcedure {
	private static final long serialVersionUID = 1;

	public StoredProcedureAdapter(IEntity implementor) {
		super(implementor);
	}

	public StoredProcedureAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<StoredProcedure> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.StoredProcedure;
	}

	public Name getName() {
		return wGet(SQLFeatureDescriptorEnum.name).wGetAdapter(SQLEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(SQLFeatureDescriptorEnum.name, name);
	}

	public ProcedureDeclarations getProcedureDeclarations() {
		return wGet(SQLFeatureDescriptorEnum.procedureDeclarations)
				.wGetAdapter(SQLEntityDescriptorEnum.ProcedureDeclarations);
	}

	public void setProcedureDeclarations(ProcedureDeclarations procedureDeclarations) {
		wSet(SQLFeatureDescriptorEnum.procedureDeclarations, procedureDeclarations);
	}

	public ProcedureStatements getProcedureStatements() {
		return wGet(SQLFeatureDescriptorEnum.procedureStatements)
				.wGetAdapter(SQLEntityDescriptorEnum.ProcedureStatements);
	}

	public void setProcedureStatements(ProcedureStatements procedureStatements) {
		wSet(SQLFeatureDescriptorEnum.procedureStatements, procedureStatements);
	}
}
