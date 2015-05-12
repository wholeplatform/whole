/**
 * Copyright 2004-2015 Riccardo Solmi. All rights reserved.
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
package org.whole.test;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runners.Suite;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerBuilder;

/**
 * @author Riccardo Solmi
 * 
 * FIXME workaround to fix class initialization when run as JUnit Plug-in Test
 */
public class MultipleCategories extends Suite {
    public MultipleCategories(Class<?> klass, RunnerBuilder builder)
            throws InitializationError {
        super(klass, builder);
        try {
            filter(new Categories.CategoryFilter(getIncludedCategory(klass),
                    getExcludedCategory(klass)));
        } catch (NoTestsRemainException e) {
            throw new InitializationError(e);
        }
//FIXME		assertNoCategorizedDescendentsOfUncategorizeableParents(getDescription());
    }

    private Class<?> getIncludedCategory(Class<?> klass) {
        IncludeCategory annotation = klass.getAnnotation(IncludeCategory.class);
        return annotation == null ? null : annotation.value();
    }

    private Class<?> getExcludedCategory(Class<?> klass) {
        ExcludeCategory annotation = klass.getAnnotation(ExcludeCategory.class);
        return annotation == null ? null : annotation.value();
    }
}
