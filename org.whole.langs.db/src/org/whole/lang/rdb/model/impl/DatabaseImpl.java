package org.whole.lang.rdb.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.rdb.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.rdb.reflect.RDBEntityDescriptorEnum;
import org.whole.lang.rdb.visitors.IRDBVisitor;
import org.whole.lang.rdb.reflect.RDBFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class DatabaseImpl extends AbstractSimpleEntity implements Database {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<Database> wGetEntityDescriptor() {
		return RDBEntityDescriptorEnum.Database;
	}

	public int wGetEntityOrd() {
		return RDBEntityDescriptorEnum.Database_ord;
	}

	public void accept(IRDBVisitor visitor) {
		visitor.visit(this);
	}

	private URI uri;

	public URI getUri() {
		return notifyRequested(RDBFeatureDescriptorEnum.uri, uri);
	}

	public void setUri(URI uri) {
		notifyChanged(RDBFeatureDescriptorEnum.uri, this.uri, this.uri = uri);
	}

	private Namespace namespace;

	public Namespace getNamespace() {
		return notifyRequested(RDBFeatureDescriptorEnum.namespace, namespace);
	}

	public void setNamespace(Namespace namespace) {
		notifyChanged(RDBFeatureDescriptorEnum.namespace, this.namespace,
				this.namespace = namespace);
	}

	private Schemas schemas;

	public Schemas getSchemas() {
		return notifyRequested(RDBFeatureDescriptorEnum.schemas, schemas);
	}

	public void setSchemas(Schemas schemas) {
		notifyChanged(RDBFeatureDescriptorEnum.schemas, this.schemas,
				this.schemas = schemas);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getUri().wGetAdaptee(false);
		case 1:
			return getNamespace().wGetAdaptee(false);
		case 2:
			return getSchemas().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setUri(value.wGetAdapter(RDBEntityDescriptorEnum.URI));
			break;
		case 1:
			setNamespace(value.wGetAdapter(RDBEntityDescriptorEnum.Namespace));
			break;
		case 2:
			setSchemas(value.wGetAdapter(RDBEntityDescriptorEnum.Schemas));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
