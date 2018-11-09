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
public class ForeachAdapter extends AbstractEntityAdapter implements Foreach {
	private static final long serialVersionUID = 1;

	public ForeachAdapter(IEntity implementor) {
		super(implementor);
	}

	public ForeachAdapter() {
	}

	public void accept(ISQLVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Foreach> wGetEntityDescriptor() {
		return SQLEntityDescriptorEnum.Foreach;
	}

	public Name getName() {
		return wGet(SQLFeatureDescriptorEnum.name).wGetAdapter(SQLEntityDescriptorEnum.Name);
	}

	public void setName(Name name) {
		wSet(SQLFeatureDescriptorEnum.name, name);
	}

	public ArrayExpr getArrayExp() {
		return wGet(SQLFeatureDescriptorEnum.arrayExp).wGetAdapter(SQLEntityDescriptorEnum.ArrayExpr);
	}

	public void setArrayExp(ArrayExpr arrayExp) {
		wSet(SQLFeatureDescriptorEnum.arrayExp, arrayExp);
	}

	public SQLStatement getTrueBody() {
		return wGet(SQLFeatureDescriptorEnum.trueBody).wGetAdapter(SQLEntityDescriptorEnum.SQLStatement);
	}

	public void setTrueBody(SQLStatement trueBody) {
		wSet(SQLFeatureDescriptorEnum.trueBody, trueBody);
	}
}
