package org.whole.lang.dbcfg.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.dbcfg.reflect.DBCFGEntityDescriptorEnum;

/** 
 * @generator Whole
 */
public abstract class DBCFGIdentitySwitchVisitor extends AbstractVisitor
		implements IDBCFGVisitor {
	public void visit(IEntity entity) {
		switch (entity.wGetEntityOrd()) {
		case DBCFGEntityDescriptorEnum.DBConfiguration_ord:
			visit((DBConfiguration) entity);
			break;
		case DBCFGEntityDescriptorEnum.JDBCDrivers_ord:
			visit((JDBCDrivers) entity);
			break;
		case DBCFGEntityDescriptorEnum.JDBCDriver_ord:
			visit((JDBCDriver) entity);
			break;
		case DBCFGEntityDescriptorEnum.Files_ord:
			visit((Files) entity);
			break;
		case DBCFGEntityDescriptorEnum.DataSources_ord:
			visit((DataSources) entity);
			break;
		case DBCFGEntityDescriptorEnum.DataSource_ord:
			visit((DataSource) entity);
			break;
		case DBCFGEntityDescriptorEnum.Index_ord:
			visit((Index) entity);
			break;
		case DBCFGEntityDescriptorEnum.Dialect_ord:
			visit((Dialect) entity);
			break;
		case DBCFGEntityDescriptorEnum.Url_ord:
			visit((Url) entity);
			break;
		case DBCFGEntityDescriptorEnum.ServerName_ord:
			visit((ServerName) entity);
			break;
		case DBCFGEntityDescriptorEnum.PortNumber_ord:
			visit((PortNumber) entity);
			break;
		case DBCFGEntityDescriptorEnum.DatabaseName_ord:
			visit((DatabaseName) entity);
			break;
		case DBCFGEntityDescriptorEnum.DatabaseSchema_ord:
			visit((DatabaseSchema) entity);
			break;
		case DBCFGEntityDescriptorEnum.UserName_ord:
			visit((UserName) entity);
			break;
		case DBCFGEntityDescriptorEnum.Password_ord:
			visit((Password) entity);
			break;
		case DBCFGEntityDescriptorEnum.DriverName_ord:
			visit((DriverName) entity);
			break;
		case DBCFGEntityDescriptorEnum.ClassName_ord:
			visit((ClassName) entity);
			break;
		case DBCFGEntityDescriptorEnum.FilePath_ord:
			visit((FilePath) entity);
			break;
		}
	}
}
