package passerRating;

import java.util.Scanner;

public class passerRating {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.print("What the quarterback's first name?");
		String firstName = input.next();
		System.out.print("What the quarterback's last name?");
		String lastName = input.next();
		System.out.print("is " + firstName + " " + lastName +" in college or the pros (enter 0 for college or 1 pros:  ");
		byte collegeOrPro = input.nextByte();
		System.out.print(collegeOrPro);
		boolean pro = true;
		byte x = 0;
		while (x==0){
			if (collegeOrPro == 0){
				pro =false;
				x++;
			}
			else if (collegeOrPro == 1){
				pro = true;
				x++;
			}
			else{
				System.out.print("Invalid value. Enter valid response:  ");
				collegeOrPro = input.nextByte();
			}
		}
		System.out.print("Enter " + firstName + " " + lastName +"'s passes attempted:  ");
		double att = input.nextDouble();
		byte y = 0;
		while (y==0){
			if (att >= 0){
				y++;
			}
			else{
				System.out.print("Invalid value. Enter valid passes attempted:  ");
				att = input.nextDouble();
			}
		}	
		System.out.print("Enter " + firstName + " " + lastName + "'s completed passes:  ");
		double comp = input.nextDouble();
		byte z = 0;
		while (z==0){
			if (comp >= 0 && comp <= att){
				z++;
			}
			else{
				System.out.print("Invalid value. Enter valid passes completed:  ");
				comp = input.nextDouble();
			}
		}
		System.out.print("Enter " + firstName + " " + lastName + "'s touchdowns thrown:  ");
		double tds = input.nextDouble();
		byte a = 0;
		while (a==0){
			if (tds >= 0 && tds <= comp){
				a++;
			}
			else{
				System.out.print("Invalid value. Enter valid touchdowns:  ");
				tds = input.nextDouble();
			}
		}
		System.out.print("Enter yards thrown by " + firstName + " " + lastName + ":  ");
		double yds = input.nextDouble();
		byte c = 0;
		while(c==0){
			if (yds <= 99*comp && yds >= -99*comp){
			c++;}
			else{
				System.out.print("Invalid value. Enter valid yds:  ");
				yds = input.nextDouble();
			}
		}
		
		System.out.print("Enter interceptions thrown by " + firstName + " " + lastName + ":  ");
		double picks = input.nextDouble();
		byte b = 0;
		while (b==0){
			if (picks >= 0 && picks <= (att-comp)){
				b++;
			}
			else{
				System.out.print("Invalid value. Enter valid interceptions thrown:  ");
				picks = input.nextDouble();
			}
		}
	double qbr;
	if (pro == true){
		double nComp = ((comp/att)-.3)*5;
		if (nComp>=2.375){
			nComp=2.375;
		}
		else if (nComp <= 0){
			nComp = 0;
		}
		double nYds = ((yds/att)-3)/4;
		if (nYds>=2.375){
			nYds=2.375;
		}
		else if (nYds <= 0){
			nYds = 0;
		}
		double nTds = 20*tds/att;
		if (nTds>=2.375){
			nTds=2.375;
		}
		else if (nTds <= 0){
			nTds = 0;
		}
		double nPicks = 2.375 - (picks*25/att);
		if (nPicks>=2.375){
			nPicks=2.375;
		}
		else if (nPicks <= 0){
			nPicks = 0;
		}
		qbr = ((nComp+nYds+nTds+nPicks)/6)*100;
	}
	else {
		qbr = ((8.4*yds)+(330*tds)+(100*comp)-(200*picks))/att;
	}
		System.out.println(firstName + " " + lastName + "'s quarterback rating is " + String.format( "%.1f", qbr ) );
		}
}




