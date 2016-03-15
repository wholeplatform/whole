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
package org.whole.lang.builders;

import org.whole.lang.reflect.EntityDescriptor;
import org.whole.lang.reflect.ILanguageKit;
import org.whole.lang.util.StringUtils;

/**
 * @author Riccardo Solmi
 */
public class BuilderConstants {
    
    public static final String buildContextName = "c";

    public static final String builderType(ILanguageKit languageKit) {
		String builderType = languageKit.getClass().getName();
    	int i = builderType.lastIndexOf("reflect");
    	builderType = builderType.substring(0, i)+"builders.I"+languageKit.getName()+"Builder";
    	return builderType;
    }

    public static final String resultTypeName() {
        return "void";
    }

    public static final String startBuildName() {
        return "wEntity_";
    }
    public static final String startBuildName(String type) {
    	return StringUtils.toSimpleName(type)+"_";
    }
    public static final String startBuildName(EntityDescriptor<?> entityDesc) {
        return entityDesc.getImplName()+"_";
    }

    public static final String endBuildName() {
        return "_wEntity";
    }
    public static final String endBuildName(String type) {
    	return "_"+StringUtils.toSimpleName(type);
    }
    public static final String endBuildName(EntityDescriptor<?> entityDesc) {
        return "_"+entityDesc.getImplName();
    }

    public static final String buildName() {
        return "wEntity";
    }
    public static final String buildName(String type) {
    	return StringUtils.toSimpleName(type);
    }
    public static final String buildName(EntityDescriptor<?> entityDesc) {
        return entityDesc.getImplName();
    }

    public static final String defaultBuildName() {
        return "wDefault";
    }

    public static final String selectName() {
        return "wFeature";
    }
}
