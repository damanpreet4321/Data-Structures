import java.util.*;
class matrix
{
	String[] verti=new String[]{"Hostel-D","Hostel-C","Hostel-B","Hostel-A" ,"Hostel-H","Hostel-J","Hostel-M", 
								"Hostel-FRC" , "COS","OAT","Hostel-K","Hostel-L","Hostel-G","Hostel-N","PG-Hostel","MainGate","Directorate",
								"Audi","JaggiCafeteria","SBI","B-Block","C-Block","D-Block","E-Block","F-Block","Parking",
								"ICICI","G-Block","G-Cafeteria","TAN-Building","AaharCanteen","Library","Workshop","SportsComplex",
								"SwimmingPool","HealthCentre","ThaparLibraryGate","Haveli","Guest-House","Running-Track","Aahar","R&D"};
	int N=42;
	int[] dist=new int[N];                 
	int mat[][]=new int[N][N];
	int[] path=new int[N];
	int[] lol=new int[N];
	int aaa=0;
	int backtrack(int r,int z)
	{
		int flag=1;
		f:
		for(int j=0;j<N;j++)
		{	 
			if(mat[r][j]>0)
			{
				if(dist[r]-mat[r][j]==dist[j])
				{
					path[z]=j;z++;
					backtrack(j,z);
					System.out.println("Z is"+z);
					
					for( aaa=aaa++; aaa<N; aaa++)
					{
						lol[aaa]=z;
					}
				//	System.out.println(aaa);
					System.out.println(lol[0]);
					return lol[0];
				}
			}
		}
		return lol[0];
                
		
	}
	boolean checks(int i,int sptset[])
	{
		boolean f=true;
		for(int j=0;j<sptset.length;j++)
		{
			if(i==sptset[j])
			{f=false;break;}
		}
		return f;
	}
	void dijkstra(int s,int sptset[])
	{
		for(int l=0;l<N;l++)
		{sptset[l]=-1;}
		for(int l=0;l<N;l++)
		{dist[l]=Integer.MAX_VALUE;}
		dist[s]=0;
	//	System.out.println(s);
		int i=0,n=0;
		while(n!=N) 
		{
			for(int k=0;k<N;k++)
			{
				if(checks(k,sptset))
				{if(dist[i]>=dist[k]){i=k;}}
			}

			sptset[n]=i;
			//System.out.print(verti[sptset[n]]+"  ");
			n++;
			for(int j=0;j<N;j++)
			{	 
				if(mat[i][j]>0)
				{
					int p=dist[i]+mat[i][j];
					if(checks(j,sptset)&&p<dist[j])
					{dist[j]=p;}
				}
			}
			for(int k=0;k<N;k++)
			{
				if(checks(k,sptset))
				{i=k;break;}
			}
		}
	}
	void shortpath(int s,int d)
	{
		int z=1;
		
		int sptset[]=new int[N];
	//	System.out.println(s);
		dijkstra(s,sptset);
		path[0]=d;
		z=backtrack(d,z);
                for(int l=0;l<aaa;l++)
                {
                    lol[l]=0;
                }
		System.out.println("   "+z);
		for(int k=z-1;k>0;k--)
		{
			System.out.print(verti[path[k]]+"  --> ");
		}
		System.out.println(verti[path[0]]);
		System.out.println("Total Distance is:"+dist[d]+" metres");
		float time=(float)dist[d]/80;
		System.out.println("Average journey time:"+time+" min");
		
		
	} 
	void edge(String x,String y,int d)
	{
		int p=0,q=0;
		for(int i=0;i<N;i++)
		{
			if(verti[i]==x){p=i;}
			if(verti[i]==y){q=i;}
		}
		mat[p][q]=d;
		mat[q][p]=d;
	}
	void show()
	{
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				System.out.print(mat[i][j]+" ");
			
			}
                        System.out.println();
		}
	}
	void food(int loc)
	{
		int q=Integer.MAX_VALUE,q1=0;
		String[] fpoints=new String[]{"AaharCanteen","JaggiCafeteria","G-Cafeteria","COS","Aahar"}; 
		int spttemp[]=new int[N];
		dijkstra(loc,spttemp);
		for(int u=0;u<N;u++)
		{
			for(int v=0;v<5;v++)
			{
				if(verti[u]==fpoints[v])
				{
					if(dist[u]<q)
					{q=dist[u];q1=u;}
				}
			}	
		}
		System.out.println("Nearest Food Point from your location is:"+verti[q1]+" at a distance of:"+q+" metres");
	}
	}

