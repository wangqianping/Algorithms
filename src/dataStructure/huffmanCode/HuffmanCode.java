package huffmanCode;

import java.util.*;

/**
 * 演示赫夫曼编码解码
 */
public class HuffmanCode {

    public static void main(String[] args) {

        String msg = "can you can a can as a can canner can a can.";
        byte[] bytes = msg.getBytes();
        //进行赫夫曼编码
        byte[] b = encode(bytes);
        //使用赫夫曼编码进行解码
        byte[] newBytes = decode(huffCodes, b);
        System.out.println(new String(newBytes));
    }

    /**
     * 使用指定的赫夫曼编码表进行解码
     *
     * @param huffCodes
     * @param bytes
     * @return
     */
    private static byte[] decode(Map<Byte, String> huffCodes, byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        //把byte数组转为一个二进制字符串
        for (int i = 0; i < bytes.length; i++) {
            String str;
            if (i == bytes.length - 1) {
                str = byteToBitStr(false,bytes[i]);
            } else {
                str = byteToBitStr(true, bytes[i]);
            }
            sb.append(str);
        }
        //把二进制字符串根据赫夫曼编码表进行解码
        Map<String,Byte> map = new HashMap<>();
        for(Map.Entry<Byte,String> entry:huffCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }
        List<Byte> byteList = new ArrayList<>();
        for(int i=0;i<sb.length();){
            int count=1;
            boolean flag = true;
            Byte aByte = null;
            while(flag){
                String key = sb.substring(i,i+count);
                aByte = map.get(key);
                if(aByte==null){
                    count++;
                }else{
                    flag=false;
                }
            }
            byteList.add(aByte);
            i=count+i;
        }

        byte[] bytes1 = new byte[byteList.size()];
        for(int i =0;i<byteList.size();i++){
            bytes1[i]=byteList.get(i);
        }
        return bytes1;
    }

    /**
     * 将一个字节转为八位的二进制字符串
     *
     * @param b
     * @return
     */
    private static String byteToBitStr(boolean flag, byte b) {
        int temp = b;
        if (flag) {
            temp = temp | 256;
        }
        String result = Integer.toBinaryString(temp);
        if (flag) {
            return result.substring(result.length()-8);
        } else {
            return result;
        }
    }

    /**
     * 进行赫夫曼编码实现压缩
     *
     * @param bytes
     * @return
     */
    private static byte[] encode(byte[] bytes) {

        //先统计每一个byte出现的次数并放入一个集合中
        List<Node> nodes = getNodes(bytes);
        //创建一棵赫夫曼树
        Node tree = createHuffmanTree(nodes);
        //创建一个赫夫曼编码表
        Map<Byte, String> huffCodes = getCodes(tree);
        //编码压缩
        byte[] b = zip(bytes, huffCodes);
        return b;
    }

    /**
     * 进行赫夫曼编码
     *
     * @param bytes
     * @param huffCodes
     * @return
     */
    private static byte[] zip(byte[] bytes, Map<Byte, String> huffCodes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(huffCodes.get(b));
        }
        int lengeth;
        if (sb.length() % 8 == 0) {
            lengeth = sb.length() / 8;
        } else {
            lengeth = sb.length() / 8 + 1;
        }

        byte[] by = new byte[lengeth];
        int index = 0;
        for (int i = 0; i < sb.length(); i += 8) {
            String strByte;
            if (i + 8 > sb.length()) {
                strByte = sb.substring(i);
            } else {
                strByte = sb.substring(i, i + 8);
            }

            byte byt = (byte) Integer.parseInt(strByte, 2);
            by[index] = byt;
            index++;
        }
        return by;
    }

    //用于临时存储路径
    static StringBuilder sb = new StringBuilder();
    //用于存储赫夫曼编码表
    static Map<Byte, String> huffCodes = new HashMap<>();

    /**
     * 根据赫夫曼树获取赫夫曼编码
     *
     * @param tree
     * @return
     */
    private static Map<Byte, String> getCodes(Node tree) {

        if (tree == null) {
            return null;
        }

        getCodes(tree.left, "0", sb);
        getCodes(tree.right, "1", sb);

        return huffCodes;
    }

    private static void getCodes(Node node, String code, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if (node.date == null) {
            getCodes(node.left, "0", sb2);
            getCodes(node.right, "1", sb2);
        } else {
            huffCodes.put(node.date, sb2.toString());
        }
    }

    /**
     * 创建赫夫曼树
     *
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes) {

        while (nodes.size() > 1) {
            //倒序排序
            nodes.sort(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    return -(o1.weight - o2.weight);
                }
            });
            //取出两个权值最小的二叉树构建一个新的二叉树
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            Node parent = new Node(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;
            //移除原有的二叉树并将新创建的二叉树放入集合
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(parent);
        }

        return nodes.get(0);
    }

    /**
     * 将byte数组转为node集合
     *
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes) {
        List<Node> nodes = new ArrayList<>();
        Map<Byte, Integer> counts = new HashMap<>();
        //统计每一个byte出现的次数
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) {
                counts.put(b, 1);
            } else {
                counts.put(b, ++count);
            }
        }
        //把每一个键值对转换成一个Node
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }


}
