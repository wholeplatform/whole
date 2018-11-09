package org.whole.lang.sql.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.sql.model.StoredProcedure;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.sql.reflect.SQLEntityDescriptorEnum;
import org.whole.lang.sql.visitors.ISQLVisitor;
import org.whole.lang.exceptions.IWholeRuntimeException;
import org.whole.lang.sql.model.Name;
import org.whole.lang.sql.reflect.SQLFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.sql.model.ProcedureDeclarations;
import org.whole.lang.sql.model.ProcedureStatements;

/** 
 * @generator Whole
 */
public class StoredProcedureImpl extends AbstractSimpleEntity implements StoredProcedure {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<StoredProcedure> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.StoredProcedure;
	}

	public int wGetEntityOrd() {
		return SQLEntityDescriptorEnum.StoredProcedure_ord;
	}

	public void accept(ISQLVisitor visitor) {
		try {
			visitor.visit(this);
		} catch (Exception e) {
			throw IWholeRuntimeException.asWholeException(e, this, visitor.getBindings());
		}
	}

	public int wHashCode() {
		return getName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getName().wEquals(entity.wGet(SQLFeatureDescriptorEnum.name));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("name=");
		buffer.append(name);
	}

	private Name name;

	public Name getName() {
		return notifyRequested(SQLFeatureDescriptorEnum.name, name);
	}

	public void setName(Name name) {
		notifyChanged(SQLFeatureDescriptorEnum.name, this.name, this.name = name);
	}

	private ProcedureDeclarations procedureDeclarations;

	public ProcedureDeclarations getProcedureDeclarations() {
		return notifyRequested(SQLFeatureDescriptorEnum.procedureDeclarations, procedureDeclarations);
	}

	public void setProcedureDeclarations(ProcedureDeclarations procedureDeclarations) {
		notifyChanged(SQLFeatureDescriptorEnum.procedureDeclarations, this.procedureDeclarations,
				this.procedureDeclarations = procedureDeclarations);
	}

	private ProcedureStatements procedureStatements;

	public ProcedureStatements getProcedureStatements() {
		return notifyRequested(SQLFeatureDescriptorEnum.procedureStatements, procedureStatements);
	}

	public void setProcedureStatements(ProcedureStatements procedureStatements) {
		notifyChanged(SQLFeatureDescriptorEnum.procedureStatements, this.procedureStatements,
				this.procedureStatements = procedureStatements);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getName().wGetAdaptee(false);
		case 1:
			return getProcedureDeclarations().wGetAdaptee(false);
		case 2:
			return getProcedureStatements().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setName(value.wGetAdapter(SQLEntityDescriptorEnum.Name));
			break;
		case 1:
			setProcedureDeclarations(value.wGetAdapter(SQLEntityDescriptorEnum.ProcedureDeclarations));
			break;
		case 2:
			setProcedureStatements(value.wGetAdapter(SQLEntityDescriptorEnum.ProcedureStatements));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
