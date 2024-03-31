import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class TestUtil {
  Util c;

  @Before
  public void setUp() { c = new Util(); }

  @Test
  public void example() { assertTrue(true); }

  @Test
  public void testLengthIsOne(){
    assertFalse(c.compute(12));
  }

  @Test
  public void testLengthIsEven(){
    assertFalse(c.compute(3,6,8,7));
  }

  @Test(expected = RuntimeException.class)
  public void testExceptionHandle(){
    c.compute(3,5,6,0,9);
  }

  @Test
  public void testSumIsDivisibleByElement(){
    assertTrue(c.compute(3,6,9,18,36));
  }

  @Test
  public void testSumIsNotDivisibleByElement(){
    assertFalse(c.compute(3,6,9,18,7));
  }

}