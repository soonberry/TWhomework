package pos;

import parser.ReadTXT;

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

        ReadTXT readItemList=new ReadTXT();
        List<String> itemL=readItemList.readTxt("itemlist.txt");

        for(String i:itemL){

            if(i.contains(id)) {
                this.price=Double.parseDouble(i.split(":")[1]);
                this.ID=i.split(":")[0];
//                System.out.println("ID:"+this.ID+"  price:"+this.price);
            }
        }
    }

    public boolean hasSecHalf(){
        ReadTXT readDiscount=new ReadTXT();
        List<String> itemDis=readDiscount.readTxt("second_half_price_promotion.txt");
        for(String i:itemDis){
            if(i.equals(this.getID())) {
                return true;
            }
        }
        return false;

    }
    public boolean hasDiscount(){
        ReadTXT readDiscount=new ReadTXT();
        List<String> itemDis=readDiscount.readTxt("discount_promotion.txt");
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
