package org.whole.lang.environment.visitors;

import org.whole.lang.environment.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;
import org.whole.lang.environment.model.Void;

/** 
 * @generator Whole
 */
public class EnvironmentFailureVisitor extends EnvironmentIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(BooleanData entity) {
		throw new VisitException();
	}

	public void visit(ByteData entity) {
		throw new VisitException();
	}

	public void visit(CharData entity) {
		throw new VisitException();
	}

	public void visit(DoubleData entity) {
		throw new VisitException();
	}

	public void visit(FloatData entity) {
		throw new VisitException();
	}

	public void visit(IntData entity) {
		throw new VisitException();
	}

	public void visit(LongData entity) {
		throw new VisitException();
	}

	public void visit(ShortData entity) {
		throw new VisitException();
	}

	public void visit(StringData entity) {
		throw new VisitException();
	}

	public void visit(DateData entity) {
		throw new VisitException();
	}

	public void visit(ObjectData entity) {
		throw new VisitException();
	}

	public void visit(Tuple entity) {
		throw new VisitException();
	}

	public void visit(ContainmentTuple entity) {
		throw new VisitException();
	}

	public void visit(Void entity) {
		throw new VisitException();
	}
}
