package org.whole.lang.dbcfg.visitors;

import org.whole.lang.dbcfg.visitors.DBCFGIdentityUnaryVisitor;
import org.whole.lang.dbcfg.visitors.IDBCFGVisitor;
import org.whole.lang.dbcfg.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class DBCFGTraverseAllAdjacentsVisitor extends
		DBCFGIdentityUnaryVisitor<IDBCFGVisitor> {
	public DBCFGTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public DBCFGTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
