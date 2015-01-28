package pos;

/**
 * Created by shuwenli on 14-11-21.
 */
public class Pos {

    private Cart cart;

    public Pos() {
        cart = new Cart();
    }

    public void printList(){

        cart.initcartList();
    }
}
