package hashMap;

/**
 * 演示直接定址法设计散列函数
 */
public class HashTable {

    private StudentInfo[] data = new StudentInfo[100];


    public void put(StudentInfo studentInfo){
        int index = studentInfo.hashCode();
        data[index] = studentInfo;
    }

    public StudentInfo get(StudentInfo studentInfo){
        return data[studentInfo.age];
    }


    public static void main(String[] args) {

        StudentInfo studentInfo1 = new StudentInfo(10,1);
        StudentInfo studentInfo2 = new StudentInfo(15,2);
        StudentInfo studentInfo3 = new StudentInfo(13,4);

        HashTable hashTable = new HashTable();
        hashTable.put(studentInfo1);
        hashTable.put(studentInfo2);
        hashTable.put(studentInfo3);

        StudentInfo studentInfo = hashTable.get(studentInfo1);
        System.out.println(studentInfo);

    }

}
