
package finalprojectB;

import junit.framework.TestCase;

import java.util.Random;
import org.junit.Test;


//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   @Test
   public void testManualTest(){
       UrlValidator urlTest = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
       String testString = "http://www.google.com";
       boolean result = urlTest.isValid(testString);
       assertEquals(true,result);
       System.out.println("Passed " + testString + " as " + result);
       //True Tests
       testString = "http://www.google.com:80/test1?action=view";
       result = urlTest.isValid(testString);
       assertEquals(true,result);
       System.out.println("Passed " + testString + " as " + result);

       testString = "ftp://0.0.0.0:0?action=edit&mode=up";
       result = urlTest.isValid(testString);
       assertEquals(true,result);
       System.out.println("Passed " + testString + " as " + result);

       testString = "h3t://go.au:80/test1";
       result = urlTest.isValid(testString);
       assertEquals(true,result);
       System.out.println("Passed " + testString + " as " + result);

       testString = "h3t://go.tv:80/test1";
       result = urlTest.isValid(testString);
       assertEquals(true,result);
       System.out.println("Passed " + testString + " as " + result);

       testString = "h3t://go.se:80/test1";
       result = urlTest.isValid(testString);
       assertEquals(true,result);
       System.out.println("Passed " + testString + " as " + result);

       testString = "ftp://google.com";
       result = urlTest.isValid(testString);
       assertEquals(true,result);
       System.out.println("Passed " + testString + " as " + result);

       testString = "http://ww.google.com";
       result = urlTest.isValid(testString);
       assertEquals(true,result);
       System.out.println("Passed " + testString + " as " + result);

       //False Tests
       testString = "http:/www.google.com";
       result = urlTest.isValid(testString);
       assertEquals(false,result);
       System.out.println("Passed " + testString + " as " + result);

       //Test invalid ip address
       testString = "ftp://300.300.300.300:0";
       result = urlTest.isValid(testString);
       assertEquals(false,result);
       System.out.println("Passed " + testString + " as " + result);

       testString = "www.google.com";
       result = urlTest.isValid(testString);
       assertEquals(false,result);
       System.out.println("Passed " + testString + " as " + result);

       testString = "www.google.com";
       result = urlTest.isValid(testString);
       assertEquals(false,result);
       System.out.println("Passed " + testString + " as " + result);
   }


    @Test
    public void testURLScheme() {
        UrlValidator urlTest = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
        String testString = "http://www.google.com";
        boolean result = urlTest.isValid(testString);
        assertEquals(true,result);
        System.out.println("Passed " + testString + " as " + result);

        testString = "wat://www.google.com";
        result = urlTest.isValid(testString);
        assertEquals(false,result);
        System.out.println("Passed " + testString + " as " + result);
    }

    @Test
    public void testURLAuthority(){
        UrlValidator urlTest = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
        String testString = "http://www.google.com";
        boolean result = urlTest.isValid(testString);
        assertEquals(true,result);
        System.out.println("Passed " + testString + " as " + result);

        testString = "http://1.2.3";
        result = urlTest.isValid(testString);
        assertEquals(false,result);
        System.out.println("Passed " + testString + " as " + result);
    }

    @Test
    public void testURLPort(){
        UrlValidator urlTest = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
        String testString = "http://www.google.com:80";
        boolean result = urlTest.isValid(testString);
        assertEquals(true,result);
        System.out.println("Passed " + testString + " as " + result);

        testString = "http://www.google.com:65a";
        result = urlTest.isValid(testString);
        assertEquals(false,result);
        System.out.println("Passed " + testString + " as " + result);
    }

    @Test
    public void testURLPath(){
        UrlValidator urlTest = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
        String testString = "http://www.google.com/test1";
        boolean result = urlTest.isValid(testString);
        assertEquals(true,result);
        System.out.println("Passed " + testString + " as " + result);

        testString = "http://www.google.com/../";
        result = urlTest.isValid(testString);
        assertEquals(false,result);
        System.out.println("Passed " + testString + " as " + result);
    }

    @Test
    public void testURLQuery(){
        UrlValidator urlTest = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
        String testString = "http://www.google.com/?action=view";
        boolean result = urlTest.isValid(testString);
        assertEquals(true,result);
        System.out.println("Passed " + testString + " as " + result);

        testString = "http://www.google.com/?action=thisshouldfail";
        result = urlTest.isValid(testString);
        assertEquals(false,result);
        System.out.println("Passed " + testString + " as " + result);
    }


    /**
     * Ip Tester
     * This program generates various IP addresses and tests to see if
     * they're valid.
     */
    @Test
    public void testIPisValid() {
        System.out.println(" -------- Testing Random IP URLs -------- ");
        for(int j = 0; j <50; j++) {
            String ip = "http://";
            Random rand = new Random();
            Boolean result = true;
            int ipSection = rand.nextInt(300) + 1;
            if (ipSection > 255) {
                result = false;
            }
            for (int i = 0; i < 3; i++) {
                ip += ipSection + ".";
                ipSection = rand.nextInt(300) + 1;
                if (ipSection > 255) {
                    result = false;
                }
            }
            ip += ipSection;
            UrlValidator urlTest = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
            boolean output = urlTest.isValid(ip);
            System.out.println("Tested " + ip + " as " + output + " expected " + result);
            assertTrue(result == output);
        }
    }
    /**
     * Automated URL Tester
     * This generates and tests urls from a given index of urls
     */
    public void testGenUrlIsValid(){
        for(int s = 0; s < 8; s++){
            String scheme = schemes[s];
            Boolean result = true;
            if(s > 3){
                result = false;
            }
            for(int d = 0; d < 8; d++){
                String domain = domains[d];
                for(int p = 0; p < 6; p++){
                    String path = paths[p];
                    if (p > 3 || d > 3 || s > 3) {
                        result = false;
                    }
                    String url = scheme + domain + path;
                    UrlValidator urlTest = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
                    boolean output = urlTest.isValid(url);
                    System.out.println("Tested " + url + " as " + output + " expected " + result);
                    assertTrue(result == output);
                    result = true;

                }
            }
        }

    }

    /**
     * Various url schema, anything after index 3 should evaluate as false
     */
    String[] schemes = {
            "http://",
            "ftp://",
            "https://",
            "h3t://",
            "http:/",
            "ftp:/",
            "https:/",
            "h3t:/"
    };
    /**
     * Various domains, anything after index 3 should evaluate to false
     */
    String[] domains = {
            "www.google.com",
            "www.google.co.uk",
            "www.google.gov",
            "www.google.edu",
            "www.google.1bb",
            "",
            "google.",
            ".com"
    };
    /**
     * Various Paths to attach to url, anything after index 3 should eval to false
     */
    String[] paths = {
            "/testa",
            "/test1",
            "/%20",
            "/-20",
            "/..",
            ".."
    };

}
