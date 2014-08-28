package org.whole.lang.patterns.factories;

import org.whole.lang.factories.GenericEntityFactory;
import org.whole.lang.patterns.model.*;
import org.whole.lang.factories.RegistryConfigurations;
import org.whole.lang.factories.IEntityRegistryProvider;
import org.whole.lang.patterns.reflect.PatternsEntityDescriptorEnum;
import org.whole.lang.factories.IEntityBuilder;
import org.whole.lang.factories.EntityBuilder;
import org.whole.lang.model.IEntity;

/**
 *  @generator  Whole
 */
public class PatternsEntityFactory extends GenericEntityFactory {
    public static final PatternsEntityFactory instance = instance(RegistryConfigurations.DEFAULT);

    public static PatternsEntityFactory instance(IEntityRegistryProvider provider) {
        return new PatternsEntityFactory(provider);
    }

    protected PatternsEntityFactory(IEntityRegistryProvider provider) {
        super(provider);
    }

    public PatternLanguage createPatternLanguage() {
        return create(PatternsEntityDescriptorEnum.PatternLanguage);
    }

    public PatternLanguage createPatternLanguage(URI uri, Namespace namespace, Name name, Version version, Patterns patterns, Declarations declarations) {
        return create(PatternsEntityDescriptorEnum.PatternLanguage, uri, namespace, name, version, patterns, declarations);
    }

    public IEntityBuilder<PatternLanguage> buildPatternLanguage() {
        return new EntityBuilder<PatternLanguage>(create(PatternsEntityDescriptorEnum.PatternLanguage));
    }

    public Patterns createPatterns() {
        return create(PatternsEntityDescriptorEnum.Patterns);
    }

    public Patterns createPatterns(PatternOrTypeDeclaration... entities) {
        return create(PatternsEntityDescriptorEnum.Patterns, (IEntity[]) entities);
    }

    public Patterns createPatterns(int initialSize) {
        return clone(PatternsEntityDescriptorEnum.Patterns, initialSize);
    }

    public Library createLibrary() {
        return create(PatternsEntityDescriptorEnum.Library);
    }

    public Library createLibrary(URI uri, Namespace namespace, Name name, Version version, Declarations declarations) {
        return create(PatternsEntityDescriptorEnum.Library, uri, namespace, name, version, declarations);
    }

    public IEntityBuilder<Library> buildLibrary() {
        return new EntityBuilder<Library>(create(PatternsEntityDescriptorEnum.Library));
    }

    public Pattern createPattern() {
        return create(PatternsEntityDescriptorEnum.Pattern);
    }

    public Pattern createPattern(ResultTypes resultTypes, Name name, Template template) {
        return create(PatternsEntityDescriptorEnum.Pattern, resultTypes, name, template);
    }

    public IEntityBuilder<Pattern> buildPattern() {
        return new EntityBuilder<Pattern>(create(PatternsEntityDescriptorEnum.Pattern));
    }

    public Repetition createRepetition() {
        return create(PatternsEntityDescriptorEnum.Repetition);
    }

    public Repetition createRepetition(Name name, Type type, ResultTypes supertypes) {
        return create(PatternsEntityDescriptorEnum.Repetition, name, type, supertypes);
    }

    public IEntityBuilder<Repetition> buildRepetition() {
        return new EntityBuilder<Repetition>(create(PatternsEntityDescriptorEnum.Repetition));
    }

    public Choice createChoice() {
        return create(PatternsEntityDescriptorEnum.Choice);
    }

    public Choice createChoice(Name name, Types types, ResultTypes supertypes) {
        return create(PatternsEntityDescriptorEnum.Choice, name, types, supertypes);
    }

    public IEntityBuilder<Choice> buildChoice() {
        return new EntityBuilder<Choice>(create(PatternsEntityDescriptorEnum.Choice));
    }

    public Enumeration createEnumeration() {
        return create(PatternsEntityDescriptorEnum.Enumeration);
    }

    public Enumeration createEnumeration(Name name, Type resultType, EnumValues values, ResultTypes supertypes) {
        return create(PatternsEntityDescriptorEnum.Enumeration, name, resultType, values, supertypes);
    }

    public IEntityBuilder<Enumeration> buildEnumeration() {
        return new EntityBuilder<Enumeration>(create(PatternsEntityDescriptorEnum.Enumeration));
    }

    public EnumValues createEnumValues() {
        return create(PatternsEntityDescriptorEnum.EnumValues);
    }

