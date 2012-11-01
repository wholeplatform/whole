package org.whole.lang.dbcfg.visitors;

import org.whole.lang.dbcfg.model.*;

/** 
 * @generator Whole
 */
public class DBCFGIdentityDefaultVisitor extends DBCFGIdentityVisitor {
	public void visit(IDBCFGEntity entity) {
	}

	public void visit(DBConfiguration entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(JDBCDrivers entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(JDBCDriver entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(Files entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(DataSources entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(DataSource entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(Index entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(Dialect entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(Url entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(ServerName entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(PortNumber entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(DatabaseName entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(DatabaseSchema entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(UserName entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(Password entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(DriverName entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(ClassName entity) {
		visit((IDBCFGEntity) entity);
	}

	public void visit(FilePath entity) {
		visit((IDBCFGEntity) entity);
	}
}
