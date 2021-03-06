package org.whole.lang.dbcfg.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class DBCFGForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor>
		implements IDBCFGVisitor {
	public DBCFGForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DBConfiguration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(JDBCDrivers entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(JDBCDriver entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Files entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DataSources entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DataSource entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Index entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Dialect entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Url entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ServerName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(PortNumber entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DatabaseName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DatabaseSchema entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(UserName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Password entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(DriverName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ClassName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FilePath entity) {
		wGetVisitor1().visit(entity);
	}
}
