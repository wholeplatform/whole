package org.whole.lang.dbcfg.visitors;

import org.whole.lang.dbcfg.model.*;

/** 
 * @generator Whole
 */
public class DBCFGForwardStagedVisitor extends DBCFGIdentityVisitor {
	public void visit(DBConfiguration entity) {
		stagedVisit(entity);
	}

	public void visit(JDBCDrivers entity) {
		stagedVisit(entity);
	}

	public void visit(JDBCDriver entity) {
		stagedVisit(entity);
	}

	public void visit(Files entity) {
		stagedVisit(entity);
	}

	public void visit(DataSources entity) {
		stagedVisit(entity);
	}

	public void visit(DataSource entity) {
		stagedVisit(entity);
	}

	public void visit(Index entity) {
		stagedVisit(entity);
	}

	public void visit(Dialect entity) {
		stagedVisit(entity);
	}

	public void visit(Url entity) {
		stagedVisit(entity);
	}

	public void visit(ServerName entity) {
		stagedVisit(entity);
	}

	public void visit(PortNumber entity) {
		stagedVisit(entity);
	}

	public void visit(DatabaseName entity) {
		stagedVisit(entity);
	}

	public void visit(DatabaseSchema entity) {
		stagedVisit(entity);
	}

	public void visit(UserName entity) {
		stagedVisit(entity);
	}

	public void visit(Password entity) {
		stagedVisit(entity);
	}

	public void visit(DriverName entity) {
		stagedVisit(entity);
	}

	public void visit(ClassName entity) {
		stagedVisit(entity);
	}

	public void visit(FilePath entity) {
		stagedVisit(entity);
	}
}
