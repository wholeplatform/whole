/**
 * Copyright 2004-2016 Riccardo Solmi. All rights reserved.
 * This file is part of the Whole Platform.
 *
 * The Whole Platform is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * The Whole Platform is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with the Whole Platform. If not, see <http://www.gnu.org/licenses/>.
 */
package org.whole.lang.java.util;

import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.BooleanLiteral;
import org.eclipse.jdt.core.dom.CastExpression;
import org.eclipse.jdt.core.dom.CharacterLiteral;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.DoStatement;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.FieldAccess;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ForStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.InfixExpression;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.NullLiteral;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.PostfixExpression;
import org.eclipse.jdt.core.dom.PrefixExpression;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.ReturnStatement;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.SuperFieldAccess;
import org.eclipse.jdt.core.dom.SuperMethodInvocation;
import org.eclipse.jdt.core.dom.ThisExpression;
import org.eclipse.jdt.core.dom.ThrowStatement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.TypeLiteral;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
import org.whole.lang.builders.ModelBuilder;
import org.whole.lang.java.builders.IJavaBuilder;
import org.whole.lang.java.builders.JavaSpecificBuilderAdapter;
import org.whole.lang.java.parsers.JavaDataTypePersistenceParser;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.EntityDescriptor;

/**
 * @author Riccardo Solmi
 */
public class JDT2JavaBuilder extends ASTVisitor {
	private IJavaBuilder builder;

	public JDT2JavaBuilder(IJavaBuilder builder) {
    	this.builder = builder;
    }
    public static void transform(ASTNode model, IJavaBuilder builder) {
        JDT2JavaBuilder transformer = new JDT2JavaBuilder(builder);
        model.accept(transformer);
    }
    public static IEntity transform(ASTNode model) {
    	JavaSpecificBuilderAdapter builder = new JavaSpecificBuilderAdapter(new ModelBuilder());
    	transform(model, builder);
        return builder.wGetResult();
    }


	protected boolean acceptChild(ASTNode child) {
		if (child == null) {
			builder.wDefault();
			return false;
		}

		child.accept(this);
		return true;
	}    
    protected void acceptChildren(List children) {
    	for (int i=0; i<children.size(); i++)
    		((ASTNode) children.get(i)).accept(this);
    }
    protected void acceptChildren(List children, EntityDescriptor entityDesc) {
    	builder.wEntity_(entityDesc);
    	for (int i=0; i<children.size(); i++)
    		((ASTNode) children.get(i)).accept(this);
    	builder._wEntity(entityDesc);
    }

	public boolean visit(CompilationUnit node) {
		builder.CompilationUnit_();
		acceptChild(node.getPackage());
		acceptChildren(node.imports(), JavaEntityDescriptorEnum.ImportDeclarations);
		acceptChildren(node.types(), JavaEntityDescriptorEnum.TypeDeclarations);
		builder._CompilationUnit();
		return false;
	}

	public boolean visit(PackageDeclaration node) {
		builder.PackageDeclaration_();
		return true;
	}
	public void endVisit(PackageDeclaration node) {
		builder._PackageDeclaration();
	}

	public boolean visit(SimpleName node) {
		builder.SimpleName(node.getIdentifier());
		return false;
	}
	public boolean visit(QualifiedName node) {
		builder.QualifiedName(node.getFullyQualifiedName());
		return false;
	}

	public boolean visit(SimpleType node) {
		builder.SimpleType(node.getName().getFullyQualifiedName());
		return false;
	}
	public boolean visit(PrimitiveType node) {
	    builder.PrimitiveType(node.getPrimitiveTypeCode().toString());
		return false;
	}

	public boolean visit(NumberLiteral node) {
		String token = node.getToken();
		try {
			builder.IntLiteral(Integer.parseInt(token));
		} catch (NumberFormatException e) {
			try {
				builder.LongLiteral(Long.parseLong(token));
			} catch (NumberFormatException g) {
				try {
					builder.FloatLiteral(Float.parseFloat(token));
				} catch (NumberFormatException h) {
					try {
						builder.DoubleLiteral(Double.parseDouble(token));
					} catch (NumberFormatException m) {
						try {
							builder.ByteLiteral(Byte.parseByte(token));
						} catch (NumberFormatException n) {
							builder.ShortLiteral(Short.parseShort(token));
						}
					}
				}
			}
		}
		return false;
	}
	public boolean visit(NullLiteral node) {
		builder.NullLiteral();
		return false;
	}
	public boolean visit(BooleanLiteral node) {
		builder.BooleanLiteral(node.booleanValue());
	    return false;
	}
	public boolean visit(CharacterLiteral node) {
	    builder.CharLiteral(node.charValue());
	    return false;
	}
	public boolean visit(StringLiteral node) {
	    builder.StringLiteral(node.getLiteralValue());
		return false;
	}

