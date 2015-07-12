import java.util.Random;


public class MyRandom {

	/**
	 * @param args
	 */
	
	private static int[][]  layout = new int[4][4];//整体布局
	
	private static int[][] layoutT = new int[4][4];//转置后的整体布局
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		for(int i = 0; i<2; i++){
//			Random random = new Random();
//			Integer r = random.nextInt(16);
//			System.out.println(r);
//		}
		layout[0][0]=2;
		layout[0][1]=3;
		layout[0][2]=4;
		layout[0][3]=5;
		for(int i=0;i<4;i++){
    		for(int j=0;j<4;j++){
    			if(i==0){
    				layoutT[j][3] = layout[i][j];
    			}else if(i==1){
    				layoutT[j][2] = layout[i][j];
    			}else if(i==2){
    				layoutT[j][1] = layout[i][j];
    			}else if(i==3){
    				layoutT[j][0] = layout[i][j];
    			}
    			layout[i][j]=0;
    		}
    	}
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				layout[i][j] = layoutT[i][j];
				layoutT[i][j] = 0;
			}
		}
		System.out.println(layoutT);
	}

}
