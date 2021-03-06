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

import org.whole.lang.swift.model.*;

/**
 *  @generator Whole
 */
public class SwiftForwardStagedVisitor extends SwiftIdentityVisitor {

    public void visit(BooleanLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(IntegerLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(FloatingLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(StringLiteral entity) {
        stagedVisit(entity);
    }

    public void visit(Identifier entity) {
        stagedVisit(entity);
    }

    public void visit(BinaryOperator entity) {
        stagedVisit(entity);
    }

    public void visit(PostfixOperator entity) {
        stagedVisit(entity);
    }

    public void visit(PrefixOperator entity) {
        stagedVisit(entity);
    }

    public void visit(DollarIdentifier entity) {
        stagedVisit(entity);
    }

    public void visit(RawStringDelimiter entity) {
        stagedVisit(entity);
    }

    public void visit(CodeBlockItemList entity) {
        stagedVisit(entity);
    }

    public void visit(InOutExpr entity) {
        stagedVisit(entity);
    }

    public void visit(PoundColumnExpr entity) {
        stagedVisit(entity);
    }

    public void visit(FunctionCallArgumentList entity) {
        stagedVisit(entity);
    }

    public void visit(StringLiteralSegments entity) {
        stagedVisit(entity);
    }

    public void visit(ExpressionSegment entity) {
        stagedVisit(entity);
    }

    public void visit(TryExpr entity) {
        stagedVisit(entity);
    }

    public void visit(QuestionOrExclamationMarkEnum entity) {
        stagedVisit(entity);
    }

    public void visit(DeclNameArgumentList entity) {
        stagedVisit(entity);
    }

    public void visit(IdentifierExpr entity) {
        stagedVisit(entity);
    }

    public void visit(IdentifierEnum entity) {
        stagedVisit(entity);
    }

    public void visit(SuperRefExpr entity) {
        stagedVisit(entity);
    }

    public void visit(NilLiteralExpr entity) {
        stagedVisit(entity);
    }

    public void visit(DiscardAssignmentExpr entity) {
        stagedVisit(entity);
    }

    public void visit(AssignmentExpr entity) {
        stagedVisit(entity);
    }

    public void visit(SequenceExpr entity) {
        stagedVisit(entity);
    }

    public void visit(PoundLineExpr entity) {
        stagedVisit(entity);
    }

    public void visit(PoundFileExpr entity) {
        stagedVisit(entity);
    }

    public void visit(PoundFunctionExpr entity) {
        stagedVisit(entity);
    }

    public void visit(PoundDsohandleExpr entity) {
        stagedVisit(entity);
    }

    public void visit(SymbolicReferenceExpr entity) {
        stagedVisit(entity);
    }

    public void visit(PrefixOperatorExpr entity) {
        stagedVisit(entity);
    }

    public void visit(BinaryOperatorExpr entity) {
        stagedVisit(entity);
    }

    public void visit(ArrowExpr entity) {
        stagedVisit(entity);
    }

    public void visit(Throws entity) {
        stagedVisit(entity);
    }

    public void visit(TupleExpr entity) {
        stagedVisit(entity);
    }

    public void visit(ArrayExpr entity) {
        stagedVisit(entity);
    }

    public void visit(DictionaryExpr entity) {
        stagedVisit(entity);
    }

    public void visit(FunctionCallArgument entity) {
        stagedVisit(entity);
    }

    public void visit(TupleElement entity) {
        stagedVisit(entity);
    }

    public void visit(DictionaryElement entity) {
        stagedVisit(entity);
    }

    public void visit(TernaryExpr entity) {
        stagedVisit(entity);
    }

    public void visit(MemberAccessExpr entity) {
        stagedVisit(entity);
    }

    public void visit(DotEnum entity) {
        stagedVisit(entity);
    }

    public void visit(IsExpr entity) {
        stagedVisit(entity);
    }

    public void visit(AsExpr entity) {
        stagedVisit(entity);
    }

    public void visit(TypeExpr entity) {
        stagedVisit(entity);
    }

    public void visit(ClosureCaptureItem entity) {
        stagedVisit(entity);
    }

    public void visit(ClosureCaptureItemList entity) {
        stagedVisit(entity);
    }

    public void visit(WildcardMarker entity) {
        stagedVisit(entity);
    }

    public void visit(ClosureParamList entity) {
        stagedVisit(entity);
    }

    public void visit(ClosureSignature entity) {
        stagedVisit(entity);
    }

    public void visit(ClosureExpr entity) {
        stagedVisit(entity);
    }

    public void visit(UnresolvedPatternExpr entity) {
        stagedVisit(entity);
    }

    public void visit(FunctionCallExpr entity) {
        stagedVisit(entity);
    }

    public void visit(SubscriptExpr entity) {
        stagedVisit(entity);
    }

    public void visit(OptionalChainingExpr entity) {
        stagedVisit(entity);
    }

    public void visit(ForcedValueExpr entity) {
        stagedVisit(entity);
    }

    public void visit(PostfixUnaryExpr entity) {
        stagedVisit(entity);
    }

    public void visit(SpecializeExpr entity) {
        stagedVisit(entity);
    }

    public void visit(StringLiteralExpr entity) {
        stagedVisit(entity);
    }

    public void visit(OpenQuoteEnum entity) {
        stagedVisit(entity);
    }

    public void visit(KeyPathExpr entity) {
        stagedVisit(entity);
    }

    public void visit(KeyPathBaseExpr entity) {
        stagedVisit(entity);
    }

    public void visit(ObjcKeyPathExpr entity) {
        stagedVisit(entity);
    }

    public void visit(ObjcSelectorExpr entity) {
        stagedVisit(entity);
    }

    public void visit(KindValue entity) {
        stagedVisit(entity);
    }

    public void visit(EditorPlaceholderExpr entity) {
        stagedVisit(entity);
    }

    public void visit(ObjectLiteralExpr entity) {
        stagedVisit(entity);
    }

    public void visit(PoundIdentifierEnum entity) {
        stagedVisit(entity);
    }

    public void visit(TypealiasDecl entity) {
        stagedVisit(entity);
    }

    public void visit(AssociatedtypeDecl entity) {
        stagedVisit(entity);
    }

    public void visit(FunctionParameterList entity) {
        stagedVisit(entity);
    }

    public void visit(FunctionSignature entity) {
        stagedVisit(entity);
    }

    public void visit(ThrowsOrRethrowsKeywordEnum entity) {
        stagedVisit(entity);
    }

    public void visit(IfConfigClause entity) {
        stagedVisit(entity);
    }

    public void visit(PoundKeywordEnum entity) {
        stagedVisit(entity);
    }

    public void visit(SwitchCaseList entity) {
        stagedVisit(entity);
    }

    public void visit(MemberDeclList entity) {
        stagedVisit(entity);
    }

    public void visit(IfConfigDecl entity) {
        stagedVisit(entity);
    }

    public void visit(PoundErrorDecl entity) {
        stagedVisit(entity);
    }

    public void visit(PoundWarningDecl entity) {
        stagedVisit(entity);
    }

    public void visit(PoundSourceLocation entity) {
        stagedVisit(entity);
    }

    public void visit(PoundSourceLocationArgs entity) {
        stagedVisit(entity);
    }

    public void visit(DeclModifier entity) {
        stagedVisit(entity);
    }

    public void visit(NameValue entity) {
        stagedVisit(entity);
    }

    public void visit(InheritedTypeList entity) {
        stagedVisit(entity);
    }

    public void visit(ClassDecl entity) {
        stagedVisit(entity);
    }

    public void visit(StructDecl entity) {
        stagedVisit(entity);
    }

    public void visit(ProtocolDecl entity) {
        stagedVisit(entity);
    }

    public void visit(ExtensionDecl entity) {
        stagedVisit(entity);
    }

    public void visit(SourceFile entity) {
        stagedVisit(entity);
    }

    public void visit(FunctionParameter entity) {
        stagedVisit(entity);
    }

    public void visit(Ellipsis entity) {
        stagedVisit(entity);
    }

    public void visit(ModifierList entity) {
        stagedVisit(entity);
    }

    public void visit(FunctionDecl entity) {
        stagedVisit(entity);
    }

    public void visit(InitializerDecl entity) {
        stagedVisit(entity);
    }

    public void visit(OptionalMarkEnum entity) {
        stagedVisit(entity);
    }

    public void visit(DeinitializerDecl entity) {
        stagedVisit(entity);
    }

    public void visit(SubscriptDecl entity) {
        stagedVisit(entity);
    }

    public void visit(AccessorBlock entity) {
        stagedVisit(entity);
    }

    public void visit(AccessLevelModifier entity) {
        stagedVisit(entity);
    }

    public void visit(AccessPath entity) {
        stagedVisit(entity);
    }

    public void visit(ImportDecl entity) {
        stagedVisit(entity);
    }

    public void visit(ImportKindEnum entity) {
        stagedVisit(entity);
    }

    public void visit(AccessorDecl entity) {
        stagedVisit(entity);
    }

    public void visit(AccessorKindValue entity) {
        stagedVisit(entity);
    }

    public void visit(PatternBinding entity) {
        stagedVisit(entity);
    }

    public void visit(PatternBindingList entity) {
        stagedVisit(entity);
    }

    public void visit(VariableDecl entity) {
        stagedVisit(entity);
    }

    public void visit(LetOrVarKeywordEnum entity) {
        stagedVisit(entity);
    }

    public void visit(EnumCaseElement entity) {
        stagedVisit(entity);
    }

    public void visit(EnumCaseElementList entity) {
        stagedVisit(entity);
    }

    public void visit(EnumCaseDecl entity) {
        stagedVisit(entity);
    }

    public void visit(EnumDecl entity) {
        stagedVisit(entity);
    }

    public void visit(OperatorDecl entity) {
        stagedVisit(entity);
    }

    public void visit(IdentifierList entity) {
        stagedVisit(entity);
    }

    public void visit(PrecedenceGroupDecl entity) {
        stagedVisit(entity);
    }

    public void visit(PrecedenceGroupAttributeList entity) {
        stagedVisit(entity);
    }

    public void visit(PrecedenceGroupRelation entity) {
        stagedVisit(entity);
    }

    public void visit(PrecedenceGroupAssignment entity) {
        stagedVisit(entity);
    }

    public void visit(PrecedenceGroupAssociativity entity) {
        stagedVisit(entity);
    }

    public void visit(HigherThanOrLowerThanValue entity) {
        stagedVisit(entity);
    }

    public void visit(PrecedenceGroupNameList entity) {
        stagedVisit(entity);
    }

    public void visit(FlagEnum entity) {
        stagedVisit(entity);
    }

    public void visit(ValueValue entity) {
        stagedVisit(entity);
    }

    public void visit(CustomAttribute entity) {
        stagedVisit(entity);
    }

    public void visit(Attribute entity) {
        stagedVisit(entity);
    }

    public void visit(AvailabilitySpecList entity) {
        stagedVisit(entity);
    }

    public void visit(SpecializeAttributeSpecList entity) {
        stagedVisit(entity);
    }

    public void visit(ObjCSelector entity) {
        stagedVisit(entity);
    }

    public void visit(ImplementsAttributeArguments entity) {
        stagedVisit(entity);
    }

    public void visit(NamedAttributeStringArgument entity) {
        stagedVisit(entity);
    }

    public void visit(AttributeList entity) {
        stagedVisit(entity);
    }

    public void visit(LabeledSpecializeEntry entity) {
        stagedVisit(entity);
    }

    public void visit(DeclName entity) {
        stagedVisit(entity);
    }

    public void visit(ContinueStmt entity) {
        stagedVisit(entity);
    }

    public void visit(WhileStmt entity) {
        stagedVisit(entity);
    }

    public void visit(DeferStmt entity) {
        stagedVisit(entity);
    }

    public void visit(SwitchCase entity) {
        stagedVisit(entity);
    }

    public void visit(RepeatWhileStmt entity) {
        stagedVisit(entity);
    }

    public void visit(GuardStmt entity) {
        stagedVisit(entity);
    }

    public void visit(ForInStmt entity) {
        stagedVisit(entity);
    }

    public void visit(Case entity) {
        stagedVisit(entity);
    }

    public void visit(SwitchStmt entity) {
        stagedVisit(entity);
    }

    public void visit(CatchClauseList entity) {
        stagedVisit(entity);
    }

    public void visit(DoStmt entity) {
        stagedVisit(entity);
    }

    public void visit(ReturnStmt entity) {
        stagedVisit(entity);
    }

    public void visit(YieldStmt entity) {
        stagedVisit(entity);
    }

    public void visit(YieldList entity) {
        stagedVisit(entity);
    }

    public void visit(FallthroughStmt entity) {
        stagedVisit(entity);
    }

    public void visit(BreakStmt entity) {
        stagedVisit(entity);
    }

    public void visit(AvailabilityCondition entity) {
        stagedVisit(entity);
    }

    public void visit(MatchingPatternCondition entity) {
        stagedVisit(entity);
    }

    public void visit(OptionalBindingCondition entity) {
        stagedVisit(entity);
    }

    public void visit(ConditionElementList entity) {
        stagedVisit(entity);
    }

    public void visit(ThrowStmt entity) {
        stagedVisit(entity);
    }

    public void visit(IfStmt entity) {
        stagedVisit(entity);
    }

    public void visit(SwitchDefaultLabel entity) {
        stagedVisit(entity);
    }

    public void visit(SwitchCaseLabel entity) {
        stagedVisit(entity);
    }

    public void visit(CaseItem entity) {
        stagedVisit(entity);
    }

    public void visit(CatchClause entity) {
        stagedVisit(entity);
    }

    public void visit(PoundAssertStmt entity) {
        stagedVisit(entity);
    }

    public void visit(GenericRequirementList entity) {
        stagedVisit(entity);
    }

    public void visit(SameTypeRequirement entity) {
        stagedVisit(entity);
    }

    public void visit(ConformanceRequirement entity) {
        stagedVisit(entity);
    }

    public void visit(GenericParameterList entity) {
        stagedVisit(entity);
    }

    public void visit(GenericParameter entity) {
        stagedVisit(entity);
    }

    public void visit(SimpleTypeIdentifier entity) {
        stagedVisit(entity);
    }

    public void visit(NameEnum entity) {
        stagedVisit(entity);
    }

    public void visit(MemberTypeIdentifier entity) {
        stagedVisit(entity);
    }

    public void visit(PeriodEnum entity) {
        stagedVisit(entity);
    }

    public void visit(ClassRestrictionType entity) {
        stagedVisit(entity);
    }

    public void visit(ArrayType entity) {
        stagedVisit(entity);
    }

    public void visit(DictionaryType entity) {
        stagedVisit(entity);
    }

    public void visit(MetatypeType entity) {
        stagedVisit(entity);
    }

    public void visit(TypeOrProtocolValue entity) {
        stagedVisit(entity);
    }

    public void visit(OptionalType entity) {
        stagedVisit(entity);
    }

    public void visit(SomeType entity) {
        stagedVisit(entity);
    }

    public void visit(ImplicitlyUnwrappedOptionalType entity) {
        stagedVisit(entity);
    }

    public void visit(CompositionTypeElement entity) {
        stagedVisit(entity);
    }

    public void visit(Ampersand entity) {
        stagedVisit(entity);
    }

    public void visit(CompositionType entity) {
        stagedVisit(entity);
    }

    public void visit(TupleTypeElement entity) {
        stagedVisit(entity);
    }

    public void visit(Inout entity) {
        stagedVisit(entity);
    }

    public void visit(TupleTypeElementList entity) {
        stagedVisit(entity);
    }

    public void visit(TupleType entity) {
        stagedVisit(entity);
    }

    public void visit(FunctionType entity) {
        stagedVisit(entity);
    }

    public void visit(AttributedType entity) {
        stagedVisit(entity);
    }

    public void visit(SpecifierValue entity) {
        stagedVisit(entity);
    }

    public void visit(GenericArgumentList entity) {
        stagedVisit(entity);
    }

    public void visit(EnumCasePattern entity) {
        stagedVisit(entity);
    }

    public void visit(IsTypePattern entity) {
        stagedVisit(entity);
    }

    public void visit(OptionalPattern entity) {
        stagedVisit(entity);
    }

    public void visit(IdentifierPattern entity) {
        stagedVisit(entity);
    }

    public void visit(SelfMarker entity) {
        stagedVisit(entity);
    }

    public void visit(AsTypePattern entity) {
        stagedVisit(entity);
    }

    public void visit(WildcardPattern entity) {
        stagedVisit(entity);
    }

    public void visit(TuplePatternElement entity) {
        stagedVisit(entity);
    }

    public void visit(ExpressionPattern entity) {
        stagedVisit(entity);
    }

    public void visit(TuplePatternElementList entity) {
        stagedVisit(entity);
    }

    public void visit(ValueBindingPattern entity) {
        stagedVisit(entity);
    }

    public void visit(AvailabilityVersionRestriction entity) {
        stagedVisit(entity);
    }

    public void visit(AvailabilityLabeledArgument entity) {
        stagedVisit(entity);
    }

    public void visit(VersionTuple entity) {
        stagedVisit(entity);
    }

    public void visit(CaptureSpecifierEnum entity) {
        stagedVisit(entity);
    }
}
