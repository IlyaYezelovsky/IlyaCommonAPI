package ilya.math;

import java.util.*;
import static java.lang.Math.*;

public class Statistics {
	
	private Statistics() {
		throw new AssertionError("No Statistics instances for you!");
	}
	
	public static double sum(double[] x) {
		double s = 0;
		for (double xn:x) {
			s += xn;
		}
		return s;
	}
	
	public static double av(double[] x) {
		return sum(x) / x.length;
	}
	
	public static double variance(double[] x) {
		double bar = av(x);
		double var = 0;
		for (double xn:x) {
			var += pow(xn - bar, 2);
		}
		return var;
	}
	
	public static double sd(double[] x) {
		return sqrt(variance(x));
	}
	
	public static double avd(double[] x) {
		double bar = av(x);
		double vd = 0;
		for (double xn:x) {
			vd += abs(xn - bar);
		}
		return vd;
	}
	
	public static double[] sort(double[] x) {
        // 创建数组副本以避免修改原数组
        double[] sorted = Arrays.copyOf(x, x.length);
        Arrays.sort(sorted);
        return sorted;
    }
	
	public static double median(double[] x) {
        if (x == null || x.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }
        
        // 先对数组进行排序
        double[] sorted = sort(x);
        int length = sorted.length;
        
        // 根据数组长度的奇偶性计算中位数
        if (length % 2 == 0) {
            // 偶数个元素：取中间两个数的平均值
            return (sorted[length / 2 - 1] + sorted[length / 2]) / 2.0;
        } else {
            // 奇数个元素：取中间的数
            return sorted[length / 2];
        }
	}
	
	public static double[] mode(double[] x) {
        if (x == null || x.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        // 使用Map统计每个数字出现的频率
        Map<Double, Integer> frequencyMap = new HashMap<>();
        for (double num : x) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 找出最大的频率值
        int maxFrequency = Collections.max(frequencyMap.values());

        // 收集所有频率等于maxFrequency的数字
        List<Double> modes = new ArrayList<>();
        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }
     // 如果没有众数（所有数字出现次数相同且数组长度>1）或者数组只有一个元素
        if (modes.size() == frequencyMap.size() && x.length > 1) {
            return new double[0];
        }

        // 将众数列表转换为数组并排序
        double[] result = new double[modes.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = modes.get(i);
        }
        Arrays.sort(result);

        return result;
    }

}
