package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class bj14501_study {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 완전탐색
		// for문을 돌면서 -> 이중 for문일지는 생각해보기
		// Ti-1 만큼 뒤에 거 없애고
		// Pi 더하기
		
		int N = sc.nextInt(); // 퇴사까지 남은 날짜
		
		List<Integer> days = new ArrayList<>();
		List<Integer> wages = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			int day = sc.nextInt();
			int wage = sc.nextInt();
			days.add(day);
			wages.add(wage);
		}
		
		for(int i=0; i<days.size(); i++) {
			System.out.print(days.get(i) + " ");
		}
		System.out.println();
		for(int i=0; i<days.size(); i++) {
			System.out.print(wages.get(i) + " ");
		} System.out.println();
		
		int[] totals = new int[N];
		
		
		for(int i=0; i<N; i++) { // 일하는 기간의 합이 N을 넘지 않고, 퇴사 전에 일을 끝내는 경우 탐색
			int total = 0;
			int[] temp = new int[days.size()]; // 일하는 날을 표시할 임시 배열 선언
			check : for(int j=i; j<temp.length; j++) { // i부터 시작
				if(temp[j] == -1) { // 이미 일하느라 못하는 날이면
					continue check; // 다시 돌아감
				}
				for(int k=j+1; k<days.get(j)+j; k++) { // 일하는 날만큼
					if(k>=days.size()) {
						temp[j] = -1;
						break;
					}
					temp[k] = -1; // 뒤에를 -1로 바꿈
					
				}
			}
			for(int p=i; p<wages.size(); p++) {
				if(temp[p] != -1) {
					total = total + wages.get(p);
				}
			} totals[i] = total;
			System.out.println(total);
			System.out.println(Arrays.toString(temp));
		}
		
		int max = Integer.MIN_VALUE;
		for(int i=0; i<totals.length; i++) {
			if(max < totals[i]) {
				max = totals[i];
			}
		}
		
		System.out.println(max);
	}
}
