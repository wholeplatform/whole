package org.whole.lang.queries.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.queries.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class QueriesEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int PathExpressionOrPredicate_ord = 0;
	public static final int PathExpression_ord = 1;
	public static final int QueryDeclaration_ord = 2;
	public static final int Path_ord = 3;
	public static final int Delete_ord = 4;
	public static final int CartesianInsert_ord = 5;
	public static final int PointwiseInsert_ord = 6;
	public static final int CartesianUpdate_ord = 7;
	public static final int PointwiseUpdate_ord = 8;
	public static final int Select_ord = 9;
	public static final int For_ord = 10;
	public static final int If_ord = 11;
	public static final int Do_ord = 12;
	public static final int StepExpression_ord = 13;
	public static final int EntityTemplate_ord = 14;
	public static final int EntityCall_ord = 15;
	public static final int Call_ord = 16;
	public static final int Constraints_ord = 17;
	public static final int Expressions_ord = 18;
	public static final int Bindings_ord = 19;
	public static final int Bind_ord = 20;
	public static final int Choose_ord = 21;
	public static final int Block_ord = 22;
	public static final int Sequence_ord = 23;
	public static final int Scope_ord = 24;
	public static final int CartesianProduct_ord = 25;
	public static final int PointwiseProduct_ord = 26;
	public static final int Filter_ord = 27;
	public static final int AspectStep_ord = 28;
	public static final int DirectStep_ord = 29;
	public static final int AdjacentStep_ord = 30;
	public static final int ReachableStep_ord = 31;
	public static final int ReachableOrSelfStep_ord = 32;
	public static final int InverseStep_ord = 33;
	public static final int InverseAdjacentStep_ord = 34;
	public static final int InverseReachableStep_ord = 35;
	public static final int InverseReachableOrSelfStep_ord = 36;
	public static final int RootStep_ord = 37;
	public static final int FragmentRootStep_ord = 38;
	public static final int SelfStep_ord = 39;
	public static final int ForwardStep_ord = 40;
	public static final int FeatureStep_ord = 41;
	public static final int ChildStep_ord = 42;
	public static final int DescendantStep_ord = 43;
	public static final int DescendantOrSelfStep_ord = 44;
	public static final int FollowingSiblingStep_ord = 45;
	public static final int FollowingStep_ord = 46;
	public static final int ReverseStep_ord = 47;
	public static final int ParentStep_ord = 48;
	public static final int AncestorStep_ord = 49;
	public static final int AncestorOrSelfStep_ord = 50;
	public static final int PrecedingSiblingStep_ord = 51;
	public static final int PrecedingStep_ord = 52;
	public static final int PruneOrPredicate_ord = 53;
	public static final int Prune_ord = 54;
	public static final int Predicate_ord = 55;
	public static final int VariableTest_ord = 56;
	public static final int IndexVariableTest_ord = 57;
	public static final int KindTest_ord = 58;
	public static final int StageTest_ord = 59;
	public static final int StageVariableTest_ord = 60;
	public static final int LanguageTest_ord = 61;
	public static final int TypeTest_ord = 62;
	public static final int SubtypeTest_ord = 63;
	public static final int SupertypeTest_ord = 64;
	public static final int AtTypeTest_ord = 65;
	public static final int AtFeatureTest_ord = 66;
	public static final int AtIndexTest_ord = 67;
	public static final int IndexTest_ord = 68;
	public static final int IndexRangeTest_ord = 69;
	public static final int VisitorTest_ord = 70;
	public static final int ExpressionTest_ord = 71;
	public static final int DistinctTest_ord = 72;
	public static final int And_ord = 73;
	public static final int Or_ord = 74;
	public static final int Not_ord = 75;
	public static final int QuantifiedPredicate_ord = 76;
	public static final int One_ord = 77;
	public static final int Some_ord = 78;
	public static final int Every_ord = 79;
	public static final int ParenthesizedPredicate_ord = 80;
	public static final int EntityType_ord = 81;
	public static final int NamesExpression_ord = 82;
	public static final int TemplateNames_ord = 83;
	public static final int AllNames_ord = 84;
	public static final int AddNames_ord = 85;
	public static final int RemoveNames_ord = 86;
	public static final int Names_ord = 87;
	public static final int Name_ord = 88;
	public static final int Expression_ord = 89;
	public static final int CollectByExpression_ord = 90;
	public static final int Comparator_ord = 91;
	public static final int IdentityComparator_ord = 92;
	public static final int UnionAll_ord = 93;
	public static final int Union_ord = 94;
	public static final int Intersect_ord = 95;
	public static final int Except_ord = 96;
	public static final int VariableRefStep_ord = 97;
	public static final int Singleton_ord = 98;
	public static final int PointwiseEquals_ord = 99;
	public static final int Tuple_ord = 100;
	public static final int Addition_ord = 101;
	public static final int Subtraction_ord = 102;
	public static final int Multiplication_ord = 103;
	public static final int Division_ord = 104;
	public static final int Remainder_ord = 105;
	public static final int Equals_ord = 106;
	public static final int NotEquals_ord = 107;
	public static final int LessThan_ord = 108;
	public static final int LessOrEquals_ord = 109;
	public static final int GreaterThan_ord = 110;
	public static final int GreaterOrEquals_ord = 111;
	public static final int Literal_ord = 112;
	public static final int VoidLiteral_ord = 113;
	public static final int BooleanLiteral_ord = 114;
	public static final int ByteLiteral_ord = 115;
	public static final int CharLiteral_ord = 116;
	public static final int DoubleLiteral_ord = 117;
	public static final int FloatLiteral_ord = 118;
	public static final int IntLiteral_ord = 119;
	public static final int LongLiteral_ord = 120;
	public static final int ShortLiteral_ord = 121;
	public static final int DateLiteral_ord = 122;
	public static final int StringLiteral_ord = 123;
	public static final int Placement_ord = 124;
	public static final QueriesEntityDescriptorEnum instance = new QueriesEntityDescriptorEnum();
	public static final EntityDescriptor<PathExpressionOrPredicate> PathExpressionOrPredicate = (EntityDescriptor<PathExpressionOrPredicate>) instance
			.valueOf(PathExpressionOrPredicate_ord);
	public static final EntityDescriptor<PathExpression> PathExpression = (EntityDescriptor<PathExpression>) instance
			.valueOf(PathExpression_ord);
	public static final EntityDescriptor<QueryDeclaration> QueryDeclaration = (EntityDescriptor<QueryDeclaration>) instance
			.valueOf(QueryDeclaration_ord);
	public static final EntityDescriptor<Path> Path = (EntityDescriptor<Path>) instance
			.valueOf(Path_ord);
	public static final EntityDescriptor<Delete> Delete = (EntityDescriptor<Delete>) instance
			.valueOf(Delete_ord);
	public static final EntityDescriptor<CartesianInsert> CartesianInsert = (EntityDescriptor<CartesianInsert>) instance
			.valueOf(CartesianInsert_ord);
	public static final EntityDescriptor<PointwiseInsert> PointwiseInsert = (EntityDescriptor<PointwiseInsert>) instance
			.valueOf(PointwiseInsert_ord);
	public static final EntityDescriptor<CartesianUpdate> CartesianUpdate = (EntityDescriptor<CartesianUpdate>) instance
			.valueOf(CartesianUpdate_ord);
	public static final EntityDescriptor<PointwiseUpdate> PointwiseUpdate = (EntityDescriptor<PointwiseUpdate>) instance
			.valueOf(PointwiseUpdate_ord);
	public static final EntityDescriptor<Select> Select = (EntityDescriptor<Select>) instance
			.valueOf(Select_ord);
	public static final EntityDescriptor<For> For = (EntityDescriptor<For>) instance
			.valueOf(For_ord);
	public static final EntityDescriptor<If> If = (EntityDescriptor<If>) instance
			.valueOf(If_ord);
	public static final EntityDescriptor<Do> Do = (EntityDescriptor<Do>) instance
			.valueOf(Do_ord);
	public static final EntityDescriptor<StepExpression> StepExpression = (EntityDescriptor<StepExpression>) instance
			.valueOf(StepExpression_ord);
	public static final EntityDescriptor<EntityTemplate> EntityTemplate = (EntityDescriptor<EntityTemplate>) instance
			.valueOf(EntityTemplate_ord);
	public static final EntityDescriptor<EntityCall> EntityCall = (EntityDescriptor<EntityCall>) instance
			.valueOf(EntityCall_ord);
	public static final EntityDescriptor<Call> Call = (EntityDescriptor<Call>) instance
			.valueOf(Call_ord);
	public static final EntityDescriptor<Constraints> Constraints = (EntityDescriptor<Constraints>) instance
			.valueOf(Constraints_ord);
	public static final EntityDescriptor<Expressions> Expressions = (EntityDescriptor<Expressions>) instance
			.valueOf(Expressions_ord);
	public static final EntityDescriptor<Bindings> Bindings = (EntityDescriptor<Bindings>) instance
			.valueOf(Bindings_ord);
	public static final EntityDescriptor<Bind> Bind = (EntityDescriptor<Bind>) instance
			.valueOf(Bind_ord);
	public static final EntityDescriptor<Choose> Choose = (EntityDescriptor<Choose>) instance
			.valueOf(Choose_ord);
	public static final EntityDescriptor<Block> Block = (EntityDescriptor<Block>) instance
			.valueOf(Block_ord);
	public static final EntityDescriptor<Sequence> Sequence = (EntityDescriptor<Sequence>) instance
			.valueOf(Sequence_ord);
	public static final EntityDescriptor<Scope> Scope = (EntityDescriptor<Scope>) instance
			.valueOf(Scope_ord);
	public static final EntityDescriptor<CartesianProduct> CartesianProduct = (EntityDescriptor<CartesianProduct>) instance
			.valueOf(CartesianProduct_ord);
	public static final EntityDescriptor<PointwiseProduct> PointwiseProduct = (EntityDescriptor<PointwiseProduct>) instance
			.valueOf(PointwiseProduct_ord);
	public static final EntityDescriptor<Filter> Filter = (EntityDescriptor<Filter>) instance
			.valueOf(Filter_ord);
	public static final EntityDescriptor<AspectStep> AspectStep = (EntityDescriptor<AspectStep>) instance
			.valueOf(AspectStep_ord);
	public static final EntityDescriptor<DirectStep> DirectStep = (EntityDescriptor<DirectStep>) instance
			.valueOf(DirectStep_ord);
	public static final EntityDescriptor<AdjacentStep> AdjacentStep = (EntityDescriptor<AdjacentStep>) instance
			.valueOf(AdjacentStep_ord);
	public static final EntityDescriptor<ReachableStep> ReachableStep = (EntityDescriptor<ReachableStep>) instance
			.valueOf(ReachableStep_ord);
	public static final EntityDescriptor<ReachableOrSelfStep> ReachableOrSelfStep = (EntityDescriptor<ReachableOrSelfStep>) instance
			.valueOf(ReachableOrSelfStep_ord);
	public static final EntityDescriptor<InverseStep> InverseStep = (EntityDescriptor<InverseStep>) instance
			.valueOf(InverseStep_ord);
	public static final EntityDescriptor<InverseAdjacentStep> InverseAdjacentStep = (EntityDescriptor<InverseAdjacentStep>) instance
			.valueOf(InverseAdjacentStep_ord);
	public static final EntityDescriptor<InverseReachableStep> InverseReachableStep = (EntityDescriptor<InverseReachableStep>) instance
			.valueOf(InverseReachableStep_ord);
	public static final EntityDescriptor<InverseReachableOrSelfStep> InverseReachableOrSelfStep = (EntityDescriptor<InverseReachableOrSelfStep>) instance
			.valueOf(InverseReachableOrSelfStep_ord);
	public static final EntityDescriptor<RootStep> RootStep = (EntityDescriptor<RootStep>) instance
			.valueOf(RootStep_ord);
	public static final EntityDescriptor<FragmentRootStep> FragmentRootStep = (EntityDescriptor<FragmentRootStep>) instance
			.valueOf(FragmentRootStep_ord);
	public static final EntityDescriptor<SelfStep> SelfStep = (EntityDescriptor<SelfStep>) instance
			.valueOf(SelfStep_ord);
	public static final EntityDescriptor<ForwardStep> ForwardStep = (EntityDescriptor<ForwardStep>) instance
			.valueOf(ForwardStep_ord);
	public static final EntityDescriptor<FeatureStep> FeatureStep = (EntityDescriptor<FeatureStep>) instance
			.valueOf(FeatureStep_ord);
	public static final EntityDescriptor<ChildStep> ChildStep = (EntityDescriptor<ChildStep>) instance
			.valueOf(ChildStep_ord);
	public static final EntityDescriptor<DescendantStep> DescendantStep = (EntityDescriptor<DescendantStep>) instance
			.valueOf(DescendantStep_ord);
	public static final EntityDescriptor<DescendantOrSelfStep> DescendantOrSelfStep = (EntityDescriptor<DescendantOrSelfStep>) instance
			.valueOf(DescendantOrSelfStep_ord);
	public static final EntityDescriptor<FollowingSiblingStep> FollowingSiblingStep = (EntityDescriptor<FollowingSiblingStep>) instance
			.valueOf(FollowingSiblingStep_ord);
	public static final EntityDescriptor<FollowingStep> FollowingStep = (EntityDescriptor<FollowingStep>) instance
			.valueOf(FollowingStep_ord);
	public static final EntityDescriptor<ReverseStep> ReverseStep = (EntityDescriptor<ReverseStep>) instance
			.valueOf(ReverseStep_ord);
	public static final EntityDescriptor<ParentStep> ParentStep = (EntityDescriptor<ParentStep>) instance
			.valueOf(ParentStep_ord);
	public static final EntityDescriptor<AncestorStep> AncestorStep = (EntityDescriptor<AncestorStep>) instance
			.valueOf(AncestorStep_ord);
	public static final EntityDescriptor<AncestorOrSelfStep> AncestorOrSelfStep = (EntityDescriptor<AncestorOrSelfStep>) instance
			.valueOf(AncestorOrSelfStep_ord);
	public static final EntityDescriptor<PrecedingSiblingStep> PrecedingSiblingStep = (EntityDescriptor<PrecedingSiblingStep>) instance
			.valueOf(PrecedingSiblingStep_ord);
	public static final EntityDescriptor<PrecedingStep> PrecedingStep = (EntityDescriptor<PrecedingStep>) instance
			.valueOf(PrecedingStep_ord);
	public static final EntityDescriptor<PruneOrPredicate> PruneOrPredicate = (EntityDescriptor<PruneOrPredicate>) instance
			.valueOf(PruneOrPredicate_ord);
	public static final EntityDescriptor<Prune> Prune = (EntityDescriptor<Prune>) instance
			.valueOf(Prune_ord);
	public static final EntityDescriptor<Predicate> Predicate = (EntityDescriptor<Predicate>) instance
			.valueOf(Predicate_ord);
	public static final EntityDescriptor<VariableTest> VariableTest = (EntityDescriptor<VariableTest>) instance
			.valueOf(VariableTest_ord);
	public static final EntityDescriptor<IndexVariableTest> IndexVariableTest = (EntityDescriptor<IndexVariableTest>) instance
			.valueOf(IndexVariableTest_ord);
	public static final EntityDescriptor<KindTest> KindTest = (EntityDescriptor<KindTest>) instance
			.valueOf(KindTest_ord);
	public static final EntityDescriptor<StageTest> StageTest = (EntityDescriptor<StageTest>) instance
			.valueOf(StageTest_ord);
	public static final EntityDescriptor<StageVariableTest> StageVariableTest = (EntityDescriptor<StageVariableTest>) instance
			.valueOf(StageVariableTest_ord);
	public static final EntityDescriptor<LanguageTest> LanguageTest = (EntityDescriptor<LanguageTest>) instance
			.valueOf(LanguageTest_ord);
	public static final EntityDescriptor<TypeTest> TypeTest = (EntityDescriptor<TypeTest>) instance
			.valueOf(TypeTest_ord);
	public static final EntityDescriptor<SubtypeTest> SubtypeTest = (EntityDescriptor<SubtypeTest>) instance
			.valueOf(SubtypeTest_ord);
	public static final EntityDescriptor<SupertypeTest> SupertypeTest = (EntityDescriptor<SupertypeTest>) instance
			.valueOf(SupertypeTest_ord);
	public static final EntityDescriptor<AtTypeTest> AtTypeTest = (EntityDescriptor<AtTypeTest>) instance
			.valueOf(AtTypeTest_ord);
	public static final EntityDescriptor<AtFeatureTest> AtFeatureTest = (EntityDescriptor<AtFeatureTest>) instance
			.valueOf(AtFeatureTest_ord);
	public static final EntityDescriptor<AtIndexTest> AtIndexTest = (EntityDescriptor<AtIndexTest>) instance
			.valueOf(AtIndexTest_ord);
	public static final EntityDescriptor<IndexTest> IndexTest = (EntityDescriptor<IndexTest>) instance
			.valueOf(IndexTest_ord);
	public static final EntityDescriptor<IndexRangeTest> IndexRangeTest = (EntityDescriptor<IndexRangeTest>) instance
			.valueOf(IndexRangeTest_ord);
	public static final EntityDescriptor<VisitorTest> VisitorTest = (EntityDescriptor<VisitorTest>) instance
			.valueOf(VisitorTest_ord);
	public static final EntityDescriptor<ExpressionTest> ExpressionTest = (EntityDescriptor<ExpressionTest>) instance
			.valueOf(ExpressionTest_ord);
	public static final EntityDescriptor<DistinctTest> DistinctTest = (EntityDescriptor<DistinctTest>) instance
			.valueOf(DistinctTest_ord);
	public static final EntityDescriptor<And> And = (EntityDescriptor<And>) instance
			.valueOf(And_ord);
	public static final EntityDescriptor<Or> Or = (EntityDescriptor<Or>) instance
			.valueOf(Or_ord);
	public static final EntityDescriptor<Not> Not = (EntityDescriptor<Not>) instance
			.valueOf(Not_ord);
	public static final EntityDescriptor<QuantifiedPredicate> QuantifiedPredicate = (EntityDescriptor<QuantifiedPredicate>) instance
			.valueOf(QuantifiedPredicate_ord);
	public static final EntityDescriptor<One> One = (EntityDescriptor<One>) instance
			.valueOf(One_ord);
	public static final EntityDescriptor<Some> Some = (EntityDescriptor<Some>) instance
			.valueOf(Some_ord);
	public static final EntityDescriptor<Every> Every = (EntityDescriptor<Every>) instance
			.valueOf(Every_ord);
	public static final EntityDescriptor<ParenthesizedPredicate> ParenthesizedPredicate = (EntityDescriptor<ParenthesizedPredicate>) instance
			.valueOf(ParenthesizedPredicate_ord);
	public static final EntityDescriptor<EntityType> EntityType = (EntityDescriptor<EntityType>) instance
			.valueOf(EntityType_ord);
	public static final EntityDescriptor<NamesExpression> NamesExpression = (EntityDescriptor<NamesExpression>) instance
			.valueOf(NamesExpression_ord);
	public static final EntityDescriptor<TemplateNames> TemplateNames = (EntityDescriptor<TemplateNames>) instance
			.valueOf(TemplateNames_ord);
	public static final EntityDescriptor<AllNames> AllNames = (EntityDescriptor<AllNames>) instance
			.valueOf(AllNames_ord);
	public static final EntityDescriptor<AddNames> AddNames = (EntityDescriptor<AddNames>) instance
			.valueOf(AddNames_ord);
	public static final EntityDescriptor<RemoveNames> RemoveNames = (EntityDescriptor<RemoveNames>) instance
			.valueOf(RemoveNames_ord);
	public static final EntityDescriptor<Names> Names = (EntityDescriptor<Names>) instance
			.valueOf(Names_ord);
	public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance
			.valueOf(Name_ord);
	public static final EntityDescriptor<Expression> Expression = (EntityDescriptor<Expression>) instance
			.valueOf(Expression_ord);
	public static final EntityDescriptor<CollectByExpression> CollectByExpression = (EntityDescriptor<CollectByExpression>) instance
			.valueOf(CollectByExpression_ord);
	public static final EntityDescriptor<Comparator> Comparator = (EntityDescriptor<Comparator>) instance
			.valueOf(Comparator_ord);
	public static final EntityDescriptor<IdentityComparator> IdentityComparator = (EntityDescriptor<IdentityComparator>) instance
			.valueOf(IdentityComparator_ord);
	public static final EntityDescriptor<UnionAll> UnionAll = (EntityDescriptor<UnionAll>) instance
			.valueOf(UnionAll_ord);
	public static final EntityDescriptor<Union> Union = (EntityDescriptor<Union>) instance
			.valueOf(Union_ord);
	public static final EntityDescriptor<Intersect> Intersect = (EntityDescriptor<Intersect>) instance
			.valueOf(Intersect_ord);
	public static final EntityDescriptor<Except> Except = (EntityDescriptor<Except>) instance
			.valueOf(Except_ord);
	public static final EntityDescriptor<VariableRefStep> VariableRefStep = (EntityDescriptor<VariableRefStep>) instance
			.valueOf(VariableRefStep_ord);
	public static final EntityDescriptor<Singleton> Singleton = (EntityDescriptor<Singleton>) instance
			.valueOf(Singleton_ord);
	public static final EntityDescriptor<PointwiseEquals> PointwiseEquals = (EntityDescriptor<PointwiseEquals>) instance
			.valueOf(PointwiseEquals_ord);
	public static final EntityDescriptor<Tuple> Tuple = (EntityDescriptor<Tuple>) instance
			.valueOf(Tuple_ord);
	public static final EntityDescriptor<Addition> Addition = (EntityDescriptor<Addition>) instance
			.valueOf(Addition_ord);
	public static final EntityDescriptor<Subtraction> Subtraction = (EntityDescriptor<Subtraction>) instance
			.valueOf(Subtraction_ord);
	public static final EntityDescriptor<Multiplication> Multiplication = (EntityDescriptor<Multiplication>) instance
			.valueOf(Multiplication_ord);
	public static final EntityDescriptor<Division> Division = (EntityDescriptor<Division>) instance
			.valueOf(Division_ord);
	public static final EntityDescriptor<Remainder> Remainder = (EntityDescriptor<Remainder>) instance
			.valueOf(Remainder_ord);
	public static final EntityDescriptor<Equals> Equals = (EntityDescriptor<Equals>) instance
			.valueOf(Equals_ord);
	public static final EntityDescriptor<NotEquals> NotEquals = (EntityDescriptor<NotEquals>) instance
			.valueOf(NotEquals_ord);
	public static final EntityDescriptor<LessThan> LessThan = (EntityDescriptor<LessThan>) instance
			.valueOf(LessThan_ord);
	public static final EntityDescriptor<LessOrEquals> LessOrEquals = (EntityDescriptor<LessOrEquals>) instance
			.valueOf(LessOrEquals_ord);
	public static final EntityDescriptor<GreaterThan> GreaterThan = (EntityDescriptor<GreaterThan>) instance
			.valueOf(GreaterThan_ord);
	public static final EntityDescriptor<GreaterOrEquals> GreaterOrEquals = (EntityDescriptor<GreaterOrEquals>) instance
			.valueOf(GreaterOrEquals_ord);
	public static final EntityDescriptor<Literal> Literal = (EntityDescriptor<Literal>) instance
			.valueOf(Literal_ord);
	public static final EntityDescriptor<VoidLiteral> VoidLiteral = (EntityDescriptor<VoidLiteral>) instance
			.valueOf(VoidLiteral_ord);
	public static final EntityDescriptor<BooleanLiteral> BooleanLiteral = (EntityDescriptor<BooleanLiteral>) instance
			.valueOf(BooleanLiteral_ord);
	public static final EntityDescriptor<ByteLiteral> ByteLiteral = (EntityDescriptor<ByteLiteral>) instance
			.valueOf(ByteLiteral_ord);
	public static final EntityDescriptor<CharLiteral> CharLiteral = (EntityDescriptor<CharLiteral>) instance
			.valueOf(CharLiteral_ord);
	public static final EntityDescriptor<DoubleLiteral> DoubleLiteral = (EntityDescriptor<DoubleLiteral>) instance
			.valueOf(DoubleLiteral_ord);
	public static final EntityDescriptor<FloatLiteral> FloatLiteral = (EntityDescriptor<FloatLiteral>) instance
			.valueOf(FloatLiteral_ord);
	public static final EntityDescriptor<IntLiteral> IntLiteral = (EntityDescriptor<IntLiteral>) instance
			.valueOf(IntLiteral_ord);
	public static final EntityDescriptor<LongLiteral> LongLiteral = (EntityDescriptor<LongLiteral>) instance
			.valueOf(LongLiteral_ord);
	public static final EntityDescriptor<ShortLiteral> ShortLiteral = (EntityDescriptor<ShortLiteral>) instance
			.valueOf(ShortLiteral_ord);
	public static final EntityDescriptor<DateLiteral> DateLiteral = (EntityDescriptor<DateLiteral>) instance
			.valueOf(DateLiteral_ord);
	public static final EntityDescriptor<StringLiteral> StringLiteral = (EntityDescriptor<StringLiteral>) instance
			.valueOf(StringLiteral_ord);
	public static final EntityDescriptor<Placement> Placement = (EntityDescriptor<Placement>) instance
			.valueOf(Placement_ord);

	private QueriesEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(PathExpressionOrPredicate_ord,
				"PathExpressionOrPredicate", PathExpressionOrPredicate.class,
				true, Some_ord, PrecedingSiblingStep_ord, ExpressionTest_ord,
				DescendantStep_ord, LessThan_ord, FloatLiteral_ord,
				FollowingStep_ord, Singleton_ord, Path_ord, RootStep_ord,
				AtFeatureTest_ord, Except_ord, TypeTest_ord,
				CollectByExpression_ord, CharLiteral_ord, Union_ord,
				AtTypeTest_ord, Every_ord, Do_ord, Filter_ord,
				LanguageTest_ord, CartesianUpdate_ord,
				DescendantOrSelfStep_ord, AtIndexTest_ord, StepExpression_ord,
				ReachableOrSelfStep_ord, InverseAdjacentStep_ord,
				InverseReachableOrSelfStep_ord, VoidLiteral_ord,
				DirectStep_ord, Choose_ord, InverseStep_ord, Remainder_ord,
				KindTest_ord, UnionAll_ord, EntityTemplate_ord,
				DistinctTest_ord, PointwiseProduct_ord, CartesianProduct_ord,
				EntityCall_ord, SupertypeTest_ord, Expression_ord, One_ord,
				Block_ord, Scope_ord, Multiplication_ord, ReverseStep_ord,
				IndexVariableTest_ord, ReachableStep_ord, VisitorTest_ord,
				Intersect_ord, QuantifiedPredicate_ord, ChildStep_ord,
				ParenthesizedPredicate_ord, QueryDeclaration_ord, Equals_ord,
				DoubleLiteral_ord, BooleanLiteral_ord, FeatureStep_ord,
				AdjacentStep_ord, ParentStep_ord, GreaterOrEquals_ord,
				Tuple_ord, GreaterThan_ord, Delete_ord, Sequence_ord,
				PrecedingStep_ord, FragmentRootStep_ord, PathExpression_ord,
				Literal_ord, CartesianInsert_ord, Call_ord, SelfStep_ord,
				StageTest_ord, DateLiteral_ord, Select_ord, Subtraction_ord,
				PointwiseEquals_ord, Or_ord, AncestorOrSelfStep_ord,
				Predicate_ord, VariableRefStep_ord, If_ord, And_ord,
				PointwiseUpdate_ord, ShortLiteral_ord, LongLiteral_ord,
				FollowingSiblingStep_ord, ForwardStep_ord, NotEquals_ord,
				VariableTest_ord, IntLiteral_ord, LessOrEquals_ord,
				AncestorStep_ord, For_ord, Addition_ord, StringLiteral_ord,
				PointwiseInsert_ord, SubtypeTest_ord, AspectStep_ord, Not_ord,
				ByteLiteral_ord, IndexTest_ord, Division_ord,
				IndexRangeTest_ord, StageVariableTest_ord,
				InverseReachableStep_ord);
		putSimpleEntity(PathExpression_ord, "PathExpression",
				PathExpression.class, true, PrecedingSiblingStep_ord,
				DescendantStep_ord, AdjacentStep_ord, LessThan_ord,
				FloatLiteral_ord, FollowingStep_ord, ParentStep_ord,
				Singleton_ord, Path_ord, GreaterOrEquals_ord, RootStep_ord,
				Tuple_ord, GreaterThan_ord, Delete_ord, Except_ord,
				Sequence_ord, PrecedingStep_ord, FragmentRootStep_ord,
				Literal_ord, CartesianInsert_ord, Call_ord,
				CollectByExpression_ord, CharLiteral_ord, SelfStep_ord,
				Union_ord, DateLiteral_ord, Do_ord, Filter_ord, Select_ord,
				CartesianUpdate_ord, Subtraction_ord, PointwiseEquals_ord,
				DescendantOrSelfStep_ord, AncestorOrSelfStep_ord,
				VariableRefStep_ord, If_ord, PointwiseUpdate_ord,
				LongLiteral_ord, ShortLiteral_ord, StepExpression_ord,
				FollowingSiblingStep_ord, InverseReachableOrSelfStep_ord,
				InverseAdjacentStep_ord, ReachableOrSelfStep_ord,
				VoidLiteral_ord, ForwardStep_ord, NotEquals_ord,
				DirectStep_ord, IntLiteral_ord, Choose_ord, LessOrEquals_ord,
				InverseStep_ord, Remainder_ord, UnionAll_ord,
				EntityTemplate_ord, AncestorStep_ord, EntityCall_ord,
				CartesianProduct_ord, PointwiseProduct_ord, Expression_ord,
				For_ord, Addition_ord, Block_ord, Scope_ord, StringLiteral_ord,
				Multiplication_ord, ReverseStep_ord, ReachableStep_ord,
				PointwiseInsert_ord, AspectStep_ord, Intersect_ord,
				ChildStep_ord, ByteLiteral_ord, QueryDeclaration_ord,
				Division_ord, Equals_ord, DoubleLiteral_ord, FeatureStep_ord,
				BooleanLiteral_ord, InverseReachableStep_ord);
		putSimpleEntity(QueryDeclaration_ord, "QueryDeclaration",
				QueryDeclaration.class, false)
				.withFeature(QueriesFeatureDescriptorEnum.name, Name_ord)
				.withFeature(QueriesFeatureDescriptorEnum.parameters,
						Names_ord, true, false, false, false, false)
				.withFeature(QueriesFeatureDescriptorEnum.body,
						PathExpression_ord);
		putCompositeEntity(Path_ord, "Path", Path.class, false,
				StepExpression_ord, true, false);
		putSimpleEntity(Delete_ord, "Delete", Delete.class, false).withFeature(
				QueriesFeatureDescriptorEnum.fromClause, PathExpression_ord);
		putSimpleEntity(CartesianInsert_ord, "CartesianInsert",
				CartesianInsert.class, false)
				.withFeature(QueriesFeatureDescriptorEnum.placement,
						Placement_ord)
				.withFeature(QueriesFeatureDescriptorEnum.fromClause,
						PathExpression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.valuesClause,
						PathExpression_ord);
		putSimpleEntity(PointwiseInsert_ord, "PointwiseInsert",
				PointwiseInsert.class, false)
				.withFeature(QueriesFeatureDescriptorEnum.placement,
						Placement_ord)
				.withFeature(QueriesFeatureDescriptorEnum.fromClause,
						PathExpression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.valuesClause,
						PathExpression_ord);
		putSimpleEntity(CartesianUpdate_ord, "CartesianUpdate",
				CartesianUpdate.class, false).withFeature(
				QueriesFeatureDescriptorEnum.fromClause, PathExpression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.valuesClause,
						PathExpression_ord);
		putSimpleEntity(PointwiseUpdate_ord, "PointwiseUpdate",
				PointwiseUpdate.class, false).withFeature(
				QueriesFeatureDescriptorEnum.fromClause, PathExpression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.valuesClause,
						PathExpression_ord);
		putSimpleEntity(Select_ord, "Select", Select.class, false)
				.withFeature(QueriesFeatureDescriptorEnum.selectClause,
						PathExpression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.fromClause,
						PathExpressionOrPredicate_ord)
				.withFeature(QueriesFeatureDescriptorEnum.whereClause,
						PathExpression_ord, true, false, false, false, false)
				.withFeature(QueriesFeatureDescriptorEnum.clearClause,
						NamesExpression_ord, true, false, false, false, false);
		putSimpleEntity(For_ord, "For", For.class, false).withFeature(
				QueriesFeatureDescriptorEnum.fromClause, PathExpression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.expression,
						PathExpression_ord);
		putSimpleEntity(If_ord, "If", If.class, false).withFeature(
				QueriesFeatureDescriptorEnum.predicate, Predicate_ord)
				.withFeature(QueriesFeatureDescriptorEnum.expression,
						PathExpression_ord);
		putSimpleEntity(Do_ord, "Do", Do.class, false).withFeature(
				QueriesFeatureDescriptorEnum.expression, PathExpression_ord);
		putSimpleEntity(StepExpression_ord, "StepExpression",
				StepExpression.class, true, PrecedingSiblingStep_ord,
				DescendantStep_ord, LessThan_ord, AdjacentStep_ord,
				FloatLiteral_ord, FollowingStep_ord, Singleton_ord,
				ParentStep_ord, GreaterOrEquals_ord, Tuple_ord, RootStep_ord,
				GreaterThan_ord, Except_ord, Sequence_ord, PrecedingStep_ord,
				FragmentRootStep_ord, Literal_ord, Call_ord,
				CollectByExpression_ord, CharLiteral_ord, SelfStep_ord,
				Union_ord, DateLiteral_ord, Filter_ord, Subtraction_ord,
				PointwiseEquals_ord, DescendantOrSelfStep_ord,
				AncestorOrSelfStep_ord, VariableRefStep_ord, LongLiteral_ord,
				ShortLiteral_ord, FollowingSiblingStep_ord,
				InverseReachableOrSelfStep_ord, InverseAdjacentStep_ord,
				ReachableOrSelfStep_ord, VoidLiteral_ord, NotEquals_ord,
				ForwardStep_ord, DirectStep_ord, IntLiteral_ord, Choose_ord,
				LessOrEquals_ord, InverseStep_ord, Remainder_ord, UnionAll_ord,
				EntityTemplate_ord, AncestorStep_ord, PointwiseProduct_ord,
				CartesianProduct_ord, EntityCall_ord, Expression_ord,
				Addition_ord, Block_ord, Scope_ord, StringLiteral_ord,
				Multiplication_ord, ReverseStep_ord, ReachableStep_ord,
				AspectStep_ord, Intersect_ord, ChildStep_ord, ByteLiteral_ord,
				Division_ord, Equals_ord, DoubleLiteral_ord, FeatureStep_ord,
				BooleanLiteral_ord, InverseReachableStep_ord);
		putSimpleEntity(EntityTemplate_ord, "EntityTemplate",
				EntityTemplate.class, false).withFeature(
				QueriesFeatureDescriptorEnum.name, EntityType_ord).withFeature(
				QueriesFeatureDescriptorEnum.constraints, Constraints_ord,
				true, false, false, false, false);
		putSimpleEntity(EntityCall_ord, "EntityCall", EntityCall.class, false)
				.withFeature(QueriesFeatureDescriptorEnum.name, EntityType_ord)
				.withFeature(QueriesFeatureDescriptorEnum.bindings,
						Bindings_ord, true, false, false, false, false);
		putSimpleEntity(Call_ord, "Call", Call.class, false).withFeature(
				QueriesFeatureDescriptorEnum.name, Name_ord).withFeature(
				QueriesFeatureDescriptorEnum.arguments, Expressions_ord, true,
				false, false, false, false);
		putSimpleEntity(Constraints_ord, "Constraints", Constraints.class,
				true, Bindings_ord, Expressions_ord);
		putCompositeEntity(Expressions_ord, "Expressions", Expressions.class,
				false, PathExpression_ord, true, false);
		putCompositeEntity(Bindings_ord, "Bindings", Bindings.class, false,
				Bind_ord, true, false);
		putSimpleEntity(Bind_ord, "Bind", Bind.class, false).withFeature(
				QueriesFeatureDescriptorEnum.name, Name_ord)
				.withFeature(QueriesFeatureDescriptorEnum.expression,
						PathExpressionOrPredicate_ord, true, false, false,
						false, false);
		putCompositeEntity(Choose_ord, "Choose", Choose.class, false,
				PathExpression_ord, true, false);
		putCompositeEntity(Block_ord, "Block", Block.class, false,
				PathExpression_ord, true, false);
		putCompositeEntity(Sequence_ord, "Sequence", Sequence.class, false,
				PathExpression_ord, true, false);
		putSimpleEntity(Scope_ord, "Scope", Scope.class, false).withFeature(
				QueriesFeatureDescriptorEnum.localNames, Names_ord)
				.withFeature(QueriesFeatureDescriptorEnum.expression,
						PathExpression_ord);
		putCompositeEntity(CartesianProduct_ord, "CartesianProduct",
				CartesianProduct.class, false, PathExpression_ord, true, false);
		putCompositeEntity(PointwiseProduct_ord, "PointwiseProduct",
				PointwiseProduct.class, false, PathExpression_ord, true, false);
		putSimpleEntity(Filter_ord, "Filter", Filter.class, false).withFeature(
				QueriesFeatureDescriptorEnum.expression, StepExpression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.predicate,
						PruneOrPredicate_ord);
		putSimpleEntity(AspectStep_ord, "AspectStep", AspectStep.class, false);
		putSimpleEntity(DirectStep_ord, "DirectStep", DirectStep.class, true,
				ReachableOrSelfStep_ord, AdjacentStep_ord, ReachableStep_ord);
		putSimpleEntity(AdjacentStep_ord, "AdjacentStep", AdjacentStep.class,
				false);
		putSimpleEntity(ReachableStep_ord, "ReachableStep",
				ReachableStep.class, false);
		putSimpleEntity(ReachableOrSelfStep_ord, "ReachableOrSelfStep",
				ReachableOrSelfStep.class, false);
		putSimpleEntity(InverseStep_ord, "InverseStep", InverseStep.class,
				true, InverseAdjacentStep_ord, InverseReachableOrSelfStep_ord,
				InverseReachableStep_ord);
		putSimpleEntity(InverseAdjacentStep_ord, "InverseAdjacentStep",
				InverseAdjacentStep.class, false);
		putSimpleEntity(InverseReachableStep_ord, "InverseReachableStep",
				InverseReachableStep.class, false);
		putSimpleEntity(InverseReachableOrSelfStep_ord,
				"InverseReachableOrSelfStep", InverseReachableOrSelfStep.class,
				false);
		putSimpleEntity(RootStep_ord, "RootStep", RootStep.class, false);
		putSimpleEntity(FragmentRootStep_ord, "FragmentRootStep",
				FragmentRootStep.class, false);
		putSimpleEntity(SelfStep_ord, "SelfStep", SelfStep.class, false);
		putSimpleEntity(ForwardStep_ord, "ForwardStep", ForwardStep.class,
				true, FollowingStep_ord, ChildStep_ord, DescendantStep_ord,
				FollowingSiblingStep_ord, FeatureStep_ord,
				DescendantOrSelfStep_ord);
		putDataEntity(FeatureStep_ord, "FeatureStep", FeatureStep.class, false,
				String.class);
		putSimpleEntity(ChildStep_ord, "ChildStep", ChildStep.class, false);
		putSimpleEntity(DescendantStep_ord, "DescendantStep",
				DescendantStep.class, false);
		putSimpleEntity(DescendantOrSelfStep_ord, "DescendantOrSelfStep",
				DescendantOrSelfStep.class, false);
		putSimpleEntity(FollowingSiblingStep_ord, "FollowingSiblingStep",
				FollowingSiblingStep.class, false);
		putSimpleEntity(FollowingStep_ord, "FollowingStep",
				FollowingStep.class, false);
		putSimpleEntity(ReverseStep_ord, "ReverseStep", ReverseStep.class,
				true, AncestorStep_ord, PrecedingSiblingStep_ord,
				ParentStep_ord, PrecedingStep_ord, AncestorOrSelfStep_ord);
		putSimpleEntity(ParentStep_ord, "ParentStep", ParentStep.class, false);
		putSimpleEntity(AncestorStep_ord, "AncestorStep", AncestorStep.class,
				false);
		putSimpleEntity(AncestorOrSelfStep_ord, "AncestorOrSelfStep",
				AncestorOrSelfStep.class, false);
		putSimpleEntity(PrecedingSiblingStep_ord, "PrecedingSiblingStep",
				PrecedingSiblingStep.class, false);
		putSimpleEntity(PrecedingStep_ord, "PrecedingStep",
				PrecedingStep.class, false);
		putSimpleEntity(PruneOrPredicate_ord, "PruneOrPredicate",
				PruneOrPredicate.class, true, Some_ord, ExpressionTest_ord,
				VariableTest_ord, KindTest_ord, AtFeatureTest_ord,
				DistinctTest_ord, SupertypeTest_ord, One_ord, Prune_ord,
				IndexVariableTest_ord, TypeTest_ord, VisitorTest_ord,
				StageTest_ord, SubtypeTest_ord, Every_ord, AtTypeTest_ord,
				Not_ord, QuantifiedPredicate_ord, LanguageTest_ord,
				ParenthesizedPredicate_ord, IndexTest_ord, Or_ord,
				Predicate_ord, AtIndexTest_ord, IndexRangeTest_ord,
				StageVariableTest_ord, And_ord);
		putSimpleEntity(Prune_ord, "Prune", Prune.class, false).withFeature(
				QueriesFeatureDescriptorEnum.predicate, Predicate_ord);
		putSimpleEntity(Predicate_ord, "Predicate", Predicate.class, true,
				Some_ord, ExpressionTest_ord, VariableTest_ord, KindTest_ord,
				AtFeatureTest_ord, DistinctTest_ord, SupertypeTest_ord,
				One_ord, IndexVariableTest_ord, TypeTest_ord, VisitorTest_ord,
				StageTest_ord, SubtypeTest_ord, Every_ord, AtTypeTest_ord,
				Not_ord, QuantifiedPredicate_ord, LanguageTest_ord,
				ParenthesizedPredicate_ord, IndexTest_ord, Or_ord,
				AtIndexTest_ord, IndexRangeTest_ord, StageVariableTest_ord,
				And_ord);
		putDataEntity(VariableTest_ord, "VariableTest", VariableTest.class,
				false, String.class);
		putDataEntity(IndexVariableTest_ord, "IndexVariableTest",
				IndexVariableTest.class, false, String.class);
		putDataEntity(KindTest_ord, "KindTest", KindTest.class, false,
				KindTestEnum.Value.class);
		putDataEntity(StageTest_ord, "StageTest", StageTest.class, false,
				StageTestEnum.Value.class);
		putDataEntity(StageVariableTest_ord, "StageVariableTest",
				StageVariableTest.class, false, String.class);
		putDataEntity(LanguageTest_ord, "LanguageTest", LanguageTest.class,
				false, String.class);
		putDataEntity(TypeTest_ord, "TypeTest", TypeTest.class, false,
				String.class);
		putDataEntity(SubtypeTest_ord, "SubtypeTest", SubtypeTest.class, false,
				String.class);
		putDataEntity(SupertypeTest_ord, "SupertypeTest", SupertypeTest.class,
				false, String.class);
		putDataEntity(AtTypeTest_ord, "AtTypeTest", AtTypeTest.class, false,
				String.class);
		putDataEntity(AtFeatureTest_ord, "AtFeatureTest", AtFeatureTest.class,
				false, String.class);
		putDataEntity(AtIndexTest_ord, "AtIndexTest", AtIndexTest.class, false,
				int.class);
		putSimpleEntity(IndexTest_ord, "IndexTest", IndexTest.class, false)
				.withFeature(QueriesFeatureDescriptorEnum.index, IntLiteral_ord);
		putSimpleEntity(IndexRangeTest_ord, "IndexRangeTest",
				IndexRangeTest.class, false).withFeature(
				QueriesFeatureDescriptorEnum.startIndex, IntLiteral_ord)
				.withFeature(QueriesFeatureDescriptorEnum.endIndex,
						IntLiteral_ord, true, false, false, false, false);
		putDataEntity(VisitorTest_ord, "VisitorTest", VisitorTest.class, false,
				org.whole.lang.visitors.IVisitor.class);
		putSimpleEntity(ExpressionTest_ord, "ExpressionTest",
				ExpressionTest.class, false).withFeature(
				QueriesFeatureDescriptorEnum.expression, PathExpression_ord);
		putSimpleEntity(DistinctTest_ord, "DistinctTest", DistinctTest.class,
				false).withFeature(QueriesFeatureDescriptorEnum.comparator,
				Comparator_ord, true, false, false, false, false);
		putCompositeEntity(And_ord, "And", And.class, false, Predicate_ord,
				true, false);
		putCompositeEntity(Or_ord, "Or", Or.class, false, Predicate_ord, true,
				false);
		putSimpleEntity(Not_ord, "Not", Not.class, false).withFeature(
				QueriesFeatureDescriptorEnum.predicate, Predicate_ord);
		putSimpleEntity(QuantifiedPredicate_ord, "QuantifiedPredicate",
				QuantifiedPredicate.class, true, One_ord, Some_ord, Every_ord)
				.withFeature(QueriesFeatureDescriptorEnum.fromClause,
						PathExpression_ord).withFeature(
						QueriesFeatureDescriptorEnum.whereClause,
						Predicate_ord, true, false, false, false, false);
		putSimpleEntity(One_ord, "One", One.class, false).withFeature(
				QueriesFeatureDescriptorEnum.fromClause, PathExpression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.whereClause,
						Predicate_ord, true, false, false, false, false);
		putSimpleEntity(Some_ord, "Some", Some.class, false).withFeature(
				QueriesFeatureDescriptorEnum.fromClause, PathExpression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.whereClause,
						Predicate_ord, true, false, false, false, false);
		putSimpleEntity(Every_ord, "Every", Every.class, false).withFeature(
				QueriesFeatureDescriptorEnum.fromClause, PathExpression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.whereClause,
						Predicate_ord, true, false, false, false, false);
		putSimpleEntity(ParenthesizedPredicate_ord, "ParenthesizedPredicate",
				ParenthesizedPredicate.class, false).withFeature(
				QueriesFeatureDescriptorEnum.predicate, Predicate_ord);
		putDataEntity(EntityType_ord, "EntityType", EntityType.class, false,
				String.class);
		putSimpleEntity(NamesExpression_ord, "NamesExpression",
				NamesExpression.class, true, RemoveNames_ord, AllNames_ord,
				AddNames_ord, Names_ord, TemplateNames_ord);
		putSimpleEntity(TemplateNames_ord, "TemplateNames",
				TemplateNames.class, false);
		putSimpleEntity(AllNames_ord, "AllNames", AllNames.class, false);
		putSimpleEntity(AddNames_ord, "AddNames", AddNames.class, false)
				.withFeature(QueriesFeatureDescriptorEnum.expression,
						NamesExpression_ord).withFeature(
						QueriesFeatureDescriptorEnum.names, Names_ord);
		putSimpleEntity(RemoveNames_ord, "RemoveNames", RemoveNames.class,
				false).withFeature(QueriesFeatureDescriptorEnum.expression,
				NamesExpression_ord).withFeature(
				QueriesFeatureDescriptorEnum.names, Names_ord);
		putCompositeEntity(Names_ord, "Names", Names.class, false, Name_ord,
				true, false);
		putDataEntity(Name_ord, "Name", Name.class, false, String.class);
		putSimpleEntity(Expression_ord, "Expression", Expression.class, true,
				VoidLiteral_ord, NotEquals_ord, LessThan_ord, FloatLiteral_ord,
				IntLiteral_ord, Singleton_ord, GreaterOrEquals_ord,
				LessOrEquals_ord, Tuple_ord, Remainder_ord, UnionAll_ord,
				GreaterThan_ord, Except_ord, Addition_ord, StringLiteral_ord,
				Multiplication_ord, Literal_ord, CollectByExpression_ord,
				CharLiteral_ord, Union_ord, DateLiteral_ord, Intersect_ord,
				ByteLiteral_ord, Subtraction_ord, PointwiseEquals_ord,
				Division_ord, VariableRefStep_ord, Equals_ord,
				DoubleLiteral_ord, BooleanLiteral_ord, LongLiteral_ord,
				ShortLiteral_ord);
		putSimpleEntity(CollectByExpression_ord, "CollectByExpression",
				CollectByExpression.class, true, Intersect_ord, Union_ord,
				Except_ord).withFeature(
				QueriesFeatureDescriptorEnum.expressions, Expressions_ord)
				.withFeature(QueriesFeatureDescriptorEnum.comparator,
						Comparator_ord, true, false, false, false, false);
		putSimpleEntity(Comparator_ord, "Comparator", Comparator.class, true,
				IdentityComparator_ord);
		putSimpleEntity(IdentityComparator_ord, "IdentityComparator",
				IdentityComparator.class, false).withFeature(
				QueriesFeatureDescriptorEnum.identity, StepExpression_ord);
		putSimpleEntity(UnionAll_ord, "UnionAll", UnionAll.class, false)
				.withFeature(QueriesFeatureDescriptorEnum.expressions,
						Expressions_ord);
		putSimpleEntity(Union_ord, "Union", Union.class, false).withFeature(
				QueriesFeatureDescriptorEnum.expressions, Expressions_ord)
				.withFeature(QueriesFeatureDescriptorEnum.comparator,
						Comparator_ord, true, false, false, false, false);
		putSimpleEntity(Intersect_ord, "Intersect", Intersect.class, false)
				.withFeature(QueriesFeatureDescriptorEnum.expressions,
						Expressions_ord).withFeature(
						QueriesFeatureDescriptorEnum.comparator,
						Comparator_ord, true, false, false, false, false);
		putSimpleEntity(Except_ord, "Except", Except.class, false).withFeature(
				QueriesFeatureDescriptorEnum.expressions, Expressions_ord)
				.withFeature(QueriesFeatureDescriptorEnum.comparator,
						Comparator_ord, true, false, false, false, false);
		putDataEntity(VariableRefStep_ord, "VariableRefStep",
				VariableRefStep.class, false, String.class);
		putSimpleEntity(Singleton_ord, "Singleton", Singleton.class, false)
				.withFeature(QueriesFeatureDescriptorEnum.expression,
						PathExpression_ord);
		putSimpleEntity(PointwiseEquals_ord, "PointwiseEquals",
				PointwiseEquals.class, false).withFeature(
				QueriesFeatureDescriptorEnum.pexp1, PathExpression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.pexp2,
						PathExpression_ord);
		putCompositeEntity(Tuple_ord, "Tuple", Tuple.class, false,
				PathExpression_ord, true, false);
		putSimpleEntity(Addition_ord, "Addition", Addition.class, false)
				.withFeature(QueriesFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(Subtraction_ord, "Subtraction", Subtraction.class,
				false).withFeature(QueriesFeatureDescriptorEnum.exp1,
				Expression_ord).withFeature(QueriesFeatureDescriptorEnum.exp2,
				Expression_ord);
		putSimpleEntity(Multiplication_ord, "Multiplication",
				Multiplication.class, false).withFeature(
				QueriesFeatureDescriptorEnum.exp1, Expression_ord).withFeature(
				QueriesFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(Division_ord, "Division", Division.class, false)
				.withFeature(QueriesFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(Remainder_ord, "Remainder", Remainder.class, false)
				.withFeature(QueriesFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(Equals_ord, "Equals", Equals.class, false).withFeature(
				QueriesFeatureDescriptorEnum.exp1, Expression_ord).withFeature(
				QueriesFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(NotEquals_ord, "NotEquals", NotEquals.class, false)
				.withFeature(QueriesFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(LessThan_ord, "LessThan", LessThan.class, false)
				.withFeature(QueriesFeatureDescriptorEnum.exp1, Expression_ord)
				.withFeature(QueriesFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(LessOrEquals_ord, "LessOrEquals", LessOrEquals.class,
				false).withFeature(QueriesFeatureDescriptorEnum.exp1,
				Expression_ord).withFeature(QueriesFeatureDescriptorEnum.exp2,
				Expression_ord);
		putSimpleEntity(GreaterThan_ord, "GreaterThan", GreaterThan.class,
				false).withFeature(QueriesFeatureDescriptorEnum.exp1,
				Expression_ord).withFeature(QueriesFeatureDescriptorEnum.exp2,
				Expression_ord);
		putSimpleEntity(GreaterOrEquals_ord, "GreaterOrEquals",
				GreaterOrEquals.class, false).withFeature(
				QueriesFeatureDescriptorEnum.exp1, Expression_ord).withFeature(
				QueriesFeatureDescriptorEnum.exp2, Expression_ord);
		putSimpleEntity(Literal_ord, "Literal", Literal.class, true,
				StringLiteral_ord, ByteLiteral_ord, VoidLiteral_ord,
				FloatLiteral_ord, CharLiteral_ord, IntLiteral_ord,
				DoubleLiteral_ord, DateLiteral_ord, BooleanLiteral_ord,
				LongLiteral_ord, ShortLiteral_ord);
		putSimpleEntity(VoidLiteral_ord, "VoidLiteral", VoidLiteral.class,
				false);
		putDataEntity(BooleanLiteral_ord, "BooleanLiteral",
				BooleanLiteral.class, false, boolean.class);
		putDataEntity(ByteLiteral_ord, "ByteLiteral", ByteLiteral.class, false,
				byte.class);
		putDataEntity(CharLiteral_ord, "CharLiteral", CharLiteral.class, false,
				char.class);
		putDataEntity(DoubleLiteral_ord, "DoubleLiteral", DoubleLiteral.class,
				false, double.class);
		putDataEntity(FloatLiteral_ord, "FloatLiteral", FloatLiteral.class,
				false, float.class);
		putDataEntity(IntLiteral_ord, "IntLiteral", IntLiteral.class, false,
				int.class);
		putDataEntity(LongLiteral_ord, "LongLiteral", LongLiteral.class, false,
				long.class);
		putDataEntity(ShortLiteral_ord, "ShortLiteral", ShortLiteral.class,
				false, short.class);
		putDataEntity(DateLiteral_ord, "DateLiteral", DateLiteral.class, false,
				java.util.Date.class);
		putDataEntity(StringLiteral_ord, "StringLiteral", StringLiteral.class,
				false, String.class);
		putDataEntity(Placement_ord, "Placement", Placement.class, false,
				PlacementEnum.Value.class);
	}

	protected void initForeignTypeRelations() {
		setAliasOf(true, "http://lang.whole.org/Math#Expression",
				Expression_ord);
	}
}
