package org.whole.lang.environment.visitors;

import org.whole.lang.environment.model.*;
import org.whole.lang.environment.model.Void;

/** 
 * @generator Whole
 */
public class EnvironmentForwardStagedVisitor extends EnvironmentIdentityVisitor {
	public void visit(BooleanData entity) {
		stagedVisit(entity);
	}

	public void visit(ByteData entity) {
		stagedVisit(entity);
	}

	public void visit(CharData entity) {
		stagedVisit(entity);
	}

	public void visit(DoubleData entity) {
		stagedVisit(entity);
	}

	public void visit(FloatData entity) {
		stagedVisit(entity);
	}

	public void visit(IntData entity) {
		stagedVisit(entity);
	}

	public void visit(LongData entity) {
		stagedVisit(entity);
	}

	public void visit(ShortData entity) {
		stagedVisit(entity);
	}

	public void visit(StringData entity) {
		stagedVisit(entity);
	}

	public void visit(DateData entity) {
		stagedVisit(entity);
	}

	public void visit(ObjectData entity) {
		stagedVisit(entity);
	}

	public void visit(Tuple entity) {
		stagedVisit(entity);
	}

	public void visit(ContainmentTuple entity) {
		stagedVisit(entity);
	}

	public void visit(Void entity) {
		stagedVisit(entity);
	}
}