	public boolean visit(ImportDeclaration node) {
		builder.ImportDeclaration_();
		return true;
	}
	public void endVisit(ImportDeclaration node) {
		builder._ImportDeclaration();
	}

	public boolean visit(TypeDeclaration node) {
		if (node.isInterface()) {
			builder.InterfaceDeclaration_();
			acceptChild(node.getName());
			acceptChildren(node.typeParameters(), JavaEntityDescriptorEnum.TypeParameters);
			acceptChild(node.getSuperclassType());
			builder.wDefault();
			acceptChildren(node.superInterfaceTypes(), JavaEntityDescriptorEnum.Types);
			acceptChildren(node.bodyDeclarations(), JavaEntityDescriptorEnum.BodyDeclarations);
			builder._InterfaceDeclaration();
		} else {
			builder.ClassDeclaration_();
			acceptChild(node.getName());
			acceptChildren(node.typeParameters(), JavaEntityDescriptorEnum.TypeParameters);
			acceptChild(node.getSuperclassType());
			builder.wDefault();
			acceptChildren(node.superInterfaceTypes(), JavaEntityDescriptorEnum.Types);
			acceptChildren(node.bodyDeclarations(), JavaEntityDescriptorEnum.BodyDeclarations);
			builder._ClassDeclaration();			
		}
	    return false;
	}

	public boolean visit(FieldDeclaration node) {
		builder.FieldDeclaration_();
	    acceptChild(node.getType());
	    acceptChildren(node.fragments(), JavaEntityDescriptorEnum.VariableDeclarationFragments);
		builder._FieldDeclaration();
	    return false;
	}

	public boolean visit(MethodDeclaration node) {
		if (node.isConstructor()) {
			builder.ConstructorDeclaration_();
			builder.wDefault();
			acceptChild(node.getReturnType2());
			builder.wDefault();
			acceptChild(node.getName());
		    acceptChildren(node.parameters(), JavaEntityDescriptorEnum.Parameters);
			builder.wDefault();
			acceptChild(node.getBody());		
			builder._ConstructorDeclaration();
		} else {
			builder.MethodDeclaration_();
			builder.wDefault();
			acceptChild(node.getReturnType2());
			builder.wDefault();
			acceptChild(node.getName());
		    acceptChildren(node.parameters(), JavaEntityDescriptorEnum.Parameters);
			builder.wDefault();
			acceptChild(node.getBody());		
			builder._MethodDeclaration();			
		}
		return false;
	}

	public boolean visit(SingleVariableDeclaration node) {
		builder.SingleVariableDeclaration_();
		return true;
	}
	public void endVisit(SingleVariableDeclaration node) {
		builder._SingleVariableDeclaration();
	}
	
	public boolean visit(Block node) {
	    acceptChildren(node.statements(), JavaEntityDescriptorEnum.Block);
	    return false;
	}

	public boolean visit(IfStatement node) {
		builder.IfStatement_();
		return true;
	}
	public void endVisit(IfStatement node) {
		builder._IfStatement();
	}

	public boolean visit(WhileStatement node) {
		builder.WhileStatement_();
		return true;
	}
	public void endVisit(WhileStatement node) {
		builder._WhileStatement();
	}

	public boolean visit(DoStatement node) {
		builder.DoStatement_();
		return true;
	}
	public void endVisit(DoStatement node) {
		builder._DoStatement();
	}
	public boolean visit(ForStatement node) {
		builder.ForStatement_();
		acceptChildren(node.initializers(), JavaEntityDescriptorEnum.Expressions);
	    acceptChild(node.getExpression());
		acceptChildren(node.updaters(), JavaEntityDescriptorEnum.Expressions);
	    acceptChild(node.getBody());
		builder._ForStatement();
	    return false;
	}

	public boolean visit(ReturnStatement node) {
		builder.ReturnStatement_();
		return true;
	}
	public void endVisit(ReturnStatement node) {
		builder._ReturnStatement();
	}

	public boolean visit(ThrowStatement node) {
		builder.ThrowStatement_();
		return true;
	}
	public void endVisit(ThrowStatement node) {
		builder._ThrowStatement();
	}
	
