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

import org.whole.lang.visitors.AbstractUnaryVisitor;
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.swift.model.*;
import org.whole.lang.model.IEntity;

/**
 *  @generator Whole
 */
public class SwiftForwardGenericVisitor extends AbstractUnaryVisitor<IVisitor> implements ISwiftVisitor {

    public SwiftForwardGenericVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(IEntity entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(BooleanLiteral entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IntegerLiteral entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FloatingLiteral entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(StringLiteral entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Identifier entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(BinaryOperator entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PostfixOperator entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PrefixOperator entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DollarIdentifier entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(RawStringDelimiter entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(CodeBlockItemList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(InOutExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PoundColumnExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FunctionCallArgumentList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(StringLiteralSegments entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ExpressionSegment entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TryExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(QuestionOrExclamationMarkEnum entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DeclNameArgumentList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IdentifierExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IdentifierEnum entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SuperRefExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(NilLiteralExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DiscardAssignmentExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AssignmentExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SequenceExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PoundLineExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PoundFileExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PoundFunctionExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PoundDsohandleExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SymbolicReferenceExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PrefixOperatorExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(BinaryOperatorExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ArrowExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Throws entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TupleExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ArrayExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DictionaryExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FunctionCallArgument entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TupleElement entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DictionaryElement entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TernaryExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(MemberAccessExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DotEnum entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IsExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AsExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TypeExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ClosureCaptureItem entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ClosureCaptureItemList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(WildcardMarker entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ClosureParamList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ClosureSignature entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ClosureExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(UnresolvedPatternExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FunctionCallExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SubscriptExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(OptionalChainingExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ForcedValueExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PostfixUnaryExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SpecializeExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(StringLiteralExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(OpenQuoteEnum entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(KeyPathExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(KeyPathBaseExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ObjcKeyPathExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ObjcSelectorExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(KindValue entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EditorPlaceholderExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ObjectLiteralExpr entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PoundIdentifierEnum entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TypealiasDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AssociatedtypeDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FunctionParameterList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FunctionSignature entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ThrowsOrRethrowsKeywordEnum entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IfConfigClause entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PoundKeywordEnum entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SwitchCaseList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(MemberDeclList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IfConfigDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PoundErrorDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PoundWarningDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PoundSourceLocation entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PoundSourceLocationArgs entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DeclModifier entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(NameValue entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(InheritedTypeList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ClassDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(StructDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ProtocolDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ExtensionDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SourceFile entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FunctionParameter entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Ellipsis entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ModifierList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FunctionDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(InitializerDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(OptionalMarkEnum entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DeinitializerDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SubscriptDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AccessorBlock entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AccessLevelModifier entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AccessPath entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ImportDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ImportKindEnum entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AccessorDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AccessorKindValue entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PatternBinding entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PatternBindingList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(VariableDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(LetOrVarKeywordEnum entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EnumCaseElement entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EnumCaseElementList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EnumCaseDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EnumDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(OperatorDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IdentifierList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PrecedenceGroupDecl entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PrecedenceGroupAttributeList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PrecedenceGroupRelation entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PrecedenceGroupAssignment entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PrecedenceGroupAssociativity entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(HigherThanOrLowerThanValue entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PrecedenceGroupNameList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FlagEnum entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ValueValue entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(CustomAttribute entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Attribute entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AvailabilitySpecList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SpecializeAttributeSpecList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ObjCSelector entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ImplementsAttributeArguments entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(NamedAttributeStringArgument entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AttributeList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(LabeledSpecializeEntry entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DeclName entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ContinueStmt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(WhileStmt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DeferStmt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SwitchCase entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(RepeatWhileStmt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(GuardStmt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ForInStmt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Case entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SwitchStmt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(CatchClauseList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DoStmt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ReturnStmt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(YieldStmt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(YieldList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FallthroughStmt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(BreakStmt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AvailabilityCondition entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(MatchingPatternCondition entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(OptionalBindingCondition entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ConditionElementList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ThrowStmt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IfStmt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SwitchDefaultLabel entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SwitchCaseLabel entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(CaseItem entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(CatchClause entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PoundAssertStmt entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(GenericRequirementList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SameTypeRequirement entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ConformanceRequirement entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(GenericParameterList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(GenericParameter entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SimpleTypeIdentifier entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(NameEnum entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(MemberTypeIdentifier entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(PeriodEnum entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ClassRestrictionType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ArrayType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(DictionaryType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(MetatypeType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TypeOrProtocolValue entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(OptionalType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SomeType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ImplicitlyUnwrappedOptionalType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(CompositionTypeElement entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Ampersand entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(CompositionType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TupleTypeElement entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(Inout entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TupleTypeElementList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TupleType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(FunctionType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AttributedType entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SpecifierValue entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(GenericArgumentList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(EnumCasePattern entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IsTypePattern entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(OptionalPattern entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(IdentifierPattern entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(SelfMarker entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AsTypePattern entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(WildcardPattern entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TuplePatternElement entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ExpressionPattern entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(TuplePatternElementList entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(ValueBindingPattern entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AvailabilityVersionRestriction entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(AvailabilityLabeledArgument entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(VersionTuple entity) {
        wGetVisitor1().visit(entity);
    }

    public void visit(CaptureSpecifierEnum entity) {
        wGetVisitor1().visit(entity);
    }
}
