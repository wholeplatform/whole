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
package org.whole.lang.artifacts.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.whole.lang.artifacts.reflect.ArtifactsEntityDescriptorEnum;
import org.whole.lang.artifacts.reflect.ArtifactsFeatureDescriptorEnum;
import org.whole.lang.ui.notations.NotationImages;
import org.whole.lang.ui.templates.AbstractUITemplate;
import org.whole.lang.ui.templates.IOutlineBuilder;
import org.whole.lang.ui.templates.IPaletteBuilder;
import org.whole.lang.ui.templates.OutlineKinds;

/**
 * @author Riccardo Solmi
 */
public class ArtifactsOutlineUITemplate extends AbstractUITemplate {
	protected void applyOutlineOnly(IOutlineBuilder builder) {
		builder.Template(ArtifactsEntityDescriptorEnum.Workspace,
				"Workspace", ImageDescriptor.createFromImage(NotationImages.WORKSPACE16),
				OutlineKinds.COMPOSITE_NODE, true, ArtifactsFeatureDescriptorEnum.projects);
		builder.Template(ArtifactsEntityDescriptorEnum.Project,
				ImageDescriptor.createFromImage(NotationImages.PROJECT16),
				OutlineKinds.COMPOSITE_NODE, true, ArtifactsFeatureDescriptorEnum.name, ArtifactsFeatureDescriptorEnum.artifacts);
		builder.Template(ArtifactsEntityDescriptorEnum.FolderArtifact,
				ImageDescriptor.createFromImage(NotationImages.FOLDER16),
				OutlineKinds.COMPOSITE_NODE, true, ArtifactsFeatureDescriptorEnum.name, ArtifactsFeatureDescriptorEnum.artifacts);
		builder.Template(ArtifactsEntityDescriptorEnum.PackageArtifact,
				ImageDescriptor.createFromImage(NotationImages.PACKAGE_OBJ),
				OutlineKinds.COMPOSITE_NODE, false, ArtifactsFeatureDescriptorEnum.name, ArtifactsFeatureDescriptorEnum.artifacts);
		builder.Template(ArtifactsEntityDescriptorEnum.FileArtifact,
				ImageDescriptor.createFromImage(NotationImages.FILE16),
				OutlineKinds.SIMPLE_NODE, false, ArtifactsFeatureDescriptorEnum.name, ArtifactsFeatureDescriptorEnum.content);
	}

	public void applyPalette(IPaletteBuilder builder) {
		builder.Drawer_("Artifacts");
		builder.Template(ArtifactsEntityDescriptorEnum.Project,
				"Project", "create a Project artifact",
				ImageDescriptor.createFromImage(NotationImages.PROJECT16),
				ImageDescriptor.createFromImage(NotationImages.PROJECT16));
		builder.Template(ArtifactsEntityDescriptorEnum.FolderArtifact,
				"Folder", "create a Folder artifact",
				ImageDescriptor.createFromImage(NotationImages.FOLDER16),
				ImageDescriptor.createFromImage(NotationImages.FOLDER16));
		builder.Template(ArtifactsEntityDescriptorEnum.PackageArtifact,
				"Package", "create a Package artifact",
				ImageDescriptor.createFromImage(NotationImages.PACKAGE_OBJ),
				ImageDescriptor.createFromImage(NotationImages.PACKAGE_OBJ));
		builder.Template(ArtifactsEntityDescriptorEnum.FileArtifact,
				"File", "create a File artifact",
				ImageDescriptor.createFromImage(NotationImages.FILE16),
				ImageDescriptor.createFromImage(NotationImages.FILE16));
		builder._Drawer();
	}
}
