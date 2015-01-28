package pos;

/**
 * Created by shuwenli on 14-11-22.
 */
public class cartItem {
    Item item;
    int count;
    double sum;

    public cartItem(String it){
        count=0;
        String[] items=it.split("-");
        System.out.println("count"+count);
        for(String i:items)System.out.println("    "+i);
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }
}
