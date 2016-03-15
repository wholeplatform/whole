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
package org.whole.lang.reflect;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Riccardo Solmi
 */
public class LazyLanguageDeployer extends AbstractLazyDeployer {
	private Set<String> uris = new HashSet<String>();
	private Set<String> names = new HashSet<String>();

	public LazyLanguageDeployer(IDeployer deployer) {
		super(deployer);
	}
	public LazyLanguageDeployer(IDeployer deployer, String uri, String name) {
		super(deployer);
		uris.add(uri);
		names.add(name);
	}
	public LazyLanguageDeployer withUris(String... uri) {
		uris.addAll(Arrays.asList(uri));
		return this;
	}
	public LazyLanguageDeployer withNames(String... name) {
		names.addAll(Arrays.asList(name));
		return this;
	}
	
	public Collection<String> getLanguagesURIs(Collection<String> collection) {
		Collection<String> languagesURIs = super.getLanguagesURIs(collection);
		languagesURIs.addAll(uris);
		return languagesURIs;
	}
	public Collection<String> getLanguagesNames(Collection<String> collection) {
		Collection<String> languagesNames = super.getLanguagesNames(collection);
		languagesNames.addAll(names);
		return languagesNames;
	}

	public boolean containsLanguage(String languageURI) {
		return uris.contains(languageURI) || super.containsLanguage(languageURI);
	}
	public boolean deployLanguage(String languageURI) {
		if (!uris.contains(languageURI))
			return super.deployLanguage(languageURI);
		
		ReflectionFactory.deploy(deployer);
		return true;
	}
	public boolean undeployLanguage(String languageURI) {
		if (!uris.contains(languageURI))
			return super.undeployLanguage(languageURI);

		ReflectionFactory.undeploy(deployer);
		return true;
	}
}
