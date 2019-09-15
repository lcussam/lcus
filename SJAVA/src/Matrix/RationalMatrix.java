package Matrix;

public class RationalMatrix extends GenericMatrix<Rational>
{
	protected Rational add(Rational o1, Rational o2)
	{

		return o1.add(o2);

	}
	protected Rational multiply(Rational o1, Rational o2)
	{

		return o1.multiply(o2);

	}
	protected Rational zero()
	{

		return new Rational(0,1);

	}
}
