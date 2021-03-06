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
package org.whole.lang.swiftsyntax.visitors;

import org.whole.lang.swiftsyntax.model.*;
import org.whole.lang.model.adapters.IEntityAdapter;
import org.whole.lang.visitors.VisitException;

/**
 *  @generator Whole
 */
public class SwiftSyntaxFailureVisitor extends SwiftSyntaxIdentityVisitor {

    public boolean visitAdapter(IEntityAdapter entity) {
        throw new VisitException();
    }

    public void visit(Token entity) {
        throw new VisitException();
    }

    public void visit(UnknownDecl entity) {
        throw new VisitException();
    }

    public void visit(UnknownExpr entity) {
        throw new VisitException();
    }

    public void visit(UnknownPattern entity) {
        throw new VisitException();
    }

    public void visit(UnknownStmt entity) {
        throw new VisitException();
    }

    public void visit(UnknownType entity) {
        throw new VisitException();
    }

    public void visit(CodeBlockItem entity) {
        throw new VisitException();
    }

    public void visit(CodeBlockItemList entity) {
        throw new VisitException();
    }

    public void visit(CodeBlock entity) {
        throw new VisitException();
    }

    public void visit(InOutExpr entity) {
        throw new VisitException();
    }

    public void visit(PoundColumnExpr entity) {
        throw new VisitException();
    }

    public void visit(FunctionCallArgumentList entity) {
        throw new VisitException();
    }

    public void visit(TupleElementList entity) {
        throw new VisitException();
    }

    public void visit(ArrayElementList entity) {
        throw new VisitException();
    }

    public void visit(DictionaryElementList entity) {
        throw new VisitException();
    }

    public void visit(StringLiteralSegments entity) {
        throw new VisitException();
    }

    public void visit(TryExpr entity) {
        throw new VisitException();
    }

    public void visit(DeclNameArgument entity) {
        throw new VisitException();
    }

    public void visit(DeclNameArgumentList entity) {
        throw new VisitException();
    }

    public void visit(DeclNameArguments entity) {
        throw new VisitException();
    }

    public void visit(IdentifierExpr entity) {
        throw new VisitException();
    }

    public void visit(SuperRefExpr entity) {
        throw new VisitException();
    }

    public void visit(NilLiteralExpr entity) {
        throw new VisitException();
    }

    public void visit(DiscardAssignmentExpr entity) {
        throw new VisitException();
    }

    public void visit(AssignmentExpr entity) {
        throw new VisitException();
    }

    public void visit(SequenceExpr entity) {
        throw new VisitException();
    }

    public void visit(ExprList entity) {
        throw new VisitException();
    }

    public void visit(PoundLineExpr entity) {
        throw new VisitException();
    }

    public void visit(PoundFileExpr entity) {
        throw new VisitException();
    }

    public void visit(PoundFunctionExpr entity) {
        throw new VisitException();
    }

    public void visit(PoundDsohandleExpr entity) {
        throw new VisitException();
    }

    public void visit(SymbolicReferenceExpr entity) {
        throw new VisitException();
    }

    public void visit(PrefixOperatorExpr entity) {
        throw new VisitException();
    }

    public void visit(BinaryOperatorExpr entity) {
        throw new VisitException();
    }

    public void visit(ArrowExpr entity) {
        throw new VisitException();
    }

    public void visit(FloatLiteralExpr entity) {
        throw new VisitException();
    }

    public void visit(TupleExpr entity) {
        throw new VisitException();
    }

    public void visit(ArrayExpr entity) {
        throw new VisitException();
    }

    public void visit(DictionaryExpr entity) {
        throw new VisitException();
    }

    public void visit(FunctionCallArgument entity) {
        throw new VisitException();
    }

    public void visit(TupleElement entity) {
        throw new VisitException();
    }

    public void visit(ArrayElement entity) {
        throw new VisitException();
    }

    public void visit(DictionaryElement entity) {
        throw new VisitException();
    }

    public void visit(IntegerLiteralExpr entity) {
        throw new VisitException();
    }

    public void visit(BooleanLiteralExpr entity) {
        throw new VisitException();
    }

    public void visit(TernaryExpr entity) {
        throw new VisitException();
    }

    public void visit(MemberAccessExpr entity) {
        throw new VisitException();
    }

    public void visit(IsExpr entity) {
        throw new VisitException();
    }

    public void visit(AsExpr entity) {
        throw new VisitException();
    }

    public void visit(TypeExpr entity) {
        throw new VisitException();
    }

    public void visit(ClosureCaptureItem entity) {
        throw new VisitException();
    }

