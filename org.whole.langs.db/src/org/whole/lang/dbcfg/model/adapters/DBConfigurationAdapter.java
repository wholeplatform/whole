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
public class DBConfigurationAdapter extends AbstractEntityAdapter implements
		DBConfiguration {
	private static final long serialVersionUID = 1;

	public DBConfigurationAdapter(IEntity implementor) {
		super(implementor);
	}

	public DBConfigurationAdapter() {
	}

	public void accept(IDBCFGVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<DBConfiguration> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.DBConfiguration;
	}

	public JDBCDrivers getDrivers() {
		return wGet(DBCFGFeatureDescriptorEnum.drivers).wGetAdapter(
				DBCFGEntityDescriptorEnum.JDBCDrivers);
	}

	public void setDrivers(JDBCDrivers drivers) {
		wSet(DBCFGFeatureDescriptorEnum.drivers, drivers);
	}

	public DataSources getDataSources() {
		return wGet(DBCFGFeatureDescriptorEnum.dataSources).wGetAdapter(
				DBCFGEntityDescriptorEnum.DataSources);
	}

	public void setDataSources(DataSources dataSources) {
		wSet(DBCFGFeatureDescriptorEnum.dataSources, dataSources);
	}

	public Index getDataSourceIndex() {
		return wGet(DBCFGFeatureDescriptorEnum.dataSourceIndex).wGetAdapter(
				DBCFGEntityDescriptorEnum.Index);
	}

	public void setDataSourceIndex(Index dataSourceIndex) {
		wSet(DBCFGFeatureDescriptorEnum.dataSourceIndex, dataSourceIndex);
	}
}
