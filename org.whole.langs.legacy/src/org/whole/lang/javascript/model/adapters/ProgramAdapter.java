package org.whole.lang.javascript.model.adapters;

import org.whole.lang.model.adapters.AbstractEntityAdapter;
import org.whole.lang.javascript.model.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.javascript.visitors.IJavaScriptVisitor;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.javascript.reflect.JavaScriptEntityDescriptorEnum;
import org.whole.lang.javascript.reflect.JavaScriptFeatureDescriptorEnum;

/** 
 * @generator Whole
 */
public class ProgramAdapter extends AbstractEntityAdapter implements Program {
	private static final long serialVersionUID = 1;

	public ProgramAdapter(IEntity implementor) {
		super(implementor);
	}

	public ProgramAdapter() {
	}

	public void accept(IJavaScriptVisitor visitor) {
		if (visitor.visitAdapter(this))
			visitor.visit(this);
	}

	public EntityDescriptor<Program> wGetEntityDescriptor() {
		return JavaScriptEntityDescriptorEnum.Program;
	}

	public Statements getStatements() {
		return wGet(JavaScriptFeatureDescriptorEnum.statements).wGetAdapter(
				JavaScriptEntityDescriptorEnum.Statements);
	}

	public void setStatements(Statements statements) {
		wSet(JavaScriptFeatureDescriptorEnum.statements, statements);
	}
}
