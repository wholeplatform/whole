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
public class DBConfigurationImpl extends AbstractSimpleEntity implements
		DBConfiguration {
	private static final long serialVersionUID = 1;

	public EntityDescriptor<DBConfiguration> wGetEntityDescriptor() {
		return DBCFGEntityDescriptorEnum.DBConfiguration;
	}

	public int wGetEntityOrd() {
		return DBCFGEntityDescriptorEnum.DBConfiguration_ord;
	}

	public void accept(IDBCFGVisitor visitor) {
		visitor.visit(this);
	}

	private JDBCDrivers drivers;

	public JDBCDrivers getDrivers() {
		return notifyRequested(DBCFGFeatureDescriptorEnum.drivers, drivers);
	}

	public void setDrivers(JDBCDrivers drivers) {
		notifyChanged(DBCFGFeatureDescriptorEnum.drivers, this.drivers,
				this.drivers = drivers);
	}

	private DataSources dataSources;

	public DataSources getDataSources() {
		return notifyRequested(DBCFGFeatureDescriptorEnum.dataSources,
				dataSources);
	}

	public void setDataSources(DataSources dataSources) {
		notifyChanged(DBCFGFeatureDescriptorEnum.dataSources, this.dataSources,
				this.dataSources = dataSources);
	}

	private Index dataSourceIndex;

	public Index getDataSourceIndex() {
		return notifyRequested(DBCFGFeatureDescriptorEnum.dataSourceIndex,
				dataSourceIndex);
	}

	public void setDataSourceIndex(Index dataSourceIndex) {
		notifyChanged(DBCFGFeatureDescriptorEnum.dataSourceIndex,
				this.dataSourceIndex, this.dataSourceIndex = dataSourceIndex);
	}

	public IEntity wGet(int index) {
		switch (index) {
		case 0:
			return getDrivers().wGetAdaptee(false);
		case 1:
			return getDataSources().wGetAdaptee(false);
		case 2:
			return getDataSourceIndex().wGetAdaptee(false);
		default:
			throw new IllegalArgumentException();
		}
	}

	public void wSet(int index, IEntity value) {
		switch (index) {
		case 0:
			setDrivers(value.wGetAdapter(DBCFGEntityDescriptorEnum.JDBCDrivers));
			break;
		case 1:
			setDataSources(value
					.wGetAdapter(DBCFGEntityDescriptorEnum.DataSources));
			break;
		case 2:
			setDataSourceIndex(value
					.wGetAdapter(DBCFGEntityDescriptorEnum.Index));
			break;
		default:
			throw new IllegalArgumentException();
		}
	}

	public int wSize() {
		return 3;
	}
}
