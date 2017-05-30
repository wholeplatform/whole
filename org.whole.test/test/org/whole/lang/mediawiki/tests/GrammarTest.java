package org.whole.lang.mediawiki.tests;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.whole.lang.tests.junit.EntityMatchers.*;
import org.junit.*;
import org.whole.lang.bindings.*;
import org.whole.lang.model.IEntity;
import org.whole.lang.reflect.ReflectionFactory;
import org.whole.lang.tests.junit.TestCase;

public class GrammarTest extends TestCase {

    @BeforeClass
    public static void wholeDeploy() {
        ReflectionFactory.deploy(new Deployer());
        bindGrammar();
    }

    @AfterClass
    public static void wholeUndeploy() {
        ReflectionFactory.undeploy(new Deployer());
    }

    protected static class Deployer extends org.whole.lang.reflect.AbstractContributionDeployer {

        public void deploy(ReflectionFactory platform) {
            evaluate("fragment");
        }
    }

    protected static IEntity create(String templateName) {
        return GrammarTestTemplateManager.instance().create(templateName);
    }

    protected static IEntity evaluate(String templateName) {
        return evaluate(create(templateName));
    }

    protected static IEntity evaluateInScope(String templateName) {
        return evaluate(create(templateName), false);
    }

    /**
     *
     */
    static public void bindGrammar() {
        evaluateInScope("fragment1");
    }

    /**
     *
     */
    @Test
    public void testTable() {
        ITransactionScope ts = BindingManagerFactory.instance.createTransactionScope();
        try {
            bindings().wEnterScope(ts);
            IEntity subject;
            subject = evaluate("fragment2");
            assertThat("at /testCases/0/tests/0/body/0", subject, matches(evaluate("fragment3")));
            subject = evaluate("fragment4");
            assertThat("at /testCases/0/tests/0/body/1", subject, matches(evaluate("fragment5")));
            subject = evaluate("fragment6");
            assertThat("at /testCases/0/tests/0/body/2", subject, matches(evaluate("fragment7")));
            subject = evaluate("fragment8");
            assertThat("at /testCases/0/tests/0/body/3", subject, matches(evaluate("fragment9")));
            subject = evaluate("fragment10");
            assertThat("at /testCases/0/tests/0/body/4", subject, matches(evaluate("fragment11")));
            subject = evaluate("fragment12");
            assertThat("at /testCases/0/tests/0/body/5", subject, matches(evaluate("fragment13")));
            subject = evaluate("fragment14");
            assertThat("at /testCases/0/tests/0/body/6", subject, matches(evaluate("fragment15")));
            subject = evaluate("fragment16");
            assertThat("at /testCases/0/tests/0/body/7", subject, matches(evaluate("fragment17")));
            subject = evaluate("fragment18");
            assertThat("at /testCases/0/tests/0/body/8", subject, matches(evaluate("fragment19")));
            subject = evaluate("fragment20");
            assertThat("at /testCases/0/tests/0/body/9", subject, matches(evaluate("fragment21")));
            subject = evaluate("fragment22");
            assertThat("at /testCases/0/tests/0/body/10", subject, matches(evaluate("fragment23")));
            subject = evaluate("fragment24");
            assertThat("at /testCases/0/tests/0/body/11", subject, matches(evaluate("fragment25")));
            subject = evaluate("fragment26");
            assertThat("at /testCases/0/tests/0/body/12", subject, matches(evaluate("fragment27")));
            subject = evaluate("fragment28");
            assertThat("at /testCases/0/tests/0/body/13", subject, matches(evaluate("fragment29")));
            subject = evaluate("fragment30");
            assertThat("at /testCases/0/tests/0/body/14", subject, matches(evaluate("fragment31")));
            subject = evaluate("fragment32");
            assertThat("at /testCases/0/tests/0/body/15", subject, matches(evaluate("fragment33")));
        } finally {
            ts.rollback();
            bindings().wExitScope();
        }
    }
}
