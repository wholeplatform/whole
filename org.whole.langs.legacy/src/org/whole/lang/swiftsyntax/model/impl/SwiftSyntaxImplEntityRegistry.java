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
package org.whole.lang.swiftsyntax.model.impl;

import org.whole.lang.factories.AbstractEntityRegistry;
import org.whole.lang.swiftsyntax.reflect.SwiftSyntaxEntityDescriptorEnum;

/**
 *  @generator Whole
 */
public class SwiftSyntaxImplEntityRegistry extends AbstractEntityRegistry {

    public SwiftSyntaxImplEntityRegistry() {
        super(SwiftSyntaxEntityDescriptorEnum.instance);
    }

    protected void createPrototypes() {
        put(new TokenImpl());
        put(new UnknownDeclImpl());
        put(new UnknownExprImpl());
        put(new UnknownPatternImpl());
        put(new UnknownStmtImpl());
        put(new UnknownTypeImpl());
        put(new CodeBlockItemImpl());
        put(new CodeBlockItemListImpl());
        put(new CodeBlockImpl());
        put(new InOutExprImpl());
        put(new PoundColumnExprImpl());
        put(new FunctionCallArgumentListImpl());
        put(new TupleElementListImpl());
        put(new ArrayElementListImpl());
        put(new DictionaryElementListImpl());
        put(new StringLiteralSegmentsImpl());
        put(new TryExprImpl());
        put(new DeclNameArgumentImpl());
        put(new DeclNameArgumentListImpl());
        put(new DeclNameArgumentsImpl());
        put(new IdentifierExprImpl());
        put(new SuperRefExprImpl());
        put(new NilLiteralExprImpl());
        put(new DiscardAssignmentExprImpl());
        put(new AssignmentExprImpl());
        put(new SequenceExprImpl());
        put(new ExprListImpl());
        put(new PoundLineExprImpl());
        put(new PoundFileExprImpl());
        put(new PoundFunctionExprImpl());
        put(new PoundDsohandleExprImpl());
        put(new SymbolicReferenceExprImpl());
        put(new PrefixOperatorExprImpl());
        put(new BinaryOperatorExprImpl());
        put(new ArrowExprImpl());
        put(new FloatLiteralExprImpl());
        put(new TupleExprImpl());
        put(new ArrayExprImpl());
        put(new DictionaryExprImpl());
        put(new FunctionCallArgumentImpl());
        put(new TupleElementImpl());
        put(new ArrayElementImpl());
        put(new DictionaryElementImpl());
        put(new IntegerLiteralExprImpl());
        put(new BooleanLiteralExprImpl());
        put(new TernaryExprImpl());
        put(new MemberAccessExprImpl());
        put(new IsExprImpl());
        put(new AsExprImpl());
        put(new TypeExprImpl());
        put(new ClosureCaptureItemImpl());
        put(new ClosureCaptureItemListImpl());
        put(new ClosureCaptureSignatureImpl());
        put(new ClosureParamImpl());
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
        put(new StringSegmentImpl());
        put(new ExpressionSegmentImpl());
        put(new StringLiteralExprImpl());
        put(new KeyPathExprImpl());
        put(new KeyPathBaseExprImpl());
        put(new ObjcNamePieceImpl());
        put(new ObjcNameImpl());
        put(new ObjcKeyPathExprImpl());
        put(new ObjcSelectorExprImpl());
        put(new EditorPlaceholderExprImpl());
        put(new ObjectLiteralExprImpl());
        put(new TypeInitializerClauseImpl());
        put(new TypealiasDeclImpl());
        put(new AssociatedtypeDeclImpl());
        put(new FunctionParameterListImpl());
        put(new ParameterClauseImpl());
        put(new ReturnClauseImpl());
        put(new FunctionSignatureImpl());
        put(new IfConfigClauseImpl());
        put(new IfConfigClauseListImpl());
        put(new IfConfigDeclImpl());
        put(new PoundErrorDeclImpl());
        put(new PoundWarningDeclImpl());
        put(new PoundSourceLocationImpl());
        put(new PoundSourceLocationArgsImpl());
        put(new DeclModifierImpl());
        put(new InheritedTypeImpl());
        put(new InheritedTypeListImpl());
        put(new TypeInheritanceClauseImpl());
        put(new ClassDeclImpl());
        put(new StructDeclImpl());
        put(new ProtocolDeclImpl());
        put(new ExtensionDeclImpl());
        put(new MemberDeclBlockImpl());
        put(new MemberDeclListImpl());
        put(new MemberDeclListItemImpl());
        put(new SourceFileImpl());
        put(new InitializerClauseImpl());
        put(new FunctionParameterImpl());
        put(new ModifierListImpl());
        put(new FunctionDeclImpl());
        put(new InitializerDeclImpl());
        put(new DeinitializerDeclImpl());
        put(new SubscriptDeclImpl());
        put(new AccessLevelModifierImpl());
        put(new AccessPathComponentImpl());
        put(new AccessPathImpl());
        put(new ImportDeclImpl());
        put(new AccessorParameterImpl());
        put(new AccessorDeclImpl());
        put(new AccessorListImpl());
        put(new AccessorBlockImpl());
        put(new PatternBindingImpl());
        put(new PatternBindingListImpl());
        put(new VariableDeclImpl());
        put(new EnumCaseElementImpl());
        put(new EnumCaseElementListImpl());
        put(new EnumCaseDeclImpl());
        put(new EnumDeclImpl());
        put(new OperatorDeclImpl());
        put(new IdentifierListImpl());
        put(new OperatorPrecedenceAndTypesImpl());
        put(new PrecedenceGroupDeclImpl());
        put(new PrecedenceGroupAttributeListImpl());
        put(new PrecedenceGroupRelationImpl());
        put(new PrecedenceGroupNameListImpl());
        put(new PrecedenceGroupNameElementImpl());
        put(new PrecedenceGroupAssignmentImpl());
        put(new PrecedenceGroupAssociativityImpl());
        put(new TokenListImpl());
        put(new CustomAttributeImpl());
        put(new AttributeImpl());
        put(new AttributeListImpl());
        put(new SpecializeAttributeSpecListImpl());
        put(new LabeledSpecializeEntryImpl());
        put(new NamedAttributeStringArgumentImpl());
        put(new DeclNameImpl());
        put(new ImplementsAttributeArgumentsImpl());
        put(new ObjCSelectorPieceImpl());
        put(new ObjCSelectorImpl());
        put(new ContinueStmtImpl());
        put(new WhileStmtImpl());
        put(new DeferStmtImpl());
        put(new SwitchCaseListImpl());
        put(new RepeatWhileStmtImpl());
        put(new GuardStmtImpl());
        put(new WhereClauseImpl());
        put(new ForInStmtImpl());
        put(new SwitchStmtImpl());
        put(new CatchClauseListImpl());
        put(new DoStmtImpl());
        put(new ReturnStmtImpl());
        put(new YieldStmtImpl());
        put(new YieldListImpl());
        put(new FallthroughStmtImpl());
        put(new BreakStmtImpl());
        put(new CaseItemListImpl());
        put(new ConditionElementImpl());
        put(new AvailabilityConditionImpl());
        put(new MatchingPatternConditionImpl());
        put(new OptionalBindingConditionImpl());
        put(new ConditionElementListImpl());
        put(new ThrowStmtImpl());
        put(new IfStmtImpl());
        put(new SwitchCaseImpl());
        put(new SwitchDefaultLabelImpl());
        put(new CaseItemImpl());
        put(new SwitchCaseLabelImpl());
        put(new CatchClauseImpl());
        put(new PoundAssertStmtImpl());
        put(new GenericWhereClauseImpl());
        put(new GenericRequirementListImpl());
        put(new SameTypeRequirementImpl());
        put(new GenericParameterListImpl());
        put(new GenericParameterImpl());
        put(new GenericParameterClauseImpl());
        put(new ConformanceRequirementImpl());
        put(new SimpleTypeIdentifierImpl());
        put(new MemberTypeIdentifierImpl());
        put(new ClassRestrictionTypeImpl());
        put(new ArrayTypeImpl());
        put(new DictionaryTypeImpl());
        put(new MetatypeTypeImpl());
        put(new OptionalTypeImpl());
        put(new SomeTypeImpl());
        put(new ImplicitlyUnwrappedOptionalTypeImpl());
        put(new CompositionTypeElementImpl());
        put(new CompositionTypeElementListImpl());
        put(new CompositionTypeImpl());
        put(new TupleTypeElementImpl());
        put(new TupleTypeElementListImpl());
        put(new TupleTypeImpl());
        put(new FunctionTypeImpl());
        put(new AttributedTypeImpl());
        put(new GenericArgumentListImpl());
        put(new GenericArgumentImpl());
        put(new GenericArgumentClauseImpl());
        put(new TypeAnnotationImpl());
        put(new EnumCasePatternImpl());
        put(new IsTypePatternImpl());
        put(new OptionalPatternImpl());
        put(new IdentifierPatternImpl());
        put(new AsTypePatternImpl());
        put(new TuplePatternImpl());
        put(new WildcardPatternImpl());
        put(new TuplePatternElementImpl());
        put(new ExpressionPatternImpl());
        put(new TuplePatternElementListImpl());
        put(new ValueBindingPatternImpl());
        put(new AvailabilitySpecListImpl());
        put(new AvailabilityArgumentImpl());
        put(new AvailabilityLabeledArgumentImpl());
        put(new AvailabilityVersionRestrictionImpl());
        put(new VersionTupleImpl());
        put(new TokenKindImpl());
        put(new TextImpl());
        put(new TriviaImpl());
        put(new TriviaPieceImpl());
        put(new SourcePresenceImpl());
    }
}
