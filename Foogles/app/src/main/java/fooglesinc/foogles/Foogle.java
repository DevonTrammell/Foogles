package fooglesinc.foogles;

/**
 * Created by joeyjennings on 4/6/18.
 */

public class Foogle {

    private int _id;
    private String foogleName;
    private int energy;

    public Foogle() {

    }

    public Foogle(int id, String foogleName, int energy)
    {
        this._id = id;
        this.foogleName = foogleName;
        this.energy = energy;

    }

    public Foogle( String foogleName, int energy)
    {
        this.foogleName = foogleName;
        this.energy = energy;
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

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
}
