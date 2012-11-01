package org.whole.lang.dbcfg.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;
import org.whole.lang.dbcfg.reflect.DBCFGFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class JDBCDriverAdapter extends AbstractEntityAdapter implements
		JDBCDriver {
	private static final long serialVersionUID = 1;

	public JDBCDriverAdapter(IEntity implementor) {
		super(implementor);
	}

	public JDBCDriverAdapter() {
	}

	public void accept(IDBCFGVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<JDBCDriver> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.JDBCDriver;
	}

	public DriverName getDriverName() {
		return wGet(DBCFGFeatureDescriptorEnum.driverName).wGetAdapter(
				DBCFGEntityDescriptorEnum.DriverName);
	}

	public void setDriverName(DriverName driverName) {
		wSet(DBCFGFeatureDescriptorEnum.driverName, driverName);
	}

	public ClassName getDriverClassName() {
		return wGet(DBCFGFeatureDescriptorEnum.driverClassName).wGetAdapter(
				DBCFGEntityDescriptorEnum.ClassName);
	}

	public void setDriverClassName(ClassName driverClassName) {
		wSet(DBCFGFeatureDescriptorEnum.driverClassName, driverClassName);
	}

	public Files getFiles() {
		return wGet(DBCFGFeatureDescriptorEnum.files).wGetAdapter(
				DBCFGEntityDescriptorEnum.Files);
	}

	public void setFiles(Files files) {
		wSet(DBCFGFeatureDescriptorEnum.files, files);
	}

	public Dialect getDialect() {
		return wGet(DBCFGFeatureDescriptorEnum.dialect).wGetAdapter(
				DBCFGEntityDescriptorEnum.Dialect);
	}

	public void setDialect(Dialect dialect) {
		wSet(DBCFGFeatureDescriptorEnum.dialect, dialect);
	}
}
