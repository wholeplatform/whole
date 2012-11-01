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
public class CreateAdapter extends AbstractEntityAdapter implements Create {
	private static final long serialVersionUID = 1;

	public CreateAdapter(IEntity implementor) {
		super(implementor);
	}

	public CreateAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Create> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Create;
	}

	public TableName getTableName() {
		return wGet(SQLFeatureDescriptorEnum.tableName).wGetAdapter(
				SQLEntityDescriptorEnum.TableName);
	}

	public void setTableName(TableName tableName) {
		wSet(SQLFeatureDescriptorEnum.tableName, tableName);
	}

	public DeclarationOrConstraints getDeclarationOrConstraints() {
		return wGet(SQLFeatureDescriptorEnum.declarationOrConstraints)
				.wGetAdapter(SQLEntityDescriptorEnum.DeclarationOrConstraints);
	}

	public void setDeclarationOrConstraints(
			DeclarationOrConstraints declarationOrConstraints) {
		wSet(SQLFeatureDescriptorEnum.declarationOrConstraints,
				declarationOrConstraints);
	}
}
