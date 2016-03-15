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
package org.whole.lang.resources;

/**
 * @author Riccardo Solmi
 */
public abstract class AbstractResourceInfo implements IResourceInfo {
	protected IResourceInfo nextResourceInfo;

	protected AbstractResourceInfo(IResourceInfo nextResourceInfo) {
		this.nextResourceInfo = nextResourceInfo;
	}

	protected abstract String getFeature(String name, String value);

	public String getURI(String uri) {
		String value = getFeature("uri", uri);
		return value != null ? value : nextResourceInfo.getURI(uri);
	}
	public void setURI(String uri) {
	}

	public String getNamespace(String namespace) {
		String value = getFeature("namespace", namespace);
		return value != null ? value : nextResourceInfo.getNamespace(namespace);
	}
	public void setNamespace(String namespace) {
	}

	public String getName(String name) {
		String value = getFeature("name", name);
		return value != null ? value : nextResourceInfo.getName(name);
	}
	public void setName(String name) {
	}

	public String getVersion(String version) {
		String value = getFeature("version", version);
		return value != null ? value : nextResourceInfo.getVersion(version);
	}
	public void setVersion(String version) {
	}
}
