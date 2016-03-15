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
package org.whole.lang.e4.ui.compatibility;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.content.IContentDescription;
import org.eclipse.core.runtime.content.IContentType;
import org.eclipse.e4.core.contexts.ContextFunction;
import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IURIEditorInput;
import org.whole.lang.codebase.FilePersistenceProvider;
import org.whole.lang.codebase.IFilePersistenceProvider;
import org.whole.lang.e4.ui.input.ModelInput;
import org.whole.lang.reflect.ReflectionFactory;

/**
 * @author Enrico Persiani
 */
public class ModelInputFunction extends ContextFunction {
	@Override
	public Object compute(IEclipseContext context) {
		final IEditorPart editorPart = context.get(IEditorPart.class);
		final IEditorInput input = context.get(IEditorInput.class);
		if (input instanceof IFileEditorInput) {
			IFile file = ((IFileEditorInput) input).getFile();
			IFilePersistenceProvider pp = new IFilePersistenceProvider(file);
			ModelInput modelInput = new ModelInput(context, pp, calculateBasePersistenceKitId(file));
			if (editorPart != null) {
				String editorId = editorPart.getSite().getId();
				String overridePersistenceKitId = ReflectionFactory.getPersistenceKitFromEditorId(editorId).getId();
				modelInput.setOverridePersistenceKitId(overridePersistenceKitId);
			}
			return modelInput;
		} else if (input instanceof IURIEditorInput) {
			File file = new File(((IURIEditorInput) input).getURI());
			FilePersistenceProvider pp = new FilePersistenceProvider(file);
			ModelInput modelInput = new ModelInput(context, pp, ReflectionFactory.getDefaultPersistenceKit().getId());
			if (editorPart != null) {
				String editorId = editorPart.getSite().getId();
				String overridePersistenceKitId = ReflectionFactory.getPersistenceKitFromEditorId(editorId).getId();
				modelInput.setOverridePersistenceKitId(overridePersistenceKitId);
			}
			return modelInput;
		} else
			return null;
	}

	protected String calculateBasePersistenceKitId(IFile file) {
		String basePersistenceKitId = ReflectionFactory.getDefaultPersistenceKit().getId();
		try {
			IContentDescription contentDescription = file.getContentDescription();
			if (contentDescription != null) {
				IContentType contentType = contentDescription.getContentType();
				if ("org.whole.ui.contenttype.contentTypes.xmlWhole".equals(contentType.getId()))
					basePersistenceKitId = "org.whole.lang.xml.codebase.XmlBuilderPersistenceKit";
			}
		} catch (CoreException e) {
		}
		return basePersistenceKitId;
	}
}
