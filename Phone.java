import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Phone extends Product {
    public static List<Phone> phones = new ArrayList<>();
    private Integer memorySize;
    private Color color;
    private Integer batteryPower;


    public Phone() {
        if(phones.isEmpty()){
            PhoneList();
        }
    }

    public Phone(String productId, String productName, Double sellingPrice, Integer stockAmount, Brand brandInfo,
                 Double screenSize, Integer ram, Integer memorySize, Color color, Integer batteryPower) {
        super(productId, productName, sellingPrice, stockAmount, brandInfo, screenSize, ram);
        this.memorySize = memorySize;
        this.color = color;
        this.batteryPower = batteryPower;
    }

    public Integer getMemory() {
        return memorySize;
    }

    public void setMemory(Integer memorySize) {
        this.memorySize = memorySize;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Integer getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(Integer batteryPower) {
        this.batteryPower = batteryPower;
    }

    @Override

    public String toString() {
        return super.toString().replace("Product", "Phone")+"\n[batteryPower=" + batteryPower + ", color=" + color + ", memorySize=" + memorySize + "]";
    }

    private static List<Phone> PhoneList(){

        Phone p9Lite = new Phone("1", "P9 LITE", 1500.0, 10, Brand.HUAWEI, 5.2, 3, 16, Color.PURPLE, 3000);
        Phone iphone13 = new Phone("2", "IPHONE 13", 15000.0, 5, Brand.APPLE, 6.1, 8, 128, Color.BLUE, 5000);

        phones.add(p9Lite);
        phones.add(iphone13);

        return phones;
    }

    public static void showPhoneList(Scanner sc){
        if(phones.isEmpty()){
            PhoneList();
        }

        String leftAlignFormat = "| %-2s | %-12s | %-8s TL | %-8s | %-8d GB | %-8s | %-8s | %-5d GB | %-8s |%n";
        String line = "+------------------------------------------------------------------------------------------------------+%n";
        System.out.format(line);
        System.out.format("| ID | Ürün Adı     | Fiyat       | Marka    | Depolama    | Ekran    | Pil      | RAM      | Renk     |%n");
        System.out.format(line);



        for (Phone phone : phones) {
            System.out.format(leftAlignFormat,phone.getProductId(),phone.getProductName(),phone.getSellingPrice(),
                    phone.getBrandInfo(),phone.getMemory(),phone.getScreenSize(),phone.getBatteryPower(),phone.getRam(),
                    phone.getColor());
        }
        System.out.format(line);

        System.out.println("-------Menu-------");
        System.out.println("[1] Telefon ekle.");
        System.out.println("[2] Ana Menüye dön");
        System.out.println("Çıkmak için herhangi bir tuşa basın.");
        int secim = sc.nextInt();

        switch(secim){
            case 1:
                addPhone(new Phone());
                break;
            case 2:
                Main.main(null);
                break;
            default:
                break;
        }
    }

    public static void addPhone(Phone getPhone){

        Scanner sc = new Scanner(System.in);
        Phone phone = (Phone) Product.addProduct(getPhone);

        System.out.print("Hafıza:");
        phone.setMemory(sc.nextInt());

        System.out.print("Renk id:");
        phone.setColor(Color.byOrdinal(sc.nextInt()));

        System.out.println("Batarya Gücü:");
        phone.setBatteryPower(sc.nextInt());

        phones.add(phone);
        showPhoneList(sc);
    }


}