    public EnumValues createEnumValues(EnumValue... entities) {
        return create(PatternsEntityDescriptorEnum.EnumValues, (IEntity[]) entities);
    }

    public EnumValues createEnumValues(int initialSize) {
        return clone(PatternsEntityDescriptorEnum.EnumValues, initialSize);
    }

    public EnumValue createEnumValue() {
        return create(PatternsEntityDescriptorEnum.EnumValue);
    }

    public EnumValue createEnumValue(Name value, Name result) {
        return create(PatternsEntityDescriptorEnum.EnumValue, value, result);
    }

    public IEntityBuilder<EnumValue> buildEnumValue() {
        return new EntityBuilder<EnumValue>(create(PatternsEntityDescriptorEnum.EnumValue));
    }

    public Data createData() {
        return create(PatternsEntityDescriptorEnum.Data);
    }

    public Data createData(ResultTypes supertypes, Name name, DataType dataType) {
        return create(PatternsEntityDescriptorEnum.Data, supertypes, name, dataType);
    }

    public IEntityBuilder<Data> buildData() {
        return new EntityBuilder<Data>(create(PatternsEntityDescriptorEnum.Data));
    }

    public DataType createDataType() {
        return create(PatternsEntityDescriptorEnum.DataType);
    }

    public DataType createDataType(String value) {
        return create(PatternsEntityDescriptorEnum.DataType, value);
    }

    public PatternApplication createPatternApplication() {
        return create(PatternsEntityDescriptorEnum.PatternApplication);
    }

    public PatternApplication createPatternApplication(Name name, Arguments arguments) {
        return create(PatternsEntityDescriptorEnum.PatternApplication, name, arguments);
    }

    public IEntityBuilder<PatternApplication> buildPatternApplication() {
        return new EntityBuilder<PatternApplication>(create(PatternsEntityDescriptorEnum.PatternApplication));
    }

    public Arguments createArguments() {
        return create(PatternsEntityDescriptorEnum.Arguments);
    }

    public Arguments createArguments(Argument... entities) {
        return create(PatternsEntityDescriptorEnum.Arguments, (IEntity[]) entities);
    }

    public Arguments createArguments(int initialSize) {
        return clone(PatternsEntityDescriptorEnum.Arguments, initialSize);
    }

    public Binding createBinding() {
        return create(PatternsEntityDescriptorEnum.Binding);
    }

    public Binding createBinding(Name name, Template template) {
        return create(PatternsEntityDescriptorEnum.Binding, name, template);
    }

    public IEntityBuilder<Binding> buildBinding() {
        return new EntityBuilder<Binding>(create(PatternsEntityDescriptorEnum.Binding));
    }

    public VariablePoint createVariablePoint() {
        return create(PatternsEntityDescriptorEnum.VariablePoint);
    }

    public VariablePoint createVariablePoint(Name name, ResultType resultType) {
        return create(PatternsEntityDescriptorEnum.VariablePoint, name, resultType);
    }

    public IEntityBuilder<VariablePoint> buildVariablePoint() {
        return new EntityBuilder<VariablePoint>(create(PatternsEntityDescriptorEnum.VariablePoint));
    }

    public FunctionApplicationPoint createFunctionApplicationPoint() {
        return create(PatternsEntityDescriptorEnum.FunctionApplicationPoint);
    }

    public FunctionApplicationPoint createFunctionApplicationPoint(Name name, ResultType resultType) {
        return create(PatternsEntityDescriptorEnum.FunctionApplicationPoint, name, resultType);
    }

    public IEntityBuilder<FunctionApplicationPoint> buildFunctionApplicationPoint() {
        return new EntityBuilder<FunctionApplicationPoint>(create(PatternsEntityDescriptorEnum.FunctionApplicationPoint));
    }

    public Slot createSlot() {
        return create(PatternsEntityDescriptorEnum.Slot);
    }

    public Slot createSlot(Name name, BooleanValue optional, PathExpression adapter, Type type, Type resultType) {
        return create(PatternsEntityDescriptorEnum.Slot, name, optional, adapter, type, resultType);
    }

    public IEntityBuilder<Slot> buildSlot() {
        return new EntityBuilder<Slot>(create(PatternsEntityDescriptorEnum.Slot));
    }

    public ResultPoint createResultPoint() {
        return create(PatternsEntityDescriptorEnum.ResultPoint);
    }

    public ResultPoint createResultPoint(Type resultType, Template template, PathExpression weaver) {
        return create(PatternsEntityDescriptorEnum.ResultPoint, resultType, template, weaver);
    }

