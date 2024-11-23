package Parking_Lot_System;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Parking_Lot_System {
    public static void main(String[] args)throws IOException {
        ParkingFloor floor=new ParkingFloor(0,4999,5000,9999);
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        boolean entry=true;
        while(entry) {
            System.out.println("Enter\n1. If you want to park a vehicle\n2. Enter 2 if you want to unPark a vehicle\n3. Enter 3 to exit");
            int choice=Integer.parseInt(br.readLine());
            switch (choice){
                case 1: floor.park();
                break;
                case 2:floor.unPark();
                break;
                case 3: entry=false;
                break;
                default:System.out.println("Enter a valid choice");
            }
        }
    }

}
