/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.queries.visitors;

import org.whole.lang.queries.visitors.QueriesIdentityUnaryVisitor;
import org.whole.lang.queries.visitors.IQueriesVisitor;
import org.whole.lang.queries.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator Whole
 */
public class QueriesTraverseAllAdjacentsVisitor extends QueriesIdentityUnaryVisitor<IQueriesVisitor> {

    public QueriesTraverseAllAdjacentsVisitor() {
        wSetVisitor1(this);
    }

    public QueriesTraverseAllAdjacentsVisitor(IVisitor visitor1) {
        super(visitor1);
    }
}
