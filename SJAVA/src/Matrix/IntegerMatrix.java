package Matrix;

public class IntegerMatrix extends GenericMatrix<Integer>
{

	@Override
	protected Integer add(Integer x1, Integer x2) {
		// TODO Auto-generated method stub
		return x1+x2;
	}

	@Override
	protected Integer multiply(Integer x1, Integer x2) {
		// TODO Auto-generated method stub
		return x1*x2;
	}

	@Override
	protected Integer zero() {
		// TODO Auto-generated method stub
		return 0;
	}
   
}
