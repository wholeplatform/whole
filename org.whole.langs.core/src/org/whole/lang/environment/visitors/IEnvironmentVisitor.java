package org.whole.lang.environment.visitors;

import org.whole.lang.visitors.IVisitor;
import org.whole.lang.environment.model.*;
import org.whole.lang.environment.model.Void;

/** 
 * @generator Whole
 */
public interface IEnvironmentVisitor extends IVisitor {
	public void visit(BooleanData entity);

	public void visit(ByteData entity);

	public void visit(CharData entity);

	public void visit(DoubleData entity);

	public void visit(FloatData entity);

	public void visit(IntData entity);

	public void visit(LongData entity);

	public void visit(ShortData entity);

	public void visit(StringData entity);

	public void visit(DateData entity);

	public void visit(ObjectData entity);

	public void visit(Tuple entity);

	public void visit(ContainmentTuple entity);

	public void visit(Void entity);
}
