
package Ma;
 
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

 
public class SoftAssertion {
 
 @Test
 public void softAssert(){
 //SoftAssert softAssertion= new SoftAssert();
 System.out.println("softAssert Method Was Started");
 AssertJUnit.assertTrue(false);
 System.out.println("softAssert Method Was Executed");
 }
 
 @Test
 public void hardAssert(){
 System.out.println("hardAssert Method Was Started");
 AssertJUnit.assertTrue(false);
 System.out.println("hardAssert Method Was Executed");
 }
}