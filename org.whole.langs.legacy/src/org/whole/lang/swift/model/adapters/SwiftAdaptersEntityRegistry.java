/**
 *  Copyright 2004-2019 Riccardo Solmi. All rights reserved.
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
package org.whole.lang.swift.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class SwiftAdaptersEntityRegistry extends AbstractEntityRegistry {

    public SwiftAdaptersEntityRegistry() {
        super(SwiftEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new DeclAdapter());
        put(new ExprAdapter());
        put(new PatternAdapter());
        put(new StmtAdapter());
        put(new TypeAdapter());
        put(new BooleanLiteralAdapter());
        put(new IntegerLiteralAdapter());
        put(new FloatingLiteralAdapter());
        put(new StringLiteralAdapter());
        put(new IdentifierAdapter());
        put(new BinaryOperatorAdapter());
        put(new PostfixOperatorAdapter());
        put(new PrefixOperatorAdapter());
        put(new DollarIdentifierAdapter());
        put(new RawStringDelimiterAdapter());
        put(new AbstractItemAdapter());
        put(new CodeBlockItemListAdapter());
        put(new InOutExprAdapter());
        put(new PoundColumnExprAdapter());
        put(new FunctionCallArgumentListAdapter());
        put(new AbstractSegmentAdapter());
        put(new StringLiteralSegmentsAdapter());
        put(new ExpressionSegmentAdapter());
        put(new TryExprAdapter());
        put(new QuestionOrExclamationMarkEnumAdapter());
        put(new DeclNameArgumentListAdapter());
        put(new IdentifierExprAdapter());
        put(new AbstractIdentifierAdapter());
        put(new IdentifierEnumAdapter());
        put(new SuperRefExprAdapter());
        put(new NilLiteralExprAdapter());
        put(new DiscardAssignmentExprAdapter());
        put(new AssignmentExprAdapter());
        put(new SequenceExprAdapter());
        put(new PoundLineExprAdapter());
        put(new PoundFileExprAdapter());
        put(new PoundFunctionExprAdapter());
        put(new PoundDsohandleExprAdapter());
        put(new SymbolicReferenceExprAdapter());
        put(new PrefixOperatorExprAdapter());
        put(new BinaryOperatorExprAdapter());
        put(new AbstractOperatorTokenAdapter());
        put(new ArrowExprAdapter());
        put(new ThrowsAdapter());
        put(new TupleExprAdapter());
        put(new ArrayExprAdapter());
        put(new DictionaryExprAdapter());
        put(new FunctionCallArgumentAdapter());
        put(new TupleElementAdapter());
        put(new DictionaryElementAdapter());
        put(new TernaryExprAdapter());
        put(new MemberAccessExprAdapter());
        put(new DotEnumAdapter());
        put(new IsExprAdapter());
        put(new AsExprAdapter());
        put(new TypeExprAdapter());
        put(new ClosureCaptureItemAdapter());
        put(new ClosureCaptureItemListAdapter());
        put(new AbstractNameAdapter());
        put(new WildcardMarkerAdapter());
        put(new ClosureParamListAdapter());
        put(new ClosureSignatureAdapter());
        put(new AbstractInputAdapter());
        put(new ClosureExprAdapter());
        put(new UnresolvedPatternExprAdapter());
        put(new FunctionCallExprAdapter());
        put(new SubscriptExprAdapter());
        put(new OptionalChainingExprAdapter());
        put(new ForcedValueExprAdapter());
        put(new PostfixUnaryExprAdapter());
        put(new SpecializeExprAdapter());
        put(new StringLiteralExprAdapter());
        put(new OpenQuoteEnumAdapter());
        put(new KeyPathExprAdapter());
        put(new AbstractRootExprAdapter());
        put(new KeyPathBaseExprAdapter());
        put(new ObjcKeyPathExprAdapter());
        put(new ObjcSelectorExprAdapter());
        put(new KindValueAdapter());
        put(new EditorPlaceholderExprAdapter());
        put(new ObjectLiteralExprAdapter());
        put(new PoundIdentifierEnumAdapter());
        put(new TypealiasDeclAdapter());
        put(new AssociatedtypeDeclAdapter());
        put(new FunctionParameterListAdapter());
        put(new FunctionSignatureAdapter());
        put(new ThrowsOrRethrowsKeywordEnumAdapter());
        put(new IfConfigClauseAdapter());
        put(new PoundKeywordEnumAdapter());
        put(new AbstractElementsAdapter());
        put(new SwitchCaseListAdapter());
        put(new MemberDeclListAdapter());
        put(new IfConfigDeclAdapter());
        put(new PoundErrorDeclAdapter());
        put(new PoundWarningDeclAdapter());
        put(new PoundSourceLocationAdapter());
        put(new PoundSourceLocationArgsAdapter());
        put(new DeclModifierAdapter());
        put(new NameValueAdapter());
        put(new InheritedTypeListAdapter());
        put(new ClassDeclAdapter());
        put(new StructDeclAdapter());
        put(new ProtocolDeclAdapter());
        put(new ExtensionDeclAdapter());
        put(new SourceFileAdapter());
        put(new FunctionParameterAdapter());
        put(new AbstractFirstNameAdapter());
        put(new AbstractSecondNameAdapter());
        put(new EllipsisAdapter());
        put(new ModifierListAdapter());
        put(new FunctionDeclAdapter());
        put(new AbstractFunctionIdentifierAdapter());
        put(new InitializerDeclAdapter());
        put(new OptionalMarkEnumAdapter());
        put(new DeinitializerDeclAdapter());
        put(new SubscriptDeclAdapter());
        put(new AbstractAccessorAdapter());
        put(new AccessorBlockAdapter());
        put(new AccessLevelModifierAdapter());
        put(new AccessPathAdapter());
        put(new ImportDeclAdapter());
        put(new ImportKindEnumAdapter());
        put(new AccessorDeclAdapter());
        put(new AccessorKindValueAdapter());
        put(new PatternBindingAdapter());
        put(new PatternBindingListAdapter());
        put(new VariableDeclAdapter());
        put(new LetOrVarKeywordEnumAdapter());
        put(new EnumCaseElementAdapter());
        put(new EnumCaseElementListAdapter());
        put(new EnumCaseDeclAdapter());
        put(new EnumDeclAdapter());
        put(new OperatorDeclAdapter());
        put(new AbstractOperatorIdentifierAdapter());
        put(new IdentifierListAdapter());
        put(new PrecedenceGroupDeclAdapter());
        put(new AbstractPrecedenceGroupAttributeAdapter());
        put(new PrecedenceGroupAttributeListAdapter());
        put(new PrecedenceGroupRelationAdapter());
        put(new PrecedenceGroupAssignmentAdapter());
        put(new PrecedenceGroupAssociativityAdapter());
        put(new HigherThanOrLowerThanValueAdapter());
        put(new PrecedenceGroupNameListAdapter());
        put(new FlagEnumAdapter());
        put(new ValueValueAdapter());
        put(new CustomAttributeAdapter());
        put(new AttributeAdapter());
        put(new AbstractArgumentAdapter());
        put(new AvailabilitySpecListAdapter());
        put(new SpecializeAttributeSpecListAdapter());
        put(new ObjCSelectorAdapter());
        put(new ImplementsAttributeArgumentsAdapter());
        put(new NamedAttributeStringArgumentAdapter());
        put(new AbstractAttributeAdapter());
        put(new AttributeListAdapter());
        put(new AbstractSpecializeAttributeAdapter());
        put(new LabeledSpecializeEntryAdapter());
        put(new AbstractValueAdapter());
        put(new AbstractStringOrDeclnameAdapter());
        put(new DeclNameAdapter());
        put(new AbstractDeclBaseNameAdapter());
        put(new ContinueStmtAdapter());
        put(new WhileStmtAdapter());
        put(new DeferStmtAdapter());
        put(new AbstractSwitchCaseAdapter());
        put(new SwitchCaseAdapter());
        put(new RepeatWhileStmtAdapter());
        put(new GuardStmtAdapter());
        put(new ForInStmtAdapter());
        put(new CaseAdapter());
        put(new SwitchStmtAdapter());
        put(new CatchClauseListAdapter());
        put(new DoStmtAdapter());
        put(new ReturnStmtAdapter());
        put(new YieldStmtAdapter());
        put(new AbstractYieldsAdapter());
        put(new YieldListAdapter());
        put(new FallthroughStmtAdapter());
        put(new BreakStmtAdapter());
        put(new AbstractConditionAdapter());
        put(new AvailabilityConditionAdapter());
        put(new MatchingPatternConditionAdapter());
        put(new OptionalBindingConditionAdapter());
        put(new ConditionElementListAdapter());
        put(new ThrowStmtAdapter());
        put(new IfStmtAdapter());
        put(new AbstractElseBodyAdapter());
        put(new AbstractLabelAdapter());
        put(new SwitchDefaultLabelAdapter());
        put(new SwitchCaseLabelAdapter());
        put(new CaseItemAdapter());
        put(new CatchClauseAdapter());
        put(new PoundAssertStmtAdapter());
        put(new AbstractGenericRequirementAdapter());
        put(new GenericRequirementListAdapter());
        put(new SameTypeRequirementAdapter());
        put(new ConformanceRequirementAdapter());
        put(new AbstractEqualityTokenAdapter());
        put(new GenericParameterListAdapter());
        put(new GenericParameterAdapter());
        put(new SimpleTypeIdentifierAdapter());
        put(new NameEnumAdapter());
        put(new MemberTypeIdentifierAdapter());
        put(new PeriodEnumAdapter());
        put(new ClassRestrictionTypeAdapter());
        put(new ArrayTypeAdapter());
        put(new DictionaryTypeAdapter());
        put(new MetatypeTypeAdapter());
        put(new TypeOrProtocolValueAdapter());
        put(new OptionalTypeAdapter());
        put(new SomeTypeAdapter());
        put(new ImplicitlyUnwrappedOptionalTypeAdapter());
        put(new CompositionTypeElementAdapter());
        put(new AmpersandAdapter());
        put(new CompositionTypeAdapter());
        put(new TupleTypeElementAdapter());
        put(new InoutAdapter());
        put(new TupleTypeElementListAdapter());
        put(new TupleTypeAdapter());
        put(new FunctionTypeAdapter());
        put(new AttributedTypeAdapter());
        put(new SpecifierValueAdapter());
        put(new GenericArgumentListAdapter());
        put(new EnumCasePatternAdapter());
        put(new IsTypePatternAdapter());
        put(new OptionalPatternAdapter());
        put(new IdentifierPatternAdapter());
        put(new AbstractPatternIdentifierAdapter());
        put(new SelfMarkerAdapter());
        put(new AsTypePatternAdapter());
        put(new WildcardPatternAdapter());
        put(new TuplePatternElementAdapter());
        put(new ExpressionPatternAdapter());
        put(new TuplePatternElementListAdapter());
        put(new ValueBindingPatternAdapter());
        put(new AbstractEntryAdapter());
        put(new AvailabilityVersionRestrictionAdapter());
        put(new AvailabilityLabeledArgumentAdapter());
        put(new VersionTupleAdapter());
        put(new AbstractMajorMinorAdapter());
        put(new CaptureSpecifierEnumAdapter());
    }
}
