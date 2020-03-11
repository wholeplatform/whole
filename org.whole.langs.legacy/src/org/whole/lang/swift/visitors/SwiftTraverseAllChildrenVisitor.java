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

import org.whole.lang.swift.visitors.SwiftIdentityUnaryVisitor;
import org.whole.lang.swift.visitors.ISwiftVisitor;
import org.whole.lang.swift.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator Whole
 */
public class SwiftTraverseAllChildrenVisitor extends SwiftIdentityUnaryVisitor<ISwiftVisitor> {

    public SwiftTraverseAllChildrenVisitor() {
        wSetVisitor1(this);
    }

    public SwiftTraverseAllChildrenVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(CodeBlockItemList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(InOutExpr entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(FunctionCallArgumentList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(StringLiteralSegments entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ExpressionSegment entity) {
        entity.getDelimiter().accept(wGetVisitor1());
        entity.getExpressions().accept(wGetVisitor1());
    }

    public void visit(TryExpr entity) {
        entity.getQuestionOrExclamationMark().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(DeclNameArgumentList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(IdentifierExpr entity) {
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getDeclNameArguments().accept(wGetVisitor1());
    }

    public void visit(SequenceExpr entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(SymbolicReferenceExpr entity) {
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getGenericArgumentClause().accept(wGetVisitor1());
    }

    public void visit(PrefixOperatorExpr entity) {
        entity.getOperatorToken().accept(wGetVisitor1());
        entity.getPostfixExpression().accept(wGetVisitor1());
    }

    public void visit(BinaryOperatorExpr entity) {
        entity.getOperatorToken().accept(wGetVisitor1());
    }

    public void visit(ArrowExpr entity) {
        entity.getThrowsToken().accept(wGetVisitor1());
    }

    public void visit(TupleExpr entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ArrayExpr entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(DictionaryExpr entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(FunctionCallArgument entity) {
        entity.getLabel().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(TupleElement entity) {
        entity.getLabel().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(DictionaryElement entity) {
        entity.getKeyExpression().accept(wGetVisitor1());
        entity.getValueExpression().accept(wGetVisitor1());
    }

    public void visit(TernaryExpr entity) {
        entity.getConditionExpression().accept(wGetVisitor1());
        entity.getFirstChoice().accept(wGetVisitor1());
        entity.getSecondChoice().accept(wGetVisitor1());
    }

    public void visit(MemberAccessExpr entity) {
        entity.getBase().accept(wGetVisitor1());
        entity.getDot().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getDeclNameArguments().accept(wGetVisitor1());
    }

    public void visit(IsExpr entity) {
        entity.getTypeName().accept(wGetVisitor1());
    }

    public void visit(AsExpr entity) {
        entity.getQuestionOrExclamationMark().accept(wGetVisitor1());
        entity.getTypeName().accept(wGetVisitor1());
    }

    public void visit(TypeExpr entity) {
        entity.getType().accept(wGetVisitor1());
    }

    public void visit(ClosureCaptureItem entity) {
        entity.getSpecifier().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(ClosureCaptureItemList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ClosureParamList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ClosureSignature entity) {
        entity.getCapture().accept(wGetVisitor1());
        entity.getInput().accept(wGetVisitor1());
        entity.getThrowsTok().accept(wGetVisitor1());
        entity.getOutput().accept(wGetVisitor1());
    }

    public void visit(ClosureExpr entity) {
        entity.getSignature().accept(wGetVisitor1());
        entity.getStatements().accept(wGetVisitor1());
    }

    public void visit(UnresolvedPatternExpr entity) {
        entity.getPattern().accept(wGetVisitor1());
    }

    public void visit(FunctionCallExpr entity) {
        entity.getCalledExpression().accept(wGetVisitor1());
        entity.getArgumentList().accept(wGetVisitor1());
        entity.getTrailingClosure().accept(wGetVisitor1());
    }

    public void visit(SubscriptExpr entity) {
        entity.getCalledExpression().accept(wGetVisitor1());
        entity.getArgumentList().accept(wGetVisitor1());
        entity.getTrailingClosure().accept(wGetVisitor1());
    }

    public void visit(OptionalChainingExpr entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(ForcedValueExpr entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(PostfixUnaryExpr entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getOperatorToken().accept(wGetVisitor1());
    }

    public void visit(SpecializeExpr entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getGenericArgumentClause().accept(wGetVisitor1());
    }

    public void visit(StringLiteralExpr entity) {
        entity.getOpenDelimiter().accept(wGetVisitor1());
        entity.getOpenQuote().accept(wGetVisitor1());
        entity.getSegments().accept(wGetVisitor1());
    }

    public void visit(KeyPathExpr entity) {
        entity.getRootExpr().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(ObjcKeyPathExpr entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ObjcSelectorExpr entity) {
        entity.getKind().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
    }

    public void visit(EditorPlaceholderExpr entity) {
        entity.getIdentifier().accept(wGetVisitor1());
    }

    public void visit(ObjectLiteralExpr entity) {
        entity.getPoundIdentifier().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
    }

    public void visit(TypealiasDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getGenericParameterClause().accept(wGetVisitor1());
        entity.getInitializer().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
    }

    public void visit(AssociatedtypeDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getInheritanceClause().accept(wGetVisitor1());
        entity.getInitializer().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
    }

    public void visit(FunctionParameterList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(FunctionSignature entity) {
        entity.getInput().accept(wGetVisitor1());
        entity.getThrowsOrRethrowsKeyword().accept(wGetVisitor1());
        entity.getOutput().accept(wGetVisitor1());
    }

    public void visit(IfConfigClause entity) {
        entity.getPoundKeyword().accept(wGetVisitor1());
        entity.getCondition().accept(wGetVisitor1());
        entity.getElements().accept(wGetVisitor1());
    }

    public void visit(SwitchCaseList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(MemberDeclList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(IfConfigDecl entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(PoundErrorDecl entity) {
        entity.getMessage().accept(wGetVisitor1());
    }

    public void visit(PoundWarningDecl entity) {
        entity.getMessage().accept(wGetVisitor1());
    }

    public void visit(PoundSourceLocation entity) {
        entity.getArgs().accept(wGetVisitor1());
    }

    public void visit(PoundSourceLocationArgs entity) {
        entity.getFileArgLabel().accept(wGetVisitor1());
        entity.getFileName().accept(wGetVisitor1());
        entity.getLineArgLabel().accept(wGetVisitor1());
        entity.getLineNumber().accept(wGetVisitor1());
    }

    public void visit(DeclModifier entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getDetail().accept(wGetVisitor1());
    }

    public void visit(InheritedTypeList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ClassDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getGenericParameterClause().accept(wGetVisitor1());
        entity.getInheritanceClause().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
        entity.getMembers().accept(wGetVisitor1());
    }

    public void visit(StructDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getGenericParameterClause().accept(wGetVisitor1());
        entity.getInheritanceClause().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
        entity.getMembers().accept(wGetVisitor1());
    }

    public void visit(ProtocolDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getInheritanceClause().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
        entity.getMembers().accept(wGetVisitor1());
    }

    public void visit(ExtensionDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getExtendedType().accept(wGetVisitor1());
        entity.getInheritanceClause().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
        entity.getMembers().accept(wGetVisitor1());
    }

    public void visit(SourceFile entity) {
        entity.getStatements().accept(wGetVisitor1());
    }

    public void visit(FunctionParameter entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getFirstName().accept(wGetVisitor1());
        entity.getSecondName().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
        entity.getEllipsis().accept(wGetVisitor1());
        entity.getDefaultArgument().accept(wGetVisitor1());
    }

    public void visit(ModifierList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(FunctionDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getFunctionIdentifier().accept(wGetVisitor1());
        entity.getGenericParameterClause().accept(wGetVisitor1());
        entity.getSignature().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(InitializerDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getOptionalMark().accept(wGetVisitor1());
        entity.getGenericParameterClause().accept(wGetVisitor1());
        entity.getParameters().accept(wGetVisitor1());
        entity.getThrowsOrRethrowsKeyword().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(DeinitializerDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(SubscriptDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getGenericParameterClause().accept(wGetVisitor1());
        entity.getIndices().accept(wGetVisitor1());
        entity.getResult().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
        entity.getAccessor().accept(wGetVisitor1());
    }

    public void visit(AccessorBlock entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(AccessLevelModifier entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getModifier().accept(wGetVisitor1());
    }

    public void visit(AccessPath entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ImportDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getImportKind().accept(wGetVisitor1());
        entity.getPath().accept(wGetVisitor1());
    }

    public void visit(AccessorDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifier().accept(wGetVisitor1());
        entity.getAccessorKind().accept(wGetVisitor1());
        entity.getParameter().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(PatternBinding entity) {
        entity.getPattern().accept(wGetVisitor1());
        entity.getTypeAnnotation().accept(wGetVisitor1());
        entity.getInitializer().accept(wGetVisitor1());
        entity.getAccessor().accept(wGetVisitor1());
    }

    public void visit(PatternBindingList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(VariableDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getLetOrVarKeyword().accept(wGetVisitor1());
        entity.getBindings().accept(wGetVisitor1());
    }

    public void visit(EnumCaseElement entity) {
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getAssociatedValue().accept(wGetVisitor1());
        entity.getRawValue().accept(wGetVisitor1());
    }

    public void visit(EnumCaseElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(EnumCaseDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getElements().accept(wGetVisitor1());
    }

    public void visit(EnumDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getGenericParameters().accept(wGetVisitor1());
        entity.getInheritanceClause().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
        entity.getMembers().accept(wGetVisitor1());
    }

    public void visit(OperatorDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getOperatorIdentifier().accept(wGetVisitor1());
        entity.getOperatorPrecedenceAndTypes().accept(wGetVisitor1());
    }

    public void visit(IdentifierList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(PrecedenceGroupDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getGroupAttributes().accept(wGetVisitor1());
    }

    public void visit(PrecedenceGroupAttributeList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(PrecedenceGroupRelation entity) {
        entity.getHigherThanOrLowerThan().accept(wGetVisitor1());
        entity.getOtherNames().accept(wGetVisitor1());
    }

    public void visit(PrecedenceGroupAssignment entity) {
        entity.getAssignmentKeyword().accept(wGetVisitor1());
        entity.getFlag().accept(wGetVisitor1());
    }

    public void visit(PrecedenceGroupAssociativity entity) {
        entity.getAssociativityKeyword().accept(wGetVisitor1());
        entity.getValue().accept(wGetVisitor1());
    }

    public void visit(PrecedenceGroupNameList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(CustomAttribute entity) {
        entity.getAttributeName().accept(wGetVisitor1());
        entity.getArgumentList().accept(wGetVisitor1());
    }

    public void visit(Attribute entity) {
        entity.getAttributeName().accept(wGetVisitor1());
        entity.getArgument().accept(wGetVisitor1());
    }

    public void visit(AvailabilitySpecList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(SpecializeAttributeSpecList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ObjCSelector entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ImplementsAttributeArguments entity) {
        entity.getType().accept(wGetVisitor1());
        entity.getDeclBaseName().accept(wGetVisitor1());
        entity.getDeclNameArguments().accept(wGetVisitor1());
    }

    public void visit(NamedAttributeStringArgument entity) {
        entity.getNameTok().accept(wGetVisitor1());
        entity.getStringOrDeclname().accept(wGetVisitor1());
    }

    public void visit(AttributeList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(LabeledSpecializeEntry entity) {
        entity.getLabel().accept(wGetVisitor1());
        entity.getValue().accept(wGetVisitor1());
    }

    public void visit(DeclName entity) {
        entity.getDeclBaseName().accept(wGetVisitor1());
        entity.getDeclNameArguments().accept(wGetVisitor1());
    }

    public void visit(ContinueStmt entity) {
        entity.getLabel().accept(wGetVisitor1());
    }

    public void visit(WhileStmt entity) {
        entity.getLabelName().accept(wGetVisitor1());
        entity.getConditions().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(DeferStmt entity) {
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(SwitchCase entity) {
        entity.getUnknownAttr().accept(wGetVisitor1());
        entity.getLabel().accept(wGetVisitor1());
        entity.getStatements().accept(wGetVisitor1());
    }

    public void visit(RepeatWhileStmt entity) {
        entity.getLabelName().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
        entity.getCondition().accept(wGetVisitor1());
    }

    public void visit(GuardStmt entity) {
        entity.getConditions().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(ForInStmt entity) {
        entity.getLabelName().accept(wGetVisitor1());
        entity.getCaseKeyword().accept(wGetVisitor1());
        entity.getPattern().accept(wGetVisitor1());
        entity.getTypeAnnotation().accept(wGetVisitor1());
        entity.getSequenceExpr().accept(wGetVisitor1());
        entity.getWhereClause().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(SwitchStmt entity) {
        entity.getLabelName().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
        entity.getCases().accept(wGetVisitor1());
    }

    public void visit(CatchClauseList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(DoStmt entity) {
        entity.getLabelName().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
        entity.getCatchClauses().accept(wGetVisitor1());
    }

    public void visit(ReturnStmt entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(YieldStmt entity) {
        entity.getYields().accept(wGetVisitor1());
    }

    public void visit(YieldList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(BreakStmt entity) {
        entity.getLabel().accept(wGetVisitor1());
    }

    public void visit(AvailabilityCondition entity) {
        entity.getAvailabilitySpec().accept(wGetVisitor1());
    }

    public void visit(MatchingPatternCondition entity) {
        entity.getPattern().accept(wGetVisitor1());
        entity.getTypeAnnotation().accept(wGetVisitor1());
        entity.getInitializer().accept(wGetVisitor1());
    }

    public void visit(OptionalBindingCondition entity) {
        entity.getLetOrVarKeyword().accept(wGetVisitor1());
        entity.getPattern().accept(wGetVisitor1());
        entity.getTypeAnnotation().accept(wGetVisitor1());
        entity.getInitializer().accept(wGetVisitor1());
    }

    public void visit(ConditionElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ThrowStmt entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(IfStmt entity) {
        entity.getLabelName().accept(wGetVisitor1());
        entity.getConditions().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
        entity.getElseBody().accept(wGetVisitor1());
    }

    public void visit(SwitchCaseLabel entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(CaseItem entity) {
        entity.getPattern().accept(wGetVisitor1());
        entity.getWhereClause().accept(wGetVisitor1());
    }

    public void visit(CatchClause entity) {
        entity.getPattern().accept(wGetVisitor1());
        entity.getWhereClause().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(PoundAssertStmt entity) {
        entity.getCondition().accept(wGetVisitor1());
        entity.getMessage().accept(wGetVisitor1());
    }

    public void visit(GenericRequirementList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(SameTypeRequirement entity) {
        entity.getLeftTypeIdentifier().accept(wGetVisitor1());
        entity.getEqualityToken().accept(wGetVisitor1());
        entity.getRightTypeIdentifier().accept(wGetVisitor1());
    }

    public void visit(ConformanceRequirement entity) {
        entity.getLeftTypeIdentifier().accept(wGetVisitor1());
        entity.getRightTypeIdentifier().accept(wGetVisitor1());
    }

    public void visit(GenericParameterList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(GenericParameter entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getInheritedType().accept(wGetVisitor1());
    }

    public void visit(SimpleTypeIdentifier entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getGenericArgumentClause().accept(wGetVisitor1());
    }

    public void visit(MemberTypeIdentifier entity) {
        entity.getBaseType().accept(wGetVisitor1());
        entity.getPeriod().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getGenericArgumentClause().accept(wGetVisitor1());
    }

    public void visit(ArrayType entity) {
        entity.getElementType().accept(wGetVisitor1());
    }

    public void visit(DictionaryType entity) {
        entity.getKeyType().accept(wGetVisitor1());
        entity.getValueType().accept(wGetVisitor1());
    }

    public void visit(MetatypeType entity) {
        entity.getBaseType().accept(wGetVisitor1());
        entity.getTypeOrProtocol().accept(wGetVisitor1());
    }

    public void visit(OptionalType entity) {
        entity.getWrappedType().accept(wGetVisitor1());
    }

    public void visit(SomeType entity) {
        entity.getSomeSpecifier().accept(wGetVisitor1());
        entity.getBaseType().accept(wGetVisitor1());
    }

    public void visit(ImplicitlyUnwrappedOptionalType entity) {
        entity.getWrappedType().accept(wGetVisitor1());
    }

    public void visit(CompositionTypeElement entity) {
        entity.getType().accept(wGetVisitor1());
        entity.getAmpersand().accept(wGetVisitor1());
    }

    public void visit(CompositionType entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(TupleTypeElement entity) {
        entity.getInOut().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getSecondName().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
        entity.getEllipsis().accept(wGetVisitor1());
        entity.getInitializer().accept(wGetVisitor1());
    }

    public void visit(TupleTypeElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(TupleType entity) {
        entity.getElements().accept(wGetVisitor1());
    }

    public void visit(FunctionType entity) {
        entity.getArguments().accept(wGetVisitor1());
        entity.getThrowsOrRethrowsKeyword().accept(wGetVisitor1());
        entity.getReturnType().accept(wGetVisitor1());
    }

    public void visit(AttributedType entity) {
        entity.getSpecifier().accept(wGetVisitor1());
        entity.getAttributes().accept(wGetVisitor1());
        entity.getBaseType().accept(wGetVisitor1());
    }

    public void visit(GenericArgumentList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(EnumCasePattern entity) {
        entity.getType().accept(wGetVisitor1());
        entity.getCaseName().accept(wGetVisitor1());
        entity.getAssociatedTuple().accept(wGetVisitor1());
    }

    public void visit(IsTypePattern entity) {
        entity.getType().accept(wGetVisitor1());
    }

    public void visit(OptionalPattern entity) {
        entity.getSubPattern().accept(wGetVisitor1());
    }

    public void visit(IdentifierPattern entity) {
        entity.getPatternIdentifier().accept(wGetVisitor1());
    }

    public void visit(AsTypePattern entity) {
        entity.getPattern().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
    }

    public void visit(WildcardPattern entity) {
        entity.getTypeAnnotation().accept(wGetVisitor1());
    }

    public void visit(TuplePatternElement entity) {
        entity.getLabelName().accept(wGetVisitor1());
        entity.getPattern().accept(wGetVisitor1());
    }

    public void visit(ExpressionPattern entity) {
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(TuplePatternElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ValueBindingPattern entity) {
        entity.getLetOrVarKeyword().accept(wGetVisitor1());
        entity.getValuePattern().accept(wGetVisitor1());
    }

    public void visit(AvailabilityVersionRestriction entity) {
        entity.getPlatform().accept(wGetVisitor1());
        entity.getVersion().accept(wGetVisitor1());
    }

    public void visit(AvailabilityLabeledArgument entity) {
        entity.getLabel().accept(wGetVisitor1());
        entity.getValue().accept(wGetVisitor1());
    }

    public void visit(VersionTuple entity) {
        entity.getMajorMinor().accept(wGetVisitor1());
        entity.getPatchVersion().accept(wGetVisitor1());
    }
}
