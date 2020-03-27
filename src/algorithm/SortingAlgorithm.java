package algorithm;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 排序算法
 * 交换排序：冒泡排序和快速排序
 * 插入排序：直接插入排序和希尔排序
 * 选择排序：简单选择排序和堆排序
 * 归并排序：
 * 基数排序：
 */
public class SortingAlgorithm {

    /**
     * 冒泡排序法:
     * 每一轮都都选出最大的一个，已经比较过的在下一轮不进行比较
     * 每一轮的比较逻辑是两两比较，如果前一个数大于后一个数就交换位置
     */
    public void bubbleSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int val = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = val;
                }
            }
        }
    }

    /**
     * 快速排序:
     * 1.选第一个数作为基准，比他大的放右边比他小的放左边
     * 2.放的概念是直接覆盖，覆盖了哪边哪边的指针移动直到下一次覆盖，交换指针开始移动，直到高位和低位的指针重合
     * 3.然后小的作为一组大的作为新的一组继续按照方式一进行排序
     */
    public void quickSort(int[] array, int start, int end) {
        if (start < end) {
            //把数组中的第0个数作为标准数
            int stand = array[start];
            //记录需要排序的下标
            int low = start;
            int high = end;
            //当低位和高位未重合时就需要一直比较
            while (low < high) {
                //右边的数字比标准数字大，高位左移
                while (low < high && stand < array[high]) {
                    high--;
                }
                array[low] = array[high];
                //左边的数字比标准数小
                while (low < high && array[low] <= stand) {
                    low++;
                }
                array[high] = array[low];
            }
            //把标准数放到低位
            array[low] = stand;
            //处理所有小的数字
            quickSort(array, 0, low);
            //处理所有的大的数字
            quickSort(array, low + 1, end);
        }
    }

    /**
     * 直接插入排序：
     * 从第二个数起与前面的所有数进行比较，直到找到适合自己的位置然后插入进去
     */
    public void insertSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                int val = array[i];
                int j;
                for (j = i - 1; j >= 0 && val < array[j]; j--) {
                    array[j + 1] = array[j];
                }
                array[j + 1] = val;
            }

        }

    }

    /**
     * 希尔排序：
     * 将数组为成两个小组进行直接插入排序
     * 分组的方式是以数组处以2得到一个分组的步长
     * 每一轮排序都是在上一个步长的基础上除以2，直到步长为0
     * 希尔排序比直接插入排序效率高
     */
    public void shellSort(int[] array) {
        //轮询步长
        for (int d = array.length / 2; d > 0; d /= 2) {
            //遍历所有元素
            for (int i = d; i < array.length; i++) {
                //遍历本组所有的元素
                for (int j = i - d; j >= 0; j -= d) {
                    //如果当前元素大于加上步长后的那个元素
                    if (array[j] > array[j + d]) {
                        int val = array[j];
                        array[j] = array[j + d];
                        array[j + d] = val;
                    }
                }
            }
        }
    }

    /**
     * 简单选择排序：
     * 每一轮选出数组中的最小的一个数把它更新在相应的位置
     * 第N轮就更新第N位
     */
    public void selectSort(int[] array) {

        for (int i = 0; i < array.length; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[min] < array[j]) {
                    //记录这一轮排序中最小元素的下标
                    min = j;
                }
            }
            if (min != i) {
                int val = array[i];
                array[i] = array[min];
                array[min] = val;
            }
        }
    }

    /**
     * 堆排序：
     * 堆：数据结构中的一种，可以把他看作一个二叉树的数组对象
     * 根节点都比子节点大的叫大顶堆，根节点都比子节点小的叫小顶堆
     * 升序排序：用大顶堆
     * 降序排序：用小顶堆
     */
    public void heapSort(int[] array) {

        //从最后一个非叶子节点开始，即最后一个节点的父节点
        int start = (array.length - 1) / 2;
        //将数组转换成大顶堆
        for (int i = start; i >= 0; i--) {
            maxheap(array, array.length, i);
        }
        System.out.println("第1次 " + Arrays.toString(array));
        int n = 2;
        //将数组转换成大顶堆后需要交换第一个元素和最后一个元素的位置
        for (int i = array.length - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            //第一次的时候已经将整个数组转换成了大顶堆，这里交换了以后可能会影响之前已经排好的，所以从这个位置开始要继续调整
            maxheap(array, i, 0);
            System.out.println("第" + (n++) + "次 " + Arrays.toString(array));
        }
    }

    /**
     * 将一个数组变成一个大顶堆
     *
     * @param array
     * @param size
     * @param index
     */
    public void maxheap(int[] array, int size, int index) {
        //左子节点
        int left = 2 * index + 1;
        //右子节点
        int right = 2 * index + 2;
        int max = index;
        //和两个子节点比较找出最大的那个节点
        if (left < size && array[left] > array[max]) {
            max = left;
        }
        if (right < size && array[right] > array[max]) {
            max = right;
        }
        //如果子节点大则交换位置
        if (max != index) {
            int temp = array[index];
            array[index] = array[max];
            array[max] = temp;
            //交换位置后可能会影响array[max]与他的子节点不能构成大顶堆的格式，所以那个位置要继续调整
            maxheap(array, size, max);
        }
    }


    /**
     * 归并逻辑：
     * 两个有序的数组合并成一个有序的数组，注意是有序的
     */
    public void merge(int[] array, int low, int middle, int high) {

        int[] temp = new int[high - low + 1];
        //用于记录第一个数组中的下标
        int i = low;
        //用于记录第二个数组中的下标
        int j = middle + 1;
        //用于记录在临时数组中存放的下标
        int index = 0;
        //遍历两个数组取出小的数字放入临时数组
        while (i <= middle && j <= high) {
            if (array[i] <= array[j]) {
                temp[index] = array[i];
                i++;
            } else {
                temp[index] = array[j];
                j++;
            }
            index++;
        }

        while (i <= middle) {
            temp[index] = array[i];
            i++;
            index++;
        }

        while (j <= high) {
            temp[index] = array[j];
            j++;
            index++;
        }

        //把临时数组重新存入原数组
        for (int k = 0; k < temp.length; k++) {
            array[low + k] = temp[k];
        }
    }

    /**
     * 归并排序
     * 递归的方式
     */
    public void mergeSort(int[] array, int low, int high) {
        int middle = (low + high) / 2;
        if (low < high) {
            //处理左边,为了让左边有序
            mergeSort(array, low, middle);
            //处理右边，为了让右边有序
            mergeSort(array, middle + 1, high);
            //归并
            merge(array, low, middle, high);
        }

    }

    /**
     * 基数排序:
     * 每一次轮循都是比较某个位置上的数进行排序
     * 第一次个位比第二次十位比，依次类推
     */
    public void RedixSort(int[] array) {
        //存数组中最大的数
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //最大的数字是几位数
        int maxLength = (max + "").length();
        //用于临时存储每次比较时放在不同位置的数组
        int[][] temp = new int[10][array.length];
        //用于存放temp数组中每一行存放的数据的个数
        int[] counts = new int[10];
        //根据最大长度决定比较的次数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //把数字存进temp
            for (int j = 0; j < array.length; j++) {
                //取出每一位上的数并进行存储和统计个数
                int remainder = array[j] / n % 10;
                temp[remainder][counts[remainder]] = array[j];
                counts[remainder] = counts[remainder] + 1;
            }
            int index = 0;
            //把数字从temp取出来并更新原数组，相当于按位数进行了一轮排序
            for (int k = 0; k < counts.length; k++) {
                if (counts[k] != 0) {
                    for (int l = 0; l < counts[k]; l++) {
                        array[index] = temp[k][l];
                        index++;
                    }
                    //一轮比较后清楚缓存数据
                    counts[k] = 0;
                }
            }
        }
    }

    /**
     * 基础排序，队列实现
     */
    public void RedixQueueSort(int[] array) {
        //存数组中最大的数
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //最大的数字是几位数
        int maxLength = (max + "").length();
        //每一次放数据时放到的队列
        Queue<Integer>[] temp = new Queue[10];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new LinkedList<>();
        }
        //根据最大长度决定比较的次数
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            //把数字存进temp
            for (int j = 0; j < array.length; j++) {
                //取出每一位上的数并进行存储和统计个数
                int remainder = array[j] / n % 10;
                temp[remainder].add(array[j]);
            }
            int index = 0;
            //把数字从temp取出来并更新原数组，相当于按位数进行了一轮排序
            for (int k = 0; k < temp.length; k++) {
                while (!temp[k].isEmpty()) {
                    array[index] = temp[k].poll();
                    index++;
                }
            }
        }
    }


}
