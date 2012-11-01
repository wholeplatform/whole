package org.whole.lang.semantics.visitors;

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.semantics.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class SemanticsForwardGenericVisitor extends
		AbstractUnaryVisitor<IVisitor> implements ISemanticsVisitor {
	public SemanticsForwardGenericVisitor(IVisitor visitor1) {
		super(visitor1);
	}

	public void visit(IEntity entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SemanticTheory entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SemanticFunctions entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SemanticFunction entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Rules entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InferenceRules entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(AnyType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LanguageType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EntityType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EnvironmentType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LegacyType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(UnionType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FunctionType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SequenceType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SubtypeType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(SupertypeType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ProductType entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ExecutionRule entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InferenceRule entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Premises entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Transition entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Configuration entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TypedVariable entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StructuredVariable entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Variable entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(VariableValue entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(RenameGroup entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Rename entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Environments entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BindingsScope entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LocalBindings entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(LocalBinding entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(BindingOp entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(EnvironmentVariable entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(TypeCast entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(FunctionApplication entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(StageChange entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(OutputBindings entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(OutputBinding entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InputBindings entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InputBinding entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(InlineTemplate entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ChooseTemplate entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(WhereTemplate entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ForTemplate entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IfTemplate entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(IfDefTemplate entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(ElseTemplate entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(RuleName entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Num entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(URI entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Namespace entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Name entity) {
		wGetVisitor1().visit(entity);
	}

	public void visit(Version entity) {
		wGetVisitor1().visit(entity);
	}
}
