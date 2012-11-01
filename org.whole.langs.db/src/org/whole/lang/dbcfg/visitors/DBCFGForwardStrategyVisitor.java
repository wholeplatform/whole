package org.whole.lang.dbcfg.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class DBCFGForwardStrategyVisitor extends
		GenericForwardStrategyVisitor<IDBCFGVisitor> implements IDBCFGVisitor {
	public DBCFGForwardStrategyVisitor() {
		this(new DBCFGIdentityVisitor());
	}

	public DBCFGForwardStrategyVisitor(IDBCFGVisitor... initialStrategies) {
		super(initialStrategies);
	}

	public void visit(IEntity entity) {
		((IDBCFGEntity) entity).accept(this);
	}

	public void visit(DBConfiguration entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(JDBCDrivers entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(JDBCDriver entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Files entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DataSources entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DataSource entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Index entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Dialect entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Url entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ServerName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(PortNumber entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DatabaseName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DatabaseSchema entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(UserName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(Password entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(DriverName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(ClassName entity) {
		wGetStrategy().visit(entity);
	}

	public void visit(FilePath entity) {
		wGetStrategy().visit(entity);
	}
}
