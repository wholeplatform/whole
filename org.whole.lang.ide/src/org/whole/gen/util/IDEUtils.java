/**
 * Copyright 2004-2014 Riccardo Solmi. All rights reserved.
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
package org.whole.gen.util;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.ToolFactory;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.formatter.CodeFormatter;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.text.edits.TextEdit;
import org.eclipse.ui.dialogs.ElementTreeSelectionDialog;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;
import org.eclipse.ui.views.navigator.ResourceComparator;
import org.whole.lang.bindings.IBindingManager;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.ui.controls.JavaSourceFolderFilter;
import org.whole.lang.ui.controls.JavaSourceFolderValidator;

/**
 * @author Riccardo Solmi, Enrico Persiani
 */
public class IDEUtils {
    public static ClassLoader getIDEClassLoader(IBindingManager bm, boolean override) {
    	IJavaProject javaProject = (IJavaProject) bm.wGetValue("javaProject");
    	return javaProject != null ? createClassLoader(javaProject, override) : ReflectionFactory.getClassLoader(bm);
    }

	public static String asString(ASTNode astNode) {
		return astNode.toString();
	}
	public static Document asDocument(ASTNode astNode) {
		return new Document(asString(astNode));
	}
	public static String asFormattedString(ASTNode astNode) {
		return asFormattedDocument(astNode, CodeFormatter.K_UNKNOWN).get();
	}
	public static String asFormattedString(CompilationUnit cu) {
		return asFormattedDocument(cu).get();
	}
	public static Document asFormattedDocument(CompilationUnit cu) {
		return asFormattedDocument(cu, CodeFormatter.K_COMPILATION_UNIT);
	}
	public static Document asFormattedDocument(Statement stm) {
		return asFormattedDocument(stm, CodeFormatter.K_STATEMENTS);
	}
	public static Document asFormattedDocument(Expression exp) {
		return asFormattedDocument(exp, CodeFormatter.K_EXPRESSION);
	}
	@SuppressWarnings("unchecked")
	public static Document asFormattedDocument(ASTNode astNode, int kind) {
		String source = asString(astNode);
		Document document = new Document(source);

		Map<String, String> options = JavaCore.getOptions();
		options.put(JavaCore.COMPILER_SOURCE, "1.5");
		options.put(JavaCore.COMPILER_COMPLIANCE, "1.5");
		options.put(JavaCore.COMPILER_CODEGEN_TARGET_PLATFORM, "1.5");

		CodeFormatter formatter = ToolFactory.createCodeFormatter(options);
		TextEdit textEdit = formatter.format(kind, source, 0, source.length(), 0, null);
		try {
			textEdit.apply(document);
		} catch (Exception e) {
			throw new IllegalArgumentException();
		}
		return document;
	}

	public static String getTypeName(CompilationUnit cu) {
		if (cu.types().isEmpty())
			return "";
		String packageName = cu.getPackage().getName().toString();
		String typeName = ((TypeDeclaration)cu.types().get(0)).getName().getIdentifier();
		return packageName+"."+typeName;
	}

	public static void save(CompilationUnit cu, IPackageFragmentRoot packageFragmentRoot, IProgressMonitor monitor) throws JavaModelException {
		if (cu.types().isEmpty())
			return;
		String packageName = cu.getPackage().getName().toString();
		String typeName = ((TypeDeclaration)cu.types().get(0)).getName().getIdentifier();

		IPackageFragment packageFragment = packageFragmentRoot.createPackageFragment(packageName, true, monitor);
		packageFragment.createCompilationUnit(typeName+".java", asFormattedString(cu), true, monitor);
	}

	public static IPackageFragmentRoot getPackageFragmentRoot(Shell shell) {
		IContainer[] containers = openJavaSourceFoldersDialog(shell, false);
		if (containers.length == 0)
			return null;
		return JDTUtils.getPackageFragmentRoot(containers[0]);
	}
	public static IContainer[] openJavaSourceFoldersDialog(Shell shell, boolean allowMultipleSelection) {
		ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
				shell, new WorkbenchLabelProvider(), new WorkbenchContentProvider());
		dialog.setValidator(new JavaSourceFolderValidator());
		dialog.setTitle("Java Source Folder Selection");
		dialog.setMessage("Choose a destination folder for generated code");
		dialog.addFilter(new JavaSourceFolderFilter());
		dialog.setInput(JDTUtils.getWorkspaceRoot());
		dialog.setComparator(new ResourceComparator(ResourceComparator.NAME));
		dialog.setAllowMultiple(allowMultipleSelection);

