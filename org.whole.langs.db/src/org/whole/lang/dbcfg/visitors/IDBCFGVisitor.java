package org.whole.lang.dbcfg.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.dbcfg.model.*;

/** 
 * @generator Whole
 */
public interface IDBCFGVisitor extends IVisitor {
	public void visit(DBConfiguration entity);

	public void visit(JDBCDrivers entity);

	public void visit(JDBCDriver entity);

	public void visit(Files entity);

	public void visit(DataSources entity);

	public void visit(DataSource entity);

	public void visit(Index entity);

	public void visit(Dialect entity);

	public void visit(Url entity);

	public void visit(ServerName entity);

	public void visit(PortNumber entity);

	public void visit(DatabaseName entity);

	public void visit(DatabaseSchema entity);

	public void visit(UserName entity);

	public void visit(Password entity);

	public void visit(DriverName entity);

	public void visit(ClassName entity);

	public void visit(FilePath entity);
}
