
public class Caching {
    boolean flag = true;
    int count = 0;

    void thread1() {
        while (flag) {
            count++;
        }
    }

    void thread2() {
        flag = false;
    }
}
