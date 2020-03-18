package algorithm;

/**
 * 查找算法
 */
public class Search {

    /**
     * 线性查找
     *
     * @param val 目标值
     * @return
     */
    public int linearSearch(int val) {

        int[] arr = new int[]{1, 2, 3, 4, 5};

        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (val == arr[i]) {
                index = i;
                break;
            }
        }

        return index;
    }

    /**
     * 二分法查找
     * <p>
     * 二分法适用于有序数组，无序数组没有意义
     *
     * @param val 目标值
     * @return
     */
    public int BinarySearch(int val) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        //开始位置
        int begin = 0;
        //结束位置
        int end = arr.length - 1;
        //中间位置
        int mid = (begin + end) / 2;
        int index = -1;

        while (true) {

            if (arr[mid] == val) {
                index = mid;
                break;
            } else if (arr[mid] > val) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }

            mid = (begin + end) / 2;

            //当没有元素的时候
            if(begin>=end){
                return index;
            }
        }

        return index;

    }

}
