package pos;

import parser.Parser;

import java.util.*;

/**
 * Created by shuwenli on 14-11-21.
 */
public class Cart {

    private Map<String,Integer> cartList;
    private double sum;

    public Cart() {
        cartList = new HashMap<String, Integer>();
    }


    public void initcartList(){

      //  List<Map<Item,Integer>> cartList=new ArrayList<Map<Item, Integer>>();

        List<String> cartL=readShoppingList();
        Integer key=0;

        for (String it:cartL) {

            System.out.println("cart item:"+it);
            Item item=new Item(it.split("-")[0]);

            if (cartList.containsKey(item.getID())) {
                key = cartList.get(item.getID());
//                System.out.println("key:"+key);
                if (it.split("-").length > 1) {
                    key+= Integer.parseInt(it.split("-")[1]);
                } else
                    key++;
                cartList.put(item.getID(),key);

            } else{
                if (it.split("-").length > 1)
                    key= Integer.parseInt(it.split("-")[1]);
                else
                    key=1;
                cartList.put(item.getID(), key);
            }
        }

        printCart();
 //       System.out.println(cartL.toString());
    }

    public void printCart() {

        System.out.println("*********Print the cart***********");
        Set set=cartList.entrySet();
        Iterator iterator=set.iterator();
        while(iterator.hasNext()){

            Map.Entry mapentry=(Map.Entry)iterator.next();
            Item item=new Item(mapentry.getKey().toString());
                System.out.println(item.toString()+"\tcount:" +mapentry.getValue()+"\tsum:"+sumItem(item, (Integer) (mapentry.getValue())));
        }
    }

    public double sumItem(Item item,int count) {
        double sumIt=item.getPrice()*count;
        if(count>1&&item.hasSecHalf())
            sumIt-=((int)(count/2))*item.getPrice()/2;
        if(item.hasDiscount())
            sumIt*=item.getDiscount();

        return sumIt;
    }

    private List<String> readShoppingList() {

        Parser readItemList=new Parser();
        List<String> cartL=readItemList.parse("cart.txt");

        return cartL;

    }


}
