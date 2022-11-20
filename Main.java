import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner inp = new Scanner(System.in);
        System.out.println("-------Menu-------");
        System.out.println("[1] Markaları Listele");
        System.out.println("[2] Telefonları Listele");
        System.out.println("[3] Notebookları Listele");
        System.out.println("[4] Ürün ekle");
        System.out.println("Çıkmak için herhangi bir tuşa basın.");
        System.out.println("Seç:");
        int secim = inp.nextInt();

        switch(secim){
            case 1:
                Brand.showList();
                Main.main(null);
                break;

            case 2:
                Phone.showPhoneList(inp);
                break;

            case 3:
                Notebook.showNotebookList(inp);
                break;

            case 4:
                System.out.println("[1] Telefon ekle");
                System.out.println("[2] Notebook ekle");
                System.out.println("[3] Ana Menüye dön");
                System.out.println("Çıkış yapmak için farklı bir tuşa basın");
                switch (inp.nextInt()) {
                    case 1:
                        Phone.addPhone(new Phone());
                        break;
                    case 2:
                        Notebook.addNotebook(new Notebook());
                        break;
                    case 3:
                        Main.main(null);
                        break;

                    default:
                        break;
                }
                break;

            default:
                inp.close();
                break;
        }
        inp.close();


    }

}
