/**
 * Created by christianhasselstrom on 02/06/2016.
 */
public class Programmer
{
    private String nickName = "Nick name";
    public String favoriteLanguage = "Favorite programming language";

    protected final void changeNick(String newNick)
    {
        this.nickName = newNick;
    }

    protected String getNickName()
    {
        return this.nickName;
    }

    public void goProgramming()
    {
        System.out.println("Is programming in " + favoriteLanguage);
    }

    //Programmer class
    public void takeBreak()
    {
        System.out.println(nickName + " is taking a 5 minute break");
    }

    public Programmer()
    {
    }
    public Programmer(String nickName, String favoriteLanguage)
    {
        this.changeNick(nickName);
        this.favoriteLanguage = favoriteLanguage;
    }
}
