public enum Color {
    RED(0),
    PURPLE(1),
    BLUE(2),
    GOLD(3),
    SILVER(4);

    int colorOrdinal = 0;

    Color(int ord){
        this.colorOrdinal = ord;
    }
    public static Color byOrdinal(int ord){
        for(Color c : Color.values()){
            if(c.colorOrdinal == ord){
                return c;
            }
        }
        return null;
    }
}