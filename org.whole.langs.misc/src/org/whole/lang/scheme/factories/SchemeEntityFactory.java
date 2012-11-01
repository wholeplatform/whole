package org.whole.lang.scheme.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.scheme.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.scheme.reflect.SchemeEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;

/** 
 * @generator Whole
 */
public class SchemeEntityFactory extends GenericEntityFactory {
	public static final SchemeEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

	public static SchemeEntityFactory instance(IEntityRegistryProvider provider) {
		return new SchemeEntityFactory(provider);
	}

	protected SchemeEntityFactory(IEntityRegistryProvider provider) {
		super(provider);
	}

	public Definitions createDefinitions() {
		return create(SchemeEntityDescriptorEnum.Definitions);
	}

	public Definitions createDefinitions(Definition... entities) {
		return create(SchemeEntityDescriptorEnum.Definitions,
				(IEntity[]) entities);
	}

	public Definitions createDefinitions(int initialSize) {
		return clone(SchemeEntityDescriptorEnum.Definitions, initialSize);
	}

	public Definition createDefinition() {
		return create(SchemeEntityDescriptorEnum.Definition);
	}

	public Definition createDefinition(Name name, SchemeExpression expression) {
		return create(SchemeEntityDescriptorEnum.Definition, name, expression);
	}

	public IEntityBuilder<Definition> buildDefinition() {
		return new EntityBuilder<Definition>(
				create(SchemeEntityDescriptorEnum.Definition));
	}

	public Branches createBranches() {
		return create(SchemeEntityDescriptorEnum.Branches);
	}

	public Branches createBranches(Branch... entities) {
		return create(SchemeEntityDescriptorEnum.Branches, (IEntity[]) entities);
	}

	public Branches createBranches(int initialSize) {
		return clone(SchemeEntityDescriptorEnum.Branches, initialSize);
	}

	public Branch createBranch() {
		return create(SchemeEntityDescriptorEnum.Branch);
	}

	public Branch createBranch(SchemeExpression test, SchemeExpression body) {
		return create(SchemeEntityDescriptorEnum.Branch, test, body);
	}

	public IEntityBuilder<Branch> buildBranch() {
		return new EntityBuilder<Branch>(
				create(SchemeEntityDescriptorEnum.Branch));
	}

	public SchemeExpressions createSchemeExpressions() {
		return create(SchemeEntityDescriptorEnum.SchemeExpressions);
	}

	public SchemeExpressions createSchemeExpressions(
			SchemeExpression... entities) {
		return create(SchemeEntityDescriptorEnum.SchemeExpressions,
				(IEntity[]) entities);
	}

	public SchemeExpressions createSchemeExpressions(int initialSize) {
		return clone(SchemeEntityDescriptorEnum.SchemeExpressions, initialSize);
	}

	public ApplyExpression createApplyExpression() {
		return create(SchemeEntityDescriptorEnum.ApplyExpression);
	}

	public ApplyExpression createApplyExpression(SchemeExpressions expressions) {
		return create(SchemeEntityDescriptorEnum.ApplyExpression, expressions);
	}

	public LambdaExpression createLambdaExpression() {
		return create(SchemeEntityDescriptorEnum.LambdaExpression);
	}

	public LambdaExpression createLambdaExpression(Names args,
			SchemeExpression body) {
		return create(SchemeEntityDescriptorEnum.LambdaExpression, args, body);
	}

	public IEntityBuilder<LambdaExpression> buildLambdaExpression() {
		return new EntityBuilder<LambdaExpression>(
				create(SchemeEntityDescriptorEnum.LambdaExpression));
	}

	public AndExpression createAndExpression() {
		return create(SchemeEntityDescriptorEnum.AndExpression);
	}

	public AndExpression createAndExpression(SchemeExpressions expressions) {
		return create(SchemeEntityDescriptorEnum.AndExpression, expressions);
	}

	public OrExpression createOrExpression() {
		return create(SchemeEntityDescriptorEnum.OrExpression);
	}

	public OrExpression createOrExpression(SchemeExpressions expressions) {
		return create(SchemeEntityDescriptorEnum.OrExpression, expressions);
	}

