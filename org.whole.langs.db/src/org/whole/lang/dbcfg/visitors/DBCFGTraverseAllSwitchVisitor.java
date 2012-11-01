package org.whole.lang.dbcfg.visitors;

import org.whole.lang.dbcfg.visitors.DBCFGIdentityUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.dbcfg.model.*;

/** 
 * @generator Whole
 */
public class DBCFGTraverseAllSwitchVisitor extends
		DBCFGIdentityUnaryVisitor<IVisitor> {
	public DBCFGTraverseAllSwitchVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(DBConfiguration entity) {
		wGetVisitor1().visit(entity.getDrivers());
		wGetVisitor1().visit(entity.getDataSources());
		wGetVisitor1().visit(entity.getDataSourceIndex());
	}

	public void visit(JDBCDrivers entity) {
		for (JDBCDriver child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(JDBCDriver entity) {
		wGetVisitor1().visit(entity.getDriverName());
		wGetVisitor1().visit(entity.getDriverClassName());
		wGetVisitor1().visit(entity.getFiles());
		wGetVisitor1().visit(entity.getDialect());
	}

	public void visit(Files entity) {
		for (FilePath child : entity)
			wGetVisitor1().visit(child);
	}

	public void visit(DataSources entity) {
		for (int i = 0; i < entity.size(); i++)
			wGetVisitor1().visit(entity.get(i));
	}

	public void visit(DataSource entity) {
		wGetVisitor1().visit(entity.getDriverName());
		wGetVisitor1().visit(entity.getUrl());
		wGetVisitor1().visit(entity.getServerName());
		wGetVisitor1().visit(entity.getPortNumber());
		wGetVisitor1().visit(entity.getDatabaseName());
		wGetVisitor1().visit(entity.getDatabaseSchema());
		wGetVisitor1().visit(entity.getUserName());
		wGetVisitor1().visit(entity.getPassword());
	}
}
