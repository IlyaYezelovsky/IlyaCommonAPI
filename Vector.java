package ilya.util;

public class Vector {
	
	private double x;
	private double y;
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
	
	public Vector(double a, double b, boolean isCoodinates) {
        if (isCoodinates) {
            x = a;
            y = b;
        } else {
            x = a * Math.cos(b);
            y = a * Math.sin(b);
        }
	}
    
    public Vector(double a, double b) {
        this(a, b, true);
    }
	
	public Vector() {
		this(0, 0, true);
	}
	
	public Vector add(Vector a) {
		return new Vector(x + a.x, y + a.y);
	}
	
	public Vector subtract(Vector a) {
		return new Vector(x - a.x, y - a.y);
	}
    
    public Vector opposite() {
        return new Vector(-x, -y);
    }
    
	public Vector multiply(double l) {
		return new Vector(l * x, l * y);
	}
	
	public double multiply(Vector a) {
		return x * a.x + y * a.y;
	}
	
	public double getNorm() {
		return Math.sqrt(x * x + y * y);
	}
	
	public Complex toComplex() {
		return new Complex(x, y);
	}
    
    public boolean isParallelTo(Vector a) {
        if (getNorm() == 0 || a.getNorm() == 0) {
            return true;
        } else if (toComplex().getArg() == a.toComplex().getArg() || toComplex().getArg() == a.toComplex().getArg() + Math.PI) {
            return true;
        } else {
            return false;
        }
    }
    
    public boolean isPerpendicularTo(Vector a) {
        if (multiply(a) == 0) {
            return true;
        } else {
            return false;
        }
    }
	
	@Override
	public boolean equals(Object a) {
		if (a instanceof Vector) {
			Vector z = (Vector) a;
			if (z.x == x && z.y == y) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}

