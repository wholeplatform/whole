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
package org.whole.lang.artifacts.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator Whole
 */
public class ArtifactsFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int metadata_ord = 0;
    public static final int projects_ord = 1;
    public static final int name_ord = 2;
    public static final int natures_ord = 3;
    public static final int artifacts_ord = 4;
    public static final int locationURI_ord = 5;
    public static final int content_ord = 6;
    public static final int copyright_ord = 7;
    public static final int license_ord = 8;
    public static final int author_ord = 9;
    public static final int attributes_ord = 10;
    public static final int persistenceKitId_ord = 11;
    public static final int extension_ord = 12;
    public static final ArtifactsFeatureDescriptorEnum instance = new ArtifactsFeatureDescriptorEnum();
    public static final FeatureDescriptor metadata = instance.valueOf(metadata_ord);
    public static final FeatureDescriptor projects = instance.valueOf(projects_ord);
    public static final FeatureDescriptor name = instance.valueOf(name_ord);
    public static final FeatureDescriptor natures = instance.valueOf(natures_ord);
    public static final FeatureDescriptor artifacts = instance.valueOf(artifacts_ord);
    public static final FeatureDescriptor locationURI = instance.valueOf(locationURI_ord);
    public static final FeatureDescriptor content = instance.valueOf(content_ord);
    public static final FeatureDescriptor copyright = instance.valueOf(copyright_ord);
    public static final FeatureDescriptor license = instance.valueOf(license_ord);
    public static final FeatureDescriptor author = instance.valueOf(author_ord);
    public static final FeatureDescriptor attributes = instance.valueOf(attributes_ord);
    public static final FeatureDescriptor persistenceKitId = instance.valueOf(persistenceKitId_ord);
    public static final FeatureDescriptor extension = instance.valueOf(extension_ord);

    private ArtifactsFeatureDescriptorEnum() {
        putFeatureDescriptor(metadata_ord, "metadata");
        putFeatureDescriptor(projects_ord, "projects");
        putFeatureDescriptor(name_ord, "name");
        putFeatureDescriptor(natures_ord, "natures");
        putFeatureDescriptor(artifacts_ord, "artifacts");
        putFeatureDescriptor(locationURI_ord, "locationURI");
        putFeatureDescriptor(content_ord, "content");
        putFeatureDescriptor(copyright_ord, "copyright");
        putFeatureDescriptor(license_ord, "license");
        putFeatureDescriptor(author_ord, "author");
        putFeatureDescriptor(attributes_ord, "attributes");
        putFeatureDescriptor(persistenceKitId_ord, "persistenceKitId");
        putFeatureDescriptor(extension_ord, "extension");
    }
    private static final long serialVersionUID = 1;
}
