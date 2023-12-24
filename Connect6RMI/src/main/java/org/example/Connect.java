package org.example;
import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Connect extends Remote{

    int GetPlayerCommand() throws RemoteException;

    String GetCurrentStep(int id) throws RemoteException;

    String GetQueueStep() throws RemoteException;

    void SetQueueStep(String step) throws RemoteException;

    String GetStateBoard(int i, int j) throws RemoteException;

    void SetStateBoard(int i, int j, String s) throws RemoteException;

    String CheckWinner() throws RemoteException;

}
