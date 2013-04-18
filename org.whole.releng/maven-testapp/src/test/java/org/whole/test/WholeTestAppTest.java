package org.whole.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class WholeTestAppTest extends TestCase {
    public WholeTestAppTest( String testName ) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( WholeTestAppTest.class );
    }

    public void testApp() {
	try {
            WholeTestApp.main(new String[0]);
	} catch (Exception e) {
            fail();
	}
    }
}
