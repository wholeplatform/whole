/**
 *  Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 *  This file is part of the Whole Platform.
 *  
 *  The Whole Platform is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *  
 *  The Whole Platform is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *  GNU Lesser General Public License for more details.
 *  
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.semantics.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.semantics.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.semantics.reflect.SemanticsEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SemanticsEntityFactory extends GenericEntityFactory {
    public static final SemanticsEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static SemanticsEntityFactory instance(IEntityRegistryProvider provider) {
        return new SemanticsEntityFactory(provider);
    }

    protected SemanticsEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public SemanticTheory createSemanticTheory() {
        return create(SemanticsEntityDescriptorEnum.SemanticTheory);
    }

    public SemanticTheory createSemanticTheory(URI uri, Namespace namespace, Name name, Version version, SemanticFunctions functions) {
        return create(SemanticsEntityDescriptorEnum.SemanticTheory, uri, namespace, name, version, functions);
    }

    public IEntityBuilder<SemanticTheory> buildSemanticTheory() {
        return new EntityBuilder<SemanticTheory>(create(SemanticsEntityDescriptorEnum.SemanticTheory));
    }

    public SemanticFunctions createSemanticFunctions() {
        return create(SemanticsEntityDescriptorEnum.SemanticFunctions);
    }

    public SemanticFunctions createSemanticFunctions(SemanticFunction... entities) {
        return create(SemanticsEntityDescriptorEnum.SemanticFunctions, (IEntity[]) entities);
    }

    public SemanticFunctions createSemanticFunctions(int initialSize) {
        return clone(SemanticsEntityDescriptorEnum.SemanticFunctions, initialSize);
    }

    public SemanticFunction createSemanticFunction() {
        return create(SemanticsEntityDescriptorEnum.SemanticFunction);
    }

    public SemanticFunction createSemanticFunction(Name name, FunctionType signature, FunctionBody rules) {
        return create(SemanticsEntityDescriptorEnum.SemanticFunction, name, signature, rules);
    }

    public IEntityBuilder<SemanticFunction> buildSemanticFunction() {
        return new EntityBuilder<SemanticFunction>(create(SemanticsEntityDescriptorEnum.SemanticFunction));
    }

    public Rules createRules() {
        return create(SemanticsEntityDescriptorEnum.Rules);
    }

    public Rules createRules(Rule... entities) {
        return create(SemanticsEntityDescriptorEnum.Rules, (IEntity[]) entities);
    }

    public Rules createRules(int initialSize) {
        return clone(SemanticsEntityDescriptorEnum.Rules, initialSize);
    }

    public InferenceRules createInferenceRules() {
        return create(SemanticsEntityDescriptorEnum.InferenceRules);
    }

    public InferenceRules createInferenceRules(InferenceRule... entities) {
        return create(SemanticsEntityDescriptorEnum.InferenceRules, (IEntity[]) entities);
    }

    public InferenceRules createInferenceRules(int initialSize) {
        return clone(SemanticsEntityDescriptorEnum.InferenceRules, initialSize);
    }

    public AnyType createAnyType() {
        return create(SemanticsEntityDescriptorEnum.AnyType);
    }

    public LanguageType createLanguageType() {
        return create(SemanticsEntityDescriptorEnum.LanguageType);
    }

    public LanguageType createLanguageType(String value) {
        return create(SemanticsEntityDescriptorEnum.LanguageType, value);
    }

    public EnvType createEnvType() {
        return create(SemanticsEntityDescriptorEnum.EnvType);
    }

    public EntityType createEntityType() {
        return create(SemanticsEntityDescriptorEnum.EntityType);
    }

    public EntityType createEntityType(String value) {
        return create(SemanticsEntityDescriptorEnum.EntityType, value);
    }

    public EnvironmentType createEnvironmentType() {
        return create(SemanticsEntityDescriptorEnum.EnvironmentType);
    }

    public EnvironmentType createEnvironmentType(String value) {
        return create(SemanticsEntityDescriptorEnum.EnvironmentType, value);
    }

    public LegacyType createLegacyType() {
        return create(SemanticsEntityDescriptorEnum.LegacyType);
    }

    public LegacyType createLegacyType(LegacyTypeEnum.Value value) {
        return create(SemanticsEntityDescriptorEnum.LegacyType, value);
    }

    public UnionType createUnionType() {
        return create(SemanticsEntityDescriptorEnum.UnionType);
    }

    public UnionType createUnionType(Category... entities) {
        return create(SemanticsEntityDescriptorEnum.UnionType, (IEntity[]) entities);
    }

    public UnionType createUnionType(int initialSize) {
        return clone(SemanticsEntityDescriptorEnum.UnionType, initialSize);
    }

    public FunctionType createFunctionType() {
        return create(SemanticsEntityDescriptorEnum.FunctionType);
    }

    public FunctionType createFunctionType(SignatureOrSequence source, SignatureOrSequence target) {
        return create(SemanticsEntityDescriptorEnum.FunctionType, source, target);
    }

    public IEntityBuilder<FunctionType> buildFunctionType() {
        return new EntityBuilder<FunctionType>(create(SemanticsEntityDescriptorEnum.FunctionType));
    }

    public SequenceType createSequenceType() {
        return create(SemanticsEntityDescriptorEnum.SequenceType);
    }

    public SequenceType createSequenceType(Signature signature) {
        return create(SemanticsEntityDescriptorEnum.SequenceType, signature);
    }

    public SubtypeType createSubtypeType() {
        return create(SemanticsEntityDescriptorEnum.SubtypeType);
    }

    public SubtypeType createSubtypeType(EntityType category) {
        return create(SemanticsEntityDescriptorEnum.SubtypeType, category);
    }

    public SupertypeType createSupertypeType() {
        return create(SemanticsEntityDescriptorEnum.SupertypeType);
    }

    public SupertypeType createSupertypeType(Category category) {
        return create(SemanticsEntityDescriptorEnum.SupertypeType, category);
    }

    public ProductType createProductType() {
        return create(SemanticsEntityDescriptorEnum.ProductType);
    }

    public ProductType createProductType(Signature... entities) {
        return create(SemanticsEntityDescriptorEnum.ProductType, (IEntity[]) entities);
    }

    public ProductType createProductType(int initialSize) {
        return clone(SemanticsEntityDescriptorEnum.ProductType, initialSize);
    }

    public ExecutionRule createExecutionRule() {
        return create(SemanticsEntityDescriptorEnum.ExecutionRule);
    }

    public ExecutionRule createExecutionRule(Name name, Predicate condition, Expression meaning) {
        return create(SemanticsEntityDescriptorEnum.ExecutionRule, name, condition, meaning);
    }

    public IEntityBuilder<ExecutionRule> buildExecutionRule() {
        return new EntityBuilder<ExecutionRule>(create(SemanticsEntityDescriptorEnum.ExecutionRule));
    }

    public InferenceRule createInferenceRule() {
        return create(SemanticsEntityDescriptorEnum.InferenceRule);
    }

    public InferenceRule createInferenceRule(RuleName name, Premises premises, Transition conclusion, Predicate condition) {
        return create(SemanticsEntityDescriptorEnum.InferenceRule, name, premises, conclusion, condition);
    }

    public IEntityBuilder<InferenceRule> buildInferenceRule() {
        return new EntityBuilder<InferenceRule>(create(SemanticsEntityDescriptorEnum.InferenceRule));
    }

    public Premises createPremises() {
        return create(SemanticsEntityDescriptorEnum.Premises);
    }

    public Premises createPremises(Premise... entities) {
        return create(SemanticsEntityDescriptorEnum.Premises, (IEntity[]) entities);
    }

    public Premises createPremises(int initialSize) {
        return clone(SemanticsEntityDescriptorEnum.Premises, initialSize);
    }

    public Transition createTransition() {
        return create(SemanticsEntityDescriptorEnum.Transition);
    }

    public Transition createTransition(Configuration sourceConfiguration, ConfigurationOrTransition targetConfiguration) {
        return create(SemanticsEntityDescriptorEnum.Transition, sourceConfiguration, targetConfiguration);
    }

    public IEntityBuilder<Transition> buildTransition() {
        return new EntityBuilder<Transition>(create(SemanticsEntityDescriptorEnum.Transition));
    }

    public Configuration createConfiguration() {
        return create(SemanticsEntityDescriptorEnum.Configuration);
    }

    public Configuration createConfiguration(ConfigurationItem... entities) {
        return create(SemanticsEntityDescriptorEnum.Configuration, (IEntity[]) entities);
    }

    public Configuration createConfiguration(int initialSize) {
        return clone(SemanticsEntityDescriptorEnum.Configuration, initialSize);
    }

    public TypedVariable createTypedVariable() {
        return create(SemanticsEntityDescriptorEnum.TypedVariable);
    }

    public TypedVariable createTypedVariable(Variable variable, Num index, Num time, Signature signature) {
        return create(SemanticsEntityDescriptorEnum.TypedVariable, variable, index, time, signature);
    }

    public IEntityBuilder<TypedVariable> buildTypedVariable() {
        return new EntityBuilder<TypedVariable>(create(SemanticsEntityDescriptorEnum.TypedVariable));
    }

    public StructuredVariable createStructuredVariable() {
        return create(SemanticsEntityDescriptorEnum.StructuredVariable);
    }

    public StructuredVariable createStructuredVariable(Variable variable, Num index, Num time) {
        return create(SemanticsEntityDescriptorEnum.StructuredVariable, variable, index, time);
    }

    public IEntityBuilder<StructuredVariable> buildStructuredVariable() {
        return new EntityBuilder<StructuredVariable>(create(SemanticsEntityDescriptorEnum.StructuredVariable));
    }

    public Variable createVariable() {
        return create(SemanticsEntityDescriptorEnum.Variable);
    }

    public Variable createVariable(String value) {
        return create(SemanticsEntityDescriptorEnum.Variable, value);
    }

    public VariableValue createVariableValue() {
        return create(SemanticsEntityDescriptorEnum.VariableValue);
    }

    public VariableValue createVariableValue(Identifier identifier) {
        return create(SemanticsEntityDescriptorEnum.VariableValue, identifier);
    }

    public RenameGroup createRenameGroup() {
        return create(SemanticsEntityDescriptorEnum.RenameGroup);
    }

    public RenameGroup createRenameGroup(Rename... entities) {
        return create(SemanticsEntityDescriptorEnum.RenameGroup, (IEntity[]) entities);
    }

    public RenameGroup createRenameGroup(int initialSize) {
        return clone(SemanticsEntityDescriptorEnum.RenameGroup, initialSize);
    }

    public Rename createRename() {
        return create(SemanticsEntityDescriptorEnum.Rename);
    }

    public Rename createRename(LocalIdentifier newIdentifier, LocalIdentifier oldIdentifier) {
        return create(SemanticsEntityDescriptorEnum.Rename, newIdentifier, oldIdentifier);
    }

    public IEntityBuilder<Rename> buildRename() {
        return new EntityBuilder<Rename>(create(SemanticsEntityDescriptorEnum.Rename));
    }

    public Environments createEnvironments() {
        return create(SemanticsEntityDescriptorEnum.Environments);
    }

    public Environments createEnvironments(Environment... entities) {
        return create(SemanticsEntityDescriptorEnum.Environments, (IEntity[]) entities);
    }

    public Environments createEnvironments(int initialSize) {
        return clone(SemanticsEntityDescriptorEnum.Environments, initialSize);
    }

    public BindingsScope createBindingsScope() {
        return create(SemanticsEntityDescriptorEnum.BindingsScope);
    }

    public BindingsScope createBindingsScope(LocalIdentifier identifier, LocalBindings bindings, BindingsScope nestedScope) {
        return create(SemanticsEntityDescriptorEnum.BindingsScope, identifier, bindings, nestedScope);
    }

    public IEntityBuilder<BindingsScope> buildBindingsScope() {
        return new EntityBuilder<BindingsScope>(create(SemanticsEntityDescriptorEnum.BindingsScope));
    }

    public LocalBindings createLocalBindings() {
        return create(SemanticsEntityDescriptorEnum.LocalBindings);
    }

    public LocalBindings createLocalBindings(LocalBinding... entities) {
        return create(SemanticsEntityDescriptorEnum.LocalBindings, (IEntity[]) entities);
    }

    public LocalBindings createLocalBindings(int initialSize) {
        return clone(SemanticsEntityDescriptorEnum.LocalBindings, initialSize);
    }

    public LocalBinding createLocalBinding() {
        return create(SemanticsEntityDescriptorEnum.LocalBinding);
    }

    public LocalBinding createLocalBinding(BindingOp op, LocalIdentifier identifier, Expression expression) {
        return create(SemanticsEntityDescriptorEnum.LocalBinding, op, identifier, expression);
    }

    public IEntityBuilder<LocalBinding> buildLocalBinding() {
        return new EntityBuilder<LocalBinding>(create(SemanticsEntityDescriptorEnum.LocalBinding));
    }

    public BindingOp createBindingOp() {
        return create(SemanticsEntityDescriptorEnum.BindingOp);
    }

    public BindingOp createBindingOp(BindingOpEnum.Value value) {
        return create(SemanticsEntityDescriptorEnum.BindingOp, value);
    }

    public EnvironmentVariable createEnvironmentVariable() {
        return create(SemanticsEntityDescriptorEnum.EnvironmentVariable);
    }

    public EnvironmentVariable createEnvironmentVariable(LocalIdentifier environment, LocalIdentifier variable) {
        return create(SemanticsEntityDescriptorEnum.EnvironmentVariable, environment, variable);
    }

    public IEntityBuilder<EnvironmentVariable> buildEnvironmentVariable() {
        return new EntityBuilder<EnvironmentVariable>(create(SemanticsEntityDescriptorEnum.EnvironmentVariable));
    }

    public TypeCast createTypeCast() {
        return create(SemanticsEntityDescriptorEnum.TypeCast);
    }

    public TypeCast createTypeCast(CastType type, Term expression) {
        return create(SemanticsEntityDescriptorEnum.TypeCast, type, expression);
    }

    public IEntityBuilder<TypeCast> buildTypeCast() {
        return new EntityBuilder<TypeCast>(create(SemanticsEntityDescriptorEnum.TypeCast));
    }

    public FunctionApplication createFunctionApplication() {
        return create(SemanticsEntityDescriptorEnum.FunctionApplication);
    }

    public FunctionApplication createFunctionApplication(Name name, Expression arguments, Environments environments, StageChange stage) {
        return create(SemanticsEntityDescriptorEnum.FunctionApplication, name, arguments, environments, stage);
    }

    public IEntityBuilder<FunctionApplication> buildFunctionApplication() {
        return new EntityBuilder<FunctionApplication>(create(SemanticsEntityDescriptorEnum.FunctionApplication));
    }

    public StageChange createStageChange() {
        return create(SemanticsEntityDescriptorEnum.StageChange);
    }

    public StageChange createStageChange(StageChangeEnum.Value value) {
        return create(SemanticsEntityDescriptorEnum.StageChange, value);
    }

    public OutputBindings createOutputBindings() {
        return create(SemanticsEntityDescriptorEnum.OutputBindings);
    }

    public OutputBindings createOutputBindings(OutputBinding... entities) {
        return create(SemanticsEntityDescriptorEnum.OutputBindings, (IEntity[]) entities);
    }

    public OutputBindings createOutputBindings(int initialSize) {
        return clone(SemanticsEntityDescriptorEnum.OutputBindings, initialSize);
    }

    public OutputBinding createOutputBinding() {
        return create(SemanticsEntityDescriptorEnum.OutputBinding);
    }

    public OutputBinding createOutputBinding(BindingSubject identifier, Expression expression) {
        return create(SemanticsEntityDescriptorEnum.OutputBinding, identifier, expression);
    }

    public IEntityBuilder<OutputBinding> buildOutputBinding() {
        return new EntityBuilder<OutputBinding>(create(SemanticsEntityDescriptorEnum.OutputBinding));
    }

    public InputBindings createInputBindings() {
        return create(SemanticsEntityDescriptorEnum.InputBindings);
    }

    public InputBindings createInputBindings(InputBinding... entities) {
        return create(SemanticsEntityDescriptorEnum.InputBindings, (IEntity[]) entities);
    }

    public InputBindings createInputBindings(int initialSize) {
        return clone(SemanticsEntityDescriptorEnum.InputBindings, initialSize);
    }

    public InputBinding createInputBinding() {
        return create(SemanticsEntityDescriptorEnum.InputBinding);
    }

    public InputBinding createInputBinding(BindingSubject identifier, Expression expression) {
        return create(SemanticsEntityDescriptorEnum.InputBinding, identifier, expression);
    }

    public IEntityBuilder<InputBinding> buildInputBinding() {
        return new EntityBuilder<InputBinding>(create(SemanticsEntityDescriptorEnum.InputBinding));
    }

    public InlineTemplate createInlineTemplate() {
        return create(SemanticsEntityDescriptorEnum.InlineTemplate);
    }

    public InlineTemplate createInlineTemplate(Term expression) {
        return create(SemanticsEntityDescriptorEnum.InlineTemplate, expression);
    }

    public ChooseTemplate createChooseTemplate() {
        return create(SemanticsEntityDescriptorEnum.ChooseTemplate);
    }

    public ChooseTemplate createChooseTemplate(Case... entities) {
        return create(SemanticsEntityDescriptorEnum.ChooseTemplate, (IEntity[]) entities);
    }

    public ChooseTemplate createChooseTemplate(int initialSize) {
        return clone(SemanticsEntityDescriptorEnum.ChooseTemplate, initialSize);
    }

    public WhereTemplate createWhereTemplate() {
        return create(SemanticsEntityDescriptorEnum.WhereTemplate);
    }

    public WhereTemplate createWhereTemplate(Term expression, InputBindings where) {
        return create(SemanticsEntityDescriptorEnum.WhereTemplate, expression, where);
    }

    public IEntityBuilder<WhereTemplate> buildWhereTemplate() {
        return new EntityBuilder<WhereTemplate>(create(SemanticsEntityDescriptorEnum.WhereTemplate));
    }

    public ForTemplate createForTemplate() {
        return create(SemanticsEntityDescriptorEnum.ForTemplate);
    }

    public ForTemplate createForTemplate(Term expression, Expression condition) {
        return create(SemanticsEntityDescriptorEnum.ForTemplate, expression, condition);
    }

    public IEntityBuilder<ForTemplate> buildForTemplate() {
        return new EntityBuilder<ForTemplate>(create(SemanticsEntityDescriptorEnum.ForTemplate));
    }

    public IfTemplate createIfTemplate() {
        return create(SemanticsEntityDescriptorEnum.IfTemplate);
    }

    public IfTemplate createIfTemplate(Term expression, Predicate condition) {
        return create(SemanticsEntityDescriptorEnum.IfTemplate, expression, condition);
    }

    public IEntityBuilder<IfTemplate> buildIfTemplate() {
        return new EntityBuilder<IfTemplate>(create(SemanticsEntityDescriptorEnum.IfTemplate));
    }

    public IfDefTemplate createIfDefTemplate() {
        return create(SemanticsEntityDescriptorEnum.IfDefTemplate);
    }

    public IfDefTemplate createIfDefTemplate(Term expression) {
        return create(SemanticsEntityDescriptorEnum.IfDefTemplate, expression);
    }

    public ElseTemplate createElseTemplate() {
        return create(SemanticsEntityDescriptorEnum.ElseTemplate);
    }

    public ElseTemplate createElseTemplate(Term expression) {
        return create(SemanticsEntityDescriptorEnum.ElseTemplate, expression);
    }

    public RuleName createRuleName() {
        return create(SemanticsEntityDescriptorEnum.RuleName);
    }

    public RuleName createRuleName(Name name, Name sub, Name sup) {
        return create(SemanticsEntityDescriptorEnum.RuleName, name, sub, sup);
    }

    public IEntityBuilder<RuleName> buildRuleName() {
        return new EntityBuilder<RuleName>(create(SemanticsEntityDescriptorEnum.RuleName));
    }

    public Num createNum() {
        return create(SemanticsEntityDescriptorEnum.Num);
    }

    public Num createNum(int value) {
        return create(SemanticsEntityDescriptorEnum.Num, value);
    }

    public URI createURI() {
        return create(SemanticsEntityDescriptorEnum.URI);
    }

    public URI createURI(String value) {
        return create(SemanticsEntityDescriptorEnum.URI, value);
    }

    public Namespace createNamespace() {
        return create(SemanticsEntityDescriptorEnum.Namespace);
    }

    public Namespace createNamespace(String value) {
        return create(SemanticsEntityDescriptorEnum.Namespace, value);
    }

    public Name createName() {
        return create(SemanticsEntityDescriptorEnum.Name);
    }

    public Name createName(String value) {
        return create(SemanticsEntityDescriptorEnum.Name, value);
    }

    public Version createVersion() {
        return create(SemanticsEntityDescriptorEnum.Version);
    }

    public Version createVersion(String value) {
        return create(SemanticsEntityDescriptorEnum.Version, value);
    }
}
