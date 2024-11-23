package Parking_Lot_System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {
    HashMap<Integer,Boolean> twoWheelerSpots=new HashMap<>();
    HashMap<Integer,Boolean> fourWheelerSpots=new HashMap<>();
    BufferedReader br;
    ParkingFloor(int twoWheelerStartIndex,int twoWheelerEndIndex,int fourWheelerStartIndex,int fourWheelerEndIndex){
        br=new BufferedReader(new InputStreamReader(System.in));
        this.fourWheelerSpots=new HashMap<>();
        this.twoWheelerSpots=new HashMap<>();
        for(int i=twoWheelerStartIndex;i<=twoWheelerEndIndex;i++) {
            twoWheelerSpots.put(i, true);
        }
        for(int i=fourWheelerStartIndex;i<=fourWheelerEndIndex;i++){
            System.out.println(i+" "+fourWheelerEndIndex);
            fourWheelerSpots.put(i,true);
        }
    }
    public int nextFreeSpot(int type){
        // type==0 indicates a two-wheeler spot
        // type==1 indicates a four-wheeler spot
        if(type==0){
            for(Map.Entry<Integer,Boolean> entrySet:twoWheelerSpots.entrySet()){
                if(entrySet.getValue()){
                    return entrySet.getKey();
                }
            }
        }
        else{
            for(Map.Entry<Integer,Boolean> entrySet:fourWheelerSpots.entrySet()){
                if(entrySet.getValue()){
                    return entrySet.getKey();
                }
            }
        }
        return -1;
    }
    public void park() throws IOException {
        int type=0;
        System.out.println("What is the type of your Vehicle?\nEnter 0 for two-wheeler\nEnter 1 for four-wheeler");
        type=Integer.parseInt(br.readLine());
        //System.out.println("Next Available Free spot for two-wheeler:" + nextFreeSpot(0));
        //System.out.println("Next Available Free spot for four-wheeler:" + nextFreeSpot(1));
        int parkingIndex=nextFreeSpot(type);
        if(parkingIndex<0) {
            System.out.println("Unable to reserve the spot. Please try again later");
        }
            if(type==0){
                twoWheelerSpots.put(parkingIndex,false);
                System.out.println("Parking spot successfully reserved!\n Your parking Id:" + parkingIndex);
            }

            else{
                fourWheelerSpots.put(parkingIndex,false);
                System.out.println("Parking spot successfully reserved!\n Your parking Id:" + parkingIndex);

            }

    }
    public void unPark() throws IOException{
        int type=0;
        System.out.println("What is the type of your Vehicle?\nEnter 0 for two-wheeler\nEnter 1 for four-wheeler");
        type=Integer.parseInt(br.readLine());
        System.out.println("Enter the parking Index");
        int parkingIndex=Integer.parseInt(br.readLine());
        if(type==0){
            twoWheelerSpots.put(parkingIndex,true);
            System.out.println("Your Vehicle is successfully unreserved!");
        }
        else{
            fourWheelerSpots.put(parkingIndex,true);
            System.out.println("Your Vehicle is successfully unreserved!");
        }
    }
    public boolean isAvailable(int parkingIndex,HashMap<Integer,Boolean> spot){
        return spot.get(parkingIndex);
    }
    public void print(){
        System.out.println(twoWheelerSpots);
        System.out.println(fourWheelerSpots);
    }
}
