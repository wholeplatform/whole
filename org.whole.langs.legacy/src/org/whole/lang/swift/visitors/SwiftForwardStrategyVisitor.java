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
package org.whole.lang.swift.visitors;

import org.whole.lang.visitors.GenericForwardStrategyVisitor;
import org.whole.lang.swift.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SwiftForwardStrategyVisitor extends GenericForwardStrategyVisitor<ISwiftVisitor> implements ISwiftVisitor {

    public SwiftForwardStrategyVisitor() {
        this(new SwiftIdentityVisitor());
    }

    public SwiftForwardStrategyVisitor(ISwiftVisitor... initialStrategies) {
        super(initialStrategies);
    }

    public void visit(IEntity entity) {
        ((ISwiftEntity) entity).accept(this);
    }

    public void visit(BooleanLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IntegerLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FloatingLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StringLiteral entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Identifier entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BinaryOperator entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PostfixOperator entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrefixOperator entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DollarIdentifier entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(RawStringDelimiter entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CodeBlockItemList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InOutExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundColumnExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionCallArgumentList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StringLiteralSegments entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExpressionSegment entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TryExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(QuestionOrExclamationMarkEnum entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DeclNameArgumentList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IdentifierExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IdentifierEnum entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SuperRefExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NilLiteralExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DiscardAssignmentExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AssignmentExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SequenceExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundLineExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundFileExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundFunctionExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundDsohandleExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SymbolicReferenceExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrefixOperatorExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BinaryOperatorExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArrowExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Throws entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TupleExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArrayExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DictionaryExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionCallArgument entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TupleElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DictionaryElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TernaryExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MemberAccessExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DotEnum entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IsExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AsExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClosureCaptureItem entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClosureCaptureItemList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(WildcardMarker entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClosureParamList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClosureSignature entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClosureExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(UnresolvedPatternExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionCallExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SubscriptExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OptionalChainingExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ForcedValueExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PostfixUnaryExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SpecializeExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StringLiteralExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OpenQuoteEnum entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(KeyPathExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(KeyPathBaseExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ObjcKeyPathExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ObjcSelectorExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(KindValue entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EditorPlaceholderExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ObjectLiteralExpr entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundIdentifierEnum entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypealiasDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AssociatedtypeDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionParameterList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionSignature entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ThrowsOrRethrowsKeywordEnum entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IfConfigClause entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundKeywordEnum entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SwitchCaseList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MemberDeclList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IfConfigDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundErrorDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundWarningDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundSourceLocation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundSourceLocationArgs entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DeclModifier entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NameValue entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InheritedTypeList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClassDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(StructDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ProtocolDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExtensionDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SourceFile entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionParameter entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Ellipsis entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ModifierList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(InitializerDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OptionalMarkEnum entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DeinitializerDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SubscriptDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AccessorBlock entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AccessLevelModifier entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AccessPath entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ImportDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ImportKindEnum entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AccessorDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AccessorKindValue entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PatternBinding entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PatternBindingList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VariableDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LetOrVarKeywordEnum entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumCaseElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumCaseElementList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumCaseDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OperatorDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IdentifierList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedenceGroupDecl entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedenceGroupAttributeList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedenceGroupRelation entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedenceGroupAssignment entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedenceGroupAssociativity entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(HigherThanOrLowerThanValue entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PrecedenceGroupNameList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FlagEnum entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ValueValue entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CustomAttribute entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Attribute entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AvailabilitySpecList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SpecializeAttributeSpecList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ObjCSelector entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ImplementsAttributeArguments entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NamedAttributeStringArgument entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AttributeList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(LabeledSpecializeEntry entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DeclName entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ContinueStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(WhileStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DeferStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SwitchCase entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(RepeatWhileStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GuardStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ForInStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Case entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SwitchStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CatchClauseList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DoStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ReturnStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(YieldStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(YieldList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FallthroughStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(BreakStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AvailabilityCondition entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MatchingPatternCondition entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OptionalBindingCondition entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ConditionElementList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ThrowStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IfStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SwitchDefaultLabel entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SwitchCaseLabel entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CaseItem entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CatchClause entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PoundAssertStmt entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GenericRequirementList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SameTypeRequirement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ConformanceRequirement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GenericParameterList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GenericParameter entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SimpleTypeIdentifier entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(NameEnum entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MemberTypeIdentifier entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(PeriodEnum entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ClassRestrictionType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ArrayType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(DictionaryType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(MetatypeType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TypeOrProtocolValue entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OptionalType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SomeType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ImplicitlyUnwrappedOptionalType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CompositionTypeElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Ampersand entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CompositionType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TupleTypeElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(Inout entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TupleTypeElementList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TupleType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(FunctionType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AttributedType entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SpecifierValue entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(GenericArgumentList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(EnumCasePattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IsTypePattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(OptionalPattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(IdentifierPattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(SelfMarker entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AsTypePattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(WildcardPattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TuplePatternElement entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ExpressionPattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(TuplePatternElementList entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(ValueBindingPattern entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AvailabilityVersionRestriction entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(AvailabilityLabeledArgument entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(VersionTuple entity) {
        wGetStrategy().visit(entity);
    }

    public void visit(CaptureSpecifierEnum entity) {
        wGetStrategy().visit(entity);
    }
}
