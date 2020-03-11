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

import org.whole.lang.visitors.AbstractVisitor;
import org.whole.lang.swift.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SwiftIdentityVisitor extends AbstractVisitor implements ISwiftVisitor {

    public void visit(IEntity entity) {
        ((ISwiftEntity) entity).accept(this);
    }

    public void visit(BooleanLiteral entity) {
    }

    public void visit(IntegerLiteral entity) {
    }

    public void visit(FloatingLiteral entity) {
    }

    public void visit(StringLiteral entity) {
    }

    public void visit(Identifier entity) {
    }

    public void visit(BinaryOperator entity) {
    }

    public void visit(PostfixOperator entity) {
    }

    public void visit(PrefixOperator entity) {
    }

    public void visit(DollarIdentifier entity) {
    }

    public void visit(RawStringDelimiter entity) {
    }

    public void visit(CodeBlockItemList entity) {
    }

    public void visit(InOutExpr entity) {
    }

    public void visit(PoundColumnExpr entity) {
    }

    public void visit(FunctionCallArgumentList entity) {
    }

    public void visit(StringLiteralSegments entity) {
    }

    public void visit(ExpressionSegment entity) {
    }

    public void visit(TryExpr entity) {
    }

    public void visit(QuestionOrExclamationMarkEnum entity) {
    }

    public void visit(DeclNameArgumentList entity) {
    }

    public void visit(IdentifierExpr entity) {
    }

    public void visit(IdentifierEnum entity) {
    }

    public void visit(SuperRefExpr entity) {
    }

    public void visit(NilLiteralExpr entity) {
    }

    public void visit(DiscardAssignmentExpr entity) {
    }

    public void visit(AssignmentExpr entity) {
    }

    public void visit(SequenceExpr entity) {
    }

    public void visit(PoundLineExpr entity) {
    }

    public void visit(PoundFileExpr entity) {
    }

    public void visit(PoundFunctionExpr entity) {
    }

    public void visit(PoundDsohandleExpr entity) {
    }

    public void visit(SymbolicReferenceExpr entity) {
    }

    public void visit(PrefixOperatorExpr entity) {
    }

    public void visit(BinaryOperatorExpr entity) {
    }

    public void visit(ArrowExpr entity) {
    }

    public void visit(Throws entity) {
    }

    public void visit(TupleExpr entity) {
    }

    public void visit(ArrayExpr entity) {
    }

    public void visit(DictionaryExpr entity) {
    }

    public void visit(FunctionCallArgument entity) {
    }

    public void visit(TupleElement entity) {
    }

    public void visit(DictionaryElement entity) {
    }

    public void visit(TernaryExpr entity) {
    }

    public void visit(MemberAccessExpr entity) {
    }

    public void visit(DotEnum entity) {
    }

    public void visit(IsExpr entity) {
    }

    public void visit(AsExpr entity) {
    }

    public void visit(TypeExpr entity) {
    }

    public void visit(ClosureCaptureItem entity) {
    }

    public void visit(ClosureCaptureItemList entity) {
    }

    public void visit(WildcardMarker entity) {
    }

    public void visit(ClosureParamList entity) {
    }

    public void visit(ClosureSignature entity) {
    }

    public void visit(ClosureExpr entity) {
    }

    public void visit(UnresolvedPatternExpr entity) {
    }

    public void visit(FunctionCallExpr entity) {
    }

    public void visit(SubscriptExpr entity) {
    }

    public void visit(OptionalChainingExpr entity) {
    }

    public void visit(ForcedValueExpr entity) {
    }

    public void visit(PostfixUnaryExpr entity) {
    }

    public void visit(SpecializeExpr entity) {
    }

    public void visit(StringLiteralExpr entity) {
    }

    public void visit(OpenQuoteEnum entity) {
    }

    public void visit(KeyPathExpr entity) {
    }

    public void visit(KeyPathBaseExpr entity) {
    }

    public void visit(ObjcKeyPathExpr entity) {
    }

    public void visit(ObjcSelectorExpr entity) {
    }

    public void visit(KindValue entity) {
    }

    public void visit(EditorPlaceholderExpr entity) {
    }

    public void visit(ObjectLiteralExpr entity) {
    }

    public void visit(PoundIdentifierEnum entity) {
    }

    public void visit(TypealiasDecl entity) {
    }

    public void visit(AssociatedtypeDecl entity) {
    }

    public void visit(FunctionParameterList entity) {
    }

    public void visit(FunctionSignature entity) {
    }

    public void visit(ThrowsOrRethrowsKeywordEnum entity) {
    }

    public void visit(IfConfigClause entity) {
    }

    public void visit(PoundKeywordEnum entity) {
    }

    public void visit(SwitchCaseList entity) {
    }

    public void visit(MemberDeclList entity) {
    }

    public void visit(IfConfigDecl entity) {
    }

    public void visit(PoundErrorDecl entity) {
    }

    public void visit(PoundWarningDecl entity) {
    }

    public void visit(PoundSourceLocation entity) {
    }

    public void visit(PoundSourceLocationArgs entity) {
    }

    public void visit(DeclModifier entity) {
    }

    public void visit(NameValue entity) {
    }

    public void visit(InheritedTypeList entity) {
    }

    public void visit(ClassDecl entity) {
    }

    public void visit(StructDecl entity) {
    }

    public void visit(ProtocolDecl entity) {
    }

    public void visit(ExtensionDecl entity) {
    }

    public void visit(SourceFile entity) {
    }

    public void visit(FunctionParameter entity) {
    }

    public void visit(Ellipsis entity) {
    }

    public void visit(ModifierList entity) {
    }

    public void visit(FunctionDecl entity) {
    }

    public void visit(InitializerDecl entity) {
    }

    public void visit(OptionalMarkEnum entity) {
    }

    public void visit(DeinitializerDecl entity) {
    }

    public void visit(SubscriptDecl entity) {
    }

    public void visit(AccessorBlock entity) {
    }

    public void visit(AccessLevelModifier entity) {
    }

    public void visit(AccessPath entity) {
    }

    public void visit(ImportDecl entity) {
    }

    public void visit(ImportKindEnum entity) {
    }

    public void visit(AccessorDecl entity) {
    }

    public void visit(AccessorKindValue entity) {
    }

    public void visit(PatternBinding entity) {
    }

    public void visit(PatternBindingList entity) {
    }

    public void visit(VariableDecl entity) {
    }

    public void visit(LetOrVarKeywordEnum entity) {
    }

    public void visit(EnumCaseElement entity) {
    }

    public void visit(EnumCaseElementList entity) {
    }

    public void visit(EnumCaseDecl entity) {
    }

    public void visit(EnumDecl entity) {
    }

    public void visit(OperatorDecl entity) {
    }

    public void visit(IdentifierList entity) {
    }

    public void visit(PrecedenceGroupDecl entity) {
    }

    public void visit(PrecedenceGroupAttributeList entity) {
    }

    public void visit(PrecedenceGroupRelation entity) {
    }

    public void visit(PrecedenceGroupAssignment entity) {
    }

    public void visit(PrecedenceGroupAssociativity entity) {
    }

    public void visit(HigherThanOrLowerThanValue entity) {
    }

    public void visit(PrecedenceGroupNameList entity) {
    }

    public void visit(FlagEnum entity) {
    }

    public void visit(ValueValue entity) {
    }

    public void visit(CustomAttribute entity) {
    }

    public void visit(Attribute entity) {
    }

    public void visit(AvailabilitySpecList entity) {
    }

    public void visit(SpecializeAttributeSpecList entity) {
    }

    public void visit(ObjCSelector entity) {
    }

    public void visit(ImplementsAttributeArguments entity) {
    }

    public void visit(NamedAttributeStringArgument entity) {
    }

    public void visit(AttributeList entity) {
    }

    public void visit(LabeledSpecializeEntry entity) {
    }

    public void visit(DeclName entity) {
    }

    public void visit(ContinueStmt entity) {
    }

    public void visit(WhileStmt entity) {
    }

    public void visit(DeferStmt entity) {
    }

    public void visit(SwitchCase entity) {
    }

    public void visit(RepeatWhileStmt entity) {
    }

    public void visit(GuardStmt entity) {
    }

    public void visit(ForInStmt entity) {
    }

    public void visit(Case entity) {
    }

    public void visit(SwitchStmt entity) {
    }

    public void visit(CatchClauseList entity) {
    }

    public void visit(DoStmt entity) {
    }

    public void visit(ReturnStmt entity) {
    }

    public void visit(YieldStmt entity) {
    }

    public void visit(YieldList entity) {
    }

    public void visit(FallthroughStmt entity) {
    }

    public void visit(BreakStmt entity) {
    }

    public void visit(AvailabilityCondition entity) {
    }

    public void visit(MatchingPatternCondition entity) {
    }

    public void visit(OptionalBindingCondition entity) {
    }

    public void visit(ConditionElementList entity) {
    }

    public void visit(ThrowStmt entity) {
    }

    public void visit(IfStmt entity) {
    }

    public void visit(SwitchDefaultLabel entity) {
    }

    public void visit(SwitchCaseLabel entity) {
    }

    public void visit(CaseItem entity) {
    }

    public void visit(CatchClause entity) {
    }

    public void visit(PoundAssertStmt entity) {
    }

    public void visit(GenericRequirementList entity) {
    }

    public void visit(SameTypeRequirement entity) {
    }

    public void visit(ConformanceRequirement entity) {
    }

    public void visit(GenericParameterList entity) {
    }

    public void visit(GenericParameter entity) {
    }

    public void visit(SimpleTypeIdentifier entity) {
    }

    public void visit(NameEnum entity) {
    }

    public void visit(MemberTypeIdentifier entity) {
    }

    public void visit(PeriodEnum entity) {
    }

    public void visit(ClassRestrictionType entity) {
    }

    public void visit(ArrayType entity) {
    }

    public void visit(DictionaryType entity) {
    }

    public void visit(MetatypeType entity) {
    }

    public void visit(TypeOrProtocolValue entity) {
    }

    public void visit(OptionalType entity) {
    }

    public void visit(SomeType entity) {
    }

    public void visit(ImplicitlyUnwrappedOptionalType entity) {
    }

    public void visit(CompositionTypeElement entity) {
    }

    public void visit(Ampersand entity) {
    }

    public void visit(CompositionType entity) {
    }

    public void visit(TupleTypeElement entity) {
    }

    public void visit(Inout entity) {
    }

    public void visit(TupleTypeElementList entity) {
    }

    public void visit(TupleType entity) {
    }

    public void visit(FunctionType entity) {
    }

    public void visit(AttributedType entity) {
    }

    public void visit(SpecifierValue entity) {
    }

    public void visit(GenericArgumentList entity) {
    }

    public void visit(EnumCasePattern entity) {
    }

    public void visit(IsTypePattern entity) {
    }

    public void visit(OptionalPattern entity) {
    }

    public void visit(IdentifierPattern entity) {
    }

    public void visit(SelfMarker entity) {
    }

    public void visit(AsTypePattern entity) {
    }

    public void visit(WildcardPattern entity) {
    }

    public void visit(TuplePatternElement entity) {
    }

    public void visit(ExpressionPattern entity) {
    }

    public void visit(TuplePatternElementList entity) {
    }

    public void visit(ValueBindingPattern entity) {
    }

    public void visit(AvailabilityVersionRestriction entity) {
    }

    public void visit(AvailabilityLabeledArgument entity) {
    }

    public void visit(VersionTuple entity) {
    }

    public void visit(CaptureSpecifierEnum entity) {
    }
}
