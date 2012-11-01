package org.whole.lang.dbcfg.visitors;

import org.whole.lang.dbcfg.visitors.DBCFGIdentityUnaryVisitor;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class DBCFGTraverseAllChildrenVisitor extends
		DBCFGIdentityUnaryVisitor<IDBCFGVisitor> {
	public DBCFGTraverseAllChildrenVisitor() {
		wSetVisitor1(this);
	}

	public DBCFGTraverseAllChildrenVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(DBConfiguration entity) {
		entity.getDrivers().accept(wGetVisitor1());
		entity.getDataSources().accept(wGetVisitor1());
		entity.getDataSourceIndex().accept(wGetVisitor1());
	}

	public void visit(JDBCDrivers entity) {
		for (JDBCDriver child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(JDBCDriver entity) {
		entity.getDriverName().accept(wGetVisitor1());
		entity.getDriverClassName().accept(wGetVisitor1());
		entity.getFiles().accept(wGetVisitor1());
		entity.getDialect().accept(wGetVisitor1());
	}

	public void visit(Files entity) {
		for (FilePath child : entity)
			child.accept(wGetVisitor1());
	}

	public void visit(DataSources entity) {
		for (int i = 0; i < entity.size(); i++)
			entity.get(i).accept(wGetVisitor1());
	}

	public void visit(DataSource entity) {
		entity.getDriverName().accept(wGetVisitor1());
		entity.getUrl().accept(wGetVisitor1());
		entity.getServerName().accept(wGetVisitor1());
		entity.getPortNumber().accept(wGetVisitor1());
		entity.getDatabaseName().accept(wGetVisitor1());
		entity.getDatabaseSchema().accept(wGetVisitor1());
		entity.getUserName().accept(wGetVisitor1());
		entity.getPassword().accept(wGetVisitor1());
	}
}
