package org.whole.lang.dbcfg.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/** 
 * @generator Whole
 */
public class DBCFGFeatureDescriptorEnum extends FeatureDescriptorEnum {
	public static final int drivers_ord = 0;
	public static final int dataSources_ord = 1;
	public static final int dataSourceIndex_ord = 2;
	public static final int driverName_ord = 3;
	public static final int driverClassName_ord = 4;
	public static final int files_ord = 5;
	public static final int dialect_ord = 6;
	public static final int url_ord = 7;
	public static final int serverName_ord = 8;
	public static final int portNumber_ord = 9;
	public static final int databaseName_ord = 10;
	public static final int databaseSchema_ord = 11;
	public static final int userName_ord = 12;
	public static final int password_ord = 13;
	public static final DBCFGFeatureDescriptorEnum instance = new DBCFGFeatureDescriptorEnum();
	public static final FeatureDescriptor drivers = instance
			.valueOf(drivers_ord);
	public static final FeatureDescriptor dataSources = instance
			.valueOf(dataSources_ord);
	public static final FeatureDescriptor dataSourceIndex = instance
			.valueOf(dataSourceIndex_ord);
	public static final FeatureDescriptor driverName = instance
			.valueOf(driverName_ord);
	public static final FeatureDescriptor driverClassName = instance
			.valueOf(driverClassName_ord);
	public static final FeatureDescriptor files = instance.valueOf(files_ord);
	public static final FeatureDescriptor dialect = instance
			.valueOf(dialect_ord);
	public static final FeatureDescriptor url = instance.valueOf(url_ord);
	public static final FeatureDescriptor serverName = instance
			.valueOf(serverName_ord);
	public static final FeatureDescriptor portNumber = instance
			.valueOf(portNumber_ord);
	public static final FeatureDescriptor databaseName = instance
			.valueOf(databaseName_ord);
	public static final FeatureDescriptor databaseSchema = instance
			.valueOf(databaseSchema_ord);
	public static final FeatureDescriptor userName = instance
			.valueOf(userName_ord);
	public static final FeatureDescriptor password = instance
			.valueOf(password_ord);

	private DBCFGFeatureDescriptorEnum() {
		putFeatureDescriptor(drivers_ord, "drivers");
		putFeatureDescriptor(dataSources_ord, "dataSources");
		putFeatureDescriptor(dataSourceIndex_ord, "dataSourceIndex");
		putFeatureDescriptor(driverName_ord, "driverName");
		putFeatureDescriptor(driverClassName_ord, "driverClassName");
		putFeatureDescriptor(files_ord, "files");
		putFeatureDescriptor(dialect_ord, "dialect");
		putFeatureDescriptor(url_ord, "url");
		putFeatureDescriptor(serverName_ord, "serverName");
		putFeatureDescriptor(portNumber_ord, "portNumber");
		putFeatureDescriptor(databaseName_ord, "databaseName");
		putFeatureDescriptor(databaseSchema_ord, "databaseSchema");
		putFeatureDescriptor(userName_ord, "userName");
		putFeatureDescriptor(password_ord, "password");
	}

	private static final long serialVersionUID = 1;
}
