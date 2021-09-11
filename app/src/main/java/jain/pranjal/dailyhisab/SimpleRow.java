package jain.pranjal.dailyhisab;

/**
 * Created by hp on 6/23/2019.
 */

public class SimpleRow {
    String titles;
    String descriptions;
    int image;

    public SimpleRow(String titles, int image) {
        this.titles = titles;
        this.image = image;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}