
import java.io.*;

public class MarsRovers{
	
	public static void main(String[] args) {
		try{

			String line;
			String nav;
			String tokens[];
			int i, plateau;
			int xmax, ymax;
			int rx, ry;
			char limit;
			char rd, rdnew;

			//leitura do arquivo de entrada
			FileInputStream fs = new FileInputStream("mars_rovers.txt");
			DataInputStream in = new DataInputStream(fs);
      		BufferedReader br = new BufferedReader(new InputStreamReader(in));

      		//abrir arquivo para gravação de resultados
      		FileWriter fw = new FileWriter("mars_rovers_results.txt");
    		PrintWriter pw = new PrintWriter(fw);

			line = br.readLine();
			tokens = line.split(" ");

			//leitura da primeira linha (valores máximos de navegação)
			xmax = Integer.parseInt(tokens[0]);
			ymax = Integer.parseInt(tokens[1]);

			
			System.out.println("--------------------------------------------------");
			System.out.println("            Mars Rovers Navigation"                );
			System.out.println("--------------------------------------------------");

			System.out.println("Low-left coordinates: (0,0)");
			System.out.println("Upper-right coordinates: ("+ xmax + ","+ ymax + ")");
			System.out.println();
			plateau = (xmax + 1) * (ymax + 1);   // tamanho do tabuleiro
			System.out.println("Paltaeu: " + plateau + " grids.");
			System.out.println();



			while((line = br.readLine()) != null){

				tokens = line.split(" ");
				rx = Integer.parseInt(tokens[0]);
				ry = Integer.parseInt(tokens[1]);
				rd = tokens[2].charAt(0);

				System.out.println("--------------------------------------------------");
				System.out.println("Starting navigation...");
				System.out.println();
				System.out.println("Initial rover's position: ("+ rx +","+ ry +")");
				System.out.println("Rover's orietation: " + rd);
				System.out.println();


				pw.printf("--------------------------------------------------\n");
				pw.printf("Starting navigation...\n");
				pw.println();
				pw.printf("Initial rover's position: (%d, %d)\n", rx, ry);
				pw.printf("Rover's orietation:  %c", rd);
				pw.println();



				nav = br.readLine();
				System.out.println("String of navigation: " + nav);
				for (i = 0; i < nav.length() ; i++) {

					rdnew = ' ';

					switch(nav.charAt(i)){
						case 'L':
							if(rd == 'E') rdnew  = 'N';
							if(rd == 'N') rdnew  = 'W';
							if(rd == 'W') rdnew  = 'S';
							if(rd == 'S') rdnew  = 'E';
							rd = rdnew;
							System.out.println("Orietation changed!");
							System.out.println();
							break;

						case 'R':
							if(rd == 'E') rdnew  = 'S';
							if(rd == 'N') rdnew  = 'E';
							if(rd == 'W') rdnew  = 'N';
							if(rd == 'S') rdnew  = 'W';
							rd = rdnew;
							System.out.println("Orietation changed!");
							System.out.println();
							break;

						case 'M': 
							limit = 'N';
							if(rd == 'E'){
								if(rx == xmax) 
									limit = 'S';
								else
									rx = rx + 1; 
							}
							if(rd == 'N'){
								if(ry == ymax)
									limit = 'S';
								else
									ry = ry + 1;
							}
							if(rd == 'W'){
								if(rx == 0)
									limit = 'S';
								else
									rx = rx - 1; 
							}
							if(rd == 'S'){
								if(ry == 0)
									limit = 'S';
								else
									ry = ry - 1;
							} 
							if (limit == 'N'){
						        Thread.sleep(1000);
						        System.out.println("Moving completed!");
						        Thread.sleep(500);
						        System.out.println();
						    } else {
						        System.out.println("Movement not realized! Limit of the plateau found.");
						        Thread.sleep(1500);
						        System.out.println();
						    }

							break;				  	
							   
					}
					
					System.out.println("Rover's position: X = " + rx + " Y = " + ry +  " orietation = "+ rd);
				}
				
				System.out.println();
				System.out.println("Final rover's position: ("+ rx +","+ ry +")");
				System.out.println("Final rover's orietation: " + rd);

				pw.printf("Final rover's position: (%d,%d)\n", rx, ry);
				pw.printf("Final rover's orietation: %c\n", rd);
	
			}
			// fecha arquivo
			System.out.println("-------------------------------------------------------------");
		    System.out.println("The End.");
		    System.out.println();
		    in.close();

		    fw.close();
			
		}
		catch(Exception e){
			System.out.println("Error: " + e);
		}
	}
			
}