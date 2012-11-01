package org.whole.lang.unifiedlambdadelta.reflect;

import org.whole.lang.reflect.EntityDescriptorEnum;
import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.unifiedlambdadelta.model.*;

/** 
 * @generator Whole
 */
@SuppressWarnings("unchecked")
public class UnifiedLambdaDeltaEntityDescriptorEnum extends
		EntityDescriptorEnum {
	public static final int Context_ord = 0;
	public static final int Term_ord = 1;
	public static final int Binder_ord = 2;
	public static final int BinaryItem_ord = 3;
	public static final int BinaryContextBinder_ord = 4;
	public static final int Declaration_ord = 5;
	public static final int Definition_ord = 6;
	public static final int Top_ord = 7;
	public static final int BinaryTerm_ord = 8;
	public static final int Application_ord = 9;
	public static final int Cast_ord = 10;
	public static final int BinaryTermBinder_ord = 11;
	public static final int Abstraction_ord = 12;
	public static final int Abbreviation_ord = 13;
	public static final int Local_ord = 14;
	public static final int Sort_ord = 15;
	public static final int Polarity_ord = 16;
	public static final int Index_ord = 17;
	public static final int Level_ord = 18;
	public static final int Name_ord = 19;
	public static final int Access_ord = 20;
	public static final int Prefix_ord = 21;
	public static final int Postfix_ord = 22;
	public static final UnifiedLambdaDeltaEntityDescriptorEnum instance = new UnifiedLambdaDeltaEntityDescriptorEnum();
	public static final EntityDescriptor<Context> Context = (EntityDescriptor<Context>) instance
			.valueOf(Context_ord);
	public static final EntityDescriptor<Term> Term = (EntityDescriptor<Term>) instance
			.valueOf(Term_ord);
	public static final EntityDescriptor<Binder> Binder = (EntityDescriptor<Binder>) instance
			.valueOf(Binder_ord);
	public static final EntityDescriptor<BinaryItem> BinaryItem = (EntityDescriptor<BinaryItem>) instance
			.valueOf(BinaryItem_ord);
	public static final EntityDescriptor<BinaryContextBinder> BinaryContextBinder = (EntityDescriptor<BinaryContextBinder>) instance
			.valueOf(BinaryContextBinder_ord);
	public static final EntityDescriptor<Declaration> Declaration = (EntityDescriptor<Declaration>) instance
			.valueOf(Declaration_ord);
	public static final EntityDescriptor<Definition> Definition = (EntityDescriptor<Definition>) instance
			.valueOf(Definition_ord);
	public static final EntityDescriptor<Top> Top = (EntityDescriptor<Top>) instance
			.valueOf(Top_ord);
	public static final EntityDescriptor<BinaryTerm> BinaryTerm = (EntityDescriptor<BinaryTerm>) instance
			.valueOf(BinaryTerm_ord);
	public static final EntityDescriptor<Application> Application = (EntityDescriptor<Application>) instance
			.valueOf(Application_ord);
	public static final EntityDescriptor<Cast> Cast = (EntityDescriptor<Cast>) instance
			.valueOf(Cast_ord);
	public static final EntityDescriptor<BinaryTermBinder> BinaryTermBinder = (EntityDescriptor<BinaryTermBinder>) instance
			.valueOf(BinaryTermBinder_ord);
	public static final EntityDescriptor<Abstraction> Abstraction = (EntityDescriptor<Abstraction>) instance
			.valueOf(Abstraction_ord);
	public static final EntityDescriptor<Abbreviation> Abbreviation = (EntityDescriptor<Abbreviation>) instance
			.valueOf(Abbreviation_ord);
	public static final EntityDescriptor<Local> Local = (EntityDescriptor<Local>) instance
			.valueOf(Local_ord);
	public static final EntityDescriptor<Sort> Sort = (EntityDescriptor<Sort>) instance
			.valueOf(Sort_ord);
	public static final EntityDescriptor<Polarity> Polarity = (EntityDescriptor<Polarity>) instance
			.valueOf(Polarity_ord);
	public static final EntityDescriptor<Index> Index = (EntityDescriptor<Index>) instance
			.valueOf(Index_ord);
	public static final EntityDescriptor<Level> Level = (EntityDescriptor<Level>) instance
			.valueOf(Level_ord);
	public static final EntityDescriptor<Name> Name = (EntityDescriptor<Name>) instance
			.valueOf(Name_ord);
	public static final EntityDescriptor<Access> Access = (EntityDescriptor<Access>) instance
			.valueOf(Access_ord);
	public static final EntityDescriptor<Prefix> Prefix = (EntityDescriptor<Prefix>) instance
			.valueOf(Prefix_ord);
	public static final EntityDescriptor<Postfix> Postfix = (EntityDescriptor<Postfix>) instance
			.valueOf(Postfix_ord);

	private UnifiedLambdaDeltaEntityDescriptorEnum() {
	}

	private static final long serialVersionUID = 1;

	protected void initEntityDescriptors() {
		putSimpleEntity(Context_ord, "Context", Context.class, true, Top_ord,
				Declaration_ord, BinaryContextBinder_ord, Definition_ord);
		putSimpleEntity(Term_ord, "Term", Term.class, true, Abstraction_ord,
				Sort_ord, Local_ord, BinaryTerm_ord, Cast_ord, Application_ord,
				BinaryTermBinder_ord, Abbreviation_ord);
		putSimpleEntity(Binder_ord, "Binder", Binder.class, true,
				Abstraction_ord, Declaration_ord, BinaryTermBinder_ord,
				Abbreviation_ord, Definition_ord, BinaryContextBinder_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.name,
						Name_ord);
		putSimpleEntity(BinaryItem_ord, "BinaryItem", BinaryItem.class, true,
				Abstraction_ord, BinaryTerm_ord, BinaryContextBinder_ord,
				Application_ord, Cast_ord, Declaration_ord,
				BinaryTermBinder_ord, Abbreviation_ord, Definition_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity,
						Polarity_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.front,
						Term_ord);
		putSimpleEntity(BinaryContextBinder_ord, "BinaryContextBinder",
				BinaryContextBinder.class, true, Declaration_ord,
				Definition_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity,
						Polarity_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.front,
						Term_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.name,
						Name_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.back,
						Context_ord);
		putSimpleEntity(Declaration_ord, "Declaration", Declaration.class,
				false)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity,
						Polarity_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.front,
						Term_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.name,
						Name_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.back,
						Context_ord);
		putSimpleEntity(Definition_ord, "Definition", Definition.class, false)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity,
						Polarity_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.front,
						Term_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.name,
						Name_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.back,
						Context_ord);
		putSimpleEntity(Top_ord, "Top", Top.class, false);
		putSimpleEntity(BinaryTerm_ord, "BinaryTerm", BinaryTerm.class, true,
				Abstraction_ord, BinaryTermBinder_ord, Abbreviation_ord,
				Application_ord, Cast_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity,
						Polarity_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.front,
						Term_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.back,
						Term_ord);
		putSimpleEntity(Application_ord, "Application", Application.class,
				false)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity,
						Polarity_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.front,
						Term_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.back,
						Term_ord);
		putSimpleEntity(Cast_ord, "Cast", Cast.class, false)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity,
						Polarity_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.front,
						Term_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.back,
						Term_ord);
		putSimpleEntity(BinaryTermBinder_ord, "BinaryTermBinder",
				BinaryTermBinder.class, true, Abstraction_ord, Abbreviation_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity,
						Polarity_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.front,
						Term_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.back,
						Term_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.name,
						Name_ord);
		putSimpleEntity(Abstraction_ord, "Abstraction", Abstraction.class,
				false)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity,
						Polarity_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.front,
						Term_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.back,
						Term_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.name,
						Name_ord);
		putSimpleEntity(Abbreviation_ord, "Abbreviation", Abbreviation.class,
				false)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.polarity,
						Polarity_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.front,
						Term_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.back,
						Term_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.name,
						Name_ord);
		putSimpleEntity(Local_ord, "Local", Local.class, false).withFeature(
				UnifiedLambdaDeltaFeatureDescriptorEnum.index, Index_ord);
		putSimpleEntity(Sort_ord, "Sort", Sort.class, false).withFeature(
				UnifiedLambdaDeltaFeatureDescriptorEnum.level, Level_ord);
		putDataEntity(Polarity_ord, "Polarity", Polarity.class, false,
				boolean.class);
		putDataEntity(Index_ord, "Index", Index.class, false, int.class);
		putDataEntity(Level_ord, "Level", Level.class, false, int.class);
		putSimpleEntity(Name_ord, "Name", Name.class, false)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.access,
						Access_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.prefix,
						Prefix_ord)
				.withFeature(UnifiedLambdaDeltaFeatureDescriptorEnum.postfix,
						Postfix_ord);
		putDataEntity(Access_ord, "Access", Access.class, false, boolean.class);
		putDataEntity(Prefix_ord, "Prefix", Prefix.class, false, String.class);
		putDataEntity(Postfix_ord, "Postfix", Postfix.class, false, int.class);
	}
}
