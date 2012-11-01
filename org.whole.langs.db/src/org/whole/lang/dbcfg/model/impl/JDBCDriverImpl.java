package org.whole.lang.dbcfg.model.impl;

import org.whole.lang.model.AbstractSimpleEntity;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.dbcfg.reflect.DBCFGFeatureDescriptorEnum;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class JDBCDriverImpl extends AbstractSimpleEntity implements JDBCDriver {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<JDBCDriver> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.JDBCDriver;
	}

	public int wGetEntityOrd() {
		return DBCFGEntityDescriptorEnum.JDBCDriver_ord;
	}

	public void accept(IDBCFGVisitor visitor) {
		visitor.visit(this);
	}

	public int wHashCode() {
		return getDriverName().wHashCode();
	}

	public boolean wEquals(IEntity entity) {
		if (this == entity)
			return true;
		if (!wGetEntityDescriptor().equals(entity.wGetEntityDescriptor()))
			return false;
		try {
			return getDriverName().wEquals(
					entity.wGet(DBCFGFeatureDescriptorEnum.driverName));
		} catch (Exception e) {
			return false;
		}
	}

	protected void toString(StringBuffer buffer) {
		buffer.append("driverName=");
		buffer.append(driverName);
	}

	private DriverName driverName;

	public DriverName getDriverName() {
		return notifyRequested(DBCFGFeatureDescriptorEnum.driverName,
				driverName);
	}

	public void setDriverName(DriverName driverName) {
		notifyChanged(DBCFGFeatureDescriptorEnum.driverName, this.driverName,
				this.driverName = driverName);
	}

	private ClassName driverClassName;

	public ClassName getDriverClassName() {
		return notifyRequested(DBCFGFeatureDescriptorEnum.driverClassName,
				driverClassName);
	}

	public void setDriverClassName(ClassName driverClassName) {
		notifyChanged(DBCFGFeatureDescriptorEnum.driverClassName,
				this.driverClassName, this.driverClassName = driverClassName);
	}

	private Files files;

	public Files getFiles() {
		return notifyRequested(DBCFGFeatureDescriptorEnum.files, files);
	}

	public void setFiles(Files files) {
		notifyChanged(DBCFGFeatureDescriptorEnum.files, this.files,
				this.files = files);
	}

	private Dialect dialect;

	public Dialect getDialect() {
		return notifyRequested(DBCFGFeatureDescriptorEnum.dialect, dialect);
	}

	public void setDialect(Dialect dialect) {
		notifyChanged(DBCFGFeatureDescriptorEnum.dialect, this.dialect,
				this.dialect = dialect);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getDriverName().wGetAdaptee(false);
		case 1:
			return getDriverClassName().wGetAdaptee(false);
		case 2:
			return getFiles().wGetAdaptee(false);
		case 3:
			return getDialect().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setDriverName(value
					.wGetAdapter(DBCFGEntityDescriptorEnum.DriverName));
			break;
		case 1:
			setDriverClassName(value
					.wGetAdapter(DBCFGEntityDescriptorEnum.ClassName));
			break;
		case 2:
			setFiles(value.wGetAdapter(DBCFGEntityDescriptorEnum.Files));
			break;
		case 3:
			setDialect(value.wGetAdapter(DBCFGEntityDescriptorEnum.Dialect));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 4;
	}
}
