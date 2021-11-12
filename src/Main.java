import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

//СЕРИАЛИЗАЦИЯ ВТОРАЯ ЗАДАЧА

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList <Players> users = new ArrayList<>();
        ArrayList <Game> games = new ArrayList<>();
        Game new_game= new Game();
        while (true){
            System.out.println("PRESS [1] TO CREAT GAME\nPRESS [2] TO ADD PLAYER TO GAME\n"+
                    "PRESS [3] TO PLAY GAME\nPRESS [0] TO EXIT");
            String choice = in.next();
            if (choice.equals("1")) {
                System.out.println("ADD NAME GAME:");
                new_game.setGameName(in.next());
                System.out.println("ADD IP ADDRESS");
                new_game.setIpAddress(in.next());
                System.out.println("ADD PORT");
                new_game.setPort(in.nextInt());
                games = readGame();
                games.add(new_game);
                saveGame(games);
            } else if (choice.equals("2")) {
                games = readGame();
                for (int i=0; i<games.size(); i++) {
                    System.out.println(games.indexOf(games.get(i))+") "+games.get(i).getGameName());
                }
                System.out.println("Choose game by its index:");
                int ch1 = in.nextInt();
                for (int i=0; i<games.size(); i++) {
                    if (ch1 == games.indexOf(games.get(i))) {
                        Players new_user = new Players();
                        System.out.println("ADD NICKNAME");
                        new_user.setNickName(in.next());
                        System.out.println("ADD RATING");
                        new_user.setRating(in.nextDouble());
                        users.add(new_user);
                        games.get(ch1).setPlayers(users);
                        saveGame(games);
                    }
                }
            } else if (choice.equals("3")) {
                games = readGame();
                for (int i=0; i< games.size(); i++) {
                    System.out.println(games.get(i).toString());
                }
            } else if (choice.equals("0")) {
                System.exit(0);
            }
        }
    }

    public static void saveGame(ArrayList<Game> games){
        try{
            ObjectOutputStream outStream =
                    new ObjectOutputStream(new FileOutputStream("src/settings.data"));
            outStream.writeObject(games);
            outStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Game> readGame(){
        ArrayList<Game> gam = new ArrayList<>();
        try{
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("src/settings.data"));
            gam = (ArrayList)inputStream.readObject();
            inputStream.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return gam;
    }
}
