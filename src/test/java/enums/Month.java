package enums;


public enum Month {
    Jan(1),
    Feb(2),
    March(3),
    April(4),
    May(5),
    June(6),
    July(7),
    August(8),
    Sept(9),
    Oct(10),
    Nov(11),
    Dec(12);

    private int value;
    private Month(int value){
        this.value = value;
    }

    public int getMonthValue() {return this.value; }
}
