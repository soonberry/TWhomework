package pos;

import parser.ReadTXT;

import java.util.List;

/**
 * Created by shuwenli on 14-11-23.
 * 装饰者模式，计算折扣的时候new一个本类就可以了。
 */
public class DiscountItem extends Item {
    double discount;

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
}
