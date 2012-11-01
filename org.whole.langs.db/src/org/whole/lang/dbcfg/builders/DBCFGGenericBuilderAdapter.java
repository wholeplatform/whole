package org.whole.lang.dbcfg.builders;

import org.whole.lang.builders.GenericIdentityBuilder;
import org.whole.lang.contexts.IEntityContext;
import org.whole.lang.reflect.FeatureDescriptor;
import org.whole.lang.dbcfg.reflect.DBCFGFeatureDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;
import org.whole.lang.model.EnumValue;
import org.whole.lang.dbcfg.model.DialectEnum.Value;

/** 
 * @generator Whole
 */
public class DBCFGGenericBuilderAdapter extends GenericIdentityBuilder {
	private IDBCFGBuilder specificBuilder;

	public DBCFGGenericBuilderAdapter(IDBCFGBuilder specificBuilder) {
		this.specificBuilder = specificBuilder;
	}

	public DBCFGGenericBuilderAdapter(IDBCFGBuilder specificBuilder,
			IEntityContext entityContext) {
		this(specificBuilder);
		wSetEntityContext(entityContext);
	}

	public void visit() {
	}

	public void wFeature(FeatureDescriptor featureDesc) {
		switch (featureDesc.getOrdinal()) {
		case DBCFGFeatureDescriptorEnum.drivers_ord:
			specificBuilder.drivers();
			break;
		case DBCFGFeatureDescriptorEnum.dataSources_ord:
			specificBuilder.dataSources();
			break;
		case DBCFGFeatureDescriptorEnum.dataSourceIndex_ord:
			specificBuilder.dataSourceIndex();
			break;
		case DBCFGFeatureDescriptorEnum.driverName_ord:
			specificBuilder.driverName();
			break;
		case DBCFGFeatureDescriptorEnum.driverClassName_ord:
			specificBuilder.driverClassName();
			break;
		case DBCFGFeatureDescriptorEnum.files_ord:
			specificBuilder.files();
			break;
		case DBCFGFeatureDescriptorEnum.dialect_ord:
			specificBuilder.dialect();
			break;
		case DBCFGFeatureDescriptorEnum.url_ord:
			specificBuilder.url();
			break;
		case DBCFGFeatureDescriptorEnum.serverName_ord:
			specificBuilder.serverName();
			break;
		case DBCFGFeatureDescriptorEnum.portNumber_ord:
			specificBuilder.portNumber();
			break;
		case DBCFGFeatureDescriptorEnum.databaseName_ord:
			specificBuilder.databaseName();
			break;
		case DBCFGFeatureDescriptorEnum.databaseSchema_ord:
			specificBuilder.databaseSchema();
			break;
		case DBCFGFeatureDescriptorEnum.userName_ord:
			specificBuilder.userName();
			break;
		case DBCFGFeatureDescriptorEnum.password_ord:
			specificBuilder.password();
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case DBCFGEntityDescriptorEnum.DBConfiguration_ord:
			specificBuilder.DBConfiguration();
			break;
		case DBCFGEntityDescriptorEnum.JDBCDrivers_ord:
			specificBuilder.JDBCDrivers();
			break;
		case DBCFGEntityDescriptorEnum.JDBCDriver_ord:
			specificBuilder.JDBCDriver();
			break;
		case DBCFGEntityDescriptorEnum.Files_ord:
			specificBuilder.Files();
			break;
		case DBCFGEntityDescriptorEnum.DataSources_ord:
			specificBuilder.DataSources();
			break;
		case DBCFGEntityDescriptorEnum.DataSource_ord:
			specificBuilder.DataSource();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case DBCFGEntityDescriptorEnum.DBConfiguration_ord:
			specificBuilder.DBConfiguration_();
			break;
		case DBCFGEntityDescriptorEnum.JDBCDrivers_ord:
			specificBuilder.JDBCDrivers_();
			break;
		case DBCFGEntityDescriptorEnum.JDBCDriver_ord:
			specificBuilder.JDBCDriver_();
			break;
		case DBCFGEntityDescriptorEnum.Files_ord:
			specificBuilder.Files_();
			break;
		case DBCFGEntityDescriptorEnum.DataSources_ord:
			specificBuilder.DataSources_();
			break;
		case DBCFGEntityDescriptorEnum.DataSource_ord:
			specificBuilder.DataSource_();
			break;
		}
	}

	public void _wEntity(EntityDescriptor<?> entityDesc) {
		switch (entityDesc.getOrdinal()) {
		case DBCFGEntityDescriptorEnum.DBConfiguration_ord:
			specificBuilder._DBConfiguration();
			break;
		case DBCFGEntityDescriptorEnum.JDBCDrivers_ord:
			specificBuilder._JDBCDrivers();
			break;
		case DBCFGEntityDescriptorEnum.JDBCDriver_ord:
			specificBuilder._JDBCDriver();
			break;
		case DBCFGEntityDescriptorEnum.Files_ord:
			specificBuilder._Files();
			break;
		case DBCFGEntityDescriptorEnum.DataSources_ord:
			specificBuilder._DataSources();
			break;
		case DBCFGEntityDescriptorEnum.DataSource_ord:
			specificBuilder._DataSource();
			break;
		}
	}

	public void wEntity_(EntityDescriptor<?> entityDesc, int initialCapacity) {
		switch (entityDesc.getOrdinal()) {
		case DBCFGEntityDescriptorEnum.JDBCDrivers_ord:
			specificBuilder.JDBCDrivers_(initialCapacity);
			break;
		case DBCFGEntityDescriptorEnum.Files_ord:
			specificBuilder.Files_(initialCapacity);
			break;
		case DBCFGEntityDescriptorEnum.DataSources_ord:
			specificBuilder.DataSources_(initialCapacity);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, int value) {
		switch (entityDesc.getOrdinal()) {
		case DBCFGEntityDescriptorEnum.Index_ord:
			specificBuilder.Index(value);
			break;
		case DBCFGEntityDescriptorEnum.PortNumber_ord:
			specificBuilder.PortNumber(value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, EnumValue value) {
		switch (entityDesc.getOrdinal()) {
		case DBCFGEntityDescriptorEnum.Dialect_ord:
			specificBuilder.Dialect((Value) value);
			break;
		}
	}

	public void wEntity(EntityDescriptor<?> entityDesc, String value) {
		switch (entityDesc.getOrdinal()) {
		case DBCFGEntityDescriptorEnum.Url_ord:
			specificBuilder.Url(value);
			break;
		case DBCFGEntityDescriptorEnum.ServerName_ord:
			specificBuilder.ServerName(value);
			break;
		case DBCFGEntityDescriptorEnum.DatabaseName_ord:
			specificBuilder.DatabaseName(value);
			break;
		case DBCFGEntityDescriptorEnum.DatabaseSchema_ord:
			specificBuilder.DatabaseSchema(value);
			break;
		case DBCFGEntityDescriptorEnum.UserName_ord:
			specificBuilder.UserName(value);
			break;
		case DBCFGEntityDescriptorEnum.Password_ord:
			specificBuilder.Password(value);
			break;
		case DBCFGEntityDescriptorEnum.DriverName_ord:
			specificBuilder.DriverName(value);
			break;
		case DBCFGEntityDescriptorEnum.ClassName_ord:
			specificBuilder.ClassName(value);
			break;
		case DBCFGEntityDescriptorEnum.FilePath_ord:
			specificBuilder.FilePath(value);
			break;
		}
	}
}