    public void visit(ClosureCaptureItemList entity) {
        throw new VisitException();
    }

    public void visit(ClosureCaptureSignature entity) {
        throw new VisitException();
    }

    public void visit(ClosureParam entity) {
        throw new VisitException();
    }

    public void visit(ClosureParamList entity) {
        throw new VisitException();
    }

    public void visit(ClosureSignature entity) {
        throw new VisitException();
    }

    public void visit(ClosureExpr entity) {
        throw new VisitException();
    }

    public void visit(UnresolvedPatternExpr entity) {
        throw new VisitException();
    }

    public void visit(FunctionCallExpr entity) {
        throw new VisitException();
    }

    public void visit(SubscriptExpr entity) {
        throw new VisitException();
    }

    public void visit(OptionalChainingExpr entity) {
        throw new VisitException();
    }

    public void visit(ForcedValueExpr entity) {
        throw new VisitException();
    }

    public void visit(PostfixUnaryExpr entity) {
        throw new VisitException();
    }

    public void visit(SpecializeExpr entity) {
        throw new VisitException();
    }

    public void visit(StringSegment entity) {
        throw new VisitException();
    }

    public void visit(ExpressionSegment entity) {
        throw new VisitException();
    }

    public void visit(StringLiteralExpr entity) {
        throw new VisitException();
    }

    public void visit(KeyPathExpr entity) {
        throw new VisitException();
    }

    public void visit(KeyPathBaseExpr entity) {
        throw new VisitException();
    }

    public void visit(ObjcNamePiece entity) {
        throw new VisitException();
    }

    public void visit(ObjcName entity) {
        throw new VisitException();
    }

    public void visit(ObjcKeyPathExpr entity) {
        throw new VisitException();
    }

    public void visit(ObjcSelectorExpr entity) {
        throw new VisitException();
    }

    public void visit(EditorPlaceholderExpr entity) {
        throw new VisitException();
    }

    public void visit(ObjectLiteralExpr entity) {
        throw new VisitException();
    }

    public void visit(TypeInitializerClause entity) {
        throw new VisitException();
    }

    public void visit(TypealiasDecl entity) {
        throw new VisitException();
    }

    public void visit(AssociatedtypeDecl entity) {
        throw new VisitException();
    }

    public void visit(FunctionParameterList entity) {
        throw new VisitException();
    }

    public void visit(ParameterClause entity) {
        throw new VisitException();
    }

    public void visit(ReturnClause entity) {
        throw new VisitException();
    }

    public void visit(FunctionSignature entity) {
        throw new VisitException();
    }

    public void visit(IfConfigClause entity) {
        throw new VisitException();
    }

    public void visit(IfConfigClauseList entity) {
        throw new VisitException();
    }

    public void visit(IfConfigDecl entity) {
        throw new VisitException();
    }

    public void visit(PoundErrorDecl entity) {
        throw new VisitException();
    }

    public void visit(PoundWarningDecl entity) {
        throw new VisitException();
    }

    public void visit(PoundSourceLocation entity) {
        throw new VisitException();
    }

    public void visit(PoundSourceLocationArgs entity) {
        throw new VisitException();
    }

    public void visit(DeclModifier entity) {
        throw new VisitException();
    }

    public void visit(InheritedType entity) {
        throw new VisitException();
    }

    public void visit(InheritedTypeList entity) {
        throw new VisitException();
    }

    public void visit(TypeInheritanceClause entity) {
        throw new VisitException();
    }

    public void visit(ClassDecl entity) {
        throw new VisitException();
    }

    public void visit(StructDecl entity) {
        throw new VisitException();
    }

    public void visit(ProtocolDecl entity) {
        throw new VisitException();
    }

    public void visit(ExtensionDecl entity) {
        throw new VisitException();
    }

    public void visit(MemberDeclBlock entity) {
        throw new VisitException();
    }

    public void visit(MemberDeclList entity) {
        throw new VisitException();
    }

    public void visit(MemberDeclListItem entity) {
        throw new VisitException();
    }

    public void visit(SourceFile entity) {
        throw new VisitException();
    }

    public void visit(InitializerClause entity) {
        throw new VisitException();
    }

    public void visit(FunctionParameter entity) {
        throw new VisitException();
    }

    public void visit(ModifierList entity) {
        throw new VisitException();
    }

    public void visit(FunctionDecl entity) {
        throw new VisitException();
    }

    public void visit(InitializerDecl entity) {
        throw new VisitException();
    }

    public void visit(DeinitializerDecl entity) {
        throw new VisitException();
    }

    public void visit(SubscriptDecl entity) {
        throw new VisitException();
    }

