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
package org.whole.lang.swift.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.swift.reflect.SwiftEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class SwiftImplEntityRegistry extends AbstractEntityRegistry {

    public SwiftImplEntityRegistry() {
        super(SwiftEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new BooleanLiteralImpl());
        put(new IntegerLiteralImpl());
        put(new FloatingLiteralImpl());
        put(new StringLiteralImpl());
        put(new IdentifierImpl());
        put(new BinaryOperatorImpl());
        put(new PostfixOperatorImpl());
        put(new PrefixOperatorImpl());
        put(new DollarIdentifierImpl());
        put(new RawStringDelimiterImpl());
        put(new CodeBlockItemListImpl());
        put(new InOutExprImpl());
        put(new PoundColumnExprImpl());
        put(new FunctionCallArgumentListImpl());
        put(new StringLiteralSegmentsImpl());
        put(new ExpressionSegmentImpl());
        put(new TryExprImpl());
        put(new QuestionOrExclamationMarkEnumImpl());
        put(new DeclNameArgumentListImpl());
        put(new IdentifierExprImpl());
        put(new IdentifierEnumImpl());
        put(new SuperRefExprImpl());
        put(new NilLiteralExprImpl());
        put(new DiscardAssignmentExprImpl());
        put(new AssignmentExprImpl());
        put(new SequenceExprImpl());
        put(new PoundLineExprImpl());
        put(new PoundFileExprImpl());
        put(new PoundFunctionExprImpl());
        put(new PoundDsohandleExprImpl());
        put(new SymbolicReferenceExprImpl());
        put(new PrefixOperatorExprImpl());
        put(new BinaryOperatorExprImpl());
        put(new ArrowExprImpl());
        put(new ThrowsImpl());
        put(new TupleExprImpl());
        put(new ArrayExprImpl());
        put(new DictionaryExprImpl());
        put(new FunctionCallArgumentImpl());
        put(new TupleElementImpl());
        put(new DictionaryElementImpl());
        put(new TernaryExprImpl());
        put(new MemberAccessExprImpl());
        put(new DotEnumImpl());
        put(new IsExprImpl());
        put(new AsExprImpl());
        put(new TypeExprImpl());
        put(new ClosureCaptureItemImpl());
        put(new ClosureCaptureItemListImpl());
        put(new WildcardMarkerImpl());
        put(new ClosureParamListImpl());
        put(new ClosureSignatureImpl());
        put(new ClosureExprImpl());
        put(new UnresolvedPatternExprImpl());
        put(new FunctionCallExprImpl());
        put(new SubscriptExprImpl());
        put(new OptionalChainingExprImpl());
        put(new ForcedValueExprImpl());
        put(new PostfixUnaryExprImpl());
        put(new SpecializeExprImpl());
        put(new StringLiteralExprImpl());
        put(new OpenQuoteEnumImpl());
        put(new KeyPathExprImpl());
        put(new KeyPathBaseExprImpl());
        put(new ObjcKeyPathExprImpl());
        put(new ObjcSelectorExprImpl());
        put(new KindValueImpl());
        put(new EditorPlaceholderExprImpl());
        put(new ObjectLiteralExprImpl());
        put(new PoundIdentifierEnumImpl());
        put(new TypealiasDeclImpl());
        put(new AssociatedtypeDeclImpl());
        put(new FunctionParameterListImpl());
        put(new FunctionSignatureImpl());
        put(new ThrowsOrRethrowsKeywordEnumImpl());
        put(new IfConfigClauseImpl());
        put(new PoundKeywordEnumImpl());
        put(new SwitchCaseListImpl());
        put(new MemberDeclListImpl());
        put(new IfConfigDeclImpl());
        put(new PoundErrorDeclImpl());
        put(new PoundWarningDeclImpl());
        put(new PoundSourceLocationImpl());
        put(new PoundSourceLocationArgsImpl());
        put(new DeclModifierImpl());
        put(new NameValueImpl());
        put(new InheritedTypeListImpl());
        put(new ClassDeclImpl());
        put(new StructDeclImpl());
        put(new ProtocolDeclImpl());
        put(new ExtensionDeclImpl());
        put(new SourceFileImpl());
        put(new FunctionParameterImpl());
        put(new EllipsisImpl());
        put(new ModifierListImpl());
        put(new FunctionDeclImpl());
        put(new InitializerDeclImpl());
        put(new OptionalMarkEnumImpl());
        put(new DeinitializerDeclImpl());
        put(new SubscriptDeclImpl());
        put(new AccessorBlockImpl());
        put(new AccessLevelModifierImpl());
        put(new AccessPathImpl());
        put(new ImportDeclImpl());
        put(new ImportKindEnumImpl());
        put(new AccessorDeclImpl());
        put(new AccessorKindValueImpl());
        put(new PatternBindingImpl());
        put(new PatternBindingListImpl());
        put(new VariableDeclImpl());
        put(new LetOrVarKeywordEnumImpl());
        put(new EnumCaseElementImpl());
        put(new EnumCaseElementListImpl());
        put(new EnumCaseDeclImpl());
        put(new EnumDeclImpl());
        put(new OperatorDeclImpl());
        put(new IdentifierListImpl());
        put(new PrecedenceGroupDeclImpl());
        put(new PrecedenceGroupAttributeListImpl());
        put(new PrecedenceGroupRelationImpl());
        put(new PrecedenceGroupAssignmentImpl());
        put(new PrecedenceGroupAssociativityImpl());
        put(new HigherThanOrLowerThanValueImpl());
        put(new PrecedenceGroupNameListImpl());
        put(new FlagEnumImpl());
        put(new ValueValueImpl());
        put(new CustomAttributeImpl());
        put(new AttributeImpl());
        put(new AvailabilitySpecListImpl());
        put(new SpecializeAttributeSpecListImpl());
        put(new ObjCSelectorImpl());
        put(new ImplementsAttributeArgumentsImpl());
        put(new NamedAttributeStringArgumentImpl());
        put(new AttributeListImpl());
        put(new LabeledSpecializeEntryImpl());
        put(new DeclNameImpl());
        put(new ContinueStmtImpl());
        put(new WhileStmtImpl());
        put(new DeferStmtImpl());
        put(new SwitchCaseImpl());
        put(new RepeatWhileStmtImpl());
        put(new GuardStmtImpl());
        put(new ForInStmtImpl());
        put(new CaseImpl());
        put(new SwitchStmtImpl());
        put(new CatchClauseListImpl());
        put(new DoStmtImpl());
        put(new ReturnStmtImpl());
        put(new YieldStmtImpl());
        put(new YieldListImpl());
        put(new FallthroughStmtImpl());
        put(new BreakStmtImpl());
        put(new AvailabilityConditionImpl());
        put(new MatchingPatternConditionImpl());
        put(new OptionalBindingConditionImpl());
        put(new ConditionElementListImpl());
        put(new ThrowStmtImpl());
        put(new IfStmtImpl());
        put(new SwitchDefaultLabelImpl());
        put(new SwitchCaseLabelImpl());
        put(new CaseItemImpl());
        put(new CatchClauseImpl());
        put(new PoundAssertStmtImpl());
        put(new GenericRequirementListImpl());
        put(new SameTypeRequirementImpl());
        put(new ConformanceRequirementImpl());
        put(new GenericParameterListImpl());
        put(new GenericParameterImpl());
        put(new SimpleTypeIdentifierImpl());
        put(new NameEnumImpl());
        put(new MemberTypeIdentifierImpl());
        put(new PeriodEnumImpl());
        put(new ClassRestrictionTypeImpl());
        put(new ArrayTypeImpl());
        put(new DictionaryTypeImpl());
        put(new MetatypeTypeImpl());
        put(new TypeOrProtocolValueImpl());
        put(new OptionalTypeImpl());
        put(new SomeTypeImpl());
        put(new ImplicitlyUnwrappedOptionalTypeImpl());
        put(new CompositionTypeElementImpl());
        put(new AmpersandImpl());
        put(new CompositionTypeImpl());
        put(new TupleTypeElementImpl());
        put(new InoutImpl());
        put(new TupleTypeElementListImpl());
        put(new TupleTypeImpl());
        put(new FunctionTypeImpl());
        put(new AttributedTypeImpl());
        put(new SpecifierValueImpl());
        put(new GenericArgumentListImpl());
        put(new EnumCasePatternImpl());
        put(new IsTypePatternImpl());
        put(new OptionalPatternImpl());
        put(new IdentifierPatternImpl());
        put(new SelfMarkerImpl());
        put(new AsTypePatternImpl());
        put(new WildcardPatternImpl());
        put(new TuplePatternElementImpl());
        put(new ExpressionPatternImpl());
        put(new TuplePatternElementListImpl());
        put(new ValueBindingPatternImpl());
        put(new AvailabilityVersionRestrictionImpl());
        put(new AvailabilityLabeledArgumentImpl());
        put(new VersionTupleImpl());
        put(new CaptureSpecifierEnumImpl());
    }
}
