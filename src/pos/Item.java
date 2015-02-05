package pos;

import parser.Parser;

import java.util.List;

/**
 * Created by shuwenli on 14-11-21.
 */
public class Item {
    String ID;
    double price;
    double discount;

    public Item(){

        ID="0";
        price=0;
    }

    public Item(String id){

        Parser readItemList=new Parser();
        List<String> itemL=readItemList.parse("itemlist.txt");

        for(String i:itemL){

            if(i.contains(id)) {
                this.price=Double.parseDouble(i.split(":")[1]);
                this.ID=i.split(":")[0];
//                System.out.println("ID:"+this.ID+"  price:"+this.price);
            }
        }
    }

    public boolean hasSecHalf(){
        Parser readDiscount=new Parser();
        List<String> itemDis=readDiscount.parse("second_half_price_promotion.txt");
        for(String i:itemDis){
            if(i.equals(this.getID())) {
                return true;
            }
        }
        return false;

    }
    public boolean hasDiscount(){
        Parser readDiscount=new Parser();
        List<String> itemDis=readDiscount.parse("discount_promotion.txt");
        for(String i:itemDis){
            if((i.split(":")[0]).equals(this.getID())) {
                this.discount=(Double.valueOf((i.split(":"))[1]))*0.01;
                return true;
            }
        }
        return false;
    }

    public double getDiscount() {
        return discount;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getID().equals(((Item) obj).getID());
    }

    @Override
    public String toString() {
        return "ID:"+getID()+"  price:"+getPrice();
    }

    public double getPrice() {
        return price;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
