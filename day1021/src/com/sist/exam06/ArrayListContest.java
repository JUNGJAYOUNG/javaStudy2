package com.sist.exam06;
import java.util.*;

public class ArrayListContest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Double> score = new ArrayList<Double>();
		double sum=0;
		for(int i=0;i<10;i++) {		//�����Է� for��
			while(true) {
				System.out.print(i+1+"��° ������ �Է��ϼ���:");
				double input=sc.nextDouble();
				if(input<0.0 || input>10.0) {
					System.out.println("�߸��� �Է��Դϴ�.");
				}else {
					score.add(input);
					sum+=input;
					break;
				}
			}
		}
		double max=score.get(0);		//���� ū �� ���ϱ�
		int indexMax=0;
		for(int i=1;i<score.size();i++) {
			if(max<score.get(i)) {
				max=score.get(i);
				indexMax=i;
			}
		}
		
		double min=score.get(0);	//���� ���� �� ���ϱ�
		int indexMin=0;
		for(int j=1;j<score.size();j++) {
			if(min>score.get(j)) {
				min=score.get(j);
				indexMin=j;
			}
		}
		sum-=score.get(indexMin);	//�հ迡�� ���� ���� �� ����
		sum-=score.get(indexMax);	//�հ迡�� ���� ū �� ����
		score.remove(indexMax);		//��������Ʈ���� ���� ū �� ����
		score.remove(indexMin);		//��������Ʈ���� ���� ���� �� ����	
		
		
		System.out.println(score);
		System.out.println("������(������):"+sum+"��");
	}

}
