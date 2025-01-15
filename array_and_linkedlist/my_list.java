package array_and_linkedlist;

import java.util.Arrays;

class MyList {
    private int[] arr; // 数组
    private  int capacity = 10;

    private int size = 0;

    private int extendRatio = 2;

    public MyList(){
        arr = new int[capacity];
    }

    public int size(){
        return size;
    }

    public int capacity(){
        return capacity;
    }

    public int get(int index){
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("索引越界");
        }
        return arr[index];
    }

    /* 更新元素 */
    public void set(int index, int num) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("索引越界");
        arr[index] = num;
    }


    public void add(int num){
        if (size == capacity){
            extendCapacity();
        }
        arr[size] = num;
        // 添加元素大小 +1
        size++;
    }

    /* 在中间插入元素 */
    public void insert(int index, int num){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("索引越界");
        if (size == capacity){
            extendCapacity();
        }
        for (int i = size-1; i >= index; i--) {
            arr[i+1] = arr[i];
        }
        arr[index] = num;
        size++;
    }

    /* 删除元素 */
    public int remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("索引越界");
        int num = arr[index];
        // 将将索引 index 之后的元素都向前移动一位
        for (int j = index; j < size - 1; j++) {
            arr[j] = arr[j + 1];
        }
        // 更新元素数量
        size--;
        // 返回被删除的元素
        return num;
    }

    /* 将列表转换为数组 */
    public int[] toArray(){
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = arr[i];
        }
        return result;
    }



    private void extendCapacity() {
        arr = Arrays.copyOf(arr, capacity()*extendRatio );
        capacity = arr.length;
    }

}

public class my_list{
    public static void main(String[] args) {
        /* 初始化列表 */
        MyList nums = new MyList();
        /* 在尾部添加元素 */
        nums.add(1);
        nums.add(3);
        nums.add(2);
        nums.add(5);
        nums.add(4);
        System.out.println("列表 nums = " + Arrays.toString(nums.toArray()) +
                " ，容量 = " + nums.capacity() + " ，长度 = " + nums.size());

        /* 在中间插入元素 */
        nums.insert(3, 6);
        System.out.println("在索引 3 处插入数字 6 ，得到 nums = " + Arrays.toString(nums.toArray()));

        /* 删除元素 */
        nums.remove(3);
        System.out.println("删除索引 3 处的元素，得到 nums = " + Arrays.toString(nums.toArray()));

        /* 访问元素 */
        int num = nums.get(1);
        System.out.println("访问索引 1 处的元素，得到 num = " + num);

        /* 更新元素 */
        nums.set(1, 0);
        System.out.println("将索引 1 处的元素更新为 0 ，得到 nums = " + Arrays.toString(nums.toArray()));

        /* 测试扩容机制 */
        for (int i = 0; i < 10; i++) {
            // 在 i = 5 时，列表长度将超出列表容量，此时触发扩容机制
            nums.add(i);
        }
        System.out.println("扩容后的列表 nums = " + Arrays.toString(nums.toArray()) +
                " ，容量 = " + nums.capacity() + " ，长度 = " + nums.size());
    }
}
