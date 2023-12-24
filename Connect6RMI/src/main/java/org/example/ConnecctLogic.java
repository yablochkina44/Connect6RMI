package org.example;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;

public class ConnecctLogic extends UnicastRemoteObject implements Connect{

    String QueueStep = "white";
    private int PlayerId = 0;
    public String[][] BoardState = new String[19][19];
    //w - белый камень
    //b - черный камень
    //o - пустая клетка

    //заполняем состояния доски(изначально вся пустая)
    public void CreateBoardState(){
        for (int i=0; i<19; i++){
            for (int j=0; j<19; j++){
                BoardState[i][j] = "o";
            }
        }
    }
    @Override
    public int GetPlayerCommand() throws RemoteException {
        CreateBoardState();
        int CurrentPlId = PlayerId;
        PlayerId += 1;
        //System.out.println(CurrentPlId);
        return CurrentPlId;
    }
    @Override
    public String GetCurrentStep(int id) throws RemoteException {
        if (id == 0){
            return "white";
        }
        else{
            return "black";
        }
    }

    @Override
    public String GetQueueStep() throws RemoteException {
        return QueueStep;
    }

    @Override
    public void SetQueueStep(String step) throws RemoteException {
        QueueStep = step;
    }

    @Override
    public String GetStateBoard(int i, int j) throws RemoteException {
        return BoardState[i][j];
    }

    @Override
    public void SetStateBoard(int i, int j, String s) throws RemoteException {
        BoardState[i][j] = s;
    }

    @Override
    public String CheckWinner() throws RemoteException {
        int countBlack = 0;
        int countWhite = 0;
        for (int i=0; i<19; i++){
            for (int j=0; j<19; j++){
                if (Objects.equals(BoardState[i][j], "b")){
                    countBlack += 1;
                    countWhite = 0;
                    if (countBlack >= 6){
                        return "black";
                    }
                }
                else if (Objects.equals(BoardState[i][j], "w")){
                    countWhite += 1;
                    countBlack = 0;
                    if (countWhite >= 6){
                        return "white";
                    }
                }
                else{
                    countWhite = 0;
                    countBlack = 0;
                }

            }
        }
        countBlack = 0;
        countWhite = 0;
        for (int i=0; i<19; i++){
            for (int j=0; j<19; j++){
                if (Objects.equals(BoardState[j][i], "b")){
                    countBlack += 1;
                    countWhite = 0;
                    if (countBlack >= 6){
                        return "black";
                    }
                }
                else if (Objects.equals(BoardState[j][i], "w")){
                    countWhite += 1;
                    countBlack = 0;
                    if (countWhite >= 6){
                        return "white";
                    }
                }
                else{
                    countWhite = 0;
                    countBlack = 0;
                }

            }
        }
        return "o";
    }


    public ConnecctLogic() throws RemoteException{

    }


}