    public void visit(AccessLevelModifier entity) {
        throw new VisitException();
    }

    public void visit(AccessPathComponent entity) {
        throw new VisitException();
    }

    public void visit(AccessPath entity) {
        throw new VisitException();
    }

    public void visit(ImportDecl entity) {
        throw new VisitException();
    }

    public void visit(AccessorParameter entity) {
        throw new VisitException();
    }

    public void visit(AccessorDecl entity) {
        throw new VisitException();
    }

    public void visit(AccessorList entity) {
        throw new VisitException();
    }

    public void visit(AccessorBlock entity) {
        throw new VisitException();
    }

    public void visit(PatternBinding entity) {
        throw new VisitException();
    }

    public void visit(PatternBindingList entity) {
        throw new VisitException();
    }

    public void visit(VariableDecl entity) {
        throw new VisitException();
    }

    public void visit(EnumCaseElement entity) {
        throw new VisitException();
    }

    public void visit(EnumCaseElementList entity) {
        throw new VisitException();
    }

    public void visit(EnumCaseDecl entity) {
        throw new VisitException();
    }

    public void visit(EnumDecl entity) {
        throw new VisitException();
    }

    public void visit(OperatorDecl entity) {
        throw new VisitException();
    }

    public void visit(IdentifierList entity) {
        throw new VisitException();
    }

    public void visit(OperatorPrecedenceAndTypes entity) {
        throw new VisitException();
    }

    public void visit(PrecedenceGroupDecl entity) {
        throw new VisitException();
    }

    public void visit(PrecedenceGroupAttributeList entity) {
        throw new VisitException();
    }

    public void visit(PrecedenceGroupRelation entity) {
        throw new VisitException();
    }

    public void visit(PrecedenceGroupNameList entity) {
        throw new VisitException();
    }

    public void visit(PrecedenceGroupNameElement entity) {
        throw new VisitException();
    }

    public void visit(PrecedenceGroupAssignment entity) {
        throw new VisitException();
    }

    public void visit(PrecedenceGroupAssociativity entity) {
        throw new VisitException();
    }

    public void visit(TokenList entity) {
        throw new VisitException();
    }

    public void visit(CustomAttribute entity) {
        throw new VisitException();
    }

    public void visit(Attribute entity) {
        throw new VisitException();
    }

    public void visit(AttributeList entity) {
        throw new VisitException();
    }

    public void visit(SpecializeAttributeSpecList entity) {
        throw new VisitException();
    }

    public void visit(LabeledSpecializeEntry entity) {
        throw new VisitException();
    }

    public void visit(NamedAttributeStringArgument entity) {
        throw new VisitException();
    }

    public void visit(DeclName entity) {
        throw new VisitException();
    }

    public void visit(ImplementsAttributeArguments entity) {
        throw new VisitException();
    }

    public void visit(ObjCSelectorPiece entity) {
        throw new VisitException();
    }

    public void visit(ObjCSelector entity) {
        throw new VisitException();
    }

    public void visit(ContinueStmt entity) {
        throw new VisitException();
    }

    public void visit(WhileStmt entity) {
        throw new VisitException();
    }

    public void visit(DeferStmt entity) {
        throw new VisitException();
    }

    public void visit(SwitchCaseList entity) {
        throw new VisitException();
    }

    public void visit(RepeatWhileStmt entity) {
        throw new VisitException();
    }

    public void visit(GuardStmt entity) {
        throw new VisitException();
    }

    public void visit(WhereClause entity) {
        throw new VisitException();
    }

    public void visit(ForInStmt entity) {
        throw new VisitException();
    }

    public void visit(SwitchStmt entity) {
        throw new VisitException();
    }

    public void visit(CatchClauseList entity) {
        throw new VisitException();
    }

    public void visit(DoStmt entity) {
        throw new VisitException();
    }

    public void visit(ReturnStmt entity) {
        throw new VisitException();
    }

    public void visit(YieldStmt entity) {
        throw new VisitException();
    }

    public void visit(YieldList entity) {
        throw new VisitException();
    }

    public void visit(FallthroughStmt entity) {
        throw new VisitException();
    }

    public void visit(BreakStmt entity) {
        throw new VisitException();
    }

    public void visit(CaseItemList entity) {
        throw new VisitException();
    }

    public void visit(ConditionElement entity) {
        throw new VisitException();
    }

    public void visit(AvailabilityCondition entity) {
        throw new VisitException();
    }

    public void visit(MatchingPatternCondition entity) {
        throw new VisitException();
    }

    public void visit(OptionalBindingCondition entity) {
        throw new VisitException();
    }

