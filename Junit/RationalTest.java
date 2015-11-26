import junit.framework.TestCase;

public class RationalTest extends TestCase {

    protected Rational HALF;

    protected void setUp() {
      HALF = new Rational( 1, 2 );
    }

    // Create new test
    public RationalTest (String name) {
        super(name);
    }

    public void testEquality() {
        assertEquals(new Rational(1,3), new Rational(1,3));
        assertEquals(new Rational(1,3), new Rational(2,6));
        assertEquals(new Rational(3,3), new Rational(1,1));
    }

    // Test for nonequality
    public void testNonEquality() {
        assertFalse(new Rational(2,3).equals(
            new Rational(1,3)));
    }

    public void testAccessors() {
    	assertEquals(new Rational(2,3).numerator(), 2);
    	assertEquals(new Rational(2,3).denominator(), 3);
    }

    public void testRoot() {
        Rational s = new Rational( 1, 4 );
        Rational sRoot = null;
        try {
            sRoot = s.root();
        } catch (IllegalArgumentToSquareRootException e) {
            e.printStackTrace();
        }
        assertTrue( sRoot.isLessThan( HALF.plus( Rational.getTolerance() ) ) 
                        && HALF.minus( Rational.getTolerance() ).isLessThan( sRoot ) );
    }


    public void testEquals1(){
        Rational x = new Rational(-2, 8);
        Rational y = new Rational(1, -4);
        assertEquals(x, y);
    }

    public void testEquals2(){
        Rational x = new Rational(-2, 8);
        assertFalse(x.equals(-1));
    }

    public void testPlus1(){
        Rational x = new Rational(-8, 2);
        Rational y = new Rational(1, 2);
        assertEquals(x.plus(y), new Rational(-7, 2));
    }

    public void testPlus2(){
        Rational x = new Rational(-1, -1);
        Rational y = new Rational(-2, -1);
        assertEquals(x.plus(y).numerator(), 3);
    }

    public void testTimes(){
        Rational x = new Rational(-2, 8);
        assertEquals(x.times(new Rational(4, 1)), new Rational(-1, 1));
    }

    public void testMinus(){
        Rational x = new Rational(-2, 8);
        assertEquals(x.minus(new Rational(1, 1)), new Rational(-5, 4));
    }

    public void testDivides(){
        Rational x = new Rational(-2, 8);
        assertEquals(x.divides(new Rational(2, 1)), new Rational(1, -8));
    }

    public void testTolerance(){
        Rational x = new Rational(-2, -20);
        x.setTolerance(new Rational(1, 1001));
        assertEquals(new Rational(1, 1001), x.getTolerance());
    }

    public void testAbs1(){
        Rational x = new Rational(-2, 8);
        assertEquals(x.abs(), new Rational(1, 4));
    }

    public void testAbs2(){
	Rational a = new Rational(2, 3);
	Rational b = new Rational(-2, -3);
	assertEquals(a.abs().numerator(), b.abs().numerator());
    }

    public void testIsLessThan(){
        Rational x = new Rational(-2, 8);
        assertFalse(x.isLessThan(new Rational(-1, 5)));
    }

    public void testToString(){
        Rational x = new Rational(-2, 8);
        assertEquals(x.toString(), "-1/4");
    }

    public static void main(String args[]) {
        String[] testCaseName = 
            { RationalTest.class.getName() };
        // junit.swingui.TestRunner.main(testCaseName);
        junit.textui.TestRunner.main(testCaseName);
    }
}
