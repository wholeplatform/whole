package org.whole.lang.rdb.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.rdb.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.reflect.RDBFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class DatabaseAdapter extends AbstractEntityAdapter implements Database {
	private static final long serialVersionUID = 1;

	public DatabaseAdapter(IEntity implementor) {
		super(implementor);
	}

	public DatabaseAdapter() {
	}

	public void accept(IRDBVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Database> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Database;
	}

	public URI getUri() {
		return wGet(RDBFeatureDescriptorEnum.uri).wGetAdapter(
				RDBEntityDescriptorEnum.URI);
	}

	public void setUri(URI uri) {
		wSet(RDBFeatureDescriptorEnum.uri, uri);
	}

	public Namespace getNamespace() {
		return wGet(RDBFeatureDescriptorEnum.namespace).wGetAdapter(
				RDBEntityDescriptorEnum.Namespace);
	}

	public void setNamespace(Namespace namespace) {
		wSet(RDBFeatureDescriptorEnum.namespace, namespace);
	}

	public Schemas getSchemas() {
		return wGet(RDBFeatureDescriptorEnum.schemas).wGetAdapter(
				RDBEntityDescriptorEnum.Schemas);
	}

	public void setSchemas(Schemas schemas) {
		wSet(RDBFeatureDescriptorEnum.schemas, schemas);
	}
}
