package org.whole.lang.unifiedlambdadelta.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.unifiedlambdadelta.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.unifiedlambdadelta.reflect.UnifiedLambdaDeltaEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;

/** 
 * @generator Whole
 */
public class UnifiedLambdaDeltaEntityFactory extends GenericEntityFactory {
	public static final UnifiedLambdaDeltaEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static UnifiedLambdaDeltaEntityFactory instance(
			IEntityRegistryProvider provider) {
		return new UnifiedLambdaDeltaEntityFactory(provider);
	}

	protected UnifiedLambdaDeltaEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Declaration createDeclaration() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Declaration);
	}

	public Declaration createDeclaration(Polarity polarity, Term front,
			Name name, Context back) {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Declaration,
				polarity, front, name, back);
	}

	public IEntityBuilder<Declaration> buildDeclaration() {
		return new EntityBuilder<Declaration>(
				create(UnifiedLambdaDeltaEntityDescriptorEnum.Declaration));
	}

	public Definition createDefinition() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Definition);
	}

	public Definition createDefinition(Polarity polarity, Term front,
			Name name, Context back) {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Definition,
				polarity, front, name, back);
	}

	public IEntityBuilder<Definition> buildDefinition() {
		return new EntityBuilder<Definition>(
				create(UnifiedLambdaDeltaEntityDescriptorEnum.Definition));
	}

	public Top createTop() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Top);
	}

	public Application createApplication() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Application);
	}

	public Application createApplication(Polarity polarity, Term front,
			Term back) {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Application,
				polarity, front, back);
	}

	public IEntityBuilder<Application> buildApplication() {
		return new EntityBuilder<Application>(
				create(UnifiedLambdaDeltaEntityDescriptorEnum.Application));
	}

	public Cast createCast() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Cast);
	}

	public Cast createCast(Polarity polarity, Term front, Term back) {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Cast, polarity,
				front, back);
	}

	public IEntityBuilder<Cast> buildCast() {
		return new EntityBuilder<Cast>(
				create(UnifiedLambdaDeltaEntityDescriptorEnum.Cast));
	}

	public Abstraction createAbstraction() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Abstraction);
	}

	public Abstraction createAbstraction(Polarity polarity, Term front,
			Term back, Name name) {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Abstraction,
				polarity, front, back, name);
	}

	public IEntityBuilder<Abstraction> buildAbstraction() {
		return new EntityBuilder<Abstraction>(
				create(UnifiedLambdaDeltaEntityDescriptorEnum.Abstraction));
	}

	public Abbreviation createAbbreviation() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Abbreviation);
	}

	public Abbreviation createAbbreviation(Polarity polarity, Term front,
			Term back, Name name) {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Abbreviation,
				polarity, front, back, name);
	}

	public IEntityBuilder<Abbreviation> buildAbbreviation() {
		return new EntityBuilder<Abbreviation>(
				create(UnifiedLambdaDeltaEntityDescriptorEnum.Abbreviation));
	}

	public Local createLocal() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Local);
	}

	public Local createLocal(Index index) {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Local, index);
	}

	public Sort createSort() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Sort);
	}

	public Sort createSort(Level level) {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Sort, level);
	}

	public Polarity createPolarity() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Polarity);
	}

	public Polarity createPolarity(boolean value) {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Polarity, value);
	}

	public Index createIndex() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Index);
	}

	public Index createIndex(int value) {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Index, value);
	}

	public Level createLevel() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Level);
	}

	public Level createLevel(int value) {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Level, value);
	}

	public Name createName() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Name);
	}

	public Name createName(Access access, Prefix prefix, Postfix postfix) {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Name, access,
				prefix, postfix);
	}

	public IEntityBuilder<Name> buildName() {
		return new EntityBuilder<Name>(
				create(UnifiedLambdaDeltaEntityDescriptorEnum.Name));
	}

	public Access createAccess() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Access);
	}

	public Access createAccess(boolean value) {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Access, value);
	}

	public Prefix createPrefix() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Prefix);
	}

	public Prefix createPrefix(String value) {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Prefix, value);
	}

	public Postfix createPostfix() {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Postfix);
	}

	public Postfix createPostfix(int value) {
		return create(UnifiedLambdaDeltaEntityDescriptorEnum.Postfix, value);
	}
}
