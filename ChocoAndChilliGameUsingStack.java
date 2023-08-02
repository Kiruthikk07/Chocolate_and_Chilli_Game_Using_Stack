import java.util.Scanner;
class Stack {
	Node tos;
	public class Node{
		String data;
		Node next;
		Node(String data){
			this.data=data;
		}
	}
	Stack(){
		tos=null;
	}
	
	public void push(String data) {
		Node newNode=new Node(data);
		if(tos==null) {
			tos=newNode;
		}
		else {
			newNode.next=tos;
			tos=newNode;
			}
	}
	
	public void pop() {
		tos=tos.next;
	}
	
	public String peek() {
		return tos.data;
	}
	
	public int remain() {
		int length=0;
		Node temp=tos;
		while(temp.next!=null) {
			length++;
			temp=temp.next;
		}
		return length;
	}
}
	
public class ChocoAndChilliGameUsingStack {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Stack obj=new Stack();
		obj.push("chilli");
		for(int i=1;i<=13;i++) {
			obj.push("chocolate");
		}
		System.out.println("---------------------------Welcome to the Game---------------------------\n");
		System.out.println("About : In this game , a bowl consist of 13 Chocolates and 1 Chilli in the last , The player who takes the Chilli will be the loser and other player will be the Winner\n");
		System.out.println("RULE : EACH PLAYER SHOULD TAKE MINIMUM OF 1 CHOCOLATE AND MAXIMUM OF 3 CHOCOLATES IN EVERY TURN\n");
		System.out.println("Enter the name of Player 1 : ");
		String plr1=sc.next();
		System.out.println("Enter the name of Player 2 : ");
		String plr2=sc.next();
		int user1;
		int user2;
		while(true) {
			System.out.println(plr1 + " ,Enter the number of chocolates to take : ");
			user1=sc.nextInt();
			if(user1>3 || user1<=0) {
				System.out.println("Invalid input\nTry Again");
				break;
			}
			else {
				for(int i=1;i<=user1;i++) {
					if(obj.peek().equals("chilli")) {
						System.out.println(plr1 + " got Chilli\n" + plr2 + " wins\n----------Thanks for Playing----------");
						System.exit(0);
					}
					obj.pop();
				}
				if(obj.remain()==0) {
					System.out.println(plr2 + " got Chilli\n" + plr1 + " wins\n----------Thanks for Playing----------");
					System.exit(0);
				}
				System.out.println("Remaining Chocolates : " + obj.remain());
			}
			System.out.println(plr2 + " ,Enter the number of chocolates to take : ");
			user2=sc.nextInt();
			if(user2>3 || user2<=0) {
				System.out.println("Invalid input\nTry Again");
				break;
			}
			else {
				for(int i=1;i<=user2;i++) {
					if(obj.peek().equals("chilli")) {
						System.out.println(plr2 + " got Chilli\n" + plr1 + " wins\n----------Thanks for Playing----------");
						System.exit(0);
					}
					obj.pop();
				}	
				if(obj.remain()==0) {
					System.out.println(plr1 + " got Chilli\n" + plr2 + " wins\n----------Thanks for Playing----------");
					System.exit(0);
				}
				System.out.println("Remaining Chocolates : " + obj.remain());
			}
		}
	}
}
