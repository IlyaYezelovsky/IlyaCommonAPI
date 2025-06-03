package ilya.util;

public class Complex {
	
	private double re;
	private double im;
    
    public double getRe() {
        return re;
    }
    
    public double getIm() {
        return im;
    }
    
    public Complex(double ire, double iim, boolean isCoodinates) {
        if (isCoodinates) {
            re = ire;
            im = iim;
        } else {
            re = ire * Math.cos(iim);
            im = ire * Math.sin(iim);
        }
    }
    
    public Complex() {
		this(0, 0);
	}
    
    public Complex(double ire, double iim) {
        this(ire, iim, true);
    }
    
    public double getArg() throws ArithmeticException {
        if (re == 0 && im == 0) {
            throw new ArithmeticException("Argument of 0 is undefined");
        } else {
            if (Math.atan2(im, re) < 0) {
                return Math.atan2(im, re) + 2 * Math.PI;
            } else {
                return Math.atan2(im, re);
            }
        }
    }
    
    public double getNorm() {
		return Math.sqrt(re * re + im * im);
	}
	
	public Complex add(Complex z) {
		return new Complex(re + z.re, im + z.im);
	}
	
	public Complex add(double z) {
		return new Complex(re + z, im);
	}
	
	public Complex subtract(Complex z) {
		return new Complex(re - z.re, im - z.im);
	}
	
	public Complex subtract(double z) {
		return new Complex(re - z, im);
	}
    
    public Complex opposite() {
        return new Complex(-re, -im);
    }
	
	public Complex multiply(Complex z) {
		return new Complex(re * z.re - im * z.im, re * z.im + im * z.re);
	}
	
	public Complex multiply(double z) {
		return new Complex(re * z, im * z);
	}
	
    
	public Complex divide(Complex z) throws ArithmeticException {
		return new Complex((re * z.re + im * z.im) / (z.re * z.re + z.im * z.im), (im * z.re - re * z.im) / (z.re * z.re + z.im * z.im));
	}
	
	public Complex divide(double z) throws ArithmeticException {
		return new Complex(re / z, im / z);
	}
	
	public Vector toVector() {
		return new Vector(re, im);
	}
	
	public static Complex toComplex(double a) {
		return new Complex(a, 0);
	}
	
    @Override
	public String toString() {
		if (im == 0) {
			return String.valueOf(re);
		} else if (re == 0) {
			return im + "i";
		} else if (im > 0) {
			return re + "+" + im + "i";
		} else {
			return re + "-" + -im + "i";
		}
	}
    
    public boolean isReal() {
        if (im == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isImaginary() {
        if (im != 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isPureImaginary() {
        if (re == 0 && im != 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isPure() {
        if (im == 0 || isPureImaginary()) {
            return true;
        } else {
            return false;
        }
    }
    
    public double toDouble() throws UnsupportedOperationException {
        if (im == 0) {
            return re;
        } else {
            throw new UnsupportedOperationException("Cannot convert a imaginary number to double");
        }
    }
	
	public static Complex cSqrt(double a) {
		if (a >= 0) {
			return toComplex(Math.sqrt(a));
		} else {
			return new Complex(0, Math.sqrt(-a));
		}
	}
	
	@Override
	public boolean equals(Object a) {
		if (a instanceof Complex) {
			Complex z = (Complex) a;
			if (z.re == re && z.im == im) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
    
    public boolean mathematicallyEquals(double a) {
        if ((im == 0 && re == a) || equals(toComplex(a))) {
            return true;
        } else {
            return false;
        }
    }

}
