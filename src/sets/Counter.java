/**
 * @author 318770609
 */
package sets;

/**
 * the build with int that add, decrease , and return it.
 */
public class Counter {
    private int count;

    /**
     * build and initialize the counter to zero.
     */
    public Counter() {
        this.count = 0;
    }

    /**
     * @param number - add number to current count.
     */
    public void increase(int number) {
        this.count = this.count + number;
    }

    /**
     * @param number - subtract number from current count
     */
    public void decrease(int number) {
        this.count = this.count - number;
    }

    /**
     * @return the current count.
     */
    public int getValue() {
        return this.count;
    }
}