    public void visit(ConditionElementList entity) {
        throw new VisitException();
    }

    public void visit(ThrowStmt entity) {
        throw new VisitException();
    }

    public void visit(IfStmt entity) {
        throw new VisitException();
    }

    public void visit(SwitchCase entity) {
        throw new VisitException();
    }

    public void visit(SwitchDefaultLabel entity) {
        throw new VisitException();
    }

    public void visit(CaseItem entity) {
        throw new VisitException();
    }

    public void visit(SwitchCaseLabel entity) {
        throw new VisitException();
    }

    public void visit(CatchClause entity) {
        throw new VisitException();
    }

    public void visit(PoundAssertStmt entity) {
        throw new VisitException();
    }

    public void visit(GenericWhereClause entity) {
        throw new VisitException();
    }

    public void visit(GenericRequirementList entity) {
        throw new VisitException();
    }

    public void visit(SameTypeRequirement entity) {
        throw new VisitException();
    }

    public void visit(GenericParameterList entity) {
        throw new VisitException();
    }

    public void visit(GenericParameter entity) {
        throw new VisitException();
    }

    public void visit(GenericParameterClause entity) {
        throw new VisitException();
    }

    public void visit(ConformanceRequirement entity) {
        throw new VisitException();
    }

    public void visit(SimpleTypeIdentifier entity) {
        throw new VisitException();
    }

    public void visit(MemberTypeIdentifier entity) {
        throw new VisitException();
    }

    public void visit(ClassRestrictionType entity) {
        throw new VisitException();
    }

    public void visit(ArrayType entity) {
        throw new VisitException();
    }

    public void visit(DictionaryType entity) {
        throw new VisitException();
    }

    public void visit(MetatypeType entity) {
        throw new VisitException();
    }

    public void visit(OptionalType entity) {
        throw new VisitException();
    }

    public void visit(SomeType entity) {
        throw new VisitException();
    }

    public void visit(ImplicitlyUnwrappedOptionalType entity) {
        throw new VisitException();
    }

    public void visit(CompositionTypeElement entity) {
        throw new VisitException();
    }

    public void visit(CompositionTypeElementList entity) {
        throw new VisitException();
    }

    public void visit(CompositionType entity) {
        throw new VisitException();
    }

    public void visit(TupleTypeElement entity) {
        throw new VisitException();
    }

    public void visit(TupleTypeElementList entity) {
        throw new VisitException();
    }

    public void visit(TupleType entity) {
        throw new VisitException();
    }

    public void visit(FunctionType entity) {
        throw new VisitException();
    }

    public void visit(AttributedType entity) {
        throw new VisitException();
    }

    public void visit(GenericArgumentList entity) {
        throw new VisitException();
    }

    public void visit(GenericArgument entity) {
        throw new VisitException();
    }

    public void visit(GenericArgumentClause entity) {
        throw new VisitException();
    }

    public void visit(TypeAnnotation entity) {
        throw new VisitException();
    }

    public void visit(EnumCasePattern entity) {
        throw new VisitException();
    }

    public void visit(IsTypePattern entity) {
        throw new VisitException();
    }

    public void visit(OptionalPattern entity) {
        throw new VisitException();
    }

    public void visit(IdentifierPattern entity) {
        throw new VisitException();
    }

    public void visit(AsTypePattern entity) {
        throw new VisitException();
    }

    public void visit(TuplePattern entity) {
        throw new VisitException();
    }

    public void visit(WildcardPattern entity) {
        throw new VisitException();
    }

    public void visit(TuplePatternElement entity) {
        throw new VisitException();
    }

    public void visit(ExpressionPattern entity) {
        throw new VisitException();
    }

    public void visit(TuplePatternElementList entity) {
        throw new VisitException();
    }

    public void visit(ValueBindingPattern entity) {
        throw new VisitException();
    }

    public void visit(AvailabilitySpecList entity) {
        throw new VisitException();
    }

    public void visit(AvailabilityArgument entity) {
        throw new VisitException();
    }

    public void visit(AvailabilityLabeledArgument entity) {
        throw new VisitException();
    }

    public void visit(AvailabilityVersionRestriction entity) {
        throw new VisitException();
    }

    public void visit(VersionTuple entity) {
        throw new VisitException();
    }

    public void visit(TokenKind entity) {
        throw new VisitException();
    }

    public void visit(Text entity) {
        throw new VisitException();
    }

    public void visit(Trivia entity) {
        throw new VisitException();
    }

    public void visit(TriviaPiece entity) {
        throw new VisitException();
    }

    public void visit(SourcePresence entity) {
        throw new VisitException();
    }
}