    public IEntityBuilder<ResultPoint> buildResultPoint() {
        return new EntityBuilder<ResultPoint>(create(PatternsEntityDescriptorEnum.ResultPoint));
    }

    public JoinPoint createJoinPoint() {
        return create(PatternsEntityDescriptorEnum.JoinPoint);
    }

    public JoinPoint createJoinPoint(Name name, Template template) {
        return create(PatternsEntityDescriptorEnum.JoinPoint, name, template);
    }

    public IEntityBuilder<JoinPoint> buildJoinPoint() {
        return new EntityBuilder<JoinPoint>(create(PatternsEntityDescriptorEnum.JoinPoint));
    }

    public InsertionPoint createInsertionPoint() {
        return create(PatternsEntityDescriptorEnum.InsertionPoint);
    }

    public InsertionPoint createInsertionPoint(Name name) {
        return create(PatternsEntityDescriptorEnum.InsertionPoint, name);
    }

    public ScopePoint createScopePoint() {
        return create(PatternsEntityDescriptorEnum.ScopePoint);
    }

    public ScopePoint createScopePoint(Declarations context, Template template) {
        return create(PatternsEntityDescriptorEnum.ScopePoint, context, template);
    }

    public IEntityBuilder<ScopePoint> buildScopePoint() {
        return new EntityBuilder<ScopePoint>(create(PatternsEntityDescriptorEnum.ScopePoint));
    }

    public TemplatePoint createTemplatePoint() {
        return create(PatternsEntityDescriptorEnum.TemplatePoint);
    }

    public TemplatePoint createTemplatePoint(Template template) {
        return create(PatternsEntityDescriptorEnum.TemplatePoint, template);
    }

    public DerivationPoint createDerivationPoint() {
        return create(PatternsEntityDescriptorEnum.DerivationPoint);
    }

    public DerivationPoint createDerivationPoint(Expression expression, ResultType resultType) {
        return create(PatternsEntityDescriptorEnum.DerivationPoint, expression, resultType);
    }

    public IEntityBuilder<DerivationPoint> buildDerivationPoint() {
        return new EntityBuilder<DerivationPoint>(create(PatternsEntityDescriptorEnum.DerivationPoint));
    }

    public SelectionPoint createSelectionPoint() {
        return create(PatternsEntityDescriptorEnum.SelectionPoint);
    }

    public SelectionPoint createSelectionPoint(ConditionPoint... entities) {
        return create(PatternsEntityDescriptorEnum.SelectionPoint, (IEntity[]) entities);
    }

    public SelectionPoint createSelectionPoint(int initialSize) {
        return clone(PatternsEntityDescriptorEnum.SelectionPoint, initialSize);
    }

    public ConditionPoint createConditionPoint() {
        return create(PatternsEntityDescriptorEnum.ConditionPoint);
    }

    public ConditionPoint createConditionPoint(Predicate condition, Template template) {
        return create(PatternsEntityDescriptorEnum.ConditionPoint, condition, template);
    }

    public IEntityBuilder<ConditionPoint> buildConditionPoint() {
        return new EntityBuilder<ConditionPoint>(create(PatternsEntityDescriptorEnum.ConditionPoint));
    }

    public VariantSelectionPoint createVariantSelectionPoint() {
        return create(PatternsEntityDescriptorEnum.VariantSelectionPoint);
    }

    public VariantSelectionPoint createVariantSelectionPoint(Name variability, Variants variants) {
        return create(PatternsEntityDescriptorEnum.VariantSelectionPoint, variability, variants);
    }

    public IEntityBuilder<VariantSelectionPoint> buildVariantSelectionPoint() {
        return new EntityBuilder<VariantSelectionPoint>(create(PatternsEntityDescriptorEnum.VariantSelectionPoint));
    }

    public Variants createVariants() {
        return create(PatternsEntityDescriptorEnum.Variants);
    }

    public Variants createVariants(Variant... entities) {
        return create(PatternsEntityDescriptorEnum.Variants, (IEntity[]) entities);
    }

    public Variants createVariants(int initialSize) {
        return clone(PatternsEntityDescriptorEnum.Variants, initialSize);
    }

    public Variant createVariant() {
        return create(PatternsEntityDescriptorEnum.Variant);
    }

    public Variant createVariant(Name name, Template template) {
        return create(PatternsEntityDescriptorEnum.Variant, name, template);
    }

