package org.whole.lang.dbcfg.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.dbcfg.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class DBCFGEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int DBConfiguration_ord = 0;
	public static final int JDBCDrivers_ord = 1;
	public static final int JDBCDriver_ord = 2;
	public static final int Files_ord = 3;
	public static final int DataSources_ord = 4;
	public static final int DataSource_ord = 5;
	public static final int Index_ord = 6;
	public static final int Dialect_ord = 7;
	public static final int Url_ord = 8;
	public static final int ServerName_ord = 9;
	public static final int PortNumber_ord = 10;
	public static final int DatabaseName_ord = 11;
	public static final int DatabaseSchema_ord = 12;
	public static final int UserName_ord = 13;
	public static final int Password_ord = 14;
	public static final int DriverName_ord = 15;
	public static final int ClassName_ord = 16;
	public static final int FilePath_ord = 17;
	public static final DBCFGEntityDescriptorEnum instance = new DBCFGEntityDescriptorEnum();
	public static final EntityDescriptor<DBConfiguration> DBConfiguration = (EntityDescriptor<DBConfiguration>) instance
			.valueOf(DBConfiguration_ord);
	public static final EntityDescriptor<JDBCDrivers> JDBCDrivers = (EntityDescriptor<JDBCDrivers>) instance
			.valueOf(JDBCDrivers_ord);
	public static final EntityDescriptor<JDBCDriver> JDBCDriver = (EntityDescriptor<JDBCDriver>) instance
			.valueOf(JDBCDriver_ord);
	public static final EntityDescriptor<Files> Files = (EntityDescriptor<Files>) instance
			.valueOf(Files_ord);
	public static final EntityDescriptor<DataSources> DataSources = (EntityDescriptor<DataSources>) instance
			.valueOf(DataSources_ord);
	public static final EntityDescriptor<DataSource> DataSource = (EntityDescriptor<DataSource>) instance
			.valueOf(DataSource_ord);
	public static final EntityDescriptor<Index> Index = (EntityDescriptor<Index>) instance
			.valueOf(Index_ord);
	public static final EntityDescriptor<Dialect> Dialect = (EntityDescriptor<Dialect>) instance
			.valueOf(Dialect_ord);
	public static final EntityDescriptor<Url> Url = (EntityDescriptor<Url>) instance
			.valueOf(Url_ord);
	public static final EntityDescriptor<ServerName> ServerName = (EntityDescriptor<ServerName>) instance
			.valueOf(ServerName_ord);
	public static final EntityDescriptor<PortNumber> PortNumber = (EntityDescriptor<PortNumber>) instance
			.valueOf(PortNumber_ord);
	public static final EntityDescriptor<DatabaseName> DatabaseName = (EntityDescriptor<DatabaseName>) instance
			.valueOf(DatabaseName_ord);
	public static final EntityDescriptor<DatabaseSchema> DatabaseSchema = (EntityDescriptor<DatabaseSchema>) instance
			.valueOf(DatabaseSchema_ord);
	public static final EntityDescriptor<UserName> UserName = (EntityDescriptor<UserName>) instance
			.valueOf(UserName_ord);
	public static final EntityDescriptor<Password> Password = (EntityDescriptor<Password>) instance
			.valueOf(Password_ord);
	public static final EntityDescriptor<DriverName> DriverName = (EntityDescriptor<DriverName>) instance
			.valueOf(DriverName_ord);
	public static final EntityDescriptor<ClassName> ClassName = (EntityDescriptor<ClassName>) instance
			.valueOf(ClassName_ord);
	public static final EntityDescriptor<FilePath> FilePath = (EntityDescriptor<FilePath>) instance
			.valueOf(FilePath_ord);

	private DBCFGEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(DBConfiguration_ord, "DBConfiguration",
				DBConfiguration.class, false)
				.withFeature(DBCFGFeatureDescriptorEnum.drivers,
						JDBCDrivers_ord)
				.withFeature(DBCFGFeatureDescriptorEnum.dataSources,
						DataSources_ord)
				.withFeature(DBCFGFeatureDescriptorEnum.dataSourceIndex,
						Index_ord);
		putCompositeEntity(
		JDBCDrivers_ord, "JDBCDrivers", JDBCDrivers.class, false, JDBCDriver_ord, false, true);
		putSimpleEntity(JDBCDriver_ord, "JDBCDriver", JDBCDriver.class, false)
				.withFeature(DBCFGFeatureDescriptorEnum.driverName,
						DriverName_ord, false, true, false, false, false)
				.withFeature(DBCFGFeatureDescriptorEnum.driverClassName,
						ClassName_ord)
				.withFeature(DBCFGFeatureDescriptorEnum.files, Files_ord)
				.withFeature(DBCFGFeatureDescriptorEnum.dialect, Dialect_ord);
		putCompositeEntity(
		Files_ord, "Files", Files.class, false, FilePath_ord, false, false);
		putCompositeEntity(
		DataSources_ord, "DataSources", DataSources.class, false, DataSource_ord, true, false);
		putSimpleEntity(DataSource_ord, "DataSource", DataSource.class, false)
				.withFeature(DBCFGFeatureDescriptorEnum.driverName,
						DriverName_ord)
				.withFeature(DBCFGFeatureDescriptorEnum.url, Url_ord)
				.withFeature(DBCFGFeatureDescriptorEnum.serverName,
						ServerName_ord)
				.withFeature(DBCFGFeatureDescriptorEnum.portNumber,
						PortNumber_ord)
				.withFeature(DBCFGFeatureDescriptorEnum.databaseName,
						DatabaseName_ord)
				.withFeature(DBCFGFeatureDescriptorEnum.databaseSchema,
						DatabaseSchema_ord)
				.withFeature(DBCFGFeatureDescriptorEnum.userName, UserName_ord)
				.withFeature(DBCFGFeatureDescriptorEnum.password, Password_ord);
		putDataEntity(Index_ord, "Index", Index.class, false, int.class);
		putDataEntity(Dialect_ord, "Dialect", Dialect.class, false,
				DialectEnum.Value.class);
		putDataEntity(Url_ord, "Url", Url.class, false, String.class);
		putDataEntity(ServerName_ord, "ServerName", ServerName.class, false,
				String.class);
		putDataEntity(PortNumber_ord, "PortNumber", PortNumber.class, false,
				int.class);
		putDataEntity(DatabaseName_ord, "DatabaseName", DatabaseName.class,
				false, String.class);
		putDataEntity(DatabaseSchema_ord, "DatabaseSchema",
				DatabaseSchema.class, false, String.class);
		putDataEntity(UserName_ord, "UserName", UserName.class, false,
				String.class);
		putDataEntity(Password_ord, "Password", Password.class, false,
				String.class);
		putDataEntity(DriverName_ord, "DriverName", DriverName.class, false,
				String.class);
		putDataEntity(ClassName_ord, "ClassName", ClassName.class, false,
				String.class);
		putDataEntity(FilePath_ord, "FilePath", FilePath.class, false,
				String.class);
	}
}
