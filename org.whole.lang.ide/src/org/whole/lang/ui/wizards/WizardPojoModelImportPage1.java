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
package org.whole.lang.ui.wizards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaElementComparator;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jdt.ui.StandardJavaElementContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.whole.gen.util.JDTUtils;
import org.whole.lang.commons.factories.CommonsEntityAdapterFactory;
import org.whole.lang.iterators.IEntityIterator;
import org.whole.lang.iterators.IteratorFactory;
import org.whole.lang.java.codebase.JavaSourceTemplateFactory;
import org.whole.lang.java.model.BodyDeclarations;
import org.whole.lang.java.model.CompilationUnit;
import org.whole.lang.java.model.TypeDeclaration;
import org.whole.lang.java.reflect.JavaEntityDescriptorEnum;
import org.whole.lang.misc.factories.MiscEntityFactory;
import org.whole.lang.misc.model.Any;
import org.whole.lang.misc.model.Misc;
import org.whole.lang.misc.reflect.MiscEntityDescriptorEnum;
import org.whole.lang.model.IEntity;
import org.whole.lang.pojo.util.PojoMappingUtils;
import org.whole.lang.ui.controls.JavaClassFileFilter;

/**
 * @author Enrico Persiani
 */
public class WizardPojoModelImportPage1 extends AbstractWizardWholeModelImportPage {
	protected TreeViewer resourceChooser;

	public WizardPojoModelImportPage1(IWorkbench workbench, IStructuredSelection selection) {
		super("pojoModelImportPage1", workbench, selection);
		setTitle("Import Pojo Model");
		setDescription("Import a set of Java classes into a Pojo model");
	}

	@Override
	protected IEntity buildModel() {
		ISelection selection = resourceChooser.getSelection();
		Misc compilationUnits = getCompilationUnits(selection);
		return PojoMappingUtils.getLibrary(compilationUnits, "SamplePojo");
	}

	@Override
	protected void createSourceGroup(Composite parent) {
		resourceChooser = new TreeViewer(parent);
		GridLayout listAreaLayout = new GridLayout();
		listAreaLayout.marginWidth = 0;
		parent.setLayout(listAreaLayout);
		resourceChooser.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		resourceChooser.setContentProvider(new StandardJavaElementContentProvider());
		resourceChooser.setLabelProvider(new JavaElementLabelProvider());
		resourceChooser.setComparator(new JavaElementComparator());
		resourceChooser.addFilter(new JavaClassFileFilter());
		resourceChooser.setInput(JavaCore.create(ResourcesPlugin.getWorkspace().getRoot()));
		resourceChooser.addSelectionChangedListener(new ISelectionChangedListener() {
			public void selectionChanged(SelectionChangedEvent event) {
				updatePageCompletion();
			}
		});
	}

	@Override
	protected boolean determinePageCompletion() {
		if (!super.determinePageCompletion())
			return false;

		if(resourceChooser == null)
			return false;

		IStructuredSelection selection = (IStructuredSelection) resourceChooser.getSelection();
		Iterator<?> iterator = selection.iterator();
		while (iterator.hasNext()) {
				Object selectedElement = iterator.next();
			if (!(selectedElement instanceof ITypeRoot)) {
				setErrorMessage("All selected elements must be Java source or class files");
				return false;
			}
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public static Misc getCompilationUnits(ISelection selection) {
		List<ITypeRoot> typeRoots = Collections.emptyList();
		if (!selection.isEmpty())
			typeRoots = ((IStructuredSelection) selection).toList();
		return getCompilationUnits(typeRoots);
	}

	public static Misc getCompilationUnits(List<ITypeRoot> elements) {
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		MiscEntityFactory mef = MiscEntityFactory.instance;
		Misc misc = mef.createMisc(0);

		elements = new ArrayList<ITypeRoot>(elements);
		Iterator<ITypeRoot> iterator = elements.iterator();
		while (iterator.hasNext()) {
			ITypeRoot typeRoot = iterator.next();
			IType type = typeRoot.findPrimaryType();

			try {
				boolean isMember = type.isMember();
				boolean isAnonymous = type.isAnonymous();
				// remove any member class but map only the named ones
				
				if (isMember || isAnonymous)
					iterator.remove();
				if (!isMember || type.getElementName().contains("Impl"))
					continue;
			} catch (JavaModelException e) {
			}

			String declaringTypeName = type.getDeclaringType().getFullyQualifiedName();
			List<String> memeberTypes = map.get(declaringTypeName);
			if (memeberTypes == null)
				map.put(declaringTypeName, memeberTypes = new ArrayList<String>());
			memeberTypes.add(typeRoot.findPrimaryType().getElementName());
		}

		for (ITypeRoot typeRoot : elements) {
			Class<?> clazz;
			try {
				clazz = Class.forName(typeRoot.findPrimaryType().getFullyQualifiedName(), false, JDTUtils.createClassLoader(typeRoot.getJavaProject(), true));
				if (clazz.getAnnotation(Deprecated.class) != null)
					continue;
			} catch (ClassNotFoundException e) {
				continue;
			}
			JavaSourceTemplateFactory templateFactory = new JavaSourceTemplateFactory(typeRoot) {
				@Override
				protected void init(String sourceAttachment, String className, IJavaProject javaProject) {
					//FIXME implement import inlining
					super.init(/* ensure reflection is used */ null, className, javaProject);
					if (clazz.getAnnotation(Deprecated.class) != null)
						;
				}
			};
			templateFactory.useCanonicalNames(false);
			CompilationUnit compilationUnit = templateFactory.create();

			String compilationUnitName = typeRoot.findPrimaryType().getFullyQualifiedName();
			if (map.containsKey(compilationUnitName)) {
				List<String> memberNames = map.get(compilationUnitName);
				BodyDeclarations bodyDeclarations = compilationUnit.getTypes().get(0).getBodyDeclarations();
				IEntityIterator<TypeDeclaration> entityIterator = IteratorFactory.<TypeDeclaration>childMatcherIterator()
						.withPattern(JavaEntityDescriptorEnum.TypeDeclaration);
				entityIterator.reset(bodyDeclarations);
				while (entityIterator.hasNext()) 
					if (!memberNames.contains(entityIterator.next().getName().getValue()))
						entityIterator.remove();
			}
			Any stageUpFragment = CommonsEntityAdapterFactory.createStageUpFragment(MiscEntityDescriptorEnum.Any, compilationUnit);
			misc.wAdd(stageUpFragment);
		}
		return misc;
	}
}
