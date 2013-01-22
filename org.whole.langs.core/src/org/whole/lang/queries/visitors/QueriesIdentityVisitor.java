package org.whole.lang.queries.visitors;

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.queries.model.*;
import org.whole.lang.model.IEntity;

/** 
 * @generator Whole
 */
public class QueriesIdentityVisitor extends AbstractVisitor implements
		IQueriesVisitor {
	public void visit(IEntity entity) {
		((IQueriesEntity) entity).accept(this);
	}

	public void visit(QueryDeclaration entity) {
	}

	public void visit(Path entity) {
	}

	public void visit(Delete entity) {
	}

	public void visit(CartesianInsert entity) {
	}

	public void visit(PointwiseInsert entity) {
	}

	public void visit(CartesianUpdate entity) {
	}

	public void visit(PointwiseUpdate entity) {
	}

	public void visit(Select entity) {
	}

	public void visit(For entity) {
	}

	public void visit(If entity) {
	}

	public void visit(Do entity) {
	}

	public void visit(EntityTemplate entity) {
	}

	public void visit(EntityCall entity) {
	}

	public void visit(Call entity) {
	}

	public void visit(Expressions entity) {
	}

	public void visit(Bindings entity) {
	}

	public void visit(Bind entity) {
	}

	public void visit(Choose entity) {
	}

	public void visit(Block entity) {
	}

	public void visit(Sequence entity) {
	}

	public void visit(Scope entity) {
	}

	public void visit(CartesianProduct entity) {
	}

	public void visit(PointwiseProduct entity) {
	}

	public void visit(Filter entity) {
	}

	public void visit(AspectStep entity) {
	}

	public void visit(AdjacentStep entity) {
	}

	public void visit(ReachableStep entity) {
	}

	public void visit(ReachableOrSelfStep entity) {
	}

	public void visit(InverseAdjacentStep entity) {
	}

	public void visit(InverseReachableStep entity) {
	}

	public void visit(InverseReachableOrSelfStep entity) {
	}

	public void visit(RootStep entity) {
	}

	public void visit(FragmentRootStep entity) {
	}

	public void visit(SelfStep entity) {
	}

	public void visit(FeatureStep entity) {
	}

	public void visit(ChildStep entity) {
	}

	public void visit(DescendantStep entity) {
	}

	public void visit(DescendantOrSelfStep entity) {
	}

	public void visit(FollowingSiblingStep entity) {
	}

	public void visit(FollowingStep entity) {
	}

	public void visit(ParentStep entity) {
	}

	public void visit(AncestorStep entity) {
	}

	public void visit(AncestorOrSelfStep entity) {
	}

	public void visit(PrecedingSiblingStep entity) {
	}

	public void visit(PrecedingStep entity) {
	}

	public void visit(Prune entity) {
	}

	public void visit(VariableTest entity) {
	}

	public void visit(IndexVariableTest entity) {
	}

	public void visit(KindTest entity) {
	}

	public void visit(StageTest entity) {
	}

	public void visit(StageVariableTest entity) {
	}

	public void visit(LanguageTest entity) {
	}

	public void visit(TypeTest entity) {
	}

	public void visit(SubtypeTest entity) {
	}

	public void visit(SupertypeTest entity) {
	}

	public void visit(ExtendedSubtypeTest entity) {
	}

	public void visit(ExtendedSupertypeTest entity) {
	}

	public void visit(AtTypeTest entity) {
	}

	public void visit(AtFeatureTest entity) {
	}

	public void visit(AtIndexTest entity) {
	}

	public void visit(IndexTest entity) {
	}

	public void visit(IndexRangeTest entity) {
	}

	public void visit(VisitorTest entity) {
	}

	public void visit(ExpressionTest entity) {
	}

	public void visit(DistinctTest entity) {
	}

	public void visit(And entity) {
	}

	public void visit(Or entity) {
	}

	public void visit(Not entity) {
	}

	public void visit(One entity) {
	}

	public void visit(Some entity) {
	}

	public void visit(Every entity) {
	}

	public void visit(ParenthesizedPredicate entity) {
	}

	public void visit(EntityType entity) {
	}

	public void visit(TemplateNames entity) {
	}

	public void visit(AllNames entity) {
	}

	public void visit(AddNames entity) {
	}

	public void visit(RemoveNames entity) {
	}

	public void visit(Names entity) {
	}

	public void visit(Name entity) {
	}

	public void visit(IdentityComparator entity) {
	}

	public void visit(UnionAll entity) {
	}

	public void visit(Union entity) {
	}

	public void visit(Intersect entity) {
	}

	public void visit(Except entity) {
	}

	public void visit(VariableRefStep entity) {
	}

	public void visit(Singleton entity) {
	}

	public void visit(PointwiseEquals entity) {
	}

	public void visit(Tuple entity) {
	}

	public void visit(Addition entity) {
	}

	public void visit(Subtraction entity) {
	}

	public void visit(Multiplication entity) {
	}

	public void visit(Division entity) {
	}

	public void visit(Remainder entity) {
	}

	public void visit(Equals entity) {
	}

	public void visit(NotEquals entity) {
	}

	public void visit(LessThan entity) {
	}

	public void visit(LessOrEquals entity) {
	}

	public void visit(GreaterThan entity) {
	}

	public void visit(GreaterOrEquals entity) {
	}

	public void visit(VoidLiteral entity) {
	}

	public void visit(BooleanLiteral entity) {
	}

	public void visit(ByteLiteral entity) {
	}

	public void visit(CharLiteral entity) {
	}

	public void visit(DoubleLiteral entity) {
	}

	public void visit(FloatLiteral entity) {
	}

	public void visit(IntLiteral entity) {
	}

	public void visit(LongLiteral entity) {
	}

	public void visit(ShortLiteral entity) {
	}

	public void visit(DateLiteral entity) {
	}

	public void visit(StringLiteral entity) {
	}

	public void visit(Placement entity) {
	}
}