		if (dialog.open() == Window.OK) {
			Object[] elements = dialog.getResult();
			IContainer[] containers = new IContainer[elements.length];
			for (int i=0; i<containers.length; i++)
				containers[i]= (IContainer) elements[i];
			return containers;
		}
		return new IContainer[0];
	}


	public static String getCompilationUnitName(IFile compilationUnitFile) {
		IProject prj = compilationUnitFile.getProject();

		try {
			if (!prj.hasNature(JavaCore.NATURE_ID))
				return null;

			IJavaProject jProject = JavaCore.create(prj);

			IClasspathEntry cpes[] = jProject.getResolvedClasspath(true);
			for (IClasspathEntry cpe : cpes) {
				IPath filePath = compilationUnitFile.getFullPath();
				IPath cpePath = cpe.getPath();
				if (cpe.getEntryKind() == IClasspathEntry.CPE_SOURCE && cpePath.isPrefixOf(filePath)) {
					IPath path = filePath.removeFirstSegments(cpePath.segmentCount()).removeFileExtension();
					StringBuilder sb = new StringBuilder();
					String[] segments = path.segments();
					for (int i=0; i<segments.length; i++) {
						if (i>0)
							sb.append('.');
						sb.append(segments[i]);
					}
					return sb.toString();
				}
			}
		} catch (CoreException e) {
			throw new IllegalArgumentException("Cannot retrieve "+compilationUnitFile+" fully qualified class name", e);
		}
		throw new IllegalArgumentException("Missing top-level type declaration in "+compilationUnitFile);
	}

	public static Class<?> loadCompilationUnit(IBindingManager bm) {
		IFile compilationUnitFile = (IFile) bm.wGetValue("file");
		ClassLoader ideClassLoader = ReflectionFactory.getClassLoader(bm);
		return loadCompilationUnit(compilationUnitFile, ideClassLoader);
	}
	public static Class<?> loadCompilationUnit(IFile compilationUnitFile, ClassLoader classLoader) {
		IProject project = compilationUnitFile.getProject();

		try {
			if (!project.hasNature(JavaCore.NATURE_ID))
				return null;


			IJavaElement javaElement = JavaCore.create(compilationUnitFile);
			if(javaElement instanceof ICompilationUnit) {
				ICompilationUnit compilationUnit = ((ICompilationUnit)javaElement);
				IType[] types = compilationUnit.getTypes();
				for(IType type : types) {
					Class<?> clazz = classLoader.loadClass(type.getFullyQualifiedName());
					if(clazz != null && !clazz.isAnonymousClass() && !clazz.isMemberClass())
						return clazz;
				}
			}
		} catch (Exception e) {
		}
		return null;
	}

	public static ClassLoader createClassLoader(IJavaProject javaProject, boolean override) {
		ClassLoader platformClassLoader = ReflectionFactory.getPlatformClassLoader();
		String outputLocation = null;
		String[] projectClassPath;
		try {
			IPath outputPath = javaProject.getOutputLocation();
			if (override && outputPath != null)
				outputLocation = ResourcesPlugin.getWorkspace().getRoot().getFolder(outputPath).getLocation().toPortableString();
			projectClassPath = JavaRuntime.computeDefaultRuntimeClassPath(javaProject);
		} catch (CoreException e) {
			return platformClassLoader;
		}

		List<URL> projectCPEntries = new ArrayList<URL>(projectClassPath.length);
		for(int i=0; i<projectClassPath.length; i++) {
			try {
				projectCPEntries.add(new File(projectClassPath[i]).toURI().toURL());
			} catch (MalformedURLException e) {
			}
		}
		return new URLClassLoader(projectCPEntries.toArray(new URL[0]), 
				outputLocation != null ?
						new FilteringClassLoader(new FolderClassFilter(outputLocation), platformClassLoader) :
						platformClassLoader);
	}
	
	public static IJavaProject getJavaProject(IProject project) {
		try {
			return JavaCore.create(project);
		} catch (Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	public static IJavaProject getJavaProject(String projectName) {
		return getJavaProject(ResourcesPlugin.getWorkspace().getRoot().getProject(projectName));
	}
}
