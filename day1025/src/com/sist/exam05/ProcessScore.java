package com.sist.exam05;

public class ProcessScore {
	double avg;
	public ProcessScore(int []score) throws IllegalScore {
		int sum=0;
		for(int i=0;i<score.length;i++) {
			if(score[i]<0) {
				throw new IllegalScore("성적은 양수여야 합니다.");
			}
			sum=+score[i];
		}
		avg=sum/score.length;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
}
