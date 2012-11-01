package org.whole.lang.commons.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.commons.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class CommonsEntityDescriptorEnum extends EntityDescriptorEnum {
	public static final int Any_ord = 0;
	public static final int Fragment_ord = 1;
	public static final int RootFragment_ord = 2;
	public static final int SameStageFragment_ord = 3;
	public static final int StageUpFragment_ord = 4;
	public static final int StageDownFragment_ord = 5;
	public static final int Resolver_ord = 6;
	public static final int Multiplexer_ord = 7;
	public static final int Variable_ord = 8;
	public static final int InlineVariable_ord = 9;
	public static final int VarName_ord = 10;
	public static final int VarType_ord = 11;
	public static final int Quantifier_ord = 12;
	public static final CommonsEntityDescriptorEnum instance = new CommonsEntityDescriptorEnum();
	public static final EntityDescriptor<Any> Any = (EntityDescriptor<Any>) instance
			.valueOf(Any_ord);
	public static final EntityDescriptor<Fragment> Fragment = (EntityDescriptor<Fragment>) instance
			.valueOf(Fragment_ord);
	public static final EntityDescriptor<RootFragment> RootFragment = (EntityDescriptor<RootFragment>) instance
			.valueOf(RootFragment_ord);
	public static final EntityDescriptor<SameStageFragment> SameStageFragment = (EntityDescriptor<SameStageFragment>) instance
			.valueOf(SameStageFragment_ord);
	public static final EntityDescriptor<StageUpFragment> StageUpFragment = (EntityDescriptor<StageUpFragment>) instance
			.valueOf(StageUpFragment_ord);
	public static final EntityDescriptor<StageDownFragment> StageDownFragment = (EntityDescriptor<StageDownFragment>) instance
			.valueOf(StageDownFragment_ord);
	public static final EntityDescriptor<Resolver> Resolver = (EntityDescriptor<Resolver>) instance
			.valueOf(Resolver_ord);
	public static final EntityDescriptor<Multiplexer> Multiplexer = (EntityDescriptor<Multiplexer>) instance
			.valueOf(Multiplexer_ord);
	public static final EntityDescriptor<Variable> Variable = (EntityDescriptor<Variable>) instance
			.valueOf(Variable_ord);
	public static final EntityDescriptor<InlineVariable> InlineVariable = (EntityDescriptor<InlineVariable>) instance
			.valueOf(InlineVariable_ord);
	public static final EntityDescriptor<VarName> VarName = (EntityDescriptor<VarName>) instance
			.valueOf(VarName_ord);
	public static final EntityDescriptor<VarType> VarType = (EntityDescriptor<VarType>) instance
			.valueOf(VarType_ord);
	public static final EntityDescriptor<Quantifier> Quantifier = (EntityDescriptor<Quantifier>) instance
			.valueOf(Quantifier_ord);

	private CommonsEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(Any_ord, "Any", Any.class, true, StageUpFragment_ord,
				Variable_ord, SameStageFragment_ord, VarName_ord,
				StageDownFragment_ord, VarType_ord, InlineVariable_ord,
				Resolver_ord, Quantifier_ord, Fragment_ord, RootFragment_ord);
		putSimpleEntity(Fragment_ord, "Fragment", Fragment.class, true,
				StageUpFragment_ord, StageDownFragment_ord,
				SameStageFragment_ord, RootFragment_ord).withFeature(
				CommonsFeatureDescriptorEnum.rootEntity, Any_ord);
		putSimpleEntity(RootFragment_ord, "RootFragment", RootFragment.class,
				false).withFeature(CommonsFeatureDescriptorEnum.rootEntity,
				Any_ord);
		putSimpleEntity(SameStageFragment_ord, "SameStageFragment",
				SameStageFragment.class, false).withFeature(
				CommonsFeatureDescriptorEnum.rootEntity, Any_ord);
		putSimpleEntity(StageUpFragment_ord, "StageUpFragment",
				StageUpFragment.class, false).withFeature(
				CommonsFeatureDescriptorEnum.rootEntity, Any_ord);
		putSimpleEntity(StageDownFragment_ord, "StageDownFragment",
				StageDownFragment.class, false).withFeature(
				CommonsFeatureDescriptorEnum.rootEntity, Any_ord);
		putSimpleEntity(Resolver_ord, "Resolver", Resolver.class, false);
		putCompositeEntity(Multiplexer_ord, "Multiplexer", Multiplexer.class,
				true, Any_ord, false, false);
		putSimpleEntity(Variable_ord, "Variable", Variable.class, false,
				InlineVariable_ord)
				.withFeature(CommonsFeatureDescriptorEnum.varType, VarType_ord)
				.withFeature(CommonsFeatureDescriptorEnum.varName, VarName_ord)
				.withFeature(CommonsFeatureDescriptorEnum.quantifier,
						Quantifier_ord);
		putSimpleEntity(InlineVariable_ord, "InlineVariable",
				InlineVariable.class, false)
				.withFeature(CommonsFeatureDescriptorEnum.varType, VarType_ord)
				.withFeature(CommonsFeatureDescriptorEnum.varName, VarName_ord)
				.withFeature(CommonsFeatureDescriptorEnum.quantifier,
						Quantifier_ord);
		putDataEntity(VarName_ord, "VarName", VarName.class, false,
				String.class);
		putDataEntity(VarType_ord, "VarType", VarType.class, false,
				Object.class);//FIXME org.whole.lang.reflect.EntityDescriptor.class);
		putDataEntity(Quantifier_ord, "Quantifier", Quantifier.class, false,
				QuantifierEnum.Value.class);
	}

	protected void initForeignTypeRelations() {
		setAssignableFromAll(true, Any_ord);
		setAssignableToAll(true, SameStageFragment_ord, StageDownFragment_ord,
				StageUpFragment_ord, Variable_ord, InlineVariable_ord,
				Resolver_ord);
	}
}
