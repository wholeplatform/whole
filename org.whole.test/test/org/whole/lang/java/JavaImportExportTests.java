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
package org.whole.lang.java;

import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.dom.ASTMatcher;
import org.eclipse.jdt.core.dom.CharacterLiteral;
import org.eclipse.jdt.core.dom.Comment;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.NumberLiteral;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.junit.BeforeClass;
import org.junit.Test;
import org.whole.gen.lang.reflect.GenOperationsDeployer;
import org.whole.gen.util.JDTUtils;
import org.whole.lang.java.util.JDTTransformerVisitor;
import org.whole.lang.model.IEntity;
import org.whole.lang.operations.PrettyPrinterOperation;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.util.StringUtils;

/**
 * Must be run as a JUnit Plug-in Test in an Eclipse with Whole plugins deployed
 * 
 * @author Enrico Persiani
 */
public class JavaImportExportTests {
    @BeforeClass
    public static void deployWholePlatform() {
    	ReflectionFactory.deployWholePlatform();
		ReflectionFactory.deploy(GenOperationsDeployer.class);
	}
	
	private int goodCounter = 0;
	private int wrongCounter = 0;
	private int badCounter = 0;
	@Test
    public void testSourceFolder() {
		IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
		File rootFolder = workspaceRoot.getLocation().toFile();
		performTest(rootFolder);
		System.out.printf("Summary: Good(%d) Wrong(%d) Bad(%d)\n", goodCounter, badCounter, wrongCounter);
	}

	@SuppressWarnings("unchecked")
    private boolean performTest(String source) throws Exception {
		CompilationUnit cu = JDTUtils.parseAsCompilationUnit(source);
		IEntity model = JDTTransformerVisitor.transform(source, cu);

		String newSource = PrettyPrinterOperation.toPrettyPrintString(model);
		CompilationUnit cuReparsed = JDTUtils.parseAsCompilationUnit(newSource);

		for (Comment element : (List<Comment>) cu.getCommentList())
			element.delete();

		boolean subtreeMatch = cu.subtreeMatch(new SemanticASTMatcher(), cuReparsed);
		return subtreeMatch;
	}

	private FileFilter fileFilter = new FileFilter() {
		public boolean accept(File pathname) {
			return pathname.isDirectory() || isJavaSource(pathname);
		}

		private boolean isJavaSource(File pathname) {
			return pathname.getName().matches(".*\\.java$");
		}
	};
	private void performTest(File rootFolder) {
		if (!rootFolder.canRead())
			return;
		for (File file : rootFolder.listFiles(fileFilter)) {
			if (file.isDirectory())
				performTest(file);
			else {
			    try {
			        FileReader rd = new FileReader(file);
			        char[] buf = new char[(int)file.length()];
			        rd.read(buf);
			        try {
			        	String source = new String(buf);
						boolean status = performTest(source);
			        	if (!status) {
			        		badCounter++;
			        		System.out.println("error converting "+file.getAbsolutePath());
			        	} else
			        		goodCounter++;
			        } catch (Exception e) {
			        	wrongCounter++;
			        	System.out.println("cannot convert "+file.getAbsolutePath());
			        }
			    } catch (IOException e) {
			    	System.out.println("I/O ERROR on "+file.getAbsolutePath());
			    }
			}
		}
	}

	private class SemanticASTMatcher extends ASTMatcher {
		@Override
		public boolean match(CharacterLiteral node, Object other) {
			if (!(other instanceof CharacterLiteral)) {
				return false;
			}
			CharacterLiteral o = (CharacterLiteral) other;
			return localSafeEquals(node.getEscapedValue(), o.getEscapedValue());
		}

		@Override
		public boolean match(NumberLiteral node, Object other) {
			if (!(other instanceof NumberLiteral)) {
				return false;
			}
			NumberLiteral o = (NumberLiteral) other;
			String token = node.getToken();
			String otherToken = o.getToken();
		
			boolean isIntegerToken = StringUtils.isJavaIntegerLiteral(token);
			boolean isIntegerOtherToken = StringUtils.isJavaIntegerLiteral(otherToken);
			
			if (isIntegerToken != isIntegerOtherToken)
				return false;
		
			if (isIntegerToken)
				return StringUtils.parseJavaIntegerLiteralType(token) == StringUtils.parseJavaIntegerLiteralType(otherToken);
			else
				return Double.parseDouble(token) == Double.parseDouble(otherToken);
		}

		@Override
		public boolean match(StringLiteral node, Object other) {
			if (!(other instanceof StringLiteral)) {
				return false;
			}
			StringLiteral o = (StringLiteral) other;
			return localSafeEquals(node.getEscapedValue(), o.getEscapedValue());
		}

		private boolean localSafeEquals(String escapedValue, String otherEscapedValue) {
			boolean matches = StringUtils.unescapeString(escapedValue).equals(StringUtils.unescapeString(otherEscapedValue));
			return matches;
		}
	}
}