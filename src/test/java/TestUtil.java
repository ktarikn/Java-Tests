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
  public void OneArg(){
    assertFalse(c.compute(13));
  }
  @Test
  public void EvenArgs(){
    assertFalse(c.compute());
    assertFalse(c.compute(12,24));
  }
  @Test(expected = RuntimeException.class)
  public void ZeroAsArg(){
    
    c.compute(12,0,24);
  }
  @Test
  public void Divisable(){
    assertTrue(c.compute(12,3,2,4,9)); // odd num of args and sum is divisable by three
  }
  @Test
  public void NonDivisable(){
    assertFalse(c.compute(12,24,5)); // odd num of args and sum is not divisable by any arguement
  }
}