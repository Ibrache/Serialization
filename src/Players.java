import java.io.Serializable;
import java.util.ArrayList;

public class Players implements Serializable {
    String nickName;
    double rating;

    public Players(){
        this.nickName = "no nick";
        this.rating = 0.0;
    }

    public Players(String nickName, double rating) {
        this.nickName = nickName;
        this.rating = rating;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getUsersData(){
        return nickName+" "+rating;
    }

}