class graphs
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		matrix obj=new matrix();
		obj.edge("Hostel-D","Hostel-C",100);
		obj.edge("Hostel-C","Hostel-B",200);
		obj.edge("Hostel-B","Hostel-A",150);
		obj.edge("Hostel-A","Hostel-H",250);
		obj.edge("Hostel-A","PG-Hostel",150);
		obj.edge("Hostel-H","Hostel-J",150);
		obj.edge("Hostel-J","Hostel-M",300);
		obj.edge("Hostel-J","COS",200);
		obj.edge("COS","OAT",50);
		obj.edge("Hostel-M","Hostel-FRC",100);
		obj.edge("Hostel-FRC","COS",170);	
		obj.edge("Hostel-H","HealthCentre",100);
		obj.edge("SportsComplex","HealthCentre",50);
		obj.edge("SportsComplex","Hostel-K",300);
		obj.edge("COS","Running-Track",30);
		obj.edge("Hostel-K","Hostel-L",100);
		obj.edge("Hostel-G","Hostel-N",50);
		obj.edge("MainGate","Directorate",130);
		obj.edge("MainGate","Audi",450);
		obj.edge("MainGate","Parking",80);
		obj.edge("Directorate","JaggiCafeteria",60);
		obj.edge("Directorate","Audi",80);
		obj.edge("JaggiCafeteria","Audi",30);
		obj.edge("AaharCanteen","Parking",50);
		obj.edge("Aahar","Library",70);
		obj.edge("Library","R&D",40);
		obj.edge("G-Block","G-Cafeteria",30);	
		obj.edge("Directorate","B-Block",50);
		obj.edge("B-Block","C-Block",50);
		obj.edge("C-Block","D-Block",50);
		obj.edge("SBI","Audi",80);
		obj.edge("SBI","ICICI",10);
		obj.edge("B-Block","G-Block",70);
		obj.edge("ICICI","G-Cafeteria",80);
		obj.edge("G-Block","TAN-Building",220);
		obj.edge("D-Block","F-Block",50);
		obj.edge("C-Block","F-Block",50);
		obj.edge("B-Block","E-Block",50);
		obj.edge("E-Block","F-Block",50);
		obj.edge("D-Block","Workshop",50);
		obj.edge("F-Block","Workshop",70);
		obj.edge("Workshop","Library",250);
		obj.edge("SportsComplex","SwimmingPool",50);
		obj.edge("SwimmingPool","Hostel-G",100);
		obj.edge("SportsComplex","HealthCentre",50);
		obj.edge("Library","ThaparLibraryGate",100);
		obj.edge("MainGate","ThaparLibraryGate",400);
		obj.edge("Hostel-H","Hostel-G",200);
		obj.edge("Hostel-G","TAN-Building",100);
		obj.edge("Workshop","TAN-Building",250);
		obj.edge("D-Block","TAN-Building",250);
		obj.edge("Haveli","PG-Hostel",100);
		obj.edge("Haveli","Guest-House",50);
		obj.edge("Audi","Guest-House",100);
		obj.edge("E-Block","AaharCanteen",50);
		obj.edge("Hostel-G","HealthCentre",100);
			System.out.println("Indexes for different places on the Thapar map are: ");
		for(int l=0; l<42; l++)
		{
			System.out.println((l) + ". " + obj.verti[l] + "   ");
		}
             //   obj.show();
		for(int p=1; p>0;)
		{
				System.out.println("\n\n--------------------------Welcome to Thapar Maps--------------------------\n\nPlease choose one of the following two options.\n\n1. I need to reach from one place to another in least time.\n\n2. I need to reach the nearest place for food.\n\n3. Exit\n\n");
		int option = sc.nextInt();
	//	for(int p=1; p>0; p++)
	//	{
//        for(int l=0;l<obj.N;l++)
//                {
//                    obj.lol[l]=0;
//                }
        obj.aaa=0;
		if(option == 1)
		{
			System.out.println("Please enter the source place.\n");
			int sr = sc.nextInt();
			System.out.println("Please enter the destination.\n");
			int ds = sc.nextInt();
			System.out.println("\n\n");
		//	System.out.println("----------------------"+ds+"-------------"+sr+"------------");
			obj.shortpath(sr,ds);
	//		obj.shortpath("OAT","COS");
		}
		else if(option == 2)
		{
			System.out.println("Please enter the source place.\n");
			int sor = sc.nextInt();
			obj.food(sor);
		}

		else if(option == 3)
		{
			System.out.println("-------------------You have succesfully exited the program.---------------------\n\n");
			break;
		}

		else 
		{
			System.out.println("Invalid Option. Please enter a valid option.\n\n");
		}
		}
	}
}
	
