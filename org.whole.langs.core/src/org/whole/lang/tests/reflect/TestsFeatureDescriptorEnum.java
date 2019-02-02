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
package org.whole.lang.tests.reflect;

import org.whole.lang.reflect.FeatureDescriptorEnum;
import org.whole.lang.reflect.FeatureDescriptor;

/**
 *  @generator Whole
 */
public class TestsFeatureDescriptorEnum extends FeatureDescriptorEnum {
    public static final int packageName_ord = 0;
    public static final int description_ord = 1;
    public static final int name_ord = 2;
    public static final int deployer_ord = 3;
    public static final int filterFamilies_ord = 4;
    public static final int testCases_ord = 5;
    public static final int actualResults_ord = 6;
    public static final int expectedResults_ord = 7;
    public static final int filterRules_ord = 8;
    public static final int body_ord = 9;
    public static final int aspects_ord = 10;
    public static final int tests_ord = 11;
    public static final int actualResult_ord = 12;
    public static final int expectedResult_ord = 13;
    public static final int kind_ord = 14;
    public static final int filter_ord = 15;
    public static final int subjectStatement_ord = 16;
    public static final int subject_ord = 17;
    public static final int constraint_ord = 18;
    public static final int descriptorName_ord = 19;
    public static final int throwableType_ord = 20;
    public static final int object_ord = 21;
    public static final int successes_ord = 22;
    public static final int failures_ord = 23;
    public static final int errors_ord = 24;
    public static final int outcome_ord = 25;
    public static final int location_ord = 26;
    public static final int cause_ord = 27;
    public static final TestsFeatureDescriptorEnum instance = new TestsFeatureDescriptorEnum();
    public static final FeatureDescriptor packageName = instance.valueOf(packageName_ord);
    public static final FeatureDescriptor description = instance.valueOf(description_ord);
    public static final FeatureDescriptor name = instance.valueOf(name_ord);
    public static final FeatureDescriptor deployer = instance.valueOf(deployer_ord);
    public static final FeatureDescriptor filterFamilies = instance.valueOf(filterFamilies_ord);
    public static final FeatureDescriptor testCases = instance.valueOf(testCases_ord);
    public static final FeatureDescriptor actualResults = instance.valueOf(actualResults_ord);
    public static final FeatureDescriptor expectedResults = instance.valueOf(expectedResults_ord);
    public static final FeatureDescriptor filterRules = instance.valueOf(filterRules_ord);
    public static final FeatureDescriptor body = instance.valueOf(body_ord);
    public static final FeatureDescriptor aspects = instance.valueOf(aspects_ord);
    public static final FeatureDescriptor tests = instance.valueOf(tests_ord);
    public static final FeatureDescriptor actualResult = instance.valueOf(actualResult_ord);
    public static final FeatureDescriptor expectedResult = instance.valueOf(expectedResult_ord);
    public static final FeatureDescriptor kind = instance.valueOf(kind_ord);
    public static final FeatureDescriptor filter = instance.valueOf(filter_ord);
    public static final FeatureDescriptor subjectStatement = instance.valueOf(subjectStatement_ord);
    public static final FeatureDescriptor subject = instance.valueOf(subject_ord);
    public static final FeatureDescriptor constraint = instance.valueOf(constraint_ord);
    public static final FeatureDescriptor descriptorName = instance.valueOf(descriptorName_ord);
    public static final FeatureDescriptor throwableType = instance.valueOf(throwableType_ord);
    public static final FeatureDescriptor object = instance.valueOf(object_ord);
    public static final FeatureDescriptor successes = instance.valueOf(successes_ord);
    public static final FeatureDescriptor failures = instance.valueOf(failures_ord);
    public static final FeatureDescriptor errors = instance.valueOf(errors_ord);
    public static final FeatureDescriptor outcome = instance.valueOf(outcome_ord);
    public static final FeatureDescriptor location = instance.valueOf(location_ord);
    public static final FeatureDescriptor cause = instance.valueOf(cause_ord);

    private TestsFeatureDescriptorEnum() {
        putFeatureDescriptor(packageName_ord, "packageName");
        putFeatureDescriptor(description_ord, "description");
        putFeatureDescriptor(name_ord, "name");
        putFeatureDescriptor(deployer_ord, "deployer");
        putFeatureDescriptor(filterFamilies_ord, "filterFamilies");
        putFeatureDescriptor(testCases_ord, "testCases");
        putFeatureDescriptor(actualResults_ord, "actualResults");
        putFeatureDescriptor(expectedResults_ord, "expectedResults");
        putFeatureDescriptor(filterRules_ord, "filterRules");
        putFeatureDescriptor(body_ord, "body");
        putFeatureDescriptor(aspects_ord, "aspects");
        putFeatureDescriptor(tests_ord, "tests");
        putFeatureDescriptor(actualResult_ord, "actualResult");
        putFeatureDescriptor(expectedResult_ord, "expectedResult");
        putFeatureDescriptor(kind_ord, "kind");
        putFeatureDescriptor(filter_ord, "filter");
        putFeatureDescriptor(subjectStatement_ord, "subjectStatement");
        putFeatureDescriptor(subject_ord, "subject");
        putFeatureDescriptor(constraint_ord, "constraint");
        putFeatureDescriptor(descriptorName_ord, "descriptorName");
        putFeatureDescriptor(throwableType_ord, "throwableType");
        putFeatureDescriptor(object_ord, "object");
        putFeatureDescriptor(successes_ord, "successes");
        putFeatureDescriptor(failures_ord, "failures");
        putFeatureDescriptor(errors_ord, "errors");
        putFeatureDescriptor(outcome_ord, "outcome");
        putFeatureDescriptor(location_ord, "location");
        putFeatureDescriptor(cause_ord, "cause");
    }
    private static final long serialVersionUID = 1;
}
