package com.amair.recursion;
import java.util.Scanner;

public class NQueenClass {
	int row;
	int col;	
	public static NQueenClass[] QueenPosition; 
	NQueenClass(int row, int col){
		this.row = row;
		this.col = col;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number of Queens : ");
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		QueenPosition =  new NQueenClass[n];
		boolean result = helpQueen(n, 0);
		if(result) {
			for(int i=0;i<QueenPosition.length;i++) {
				System.out.println("("+QueenPosition[i].row+","+QueenPosition[i].col+")");
			}
		}
		
		String indent = "";
		for(int i=0;i<2*n+1;i++) {
			indent = indent+"+";
		}
		System.out.println(indent);
		//System.out.println();
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(QueenPosition[i].row==i && QueenPosition[i].col == j) {
					System.out.print("|*|");
					}
					else {
						System.out.print("||");
					}
				}
			System.out.println();
			System.out.println(indent);
			}
		
		s.close();
}

	public static boolean helpQueen(int n , int row) {
		if(n==2||n==3) return false;
		if(n==row) return true;

			for(int col=0;col<n;col++) {
				boolean isSafe = true;
				QueenPosition[row] = new NQueenClass(row,col);
				for(int q=0;q<row;q++) {
					if(QueenPosition[q].col==col||QueenPosition[q].row-QueenPosition[q].col == row-col||
							QueenPosition[q].row+QueenPosition[q].col == row+col) {
						isSafe = false;
					}
				}
				if(isSafe) {
					 if(helpQueen(n,row+1)) return true;
				}
			}
			return false;
	}
}