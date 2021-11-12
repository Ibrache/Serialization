import java.io.Serializable;
import java.util.ArrayList;

public class Game implements Serializable {
    String gameName;
    String ipAddress;
    int port;
    ArrayList<Players> users = new ArrayList();

    public Game(){
        this.gameName = "no name";
        this.ipAddress = "no ip";
        this.port = 0;
        this.users = null;
    }

    public Game(String gameName, String ipAddress, int port, ArrayList<Players> users) {
        this.gameName = gameName;
        this.ipAddress = ipAddress;
        this.port = port;
        this.users = users;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public ArrayList<Players> getPlayers() {
        return users;
    }

    public void setPlayers(ArrayList<Players> users) {
        this.users = users;
    }

    public void addPlayer(Players p1){
        users.add(p1);
    }

    @Override
    public String toString() {
        String temp = gameName+" "+ipAddress+" "+port;
        for (int i = 0; i< users.size(); i++) {
            temp = temp + users.get(i);
        }
        return temp;
    }
}
