/**
 * Created by christianhasselstrom on 25/05/2016.
 */
public class Programmer
{
    private String name;
    private int age;
    private String nickName;

    public CSSInterface cssType;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String tryCss()
    {
        return cssType.css();
    }
    public void setCssType(CSSInterface newCssType)
    {
        cssType = newCssType;
    }


}
