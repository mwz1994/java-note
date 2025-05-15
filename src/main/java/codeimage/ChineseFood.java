package codeimage;

public class ChineseFood extends Food{
    int kg;
    String tag;



    public ChineseFood(int kg, String tag) {
        super(tag);

        this.kg = kg;
        this.tag = tag;
    }
}