	public boolean visit(ExpressionStatement node) {
		builder.ExpressionStatement_();
		return true;
	}
	public void endVisit(ExpressionStatement node) {
		builder._ExpressionStatement();
	}
	
	public boolean visit(Assignment node) {
		builder.Assignment_();
	    acceptChild(node.getLeftHandSide());
		builder.AssignmentOperator(JavaDataTypePersistenceParser.parseAssignmentOperator(node.getOperator().toString()));
	    acceptChild(node.getRightHandSide());
		builder._Assignment();
		return false;
	}
	
	public boolean visit(InfixExpression node) {
		builder.InfixExpression_();
	    acceptChild(node.getLeftOperand());
		builder.InfixOperator(JavaDataTypePersistenceParser.parseInfixOperator(node.getOperator().toString()));
	    acceptChild(node.getRightOperand());
	    acceptChildren(node.extendedOperands(), JavaEntityDescriptorEnum.Expressions);
		builder._InfixExpression();
		return false;
	}
	
	public boolean visit(PostfixExpression node) {
		builder.PostfixExpression_();
	    acceptChild(node.getOperand());
		builder.PostfixOperator(JavaDataTypePersistenceParser.parsePostfixOperator(node.getOperator().toString()));
		builder._PostfixExpression();
		return false;
	}
	public boolean visit(PrefixExpression node) {
		builder.PrefixExpression_();
	    acceptChild(node.getOperand());
		builder.PrefixOperator(JavaDataTypePersistenceParser.parsePrefixOperator(node.getOperator().toString()));
		builder._PrefixExpression();
		return false;
	}

	public boolean visit(MethodInvocation node) {
		builder.MethodInvocation_();
	    builder.wDefault();
		acceptChild(node.getExpression());
	    acceptChild(node.getName());
	    acceptChildren(node.arguments(), JavaEntityDescriptorEnum.Arguments);
		builder._MethodInvocation();
		return false;
	}

	public boolean visit(SuperMethodInvocation node) {
		builder.SuperMethodInvocation_();
		acceptChild(node.getQualifier());
	    builder.wDefault();
	    acceptChild(node.getName());
	    acceptChildren(node.arguments(), JavaEntityDescriptorEnum.Arguments);
		builder._SuperMethodInvocation();
		return false;
	}

	public boolean visit(ClassInstanceCreation node) {
		builder.ClassInstanceCreation_();
	    acceptChild(node.getExpression());
	    builder.wDefault();
	    builder.wDefault();
	    acceptChild(node.getType());
	    acceptChildren(node.arguments(), JavaEntityDescriptorEnum.Arguments);
	    acceptChild(node.getAnonymousClassDeclaration());
	    builder._ClassInstanceCreation();
	    return false;
	}

	public boolean visit(CastExpression node) {
		builder.CastExpression_();
		return true;
	}
	public void endVisit(CastExpression node) {
		builder._CastExpression();
	}

	public boolean visit(TypeLiteral node) {
		builder.TypeLiteral_();
		return true;
	}
	public void endVisit(TypeLiteral node) {
		builder._TypeLiteral();
	}

	public boolean visit(ThisExpression node) {
		builder.ThisExpression_();
		return true;
	}
	public void endVisit(ThisExpression node) {
		builder._ThisExpression();
	}

	public boolean visit(SuperFieldAccess node) {
		builder.SuperFieldAccess_();
		return true;
	}
	public void endVisit(SuperFieldAccess node) {
		builder._SuperFieldAccess();
	}

	public boolean visit(FieldAccess node) {
		builder.FieldAccess_();
		return true;
	}
	public void endVisit(FieldAccess node) {
		builder._FieldAccess();
	}

	public boolean visit(VariableDeclarationExpression node) {
		builder.VariableDeclarationExpression_();
	    acceptChild(node.getType());
	    acceptChildren(node.fragments(), JavaEntityDescriptorEnum.VariableDeclarationFragments);
		builder._VariableDeclarationExpression();
		return false;
	}

	public boolean visit(VariableDeclarationStatement node) {
		builder.VariableDeclarationStatement_();
	    acceptChild(node.getType());
	    acceptChildren(node.fragments(), JavaEntityDescriptorEnum.VariableDeclarationFragments);
		builder._VariableDeclarationStatement();
		return false;
	}

	public boolean visit(VariableDeclarationFragment node) {
		builder.VariableDeclarationFragment_();
		return true;
	}
	public void endVisit(VariableDeclarationFragment node) {
		builder._VariableDeclarationFragment();
	}
}