    public IEntityBuilder<Variant> buildVariant() {
        return new EntityBuilder<Variant>(create(PatternsEntityDescriptorEnum.Variant));
    }

    public IterationPoint createIterationPoint() {
        return create(PatternsEntityDescriptorEnum.IterationPoint);
    }

    public IterationPoint createIterationPoint(PathExpression iterator, Template template) {
        return create(PatternsEntityDescriptorEnum.IterationPoint, iterator, template);
    }

    public IEntityBuilder<IterationPoint> buildIterationPoint() {
        return new EntityBuilder<IterationPoint>(create(PatternsEntityDescriptorEnum.IterationPoint));
    }

    public SequencePoint createSequencePoint() {
        return create(PatternsEntityDescriptorEnum.SequencePoint);
    }

    public SequencePoint createSequencePoint(Template... entities) {
        return create(PatternsEntityDescriptorEnum.SequencePoint, (IEntity[]) entities);
    }

    public SequencePoint createSequencePoint(int initialSize) {
        return clone(PatternsEntityDescriptorEnum.SequencePoint, initialSize);
    }

    public InlinePoint createInlinePoint() {
        return create(PatternsEntityDescriptorEnum.InlinePoint);
    }

    public InlinePoint createInlinePoint(Template template) {
        return create(PatternsEntityDescriptorEnum.InlinePoint, template);
    }

    public Declarations createDeclarations() {
        return create(PatternsEntityDescriptorEnum.Declarations);
    }

    public Declarations createDeclarations(Declaration... entities) {
        return create(PatternsEntityDescriptorEnum.Declarations, (IEntity[]) entities);
    }

    public Declarations createDeclarations(int initialSize) {
        return clone(PatternsEntityDescriptorEnum.Declarations, initialSize);
    }

    public FunctionDeclaration createFunctionDeclaration() {
        return create(PatternsEntityDescriptorEnum.FunctionDeclaration);
    }

    public FunctionDeclaration createFunctionDeclaration(ResultTypes applicationTypes, Name name, Expression body) {
        return create(PatternsEntityDescriptorEnum.FunctionDeclaration, applicationTypes, name, body);
    }

    public IEntityBuilder<FunctionDeclaration> buildFunctionDeclaration() {
        return new EntityBuilder<FunctionDeclaration>(create(PatternsEntityDescriptorEnum.FunctionDeclaration));
    }

    public PointcutDeclaration createPointcutDeclaration() {
        return create(PatternsEntityDescriptorEnum.PointcutDeclaration);
    }

    public PointcutDeclaration createPointcutDeclaration(Name name, Expression expression) {
        return create(PatternsEntityDescriptorEnum.PointcutDeclaration, name, expression);
    }

    public IEntityBuilder<PointcutDeclaration> buildPointcutDeclaration() {
        return new EntityBuilder<PointcutDeclaration>(create(PatternsEntityDescriptorEnum.PointcutDeclaration));
    }

    public JoinPointDeclaration createJoinPointDeclaration() {
        return create(PatternsEntityDescriptorEnum.JoinPointDeclaration);
    }

    public JoinPointDeclaration createJoinPointDeclaration(Name name, Expression expression) {
        return create(PatternsEntityDescriptorEnum.JoinPointDeclaration, name, expression);
    }

    public IEntityBuilder<JoinPointDeclaration> buildJoinPointDeclaration() {
        return new EntityBuilder<JoinPointDeclaration>(create(PatternsEntityDescriptorEnum.JoinPointDeclaration));
    }

    public VariableDeclaration createVariableDeclaration() {
        return create(PatternsEntityDescriptorEnum.VariableDeclaration);
    }

    public VariableDeclaration createVariableDeclaration(Name name, Expression expression, Type resultType) {
        return create(PatternsEntityDescriptorEnum.VariableDeclaration, name, expression, resultType);
    }

    public IEntityBuilder<VariableDeclaration> buildVariableDeclaration() {
        return new EntityBuilder<VariableDeclaration>(create(PatternsEntityDescriptorEnum.VariableDeclaration));
    }

    public VariantSelector createVariantSelector() {
        return create(PatternsEntityDescriptorEnum.VariantSelector);
    }

    public VariantSelector createVariantSelector(Name variability, Expression variant) {
        return create(PatternsEntityDescriptorEnum.VariantSelector, variability, variant);
    }

    public IEntityBuilder<VariantSelector> buildVariantSelector() {
        return new EntityBuilder<VariantSelector>(create(PatternsEntityDescriptorEnum.VariantSelector));
    }

