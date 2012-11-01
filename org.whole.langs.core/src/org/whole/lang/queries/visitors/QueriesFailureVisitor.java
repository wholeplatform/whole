package org.whole.lang.queries.visitors;

import org.whole.lang.queries.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/** 
 * @generator Whole
 */
public class QueriesFailureVisitor extends QueriesIdentityVisitor {
	public boolean visitAdapter(IEntityAdapter entity) {
		throw new VisitException();
	}

	public void visit(QueryDeclaration entity) {
		throw new VisitException();
	}

	public void visit(Path entity) {
		throw new VisitException();
	}

	public void visit(Delete entity) {
		throw new VisitException();
	}

	public void visit(CartesianInsert entity) {
		throw new VisitException();
	}

	public void visit(PointwiseInsert entity) {
		throw new VisitException();
	}

	public void visit(CartesianUpdate entity) {
		throw new VisitException();
	}

	public void visit(PointwiseUpdate entity) {
		throw new VisitException();
	}

	public void visit(Select entity) {
		throw new VisitException();
	}

	public void visit(For entity) {
		throw new VisitException();
	}

	public void visit(If entity) {
		throw new VisitException();
	}

	public void visit(Do entity) {
		throw new VisitException();
	}

	public void visit(EntityTemplate entity) {
		throw new VisitException();
	}

	public void visit(EntityCall entity) {
		throw new VisitException();
	}

	public void visit(Call entity) {
		throw new VisitException();
	}

	public void visit(Expressions entity) {
		throw new VisitException();
	}

	public void visit(Bindings entity) {
		throw new VisitException();
	}

	public void visit(Bind entity) {
		throw new VisitException();
	}

	public void visit(Choose entity) {
		throw new VisitException();
	}

	public void visit(Block entity) {
		throw new VisitException();
	}

	public void visit(Sequence entity) {
		throw new VisitException();
	}

	public void visit(Scope entity) {
		throw new VisitException();
	}

	public void visit(CartesianProduct entity) {
		throw new VisitException();
	}

	public void visit(PointwiseProduct entity) {
		throw new VisitException();
	}

	public void visit(Filter entity) {
		throw new VisitException();
	}

	public void visit(AspectStep entity) {
		throw new VisitException();
	}

	public void visit(AdjacentStep entity) {
		throw new VisitException();
	}

	public void visit(ReachableStep entity) {
		throw new VisitException();
	}

	public void visit(ReachableOrSelfStep entity) {
		throw new VisitException();
	}

	public void visit(InverseAdjacentStep entity) {
		throw new VisitException();
	}

	public void visit(InverseReachableStep entity) {
		throw new VisitException();
	}

	public void visit(InverseReachableOrSelfStep entity) {
		throw new VisitException();
	}

	public void visit(RootStep entity) {
		throw new VisitException();
	}

	public void visit(FragmentRootStep entity) {
		throw new VisitException();
	}

	public void visit(SelfStep entity) {
		throw new VisitException();
	}

	public void visit(FeatureStep entity) {
		throw new VisitException();
	}

	public void visit(ChildStep entity) {
		throw new VisitException();
	}

	public void visit(DescendantStep entity) {
		throw new VisitException();
	}

	public void visit(DescendantOrSelfStep entity) {
		throw new VisitException();
	}

	public void visit(FollowingSiblingStep entity) {
		throw new VisitException();
	}

	public void visit(FollowingStep entity) {
		throw new VisitException();
	}

	public void visit(ParentStep entity) {
		throw new VisitException();
	}

	public void visit(AncestorStep entity) {
		throw new VisitException();
	}

	public void visit(AncestorOrSelfStep entity) {
		throw new VisitException();
	}

	public void visit(PrecedingSiblingStep entity) {
		throw new VisitException();
	}

	public void visit(PrecedingStep entity) {
		throw new VisitException();
	}

	public void visit(Prune entity) {
		throw new VisitException();
	}

	public void visit(VariableTest entity) {
		throw new VisitException();
	}

	public void visit(IndexVariableTest entity) {
		throw new VisitException();
	}

	public void visit(KindTest entity) {
		throw new VisitException();
	}

	public void visit(StageTest entity) {
		throw new VisitException();
	}

	public void visit(StageVariableTest entity) {
		throw new VisitException();
	}

