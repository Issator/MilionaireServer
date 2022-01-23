package pwszt.tar.MilionaireServer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwszt.tar.MilionaireServer.dao.PlayerData;
import pwszt.tar.MilionaireServer.model.Player;
import pwszt.tar.MilionaireServer.model.PlayerLoginBody;

import java.io.*;
import java.util.*;

@Service
public class PlayerService {

    private final PlayerData playerData;
    private final List<Player> PlayerDB = new ArrayList<>();

    @Autowired
    public PlayerService(PlayerData playerData){
        List<Player> playersFromFile = new ArrayList<>();
        playersFromFile.addAll(getPlayersFromFile());
        this.playerData = playerData;

        if(!playersFromFile.isEmpty())
        {
            this.PlayerDB.addAll(playersFromFile);
        }

    }

    // DODAJ GRACZA
    public Player addPlayer(PlayerLoginBody playerLoginBody){
        UUID id = UUID.randomUUID();
        Player player = new Player(id,playerLoginBody.getNick(),playerLoginBody.getPassword());
        PlayerDB.add(player);
        addPlayerToFile(player);
        return playerData.returnPlayer(player);
    }

    // WYPISZ GRACZY
    public List getPlayers(){
        return PlayerDB;
    }

    // USUN GRACZA
    public HashMap deletePlayerById(UUID id){
        HashMap<String, String> serverAnswer = new HashMap<>();

        Optional<Player> toDeletePlayer;
        toDeletePlayer = PlayerDB.stream()
                                 .filter(player -> player.getId().equals(id))
                                 .findFirst();
        if(toDeletePlayer.isEmpty()){
            serverAnswer.put("isExist","false");
            serverAnswer.put("isDeleted","false");
        } else {
            PlayerDB.remove(toDeletePlayer.get());
            serverAnswer.put("isExist","true");
            serverAnswer.put("isDeleted","true");
        }
        updatePlayerFile();
        return playerData.deletePlayerAnswer(serverAnswer);
    }

    // ZNAJDZ GRACZA
    public Optional<Player> getPlayerByLoginBody(PlayerLoginBody playerLoginBody){

        return  PlayerDB.stream()
                .filter(player ->
                        player.getNick().equals(playerLoginBody.getNick()) &&
                        player.getPassword().equals(playerLoginBody.getPassword()))
                .findFirst();
    }

    // ZMIEN DANE GRACZA
    public Player updatePlayer(Player player){
        Player toEdit   =   PlayerDB.stream()
                                    .filter(p -> p.getId().equals(player.getId()))
                                    .findFirst().orElse(null);

        if (toEdit != null){
            int indexOf = PlayerDB.indexOf(toEdit);
            PlayerDB.set(indexOf,player);
            updatePlayerFile();
        }
        return toEdit;
    }

    //EDYTUJ PLIK
    public int addPlayerToFile(Player player){
            try {
                FileWriter fw = new FileWriter("baza/players.csv",true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter out = new PrintWriter(bw);
                String toSave = player.getId() + ";" +
                        player.getNick() + ";" +
                        player.getPassword() + ";";

                out.println(toSave);

                out.close();
                bw.close();
                fw.close();
            } catch (IOException e){
                e.printStackTrace();
                return -1;
            }
            return 0;
    }

    // POBIERANIE GRACZY
    public List<Player> getPlayersFromFile(){
        List<Player> playerList = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(
                new FileReader("baza/players.csv"));

            String line;
            while ((line= br.readLine())!=null){
                String [] data = line.split(";");
                Player player = new Player(UUID.fromString(data[0]),data[1],data[2]);
                playerList.add(player);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("NIE ZNALEZIONO PLIKU Z GRACZAMI");
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            System.out.println("BLAD ODCZYTU PLIKU Z GRACZAMI");
            e.printStackTrace();
            return null;
        }
        return playerList;
    }

    //AKTUALIZOWANIE BAZY GRACZY
    public void updatePlayerFile(){
        try {
            FileWriter fw = new FileWriter("baza/players.csv");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
            for(Player player: PlayerDB){
                String toSave = player.getId() + ";" +
                        player.getNick() + ";" +
                        player.getPassword() + ";";

                out.println(toSave);
            }
            out.close();
            bw.close();
            fw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

}
