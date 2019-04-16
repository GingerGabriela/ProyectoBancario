package dominio;

import java.util.Vector;

public class Cuenta 
{
		/**
		 * atributos protegidos de la clase Cuenta
		 */
	protected String mNumero;
	protected String mTitular;
	protected Vector mMovimientos;	

	/**
	 * Constructor de  Cuenta
	 * @param numero
	 * @param titular
	 */
	public Cuenta(String numero, String titular)
	{
		mNumero=numero;
		mTitular=titular;
		mMovimientos=new Vector();
	}
	/**
	 * metodo ingresar en la cuenta con Excepcion
	 * @param x
	 * @throws Exception
	 */
	public void ingresar(double x) throws Exception
	{
		if (x<=0)
			throw new Exception("No se puede ingresar una cantidad negativa");
		Movimiento m=new Movimiento();
		m.setConcepto("Ingreso en efectivo");
		m.setImporte(x);
		this.mMovimientos.addElement(m);
	}
	/**
	 * metodo retirar dinero de la Cuenta
	 * @param double x
	 * @throws Exception
	 */
	
	public void retirar(double x) throws Exception 
	{
		if (x<=0)
			throw new Exception("No se puede retirar una cantidad negativa");	
		if (getSaldo()<x)
			throw new Exception("Saldo insuficiente");
		Movimiento m=new Movimiento();
		m.setConcepto("Retirada de efectivo");
		m.setImporte(-x);
		this.mMovimientos.addElement(m);
	
	}
	
	/**
	 * metodo Ingresar con una advertencia de no se puede ingresar saldo negativo
	 * @param String concepto
	 * @param double x
	 * @throws Exception
	 */
	public void ingresar(String concepto, double x) throws Exception
	{
		if (x<=0)
			throw new Exception("No se puede ingresar una cantidad negativa");
		Movimiento m=new Movimiento();
		m.setConcepto(concepto);
		m.setImporte(x);
		this.mMovimientos.addElement(m);
	}
	/**
	 * metodo Retirar con una advertencia de no se puede ingresar saldo negativo
	 * @param String concepto
	 * @param double x
	 * @throws Exception
	 */
	
	public void retirar(String concepto, double x) throws Exception 
	{
		if (x<=0)
			throw new Exception("No se puede retirar una cantidad negativa");	
		if (getSaldo()<x)
			throw new Exception("Saldo insuficiente");
		Movimiento m=new Movimiento();
		m.setConcepto(concepto);
		m.setImporte(-x);
		this.mMovimientos.addElement(m);
	
	}	
	
	/**
	 * metodo cambiar Saldo
	 * @return saldo
	 */
	public double getSaldo() 
	{
		double r=0.0;
		for (int i=0; i<this.mMovimientos.size(); i++) 
		{
			Movimiento m=(Movimiento) mMovimientos.elementAt(i);
			r+=m.getImporte();
		}
		return r;
	}
	
	/**
	 * metodo revisar movimiento
	 * @param m
	 */
	public void addMovimiento(Movimiento m) 
	{
		mMovimientos.addElement(m);
	}
}