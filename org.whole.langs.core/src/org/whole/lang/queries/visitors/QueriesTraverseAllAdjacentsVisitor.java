package org.whole.lang.queries.visitors;

import org.whole.lang.queries.visitors.QueriesIdentityUnaryVisitor;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class QueriesTraverseAllAdjacentsVisitor extends
		QueriesIdentityUnaryVisitor<IQueriesVisitor> {
	public QueriesTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public QueriesTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
