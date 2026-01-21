
package Gilderose;
public abstract class Item{
    public String name;
    public int sellIn;
    public int quality;

    protected static final int MAX_QUALITY = 50;
    protected static final int MIN_QUALITY = 0;
    protected abstract void updateQuality();
//    protected abstract void updateSellIn();
    protected abstract void handleExpired();
    public Item(String name, int sellIn,int quality){
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString(){
        return this.name + " " + this.sellIn + "," + this.quality;
    }


//    additional methods
    public boolean isExpired() {
        return sellIn < 0;
    }

    public  void incrementQuality() {
        if (quality < MAX_QUALITY) {
            quality++;
        }
    }

    public void decrementQuality() {
        if (quality > MIN_QUALITY) {
            quality--;
        }
    }

    public void updateSellIn() {
        sellIn--;
    }

}

class AgedBrieItem extends Item{
    public AgedBrieItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }




    protected void updateQuality() {
        incrementQuality();
        if (sellIn < 0) {
            incrementQuality(); // Increases twice as fast after sell date
        }
    }

    public void updateSellIn() {
        sellIn--;
    }


    @Override
    protected void handleExpired() {

    }
}

class BackstagePassItem extends Item{

    public BackstagePassItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    private static final int FIRST_QUALITY_BOOST_DAYS = 10;
    private static final int SECOND_QUALITY_BOOST_DAYS = 5;


    @Override
    public void updateQuality() {
        incrementQuality();

        if (sellIn <= FIRST_QUALITY_BOOST_DAYS) {
            incrementQuality();
        }

        if (sellIn <= SECOND_QUALITY_BOOST_DAYS) {
            incrementQuality();
        }
    }


    public void updateSellIn() {
        sellIn--;
    }

    @Override
    public void handleExpired() {

    }
}

class LegendaryItem extends Item{

    public LegendaryItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    @Override
    protected void updateQuality() {

    }

    @Override
    protected void handleExpired() {

    }

    @Override
    public boolean isExpired() {
        return false; // Legendary items never expire
    }
}

class ConjuredItem extends  Item{
    @Override
    protected void updateQuality() {
        super.decrementQuality();
        super.decrementQuality();

        if(sellIn < 0){
            super.decrementQuality();
            super.decrementQuality();
        }
    }

    @Override
    protected void handleExpired() {

    }

    public ConjuredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
}