/**
 * Created by christianhasselstrom on 02/06/2016.
 */
public class JavaGuy extends Programmer
{
    public String hobby = "Favorite hobby";

    public void findFavHobby()
    {
        System.out.println("Favorite hobby is: " + hobby);
    }
    //JavaGuy class
    public void takeBreak()
    {
        System.out.println(this.getNickName() +  " is taking a 10 minute break");
    }

    public void takeBreak(int time)
    {
        System.out.println(this.getNickName() + " is taking a " + time + " minute break");
    }

    public JavaGuy()
    {
    }

    public JavaGuy(String nickName, String favoriteLanguage, String computer)
    {
        super(nickName, favoriteLanguage);
        this.hobby = computer;
    }


}
