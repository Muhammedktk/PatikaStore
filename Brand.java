import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public enum Brand {

    SAMSUNG(0),
    LENOVO(1),
    APPLE(2),
    HUAWEI(3),
    CASPER(4),
    ASUS(5),
    HP(6),
    XIOMI(7),
    MONSTER(8);

    static List<String> brandNames = new ArrayList<>();

    int brandOrdinal = 0;
    Brand(int ord){
        this.brandOrdinal = ord;
    }
    public static Brand byOrdinal(int ord){
        for (Brand b : Brand.values()) {
            if(b.brandOrdinal == ord){
                return b;
            }
        }
        return null;
    }
    public static void showList(){
        System.out.println("Markalarımız:");
        System.out.println("-------------");
        for (Brand b : Brand.values()) {
            brandNames.add("- "+b.toString().charAt(0)+b.toString().substring(1, b.toString().length()).toLowerCase().replace("ı", "i"));
        }
        brandNames = brandNames.stream().sorted().collect(Collectors.toList());
        brandNames.forEach(System.out::println);
    }
}