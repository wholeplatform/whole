package org.whole.lang.properties.visitors;

import org.whole.lang.properties.visitors.PropertiesIdentityUnaryVisitor;
import org.whole.lang.properties.visitors.IPropertiesVisitor;
import org.whole.lang.properties.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class PropertiesTraverseAllAdjacentsVisitor extends
		PropertiesIdentityUnaryVisitor<IPropertiesVisitor> {
	public PropertiesTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public PropertiesTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
