/**
 * Created by christianhasselstrom on 04/06/2016.
 */
public class Main
{
    public static void main(String[] args)
    {
        AirbnbMediator denmark = new AirbnbMediator();

        Copenhagen hans = new Copenhagen(denmark);
        Aarhus chris = new Aarhus(denmark);
        Copenhagen mille = new Copenhagen(denmark);
        Aarhus victoria = new Aarhus(denmark);

        hans.buyOffer("Treværelses et sted i Århus" , "15/6-18/6" , 500);
        hans.buyOffer("Etværelses i KBH K" , "28/7-29/7" , 3000);
        chris.buyOffer("Toværlses på Vesterbro" , "10/6-14/6" , 600);
        mille.buyOffer("Værelse i Nordvest" , "11/7-14/7" , 600);

        System.out.println();

        chris.saleOffer("Treværelses et sted i Århus" , "15/6-18/6" , 500);
        mille.saleOffer("Etværelses i KBH K" , "28/7-29/7" , 3000);
        chris.saleOffer("Stort hus i Århus C" , "18/7-20/7" , 400);
        victoria.saleOffer("Toværelses i Århus V", "18/8-20/8", 250);

        System.out.println();


        victoria.buyOffer("Stort hus i Århus C" , "18/7-20/7" , 400);
        chris.buyOffer("Toværlses på Vesterbro" , "15/6-20/6" , 1000);

        System.out.println();

        denmark.getAvaiAppart();
    }
}
