package testClasses;

import com.google.common.reflect.ClassPath;
import driver.Browser;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        //Get all test classes
        final ClassLoader loader = Thread.currentThread().getContextClassLoader();
        List<Class<?>> testClasses = new ArrayList<>();

        for (ClassPath.ClassInfo info : ClassPath.from(loader).getTopLevelClasses()) {
            String classInfoName = info.getName();
            boolean startWithTestDot = classInfoName.startsWith("testClasses.");
            boolean isBaseTestClass = classInfoName.startsWith("testClasses.BaseTest");
            boolean isMainTestClass = classInfoName.startsWith("testClasses.Main");

            if (startWithTestDot && !isBaseTestClass && !isMainTestClass) {
                testClasses.add(info.load());
            }
        }

        //Get browser
        String browser = System.getProperty("browser");
//        String browser = System.getenv("browser");
        if (browser == null) {
            throw new IllegalArgumentException("[ERR] Please provide the browser via -Dbrowser");
        }

        try {
            Browser.valueOf(browser);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERR] We don't support browser " + browser+ ", supported browser: " + Arrays.toString(Browser.values()));
        }

        //Assign test classes to browser
//        final int testNumForBrowser = testClasses.size();
        Map<String, List<Class<?>>> desireCaps = new HashMap<>();
        desireCaps.put(browser,testClasses);

        //Build Test suite
        TestNG testNG = new TestNG();
        XmlSuite suite = new XmlSuite();
        suite.setName("Configure SES WEB/IdP");

        List<XmlTest> allTests = new ArrayList<>();
        for (String browserNames : desireCaps.keySet()) {
            XmlTest test = new XmlTest(suite);
            test.setName(browserNames);
            List<XmlClass> xmlClasses =new ArrayList<>();
            List<Class<?>> delicatedClasses=desireCaps.get(browserNames);
            for (Class<?> delicatedClass : delicatedClasses) {
                xmlClasses.add(new XmlClass(delicatedClass.getName()));
            }
            test.setXmlClasses(xmlClasses);
            test.addParameter("browser",browser);
            allTests.add(test);
        }
        suite.setTests(allTests);
        System.out.println(suite.toXml());

        //Add Testsuite into suite list
        List<XmlSuite> suites=new ArrayList<>();
        suites.add(suite);

        //invoke run method
        testNG.setXmlSuites(suites);
        testNG.run();



    }
}
