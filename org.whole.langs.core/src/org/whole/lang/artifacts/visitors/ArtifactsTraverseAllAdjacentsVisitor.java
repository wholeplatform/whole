package org.whole.lang.artifacts.visitors;

import org.whole.lang.artifacts.visitors.ArtifactsIdentityUnaryVisitor;
import org.whole.lang.artifacts.visitors.IArtifactsVisitor;
import org.whole.lang.artifacts.model.*;
import org.whole.lang.visitors.IVisitor;

/** 
 * @generator Whole
 */
public class ArtifactsTraverseAllAdjacentsVisitor extends
		ArtifactsIdentityUnaryVisitor<IArtifactsVisitor> {
	public ArtifactsTraverseAllAdjacentsVisitor() {
		wSetVisitor1(this);
	}

	public ArtifactsTraverseAllAdjacentsVisitor(IVisitor visitor1) {
		super(visitor1);
	}
}