	public void visit(LanguageTest entity) {
		throw new VisitException();
	}

	public void visit(TypeTest entity) {
		throw new VisitException();
	}

	public void visit(SubtypeTest entity) {
		throw new VisitException();
	}

	public void visit(SupertypeTest entity) {
		throw new VisitException();
	}

	public void visit(AtTypeTest entity) {
		throw new VisitException();
	}

	public void visit(AtFeatureTest entity) {
		throw new VisitException();
	}

	public void visit(AtIndexTest entity) {
		throw new VisitException();
	}

	public void visit(IndexTest entity) {
		throw new VisitException();
	}

	public void visit(IndexRangeTest entity) {
		throw new VisitException();
	}

	public void visit(VisitorTest entity) {
		throw new VisitException();
	}

	public void visit(ExpressionTest entity) {
		throw new VisitException();
	}

	public void visit(DistinctTest entity) {
		throw new VisitException();
	}

	public void visit(And entity) {
		throw new VisitException();
	}

	public void visit(Or entity) {
		throw new VisitException();
	}

	public void visit(Not entity) {
		throw new VisitException();
	}

	public void visit(One entity) {
		throw new VisitException();
	}

	public void visit(Some entity) {
		throw new VisitException();
	}

	public void visit(Every entity) {
		throw new VisitException();
	}

	public void visit(ParenthesizedPredicate entity) {
		throw new VisitException();
	}

	public void visit(EntityType entity) {
		throw new VisitException();
	}

	public void visit(TemplateNames entity) {
		throw new VisitException();
	}

	public void visit(AllNames entity) {
		throw new VisitException();
	}

	public void visit(AddNames entity) {
		throw new VisitException();
	}

	public void visit(RemoveNames entity) {
		throw new VisitException();
	}

	public void visit(Names entity) {
		throw new VisitException();
	}

	public void visit(Name entity) {
		throw new VisitException();
	}

	public void visit(IdentityComparator entity) {
		throw new VisitException();
	}

	public void visit(UnionAll entity) {
		throw new VisitException();
	}

	public void visit(Union entity) {
		throw new VisitException();
	}

	public void visit(Intersect entity) {
		throw new VisitException();
	}

	public void visit(Except entity) {
		throw new VisitException();
	}

	public void visit(VariableRefStep entity) {
		throw new VisitException();
	}

	public void visit(Singleton entity) {
		throw new VisitException();
	}

	public void visit(PointwiseEquals entity) {
		throw new VisitException();
	}

	public void visit(Tuple entity) {
		throw new VisitException();
	}

	public void visit(Addition entity) {
		throw new VisitException();
	}

	public void visit(Subtraction entity) {
		throw new VisitException();
	}

	public void visit(Multiplication entity) {
		throw new VisitException();
	}

	public void visit(Division entity) {
		throw new VisitException();
	}

	public void visit(Remainder entity) {
		throw new VisitException();
	}

	public void visit(Equals entity) {
		throw new VisitException();
	}

	public void visit(NotEquals entity) {
		throw new VisitException();
	}

	public void visit(LessThan entity) {
		throw new VisitException();
	}

	public void visit(LessOrEquals entity) {
		throw new VisitException();
	}

	public void visit(GreaterThan entity) {
		throw new VisitException();
	}

	public void visit(GreaterOrEquals entity) {
		throw new VisitException();
	}

	public void visit(VoidLiteral entity) {
		throw new VisitException();
	}

	public void visit(BooleanLiteral entity) {
		throw new VisitException();
	}

	public void visit(ByteLiteral entity) {
		throw new VisitException();
	}

	public void visit(CharLiteral entity) {
		throw new VisitException();
	}

	public void visit(DoubleLiteral entity) {
		throw new VisitException();
	}

	public void visit(FloatLiteral entity) {
		throw new VisitException();
	}

	public void visit(IntLiteral entity) {
		throw new VisitException();
	}

	public void visit(LongLiteral entity) {
		throw new VisitException();
	}

	public void visit(ShortLiteral entity) {
		throw new VisitException();
	}

	public void visit(DateLiteral entity) {
		throw new VisitException();
	}

	public void visit(StringLiteral entity) {
		throw new VisitException();
	}

	public void visit(Placement entity) {
		throw new VisitException();
	}
}
