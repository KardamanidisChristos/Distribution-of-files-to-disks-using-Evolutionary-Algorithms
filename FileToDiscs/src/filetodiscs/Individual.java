package filetodiscs;


import java.util.Random;


class Individual implements Comparable{
    int[] files_sizes={2,5,4,3,7,2,12,6,1,10,9,11,8};//different files


    int []disc_dis=new int [13];//cells for files,dna
    final double disc_capacity=30;//bytes of each disc
   

    //
    double fitness = 0;//fitness of case
    

    public Individual() {
        System.out.println("xxxxxxxxxx");
        Random rn = new Random();

        //Set genes randomly for each individual
        for (int i = 0; i < files_sizes.length; i++) {
           disc_dis[i]=rn.nextInt(4-0)+0;
            System.out.println(disc_dis[i]);
        
    

        }
System.out.println("xxxxxxxxxx");
        fitness = 0;
        rn=null;
    }

    //Calculate fitness and edit variable of class
    public void calcFitness() {
       double sum0=0; 
       double sum1=0;
       double sum2=0;
       double sum3=0;
       for (int i=0;i<disc_dis.length;i++){
       if(disc_dis[i]==0){
       sum0=sum0+files_sizes[i];
       
       }
       if(disc_dis[i]==1){
       sum1=sum1+files_sizes[i];
       
       
       }
       if(disc_dis[i]==2){
       sum2=sum2+files_sizes[i];
       }
       if(disc_dis[i]==3){
       sum3=sum3+files_sizes[i];
       }
       double disc1_p=sum1/disc_capacity;
       double disc2_p=sum2/disc_capacity;
       double disc3_p=sum3/disc_capacity;
       
       
       
           //System.out.println("Not distributed==>"+sum0);
           
           //System.out.println("Disc1 Percentage"+disc1_p);
           //System.out.println("Disc2 Percentage"+disc2_p);
           //System.out.println("Disc3 Percentage"+disc3_p);
           fitness=(sum1+sum2+sum3)/(3*disc_capacity);
           if(sum1>disc_capacity | sum2>disc_capacity | sum3>disc_capacity){
           fitness=-1;
           }else{
               //System.out.println("Used:"+(sum1+sum2+sum3)+"out of"+3*disc_capacity);
           }
       
       }
    }
    void printGenes(){
       System.out.println("DNA");
   for (int i=0;i<disc_dis.length;i++){
       
       System.out.print("---"+disc_dis[i]+"---");
   }
        System.out.println("");
   }

    
    public int compareTo(Object operand2) {
        int n1=0;
        int n2=-1;
       int n3=1;
       Individual obj=(Individual)operand2;
       if(this.fitness==obj.fitness){
       return n1;
       }
       if(this.fitness>obj.fitness){
        return n2;
       }
       else{
        return n3;
       }
       
   }

    @Override
    public String toString() {
        return "Me an object";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

   
    
}