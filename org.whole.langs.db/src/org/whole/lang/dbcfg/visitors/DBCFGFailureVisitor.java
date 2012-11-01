package org.whole.lang.dbcfg.visitors;

import org.whole.lang.dbcfg.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class DBCFGFailureVisitor extends DBCFGIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(DBConfiguration entity) {
		throw new VisitException();
	}

	public void visit(JDBCDrivers entity) {
		throw new VisitException();
	}

	public void visit(JDBCDriver entity) {
		throw new VisitException();
	}

	public void visit(Files entity) {
		throw new VisitException();
	}

	public void visit(DataSources entity) {
		throw new VisitException();
	}

	public void visit(DataSource entity) {
		throw new VisitException();
	}

	public void visit(Index entity) {
		throw new VisitException();
	}

	public void visit(Dialect entity) {
		throw new VisitException();
	}

	public void visit(Url entity) {
		throw new VisitException();
	}

	public void visit(ServerName entity) {
		throw new VisitException();
	}

	public void visit(PortNumber entity) {
		throw new VisitException();
	}

	public void visit(DatabaseName entity) {
		throw new VisitException();
	}

	public void visit(DatabaseSchema entity) {
		throw new VisitException();
	}

	public void visit(UserName entity) {
		throw new VisitException();
	}

	public void visit(Password entity) {
		throw new VisitException();
	}

	public void visit(DriverName entity) {
		throw new VisitException();
	}

	public void visit(ClassName entity) {
		throw new VisitException();
	}

	public void visit(FilePath entity) {
		throw new VisitException();
	}
}
