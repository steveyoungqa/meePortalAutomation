package enums;

/**
 * Created by syn3286 on 31/03/2016.
 */
public enum Country {

    Spain(207),
    Japan(111),
    Korea(205),
    Taiwan(217),
    Vietnam(244),
    China(46),
    HongKong(99),
    UK(236);

    private int value;
    private Country(int value){

        this.value = value;
    }

    public int getCountryValue() {
        return this.value;
    }
}