    public Types createTypes() {
        return create(PatternsEntityDescriptorEnum.Types);
    }

    public Types createTypes(Type... entities) {
        return create(PatternsEntityDescriptorEnum.Types, (IEntity[]) entities);
    }

    public Types createTypes(int initialSize) {
        return clone(PatternsEntityDescriptorEnum.Types, initialSize);
    }

    public ResultTypes createResultTypes() {
        return create(PatternsEntityDescriptorEnum.ResultTypes);
    }

    public ResultTypes createResultTypes(ResultType... entities) {
        return create(PatternsEntityDescriptorEnum.ResultTypes, (IEntity[]) entities);
    }

    public ResultTypes createResultTypes(int initialSize) {
        return clone(PatternsEntityDescriptorEnum.ResultTypes, initialSize);
    }

    public Name createName() {
        return create(PatternsEntityDescriptorEnum.Name);
    }

    public Name createName(String value) {
        return create(PatternsEntityDescriptorEnum.Name, value);
    }

    public PatternJoinPointStep createPatternJoinPointStep() {
        return create(PatternsEntityDescriptorEnum.PatternJoinPointStep);
    }

    public JoinPointStep createJoinPointStep() {
        return create(PatternsEntityDescriptorEnum.JoinPointStep);
    }

    public JoinPointStep createJoinPointStep(String value) {
        return create(PatternsEntityDescriptorEnum.JoinPointStep, value);
    }

    public PointcutStep createPointcutStep() {
        return create(PatternsEntityDescriptorEnum.PointcutStep);
    }

    public PointcutStep createPointcutStep(String value) {
        return create(PatternsEntityDescriptorEnum.PointcutStep, value);
    }

    public SlotStep createSlotStep() {
        return create(PatternsEntityDescriptorEnum.SlotStep);
    }

    public SlotStep createSlotStep(String value) {
        return create(PatternsEntityDescriptorEnum.SlotStep, value);
    }

    public OuterDefinitionStep createOuterDefinitionStep() {
        return create(PatternsEntityDescriptorEnum.OuterDefinitionStep);
    }

    public OuterDefinitionStep createOuterDefinitionStep(String value) {
        return create(PatternsEntityDescriptorEnum.OuterDefinitionStep, value);
    }

    public Cut createCut() {
        return create(PatternsEntityDescriptorEnum.Cut);
    }

    public Cut createCut(PathExpression path) {
        return create(PatternsEntityDescriptorEnum.Cut, path);
    }

    public Insert createInsert() {
        return create(PatternsEntityDescriptorEnum.Insert);
    }

    public Insert createInsert(Placement placement, PathExpression path) {
        return create(PatternsEntityDescriptorEnum.Insert, placement, path);
    }

    public IEntityBuilder<Insert> buildInsert() {
        return new EntityBuilder<Insert>(create(PatternsEntityDescriptorEnum.Insert));
    }

    public SlotsDefined createSlotsDefined() {
        return create(PatternsEntityDescriptorEnum.SlotsDefined);
    }

    public PatternTypeTest createPatternTypeTest() {
        return create(PatternsEntityDescriptorEnum.PatternTypeTest);
    }

    public PatternTypeTest createPatternTypeTest(String value) {
        return create(PatternsEntityDescriptorEnum.PatternTypeTest, value);
    }

    public Placement createPlacement() {
        return create(PatternsEntityDescriptorEnum.Placement);
    }

    public Placement createPlacement(PlacementEnum.Value value) {
        return create(PatternsEntityDescriptorEnum.Placement, value);
    }

    public URI createURI() {
        return create(PatternsEntityDescriptorEnum.URI);
    }

    public URI createURI(String value) {
        return create(PatternsEntityDescriptorEnum.URI, value);
    }

    public Namespace createNamespace() {
        return create(PatternsEntityDescriptorEnum.Namespace);
    }

    public Namespace createNamespace(String value) {
        return create(PatternsEntityDescriptorEnum.Namespace, value);
    }

    public Version createVersion() {
        return create(PatternsEntityDescriptorEnum.Version);
    }

    public Version createVersion(String value) {
        return create(PatternsEntityDescriptorEnum.Version, value);
    }

    public BooleanValue createBooleanValue() {
        return create(PatternsEntityDescriptorEnum.BooleanValue);
    }

    public BooleanValue createBooleanValue(boolean value) {
        return create(PatternsEntityDescriptorEnum.BooleanValue, value);
    }
}
