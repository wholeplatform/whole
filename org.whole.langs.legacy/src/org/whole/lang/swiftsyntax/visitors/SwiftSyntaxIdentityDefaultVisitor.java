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

/**
 *  @generator Whole
 */
public class SwiftSyntaxIdentityDefaultVisitor extends SwiftSyntaxIdentityVisitor {

    public void visit(ISwiftSyntaxEntity entity) {
    }

    public void visit(Syntax entity) {
    }

    public void visit(SyntaxCollection entity) {
        visit((Syntax) entity);
    }

    public void visit(Decl entity) {
        visit((Syntax) entity);
    }

    public void visit(Expr entity) {
        visit((Syntax) entity);
    }

    public void visit(Pattern entity) {
        visit((Syntax) entity);
    }

    public void visit(Stmt entity) {
        visit((Syntax) entity);
    }

    public void visit(Type entity) {
        visit((Syntax) entity);
    }

    public void visit(Token entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(UnknownDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(UnknownExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(UnknownPattern entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(UnknownStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(UnknownType entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Type) entity);
    }

    public void visit(CodeBlockItem entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(CodeBlockItemList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(CodeBlock entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(InOutExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(PoundColumnExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(FunctionCallArgumentList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(TupleElementList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(ArrayElementList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(DictionaryElementList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(AbstractSegment entity) {
        visit((Syntax) entity);
    }

    public void visit(StringLiteralSegments entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(TryExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(DeclNameArgument entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(DeclNameArgumentList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(DeclNameArguments entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(IdentifierExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(SuperRefExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(NilLiteralExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(DiscardAssignmentExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(AssignmentExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(SequenceExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(ExprList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(PoundLineExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(PoundFileExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(PoundFunctionExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(PoundDsohandleExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(SymbolicReferenceExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(PrefixOperatorExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(BinaryOperatorExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(ArrowExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(FloatLiteralExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(TupleExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(ArrayExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(DictionaryExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(FunctionCallArgument entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(TupleElement entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ArrayElement entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(DictionaryElement entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(IntegerLiteralExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(BooleanLiteralExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(TernaryExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(MemberAccessExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(IsExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(AsExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(TypeExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(ClosureCaptureItem entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ClosureCaptureItemList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(ClosureCaptureSignature entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ClosureParam entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ClosureParamList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(ClosureSignature entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ClosureExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(UnresolvedPatternExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(FunctionCallExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(SubscriptExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(OptionalChainingExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(ForcedValueExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(PostfixUnaryExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(SpecializeExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(StringSegment entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
        visit((AbstractSegment) entity);
    }

    public void visit(ExpressionSegment entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
        visit((AbstractSegment) entity);
    }

    public void visit(StringLiteralExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(KeyPathExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(KeyPathBaseExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(ObjcNamePiece entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ObjcName entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(ObjcKeyPathExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(ObjcSelectorExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(EditorPlaceholderExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(ObjectLiteralExpr entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Expr) entity);
    }

    public void visit(TypeInitializerClause entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(TypealiasDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(AssociatedtypeDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(FunctionParameterList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(ParameterClause entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ReturnClause entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(FunctionSignature entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(IfConfigClause entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(IfConfigClauseList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(IfConfigDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
        visit((AbstractSwitchCase) entity);
    }

    public void visit(AbstractSwitchCase entity) {
        visit((Syntax) entity);
    }

    public void visit(PoundErrorDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(PoundWarningDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(PoundSourceLocation entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(PoundSourceLocationArgs entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(DeclModifier entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(InheritedType entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(InheritedTypeList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(TypeInheritanceClause entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ClassDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(StructDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(ProtocolDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(ExtensionDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(MemberDeclBlock entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(MemberDeclList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(MemberDeclListItem entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(SourceFile entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(InitializerClause entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(FunctionParameter entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ModifierList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(FunctionDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(InitializerDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(DeinitializerDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(SubscriptDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(AccessLevelModifier entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(AccessPathComponent entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(AccessPath entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(ImportDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(AccessorParameter entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(AccessorDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(AccessorList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(AccessorBlock entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(PatternBinding entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(PatternBindingList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(VariableDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(EnumCaseElement entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(EnumCaseElementList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(EnumCaseDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(EnumDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(OperatorDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(IdentifierList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(OperatorPrecedenceAndTypes entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(PrecedenceGroupDecl entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Decl) entity);
    }

    public void visit(AbstractPrecedenceGroupAttribute entity) {
        visit((Syntax) entity);
    }

    public void visit(PrecedenceGroupAttributeList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(PrecedenceGroupRelation entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
        visit((AbstractPrecedenceGroupAttribute) entity);
    }

    public void visit(PrecedenceGroupNameList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(PrecedenceGroupNameElement entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(PrecedenceGroupAssignment entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
        visit((AbstractPrecedenceGroupAttribute) entity);
    }

    public void visit(PrecedenceGroupAssociativity entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
        visit((AbstractPrecedenceGroupAttribute) entity);
    }

    public void visit(TokenList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(CustomAttribute entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
        visit((AbstractAttribute) entity);
    }

    public void visit(AbstractAttribute entity) {
        visit((Syntax) entity);
    }

    public void visit(Attribute entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
        visit((AbstractAttribute) entity);
    }

    public void visit(AttributeList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(AbstractSpecializeAttribute entity) {
        visit((Syntax) entity);
    }

    public void visit(SpecializeAttributeSpecList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(LabeledSpecializeEntry entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
        visit((AbstractSpecializeAttribute) entity);
    }

    public void visit(NamedAttributeStringArgument entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(DeclName entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ImplementsAttributeArguments entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ObjCSelectorPiece entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ObjCSelector entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(ContinueStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(WhileStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(DeferStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(SwitchCaseList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(RepeatWhileStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(GuardStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(WhereClause entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ForInStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(SwitchStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(CatchClauseList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(DoStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(ReturnStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(YieldStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(YieldList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(FallthroughStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(BreakStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(CaseItemList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(ConditionElement entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(AvailabilityCondition entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(MatchingPatternCondition entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(OptionalBindingCondition entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ConditionElementList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(ThrowStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(IfStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(SwitchCase entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
        visit((AbstractSwitchCase) entity);
    }

    public void visit(SwitchDefaultLabel entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(CaseItem entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(SwitchCaseLabel entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(CatchClause entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(PoundAssertStmt entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Stmt) entity);
    }

    public void visit(GenericWhereClause entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
        visit((AbstractSpecializeAttribute) entity);
    }

    public void visit(AbstractGenericRequirement entity) {
        visit((Syntax) entity);
    }

    public void visit(GenericRequirementList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(SameTypeRequirement entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
        visit((AbstractGenericRequirement) entity);
    }

    public void visit(GenericParameterList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(GenericParameter entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(GenericParameterClause entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ConformanceRequirement entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
        visit((AbstractGenericRequirement) entity);
    }

    public void visit(SimpleTypeIdentifier entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Type) entity);
    }

    public void visit(MemberTypeIdentifier entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Type) entity);
    }

    public void visit(ClassRestrictionType entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Type) entity);
    }

    public void visit(ArrayType entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Type) entity);
    }

    public void visit(DictionaryType entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Type) entity);
    }

    public void visit(MetatypeType entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Type) entity);
    }

    public void visit(OptionalType entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Type) entity);
    }

    public void visit(SomeType entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Type) entity);
    }

    public void visit(ImplicitlyUnwrappedOptionalType entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Type) entity);
    }

    public void visit(CompositionTypeElement entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(CompositionTypeElementList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(CompositionType entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Type) entity);
    }

    public void visit(TupleTypeElement entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(TupleTypeElementList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(TupleType entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Type) entity);
    }

    public void visit(FunctionType entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Type) entity);
    }

    public void visit(AttributedType entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Type) entity);
    }

    public void visit(GenericArgumentList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(GenericArgument entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(GenericArgumentClause entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(TypeAnnotation entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(EnumCasePattern entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(IsTypePattern entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(OptionalPattern entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(IdentifierPattern entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(AsTypePattern entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(TuplePattern entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(WildcardPattern entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(TuplePatternElement entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(ExpressionPattern entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(TuplePatternElementList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(ValueBindingPattern entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Pattern) entity);
    }

    public void visit(AvailabilitySpecList entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((SyntaxCollection) entity);
    }

    public void visit(AvailabilityArgument entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(AvailabilityLabeledArgument entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(AvailabilityVersionRestriction entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(VersionTuple entity) {
        visit((ISwiftSyntaxEntity) entity);
        visit((Syntax) entity);
    }

    public void visit(TokenKind entity) {
        visit((ISwiftSyntaxEntity) entity);
    }

    public void visit(Text entity) {
        visit((ISwiftSyntaxEntity) entity);
    }

    public void visit(Trivia entity) {
        visit((ISwiftSyntaxEntity) entity);
    }

    public void visit(TriviaPiece entity) {
        visit((ISwiftSyntaxEntity) entity);
    }

    public void visit(SourcePresence entity) {
        visit((ISwiftSyntaxEntity) entity);
    }
}
