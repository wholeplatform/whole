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

import org.whole.lang.swiftsyntax.visitors.SwiftSyntaxIdentityUnaryVisitor;
import org.whole.lang.swiftsyntax.visitors.ISwiftSyntaxVisitor;
import org.whole.lang.swiftsyntax.model.*;
import org.whole.lang.visitors.IVisitor;

/**
 *  @generator Whole
 */
public class SwiftSyntaxTraverseAllChildrenVisitor extends SwiftSyntaxIdentityUnaryVisitor<ISwiftSyntaxVisitor> {

    public SwiftSyntaxTraverseAllChildrenVisitor() {
        wSetVisitor1(this);
    }

    public SwiftSyntaxTraverseAllChildrenVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Token entity) {
        entity.getKind().accept(wGetVisitor1());
        entity.getPresence().accept(wGetVisitor1());
        entity.getLeadingTrivia().accept(wGetVisitor1());
        entity.getTrailingTrivia().accept(wGetVisitor1());
        entity.getText().accept(wGetVisitor1());
    }

    public void visit(UnknownDecl entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(UnknownExpr entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(UnknownPattern entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(UnknownStmt entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(UnknownType entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(CodeBlockItem entity) {
        entity.getItem().accept(wGetVisitor1());
        entity.getSemicolon().accept(wGetVisitor1());
        entity.getErrorTokens().accept(wGetVisitor1());
    }

    public void visit(CodeBlockItemList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(CodeBlock entity) {
        entity.getLeftBrace().accept(wGetVisitor1());
        entity.getStatements().accept(wGetVisitor1());
        entity.getRightBrace().accept(wGetVisitor1());
    }

    public void visit(InOutExpr entity) {
        entity.getAmpersand().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(PoundColumnExpr entity) {
        entity.getPoundColumn().accept(wGetVisitor1());
    }

    public void visit(FunctionCallArgumentList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(TupleElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ArrayElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(DictionaryElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(StringLiteralSegments entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(TryExpr entity) {
        entity.getTryKeyword().accept(wGetVisitor1());
        entity.getQuestionOrExclamationMark().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(DeclNameArgument entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
    }

    public void visit(DeclNameArgumentList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(DeclNameArguments entity) {
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(IdentifierExpr entity) {
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getDeclNameArguments().accept(wGetVisitor1());
    }

    public void visit(SuperRefExpr entity) {
        entity.getSuperKeyword().accept(wGetVisitor1());
    }

    public void visit(NilLiteralExpr entity) {
        entity.getNilKeyword().accept(wGetVisitor1());
    }

    public void visit(DiscardAssignmentExpr entity) {
        entity.getWildcard().accept(wGetVisitor1());
    }

    public void visit(AssignmentExpr entity) {
        entity.getAssignToken().accept(wGetVisitor1());
    }

    public void visit(SequenceExpr entity) {
        entity.getElements().accept(wGetVisitor1());
    }

    public void visit(ExprList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(PoundLineExpr entity) {
        entity.getPoundLine().accept(wGetVisitor1());
    }

    public void visit(PoundFileExpr entity) {
        entity.getPoundFile().accept(wGetVisitor1());
    }

    public void visit(PoundFunctionExpr entity) {
        entity.getPoundFunction().accept(wGetVisitor1());
    }

    public void visit(PoundDsohandleExpr entity) {
        entity.getPoundDsohandle().accept(wGetVisitor1());
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
        entity.getArrowToken().accept(wGetVisitor1());
    }

    public void visit(FloatLiteralExpr entity) {
        entity.getFloatingDigits().accept(wGetVisitor1());
    }

    public void visit(TupleExpr entity) {
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getElementList().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(ArrayExpr entity) {
        entity.getLeftSquare().accept(wGetVisitor1());
        entity.getElements().accept(wGetVisitor1());
        entity.getRightSquare().accept(wGetVisitor1());
    }

    public void visit(DictionaryExpr entity) {
        entity.getLeftSquare().accept(wGetVisitor1());
        entity.getContent().accept(wGetVisitor1());
        entity.getRightSquare().accept(wGetVisitor1());
    }

    public void visit(FunctionCallArgument entity) {
        entity.getLabel().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(TupleElement entity) {
        entity.getLabel().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(ArrayElement entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(DictionaryElement entity) {
        entity.getKeyExpression().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
        entity.getValueExpression().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(IntegerLiteralExpr entity) {
        entity.getDigits().accept(wGetVisitor1());
    }

    public void visit(BooleanLiteralExpr entity) {
        entity.getBooleanLiteral().accept(wGetVisitor1());
    }

    public void visit(TernaryExpr entity) {
        entity.getConditionExpression().accept(wGetVisitor1());
        entity.getQuestionMark().accept(wGetVisitor1());
        entity.getFirstChoice().accept(wGetVisitor1());
        entity.getColonMark().accept(wGetVisitor1());
        entity.getSecondChoice().accept(wGetVisitor1());
    }

    public void visit(MemberAccessExpr entity) {
        entity.getBase().accept(wGetVisitor1());
        entity.getDot().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getDeclNameArguments().accept(wGetVisitor1());
    }

    public void visit(IsExpr entity) {
        entity.getIsTok().accept(wGetVisitor1());
        entity.getTypeName().accept(wGetVisitor1());
    }

    public void visit(AsExpr entity) {
        entity.getAsTok().accept(wGetVisitor1());
        entity.getQuestionOrExclamationMark().accept(wGetVisitor1());
        entity.getTypeName().accept(wGetVisitor1());
    }

    public void visit(TypeExpr entity) {
        entity.getType().accept(wGetVisitor1());
    }

    public void visit(ClosureCaptureItem entity) {
        entity.getSpecifier().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getAssignToken().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(ClosureCaptureItemList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ClosureCaptureSignature entity) {
        entity.getLeftSquare().accept(wGetVisitor1());
        entity.getItems().accept(wGetVisitor1());
        entity.getRightSquare().accept(wGetVisitor1());
    }

    public void visit(ClosureParam entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
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
        entity.getInTok().accept(wGetVisitor1());
    }

    public void visit(ClosureExpr entity) {
        entity.getLeftBrace().accept(wGetVisitor1());
        entity.getSignature().accept(wGetVisitor1());
        entity.getStatements().accept(wGetVisitor1());
        entity.getRightBrace().accept(wGetVisitor1());
    }

    public void visit(UnresolvedPatternExpr entity) {
        entity.getPattern().accept(wGetVisitor1());
    }

    public void visit(FunctionCallExpr entity) {
        entity.getCalledExpression().accept(wGetVisitor1());
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getArgumentList().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
        entity.getTrailingClosure().accept(wGetVisitor1());
    }

    public void visit(SubscriptExpr entity) {
        entity.getCalledExpression().accept(wGetVisitor1());
        entity.getLeftBracket().accept(wGetVisitor1());
        entity.getArgumentList().accept(wGetVisitor1());
        entity.getRightBracket().accept(wGetVisitor1());
        entity.getTrailingClosure().accept(wGetVisitor1());
    }

    public void visit(OptionalChainingExpr entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getQuestionMark().accept(wGetVisitor1());
    }

    public void visit(ForcedValueExpr entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getExclamationMark().accept(wGetVisitor1());
    }

    public void visit(PostfixUnaryExpr entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getOperatorToken().accept(wGetVisitor1());
    }

    public void visit(SpecializeExpr entity) {
        entity.getExpression().accept(wGetVisitor1());
        entity.getGenericArgumentClause().accept(wGetVisitor1());
    }

    public void visit(StringSegment entity) {
        entity.getContent().accept(wGetVisitor1());
    }

    public void visit(ExpressionSegment entity) {
        entity.getBackslash().accept(wGetVisitor1());
        entity.getDelimiter().accept(wGetVisitor1());
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getExpressions().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(StringLiteralExpr entity) {
        entity.getOpenDelimiter().accept(wGetVisitor1());
        entity.getOpenQuote().accept(wGetVisitor1());
        entity.getSegments().accept(wGetVisitor1());
        entity.getCloseQuote().accept(wGetVisitor1());
        entity.getCloseDelimiter().accept(wGetVisitor1());
    }

    public void visit(KeyPathExpr entity) {
        entity.getBackslash().accept(wGetVisitor1());
        entity.getRootExpr().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(KeyPathBaseExpr entity) {
        entity.getPeriod().accept(wGetVisitor1());
    }

    public void visit(ObjcNamePiece entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getDot().accept(wGetVisitor1());
    }

    public void visit(ObjcName entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ObjcKeyPathExpr entity) {
        entity.getKeyPath().accept(wGetVisitor1());
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(ObjcSelectorExpr entity) {
        entity.getPoundSelector().accept(wGetVisitor1());
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getKind().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(EditorPlaceholderExpr entity) {
        entity.getIdentifier().accept(wGetVisitor1());
    }

    public void visit(ObjectLiteralExpr entity) {
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(TypeInitializerClause entity) {
        entity.getEqual().accept(wGetVisitor1());
        entity.getValue().accept(wGetVisitor1());
    }

    public void visit(TypealiasDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getTypealiasKeyword().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getGenericParameterClause().accept(wGetVisitor1());
        entity.getInitializer().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
    }

    public void visit(AssociatedtypeDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getAssociatedtypeKeyword().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getInheritanceClause().accept(wGetVisitor1());
        entity.getInitializer().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
    }

    public void visit(FunctionParameterList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ParameterClause entity) {
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getParameterList().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(ReturnClause entity) {
        entity.getArrow().accept(wGetVisitor1());
        entity.getReturnType().accept(wGetVisitor1());
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

    public void visit(IfConfigClauseList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(IfConfigDecl entity) {
        entity.getClauses().accept(wGetVisitor1());
        entity.getPoundEndif().accept(wGetVisitor1());
    }

    public void visit(PoundErrorDecl entity) {
        entity.getPoundError().accept(wGetVisitor1());
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getMessage().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(PoundWarningDecl entity) {
        entity.getPoundWarning().accept(wGetVisitor1());
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getMessage().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(PoundSourceLocation entity) {
        entity.getPoundSourceLocation().accept(wGetVisitor1());
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getArgs().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(PoundSourceLocationArgs entity) {
        entity.getFileArgLabel().accept(wGetVisitor1());
        entity.getFileArgColon().accept(wGetVisitor1());
        entity.getFileName().accept(wGetVisitor1());
        entity.getComma().accept(wGetVisitor1());
        entity.getLineArgLabel().accept(wGetVisitor1());
        entity.getLineArgColon().accept(wGetVisitor1());
        entity.getLineNumber().accept(wGetVisitor1());
    }

    public void visit(DeclModifier entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getDetailLeftParen().accept(wGetVisitor1());
        entity.getDetail().accept(wGetVisitor1());
        entity.getDetailRightParen().accept(wGetVisitor1());
    }

    public void visit(InheritedType entity) {
        entity.getTypeName().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(InheritedTypeList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(TypeInheritanceClause entity) {
        entity.getColon().accept(wGetVisitor1());
        entity.getInheritedTypeCollection().accept(wGetVisitor1());
    }

    public void visit(ClassDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getClassKeyword().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getGenericParameterClause().accept(wGetVisitor1());
        entity.getInheritanceClause().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
        entity.getMembers().accept(wGetVisitor1());
    }

    public void visit(StructDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getStructKeyword().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getGenericParameterClause().accept(wGetVisitor1());
        entity.getInheritanceClause().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
        entity.getMembers().accept(wGetVisitor1());
    }

    public void visit(ProtocolDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getProtocolKeyword().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getInheritanceClause().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
        entity.getMembers().accept(wGetVisitor1());
    }

    public void visit(ExtensionDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getExtensionKeyword().accept(wGetVisitor1());
        entity.getExtendedType().accept(wGetVisitor1());
        entity.getInheritanceClause().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
        entity.getMembers().accept(wGetVisitor1());
    }

    public void visit(MemberDeclBlock entity) {
        entity.getLeftBrace().accept(wGetVisitor1());
        entity.getMembers().accept(wGetVisitor1());
        entity.getRightBrace().accept(wGetVisitor1());
    }

    public void visit(MemberDeclList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(MemberDeclListItem entity) {
        entity.getDecl().accept(wGetVisitor1());
        entity.getSemicolon().accept(wGetVisitor1());
    }

    public void visit(SourceFile entity) {
        entity.getStatements().accept(wGetVisitor1());
        entity.getEofToken().accept(wGetVisitor1());
    }

    public void visit(InitializerClause entity) {
        entity.getEqual().accept(wGetVisitor1());
        entity.getValue().accept(wGetVisitor1());
    }

    public void visit(FunctionParameter entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getFirstName().accept(wGetVisitor1());
        entity.getSecondName().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
        entity.getEllipsis().accept(wGetVisitor1());
        entity.getDefaultArgument().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(ModifierList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(FunctionDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getFuncKeyword().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getGenericParameterClause().accept(wGetVisitor1());
        entity.getSignature().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(InitializerDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getInitKeyword().accept(wGetVisitor1());
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
        entity.getDeinitKeyword().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(SubscriptDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getSubscriptKeyword().accept(wGetVisitor1());
        entity.getGenericParameterClause().accept(wGetVisitor1());
        entity.getIndices().accept(wGetVisitor1());
        entity.getResult().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
        entity.getAccessor().accept(wGetVisitor1());
    }

    public void visit(AccessLevelModifier entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getModifier().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(AccessPathComponent entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getTrailingDot().accept(wGetVisitor1());
    }

    public void visit(AccessPath entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ImportDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getImportTok().accept(wGetVisitor1());
        entity.getImportKind().accept(wGetVisitor1());
        entity.getPath().accept(wGetVisitor1());
    }

    public void visit(AccessorParameter entity) {
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(AccessorDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifier().accept(wGetVisitor1());
        entity.getAccessorKind().accept(wGetVisitor1());
        entity.getParameter().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(AccessorList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(AccessorBlock entity) {
        entity.getLeftBrace().accept(wGetVisitor1());
        entity.getAccessors().accept(wGetVisitor1());
        entity.getRightBrace().accept(wGetVisitor1());
    }

    public void visit(PatternBinding entity) {
        entity.getPattern().accept(wGetVisitor1());
        entity.getTypeAnnotation().accept(wGetVisitor1());
        entity.getInitializer().accept(wGetVisitor1());
        entity.getAccessor().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
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
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(EnumCaseElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(EnumCaseDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getCaseKeyword().accept(wGetVisitor1());
        entity.getElements().accept(wGetVisitor1());
    }

    public void visit(EnumDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getEnumKeyword().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getGenericParameters().accept(wGetVisitor1());
        entity.getInheritanceClause().accept(wGetVisitor1());
        entity.getGenericWhereClause().accept(wGetVisitor1());
        entity.getMembers().accept(wGetVisitor1());
    }

    public void visit(OperatorDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getOperatorKeyword().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getOperatorPrecedenceAndTypes().accept(wGetVisitor1());
    }

    public void visit(IdentifierList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(OperatorPrecedenceAndTypes entity) {
        entity.getColon().accept(wGetVisitor1());
        entity.getPrecedenceGroupAndDesignatedTypes().accept(wGetVisitor1());
    }

    public void visit(PrecedenceGroupDecl entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getModifiers().accept(wGetVisitor1());
        entity.getPrecedencegroupKeyword().accept(wGetVisitor1());
        entity.getIdentifier().accept(wGetVisitor1());
        entity.getLeftBrace().accept(wGetVisitor1());
        entity.getGroupAttributes().accept(wGetVisitor1());
        entity.getRightBrace().accept(wGetVisitor1());
    }

    public void visit(PrecedenceGroupAttributeList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(PrecedenceGroupRelation entity) {
        entity.getHigherThanOrLowerThan().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
        entity.getOtherNames().accept(wGetVisitor1());
    }

    public void visit(PrecedenceGroupNameList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(PrecedenceGroupNameElement entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(PrecedenceGroupAssignment entity) {
        entity.getAssignmentKeyword().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
        entity.getFlag().accept(wGetVisitor1());
    }

    public void visit(PrecedenceGroupAssociativity entity) {
        entity.getAssociativityKeyword().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
        entity.getValue().accept(wGetVisitor1());
    }

    public void visit(TokenList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(CustomAttribute entity) {
        entity.getAtSignToken().accept(wGetVisitor1());
        entity.getAttributeName().accept(wGetVisitor1());
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getArgumentList().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(Attribute entity) {
        entity.getAtSignToken().accept(wGetVisitor1());
        entity.getAttributeName().accept(wGetVisitor1());
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getArgument().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(AttributeList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(SpecializeAttributeSpecList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(LabeledSpecializeEntry entity) {
        entity.getLabel().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
        entity.getValue().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(NamedAttributeStringArgument entity) {
        entity.getNameTok().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
        entity.getStringOrDeclname().accept(wGetVisitor1());
    }

    public void visit(DeclName entity) {
        entity.getDeclBaseName().accept(wGetVisitor1());
        entity.getDeclNameArguments().accept(wGetVisitor1());
    }

    public void visit(ImplementsAttributeArguments entity) {
        entity.getType().accept(wGetVisitor1());
        entity.getComma().accept(wGetVisitor1());
        entity.getDeclBaseName().accept(wGetVisitor1());
        entity.getDeclNameArguments().accept(wGetVisitor1());
    }

    public void visit(ObjCSelectorPiece entity) {
        entity.getName().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
    }

    public void visit(ObjCSelector entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ContinueStmt entity) {
        entity.getContinueKeyword().accept(wGetVisitor1());
        entity.getLabel().accept(wGetVisitor1());
    }

    public void visit(WhileStmt entity) {
        entity.getLabelName().accept(wGetVisitor1());
        entity.getLabelColon().accept(wGetVisitor1());
        entity.getWhileKeyword().accept(wGetVisitor1());
        entity.getConditions().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(DeferStmt entity) {
        entity.getDeferKeyword().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(SwitchCaseList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(RepeatWhileStmt entity) {
        entity.getLabelName().accept(wGetVisitor1());
        entity.getLabelColon().accept(wGetVisitor1());
        entity.getRepeatKeyword().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
        entity.getWhileKeyword().accept(wGetVisitor1());
        entity.getCondition().accept(wGetVisitor1());
    }

    public void visit(GuardStmt entity) {
        entity.getGuardKeyword().accept(wGetVisitor1());
        entity.getConditions().accept(wGetVisitor1());
        entity.getElseKeyword().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(WhereClause entity) {
        entity.getWhereKeyword().accept(wGetVisitor1());
        entity.getGuardResult().accept(wGetVisitor1());
    }

    public void visit(ForInStmt entity) {
        entity.getLabelName().accept(wGetVisitor1());
        entity.getLabelColon().accept(wGetVisitor1());
        entity.getForKeyword().accept(wGetVisitor1());
        entity.getCaseKeyword().accept(wGetVisitor1());
        entity.getPattern().accept(wGetVisitor1());
        entity.getTypeAnnotation().accept(wGetVisitor1());
        entity.getInKeyword().accept(wGetVisitor1());
        entity.getSequenceExpr().accept(wGetVisitor1());
        entity.getWhereClause().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(SwitchStmt entity) {
        entity.getLabelName().accept(wGetVisitor1());
        entity.getLabelColon().accept(wGetVisitor1());
        entity.getSwitchKeyword().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
        entity.getLeftBrace().accept(wGetVisitor1());
        entity.getCases().accept(wGetVisitor1());
        entity.getRightBrace().accept(wGetVisitor1());
    }

    public void visit(CatchClauseList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(DoStmt entity) {
        entity.getLabelName().accept(wGetVisitor1());
        entity.getLabelColon().accept(wGetVisitor1());
        entity.getDoKeyword().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
        entity.getCatchClauses().accept(wGetVisitor1());
    }

    public void visit(ReturnStmt entity) {
        entity.getReturnKeyword().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(YieldStmt entity) {
        entity.getYieldKeyword().accept(wGetVisitor1());
        entity.getYields().accept(wGetVisitor1());
    }

    public void visit(YieldList entity) {
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getElementList().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(FallthroughStmt entity) {
        entity.getFallthroughKeyword().accept(wGetVisitor1());
    }

    public void visit(BreakStmt entity) {
        entity.getBreakKeyword().accept(wGetVisitor1());
        entity.getLabel().accept(wGetVisitor1());
    }

    public void visit(CaseItemList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(ConditionElement entity) {
        entity.getCondition().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(AvailabilityCondition entity) {
        entity.getPoundAvailableKeyword().accept(wGetVisitor1());
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getAvailabilitySpec().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(MatchingPatternCondition entity) {
        entity.getCaseKeyword().accept(wGetVisitor1());
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
        entity.getThrowKeyword().accept(wGetVisitor1());
        entity.getExpression().accept(wGetVisitor1());
    }

    public void visit(IfStmt entity) {
        entity.getLabelName().accept(wGetVisitor1());
        entity.getLabelColon().accept(wGetVisitor1());
        entity.getIfKeyword().accept(wGetVisitor1());
        entity.getConditions().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
        entity.getElseKeyword().accept(wGetVisitor1());
        entity.getElseBody().accept(wGetVisitor1());
    }

    public void visit(SwitchCase entity) {
        entity.getUnknownAttr().accept(wGetVisitor1());
        entity.getLabel().accept(wGetVisitor1());
        entity.getStatements().accept(wGetVisitor1());
    }

    public void visit(SwitchDefaultLabel entity) {
        entity.getDefaultKeyword().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
    }

    public void visit(CaseItem entity) {
        entity.getPattern().accept(wGetVisitor1());
        entity.getWhereClause().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(SwitchCaseLabel entity) {
        entity.getCaseKeyword().accept(wGetVisitor1());
        entity.getCaseItems().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
    }

    public void visit(CatchClause entity) {
        entity.getCatchKeyword().accept(wGetVisitor1());
        entity.getPattern().accept(wGetVisitor1());
        entity.getWhereClause().accept(wGetVisitor1());
        entity.getBody().accept(wGetVisitor1());
    }

    public void visit(PoundAssertStmt entity) {
        entity.getPoundAssert().accept(wGetVisitor1());
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getCondition().accept(wGetVisitor1());
        entity.getComma().accept(wGetVisitor1());
        entity.getMessage().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(GenericWhereClause entity) {
        entity.getWhereKeyword().accept(wGetVisitor1());
        entity.getRequirementList().accept(wGetVisitor1());
    }

    public void visit(GenericRequirementList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(SameTypeRequirement entity) {
        entity.getLeftTypeIdentifier().accept(wGetVisitor1());
        entity.getEqualityToken().accept(wGetVisitor1());
        entity.getRightTypeIdentifier().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(GenericParameterList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(GenericParameter entity) {
        entity.getAttributes().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
        entity.getInheritedType().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(GenericParameterClause entity) {
        entity.getLeftAngleBracket().accept(wGetVisitor1());
        entity.getGenericParameterList().accept(wGetVisitor1());
        entity.getRightAngleBracket().accept(wGetVisitor1());
    }

    public void visit(ConformanceRequirement entity) {
        entity.getLeftTypeIdentifier().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
        entity.getRightTypeIdentifier().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
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

    public void visit(ClassRestrictionType entity) {
        entity.getClassKeyword().accept(wGetVisitor1());
    }

    public void visit(ArrayType entity) {
        entity.getLeftSquareBracket().accept(wGetVisitor1());
        entity.getElementType().accept(wGetVisitor1());
        entity.getRightSquareBracket().accept(wGetVisitor1());
    }

    public void visit(DictionaryType entity) {
        entity.getLeftSquareBracket().accept(wGetVisitor1());
        entity.getKeyType().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
        entity.getValueType().accept(wGetVisitor1());
        entity.getRightSquareBracket().accept(wGetVisitor1());
    }

    public void visit(MetatypeType entity) {
        entity.getBaseType().accept(wGetVisitor1());
        entity.getPeriod().accept(wGetVisitor1());
        entity.getTypeOrProtocol().accept(wGetVisitor1());
    }

    public void visit(OptionalType entity) {
        entity.getWrappedType().accept(wGetVisitor1());
        entity.getQuestionMark().accept(wGetVisitor1());
    }

    public void visit(SomeType entity) {
        entity.getSomeSpecifier().accept(wGetVisitor1());
        entity.getBaseType().accept(wGetVisitor1());
    }

    public void visit(ImplicitlyUnwrappedOptionalType entity) {
        entity.getWrappedType().accept(wGetVisitor1());
        entity.getExclamationMark().accept(wGetVisitor1());
    }

    public void visit(CompositionTypeElement entity) {
        entity.getType().accept(wGetVisitor1());
        entity.getAmpersand().accept(wGetVisitor1());
    }

    public void visit(CompositionTypeElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(CompositionType entity) {
        entity.getElements().accept(wGetVisitor1());
    }

    public void visit(TupleTypeElement entity) {
        entity.getInOut().accept(wGetVisitor1());
        entity.getName().accept(wGetVisitor1());
        entity.getSecondName().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
        entity.getEllipsis().accept(wGetVisitor1());
        entity.getInitializer().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(TupleTypeElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(TupleType entity) {
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getElements().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(FunctionType entity) {
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
        entity.getThrowsOrRethrowsKeyword().accept(wGetVisitor1());
        entity.getArrow().accept(wGetVisitor1());
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

    public void visit(GenericArgument entity) {
        entity.getArgumentType().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(GenericArgumentClause entity) {
        entity.getLeftAngleBracket().accept(wGetVisitor1());
        entity.getArguments().accept(wGetVisitor1());
        entity.getRightAngleBracket().accept(wGetVisitor1());
    }

    public void visit(TypeAnnotation entity) {
        entity.getColon().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
    }

    public void visit(EnumCasePattern entity) {
        entity.getType().accept(wGetVisitor1());
        entity.getPeriod().accept(wGetVisitor1());
        entity.getCaseName().accept(wGetVisitor1());
        entity.getAssociatedTuple().accept(wGetVisitor1());
    }

    public void visit(IsTypePattern entity) {
        entity.getIsKeyword().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
    }

    public void visit(OptionalPattern entity) {
        entity.getSubPattern().accept(wGetVisitor1());
        entity.getQuestionMark().accept(wGetVisitor1());
    }

    public void visit(IdentifierPattern entity) {
        entity.getIdentifier().accept(wGetVisitor1());
    }

    public void visit(AsTypePattern entity) {
        entity.getPattern().accept(wGetVisitor1());
        entity.getAsKeyword().accept(wGetVisitor1());
        entity.getType().accept(wGetVisitor1());
    }

    public void visit(TuplePattern entity) {
        entity.getLeftParen().accept(wGetVisitor1());
        entity.getElements().accept(wGetVisitor1());
        entity.getRightParen().accept(wGetVisitor1());
    }

    public void visit(WildcardPattern entity) {
        entity.getWildcard().accept(wGetVisitor1());
        entity.getTypeAnnotation().accept(wGetVisitor1());
    }

    public void visit(TuplePatternElement entity) {
        entity.getLabelName().accept(wGetVisitor1());
        entity.getLabelColon().accept(wGetVisitor1());
        entity.getPattern().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
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

    public void visit(AvailabilitySpecList entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }

    public void visit(AvailabilityArgument entity) {
        entity.getEntry().accept(wGetVisitor1());
        entity.getTrailingComma().accept(wGetVisitor1());
    }

    public void visit(AvailabilityLabeledArgument entity) {
        entity.getLabel().accept(wGetVisitor1());
        entity.getColon().accept(wGetVisitor1());
        entity.getValue().accept(wGetVisitor1());
    }

    public void visit(AvailabilityVersionRestriction entity) {
        entity.getPlatform().accept(wGetVisitor1());
        entity.getVersion().accept(wGetVisitor1());
    }

    public void visit(VersionTuple entity) {
        entity.getMajorMinor().accept(wGetVisitor1());
        entity.getPatchPeriod().accept(wGetVisitor1());
        entity.getPatchVersion().accept(wGetVisitor1());
    }

    public void visit(Trivia entity) {
        for (int i = 0; i < entity.size(); i++)
            entity.get(i).accept(wGetVisitor1());
    }
}
