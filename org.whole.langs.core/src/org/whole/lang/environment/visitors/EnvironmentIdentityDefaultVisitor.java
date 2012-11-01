package org.whole.lang.environment.visitors;

import org.whole.lang.environment.model.*;
import org.whole.lang.environment.model.Void;

/** 
 * @generator Whole
 */
public class EnvironmentIdentityDefaultVisitor extends
		EnvironmentIdentityVisitor {
	public void visit(IEnvironmentEntity entity) {
	}

	public void visit(Data entity) {
	}

	public void visit(BooleanData entity) {
		visit((IEnvironmentEntity) entity);
		visit((Data) entity);
	}

	public void visit(ByteData entity) {
		visit((IEnvironmentEntity) entity);
		visit((Data) entity);
	}

	public void visit(CharData entity) {
		visit((IEnvironmentEntity) entity);
		visit((Data) entity);
	}

	public void visit(DoubleData entity) {
		visit((IEnvironmentEntity) entity);
		visit((Data) entity);
	}

	public void visit(FloatData entity) {
		visit((IEnvironmentEntity) entity);
		visit((Data) entity);
	}

	public void visit(IntData entity) {
		visit((IEnvironmentEntity) entity);
		visit((Data) entity);
	}

	public void visit(LongData entity) {
		visit((IEnvironmentEntity) entity);
		visit((Data) entity);
	}

	public void visit(ShortData entity) {
		visit((IEnvironmentEntity) entity);
		visit((Data) entity);
	}

	public void visit(StringData entity) {
		visit((IEnvironmentEntity) entity);
		visit((Data) entity);
	}

	public void visit(DateData entity) {
		visit((IEnvironmentEntity) entity);
		visit((Data) entity);
	}

	public void visit(ObjectData entity) {
		visit((IEnvironmentEntity) entity);
		visit((Data) entity);
	}

	public void visit(Tuple entity) {
		visit((IEnvironmentEntity) entity);
		visit((Data) entity);
	}

	public void visit(ContainmentTuple entity) {
		visit((IEnvironmentEntity) entity);
		visit((Data) entity);
	}

	public void visit(Void entity) {
		visit((IEnvironmentEntity) entity);
		visit((Data) entity);
	}
}
