package qlvemaybay;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuanLyBay {
	static Scanner input = new Scanner(System.in);
	static String path = "ghifile/QLMayBay/";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<VeMayBay> list = new ArrayList<VeMayBay>();
		int choose;
		
		do {
			showMenu();
			choose = input.nextInt();
			switch(choose) {
			case 1:
				input(list);
				break;
			case 2:
				save(list, path + "DuLieuBay.dat");
				break;
			case 3:
				list = read( path + "DuLieuBay.dat");
				display(list);
				break;
			case 4: 
				sort(list);
				break;
			case 5: 
				saveByAirline(list);
				break;
			case 6:
				System.out.println("Thoat!!!");
				break;
			default:
				System.out.println("Nhap lai");
				break;
			}
			
		}while(choose != 6);

	}
	
	static void input(List<VeMayBay> list) {
		System.out.println("Nhap so ve may bay: ");
		int n = input.nextInt();
		
		for(int i =0; i<n; i++) {
			VeMayBay veMayBay = new VeMayBay();
			veMayBay.input();
			
			list.add(veMayBay);
		}
	}
	
	static void display(List<VeMayBay> list) {
		for(VeMayBay veMayBay : list)
			veMayBay.display();
	}
	
	static List<VeMayBay> read(String fileName) {
		List<VeMayBay> list = null;
		FileInputStream inp = null;
		ObjectInputStream iss = null;
		try {
			inp = new FileInputStream(fileName);
			iss = new ObjectInputStream(inp);
			
			list = (List<VeMayBay>) iss.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(inp != null)
				try {
					inp.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(iss != null)
				try {
					iss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		return list;
	}
	
	static void save(List<VeMayBay> list, String fileName) {
		FileOutputStream out = null;
		ObjectOutputStream oss = null;
		
		File dir = new File(path);
		if(!dir.exists())
			dir.mkdir();
		
		try {
			out = new FileOutputStream(fileName);
			oss = new ObjectOutputStream(out);
			
			oss.writeObject(list);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(out != null)
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			if(oss != null)
				try {
					oss.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	
	static void sort(List<VeMayBay> list) {
		Collections.sort(list, new Comparator<VeMayBay>() {
			@Override
			public int compare(VeMayBay o1, VeMayBay o2) {
				if(o1.getPrice() > o2.getPrice())
					return 1;
				else if(o1.getPrice() < o2.getPrice())
					return -1;
				else return 0;
			}
		});
		for(VeMayBay veMayBay : list)
			veMayBay.display();
	}
	
	static void saveByAirline(List<VeMayBay> list) {
		List<VeMayBay> vietjetAirList = getAirline(list, "VJ");
		save(vietjetAirList, path + "VietjetAirline.dat");
		
		List<VeMayBay> VietNamAirlineList = getAirline(list, "VN");
		save(VietNamAirlineList, path  + "VietNamAirline.dat");
		
		List<VeMayBay> jestarList = getAirline(list, "JE");
		save(jestarList, path + "JestarAirline.dat");
	}
	
	static List<VeMayBay> getAirline(List<VeMayBay> list, String prex){
		List<VeMayBay> airlineList = new ArrayList<VeMayBay>();
		
		for(VeMayBay veMayBay : list) {
			if(veMayBay.getId().startsWith(prex))
				airlineList.add(veMayBay);
		}
		return airlineList;
	}
	
	static void showMenu() {
		System.out.println("\n");
		System.out.println("1. Nhap thong tin N chuyen bay");
		System.out.println("2. Luu thong tin");
		System.out.println("3. Doc thong tin tu file và hien thi");
		System.out.println("4. Sap xep theo gia");
		System.out.println("5. In thong tin moi hang ra 1 file");
		System.out.println("6. Thoat");
		System.out.print("Choose: ");
	}

}
