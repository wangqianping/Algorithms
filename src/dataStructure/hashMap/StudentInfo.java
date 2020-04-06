package hashMap;

public class StudentInfo {

    int age;
    int count;

    public StudentInfo(int age,int count){
        this.age=age;
        this.count=count;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    //散列函数
    public int hashCode(){
        return age;
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "age=" + age +
                ", count=" + count +
                '}';
    }
}