	public CondExpression createCondExpression() {
		return create(SchemeEntityDescriptorEnum.CondExpression);
	}

	public CondExpression createCondExpression(Branches branches,
			SchemeExpression elseBody) {
		return create(SchemeEntityDescriptorEnum.CondExpression, branches,
				elseBody);
	}

	public IEntityBuilder<CondExpression> buildCondExpression() {
		return new EntityBuilder<CondExpression>(
				create(SchemeEntityDescriptorEnum.CondExpression));
	}

	public LocalExpression createLocalExpression() {
		return create(SchemeEntityDescriptorEnum.LocalExpression);
	}

	public LocalExpression createLocalExpression(Definitions definitions,
			SchemeExpression body) {
		return create(SchemeEntityDescriptorEnum.LocalExpression, definitions,
				body);
	}

	public IEntityBuilder<LocalExpression> buildLocalExpression() {
		return new EntityBuilder<LocalExpression>(
				create(SchemeEntityDescriptorEnum.LocalExpression));
	}

	public IdExpression createIdExpression() {
		return create(SchemeEntityDescriptorEnum.IdExpression);
	}

	public IdExpression createIdExpression(String value) {
		return create(SchemeEntityDescriptorEnum.IdExpression, value);
	}

	public ClosureValue createClosureValue() {
		return create(SchemeEntityDescriptorEnum.ClosureValue);
	}

	public ClosureValue createClosureValue(Names args, SchemeExpression body,
			SchemeEnvironment env) {
		return create(SchemeEntityDescriptorEnum.ClosureValue, args, body, env);
	}

	public IEntityBuilder<ClosureValue> buildClosureValue() {
		return new EntityBuilder<ClosureValue>(
				create(SchemeEntityDescriptorEnum.ClosureValue));
	}

	public BuiltinValue createBuiltinValue() {
		return create(SchemeEntityDescriptorEnum.BuiltinValue);
	}

	public BuiltinValue createBuiltinValue(BuiltinValueEnum.Value value) {
		return create(SchemeEntityDescriptorEnum.BuiltinValue, value);
	}

	public BooleanValue createBooleanValue() {
		return create(SchemeEntityDescriptorEnum.BooleanValue);
	}

	public BooleanValue createBooleanValue(boolean value) {
		return create(SchemeEntityDescriptorEnum.BooleanValue, value);
	}

	public IntValue createIntValue() {
		return create(SchemeEntityDescriptorEnum.IntValue);
	}

	public IntValue createIntValue(int value) {
		return create(SchemeEntityDescriptorEnum.IntValue, value);
	}

	public StringValue createStringValue() {
		return create(SchemeEntityDescriptorEnum.StringValue);
	}

	public StringValue createStringValue(String value) {
		return create(SchemeEntityDescriptorEnum.StringValue, value);
	}

	public PairValue createPairValue() {
		return create(SchemeEntityDescriptorEnum.PairValue);
	}

	public PairValue createPairValue(ConstExpression car, ConstExpression cdr) {
		return create(SchemeEntityDescriptorEnum.PairValue, car, cdr);
	}

	public IEntityBuilder<PairValue> buildPairValue() {
		return new EntityBuilder<PairValue>(
				create(SchemeEntityDescriptorEnum.PairValue));
	}

	public Names createNames() {
		return create(SchemeEntityDescriptorEnum.Names);
	}

	public Names createNames(Name... entities) {
		return create(SchemeEntityDescriptorEnum.Names, (IEntity[]) entities);
	}

	public Names createNames(int initialSize) {
		return clone(SchemeEntityDescriptorEnum.Names, initialSize);
	}

	public Name createName() {
		return create(SchemeEntityDescriptorEnum.Name);
	}

	public Name createName(String value) {
		return create(SchemeEntityDescriptorEnum.Name, value);
	}

	public SchemeEnvironment createSchemeEnvironment() {
		return create(SchemeEntityDescriptorEnum.SchemeEnvironment);
	}

	public SchemeEnvironment createSchemeEnvironment(
			org.whole.lang.bindings.IBindingManager value) {
		return create(SchemeEntityDescriptorEnum.SchemeEnvironment, value);
	}
}
