package org.whole.lang.scheme.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.scheme.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class SchemeEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int Definitions_ord = 0;
	public static final int Definition_ord = 1;
	public static final int Branches_ord = 2;
	public static final int Branch_ord = 3;
	public static final int SchemeExpressions_ord = 4;
	public static final int SchemeExpression_ord = 5;
	public static final int ApplyExpression_ord = 6;
	public static final int LambdaExpression_ord = 7;
	public static final int AndExpression_ord = 8;
	public static final int OrExpression_ord = 9;
	public static final int CondExpression_ord = 10;
	public static final int LocalExpression_ord = 11;
	public static final int IdExpression_ord = 12;
	public static final int ConstExpression_ord = 13;
	public static final int ClosureValue_ord = 14;
	public static final int BuiltinValue_ord = 15;
	public static final int BooleanValue_ord = 16;
	public static final int IntValue_ord = 17;
	public static final int StringValue_ord = 18;
	public static final int PairValue_ord = 19;
	public static final int Names_ord = 20;
	public static final int Name_ord = 21;
	public static final int SchemeEnvironment_ord = 22;
	public static final SchemeEntityDescriptorEnum instance = new SchemeEntityDescriptorEnum();
	public static final EntityDescriptor<Definitions> Definitions = (EntityDescriptor<Definitions>) instance
			.valueOf(Definitions_ord);
	public static final EntityDescriptor<Definition> Definition = (EntityDescriptor<Definition>) instance
			.valueOf(Definition_ord);
	public static final EntityDescriptor<Branches> Branches = (EntityDescriptor<Branches>) instance
			.valueOf(Branches_ord);
	public static final EntityDescriptor<Branch> Branch = (EntityDescriptor<Branch>) instance
			.valueOf(Branch_ord);
	public static final EntityDescriptor<SchemeExpressions> SchemeExpressions = (EntityDescriptor<SchemeExpressions>) instance
			.valueOf(SchemeExpressions_ord);
	public static final EntityDescriptor<SchemeExpression> SchemeExpression = (EntityDescriptor<SchemeExpression>) instance
			.valueOf(SchemeExpression_ord);
	public static final EntityDescriptor<ApplyExpression> ApplyExpression = (EntityDescriptor<ApplyExpression>) instance
			.valueOf(ApplyExpression_ord);
	public static final EntityDescriptor<LambdaExpression> LambdaExpression = (EntityDescriptor<LambdaExpression>) instance
			.valueOf(LambdaExpression_ord);
	public static final EntityDescriptor<AndExpression> AndExpression = (EntityDescriptor<AndExpression>) instance
			.valueOf(AndExpression_ord);
	public static final EntityDescriptor<OrExpression> OrExpression = (EntityDescriptor<OrExpression>) instance
			.valueOf(OrExpression_ord);
	public static final EntityDescriptor<CondExpression> CondExpression = (EntityDescriptor<CondExpression>) instance
			.valueOf(CondExpression_ord);
	public static final EntityDescriptor<LocalExpression> LocalExpression = (EntityDescriptor<LocalExpression>) instance
			.valueOf(LocalExpression_ord);
	public static final EntityDescriptor<IdExpression> IdExpression = (EntityDescriptor<IdExpression>) instance
			.valueOf(IdExpression_ord);
	public static final EntityDescriptor<ConstExpression> ConstExpression = (EntityDescriptor<ConstExpression>) instance
			.valueOf(ConstExpression_ord);
	public static final EntityDescriptor<ClosureValue> ClosureValue = (EntityDescriptor<ClosureValue>) instance
			.valueOf(ClosureValue_ord);
	public static final EntityDescriptor<BuiltinValue> BuiltinValue = (EntityDescriptor<BuiltinValue>) instance
			.valueOf(BuiltinValue_ord);
	public static final EntityDescriptor<BooleanValue> BooleanValue = (EntityDescriptor<BooleanValue>) instance
			.valueOf(BooleanValue_ord);
	public static final EntityDescriptor<IntValue> IntValue = (EntityDescriptor<IntValue>) instance
			.valueOf(IntValue_ord);
	public static final EntityDescriptor<StringValue> StringValue = (EntityDescriptor<StringValue>) instance
			.valueOf(StringValue_ord);
	public static final EntityDescriptor<PairValue> PairValue = (EntityDescriptor<PairValue>) instance
			.valueOf(PairValue_ord);
	public static final EntityDescriptor<Names> Names = (EntityDescriptor<Names>) instance
			.valueOf(Names_ord);
	public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance
			.valueOf(Name_ord);
	public static final EntityDescriptor<SchemeEnvironment> SchemeEnvironment = (EntityDescriptor<SchemeEnvironment>) instance
			.valueOf(SchemeEnvironment_ord);

	private SchemeEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putCompositeEntity(
		Definitions_ord, "Definitions", Definitions.class, false, Definition_ord, true, false);
		putSimpleEntity(Definition_ord, "Definition", Definition.class, false)
				.withFeature(SchemeFeatureDescriptorEnum.name, Name_ord)
				.withFeature(SchemeFeatureDescriptorEnum.expression,
						SchemeExpression_ord);
		putCompositeEntity(
		Branches_ord, "Branches", Branches.class, false, Branch_ord, true, false);
		putSimpleEntity(Branch_ord, "Branch", Branch.class, false).withFeature(
				SchemeFeatureDescriptorEnum.test, SchemeExpression_ord)
				.withFeature(SchemeFeatureDescriptorEnum.body,
						SchemeExpression_ord);
		putCompositeEntity(
		SchemeExpressions_ord, "SchemeExpressions", SchemeExpressions.class, false, SchemeExpression_ord, true, false);
		putSimpleEntity(SchemeExpression_ord, "SchemeExpression",
				SchemeExpression.class, true, OrExpression_ord,
				AndExpression_ord, IntValue_ord, IdExpression_ord,
				BuiltinValue_ord, LambdaExpression_ord, StringValue_ord,
				ApplyExpression_ord, PairValue_ord, BooleanValue_ord,
				LocalExpression_ord, ClosureValue_ord, ConstExpression_ord,
				CondExpression_ord);
		putSimpleEntity(ApplyExpression_ord, "ApplyExpression",
				ApplyExpression.class, false).withFeature(
				SchemeFeatureDescriptorEnum.expressions, SchemeExpressions_ord);
		putSimpleEntity(LambdaExpression_ord, "LambdaExpression",
				LambdaExpression.class, false).withFeature(
				SchemeFeatureDescriptorEnum.args, Names_ord).withFeature(
				SchemeFeatureDescriptorEnum.body, SchemeExpression_ord);
		putSimpleEntity(AndExpression_ord, "AndExpression",
				AndExpression.class, false).withFeature(
				SchemeFeatureDescriptorEnum.expressions, SchemeExpressions_ord);
		putSimpleEntity(OrExpression_ord, "OrExpression", OrExpression.class,
				false).withFeature(SchemeFeatureDescriptorEnum.expressions,
				SchemeExpressions_ord);
		putSimpleEntity(CondExpression_ord, "CondExpression",
				CondExpression.class, false).withFeature(
				SchemeFeatureDescriptorEnum.branches, Branches_ord)
				.withFeature(SchemeFeatureDescriptorEnum.elseBody,
						SchemeExpression_ord, true, false, false, false, false);
		putSimpleEntity(LocalExpression_ord, "LocalExpression",
				LocalExpression.class, false).withFeature(
				SchemeFeatureDescriptorEnum.definitions, Definitions_ord)
				.withFeature(SchemeFeatureDescriptorEnum.body,
						SchemeExpression_ord);
		putDataEntity(IdExpression_ord, "IdExpression", IdExpression.class,
				false, String.class);
		putSimpleEntity(ConstExpression_ord, "ConstExpression",
				ConstExpression.class, true, PairValue_ord, StringValue_ord,
				BooleanValue_ord, ClosureValue_ord, BuiltinValue_ord,
				IntValue_ord);
		putSimpleEntity(ClosureValue_ord, "ClosureValue", ClosureValue.class,
				false)
				.withFeature(SchemeFeatureDescriptorEnum.args, Names_ord)
				.withFeature(SchemeFeatureDescriptorEnum.body,
						SchemeExpression_ord)
				.withFeature(SchemeFeatureDescriptorEnum.env,
						SchemeEnvironment_ord);
		putDataEntity(BuiltinValue_ord, "BuiltinValue", BuiltinValue.class,
				false, BuiltinValueEnum.Value.class);
		putDataEntity(BooleanValue_ord, "BooleanValue", BooleanValue.class,
				false, boolean.class);
		putDataEntity(IntValue_ord, "IntValue", IntValue.class, false,
				int.class);
		putDataEntity(StringValue_ord, "StringValue", StringValue.class, false,
				String.class);
		putSimpleEntity(PairValue_ord, "PairValue", PairValue.class, false)
				.withFeature(SchemeFeatureDescriptorEnum.car,
						ConstExpression_ord).withFeature(
						SchemeFeatureDescriptorEnum.cdr, ConstExpression_ord);
		putCompositeEntity(
		Names_ord, "Names", Names.class, false, Name_ord, true, false);
		putDataEntity(Name_ord, "Name", Name.class, false, String.class);
		putDataEntity(SchemeEnvironment_ord, "SchemeEnvironment",
				SchemeEnvironment.class, false,
				org.whole.lang.bindings.IBindingManager.class);
	}
}
