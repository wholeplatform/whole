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
package org.whole.lang.swiftsyntax.model.adapters;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class SwiftSyntaxAdaptersEntityRegistry extends AbstractEntityRegistry {

    public SwiftSyntaxAdaptersEntityRegistry() {
        super(SwiftSyntaxEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new SyntaxAdapter());
        put(new SyntaxCollectionAdapter());
        put(new DeclAdapter());
        put(new ExprAdapter());
        put(new PatternAdapter());
        put(new StmtAdapter());
        put(new TypeAdapter());
        put(new TokenAdapter());
        put(new UnknownDeclAdapter());
        put(new UnknownExprAdapter());
        put(new UnknownPatternAdapter());
        put(new UnknownStmtAdapter());
        put(new UnknownTypeAdapter());
        put(new CodeBlockItemAdapter());
        put(new CodeBlockItemListAdapter());
        put(new CodeBlockAdapter());
        put(new InOutExprAdapter());
        put(new PoundColumnExprAdapter());
        put(new FunctionCallArgumentListAdapter());
        put(new TupleElementListAdapter());
        put(new ArrayElementListAdapter());
        put(new DictionaryElementListAdapter());
        put(new AbstractSegmentAdapter());
        put(new StringLiteralSegmentsAdapter());
        put(new TryExprAdapter());
        put(new DeclNameArgumentAdapter());
        put(new DeclNameArgumentListAdapter());
        put(new DeclNameArgumentsAdapter());
        put(new IdentifierExprAdapter());
        put(new SuperRefExprAdapter());
        put(new NilLiteralExprAdapter());
        put(new DiscardAssignmentExprAdapter());
        put(new AssignmentExprAdapter());
        put(new SequenceExprAdapter());
        put(new ExprListAdapter());
        put(new PoundLineExprAdapter());
        put(new PoundFileExprAdapter());
        put(new PoundFunctionExprAdapter());
        put(new PoundDsohandleExprAdapter());
        put(new SymbolicReferenceExprAdapter());
        put(new PrefixOperatorExprAdapter());
        put(new BinaryOperatorExprAdapter());
        put(new ArrowExprAdapter());
        put(new FloatLiteralExprAdapter());
        put(new TupleExprAdapter());
        put(new ArrayExprAdapter());
        put(new DictionaryExprAdapter());
        put(new FunctionCallArgumentAdapter());
        put(new TupleElementAdapter());
        put(new ArrayElementAdapter());
        put(new DictionaryElementAdapter());
        put(new IntegerLiteralExprAdapter());
        put(new BooleanLiteralExprAdapter());
        put(new TernaryExprAdapter());
        put(new MemberAccessExprAdapter());
        put(new IsExprAdapter());
        put(new AsExprAdapter());
        put(new TypeExprAdapter());
        put(new ClosureCaptureItemAdapter());
        put(new ClosureCaptureItemListAdapter());
        put(new ClosureCaptureSignatureAdapter());
        put(new ClosureParamAdapter());
        put(new ClosureParamListAdapter());
        put(new ClosureSignatureAdapter());
        put(new ClosureExprAdapter());
        put(new UnresolvedPatternExprAdapter());
        put(new FunctionCallExprAdapter());
        put(new SubscriptExprAdapter());
        put(new OptionalChainingExprAdapter());
        put(new ForcedValueExprAdapter());
        put(new PostfixUnaryExprAdapter());
        put(new SpecializeExprAdapter());
        put(new StringSegmentAdapter());
        put(new ExpressionSegmentAdapter());
        put(new StringLiteralExprAdapter());
        put(new KeyPathExprAdapter());
        put(new KeyPathBaseExprAdapter());
        put(new ObjcNamePieceAdapter());
        put(new ObjcNameAdapter());
        put(new ObjcKeyPathExprAdapter());
        put(new ObjcSelectorExprAdapter());
        put(new EditorPlaceholderExprAdapter());
        put(new ObjectLiteralExprAdapter());
        put(new TypeInitializerClauseAdapter());
        put(new TypealiasDeclAdapter());
        put(new AssociatedtypeDeclAdapter());
        put(new FunctionParameterListAdapter());
        put(new ParameterClauseAdapter());
        put(new ReturnClauseAdapter());
        put(new FunctionSignatureAdapter());
        put(new IfConfigClauseAdapter());
        put(new IfConfigClauseListAdapter());
        put(new IfConfigDeclAdapter());
        put(new PoundErrorDeclAdapter());
        put(new PoundWarningDeclAdapter());
        put(new PoundSourceLocationAdapter());
        put(new PoundSourceLocationArgsAdapter());
        put(new DeclModifierAdapter());
        put(new InheritedTypeAdapter());
        put(new InheritedTypeListAdapter());
        put(new TypeInheritanceClauseAdapter());
        put(new ClassDeclAdapter());
        put(new StructDeclAdapter());
        put(new ProtocolDeclAdapter());
        put(new ExtensionDeclAdapter());
        put(new MemberDeclBlockAdapter());
        put(new MemberDeclListAdapter());
        put(new MemberDeclListItemAdapter());
        put(new SourceFileAdapter());
        put(new InitializerClauseAdapter());
        put(new FunctionParameterAdapter());
        put(new ModifierListAdapter());
        put(new FunctionDeclAdapter());
        put(new InitializerDeclAdapter());
        put(new DeinitializerDeclAdapter());
        put(new SubscriptDeclAdapter());
        put(new AccessLevelModifierAdapter());
        put(new AccessPathComponentAdapter());
        put(new AccessPathAdapter());
        put(new ImportDeclAdapter());
        put(new AccessorParameterAdapter());
        put(new AccessorDeclAdapter());
        put(new AccessorListAdapter());
        put(new AccessorBlockAdapter());
        put(new PatternBindingAdapter());
        put(new PatternBindingListAdapter());
        put(new VariableDeclAdapter());
        put(new EnumCaseElementAdapter());
        put(new EnumCaseElementListAdapter());
        put(new EnumCaseDeclAdapter());
        put(new EnumDeclAdapter());
        put(new OperatorDeclAdapter());
        put(new IdentifierListAdapter());
        put(new OperatorPrecedenceAndTypesAdapter());
        put(new PrecedenceGroupDeclAdapter());
        put(new AbstractPrecedenceGroupAttributeAdapter());
        put(new PrecedenceGroupAttributeListAdapter());
        put(new PrecedenceGroupRelationAdapter());
        put(new PrecedenceGroupNameListAdapter());
        put(new PrecedenceGroupNameElementAdapter());
        put(new PrecedenceGroupAssignmentAdapter());
        put(new PrecedenceGroupAssociativityAdapter());
        put(new TokenListAdapter());
        put(new CustomAttributeAdapter());
        put(new AttributeAdapter());
        put(new AbstractAttributeAdapter());
        put(new AttributeListAdapter());
        put(new AbstractSpecializeAttributeAdapter());
        put(new SpecializeAttributeSpecListAdapter());
        put(new LabeledSpecializeEntryAdapter());
        put(new NamedAttributeStringArgumentAdapter());
        put(new DeclNameAdapter());
        put(new ImplementsAttributeArgumentsAdapter());
        put(new ObjCSelectorPieceAdapter());
        put(new ObjCSelectorAdapter());
        put(new ContinueStmtAdapter());
        put(new WhileStmtAdapter());
        put(new DeferStmtAdapter());
        put(new AbstractSwitchCaseAdapter());
        put(new SwitchCaseListAdapter());
        put(new RepeatWhileStmtAdapter());
        put(new GuardStmtAdapter());
        put(new WhereClauseAdapter());
        put(new ForInStmtAdapter());
        put(new SwitchStmtAdapter());
        put(new CatchClauseListAdapter());
        put(new DoStmtAdapter());
        put(new ReturnStmtAdapter());
        put(new YieldStmtAdapter());
        put(new YieldListAdapter());
        put(new FallthroughStmtAdapter());
        put(new BreakStmtAdapter());
        put(new CaseItemListAdapter());
        put(new ConditionElementAdapter());
        put(new AvailabilityConditionAdapter());
        put(new MatchingPatternConditionAdapter());
        put(new OptionalBindingConditionAdapter());
        put(new ConditionElementListAdapter());
        put(new ThrowStmtAdapter());
        put(new IfStmtAdapter());
        put(new SwitchCaseAdapter());
        put(new SwitchDefaultLabelAdapter());
        put(new CaseItemAdapter());
        put(new SwitchCaseLabelAdapter());
        put(new CatchClauseAdapter());
        put(new PoundAssertStmtAdapter());
        put(new GenericWhereClauseAdapter());
        put(new AbstractGenericRequirementAdapter());
        put(new GenericRequirementListAdapter());
        put(new SameTypeRequirementAdapter());
        put(new GenericParameterListAdapter());
        put(new GenericParameterAdapter());
        put(new GenericParameterClauseAdapter());
        put(new ConformanceRequirementAdapter());
        put(new SimpleTypeIdentifierAdapter());
        put(new MemberTypeIdentifierAdapter());
        put(new ClassRestrictionTypeAdapter());
        put(new ArrayTypeAdapter());
        put(new DictionaryTypeAdapter());
        put(new MetatypeTypeAdapter());
        put(new OptionalTypeAdapter());
        put(new SomeTypeAdapter());
        put(new ImplicitlyUnwrappedOptionalTypeAdapter());
        put(new CompositionTypeElementAdapter());
        put(new CompositionTypeElementListAdapter());
        put(new CompositionTypeAdapter());
        put(new TupleTypeElementAdapter());
        put(new TupleTypeElementListAdapter());
        put(new TupleTypeAdapter());
        put(new FunctionTypeAdapter());
        put(new AttributedTypeAdapter());
        put(new GenericArgumentListAdapter());
        put(new GenericArgumentAdapter());
        put(new GenericArgumentClauseAdapter());
        put(new TypeAnnotationAdapter());
        put(new EnumCasePatternAdapter());
        put(new IsTypePatternAdapter());
        put(new OptionalPatternAdapter());
        put(new IdentifierPatternAdapter());
        put(new AsTypePatternAdapter());
        put(new TuplePatternAdapter());
        put(new WildcardPatternAdapter());
        put(new TuplePatternElementAdapter());
        put(new ExpressionPatternAdapter());
        put(new TuplePatternElementListAdapter());
        put(new ValueBindingPatternAdapter());
        put(new AvailabilitySpecListAdapter());
        put(new AvailabilityArgumentAdapter());
        put(new AvailabilityLabeledArgumentAdapter());
        put(new AvailabilityVersionRestrictionAdapter());
        put(new VersionTupleAdapter());
        put(new TokenKindAdapter());
        put(new TextAdapter());
        put(new TriviaAdapter());
        put(new TriviaPieceAdapter());
        put(new SourcePresenceAdapter());
    }
}
