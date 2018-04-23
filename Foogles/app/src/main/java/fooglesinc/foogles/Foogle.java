package fooglesinc.foogles;

/**
 * Created by joeyjennings on 4/6/18.
 */

public class Foogle {

    private int _id;
    private String foogleName;
    private int level;


    public Foogle() {

    }

    public Foogle(int id, String foogleName, int level)
    {
        this._id = id;
        this.foogleName = foogleName;
        this.level = level;


    }

    public Foogle( String foogleName, int level)
    {
        this.foogleName = foogleName;
        this.level = level;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getFoogleName() {
        return foogleName;
    }

    public void setFoogleName(String foogleName) {
        this.foogleName = foogleName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


}
