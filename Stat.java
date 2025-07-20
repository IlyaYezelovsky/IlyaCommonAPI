package ilya.math;

import java.util.*;
import static java.lang.Math.*;

public class Stat {
	
	LinkedList<double[]> data = new LinkedList<double[]>();
	int rows;
	int lines = data.size();
	String name;
	
	public Stat(String n, int dims) {
		name = n;
		rows = dims;
	}
	
	public double[] getLine(int i) {
		return data.get(i);
	}
	
	public double[] getRow(int i) {
		double[] result = new double[lines];
		for (int j = 0; j < lines; j++) {
			result[j] = data.get(j)[i];
		}
		return result;
	}
	
	public void printTable() {
		if (data.isEmpty()) {
			System.out.println("Nothing to print");
		}
		System.out.print("Row\t");
        for (int col = 0; col < rows; col++) {
            System.out.print("Col " + (col + 1) + "\t");
        }
        System.out.println();
        int rowNum = 1;
        for (double[] row : data) {
            System.out.print(rowNum + "\t"); // 打印行号
            for (double value : row) {
                System.out.print(value + "\t"); // 打印每个数据值，用制表符分隔
            }
            System.out.println();
            rowNum++;
        }
	}
	
	public void addLine(int i) {
		data.add(1, new double[rows]);
	}
	
	public void addLine() {
		data.addLast(new double[rows]);
	}
	
	public void remove(int i) {
		data.remove(i);
	}
	
	public void remove() {
		data.removeLast();
	}
	
	public void clear() {
		while (!data.isEmpty()) {
			data.removeLast();
		}
	}
	
	public double get(int line, int dim) {
		try {
			return getLine(line)[dim];
		} catch (IndexOutOfBoundsException ex) {
			throw new IllegalArgumentException("Trying to access a non-existent index", ex);
		}
	}
	
	public void set(int line, int dim, double x) {
		try {
			getLine(line)[dim] = x;
		} catch (IndexOutOfBoundsException ex) {
			throw new IllegalArgumentException("Trying to access a non-existent index", ex);
		}
	}
	
	public double av(int i) {
		return Statistics.av(getRow(i));
	}
	
	public double[] av() {
		double[] result = new double[rows];
		for (int i = 0; i < rows; i++) {
			result[i] = av(i);
		}
		return result;
	}
	
	public double median(int i) {
		return Statistics.median(getRow(i));
	}
	
	public double[] median() {
		double[] result = new double[rows];
		for (int i = 0; i < rows; i++) {
			result[i] = median(i);
		}
		return result;
	}
	
	public double[] mode(int i) {
		return Statistics.mode(getRow(i));
	}
	
	public ArrayList<double[]> mode() {
		ArrayList<double[]> result = new ArrayList<double[]>();
		for (int i = 0; i < rows; i++) {
			result.add(mode(i));
		}
		return result;
	}
	
	public double var(int i) {
		return Statistics.variance(getRow(i));
	}
	
	public double[] var() {
		double[] result = new double[rows];
		for (int i = 0; i < rows; i++) {
			result[i] = var(i);
		}
		return result;
	}
	
	public double sd(int i) {
		return Statistics.sd(getRow(i));
	}
	
	public double[] sd() {
		double[] result = new double[rows];
		for (int i = 0; i < rows; i++) {
			result[i] = sd(i);
		}
		return result;
	}
	
	public double avd(int i) {
		return Statistics.avd(getRow(i));
	}
	
	public double[] avd() {
		double[] result = new double[rows];
		for (int i = 0; i < rows; i++) {
			result[i] = avd(i);
		}
		return result;
	}
	
}
