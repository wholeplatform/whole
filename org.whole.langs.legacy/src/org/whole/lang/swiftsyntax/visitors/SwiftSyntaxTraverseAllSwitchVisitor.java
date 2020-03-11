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
import org.whole.lang.visitors.IVisitor;
import org.whole.lang.swiftsyntax.model.*;

/**
 *  @generator Whole
 */
public class SwiftSyntaxTraverseAllSwitchVisitor extends SwiftSyntaxIdentityUnaryVisitor<IVisitor> {

    public SwiftSyntaxTraverseAllSwitchVisitor(IVisitor visitor1) {
        super(visitor1);
    }

    public void visit(Token entity) {
        wGetVisitor1().visit(entity.getKind());
        wGetVisitor1().visit(entity.getPresence());
        wGetVisitor1().visit(entity.getLeadingTrivia());
        wGetVisitor1().visit(entity.getTrailingTrivia());
        wGetVisitor1().visit(entity.getText());
    }

    public void visit(UnknownDecl entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(UnknownExpr entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(UnknownPattern entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(UnknownStmt entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(UnknownType entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(CodeBlockItem entity) {
        wGetVisitor1().visit(entity.getItem());
        wGetVisitor1().visit(entity.getSemicolon());
        wGetVisitor1().visit(entity.getErrorTokens());
    }

    public void visit(CodeBlockItemList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(CodeBlock entity) {
        wGetVisitor1().visit(entity.getLeftBrace());
        wGetVisitor1().visit(entity.getStatements());
        wGetVisitor1().visit(entity.getRightBrace());
    }

    public void visit(InOutExpr entity) {
        wGetVisitor1().visit(entity.getAmpersand());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(PoundColumnExpr entity) {
        wGetVisitor1().visit(entity.getPoundColumn());
    }

    public void visit(FunctionCallArgumentList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(TupleElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ArrayElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(DictionaryElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(StringLiteralSegments entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(TryExpr entity) {
        wGetVisitor1().visit(entity.getTryKeyword());
        wGetVisitor1().visit(entity.getQuestionOrExclamationMark());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(DeclNameArgument entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getColon());
    }

    public void visit(DeclNameArgumentList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(DeclNameArguments entity) {
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getArguments());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(IdentifierExpr entity) {
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getDeclNameArguments());
    }

    public void visit(SuperRefExpr entity) {
        wGetVisitor1().visit(entity.getSuperKeyword());
    }

    public void visit(NilLiteralExpr entity) {
        wGetVisitor1().visit(entity.getNilKeyword());
    }

    public void visit(DiscardAssignmentExpr entity) {
        wGetVisitor1().visit(entity.getWildcard());
    }

    public void visit(AssignmentExpr entity) {
        wGetVisitor1().visit(entity.getAssignToken());
    }

    public void visit(SequenceExpr entity) {
        wGetVisitor1().visit(entity.getElements());
    }

    public void visit(ExprList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(PoundLineExpr entity) {
        wGetVisitor1().visit(entity.getPoundLine());
    }

    public void visit(PoundFileExpr entity) {
        wGetVisitor1().visit(entity.getPoundFile());
    }

    public void visit(PoundFunctionExpr entity) {
        wGetVisitor1().visit(entity.getPoundFunction());
    }

    public void visit(PoundDsohandleExpr entity) {
        wGetVisitor1().visit(entity.getPoundDsohandle());
    }

    public void visit(SymbolicReferenceExpr entity) {
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getGenericArgumentClause());
    }

    public void visit(PrefixOperatorExpr entity) {
        wGetVisitor1().visit(entity.getOperatorToken());
        wGetVisitor1().visit(entity.getPostfixExpression());
    }

    public void visit(BinaryOperatorExpr entity) {
        wGetVisitor1().visit(entity.getOperatorToken());
    }

    public void visit(ArrowExpr entity) {
        wGetVisitor1().visit(entity.getThrowsToken());
        wGetVisitor1().visit(entity.getArrowToken());
    }

    public void visit(FloatLiteralExpr entity) {
        wGetVisitor1().visit(entity.getFloatingDigits());
    }

    public void visit(TupleExpr entity) {
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getElementList());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(ArrayExpr entity) {
        wGetVisitor1().visit(entity.getLeftSquare());
        wGetVisitor1().visit(entity.getElements());
        wGetVisitor1().visit(entity.getRightSquare());
    }

    public void visit(DictionaryExpr entity) {
        wGetVisitor1().visit(entity.getLeftSquare());
        wGetVisitor1().visit(entity.getContent());
        wGetVisitor1().visit(entity.getRightSquare());
    }

    public void visit(FunctionCallArgument entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(TupleElement entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(ArrayElement entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(DictionaryElement entity) {
        wGetVisitor1().visit(entity.getKeyExpression());
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getValueExpression());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(IntegerLiteralExpr entity) {
        wGetVisitor1().visit(entity.getDigits());
    }

    public void visit(BooleanLiteralExpr entity) {
        wGetVisitor1().visit(entity.getBooleanLiteral());
    }

    public void visit(TernaryExpr entity) {
        wGetVisitor1().visit(entity.getConditionExpression());
        wGetVisitor1().visit(entity.getQuestionMark());
        wGetVisitor1().visit(entity.getFirstChoice());
        wGetVisitor1().visit(entity.getColonMark());
        wGetVisitor1().visit(entity.getSecondChoice());
    }

    public void visit(MemberAccessExpr entity) {
        wGetVisitor1().visit(entity.getBase());
        wGetVisitor1().visit(entity.getDot());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getDeclNameArguments());
    }

    public void visit(IsExpr entity) {
        wGetVisitor1().visit(entity.getIsTok());
        wGetVisitor1().visit(entity.getTypeName());
    }

    public void visit(AsExpr entity) {
        wGetVisitor1().visit(entity.getAsTok());
        wGetVisitor1().visit(entity.getQuestionOrExclamationMark());
        wGetVisitor1().visit(entity.getTypeName());
    }

    public void visit(TypeExpr entity) {
        wGetVisitor1().visit(entity.getType());
    }

    public void visit(ClosureCaptureItem entity) {
        wGetVisitor1().visit(entity.getSpecifier());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getAssignToken());
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(ClosureCaptureItemList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ClosureCaptureSignature entity) {
        wGetVisitor1().visit(entity.getLeftSquare());
        wGetVisitor1().visit(entity.getItems());
        wGetVisitor1().visit(entity.getRightSquare());
    }

    public void visit(ClosureParam entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(ClosureParamList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ClosureSignature entity) {
        wGetVisitor1().visit(entity.getCapture());
        wGetVisitor1().visit(entity.getInput());
        wGetVisitor1().visit(entity.getThrowsTok());
        wGetVisitor1().visit(entity.getOutput());
        wGetVisitor1().visit(entity.getInTok());
    }

    public void visit(ClosureExpr entity) {
        wGetVisitor1().visit(entity.getLeftBrace());
        wGetVisitor1().visit(entity.getSignature());
        wGetVisitor1().visit(entity.getStatements());
        wGetVisitor1().visit(entity.getRightBrace());
    }

    public void visit(UnresolvedPatternExpr entity) {
        wGetVisitor1().visit(entity.getPattern());
    }

    public void visit(FunctionCallExpr entity) {
        wGetVisitor1().visit(entity.getCalledExpression());
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getArgumentList());
        wGetVisitor1().visit(entity.getRightParen());
        wGetVisitor1().visit(entity.getTrailingClosure());
    }

    public void visit(SubscriptExpr entity) {
        wGetVisitor1().visit(entity.getCalledExpression());
        wGetVisitor1().visit(entity.getLeftBracket());
        wGetVisitor1().visit(entity.getArgumentList());
        wGetVisitor1().visit(entity.getRightBracket());
        wGetVisitor1().visit(entity.getTrailingClosure());
    }

    public void visit(OptionalChainingExpr entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getQuestionMark());
    }

    public void visit(ForcedValueExpr entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getExclamationMark());
    }

    public void visit(PostfixUnaryExpr entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getOperatorToken());
    }

    public void visit(SpecializeExpr entity) {
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getGenericArgumentClause());
    }

    public void visit(StringSegment entity) {
        wGetVisitor1().visit(entity.getContent());
    }

    public void visit(ExpressionSegment entity) {
        wGetVisitor1().visit(entity.getBackslash());
        wGetVisitor1().visit(entity.getDelimiter());
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getExpressions());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(StringLiteralExpr entity) {
        wGetVisitor1().visit(entity.getOpenDelimiter());
        wGetVisitor1().visit(entity.getOpenQuote());
        wGetVisitor1().visit(entity.getSegments());
        wGetVisitor1().visit(entity.getCloseQuote());
        wGetVisitor1().visit(entity.getCloseDelimiter());
    }

    public void visit(KeyPathExpr entity) {
        wGetVisitor1().visit(entity.getBackslash());
        wGetVisitor1().visit(entity.getRootExpr());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(KeyPathBaseExpr entity) {
        wGetVisitor1().visit(entity.getPeriod());
    }

    public void visit(ObjcNamePiece entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getDot());
    }

    public void visit(ObjcName entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ObjcKeyPathExpr entity) {
        wGetVisitor1().visit(entity.getKeyPath());
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(ObjcSelectorExpr entity) {
        wGetVisitor1().visit(entity.getPoundSelector());
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getKind());
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(EditorPlaceholderExpr entity) {
        wGetVisitor1().visit(entity.getIdentifier());
    }

    public void visit(ObjectLiteralExpr entity) {
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getArguments());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(TypeInitializerClause entity) {
        wGetVisitor1().visit(entity.getEqual());
        wGetVisitor1().visit(entity.getValue());
    }

    public void visit(TypealiasDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getTypealiasKeyword());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getGenericParameterClause());
        wGetVisitor1().visit(entity.getInitializer());
        wGetVisitor1().visit(entity.getGenericWhereClause());
    }

    public void visit(AssociatedtypeDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getAssociatedtypeKeyword());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getInheritanceClause());
        wGetVisitor1().visit(entity.getInitializer());
        wGetVisitor1().visit(entity.getGenericWhereClause());
    }

    public void visit(FunctionParameterList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ParameterClause entity) {
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getParameterList());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(ReturnClause entity) {
        wGetVisitor1().visit(entity.getArrow());
        wGetVisitor1().visit(entity.getReturnType());
    }

    public void visit(FunctionSignature entity) {
        wGetVisitor1().visit(entity.getInput());
        wGetVisitor1().visit(entity.getThrowsOrRethrowsKeyword());
        wGetVisitor1().visit(entity.getOutput());
    }

    public void visit(IfConfigClause entity) {
        wGetVisitor1().visit(entity.getPoundKeyword());
        wGetVisitor1().visit(entity.getCondition());
        wGetVisitor1().visit(entity.getElements());
    }

    public void visit(IfConfigClauseList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(IfConfigDecl entity) {
        wGetVisitor1().visit(entity.getClauses());
        wGetVisitor1().visit(entity.getPoundEndif());
    }

    public void visit(PoundErrorDecl entity) {
        wGetVisitor1().visit(entity.getPoundError());
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getMessage());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(PoundWarningDecl entity) {
        wGetVisitor1().visit(entity.getPoundWarning());
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getMessage());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(PoundSourceLocation entity) {
        wGetVisitor1().visit(entity.getPoundSourceLocation());
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getArgs());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(PoundSourceLocationArgs entity) {
        wGetVisitor1().visit(entity.getFileArgLabel());
        wGetVisitor1().visit(entity.getFileArgColon());
        wGetVisitor1().visit(entity.getFileName());
        wGetVisitor1().visit(entity.getComma());
        wGetVisitor1().visit(entity.getLineArgLabel());
        wGetVisitor1().visit(entity.getLineArgColon());
        wGetVisitor1().visit(entity.getLineNumber());
    }

    public void visit(DeclModifier entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getDetailLeftParen());
        wGetVisitor1().visit(entity.getDetail());
        wGetVisitor1().visit(entity.getDetailRightParen());
    }

    public void visit(InheritedType entity) {
        wGetVisitor1().visit(entity.getTypeName());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(InheritedTypeList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(TypeInheritanceClause entity) {
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getInheritedTypeCollection());
    }

    public void visit(ClassDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getClassKeyword());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getGenericParameterClause());
        wGetVisitor1().visit(entity.getInheritanceClause());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getMembers());
    }

    public void visit(StructDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getStructKeyword());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getGenericParameterClause());
        wGetVisitor1().visit(entity.getInheritanceClause());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getMembers());
    }

    public void visit(ProtocolDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getProtocolKeyword());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getInheritanceClause());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getMembers());
    }

    public void visit(ExtensionDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getExtensionKeyword());
        wGetVisitor1().visit(entity.getExtendedType());
        wGetVisitor1().visit(entity.getInheritanceClause());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getMembers());
    }

    public void visit(MemberDeclBlock entity) {
        wGetVisitor1().visit(entity.getLeftBrace());
        wGetVisitor1().visit(entity.getMembers());
        wGetVisitor1().visit(entity.getRightBrace());
    }

    public void visit(MemberDeclList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(MemberDeclListItem entity) {
        wGetVisitor1().visit(entity.getDecl());
        wGetVisitor1().visit(entity.getSemicolon());
    }

    public void visit(SourceFile entity) {
        wGetVisitor1().visit(entity.getStatements());
        wGetVisitor1().visit(entity.getEofToken());
    }

    public void visit(InitializerClause entity) {
        wGetVisitor1().visit(entity.getEqual());
        wGetVisitor1().visit(entity.getValue());
    }

    public void visit(FunctionParameter entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getFirstName());
        wGetVisitor1().visit(entity.getSecondName());
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getEllipsis());
        wGetVisitor1().visit(entity.getDefaultArgument());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(ModifierList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(FunctionDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getFuncKeyword());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getGenericParameterClause());
        wGetVisitor1().visit(entity.getSignature());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(InitializerDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getInitKeyword());
        wGetVisitor1().visit(entity.getOptionalMark());
        wGetVisitor1().visit(entity.getGenericParameterClause());
        wGetVisitor1().visit(entity.getParameters());
        wGetVisitor1().visit(entity.getThrowsOrRethrowsKeyword());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(DeinitializerDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getDeinitKeyword());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(SubscriptDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getSubscriptKeyword());
        wGetVisitor1().visit(entity.getGenericParameterClause());
        wGetVisitor1().visit(entity.getIndices());
        wGetVisitor1().visit(entity.getResult());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getAccessor());
    }

    public void visit(AccessLevelModifier entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getModifier());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(AccessPathComponent entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getTrailingDot());
    }

    public void visit(AccessPath entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ImportDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getImportTok());
        wGetVisitor1().visit(entity.getImportKind());
        wGetVisitor1().visit(entity.getPath());
    }

    public void visit(AccessorParameter entity) {
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(AccessorDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifier());
        wGetVisitor1().visit(entity.getAccessorKind());
        wGetVisitor1().visit(entity.getParameter());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(AccessorList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(AccessorBlock entity) {
        wGetVisitor1().visit(entity.getLeftBrace());
        wGetVisitor1().visit(entity.getAccessors());
        wGetVisitor1().visit(entity.getRightBrace());
    }

    public void visit(PatternBinding entity) {
        wGetVisitor1().visit(entity.getPattern());
        wGetVisitor1().visit(entity.getTypeAnnotation());
        wGetVisitor1().visit(entity.getInitializer());
        wGetVisitor1().visit(entity.getAccessor());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(PatternBindingList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(VariableDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getLetOrVarKeyword());
        wGetVisitor1().visit(entity.getBindings());
    }

    public void visit(EnumCaseElement entity) {
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getAssociatedValue());
        wGetVisitor1().visit(entity.getRawValue());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(EnumCaseElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(EnumCaseDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getCaseKeyword());
        wGetVisitor1().visit(entity.getElements());
    }

    public void visit(EnumDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getEnumKeyword());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getGenericParameters());
        wGetVisitor1().visit(entity.getInheritanceClause());
        wGetVisitor1().visit(entity.getGenericWhereClause());
        wGetVisitor1().visit(entity.getMembers());
    }

    public void visit(OperatorDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getOperatorKeyword());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getOperatorPrecedenceAndTypes());
    }

    public void visit(IdentifierList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(OperatorPrecedenceAndTypes entity) {
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getPrecedenceGroupAndDesignatedTypes());
    }

    public void visit(PrecedenceGroupDecl entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getModifiers());
        wGetVisitor1().visit(entity.getPrecedencegroupKeyword());
        wGetVisitor1().visit(entity.getIdentifier());
        wGetVisitor1().visit(entity.getLeftBrace());
        wGetVisitor1().visit(entity.getGroupAttributes());
        wGetVisitor1().visit(entity.getRightBrace());
    }

    public void visit(PrecedenceGroupAttributeList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(PrecedenceGroupRelation entity) {
        wGetVisitor1().visit(entity.getHigherThanOrLowerThan());
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getOtherNames());
    }

    public void visit(PrecedenceGroupNameList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(PrecedenceGroupNameElement entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(PrecedenceGroupAssignment entity) {
        wGetVisitor1().visit(entity.getAssignmentKeyword());
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getFlag());
    }

    public void visit(PrecedenceGroupAssociativity entity) {
        wGetVisitor1().visit(entity.getAssociativityKeyword());
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getValue());
    }

    public void visit(TokenList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(CustomAttribute entity) {
        wGetVisitor1().visit(entity.getAtSignToken());
        wGetVisitor1().visit(entity.getAttributeName());
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getArgumentList());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(Attribute entity) {
        wGetVisitor1().visit(entity.getAtSignToken());
        wGetVisitor1().visit(entity.getAttributeName());
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getArgument());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(AttributeList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(SpecializeAttributeSpecList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(LabeledSpecializeEntry entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getValue());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(NamedAttributeStringArgument entity) {
        wGetVisitor1().visit(entity.getNameTok());
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getStringOrDeclname());
    }

    public void visit(DeclName entity) {
        wGetVisitor1().visit(entity.getDeclBaseName());
        wGetVisitor1().visit(entity.getDeclNameArguments());
    }

    public void visit(ImplementsAttributeArguments entity) {
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getComma());
        wGetVisitor1().visit(entity.getDeclBaseName());
        wGetVisitor1().visit(entity.getDeclNameArguments());
    }

    public void visit(ObjCSelectorPiece entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getColon());
    }

    public void visit(ObjCSelector entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ContinueStmt entity) {
        wGetVisitor1().visit(entity.getContinueKeyword());
        wGetVisitor1().visit(entity.getLabel());
    }

    public void visit(WhileStmt entity) {
        wGetVisitor1().visit(entity.getLabelName());
        wGetVisitor1().visit(entity.getLabelColon());
        wGetVisitor1().visit(entity.getWhileKeyword());
        wGetVisitor1().visit(entity.getConditions());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(DeferStmt entity) {
        wGetVisitor1().visit(entity.getDeferKeyword());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(SwitchCaseList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(RepeatWhileStmt entity) {
        wGetVisitor1().visit(entity.getLabelName());
        wGetVisitor1().visit(entity.getLabelColon());
        wGetVisitor1().visit(entity.getRepeatKeyword());
        wGetVisitor1().visit(entity.getBody());
        wGetVisitor1().visit(entity.getWhileKeyword());
        wGetVisitor1().visit(entity.getCondition());
    }

    public void visit(GuardStmt entity) {
        wGetVisitor1().visit(entity.getGuardKeyword());
        wGetVisitor1().visit(entity.getConditions());
        wGetVisitor1().visit(entity.getElseKeyword());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(WhereClause entity) {
        wGetVisitor1().visit(entity.getWhereKeyword());
        wGetVisitor1().visit(entity.getGuardResult());
    }

    public void visit(ForInStmt entity) {
        wGetVisitor1().visit(entity.getLabelName());
        wGetVisitor1().visit(entity.getLabelColon());
        wGetVisitor1().visit(entity.getForKeyword());
        wGetVisitor1().visit(entity.getCaseKeyword());
        wGetVisitor1().visit(entity.getPattern());
        wGetVisitor1().visit(entity.getTypeAnnotation());
        wGetVisitor1().visit(entity.getInKeyword());
        wGetVisitor1().visit(entity.getSequenceExpr());
        wGetVisitor1().visit(entity.getWhereClause());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(SwitchStmt entity) {
        wGetVisitor1().visit(entity.getLabelName());
        wGetVisitor1().visit(entity.getLabelColon());
        wGetVisitor1().visit(entity.getSwitchKeyword());
        wGetVisitor1().visit(entity.getExpression());
        wGetVisitor1().visit(entity.getLeftBrace());
        wGetVisitor1().visit(entity.getCases());
        wGetVisitor1().visit(entity.getRightBrace());
    }

    public void visit(CatchClauseList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(DoStmt entity) {
        wGetVisitor1().visit(entity.getLabelName());
        wGetVisitor1().visit(entity.getLabelColon());
        wGetVisitor1().visit(entity.getDoKeyword());
        wGetVisitor1().visit(entity.getBody());
        wGetVisitor1().visit(entity.getCatchClauses());
    }

    public void visit(ReturnStmt entity) {
        wGetVisitor1().visit(entity.getReturnKeyword());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(YieldStmt entity) {
        wGetVisitor1().visit(entity.getYieldKeyword());
        wGetVisitor1().visit(entity.getYields());
    }

    public void visit(YieldList entity) {
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getElementList());
        wGetVisitor1().visit(entity.getTrailingComma());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(FallthroughStmt entity) {
        wGetVisitor1().visit(entity.getFallthroughKeyword());
    }

    public void visit(BreakStmt entity) {
        wGetVisitor1().visit(entity.getBreakKeyword());
        wGetVisitor1().visit(entity.getLabel());
    }

    public void visit(CaseItemList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ConditionElement entity) {
        wGetVisitor1().visit(entity.getCondition());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(AvailabilityCondition entity) {
        wGetVisitor1().visit(entity.getPoundAvailableKeyword());
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getAvailabilitySpec());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(MatchingPatternCondition entity) {
        wGetVisitor1().visit(entity.getCaseKeyword());
        wGetVisitor1().visit(entity.getPattern());
        wGetVisitor1().visit(entity.getTypeAnnotation());
        wGetVisitor1().visit(entity.getInitializer());
    }

    public void visit(OptionalBindingCondition entity) {
        wGetVisitor1().visit(entity.getLetOrVarKeyword());
        wGetVisitor1().visit(entity.getPattern());
        wGetVisitor1().visit(entity.getTypeAnnotation());
        wGetVisitor1().visit(entity.getInitializer());
    }

    public void visit(ConditionElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ThrowStmt entity) {
        wGetVisitor1().visit(entity.getThrowKeyword());
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(IfStmt entity) {
        wGetVisitor1().visit(entity.getLabelName());
        wGetVisitor1().visit(entity.getLabelColon());
        wGetVisitor1().visit(entity.getIfKeyword());
        wGetVisitor1().visit(entity.getConditions());
        wGetVisitor1().visit(entity.getBody());
        wGetVisitor1().visit(entity.getElseKeyword());
        wGetVisitor1().visit(entity.getElseBody());
    }

    public void visit(SwitchCase entity) {
        wGetVisitor1().visit(entity.getUnknownAttr());
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getStatements());
    }

    public void visit(SwitchDefaultLabel entity) {
        wGetVisitor1().visit(entity.getDefaultKeyword());
        wGetVisitor1().visit(entity.getColon());
    }

    public void visit(CaseItem entity) {
        wGetVisitor1().visit(entity.getPattern());
        wGetVisitor1().visit(entity.getWhereClause());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(SwitchCaseLabel entity) {
        wGetVisitor1().visit(entity.getCaseKeyword());
        wGetVisitor1().visit(entity.getCaseItems());
        wGetVisitor1().visit(entity.getColon());
    }

    public void visit(CatchClause entity) {
        wGetVisitor1().visit(entity.getCatchKeyword());
        wGetVisitor1().visit(entity.getPattern());
        wGetVisitor1().visit(entity.getWhereClause());
        wGetVisitor1().visit(entity.getBody());
    }

    public void visit(PoundAssertStmt entity) {
        wGetVisitor1().visit(entity.getPoundAssert());
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getCondition());
        wGetVisitor1().visit(entity.getComma());
        wGetVisitor1().visit(entity.getMessage());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(GenericWhereClause entity) {
        wGetVisitor1().visit(entity.getWhereKeyword());
        wGetVisitor1().visit(entity.getRequirementList());
    }

    public void visit(GenericRequirementList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(SameTypeRequirement entity) {
        wGetVisitor1().visit(entity.getLeftTypeIdentifier());
        wGetVisitor1().visit(entity.getEqualityToken());
        wGetVisitor1().visit(entity.getRightTypeIdentifier());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(GenericParameterList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(GenericParameter entity) {
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getInheritedType());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(GenericParameterClause entity) {
        wGetVisitor1().visit(entity.getLeftAngleBracket());
        wGetVisitor1().visit(entity.getGenericParameterList());
        wGetVisitor1().visit(entity.getRightAngleBracket());
    }

    public void visit(ConformanceRequirement entity) {
        wGetVisitor1().visit(entity.getLeftTypeIdentifier());
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getRightTypeIdentifier());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(SimpleTypeIdentifier entity) {
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getGenericArgumentClause());
    }

    public void visit(MemberTypeIdentifier entity) {
        wGetVisitor1().visit(entity.getBaseType());
        wGetVisitor1().visit(entity.getPeriod());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getGenericArgumentClause());
    }

    public void visit(ClassRestrictionType entity) {
        wGetVisitor1().visit(entity.getClassKeyword());
    }

    public void visit(ArrayType entity) {
        wGetVisitor1().visit(entity.getLeftSquareBracket());
        wGetVisitor1().visit(entity.getElementType());
        wGetVisitor1().visit(entity.getRightSquareBracket());
    }

    public void visit(DictionaryType entity) {
        wGetVisitor1().visit(entity.getLeftSquareBracket());
        wGetVisitor1().visit(entity.getKeyType());
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getValueType());
        wGetVisitor1().visit(entity.getRightSquareBracket());
    }

    public void visit(MetatypeType entity) {
        wGetVisitor1().visit(entity.getBaseType());
        wGetVisitor1().visit(entity.getPeriod());
        wGetVisitor1().visit(entity.getTypeOrProtocol());
    }

    public void visit(OptionalType entity) {
        wGetVisitor1().visit(entity.getWrappedType());
        wGetVisitor1().visit(entity.getQuestionMark());
    }

    public void visit(SomeType entity) {
        wGetVisitor1().visit(entity.getSomeSpecifier());
        wGetVisitor1().visit(entity.getBaseType());
    }

    public void visit(ImplicitlyUnwrappedOptionalType entity) {
        wGetVisitor1().visit(entity.getWrappedType());
        wGetVisitor1().visit(entity.getExclamationMark());
    }

    public void visit(CompositionTypeElement entity) {
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getAmpersand());
    }

    public void visit(CompositionTypeElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(CompositionType entity) {
        wGetVisitor1().visit(entity.getElements());
    }

    public void visit(TupleTypeElement entity) {
        wGetVisitor1().visit(entity.getInOut());
        wGetVisitor1().visit(entity.getName());
        wGetVisitor1().visit(entity.getSecondName());
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getEllipsis());
        wGetVisitor1().visit(entity.getInitializer());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(TupleTypeElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(TupleType entity) {
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getElements());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(FunctionType entity) {
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getArguments());
        wGetVisitor1().visit(entity.getRightParen());
        wGetVisitor1().visit(entity.getThrowsOrRethrowsKeyword());
        wGetVisitor1().visit(entity.getArrow());
        wGetVisitor1().visit(entity.getReturnType());
    }

    public void visit(AttributedType entity) {
        wGetVisitor1().visit(entity.getSpecifier());
        wGetVisitor1().visit(entity.getAttributes());
        wGetVisitor1().visit(entity.getBaseType());
    }

    public void visit(GenericArgumentList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(GenericArgument entity) {
        wGetVisitor1().visit(entity.getArgumentType());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(GenericArgumentClause entity) {
        wGetVisitor1().visit(entity.getLeftAngleBracket());
        wGetVisitor1().visit(entity.getArguments());
        wGetVisitor1().visit(entity.getRightAngleBracket());
    }

    public void visit(TypeAnnotation entity) {
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getType());
    }

    public void visit(EnumCasePattern entity) {
        wGetVisitor1().visit(entity.getType());
        wGetVisitor1().visit(entity.getPeriod());
        wGetVisitor1().visit(entity.getCaseName());
        wGetVisitor1().visit(entity.getAssociatedTuple());
    }

    public void visit(IsTypePattern entity) {
        wGetVisitor1().visit(entity.getIsKeyword());
        wGetVisitor1().visit(entity.getType());
    }

    public void visit(OptionalPattern entity) {
        wGetVisitor1().visit(entity.getSubPattern());
        wGetVisitor1().visit(entity.getQuestionMark());
    }

    public void visit(IdentifierPattern entity) {
        wGetVisitor1().visit(entity.getIdentifier());
    }

    public void visit(AsTypePattern entity) {
        wGetVisitor1().visit(entity.getPattern());
        wGetVisitor1().visit(entity.getAsKeyword());
        wGetVisitor1().visit(entity.getType());
    }

    public void visit(TuplePattern entity) {
        wGetVisitor1().visit(entity.getLeftParen());
        wGetVisitor1().visit(entity.getElements());
        wGetVisitor1().visit(entity.getRightParen());
    }

    public void visit(WildcardPattern entity) {
        wGetVisitor1().visit(entity.getWildcard());
        wGetVisitor1().visit(entity.getTypeAnnotation());
    }

    public void visit(TuplePatternElement entity) {
        wGetVisitor1().visit(entity.getLabelName());
        wGetVisitor1().visit(entity.getLabelColon());
        wGetVisitor1().visit(entity.getPattern());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(ExpressionPattern entity) {
        wGetVisitor1().visit(entity.getExpression());
    }

    public void visit(TuplePatternElementList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(ValueBindingPattern entity) {
        wGetVisitor1().visit(entity.getLetOrVarKeyword());
        wGetVisitor1().visit(entity.getValuePattern());
    }

    public void visit(AvailabilitySpecList entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }

    public void visit(AvailabilityArgument entity) {
        wGetVisitor1().visit(entity.getEntry());
        wGetVisitor1().visit(entity.getTrailingComma());
    }

    public void visit(AvailabilityLabeledArgument entity) {
        wGetVisitor1().visit(entity.getLabel());
        wGetVisitor1().visit(entity.getColon());
        wGetVisitor1().visit(entity.getValue());
    }

    public void visit(AvailabilityVersionRestriction entity) {
        wGetVisitor1().visit(entity.getPlatform());
        wGetVisitor1().visit(entity.getVersion());
    }

    public void visit(VersionTuple entity) {
        wGetVisitor1().visit(entity.getMajorMinor());
        wGetVisitor1().visit(entity.getPatchPeriod());
        wGetVisitor1().visit(entity.getPatchVersion());
    }

    public void visit(Trivia entity) {
        for (int i = 0; i < entity.size(); i++)
            wGetVisitor1().visit(entity.get(i));
    }
}
