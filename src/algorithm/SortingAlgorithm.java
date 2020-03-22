package algorithm;

/**
 * 排序算法
 * 交换排序：冒泡排序和快速排序
 * 插入排序：直接插入排序和希尔排序
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
                array[j+1] = val;
            }

        }

    }

    /**
     * 希尔排序
     */
    public void hillSort(int[] array){
        //todo 明天继续
    }


}
