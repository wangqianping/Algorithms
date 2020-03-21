package algorithm;

/**
 * 递归算法
 * 简而言之自己调用自己
 * 写递归算法时应该满足以下几个条件
 * 1.调用自己时一定是在if(boolean)下
 * 2.boolean一定会为false
 */
public class Recursive {

    public static void main(String[] args) {
//        print(3);
        int num = getNum(4);
        System.out.println(num);
    }

    public static void print(int i) {
        if (i > 0) {
            System.out.println(i);
            i = i - 1;
            print(i);
        }
    }

    /**
     * 斐波拉契数列：1 1 2 3 5 8 13
     * 获取第n项的和
     */
    public static int getNum(int index) {

        if (index < 1) {
            return 0;
        } else if (index == 1 || index == 2) {
            return 1;
        } else {
            return getNum(index - 1) + getNum(index - 2);
        }

    }


}
