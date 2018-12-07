package list_group_by;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class ArrayGroupBy {
    public static void main(String[] args) {
        User u1 = new User(1, "刘德华");
        User u2 = new User(1, "刘志弦");
        User u3 = new User(2, "张学友");
        User u4 = new User(2, "张国立");

        List<User> list = Arrays.asList(new User[]{u1, u2, u3, u4});

        Map<String, List<User>> map = new HashMap<>();

        for (User user : list) {
            List<User> temp = map.get(user.getId() + "");
            if (temp == null) {
                temp = new ArrayList<>();
                temp.add(user);
                map.put(user.getId() + "", temp);
            } else {
                temp.add(user);
            }
        }

        System.out.println(JSON.toJSONString(map));
        Man[] man = {new Man(20, "a"), new Man(15, "b")};
        Arrays.sort(man);
        //System.out.println(Arrays.toString(man));
        int[] a = {1, 3, 5, 4, 0, 9, 6, 7, 8, 2};
        int[] arr = bubbleSort(a);
        int search = binarySearch(arr, 5);
        System.out.println(search);
        //System.out.println(Arrays.toString(bubbleSort));
    }

    public static int[] bubbleSort(int[] a) {
        int temp = 0;
        for (int i = 0; i < a.length - 1; i++) {
            boolean flag = true;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return a;
    }

    public static int binarySearch(int[] array, int index) {
        int min = 0;
        int max = array.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (array[mid] == index) return mid;

            if (array[mid] > index) max = mid - 1;

            if (array[mid] < index) min = mid + 1;
        }
        return -1;
    }
}

class Man implements Comparable {
    int age;
    String name;

    public Man(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public int compareTo(Object o) {
        Man man = (Man) o;
        if (this.age < man.age) {
            return -1;
        }
        if (this.age > man.age) {
            return 1;
        }
        return 0;
    }
}
